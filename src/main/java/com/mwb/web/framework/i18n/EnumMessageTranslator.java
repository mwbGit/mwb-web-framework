package com.mwb.web.framework.i18n;

public class EnumMessageTranslator {
    public static String getName(String code) {
        return MessageSourceManager.getMessage("enum." + code);
    }
}