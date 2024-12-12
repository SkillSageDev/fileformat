package com.fileformat.audio.reader;
import java.io.File;
import java.io.IOException;

public interface Reader {
    public byte[] getHeader(File file, int numBytes) throws IOException;
}