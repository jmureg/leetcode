package math;

public class IntToRoman {

    public static void main(String[] args) {
        IntToRoman itr = new IntToRoman();
        System.out.println("expect MMM: " + itr.intToRoman(3000));

        itr = new IntToRoman();
        System.out.println("expect XI: " + itr.intToRoman(11));


        itr = new IntToRoman();
        System.out.println("expect IV: " + itr.intToRoman(4));

        itr = new IntToRoman();
        System.out.println("expect IX: " + itr.intToRoman(9));

        itr = new IntToRoman();
        System.out.println("expect I: " + itr.intToRoman(1));

        itr = new IntToRoman();
        System.out.println("expect LVIII: " + itr.intToRoman(58));

        itr = new IntToRoman();
        System.out.println("expect MMMD: " + itr.intToRoman(3500));

        itr = new IntToRoman();
        System.out.println("expect MMMD: " + itr.intToRoman(3600));
        itr = new IntToRoman();
        System.out.println("expect MCMXCIV: " + itr.intToRoman(1994));
    }

    public String intToRoman(int num) {
        String result = "";

        if (num >= 1000) {
            int m = num / 1000;
            for (int i = 0; i < m; i++) {
                result += "M";
            }
            num = num - m * 1000;
        }
        if (num >= 900) {
            num = num - 900;
            result += "CM";
        }
        if (num >= 500) {
            num = num - 500;
            result += "D";
        }
        if (num >= 400) {
            num = num - 400;
            result += "CD";

        }
        if (num >= 100) {
            int m = num / 100;
            for (int i = 0; i < m; i++) {
                result += "C";
            }
            num = num - m * 100;
        }
        if(num>=90) {
            num = num -90;
            result += "XC";
        }
        if(num>=50) {
            num = num -50;
            result += "L";
        }
        if(num>=40) {
            num = num-40;
            result += "XL";
        }
        if(num>=10) {
            int m = num / 10;
            for (int i = 0; i < m; i++) {
                result += "X";
            }
            num = num - m * 10;
        }

        if(num>=9) {
            num = num-9;
            result += "IX";
        }
        if(num>=5) {
            num = num-5;
            result += "V";
        }
        if(num==4) {
            num = num-4;
            result += "IV";
        }
        if(num>=1) {
            for (int i = 0; i < num; i++) {
                result += "I";
            }
            num = 0;
        }

        return result;
    }
}
