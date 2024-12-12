package com.fileformat.audio.calculator;

public class CalcMp3MPEGVersion implements CalcMPEGVersion{

    @Override
    public String getMPEGVersion(String mpegVersionBits) {
        switch (mpegVersionBits) {
            case "00":
                return "MPEG Version 2.5";
            case "01":
                return "reserved";
            case "10":
                return "MPEG Version 2 (ISO/IEC 13818-3)";
            case "11":
                return "MPEG Version 1 (ISO/IEC 11172-3)";
            default:
                return "null";
        }
    }

}
