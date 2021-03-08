import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {

    //todo: create ArrayList as the system should support unknown numbers of players
    //private static BankAccount[] accounts = new BankAccount[3];

    public static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static UI ui;


    public static void main(String[] args) throws IOException {

     //  assignPlayer(account1);
     //  assignPlayer(account2);
     //  assignPlayer(account3);
        try{
            readAccountData();
        }catch(IOException e){
            System.out.println("Velkommen til Matador ");
            //todo: opret UI klasse så brugeren kan oprette konti til alle deltagere
            ui = new UI();
            ui.createAccounts();
        }

        printAccounts();
        //todo: erstat account1 med accounts[0]
        //accounts[0].withdrawAmount();



        int input=0;
        try {
            input = Integer.parseInt(UI.getUserInput("Træk beløb fra "+accounts.get(0).getOwner()+"'s konto"));
        }catch (InputMismatchException e){
            System.out.println(e.toString());
            //    input = Integer.parseInt( Main.getUserInput("Træk beløb fra "+this.owner+"'s konto"));
        }

        accounts.get(0).withdrawAmount(input);



        //accounts[2].withdrawAmount();
        // gem spillets tilstand
        saveGameData();
    }

    //todo:
    // create a scanner and load file
    // for each line in file
    //      create bankAccount and add it to accounts array
    //      set Owner on bankAccount

    public static void readAccountData() throws IOException{
        String [] accountLine;
        File file = new File("data.txt");

        Scanner scan = new Scanner(file);
        int count = 0;

        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            accountLine = line.split(":");
            accounts.add(new BankAccount(Float.parseFloat(accountLine[1])));
            int index = accounts.size();
            accounts.get(index-1).setOwner(accountLine[0]);
            count++;
        }

    }

    public static void saveGameData(){
        String gamedata = "";
        for (BankAccount a:accounts) {
            gamedata = gamedata + a.getOwner()+":"+a.getSaldo()+"\n";
        }
        try{
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gamedata);
            writer.close();

        }catch (IOException e){
            System.out.println(e.getCause());
        }
    }

    public static void printAccounts(){
        for (BankAccount a:accounts) {
            System.out.println(a);
        }
    }



}
