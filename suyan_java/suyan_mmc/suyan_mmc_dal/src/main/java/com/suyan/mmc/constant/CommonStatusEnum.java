package com.suyan.mmc.constant;

/**
 * 通用状态
 */
public enum CommonStatusEnum {
	SAVED                            ((byte) 1, "已保存"),
	ONLINE                           ((byte) 2, "已上线"),
	ONGOING                          ((byte) 3, "进行中"),
	STOPED                           ((byte) 4, "已中止"),
	CANCELED                         ((byte) 5, "已取消"),
	ENDED                            ((byte) 6, "已结束"),
	CLOSED                           ((byte) 7, "已关闭"),
	;
	
	private byte value;
	private String desc;
	
	CommonStatusEnum(byte value, String desc){
		this.value = value;
		this.desc = desc;
	}

    public byte getValue() {
        return value;
    }
    
    public String getDesc() {
		return desc;
	}

	public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (CommonStatusEnum element : CommonStatusEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val == null ? false : val.byteValue() == this.value;
    }
    
	public static String getDescByValue(Byte value) {
		if (value == null) {
			return "";
		}
		for (CommonStatusEnum element : CommonStatusEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}
