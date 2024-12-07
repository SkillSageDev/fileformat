import java.io.*;

public class Audio {
    byte[] data;
    int bytesRead;
    void getAudioBytes(File file) {
        try(FileInputStream audio = new FileInputStream(file)){
            // logic
        }catch(IOException e){
            System.out.println("no file detected");
        }
    }
}
