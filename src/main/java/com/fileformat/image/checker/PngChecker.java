package com.fileformat.image.checker;

import java.io.File;
import java.io.IOException;

import com.fileformat.audio.reader.AudioReader;
import com.fileformat.core.*;
import com.fileformat.image.reader.ImageReader;

public class PngChecker implements Checker {
    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        if ((header[1] & mask) == 0x50 && (header[2] & mask) == 0x4E && (header[3] & mask) == 0x47) {
            return "png";
        }
        return null;
    }

}
