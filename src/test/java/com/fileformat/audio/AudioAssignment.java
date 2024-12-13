package com.fileformat.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fileformat.audio.calculator.AudioCalculator;
import com.fileformat.audio.calculator.Mp3Calculator;
import com.fileformat.audio.checker.*;
import com.fileformat.audio.parser.AudioParser;
import com.fileformat.audio.parser.Mp3Parser;
import com.fileformat.audio.printer.*;
import com.fileformat.audio.reader.*;
import com.fileformat.utility.*;

public class AudioAssignment {
    public static void main(String[] args) throws IOException {
        boolean isMp3 = false;
        File file = new File("src/main/resources/sample.wav");
        Reader reader = new AudioReader();
        List<Checker> audioCheckers = new ArrayList<>();
        audioCheckers.add(new Mp3Checker());
        audioCheckers.add(new WavChecker());
        AudioCheckerBundle checker = new AudioCheckerBundle(file, reader, audioCheckers);

        if (checker.getAudioType() == "wav") {
            System.out.println("wav");
            isMp3 = false;
        } else {
            System.out.println("mp3 ... loading header!");
            isMp3 = true;
        }
        if (isMp3) {
            Merger merger = new ByteMerger();
            Extractor extractor = new Extractor(merger);
            AudioCalculator calculator = new Mp3Calculator();
            AudioParser parser = new Mp3Parser(extractor, calculator);
            Printer printer = new Mp3Printer();
            parser.parseBits(reader.getHeader(file, 4));
            printer.display(parser);
        }
    }
}