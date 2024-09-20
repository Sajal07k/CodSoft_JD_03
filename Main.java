import java.util.Scanner;
// ATM INTERFACE
class BankAccount
{
    private double balance;
    BankAccount(double amount){
        this.balance = amount;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit Successful. \nNew Balnace: "+balance);
        }else{
            System.out.println("Invalid amout");
        }
    } 

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw Successful. \nNew Balance: "+balance);
        }else if(amount > balance){
            System.out.println("Insufficient Funds.");
        }else{
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
class ATM{
    private BankAccount account;

    public ATM(BankAccount account){
        this.account = account;
    }

    public void withdraw(double amount){
        account.withdraw(amount);
    }

    public void deposit(double amount){
        account.deposit(amount);
    }

    public void checkBalance(){
        System.out.println("Current Balance "+account.getBalance());
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("______________ATM_____________ ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option : ");

            int choice = sc.nextInt();
            switch (choice) {
                case  1:
                    System.out.print("Enter withdrawal amount : ");
                    double withdrawalAmount = sc.nextDouble();
                    withdraw(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount : ");           
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. GoodBye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invald choice. Please try again.");                    
            }
        }
        sc.close();
    }
}
public class Main
{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(2000.0);
        ATM atm = new ATM(account);
        atm.start();
    }
}
