package com.fileformat.audio.printer;

import com.fileformat.audio.parser.AudioParser;

public class Mp3Printer implements Printer{

    @Override
    public void display(AudioParser parser) {
        System.out.println(
            "MPEG Version: " + parser.getMpegVersion() + " -> " + parser.getMpegVersionBits() + "\n" + 
            "Layer: " + parser.getLayer() + " -> " + parser.getLayerBits() + "\n" + 
            "Protection: " + parser.getProtection() + " -> " + parser.getProtectionBits() + "\n" + 
            "Bitrate: " + parser.getBitrate() + "kbps -> " + parser.getBitrateBits() + "\n" + 
            "Sampling Rate: " + parser.getSamplingRate() + " -> " + parser.getSamplingRateBits() + "\n" + 
            "Padding: " + parser.getPadding() + " -> " + parser.getPaddingBits() + "\n" + 
            "Channel: " + parser.getChannel() + " -> " + parser.getChannelBits() + "\n" + 
            "Mode Extenstion (only if joint stereo): " + parser.getModeExtension() + " -> " + parser.getModeExtensionBits() + "\n" + 
            "Copyright: " + parser.getCopyright() + " -> " + parser.getCopyrightBits() + "\n" + 
            "Original: " + parser.getOriginal() + " -> " + parser.getOriginalBits() + "\n" + 
            "Emphasis: " + parser.getEmphasis() + " -> " + parser.getEmphasisBits() + "\n"  
            // "Frame Length In Bytes: " + parser.getFrameLengthInBytes() + "\n"  
        );
    }

    
}