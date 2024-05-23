package zzu.asia;

import org.apache.ibatis.javassist.bytecode.ByteArray;

import java.io.*;
import java.nio.ByteBuffer;

public class test {

    public static void dvxl1() throws IOException {
        Person person = new Person("白冰玉");
        FileOutputStream outputStream = new FileOutputStream("src/main/java/zzu/asia/Person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(person);
    }

    public static void dvxl2() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/zzu/asia/Person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person.getName());
    }


    public static void main(String[] args) {
        Person person = new Person().name("bby").age("22");
        try {
            dvxl1();
            dvxl2();
//            InputStream fis = new FileInputStream("src/main/java/zzu/asia/input.txt");
//            System.out.println("Number of remaining bytes:" + fis.available());
//            int content;
//            long skip = fis.skip(2);
//            System.out.println("The actual number of bytes skipped:" + skip);
//            System.out.print("The content read from file:");
//            while ((content = fis.read()) != -1) {
//                System.out.print((char) content);
//            }

            FileOutputStream outFIle = new FileOutputStream("src/main/java/zzu/asia/out.txt");
            outFIle.write('a');

//            byte[] a = {'1', '2', '3', '4', '5'};
//            //outFIle.write(a, 2, 2);
//            byte[] array = "JavaGuide".getBytes();
//            //outFIle.write(array);
//            DataOutputStream dataOutputStream=new DataOutputStream(outFIle);
//            dataOutputStream.writeInt(123);
//            outFIle.flush();
//            outFIle.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }

    }
}

class Person implements Serializable {
    String name;
    String age;

    public String getAge() {
        return age;
    }

    public Person age(String age) {
        this.age = age;
        return this;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }
}