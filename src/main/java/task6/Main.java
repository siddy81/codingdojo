package task6;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer weldContainer = weld.initialize()) {
            weldContainer.select(Application.class).get().initApplication();
        }
    }
}
