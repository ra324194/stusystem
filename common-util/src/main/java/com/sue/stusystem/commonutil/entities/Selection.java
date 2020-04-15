package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("select_class")
public class Selection {
    @TableId
    private String stuId;
    private Integer classId;
    private String courseId;
    private Float classGrade;

}
