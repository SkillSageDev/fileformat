package calculators;

import calculators.interfaces.CalcModeExtension;

public class CalcMp3ModeExtension implements CalcModeExtension {

    @Override
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
}
