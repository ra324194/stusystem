package com.sue.stusystem.commonutil.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_list")
public class List {
    @TableId
    private Integer orderId;
    private Integer bookId;
    private Float price;


}
