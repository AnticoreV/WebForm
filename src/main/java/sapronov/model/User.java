package sapronov.model;

import java.util.LinkedList;
import java.util.List;

public class User {
    private List<String> identity = new LinkedList<>();
    public User(String pass, String name, String surname){
        identity.add(pass);
        identity.add(name);
        identity.add(surname);
    }

    public String getPolicyNumber() {
        return identity.get(0);
    }
    public String getName() {
        return identity.get(1);
    }
    public String getSurname() {
        return identity.get(2);
    }

    public List<String> getIdentity() {
        return identity;
    }
}
