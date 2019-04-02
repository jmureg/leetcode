package strings;

public class NumberOfSegmentsInString {

    public static void main(String[] args) {
/*
         System.out.println("0 vs " +  countSegments(""));
        System.out.println("1 vs " +  countSegments("one"));
        System.out.println("2 vs " +  countSegments("one two"));
        System.out.println("2 vs " +  countSegments("one two "));
        System.out.println("5 vs " +  countSegments("Hello, my name is John"));
        System.out.println("6 vs " +  countSegments(", , , ,        a, eaefa"));


*/
        System.out.println("2 vs " +  countSegments("    foo    bar"));
    }


    public static int countSegments(String s) {
        int counter = 0;

        if(s!=null && s.length()>0) {
            StringBuffer sb = new StringBuffer(s);
            int pos = s.length()-1;
            while(pos>1) {
                char top = sb.charAt(pos);
                char down = sb.charAt(pos-1);

                if(top == ' ' && down == ' ') {
                    sb.deleteCharAt(pos);
                }
                pos--;
            }
            String st = sb.toString();
            String[] strings = st.split(" ");
            for (String entry: strings
                 ) {
                if(!entry.equals("")) {
                    counter++;
                }
            }

            return counter;
        } else {
            return counter;
        }

    }
}
