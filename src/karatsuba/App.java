package karatsuba;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x;
        long y;
        long product;
        
        System.out.print("Enter the first number: ");
        x = sc.nextLong();
        System.out.print("Enter the second number: ");
        y = sc.nextLong();
        
        product = karatsuba(x, y);
        
        System.out.println("Product: " + product);
        
        sc.close();

    }

    private static long karatsuba(long x, long y) {
        /* 
         * if both numbers are single digit, perform basic multiplication and return
         * the product before moving further
         */
        if(x < 10 && y < 10) {
            return x * y;
        }
        
        /*
         * Determine the number of digits in the input, as well as half that number
         * 
         */
        int xLength = Long.toString(x).length();
        int yLength = Long.toString(y).length();

        int greaterLength = Math.max(xLength, yLength);
        int greaterHalf = greaterLength/2 + greaterLength%2;        
        
        /*
         * split each input into 4 groups of n/2
         */
        
        long a = (long) (x / Math.pow(10, greaterHalf));
        long b = (long) (x % Math.pow(10, greaterHalf));
        long c = (long) (y / Math.pow(10, greaterHalf));
        long d = (long) (y % Math.pow(10, greaterHalf));
        
        /*
         * recursive karatsuba formula
         */
        
        long step1 = karatsuba(a, c);
        long step2 = karatsuba (b, d);
        long step3 = karatsuba((a+b), (c+d));
        long step4 = step3 - step1 - step2;
        
        long product = (long) ((step1 * Math.pow(10, greaterHalf * 2)) + step2 + (step4 * Math.pow(10, greaterHalf)));
        
        return product;
    }
    

}
