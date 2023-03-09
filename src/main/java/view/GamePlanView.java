package view;

import model.Root;
import service.impl.JsonServiceImpl;

public class GamePlanView {
    private final JsonServiceImpl parser = new JsonServiceImpl();


    public void gamePlanForFirstRound() {
        Root root1 = parser.parse();
        System.out.println(root1.toString());
    }

    public void gamePlanForSecondRound() {
        Root root2 = parser.changePlaces();
        System.out.println("\n3 week break\n" + root2.toString());
    }
}
