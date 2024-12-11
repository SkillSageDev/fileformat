package calculators;

import calculators.interfaces.CalcProtection;

public class CalcMp3Protection implements CalcProtection{

    @Override
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

}
