import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
// R : 82 -> 0x52| I : 73 -> 0x49 | F : 70 -> 0x46
public class Checker {
    byte[] header;
    int byteRead;
    int mask = 0xFF;
    void getAudioType(File file) {
        try(FileInputStream audio = new FileInputStream(file)) {
            header = new byte[4];
            byteRead = audio.read(header);
            if ((header[0] & mask) == 0x52 && (header[1] & mask) == 0x49 && (header[2] & mask) == 0x46 && (header[3] & mask) == 0x46) {
                System.out.println("wav");
            } else if((header[0] & mask) == 0xFF){
                System.out.println("mp3");
            }
        } catch (IOException e) {
            System.out.println("no file detected");
        }
    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        File file = new File("d.wav");
        checker.getAudioType(file);
        System.out.println(0x52); 
    }
}
