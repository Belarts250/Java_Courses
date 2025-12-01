import java.io.*;

public class Main implements Serializable {
    public static  void main(String[] args ) throws IOException {
        User myuser = new User();
        myuser.name = "Dankie";
        myuser.password = "Donkey";

        FileOutputStream fileOut = new FileOutputStream("userInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(myuser);
        out.close();
        fileOut.close();

        System.out.println("object Info saved!");


    }
}
