package sapronov.model;

import java.util.Objects;

public class User {
    private String policyNumber;
    private String name;
    private String surname;

    public User(String pass, String name, String surname){
        this.policyNumber = pass;
        this.name = name;
        this.surname = surname;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){return true;}
        if (obj == null || this.getClass() != obj.getClass()) return false;
        User user = (User)obj;
        return user.getPolicyNumber() == this.policyNumber
                && user.getName() == this.name
                && user.getSurname() == this.surname;
    }
}
