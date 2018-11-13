package com.suyan.goods.resp;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("颜色信息")
public class ColorSeriesODTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String colorName;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String colorDesc;

    /**
     * 色值，rgb
     */
    @ApiModelProperty("色值，rgb")
    private String colorValue;

    /**
     * 父级节点
     */
    @ApiModelProperty("父级节点")
    private Integer parentId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sortNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }

    public String getColorValue() {
        return colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * The following custom property definition
     */

    private List<ColorSeriesODTO> subColors;

    public List<ColorSeriesODTO> getSubColors() {
        return subColors;
    }

    public void setSubColors(List<ColorSeriesODTO> subColors) {
        this.subColors = subColors;
    }
}