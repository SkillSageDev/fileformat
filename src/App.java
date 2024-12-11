import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        boolean isMp3 = false;
        File file = new File("stab.mp3");
        Reader reader = new AudioReader();
        ArrayList<AudioChecker> audioCheckers = new ArrayList<>();
        audioCheckers.add(new WavChecker());
        audioCheckers.add(new Mp3Checker());
        Checker checker = new Checker(file, reader, audioCheckers);
        if (checker.getAudioType() == "wav") {
            System.out.println("wav");
            isMp3 = false;
        } else {
            System.out.println("mp3 ... loading header!");
            isMp3 = true;
        }

        if (isMp3) {
            // print mp3 header
        }
    }
}
