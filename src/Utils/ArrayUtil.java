package Utils;

import java.util.Arrays;

public class ArrayUtil {
    public static String createArrayString(String s) {
        s = s.replaceAll("\\[", "{");
        return s.replaceAll("]", "}");
    }
    public static int[] stringToIntArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Character.forDigit(10,9));
    }
}
