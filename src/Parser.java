import java.io.IOException;

public interface Parser {
    public void parseBits(byte[] bytes) throws IOException;
}