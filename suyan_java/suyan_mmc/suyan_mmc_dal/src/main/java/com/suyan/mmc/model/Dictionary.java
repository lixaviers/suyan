package com.suyan.mmc.model;


public class Dictionary {

    public static final String ID = "自增id";
    public static final String DICT_ITEM = "字典类型";
    public static final String DICT_ID = "字典id";
    public static final String DICT_VALUE = "字典值";


    /**
     * 自增id
     */
    private Integer id;

    /**
     * 字典类型
     */
    private String dictItem;

    /**
     * 字典id
     */
    private Integer dictId;

    /**
     * 字典值
     */
    private String dictValue;
    

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getDictItem(){
        return dictItem;
    }
    
    public void setDictItem(String dictItem){
        this.dictItem = dictItem;
    }

    public Integer getDictId(){
        return dictId;
    }
    
    public void setDictId(Integer dictId){
        this.dictId = dictId;
    }

    public String getDictValue(){
        return dictValue;
    }
    
    public void setDictValue(String dictValue){
        this.dictValue = dictValue;
    }

    /**
    * The following custom property definition
    */

}