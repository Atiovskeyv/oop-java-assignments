// This program checks whether a given number is prime or not.
// It takes a number from the user and tests divisibility up to its square root.

void main(){
    boolean isNotPrime = false;
    String input = IO.readln("Enter a number: ");
    int number = Integer.parseInt(input);

    for(int i = 2; i <= Math.sqrt(number); i++){
        if(number % i == 0){
            isNotPrime = true;
        }
    }

    if(isNotPrime){
        IO.println("The number is not prime.");
        return;
    }
    else {
        IO.println("The number is prime.");
    }
}