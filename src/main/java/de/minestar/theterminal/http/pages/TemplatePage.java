package de.minestar.theterminal.http.pages;

public class TemplatePage {

    // CLEAR TEXT
    public static void clearText(StringObject original) {
        original.str = "";
    }

    // APPEND <BR />
    public static void appendBR(StringObject original, boolean breakLine) {
        original.str = original.str + "<br />";
        breakTXTLine(original, breakLine);
    }

    // APPEND <BR />
    public static void appendBR(StringObject original, int count, boolean breakLine) {
        while (count > 0) {
            original.str = original.str + "<br />";
            count--;
        }
        breakTXTLine(original, breakLine);
    }

    // BREAK LINE
    public static void breakTXTLine(StringObject original, boolean breakLine) {
        if (breakLine)
            original.str = original.str + "\r\n";
    }

    // APPEND TEXT TO STRING
    public static void append(StringObject original, String appendix, boolean breakLine) {
        original.str = original.str + appendix;
        breakTXTLine(original, breakLine);
    }

    // GET LINK
    public static String getLink(String linkText, String httpLink) {
        return "<a href=\"" + httpLink + "\">" + linkText + "</a>";
    }

    // GET CONFIRM LINK
    public static String getLink(String linkText, String httpLink, String confirmString) {
        return "<a onClick=\"return confirm('" + confirmString + "')\" href=\"" + httpLink + "\">" + linkText + "</a>";
    }

    // GET INPUTFIELD TEXT
    public static String getInputText(String inputName, String value, int size) {
        return "<input type=\"text\" name=\"" + inputName + "\" value=\"" + value + "\" size=\"" + size + "\">";
    }

    // GET INPUTFIELD PW
    public static String getInputPassword(String inputName, String value, int size) {
        return "<input type=\"password\" name=\"" + inputName + "\" value=\"" + value + "\" size=\"" + size + "\">";
    }

    // GET INPUTFIELD HIDDEN
    public static String getInputHidden(String inputName, String value, int size) {
        return "<input type=\"hidden\" name=\"" + inputName + "\" value=\"" + value + "\" size=\"" + size + "\">";
    }

    // GET BUTTON
    public static String getButton(String inputName, String value) {
        return "<input type=\"submit\" name=\"" + inputName + "\" value=\"" + value + "\">";
    }

    // GET FORM
    public static String getFormTag(String formName, String method, String action) {
        return "<form name=\"" + formName + "\" method=\"" + method + "\" action=\"" + action + "\">";
    }

    // GET IMAGETAG
    public static String getImageTag(String pictureName) {
        return "<img src=\"images/" + pictureName + "\" />";
    }

    // GET SELECT
    public static String getSelectTag(String selectName) {
        return "<select name=\"" + selectName + "\">";
    }

    // GET OPTION
    public static String getOptionTag(String description, String value, boolean selected) {
        if (!selected)
            return "<option value=\"" + value + "\">" + description + "</option>";
        else
            return "<option value=\"" + value + "\" SELECTED>" + description + "</option>";
    }

    // GET HTMLTAG
    public static String getOpenTag(String tag) {
        return "<" + tag + ">";
    }

    // GET HTMLTAG
    public static String getCloseTag(String tag) {
        return "</" + tag + ">";
    }

    // GET LIST-TAG
    public static String getListTag(String value) {
        return "<li>" + value + "</li>";
    }
}
