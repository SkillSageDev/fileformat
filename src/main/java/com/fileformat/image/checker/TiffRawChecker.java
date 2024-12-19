package com.fileformat.image.checker;

import com.fileformat.core.Checker;

public class TiffRawChecker implements Checker {
    public String getFileType(byte[] header) {
        if (isTiff(header)) {
            return "tif";
        } else if (isRaw(header)) {
            return "raw";
        }
        return null;
    }

    private boolean isTiff(byte[] header) {
        return (header[0] == 0x49 && header[1] == 0x49 && header[2] == 0x2A && header[3] == 0x00) ||
                (header[0] == 0x4D && header[1] == 0x4D && header[2] == 0x00 && header[3] == 0x2A);
    }

    private boolean isRaw(byte[] header) {
        // Check for common RAW formats
        return 
                (header[0] == 0x4E && header[1] == 0x45 && header[2] == 0x46 && header[3] == 0x00) || // Nikon
                (header[0] == 0x38 && header[1] == 0x42 && header[2] == 0x50 && header[3] == 0x53); // Sony
    }
}