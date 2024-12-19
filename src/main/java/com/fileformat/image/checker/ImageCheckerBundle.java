package com.fileformat.image.checker;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fileformat.core.Checker;
import com.fileformat.core.Reader;

public class ImageCheckerBundle {
    File file;
    Reader reader;
    List<Checker> imageCheckers;

    public ImageCheckerBundle(File file, Reader reader, List<Checker> imageCheckers) {
        this.file = file;
        this.reader = reader;
        this.imageCheckers = imageCheckers;
    }

        public String getImageType() {
        try {
            byte[] header = reader.getHeader(file, 10);
            for (Checker checker : imageCheckers) {
                String audioType = checker.getFileType(header);
                if (audioType != null) {
                    return audioType;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
