public class Mp3Checker implements AudioChecker {
    int mask = 0xFF;
    @Override
    public String getAudioType(byte[] header) {
        if ((header[0] & mask) == 0xFF) {
            return "mp3";
        }
        return null;
    }
}