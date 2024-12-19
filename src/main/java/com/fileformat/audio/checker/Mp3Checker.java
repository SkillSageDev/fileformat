package com.fileformat.audio.checker;

import com.fileformat.core.Checker;

public class Mp3Checker implements Checker {
    int mask = 0xFF;
    @Override
    public String getFileType(byte[] header) {
        if ((header[0] & mask) == 0xFF) {
            return "mp3";
        }
        return null;
    }
}