package sample;

public class EditText {
    public static String text(String in){
        String toReturn = in;


        toReturn = toReturn.replaceAll("\\\\f1", "");
        toReturn = toReturn.replaceAll("\\\\fcharset0 Arial", "");
        toReturn = toReturn.replaceAll("\\\\fs16", "");
        toReturn = toReturn.replaceAll("\\\\b0", "");
        toReturn = toReturn.replaceAll("\\\\blue0", "");
        toReturn = toReturn.replaceAll("\\\\b", "");
        toReturn = toReturn.replaceAll("\\\\pard", "");
        toReturn = toReturn.replaceAll("\\\\cf2", "");
        toReturn = toReturn.replaceAll("\\\\par ", "");
        toReturn = toReturn.replaceAll("\\\\fcharset0 Courier New", "");
        toReturn = toReturn.replaceAll("\\\\fnil", "");
        toReturn = toReturn.replaceAll("\\\\f0", "");
        toReturn = toReturn.replaceAll("\\\\fonttbl", "");
        toReturn = toReturn.replaceAll("\\\\deff0", "");
        toReturn = toReturn.replaceAll("\\\\ansicpg1252", "");
        toReturn = toReturn.replaceAll("\\\\ansi", "");
        toReturn = toReturn.replaceAll("\\\\rtf1", "");
        toReturn = toReturn.replaceAll("\\\\colortbl", "");
        toReturn = toReturn.replaceAll("\\\\red0", "");
        toReturn = toReturn.replaceAll("\\\\green0", "");
        toReturn = toReturn.replaceAll("\\{", "");
        toReturn = toReturn.replaceAll("}", "");
        toReturn = toReturn.replaceAll("\\\\red255", "");
        toReturn = toReturn.replaceAll(";", "");
        toReturn = toReturn.replaceAll("\\\\viewkind4", "");
        toReturn = toReturn.replaceAll("\\\\uc1", "");
        toReturn = toReturn.replaceAll("\\\\cf1", "");
        toReturn = toReturn.replaceAll("\\\\lang1033", "");
        toReturn = toReturn.replaceAll("\\\\fs20 ", "");
        toReturn = toReturn.replaceFirst("&#10;", "");
        toReturn = toReturn.replaceFirst("&#10;", "");
        toReturn = toReturn.replaceFirst("&#10;", "");
        toReturn = toReturn.replaceFirst("\n", "");
        toReturn = toReturn.replaceFirst("\n", "");
        toReturn = toReturn.replaceFirst("\n", "");
        toReturn = toReturn.replaceFirst("\n", "");

        toReturn = toReturn.replaceFirst("\r", "");


//        char[] temp = toReturn.toCharArray();
//        System.out.println(temp.toString());
//        toReturn = toReturn.replaceAll("\\\\")

        return toReturn;
    }
}
