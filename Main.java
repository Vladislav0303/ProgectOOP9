
public class Main {
    public static void main(String[] args) {
        MyVector vector = new MyVector();
        MyVector vector1 = new MyVector();
        System.out.println(vector.compareTo(vector1));
        System.out.println(vector.compare(vector, vector1));
    }
}