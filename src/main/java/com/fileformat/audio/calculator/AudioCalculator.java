package com.fileformat.audio.calculator;

public interface AudioCalculator {
    public String getMpegVersion(String mpegVersionBits);

    public String getLayer(String layerBits);

    public String getProtection(String protectionBits);

    public String getBitrate(String bitrateBits, String mpegVersion, String layer);

    public String getSamplingRate(String samplingRateBits, String mpegVersion);

    public String getPadding(String paddingBits);

    public String getChannel(String channelBits);

    public String getModeExtension(String modeExtensionBits, String layer, String channel);

    public String getCopyright(String copyrightBits);

    public String getOriginal(String originalBits);

    public String getEmphasis(String emphasisBits);

    public String getFrameLengthInBytes(String bitrate, String samplingRate, String padding, String layer);

}
