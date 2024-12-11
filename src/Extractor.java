import merger.interfaces.Merger;

public class Extractor{

    Merger merger;
    public Extractor(Merger merger){
        this.merger = merger;
    }

    String getBitsFromByte(byte bytes, int start, int end){
        return String.format("%8s", Integer.toBinaryString(bytes & 0xFF)).substring(start, end);
    }

    String getBitsFromByte(byte[] bytes, int start, int end){
        return merger.mergeBytes(bytes).substring(start, end);
    }

    String getBitsFromString(String bytes, int start, int end){
        return bytes.substring(start, end);
    }
}