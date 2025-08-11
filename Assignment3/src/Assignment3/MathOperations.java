package Assignment3;
import java.util.Scanner;

//MathOperations class encapsulating all math utility methods
class MathOperations {

 // Method to print multiplication table of a number
 public void printTable(int number) {
     System.out.println("Multiplication Table of " + number + ":");
     for (int i = 1; i <= 10; i++) {
         System.out.println(number + " x " + i + " = " + (number * i));
     }
 }

 // Method to calculate factorial of a number
 public void calculateFactorial(int number) {
     if (number < 0) {
         System.out.println("Factorial is not defined for negative numbers.");
         return;
     }

     long factorial = 1;
     for (int i = 1; i <= number; i++) {
         factorial *= i;
     }
     System.out.println("Factorial of " + number + " is " + factorial);
 }

 // Method to check if a number is prime
 public void checkPrime(int number) {
     if (number <= 1) {
         System.out.println(number + " is NOT a prime number.");
         return;
     }

     boolean isPrime = true;
     for (int i = 2; i <= number / 2; i++) {
         if (number % i == 0) {
             isPrime = false;
             break;
         }
     }

     if (isPrime)
         System.out.println(number + " is a PRIME number.");
     else
         System.out.println(number + " is NOT a prime number.");
 }

 // Method to print Fibonacci series up to given terms
 public void printFibonacci(int terms) {
     if (terms <= 0) {
         System.out.println("Number of terms must be positive.");
         return;
     }

     int first = 0, second = 1;
     System.out.println("Fibonacci series up to " + terms + " terms:");
     for (int i = 1; i <= terms; i++) {
         System.out.print(first + " ");
         int next = first + second;
         first = second;
         second = next;
     }
     System.out.println();
 }
}
