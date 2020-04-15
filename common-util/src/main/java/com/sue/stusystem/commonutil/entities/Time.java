package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("class_time")
public class Time {

    @TableId
    private  Integer classId;
    private  Integer startWeek;
    private  Integer endWeek;
    private  Integer startTime;
    private  Integer endTime;

}
