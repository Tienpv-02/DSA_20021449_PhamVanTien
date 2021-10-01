public class Hello {
    public static void main(String[] args) {
        Myvector v1 = new Myvector(2,3);
        Myvector v2 = new Myvector(3, 4);
        Myvector v3 = v1.add(v2);
        System.out.println(v3);
    }
}
