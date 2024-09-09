import java.util.*;

class task1 {
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();
            int x = random.nextInt(101);
            int n;
            System.out.println("Guess The Random No.");
            n = sc.nextInt();

            if (x == n) {
                System.out.println("You Guessed It Right");
                System.exit(0);
            } else if (n > x + 5)
                System.out.println("Too High");
            else if (n < x - 5)
                System.out.println("Too Low");
            else if (n > x + 1 && n < x + 5 || n < x - 1 && n > x - 5)
                System.out.println("Close");
        }
    }
}
