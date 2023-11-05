import java.util.Scanner;
public class ccValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long cc;
        do {
            System.out.print("please enter a credit card number: ");
            if(in.hasNextLong()) {
                cc = in.nextLong();
                break;
            } else {
                System.out.print("invalid input. ");
                in.nextLine();
            }
        } while(true);
        String ccString = Long.toString(cc);
        if(!(ccString.startsWith("4") || ccString.startsWith("5") || ccString.startsWith("6") || ccString.startsWith("37"))) {
            System.out.print("credit card has invalid prefix. ");
            System.exit(1);
        }
        if(ccString.length() < 13 || ccString.length() > 16) {
            System.out.print("credit card has invalid length. ");
            System.exit(2);
        }
        long evenSum = 0;
        long evenTemp = cc / 10;
        while(evenTemp > 0) {
            if((evenTemp % 10) < 5) {
                evenSum += evenTemp % 10 * 2;
            } else {
                evenSum += 1 + (evenTemp % 10 * 2) % 10;
            }
            evenTemp /= 100;
        }
        long oddSum = 0;
        long oddTemp = cc;
        while(oddTemp > 0) {
            oddSum += oddTemp % 10;
            oddTemp /= 100;
        }
        long sum = evenSum + oddSum;
        if((sum % 10) == 0) {
            System.out.printf("%d is a valid credit card number.", cc);
        } else {
            System.out.printf("%d is an invalid credit card number.", cc);
        }
    }
}