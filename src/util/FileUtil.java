package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {
    public static void writeObjcetToFile(Object obj,String fileName)  {
        try {
            FileOutputStream outputStream=new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public static Object readObjectFromFile(String fileName){
        try {
            FileInputStream fileInputStream=new FileInputStream(fileName);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            return objectInputStream.readObject();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
