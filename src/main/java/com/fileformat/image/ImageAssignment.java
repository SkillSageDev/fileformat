package com.fileformat.image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fileformat.core.*;
import com.fileformat.image.checker.BmpChecker;
import com.fileformat.image.checker.GifChecker;
import com.fileformat.image.checker.ImageCheckerBundle;
import com.fileformat.image.checker.JpegChecker;
import com.fileformat.image.checker.PngChecker;
import com.fileformat.image.checker.RawChecker;
import com.fileformat.image.checker.TiffChecker;
import com.fileformat.image.reader.ImageReader;

public class ImageAssignment {
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\images\\image.png");
        Reader reader = new ImageReader();
        List<Checker> imageCheckers = new ArrayList<>();
        imageCheckers.add(new PngChecker());
        imageCheckers.add(new JpegChecker());
        imageCheckers.add(new BmpChecker());
        imageCheckers.add(new GifChecker());
        imageCheckers.add(new RawChecker());
        imageCheckers.add(new TiffChecker());
        ImageCheckerBundle imageCheckerBundle = new ImageCheckerBundle(file, reader, imageCheckers);
        System.out.println(imageCheckerBundle.getImageType());
    }
}
