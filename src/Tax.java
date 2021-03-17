public class Tax extends Consequence {
    int cost;
    public Tax(int id, String label, int cost) {
        super(id,label);
        this.cost=cost;
    }
}
