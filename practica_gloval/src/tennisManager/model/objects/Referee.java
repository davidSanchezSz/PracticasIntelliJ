package tennisManager.model.objects;

import tennisManager.HasName;

import java.util.Objects;

public class Referee implements HasName {
    private String name;
    private String password;

    public Referee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password){
        return Objects.equals(this.password, password);
    }

}
