package com.fileformat.audio.calculator;

public class CalcMp3Emphasis implements CalcEmphasis{

    @Override
    public String getEmphasis(String emphasisBits) {
        switch (emphasisBits) {
            case "00":
                return "none";
            case "01":
                return "50/15 ms";
            case "10":
                return "reserved";
            case "11":
                return "CCIT J.17";
            default:
                return "null";
        }
    }

}
