package util;

import main.Config;

public class MenuUtil {
    public static void processMenu(int selectedMenu){
        switch (selectedMenu){
            case 1:
                StudentUtil.registerStudents();
                Config.save();
                break;
            case 2:
                StudentUtil.printAllRegisteredStudents();
                break;
            case 3:
                StudentUtil.findStudentsAndPrint();
                break;
            case 4:
                //StudentUtil.uptadeStudentSameObject();
                StudentUtil.uptadeStudentWithNewObject();
                Config.save();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    public static String requireName(){
        return InputUtil.requireText("enter name");
    }
    public static String requireSurname(){
        return InputUtil.requireText("enter surname");
    }
    public static String requireClassname(){
        return InputUtil.requireText("enter classname");
    }
    public static int requireAge(){
        return InputUtil.requireNumber("enter age");
    }

    public static void showSuccessOpMessage(){
        System.out.println("Operation complately seccessfuly");
    }
}
