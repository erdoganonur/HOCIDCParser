package com.carrefour.util;

import java.text.DecimalFormat;

public class FormatDouble {

    public static String formatFromDouble(double d) {
        String r_Value;
        DecimalFormat df = new DecimalFormat("#.##");
        r_Value = df.format(d).replace(',', '.');

        return r_Value;
    }

    public static double formatFromString(String price) {
        String result = "";

        for (int i = 0; i < price.length(); i++) {
            if (i == (price.length() - 2)) {
                result += '.';
                result += price.charAt(i);
            } else {
                result += price.charAt(i);
            }
        }

        return Double.parseDouble(result);
    }

}
