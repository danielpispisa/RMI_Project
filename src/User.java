import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -3253167843904900446L;
    String id;
    String psw;
    String name;
    String surname;
    String email;
    String vehicle;
    String cv;


    User(String n, String s, String e, String v, String c){
        this.name = n;
        this.surname = s;
        this.email = e;
        this.vehicle = v;
        this.cv = c;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "name='" + name + '\'' +
                ", surname=" + surname +
                ", email='" + email + '\'' + ", vehicle='" + vehicle + '\'' + ",cv='" + cv +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
