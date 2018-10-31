package com.suyan.mmc.constant;

/**
 * 订单促销类型枚举类
 */
public enum SubPromotionTypeEnum {

    SUBPROMOTION_FULL_MINUS         ((byte) 51, "订单满减"),     // 订单满减
    SUBPROMOTION_PER_FULL_MINUS     ((byte) 52, "订单叠加满减"), // 订单叠加满减
    SUBPROMOTION_DISCOUNT           ((byte) 53, "订单折扣"),     // 订单折扣
//    SUBPROMOTION_GIFT               ((byte) 55, "订单满赠"),     // 订单满赠

	;

	private byte value;
	private String desc;

	SubPromotionTypeEnum(byte value, String desc){
		this.value = value;
		this.desc = desc;
	}

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

    public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (SubPromotionTypeEnum element : SubPromotionTypeEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val == null ? false : val.byteValue() == this.value;
    }

    public static String getNameByValue(Byte value) {
        if (value == null) {
            return "";
        }
        for (SubPromotionTypeEnum element : SubPromotionTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }

}
