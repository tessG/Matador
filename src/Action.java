
public class Action {
    String msg;
    int amount;

    public Action(String msg, int amount) {
        this.msg = msg;
        this.amount = amount;
    }
    //Overloading
    public Action(String msg){
        this.msg = msg;
    }

}
