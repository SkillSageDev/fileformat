package com.fileformat.audio.calculator;

public class CalcMp3Original implements CalcOriginal{

    @Override
    public String getOriginal(String originalBits) {
        switch (originalBits) {
            case "0":
                return "Copy of original media";
            case "1":
                return "Original media";
            default:
                return "null";
        }
    }

}
