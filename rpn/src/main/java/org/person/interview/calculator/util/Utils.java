package org.person.interview.calculator.util;

public abstract class Utils {
    private Utils(){}

    public static String formatToPrecision(String value, int precision) {
        if (value.contains(".")) {
            String[] parts = value.split("\\.");
            StringBuilder sb = new StringBuilder(parts[1]);
            if (sb.length() > precision) {
                sb.setLength(precision);
            }
            int validLength = sb.length();
            for (int i = sb.length() - 1; i > -1; --i) {
                if (sb.charAt(i) == '0') {
                    validLength = i;
                } else {
                    break;
                }
            }

            if (validLength == 0) {
                return parts[0];
            }

            sb.setLength(validLength);
            return String.format("%s.%s", parts[0], sb.toString());
        }

        return  value;
    }
}
