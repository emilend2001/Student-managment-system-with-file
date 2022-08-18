package main;

import beans.Student;
import util.FileUtil;

public class Config {

    public static Student [] students;


    public static void save(){
        FileUtil.writeObjcetToFile(Config.students,"student.obj");
    }

    public static void initialize(){
        try {
            students= (Student[]) FileUtil.readObjectFromFile("student.obj");
        }catch (Exception e){
            students=new Student[0];
        }
    }
}
