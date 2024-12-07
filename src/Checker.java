import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// R : 82 -> 0x52| I : 73 -> 0x49 | F : 70 -> 0x46
public class Checker {
    File file;
    AudioReader reader;
    ArrayList<AudioChecker> audioCheckers;

    public Checker(File file, AudioReader reader, ArrayList<AudioChecker> audioCheckers) {
        this.file = file;
        this.reader = reader;
        this.audioCheckers = audioCheckers;
    }

    String getAudioType() {
        try {
            byte[] header = reader.getHeader(file, 4);
            for (AudioChecker checker : audioCheckers) {
                String audioType = checker.getAudioType(header);
                if (audioType != null) {
                    return audioType;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        File file = new File("sample.wav");
        Reader reader = new Reader();
        ArrayList<AudioChecker> audioCheckers = new ArrayList<>();
        audioCheckers.add(new Mp3Checker());
        audioCheckers.add(new WavChecker());
        Checker checker = new Checker(file, reader, audioCheckers);
        System.out.println(checker.getAudioType());
    }
}
