package com.keith.study.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keith on 9/4/15.
 */
public class FontBase {
    private List<String> list = new ArrayList<String>();
    private String fontName;
    public FontBase (String name) {
        this.fontName = fontName;
    }
    public FontBase addFont(String font) {
        this.list.add(font);
        return this;
    }
    public String getFont() {
        return this.fontName;
    }

    public static void main (String args[]) {

    }
}

class ChineseFont extends FontBase {

    public ChineseFont(String name) {
        super(name);
        addFont("ChineseFont");
    }
}

class English extends FontBase {

    public English(String name) {
        super(name);
        addFont("EnglishFont");
    }
}

class FontFactory {
    private Map<String, FontBase> fonts = new HashMap<String, FontBase>();
    public FontBase create (String name) {
        FontBase fontBase = fonts.get(name);
        if (fontBase == null) {
            try {
                fontBase = (FontBase) Class.forName(name).newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return fontBase;
    }
}
