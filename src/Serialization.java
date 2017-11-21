import java.io.*;

/**
 * Created by ashwin on 21/11/17.
 */

class Emp implements Serializable {

    public int id;
    public String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

public class Serialization {

    public static void main(String[] args) {
        // Serialization
        Emp emp = new Emp(1, "Ashwin");
        String filename = "file.ser";
        try {
            // Saving object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(emp);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }

        // Deserialization
        Emp obj = null;
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            obj = (Emp)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("[id: " + obj.id + ", name: " + obj.name + "]");
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

}
