package com.fileformat.audio.calculator;

public class CalcMp3Factory {
    public static CalcBundle createCalcMp3Bundle(){
        return new CalcBundle(
        new CalcMp3MPEGVersion(), 
        new CalcMp3Layer(), 
        new CalcMp3Protection(), 
        new CalcMp3Bitrate(), 
        new CalcMp3SamplingRate(), 
        new CalcMp3Padding(), 
        new CalcMp3Channel(), 
        new CalcMp3ModeExtension(), 
        new CalcMp3CopyRight(), 
        new CalcMp3Original(), 
        new CalcMp3Emphasis());
    }
}
