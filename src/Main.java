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

    public static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static UI ui = new UI();


    public static void main(String[] args) throws IOException {
        //Hvis et spil er i gang, vil der blive loadet data fra sidste session, ellers vil brugeren blive bedt om at registrere deltagere
        try{
            readAccountData();
        }catch(IOException e){
            System.out.println("Velkommen til Matador ");
            ui.createAccounts();
        }
        //print information om de kontoer der er i spillet
        printAccounts();

       //Test af metode til at trække beløb fra den første konto (accounts.get(0)) der blev oprettet i spillet

        int input=0;
        try {
            input = Integer.parseInt(UI.getUserInput("Træk beløb fra "+accounts.get(0).getOwner()+"'s konto"));
        }catch (InputMismatchException e){
            System.out.println(e.toString());
        }

        accounts.get(0).withdrawAmount(input);
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
        int count = 0;

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            accountLine = line.split(":");
            accounts.add(new BankAccount(Float.parseFloat(accountLine[1])));
            int index = accounts.size()-1;//minus 1 fordi arrays starter med index 0
            accounts.get(index).setOwner(accountLine[0]);
            count++;
        }

    }

    /**
     * Denne metode gemmer sessionens tilstand, dvs listen af konti i formen ejernavn:saldo
     */
    public static void saveGameData(){
        String gamedata = "";
        //todo: kald metoden printAccounts() metoden istedet for at gennemløbe igen (Dont Repeat yourself)
        for (BankAccount a:accounts) {
            gamedata = gamedata + a.getOwner()+":"+a.getBalance()+"\n";
        }
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
    public static void printAccounts(){
        for (BankAccount a:accounts) {
            System.out.println(a);
        }
    }
}
