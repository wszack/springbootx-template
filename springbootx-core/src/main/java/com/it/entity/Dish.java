package com.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * <p>
 * 菜品
 * </p>
 *
 * @author zhangzhicai
 * @since 2025-04-17
 */
@Getter
@Setter
@ToString
@TableName("dish")
@ApiModel(value = "Dish对象", description = "菜品")
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜品名称
     */
    @TableField("name")
    @ApiModelProperty("菜品名称")
    private String name;

    /**
     * 菜品分类id
     */
    @TableField("category_id")
    @ApiModelProperty("菜品分类id")
    private Long categoryId;

    /**
     * 菜品价格
     */
    @TableField("price")
    @ApiModelProperty("菜品价格")
    private BigDecimal price;

    /**
     * 图片
     */
    @TableField("image")
    @ApiModelProperty("图片")
    private String image;

    /**
     * 描述信息
     */
    @ApiModelProperty("描述信息")
    @TableField("description")
    private String description;

    /**
     * 0 停售 1 起售
     */
    @TableField("status")
    @ApiModelProperty("0 停售 1 起售")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @TableField("create_user")
    private Long createUser;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Long updateUser;
}
