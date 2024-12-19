package com.fileformat.image.checker;

import java.io.File;
import java.io.FileInputStream;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class JpegChecker implements Checker {
    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        // Jpeg header FFD8
        if ((header[0] & mask) == 0xFF && (header[1] & mask) == 0xD8) {
            return "jpeg";
        }
        return null;
    }
}
