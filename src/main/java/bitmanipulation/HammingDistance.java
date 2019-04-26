package bitmanipulation;

public class HammingDistance {
    HammingDistance() {

    }

    public int hammingDistance(int x, int y) {
        int counter = 0;
        if (x >= 0 && y >= 0 && x < Math.pow(2, 31) && y < Math.pow(2, 31)) {
            int length = Math.max(x, y);
            while (length != 0) {
                int xBit = x & 1;
                int yBit = y & 1;
                if (xBit != yBit) {
                    counter++;
                }
                x = x >>> 1;
                y = y >>> 1;
                length = length >>> 1;
            }
        }

        return counter;
    }

    /*
    source
    https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/discuss/279863/Java-AC-solution
     */
    public int hammingDistance2(int x, int y) {
        int res = x ^ y;
        int c = 0;
        while (res > 0) {
            c += res & 1;
            res >>= 1;
        }

        return c;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println("1: " + hd.hammingDistance(2147483647, 0));
        System.out.println("3: " + hd.hammingDistance(15, 7));
        System.out.println("2: " + hd.hammingDistance(1, 4));
        System.out.println("1: " + hd.hammingDistance(7, 4));
    }
}
