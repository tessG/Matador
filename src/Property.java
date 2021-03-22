public class Property extends Field{
    int cost;
    int income;

    public Property( int id, String label, int cost, int income) {
        super( id, label);
        this.cost = cost;
        this.income = income;
    }
    public String toString() {
        return "Du er landet på " + this.label + " prisen er " + this.cost;
    }
    public Action getAction(){
        String str = this.toString();
        int amount =  this.cost;
        Action a = new Action(str,amount);
        return a;
    }
}
