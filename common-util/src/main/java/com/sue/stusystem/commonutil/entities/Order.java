package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("stu_info")
public class Order {
    @TableId
    private Integer orderId;
    private String stuId;
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;
    private Float price;
    private String status;
}
