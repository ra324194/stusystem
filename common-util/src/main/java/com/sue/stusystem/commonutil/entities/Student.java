package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("stu_info")
public class Student {
    @TableId
    private String stuId;
    private String stuSex;
    private String stuName;
    private String stuClass;



}
