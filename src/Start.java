public class Start extends Consequence {
    public int income;
    public Start( int id, String label, int income) {
        super( id,label);
        this.income = income;

    }
    public String toString(){
        return "modtag 4000kr når du passerer start";
    }
    public Action getAction(){
        String str = this.toString();
        int amount  = this.income;
        Action a = new Action(str, amount);
        return a;
    }
}
