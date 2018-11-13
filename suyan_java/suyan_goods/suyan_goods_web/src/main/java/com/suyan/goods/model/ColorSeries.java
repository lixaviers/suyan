package com.suyan.goods.model;


import java.util.List;

public class ColorSeries {

    public static final String ID = "ID";
    public static final String COLOR_NAME = "名称";
    public static final String COLOR_DESC = "描述";
    public static final String COLOR_VALUE = "色值，rgb";
    public static final String PARENT_ID = "父级节点";
    public static final String SORT_NUMBER = "排序";


    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String colorName;

    /**
     * 描述
     */
    private String colorDesc;

    /**
     * 色值，rgb
     */
    private String colorValue;

    /**
     * 父级节点
     */
    private Integer parentId;

    /**
     * 排序
     */
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

    private List<ColorSeries> subColors;

    public List<ColorSeries> getSubColors() {
        return subColors;
    }

    public void setSubColors(List<ColorSeries> subColors) {
        this.subColors = subColors;
    }
}