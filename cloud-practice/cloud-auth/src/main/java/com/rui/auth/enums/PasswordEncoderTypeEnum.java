package com.rui.auth.enums;

public enum PasswordEncoderTypeEnum {
    BCRYPT("{bcrypt}","BCRYPT加密"),

    NOOP("{noop}","无密文加密");
    private final String prefix;

    private final String desc;

    public String getPrefix() {
        return prefix;
    }

    public String getDesc() {
        return desc;
    }

    PasswordEncoderTypeEnum(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }
}
