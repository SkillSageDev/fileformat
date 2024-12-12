package com.fileformat.audio.calculator;

public class CalcBundle {
    private CalcMPEGVersion calcMPEGVersion;
    private CalcLayer calcLayer;
    private CalcProtection calcProtection;
    private CalcBitrate calcBitrate;
    private CalcSamplingRate calcSamplingRate;
    private CalcPadding calcPadding;
    private CalcChannel calcChannel;
    private CalcModeExtension calcModeExtension;
    private CalcCopyRight calcCopyRight;
    private CalcOriginal calcOriginal;
    private CalcEmphasis calcEmphasis;

    public CalcBundle(
            CalcMPEGVersion calcMPEGVersion, 
            CalcLayer calcLayer, 
            CalcProtection calcProtection,
            CalcBitrate calcBitrate, 
            CalcSamplingRate calcSamplingRate, 
            CalcPadding calcPadding,
            CalcChannel calcChannel, 
            CalcModeExtension calcModeExtension, 
            CalcCopyRight calcCopyRight,
            CalcOriginal calcOriginal, 
            CalcEmphasis calcEmphasis) {
                this.calcMPEGVersion = calcMPEGVersion;
                this.calcLayer = calcLayer;
                this.calcProtection = calcProtection;
                this.calcBitrate = calcBitrate;
                this.calcSamplingRate = calcSamplingRate;
                this.calcPadding = calcPadding;
                this.calcChannel = calcChannel;
                this.calcModeExtension = calcModeExtension;
                this.calcCopyRight = calcCopyRight;
                this.calcOriginal = calcOriginal;
                this.calcEmphasis = calcEmphasis;
    }

    public CalcMPEGVersion getCalcMPEGVersion() {
        return calcMPEGVersion;
    }

    public CalcLayer getCalcLayer() {
        return calcLayer;
    }

    public CalcProtection getCalcProtection() {
        return calcProtection;
    }

    public CalcBitrate getCalcBitrate() {
        return calcBitrate;
    }

    public CalcSamplingRate getCalcSamplingRate() {
        return calcSamplingRate;
    }

    public CalcPadding getCalcPadding() {
        return calcPadding;
    }

    public CalcChannel getCalcChannel() {
        return calcChannel;
    }

    public CalcModeExtension getCalcModeExtension() {
        return calcModeExtension;
    }

    public CalcCopyRight getCalcCopyRight() {
        return calcCopyRight;
    }

    public CalcOriginal getCalcOriginal() {
        return calcOriginal;
    }

    public CalcEmphasis getCalcEmphasis() {
        return calcEmphasis;
    }

}
