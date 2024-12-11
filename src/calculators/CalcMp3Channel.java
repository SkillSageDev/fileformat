package calculators;

import calculators.interfaces.CalcChannel;

public class CalcMp3Channel implements CalcChannel{

    @Override
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

}
