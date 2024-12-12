package com.fileformat.audio.calculator;

public class CalcMp3CopyRight implements CalcCopyRight{

    @Override
    public String getCopyright(String copyrightBits) {
        switch (copyrightBits) {
            case "0":
                return "Audio is not copyrighted";
            case "1":
                return "Audio is copyrighted";
            default:
                return "null";
        }
    }

}
