package com.fileformat.audio.checker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fileformat.audio.reader.AudioReader;
import com.fileformat.core.Checker;
import com.fileformat.core.Reader;
// R : 82 -> 0x52| I : 73 -> 0x49 | F : 70 -> 0x46
public class AudioCheckerBundle{
    File file;
    Reader reader;
    List<Checker> audioCheckers;

    public AudioCheckerBundle(File file, Reader reader, List<Checker> audioCheckers) {
        this.file = file;
        this.reader = reader;
        this.audioCheckers = audioCheckers;
    }

    public String getAudioType() {
        try {
            byte[] header = reader.getHeader(file, 4);
            for (Checker checker : audioCheckers) {
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

    public static void main(String[] args) {
        File file = new File("/home/skill_sage/Desktop/PSU/Coding/Java/fileformat/src/main/resources/audios/sample.wav");
        Reader reader = new AudioReader();
        ArrayList<Checker> audioCheckers = new ArrayList<>();
        audioCheckers.add(new Mp3Checker());
        audioCheckers.add(new WavChecker());
        AudioCheckerBundle checker = new AudioCheckerBundle(file, reader, audioCheckers);
        System.out.println(checker.getAudioType());
    }
}
