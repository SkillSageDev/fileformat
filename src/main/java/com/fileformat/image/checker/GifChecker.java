package com.fileformat.image.checker;

import java.io.File;
import java.io.FileInputStream;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class GifChecker implements Checker {

    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        if ((header[0] & mask) == 0x47 && (header[1] & mask) == 0x49 && (header[2] & mask) == 0x46) {
            return "gif";
        }
        return null;
    }
}
