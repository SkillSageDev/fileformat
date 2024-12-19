package com.fileformat.image.checker;

import java.io.File;
import java.io.FileInputStream;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class BmpChecker implements Checker {
    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        // BMP header 424D
        if ((header[0] & mask) == 0x42 && (header[1] & mask) == 0x4D) {
            return "bmp";
        }
        return null;
    }
}
