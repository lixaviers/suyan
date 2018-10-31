package com.suyan.user.constant;

/**
 * @Comments: 系统状态
 */
public enum RoleStatusEnum {
	ENABLE                      ((byte) 0, "启用"),
	DISABLE                     ((byte) 1, "禁用"),
	;

	private byte value;
	private String desc;

	RoleStatusEnum(byte value, String desc){
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
        for (RoleStatusEnum element : RoleStatusEnum.values()) {
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
		for (RoleStatusEnum element : RoleStatusEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}
