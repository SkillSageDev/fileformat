package com.fileformat.image.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fileformat.core.Reader;

public class ImageReader implements Reader {

    @Override
    public byte[] getHeader(File file, int numBytes) throws IOException {
        try (FileInputStream image = new FileInputStream(file)) {
            byte[] header = new byte[numBytes];
            int byteRead = image.read(header);
            return header;
        }
    }
}
