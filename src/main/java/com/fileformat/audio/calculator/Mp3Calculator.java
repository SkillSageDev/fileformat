package com.fileformat.audio.calculator;

public class Mp3Calculator implements AudioCalculator {
    public String getMpegVersion(String mpegVersion) {
        switch (mpegVersion) {
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

    public String getLayer(String layerBits) {
        switch (layerBits) {
            case "00":
                return "reserved";
            case "01":
                return "Layer III";
            case "10":
                return "Layer II";
            case "11":
                return "Layer I";
            default:
                return "null";
        }
    }

    public String getProtection(String protectionBits) {
        switch (protectionBits) {
            case "0":
                return "Protected by CRC (16bit crc follows header)";
            case "1":
                return "Not protected";
            default:
                return "null";
        }
    }

    public String getBitrate(String bitrateBits, String mpegVersion, String layer) {
        switch (bitrateBits) {
            case "0000":
                return "free";
            case "0001":
                return ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III")) ? "8kbps" : "32kbps";
            case "0010":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "64";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "48";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "40";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "48";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "16";
            case "0011":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "96";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "56";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "48";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "56";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "24";
            case "0100":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "128";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "64";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "56";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "64";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "32";
            case "0101":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "160";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "80";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "64";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "80";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "40";
            case "0110":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "192";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "96";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "80";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "96";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "48";
            case "0111":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "224";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "112";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "96";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "112";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "56";
            case "1000":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "256";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "128";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "112";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "128";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "64";
            case "1001":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "288";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "160";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "128";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "144";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "80";
            case "1010":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "320";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "192";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "160";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "160";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "96";
            case "1011":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "352";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "224";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "192";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "176";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "112";
            case "1100":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "384";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "256";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "224";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "192";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "128";
            case "1101":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "416";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "320";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "256";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "224";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "144";
            case "1110":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "448";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "384";
                else if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "320";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "256";
                else if ((mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)" || mpegVersion == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "160";
            case "1111":
                return "bad";
            default:
                return "null";
        }
    }

    public String getSamplingRate(String samplingRateBits, String mpegVersion) {
        switch (samplingRateBits) {
            case "00":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "44100Hz";
                else if (mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "22050Hz";
                else
                    return "11025Hz";
            case "01":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "48000Hz";
                else if (mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "24000Hz";
                else
                    return "12000Hz";
            case "10":
                if (mpegVersion == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "32000Hz";
                else if (mpegVersion == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "16000Hz";
                else
                    return "8000Hz";
            case "11":
                return "reserv";
            default:
                return "null";

        }
    }

    public String getPadding(String paddingBits) {
        switch (paddingBits) {
            case "0":
                return "frame is not padded";
            case "1":
                return "frame is padded with one extra slot";
            default:
                return "null";
        }
    }

    public String getChannel(String channelBits) {
        switch (channelBits) {
            case "00":
                return "Stereo";
            case "01":
                return "Joint stereo (Stereo)";
            case "10":
                return "Dual channel (Stereo)";
            case "11":
                return "Single channel (Mono)";
            default:
                return "null";
        }
    }

    public String getModeExtension(String modeExtensionBits, String layer, String channel) {
        if (channel == "Joint stereo (Stereo)") {
            switch (modeExtensionBits) {
                case "00":
                    return (layer == "Layer III") ? "Intensity Stereo : off\nMS Stereo : off" : "bands 4 to 31";
                case "01":
                    return (layer == "Layer III") ? "Intensity Stereo : on\nMS Stereo : off" : "bands 8 to 31";
                case "10":
                    return (layer == "Layer III") ? "Intensity Stereo : off\nMS Stereo : on" : "bands 12 to 31";
                case "11":
                    return (layer == "Layer III") ? "Intensity Stereo : on\nMS Stereo : on" : "bands 16 to 31";
                default:
                    return "null";
            }
        } else {
            return "null";
        }
    }

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

    @Override
    public String getFrameLengthInBytes(String bitrate, String samplingRate, String padding, String layer) {
        if (!bitrate.equals("bad") && !samplingRate.equals("bad") && !padding.equals("bad")) {
            int frameLength;
            if (layer.equals("Layer I")) {
                frameLength = (12 * Integer.parseInt(bitrate) / Integer.parseInt(samplingRate) + Integer.parseInt(padding)) * 4;
            } else {
                frameLength = 144 * Integer.parseInt(bitrate) / Integer.parseInt(samplingRate) + Integer.parseInt(padding);
            }
            return Integer.toString(frameLength);
        } else {
            // Handle the case where the values are invalid
            System.out.println("Error: Couldn't calculate frame length, invalid bitrate, sampling rate, or padding.");
            return "error"; // Return a specific error message
        }
    }
}