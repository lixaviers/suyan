package com.suyan.mmc.constant;

/**
 * 优惠券类型枚举类
 */
public enum CouponTypeEnum {
	COUPON_CASH                      ((byte) 1, "无门槛现金抵用券"),
	COUPON_FULL_MINUS                ((byte) 2, "满减券"),
	COUPON_PER_FULL_MINUS            ((byte) 3, "每满减券"),
	COUPON_DISCOUNT                  ((byte) 4, "折扣券"),
	;

	private byte value;
	private String desc;

	CouponTypeEnum(byte value, String desc){
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
        for (CouponTypeEnum element : CouponTypeEnum.values()) {
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
        for (CouponTypeEnum element : CouponTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }

}
