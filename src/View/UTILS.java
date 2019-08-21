package View;

import java.awt.*;

public class UTILS {
    public static Color foregroundFontColor = new Color(176, 224, 230);
    public static Color backgroundColorSecondWindows = new Color(23, 63, 95);
    public static Color selectedItemColor = new Color(110, 197, 233);
    public static Color backgroundColorPrimary = new Color(32, 99, 155);
    public static String toHtmlH3(String text) {
        return "<html><h3>" + text + "</h3></html>";
    }
    public static String toHtmlH2(String text) {
        return "<html><h2>" + text + "</h2></html>";
    }
    public static String toHtmlParagraph(String text) {return "<html><p>" + text + "</p></html>";}
}
