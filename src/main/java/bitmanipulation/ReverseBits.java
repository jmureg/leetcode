package bitmanipulation;

public class ReverseBits {
    ReverseBits() {

    }

    public int reverseBits(int n) {
        int res = 0;
        int count = 31;
        while (count > 0) {
            res = (res | (n & 1)) << 1;
            n = n >>> 1;
            count--;
        }
        return res | (n & 1);
    }


    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println("1: " + rb.reverseBits(2147483647));
        System.out.println("3: " + rb.reverseBits(15));
        System.out.println("2: " + rb.reverseBits(4));
        System.out.println("1: " + rb.reverseBits(7));
    }
}
