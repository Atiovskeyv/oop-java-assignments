// This program is a safe calculator that takes user input in the format: number operator number.
// It performs basic arithmetic operations (+, -, *, /) with error handling for invalid input and division by zero.

void main(){
    IO.println("Enter an expression in the format: number operator number (e.g., 5 * 7). Type 'q' to quit.\n");

    double result = 0;

    while(true){
        try{
            String input = IO.readln("Enter operation:");
            input = input.trim();

            if (input.equals("q")) {
                IO.println("Program terminated.");
                return;
            }

            String[] parts = input.split(" ");
            int num1 = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int num2 = Integer.parseInt(parts[2]);

            switch (operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = (double)num1 / num2;
                    break;
                default:
                    IO.println("Invalid operator.");
                    continue;
            }

            IO.println("Result: " + result + "\n");
        }
        catch(NumberFormatException e){
            IO.println("Invalid number input!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            IO.println("Incomplete input!");
        }
        catch(ArithmeticException e){
            IO.println("Division by zero error!");
        }
    }
}