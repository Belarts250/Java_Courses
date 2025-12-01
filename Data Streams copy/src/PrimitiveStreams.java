import java.io.*;

public class PrimitiveStreams {
    public static void main(String[] args){
        File file= new File("C:\\Users\\user\\Downloads\\Sample.dat");
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(5);
            dos.writeUTF("hello");
            dos.writeBoolean(true);
        }catch(IOException e){
            System.out.println("Error occurred: "+e.getMessage());
        }
        try(DataInputStream reader=new DataInputStream(new FileInputStream(file))){
            System.out.println(reader.readInt());
            System.out.println(reader.readUTF());
            System.out.println(reader.readBoolean());
        }catch(IOException e){
            System.out.println("Error occurred: "+e.getMessage());
        }
    }
}