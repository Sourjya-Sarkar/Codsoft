import java.util.*;

class ATM_Components {
    double Balance;

    void menu() {
        System.out.println("Enter 1 to withdraw amouont");
        System.out.println("Enter 2 to deposit amouont");
        System.out.println("Enter 3 to check balance");
        System.out.println("Enter 4 to exit");
        System.out.println("Enter the choice");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Enter a valid choice");
                break;
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be withdrawed");
        double withdraw_amount = sc.nextDouble();
        if (withdraw_amount > Balance) {
            System.out.println("Insufficient balance");
        } else {
            Balance -= withdraw_amount;
            System.out.println("\nAmount withdrawn is Rs.\n" + withdraw_amount);
        }
        menu();
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount");
        double deposit_amount = sc.nextDouble();
        Balance = deposit_amount + Balance;
        System.out.println("\nAmount Deposited is Rs.\n" + deposit_amount);
        menu();
    }

    public void checkBalance() {
        System.out.println("Current balance of the account is Rs." + Balance);
        menu();
    }

}

public class task3 {

    public static void main(String[] args) {
        ATM_Components atm = new ATM_Components();
        atm.menu();
        atm.withdraw();
        atm.deposit();
        atm.checkBalance();
    }
}
