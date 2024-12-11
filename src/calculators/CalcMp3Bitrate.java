package calculators;

import calculators.interfaces.CalcBitrate;

public class CalcMp3Bitrate implements CalcBitrate {

    @Override
    public String getBitrate(String bitrateBits, String MPEG_Version, String layer) {
        switch (bitrateBits) {
            case "0000":
                return "free";
            case "0001":
                return ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III")) ? "8kbps" : "32kbps";
            case "0010":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "64";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "48";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "40";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "48";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "16";
            case "0011":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "96";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "56";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "48";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "56";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "24";
            case "0100":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "128";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "64";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "56";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "64";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "32";
            case "0101":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "160";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "80";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "64";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "80";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "40";
            case "0110":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "192";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "96";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "80";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "96";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "48";
            case "0111":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "224";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "112";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "96";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "112";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "56";
            case "1000":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "256";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "128";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "112";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "128";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "64";
            case "1001":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "288";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "160";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "128";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "144";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "80";
            case "1010":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "320";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "192";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "160";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "160";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "96";
            case "1011":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "352";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "224";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "192";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "176";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "112";
            case "1100":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "384";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "256";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "224";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "192";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "128";
            case "1101":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "416";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "320";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "256";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "224";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "144";
            case "1110":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer I")
                    return "448";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer II")
                    return "384";
                else if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)" && layer == "Layer III")
                    return "320";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && layer == "Layer I")
                    return "256";
                else if ((MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)" || MPEG_Version == "MPEG Version 2.5")
                        && (layer == "Layer II" || layer == "Layer III"))
                    return "160";
            case "1111":
                return "bad";
            default:
                return "null";
        }
    }

}
