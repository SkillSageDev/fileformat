package com.fileformat.image.checker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class RawChecker implements Checker {
    @Override
    public String getFileType(byte[] header) {
        int mask = 0xFF;
        // Check for various RAW file signatures
        if (isCanonRaw(header, mask) || isNikonRaw(header, mask) ||
                isSonyRaw(header, mask) || isAdobeDng(header, mask) ||
                isOlympusRaw(header, mask) || isPentaxRaw(header, mask)) {
            return "raw";
        }
        return null;
    }

    private boolean isCanonRaw(byte[] header, int mask) {
        return (header[0] & mask) == 0x49 && (header[1] & mask) == 0x49 &&
                (header[2] & mask) == 0x2A && (header[3] & mask) == 0x00;
    }

    private boolean isNikonRaw(byte[] header, int mask) {
        return (header[0] & mask) == 0x4E && (header[1] & mask) == 0x45 &&
                (header[2] & mask) == 0x46 && (header[3] & mask) == 0x00;
    }

    private boolean isSonyRaw(byte[] header, int mask) {
        return (header[0] & mask) == 0x38 && (header[1] & mask) == 0x42 &&
                (header[2] & mask) == 0x50 && (header[3] & mask) == 0x53;
    }

    private boolean isAdobeDng(byte[] header, int mask) {
        return (header[0] & mask) == 0x49 && (header[1] & mask) == 0x49 &&
                (header[2] & mask) == 0x2A && (header[3] & mask) == 0x00; // Same as Canon
    }

    private boolean isOlympusRaw(byte[] header, int mask) {
        return (header[0] & mask) == 0x4F && (header[1] & mask) == 0x52 &&
                (header[2] & mask) == 0x46 && (header[3] & mask) == 0x00;
    }

    private boolean isPentaxRaw(byte[] header, int mask) {
        return (header[0] & mask) == 0x50 && (header[1] & mask) == 0x45 &&
                (header[2] & mask) == 0x46 && (header[3] & mask) == 0x00;
    }
}