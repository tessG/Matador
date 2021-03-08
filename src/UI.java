import java.util.Scanner;

public class UI {

    public void createAccounts(){
        int input = Integer.parseInt(getUserInput("Skriv antal deltagere: "));
        for(int i = 0; i< input; i++){
            Main.accounts.add(new BankAccount(30000));
             assignPlayer(Main.accounts.get(i));
        }

    }
    public static void assignPlayer(BankAccount account){
        String input = getUserInput("Skriv kontoejers navn: ");
        account.setOwner(input);

    }

    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
