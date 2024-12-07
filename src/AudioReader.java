import java.io.File;
import java.io.IOException;

public interface AudioReader {
    public byte[] getHeader(File file, int numBytes) throws IOException;
}