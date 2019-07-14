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

    private static final long serialVersionUID = -4484791807558105458L;
    private Long id;
    private Long storyId;
    private Long categoryId;
    private Date insertTime;

}
