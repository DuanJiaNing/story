package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2018/9/24.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryCategoryRela implements Serializable {

    private static final Long serialVersionUID = -4484791807558105458L;
    private Integer id;
    private Integer storyId;
    private Integer categoryId;
    private Date insertTime;

}
