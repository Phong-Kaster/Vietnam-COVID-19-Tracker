package com.example.retrofit.Helper;

import java.text.DecimalFormat;

public class Helper {

    /**
     * @author Phong-Kaster
     * this function is used to reformat number
     * @return String formatted number
     * */
    public static String formatCardNumber(int input)
    {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(input);
    }
}
