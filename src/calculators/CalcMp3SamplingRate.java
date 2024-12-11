package calculators;

import calculators.interfaces.CalcSamplingRate;

public class CalcMp3SamplingRate implements CalcSamplingRate{

    @Override
    public String getSamplingRate(String samplingRateBits, String MPEG_Version) {
        switch (samplingRateBits) {
            case "00":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "44100Hz";
                else if (MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "22050";
                else
                    return "11025";
            case "01":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "48000Hz";
                else if (MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "24000Hz";
                else
                    return "12000Hz";
            case "10":
                if (MPEG_Version == "MPEG Version 1 (ISO/IEC 11172-3)")
                    return "32000Hz";
                else if (MPEG_Version == "MPEG Version 2 (ISO/IEC 13818-3)")
                    return "16000Hz";
                else
                    return "8000Hz";
            case "11":
                return "reserv";
            default:
                return "null";

        }
    }

}
