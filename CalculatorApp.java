
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Display welcome message
        System.out.println("\n==== Simple Java Calculator ====");
        System.out.println("Available operations: +, -, *, /\n");
        
        boolean running = true;
        
        while (running) {
            try {
                // Get first number input
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                
                // Get operation input
                System.out.print("Enter operation (+, -, *, /) or 'q' to quit: ");
                String operation = scanner.next();
                
                // Check if user wants to quit
                if (operation.equalsIgnoreCase("q")) {
                    running = false;
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    continue;
                }
                
                // Validate operation
                if (!operation.equals("+") && !operation.equals("-") && 
                    !operation.equals("*") && !operation.equals("/")) {
                    System.out.println("Error: Invalid operation. Please try again.\n");
                    continue;
                }
                
                // Get second number input
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                // Perform calculation
                double result;
                switch (operation) {
                    case "+":
                        result = add(num1, num2);
                        break;
                    case "-":
                        result = subtract(num1, num2);
                        break;
                    case "*":
                        result = multiply(num1, num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Cannot divide by zero. Please try again.\n");
                            continue;
                        }
                        result = divide(num1, num2);
                        break;
                    default:
                        result = 0; // This should never happen due to validation above
                        break;
                }
                
                // Display result
                System.out.printf("\nResult: %.2f %s %.2f = %.2f\n\n", num1, operation, num2, result);
                
            } catch (Exception e) {
                System.out.println("\nError: Invalid input. Please enter numbers only.\n");
                scanner.nextLine(); // Clear the scanner buffer
            }
        }
        
        scanner.close();
    }
    
    // Addition method
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Subtraction method
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // Multiplication method
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    // Division method
    public static double divide(double a, double b) {
        return a / b;
    }
}
