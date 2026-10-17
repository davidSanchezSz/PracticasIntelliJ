package tennisManager.model.objects;

import tennisManager.HasName;

import java.util.Random;

public class Player implements HasName {
    private String name;
    private int age;
    private int id;
    private static int idCounter = 0;

    public Player(String name) {
        Random random = new Random();
        this.name = name;
        this.age = 18 + random.nextInt(23);
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
