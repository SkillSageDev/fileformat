import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader implements AudioReader{
    public byte[] getHeader(File file, int numBytes) throws IOException {
            try (FileInputStream audio = new FileInputStream(file)) {
                byte[] header = new byte[numBytes];
                int byteRead = audio.read(header);
                if(byteRead != numBytes){
                    throw new IOException("error couldn't read the file");
                }
                return header;
            }
        }
}