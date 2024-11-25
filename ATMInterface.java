package BrainwaveMatrixSolution;
import java.util.Scanner;
public class ATMInterface {
	   
	    private static double balance = 1000.00; // Default balance
	    private static final int USER_PIN = 1234; // Default PIN

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to the ATM!");
	        System.out.print("Please enter your PIN: ");
	        int attempts = 0;

	        while (attempts < 3) {
	            int enteredPin = scanner.nextInt();
	            if (enteredPin == USER_PIN) {
	                System.out.println("Login successful!");
	                showMenu(scanner);
	                break;
	            } else {
	                attempts++;
	                if (attempts < 3) {
	                    System.out.println("Incorrect PIN. Try again (" + (3 - attempts) + " attempts left): ");
	                } else {
	                    System.out.println("Too many incorrect attempts. Exiting.");
	                    System.exit(0);
	                }
	            }
	        }

	        scanner.close();
	    }

	    private static void showMenu(Scanner scanner) {
	        while (true) {
	            System.out.println("\nATM Menu:");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    checkBalance();
	                    break;
	                case 2:
	                    depositMoney(scanner);
	                    break;
	                case 3:
	                    withdrawMoney(scanner);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void checkBalance() {
	        System.out.printf("Your current balance is: ₹%.2f\n", balance);
	    }

	    private static void depositMoney(Scanner scanner) {
	        System.out.print("Enter the amount to deposit: ₹");
	        double depositAmount = scanner.nextDouble();
	        if (depositAmount > 0) {
	            balance += depositAmount;
	            System.out.printf("Successfully deposited ₹%.2f. New balance: ₹%.2f\n", depositAmount, balance);
	        } else {
	            System.out.println("Invalid amount. Deposit must be greater than zero.");
	        }
	    }

	    private static void withdrawMoney(Scanner scanner) {
	        System.out.print("Enter the amount to withdraw: ₹");
	        double withdrawAmount = scanner.nextDouble();
	        if (withdrawAmount > 0 && withdrawAmount <= balance) {
	            balance -= withdrawAmount;
	            System.out.printf("Successfully withdrew ₹%.2f. New balance: ₹%.2f\n", withdrawAmount, balance);
	        } else if (withdrawAmount > balance) {
	            System.out.println("Insufficient funds. Transaction failed.");
	        } else {
	            System.out.println("Invalid amount. Withdrawal must be greater than zero.");
	        }
	    }
	}

