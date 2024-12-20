package com.fileformat.audio.reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fileformat.core.Reader;

public class AudioReader implements Reader{
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