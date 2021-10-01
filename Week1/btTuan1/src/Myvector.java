public class Myvector extends Object{
    public int x;
    public int y;
    public Myvector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Myvector add(Myvector other) {
        return new Myvector(this.x+other.x, this.y+other.y);
    }
    public String toString() {
        return x + "," + y;
    }
}
