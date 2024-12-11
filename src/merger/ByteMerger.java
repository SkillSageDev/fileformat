package merger;

import merger.interfaces.Merger;

public class ByteMerger implements Merger {

    @Override
    public String mergeBytes(byte[] bytes) {
        int mask = 0xFF;
        String merged = "";
        for(byte b : bytes){
            merged += String.format("%8s", Integer.toBinaryString(b & mask)).replace(' ', '0');
        }
        return merged;
    }

}
