public class Extractor{
    String getBits(byte bytes, int start, int end){
        return String.format("%8s", Integer.toBinaryString(bytes & 0xFF)).substring(start, end);
    }
}