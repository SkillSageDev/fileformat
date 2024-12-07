public class WavChecker implements AudioChecker {
    int mask = 0xFF;
    @Override
    public String getAudioType(byte[] header) {
        // checks if header == "RIFF" but in hexa
        if ((header[0] & mask) == 0x52 && (header[1] & mask) == 0x49 && (header[2] & mask) == 0x46
                && (header[3] & mask) == 0x46) {
            return "wav";
        }
        return null;
    }

}