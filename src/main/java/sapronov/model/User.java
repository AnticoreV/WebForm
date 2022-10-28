package sapronov.model;

import java.util.LinkedList;
import java.util.List;

public class User {
    List<String> identity = new LinkedList<>();
    User(String pass, String name, String surname){
        identity.add(pass);
        identity.add(name);
        identity.add(surname);
    }
}
