package com.fileformat.audio;

import java.io.File;
import java.util.ArrayList;

import com.fileformat.audio.checker.*;
import com.fileformat.audio.reader.*;

public class AudioAssignment {
    public static void main(String[] args) {
        boolean isMp3 = false;
        File file = new File("src/main/resources/stab.mp3");
        Reader reader = new AudioReader();
        ArrayList<Checker> audioCheckers = new ArrayList<>();
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
            // print mp3 header
        }
    }
}