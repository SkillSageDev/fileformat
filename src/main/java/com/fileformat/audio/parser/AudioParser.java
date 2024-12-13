package com.fileformat.audio.parser;

public interface AudioParser extends Parser {
    public String getMpegVersionBits();

    public String getLayerBits();

    public String getProtectionBits();

    public String getBitrateBits();

    public String getSamplingRateBits();

    public String getPaddingBits();

    public String getChannelBits();

    public String getModeExtensionBits();

    public String getCopyrightBits();

    public String getOriginalBits();

    public String getEmphasisBits();

    public String getMpegVersion();

    public String getLayer();

    public String getProtection();

    public String getBitrate();

    public String getSamplingRate();

    public String getPadding();

    public String getChannel();

    public String getModeExtension();

    public String getCopyright();

    public String getOriginal();

    public String getEmphasis();

    // public String getFrameLengthInBytes();
}