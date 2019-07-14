package com.duan.story.manager;

import com.duan.story.entity.Story;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Component
public class StoryLuceneIndexManager extends LuceneIndexManager<Story, Long, List<Long>> {

    private static final String INDEX_STORY_ID = "story_id";
    private static final String INDEX_STORY_TITLE = "story_title";
    private static final String INDEX_STORY_SUMMARY = "story_summary";
    private static final String INDEX_STORY_CONTENT = "story_content";

    @Override
    protected void contentProcessBeforeSearch(Story obj) {
        // TODO
    }

    @Override
    protected Term getIdFieldTerm(Long id) {
        return new Term(INDEX_STORY_ID, id + "");
    }

    @Override
    protected boolean loadIndexFields(Document doc, Story story) {

        boolean res = false;

        doc.add(new StringField(INDEX_STORY_ID, story.getId() + "", Field.Store.YES));

        String title = story.getTitle();
        if (!StringUtils.isEmpty(title)) {
            doc.add(new TextField(INDEX_STORY_TITLE, title, Field.Store.YES));
            res = true;
        }

        String summary = story.getSummary();
        if (!StringUtils.isEmpty(summary)) {
            doc.add(new TextField(INDEX_STORY_SUMMARY, summary, Field.Store.YES));
            res = true;
        }

        String content = story.getContent();
        if (!StringUtils.isEmpty(content)) {
            doc.add(new TextField(INDEX_STORY_CONTENT, content, Field.Store.YES));
            res = true;
        }

        return res;
    }

    @Override
    protected List<Long> getResult(IndexSearcher is, TopDocs topDocs, String word, int count) throws IOException {
        List<Long> result = new ArrayList<>(count);
        for (ScoreDoc doc : topDocs.scoreDocs) {
            Document document = is.doc(doc.doc);
            result.add(Long.valueOf(document.get(INDEX_STORY_ID)));
        }

        return result;
    }

    @Override
    protected Query buildQuery(String str) throws ParseException {
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

        // 或 查询
        booleanQuery.add((new QueryParser(INDEX_STORY_TITLE, analyzer)).parse(str), BooleanClause.Occur.SHOULD);
        booleanQuery.add((new QueryParser(INDEX_STORY_SUMMARY, analyzer)).parse(str), BooleanClause.Occur.SHOULD);
        booleanQuery.add((new QueryParser(INDEX_STORY_CONTENT, analyzer)).parse(str), BooleanClause.Occur.SHOULD);
        BooleanQuery query = booleanQuery.build();

        analyzer.close();
        return query;
    }
}
