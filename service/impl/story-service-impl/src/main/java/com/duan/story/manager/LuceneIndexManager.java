package com.duan.story.manager;

import com.duan.story.config.preference.FileProperties;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public abstract class LuceneIndexManager<T, ID, RESULT> {

    @Autowired
    private FileProperties fileProperties;

    /**
     * 获取IndexWriter实例
     */
    private IndexWriter getWriter() throws IOException {
        String path = fileProperties.getLuceneIndexDir();
        Directory dir = FSDirectory.open(Paths.get(path));

        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

        return new IndexWriter(dir, iwc);
    }

    public void addIndex(T obj) throws IOException {
        IndexWriter writer = getWriter();

        //相当于数据库中的一条记录
        Document doc = new Document();
        if (loadIndexFields(doc, obj)) {
            contentProcessBeforeSearch(obj);

            //添加索引记录
            writer.addDocument(doc);
            writer.close();
        }
    }

    protected abstract void contentProcessBeforeSearch(T obj);

    protected abstract Term getIdFieldTerm(ID id);

    protected abstract boolean loadIndexFields(Document doc, T obj);

    protected abstract RESULT getResult(IndexSearcher is, TopDocs topDocs, String word, int count) throws IOException;

    protected abstract Query buildQuery(String str) throws ParseException;

    public void updateIndex(T obj, ID id) throws IOException {
        IndexWriter writer = getWriter();
        Document doc = new Document();

        if (loadIndexFields(doc, obj)) {
            contentProcessBeforeSearch(obj);
            writer.updateDocument(getIdFieldTerm(id), doc);
        }

        writer.close();
    }

    public boolean deleteIndex(ID id) throws IOException {

        try (IndexWriter writer = getWriter()) {

            writer.deleteDocuments(getIdFieldTerm(id));
            writer.forceMergeDeletes(); // 强制删除
            writer.commit();
        }

        return true;
    }

    public RESULT search(String str, int count) throws IOException, ParseException {
        if (StringUtils.isEmpty(str) || count <= 0) {
            return null;
        }

        String path = fileProperties.getLuceneIndexDir();
        Directory dir = FSDirectory.open(Paths.get(path));
        IndexReader reader = DirectoryReader.open(dir);

        Query query = buildQuery(str);
        IndexSearcher is = new IndexSearcher(reader);
        TopDocs top = is.search(query, count);
        RESULT result = getResult(is, top, str, count);

        dir.close();
        reader.close();
        return result;
    }

}
