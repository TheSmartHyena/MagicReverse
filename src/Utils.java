import jdk.jshell.execution.Util;

public class Utils {
    public static Item reverseItem(Item item) {
        return new Item(Utils.reverseString(item.after), Utils.reverseString(item.before), item.content);
    }

    public static String reverseString(String value) {
        return new StringBuilder().append(value).reverse().toString();
    }

    public static Boolean hasParenthese(String value) {
        return value.contains("(") && value.contains(")");
    }

    public static Item parseValue(String value) {
        int a = value.indexOf("(");
        int b = value.lastIndexOf(")");

        return new Item(value.substring(0, a), value.substring(b + 1), value.substring(a + 1, b));
    }

    public static String doReverse(String value) {
        return Utils.recursive(value, false);
    }

    public static String recursive(String value, boolean flag) {
        if (Utils.hasParenthese(value)) {
            Item item = parseValue(value);
            if (flag) {
                item = reverseItem(item);
            } else {
                // rien
            }

            return item.before + "(" +
                    Utils.recursive(item.content, !flag) + ")" +
                    item.after;
        } else {
            if (flag) {
                return reverseString(value);
            } else {
                return value;
            }
        }
    }
}
