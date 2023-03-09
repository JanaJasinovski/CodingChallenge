import model.Root;
import service.impl.JsonServiceImpl;

public class Main {
    public static void main(String[] args) {
        JsonServiceImpl parser = new JsonServiceImpl();
        Root root1 = parser.parse();

        System.out.println(root1.toString());

        System.out.println("\n3 week break\n");

        Root root2 = parser.changePlaces();
        System.out.println(root2.toString());

    }
}