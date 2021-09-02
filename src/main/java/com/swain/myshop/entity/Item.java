package com.swain.myshop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author swain
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Item对象", description="")
public class Item implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "图片地址")
    private String imgAddress;

    @ApiModelProperty(value = "商品详情")
    private String detail;

    @ApiModelProperty(value = "建议价格")
    private BigDecimal suggestPrice;

    @ApiModelProperty(value = "售价")
    private BigDecimal sellPrice;

    @ApiModelProperty(value = "成交价")
    private BigDecimal actualPrice;

    @ApiModelProperty(value = "所属类别")
    private Long categoryId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    @ApiModelProperty(value = "删除标志位")
    @TableLogic
    private Integer isDeleted;


}
