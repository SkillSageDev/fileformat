package calculators;

import calculators.interfaces.CalcLayer;

public class CalcMp3Layer implements CalcLayer {

    @Override
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

}
