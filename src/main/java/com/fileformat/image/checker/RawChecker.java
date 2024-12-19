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
        
        // Check for Canon RAW (CR2) specifically, using further header checks
        if (isCanonRaw(header, mask)) {
            return "raw";
        }
        
        // ... Add similar checks for Nikon, Sony, etc.
        return null;
    }

    private boolean isCanonRaw(byte[] header, int mask) {
        // First check is TIFF-like, then add more specific check for Canon RAW
        return (header[0] & mask) == 0x49 && (header[1] & mask) == 0x49 && (header[2] & mask) == 0x2A && (header[3] & mask) == 0x00
            && (header[8] & mask) == 0x43 && (header[9] & mask) == 0x52;  // "CR" signature for Canon
    }
    
    // Additional checks for Nikon, Sony, etc.
}
