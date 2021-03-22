public class Player {
   private BankAccount account;
   String name;


    public Player(String name, float balance) {
        this.name = name;
        account = new BankAccount(balance);
        //Main.accounts.add(account);

    }
    public String toString(){
        String str = name +" : "+this.account.getBalance();
        return str;
    }
    public void doTransaction(int amount)
    {
        account.setBalance(amount);
    }
}
