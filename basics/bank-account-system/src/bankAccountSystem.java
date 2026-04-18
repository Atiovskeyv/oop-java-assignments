// This program demonstrates a simple bank account class.
// It allows deposit, withdrawal with balance check, and balance display operations.

public class BankAccount {
    public String accountOwner;
    public double balance;

    void deposit(double amount){
        balance = balance + amount;
        IO.println("Updated balance: " + balance);
    }

    void withdraw(double amount){
        if (amount > balance){
            IO.println("Insufficient balance.\n");
        }
        else{
            balance = balance - amount;
            IO.println("Balance: " + balance);
        }
    }

    void showBalance(){
        IO.println("Balance: " + balance);
    }
}


void main(){
    BankAccount myAccount = new BankAccount();
    myAccount.accountOwner = "Atilla";
    myAccount.balance = 500;

    myAccount.showBalance();
    myAccount.deposit(500);
    myAccount.withdraw(60000);
}