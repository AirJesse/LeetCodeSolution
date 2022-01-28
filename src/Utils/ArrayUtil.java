package Utils;

import java.util.Arrays;

public class ArrayUtil {
    public static String createArrayString(String s) {
        s = s.replaceAll("\\[", "{");
        return s.replaceAll("]", "}");
    }

    public static void main(String[] args) {
        System.out.println(createArrayString("[[1,1],[2,1],[2,2],[1,2]]"));
    }
}
