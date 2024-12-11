package calculators;

import calculators.interfaces.CalcPadding;

public class CalcMp3Padding implements CalcPadding{

    @Override
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

}
