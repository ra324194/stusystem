package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book_info")
public class Book {
    @TableId
    private Integer bookId;
    private String courseId;
    private String imageUrl;
    private Float price;

}
