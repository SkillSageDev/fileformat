import java.io.IOException;

import calculators.CalcBundle;
import calculators.CalcMp3Factory;
import merger.ByteMerger;
import merger.interfaces.Merger;

public class Mp3Parser implements Parser {
    Extractor extractor;
    CalcBundle calcBundle;

    public Mp3Parser(Extractor extractor, CalcBundle calcBundle) {
        this.extractor = extractor;
        this.calcBundle = calcBundle;
    }

    // b2
    private String MPEG_VersionBits;
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
    private String MPEG_Version;
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

    private String framLengthInBytes;

    @Override
    public void parseBits(byte[] bytes) throws IOException {
        // start = 31 - second position
        // end = 31 - first position + 1
        // Example AAAAAAAA AAABBCCD EEEEFFGH IIJJKLMM
        // B position = (20, 19) !counting position starts from 0, from right to left
        // start = (31 - 20) = 11
        // end = 31 - 19 + 1 = 13

        MPEG_VersionBits = extractor.getBitsFromByte(bytes, (31 - 20), (31 - 19 + 1));
        MPEG_Version = calcBundle.getCalcMPEGVersion().getMPEG_Version(MPEG_VersionBits);

        layerBits = extractor.getBitsFromByte(bytes, (31 - 18), (31 - 17 + 1));
        layer = calcBundle.getCalcLayer().getLayer(layerBits);

        protectionBits = extractor.getBitsFromByte(bytes, (31 - 16), (31 - 16 + 1));
        protection = calcBundle.getCalcProtection().getProtection(protectionBits);

        // b2
        bitrateBits = extractor.getBitsFromByte(bytes, (31 - 15), (31 - 12 + 1));
        bitrate = calcBundle.getCalcBitrate().getBitrate(bitrateBits, MPEG_Version, layer);

        samplingRateBits = extractor.getBitsFromByte(bytes, (31 - 11), (31 - 10));
        samplingRate = calcBundle.getCalcSamplingRate().getSamplingRate(samplingRateBits, MPEG_Version);

        paddingBits = extractor.getBitsFromByte(bytes, (31 - 9), (31 - 9 + 1));
        padding = calcBundle.getCalcPadding().getPadding(paddingBits);

        // b3
        channelBits = extractor.getBitsFromByte(bytes, (31 - 7), (31 - 6 + 1));
        channel = calcBundle.getCalcChannel().getChannel(channelBits);

        modeExtensionBits = (channel == "Joint stereo (Stereo)")
                ? extractor.getBitsFromByte(bytes, (31 - 5), (31 - 4 + 1))
                : "null";
        modeExtension = calcBundle.getCalcModeExtension().getModeExtension(modeExtensionBits, layer, channel);

        copyrightBits = extractor.getBitsFromByte(bytes, (31 - 3), (31 - 3 + 1));
        copyright = calcBundle.getCalcCopyRight().getCopyright(copyrightBits);

        originalBits = extractor.getBitsFromByte(bytes, (31 - 2), (31 - 2 + 1));
        original = calcBundle.getCalcOriginal().getOriginal(originalBits);

        emphasisBits = extractor.getBitsFromByte(bytes, (31 - 1), (31 - 0 + 1));
        emphasis = calcBundle.getCalcEmphasis().getEmphasis(emphasisBits);

        // Check if bitrate, samplingRate, and padding are valid before parsing
        if (!bitrate.equals("bad") && !samplingRate.equals("bad") && !padding.equals("bad")) {
            framLengthInBytes = (layer.equals("Layer I"))
                    ? Integer.toString((12 * Integer.parseInt(bitrate) / Integer.parseInt(samplingRate)
                            + Integer.parseInt(padding)) * 4)
                    : Integer.toString(144 * Integer.parseInt(bitrate) / Integer.parseInt(samplingRate)
                            + Integer.parseInt(padding));
        } else {
            // Handle the case where the values are invalid
            System.out.println("Error: Invalid bitrate, sampling rate, or padding.");
            framLengthInBytes = "unknown"; // Or another default value
        }

        // framLengthInBytes = (layer == "Layer I") ? Integer.toString((12 *
        // Integer.parseInt(bitrate) / Integer.parseInt(samplingRate) +
        // Integer.parseInt(padding)) * 4) : Integer.toString(144 *
        // Integer.parseInt(bitrate) / Integer.parseInt(samplingRate) +
        // Integer.parseInt(padding));
    }

    public String getMPEG_VersionBits() {
        return MPEG_VersionBits;
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

    public String getMPEG_Version() {
        return MPEG_Version;
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

    public String getFramLengthInBytes() {
        return framLengthInBytes;
    }

    public static void main(String[] args) throws IOException {
        Merger merger = new ByteMerger();
        Extractor extractor = new Extractor(merger);
        Mp3Parser parser = new Mp3Parser(extractor, CalcMp3Factory.createCalcMp3Bundle());
        byte[] bytes = { (byte) 0x0f, (byte) 0xff, (byte) 0xff, (byte) 0xff, };
        parser.parseBits(bytes);
        System.out.println(parser.getMPEG_Version());
    }
}
