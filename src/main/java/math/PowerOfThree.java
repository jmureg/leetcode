package math;

public class PowerOfThree {
    PowerOfThree() {
    }

    public boolean isPowerOfThree(int n) {
        if (n<=0) {
            return false;
        }
        if (n % 3 == 0){
            if (n/3 == 1){
                return true;
            }
            else {
                return isPowerOfThree(n / 3);
            }
        } else if (n == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PowerOfThree pot = new PowerOfThree();
        int n = 0;

        n=27;
        System.out.println(n + " - " + pot.isPowerOfThree(n));

        n=26;
        System.out.println(n + " - " + pot.isPowerOfThree(n));

        n=8;
        System.out.println(n + " - " + pot.isPowerOfThree(n));

        n=9;
        System.out.println(n + " - " + pot.isPowerOfThree(n));
    }
}
