public class Start extends Consequence {
    int income;
    public Start( int id, String label, int income) {
        super( id,label);
        this.income = income;
        System.out.println("modtag 4000kr når du passerer start");
    }
}
