import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount{
    public float saldo;
    private String owner;
    float[] transactions = new float[100];
  //  ArrayList<Float> transaction = new ArrayList<>();

    public BankAccount(float saldo){
        this.saldo = saldo;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }

    @Override
    public String toString(){
        String str;
        str= owner+" : "+saldo;
        return str;
    }

    public void withdrawAmount(int amount) {
       saldo= saldo-amount;
    }

    public float getSaldo() {
        return this.saldo;
    }
}
