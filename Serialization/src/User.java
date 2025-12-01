import java.io.Serializable;

public class User implements Serializable {
    String name;
    String password;

    void hello(){
        System.out.println("Hello my name is" + name);
    }
}
