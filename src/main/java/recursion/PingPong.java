package recursion;

import java.util.Random;

public class PingPong {
    public static Random rand = new Random();

    public static void main(String[] args) {
        boolean x = ping(0);
        if (x) {
            System.out.println("Ping hat gewonnen");
        } else {
            System.out.println("Pong hat gewonnen");
        }

    }

    // Hier kommt die ping-Methode
    public static boolean ping(double pos) {
        boolean validHit = inputIsValidHit(pos);
        if (validHit) {
            double targetPosOnOtherSide = determineNewPos(pos);
            System.out.println("Calculated " + targetPosOnOtherSide + " for ping");
            pong(targetPosOnOtherSide);
        } else {
            return true;
        }
        return false;
    }

    // Hier kommt die pong-Methode
    public static boolean pong(double pos) {
        boolean validHit = inputIsValidHit(pos);
        if (validHit) {
            double targetPosOnOtherSide = determineNewPos(pos);
            System.out.println("Calculated " + targetPosOnOtherSide + " for pong");
            ping(targetPosOnOtherSide);
        } else {
            return true;
        }
        return false;
    }

    private static double determineNewPos(double pos) {
        double newPos = pos + ((Math.random() * 10) - 5) - 0.5;
        return newPos;
    }

    private static boolean inputIsValidHit(double pos) {
        return pos >= -5 && pos <= 5;
    }

}
