package com.fileformat.audio.parser;

import java.io.IOException;

import com.fileformat.audio.calculator.AudioCalculator;
import com.fileformat.audio.calculator.Mp3Calculator;
import com.fileformat.utility.ByteMerger;
import com.fileformat.utility.Extractor;
import com.fileformat.utility.Merger;

public class Mp3Parser implements AudioParser {
    Extractor extractor;
    AudioCalculator calculator;

    public Mp3Parser(Extractor extractor, AudioCalculator calculator) {
        this.extractor = extractor;
        this.calculator = calculator;
    }

    // b2
    private String mpegVersionBits;
    private String layerBits;
    private String protectionBits;

    // b3
    private String bitrateBits;
    private String samplingRateBits;
    private String paddingBits;

    // b4
    private String channelBits;
    private String modeExtensionBits;
    private String copyrightBits;
    private String originalBits;
    private String emphasisBits;

    // second byte
    private String mpegVersion;
    private String layer;
    private String protection;

    // third byte
    private String bitrate;
    private String samplingRate;
    private String padding;

    // forth byte
    private String channel;
    private String modeExtension;
    private String copyright;
    private String original;
    private String emphasis;

    private String frameLengthInBytes;

    @Override
    public void parseBits(byte[] bytes) throws IOException {
        // start = 31 - second position
        // end = 31 - first position + 1
        // Example AAAAAAAA AAABBCCD EEEEFFGH IIJJKLMM
        // B position = (20, 19) !counting position starts from 0, from right to left
        // start = (31 - 20) = 11
        // end = 31 - 19 + 1 = 13

        mpegVersionBits = extractor.getBitsFromByte(bytes, (31 - 20), (31 - 19 + 1));
        mpegVersion = calculator.getMpegVersion(mpegVersionBits);

        layerBits = extractor.getBitsFromByte(bytes, (31 - 18), (31 - 17 + 1));
        layer = calculator.getLayer(layerBits);

        protectionBits = extractor.getBitsFromByte(bytes, (31 - 16), (31 - 16 + 1));
        protection = calculator.getProtection(protectionBits);

        // b2
        bitrateBits = extractor.getBitsFromByte(bytes, (31 - 15), (31 - 12 + 1));
        bitrate = calculator.getBitrate(bitrateBits, mpegVersion, layer);

        samplingRateBits = extractor.getBitsFromByte(bytes, (31 - 11), (31 - 10 + 1));
        samplingRate = calculator.getSamplingRate(samplingRateBits, mpegVersion);

        paddingBits = extractor.getBitsFromByte(bytes, (31 - 9), (31 - 9 + 1));
        padding = calculator.getPadding(paddingBits);

        // b3
        channelBits = extractor.getBitsFromByte(bytes, (31 - 7), (31 - 6 + 1));
        channel = calculator.getChannel(channelBits);

        modeExtensionBits = (channel.equals("Joint stereo (Stereo)"))
                ? extractor.getBitsFromByte(bytes, (31 - 5), (31 - 4 + 1))
                : "null";
        modeExtension = calculator.getModeExtension(modeExtensionBits, layer, channel);

        copyrightBits = extractor.getBitsFromByte(bytes, (31 - 3), (31 - 3 + 1));
        copyright = calculator.getCopyright(copyrightBits);

        originalBits = extractor.getBitsFromByte(bytes, (31 - 2), (31 - 2 + 1));
        original = calculator.getOriginal(originalBits);

        emphasisBits = extractor.getBitsFromByte(bytes, (31 - 1), (31 - 0 + 1));
        emphasis = calculator.getEmphasis(emphasisBits);

        // frameLengthInBytes = calculator.getFrameLengthInBytes(bitrate, samplingRate, padding, layer);
        // if (frameLengthInBytes.equals("error")) {
        //     // Handle the error case
        //     System.out.println("Failed to calculate frame length.");
        // } else {
        //     // Proceed with using frameLengthInBytes
        //     System.out.println("Frame length in bytes: " + frameLengthInBytes);
        // }

    }

    public String getMpegVersionBits() {
        return mpegVersionBits;
    }

    public String getLayerBits() {
        return layerBits;
    }

    public String getProtectionBits() {
        return protectionBits;
    }

    public String getBitrateBits() {
        return bitrateBits;
    }

    public String getSamplingRateBits() {
        return samplingRateBits;
    }

    public String getPaddingBits() {
        return paddingBits;
    }

    public String getChannelBits() {
        return channelBits;
    }

    public String getModeExtensionBits() {
        return modeExtensionBits;
    }

    public String getCopyrightBits() {
        return copyrightBits;
    }

    public String getOriginalBits() {
        return originalBits;
    }

    public String getEmphasisBits() {
        return emphasisBits;
    }

    public String getMpegVersion() {
        return mpegVersion;
    }

    public String getLayer() {
        return layer;
    }

    public String getProtection() {
        return protection;
    }

    public String getBitrate() {
        return bitrate;
    }

    public String getSamplingRate() {
        return samplingRate;
    }

    public String getPadding() {
        return padding;
    }

    public String getChannel() {
        return channel;
    }

    public String getModeExtension() {
        return modeExtension;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getOriginal() {
        return original;
    }

    public String getEmphasis() {
        return emphasis;
    }

    public String getFrameLengthInBytes() {
        return frameLengthInBytes;
    }

    public static void main(String[] args) throws IOException {
        Merger merger = new ByteMerger();
        Extractor extractor = new Extractor(merger);
        AudioCalculator calculator = new Mp3Calculator();
        AudioParser parser = new Mp3Parser(extractor, calculator);
        byte[] bytes = { (byte) 0x0f, (byte) 0xff, (byte) 0xff, (byte) 0xff, };
        parser.parseBits(bytes);
        System.out.println(parser.getMpegVersion());
    }
}
