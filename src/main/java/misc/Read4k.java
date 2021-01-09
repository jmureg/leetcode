package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Read4k {

    int position = 0;
    ArrayList<String> lines = new ArrayList<String>();
    boolean reachedEndOfFile = false;

    Read4k() {

        for (int i = 0; i < 10000; i++) {
            System.out.println(i + "\t" + readline());
        }

    }

    public static void main(String[] args) {
        new Read4k();
    }

    String readline() {
        if (!reachedEndOfFile && position == lines.size()) {
            read4kHelper();
        }
        if (position < lines.size()) {
            return lines.get(position++);
        }

        return null;
    }

    private void read4kHelper() {
        String chunk = read4k();
        if (chunk != null && !chunk.equals("")) {
            String[] linesArray = chunk.split("\n");
            this.lines.addAll(new ArrayList<String>(Arrays.asList(linesArray)));
        }
    }

    private String read4k() {
        StringBuffer buf = new StringBuffer();
        final String alphabet = "0123456789ABCDEFN$";
        final int N = alphabet.length();

        Random r = new Random();

        for (int i = 0; i < 4000; i++) {
            char c = alphabet.charAt(r.nextInt(N));
            if (c == '$') {
                buf.append("\n");
            } else {
                buf.append(c);
            }
        }

        return buf.toString();
    }

}
