package Assignment;
import java.util.Scanner;

public class MenuDrivenMath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char optionAgain;

        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Print Table of a Number");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.println("**************************");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the number: ");
                    int num = sc.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(num + " x " + i + " = " + (num * i));
                    }
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    int factNum = sc.nextInt();
                    int factorial = 1;
                    for (int i = 1; i <= factNum; i++) {
                        factorial *= i;
                    }
                    System.out.println("Factorial of " + factNum + " is: " + factorial);
                    break;

                case 3:
                    System.out.print("Enter the number: ");
                    int primeNum = sc.nextInt();
                    boolean isPrime = true;

                    if (primeNum <= 1) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= primeNum / 2; ++i) {
                            if (primeNum % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime)
                        System.out.println(primeNum + " is a Prime Number.");
                    else
                        System.out.println(primeNum + " is NOT a Prime Number.");
                    break;

                case 4:
                    System.out.print("Enter how many terms: ");
                    int terms = sc.nextInt();
                    int first = 0, second = 1;
                    System.out.print("Fibonacci Series: ");
                    for (int j = 1; j <= terms; j++) {
                        System.out.print(first + " ");
                        int next = first + second;
                        first = second;
                        second = next;
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("*****Exiting the program***");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!! Please enter 1 to 5:");
            }

            System.out.print("Back to Menu? (Y/N): ");
            optionAgain = sc.next().charAt(0);

        } while (optionAgain == 'Y' || optionAgain == 'y');

        System.out.println("End");
        sc.close();
    }
}

