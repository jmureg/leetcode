package math;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));
        System.out.println(myPow(2.10000,3));
        System.out.println(myPow(2.00000,-2));
        System.out.println(myPow(1.00001,123456));
        System.out.println(myPow(1.00012,1024));

    }
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == Integer.MIN_VALUE){
            return myPow(x*x, n/2);
        }
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        if(n%2 == 1)
            return myPow(x*x, n/2)*x;
        else
            return myPow(x*x, n/2);
    }
}
