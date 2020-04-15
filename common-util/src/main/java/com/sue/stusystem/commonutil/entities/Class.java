package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @TableId
    private Integer classId;

    private String courseId;

    private String className;

    private String classTeacher;
    @TableField("class_classroom")
    private String classroom;

    private String classTerm;

    private Integer classCapacity;

    private LocalDateTime classTestTime;

    private  String classTestClassroom;


}
