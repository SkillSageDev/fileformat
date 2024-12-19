package com.fileformat.image.checker;

import java.io.File;
import java.io.FileInputStream;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class TiffChecker implements Checker {
    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        /*
         * 0x49 0x49 0x2A 0x00
         * or:
         * 0x4D 0x4D 0x00 0x2A
         */
        if (((header[0] & mask) == 0x49 && (header[1] & mask) == 0x49 && (header[2] & mask) == 0x2A
                && (header[3] & mask) == 0x00)
                || ((header[0] & mask) == 0x4D && (header[1] & mask) == 0x4D && (header[2] & mask) == 0x00
                        && (header[3] & mask) == 0x2A)) {
            return "tiff";
        }
        return null;
    }
}
