package task5;

import java.util.UUID;

public class UniqueObject {
    private static UniqueObject instance;
    public UUID uuid;

    private UniqueObject() {
        uuid = UUID.randomUUID();
    }

    public static synchronized UniqueObject getInstance() {
        if (instance == null) {
            instance = new UniqueObject();
        }
        return instance;
    }

}
