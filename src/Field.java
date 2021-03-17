public class Field {
    String label;
    int id;

    public Field( int id, String label) {
        this.label = label;
        this.id = id;
        System.out.println(this.id + " : " + this.label);
    }
}
