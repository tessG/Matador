/**
 * Matador
 * En digital version af det klassiske matador spil
 * Anvendt i undervisingen på Dat 1, cphbusiness academy
 *
 * @author Tess Gaston
 * @version 1.0
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static ArrayList<Player> players = new ArrayList<>();
    public static UI ui = new UI();
    public static Board board;

    public static void main(String[] args) throws IOException {
        System.out.println("Velkommen til Matador ");

        //Hvis et spil er i gang, vil der blive loadet data fra sidste session, ellers vil brugeren blive bedt om at registrere deltagere
        try{
            readAccountData();
            //todo: show options (continue last game or start a new)
           // ui.showMenu();
        }catch(IOException e){
            System.out.println("Ingen data gemt");
            ui.registerPlayers();
        }
        //print information om de kontoer der er i spillet
        System.out.println(getPlayerData());



       board = new Board();
     // board.getFields()





        // gem spillets tilstand
        saveGameData();
    }

    /**
     * Denne metode læser sidste sessions spildata fra en tekstfil, hvor hver linie repræsenterer en spillers konto
     * For hver linie i tekstfilen oprettes en konto med liniens saldo og ejernavn
     * @throws IOException
     */

    public static void readAccountData() throws IOException{
        String [] accountLine;
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            accountLine = line.split(":");
            float balance = Float.parseFloat(accountLine[1]);
            players.add(new Player( accountLine[0],balance));

        }

    }

    /**
     * Denne metode gemmer sessionens tilstand, dvs listen af konti i formen ejernavn:saldo
     */
    public static void saveGameData(){
        String gamedata = "";
        //todo: kald metoden printAccounts() metoden istedet for at gennemløbe igen (Dont Repeat yourself)
        //for (BankAccount a:accounts) {
          //  gamedata = gamedata + a.getOwner()+":"+a.getBalance()+"\n";
        //}

        gamedata = getPlayerData();

        try{
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gamedata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getCause());
        }
    }

    /**
     * Denne metode printer alle konti ud
     */
    public static String getPlayerData(){
        String s = "";
        for (Player p:players) {
            s += p.toString() +'\n';
        }
        return s;
    }
}
