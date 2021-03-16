import java.util.Scanner;

public class UI {

    /*
    *
    *
    * There was no saved data on boot, so system shows the message “write name of participant 1”.
    * The user writes a name and presses enter.
    * The system creates a new BankAccount with the initial balance of 30000, creates a Player with the name.
    * Then assigns the Account  to the Player.
    * The System shows the message “write name of participant 2”, and the circle continues until there are 6 players.
    *
    * */
    private int maxPlayers = 6;
    private int startBalance = 30000;

    public void registerPlayers(){
        String input="";
        System.out.println("Skriv navnene på spillets deltagere");
        System.out.println("tast Q for quitte");
        while(Main.players.size() < maxPlayers ){ //Tjekker om brugeren har tastet Q eller om der er registret 6 spillere
            input = getUserInput("Skriv navnet på spiller nr "+(Main.players.size()+1));

            if(input.toUpperCase().equals("Q")) {
            break;
            }else{
            Player player = new Player(input, startBalance);
            Main.players.add(player);
            }

        }
        System.out.println("Tak, spillets deltagere er registeret");
    }


    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
