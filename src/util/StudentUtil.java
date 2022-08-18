package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        String className = MenuUtil.requireClassname();
        int age = MenuUtil.requireAge();

        Student st = new Student(name, surname, age, className);

        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
          Student st = Config.students[i];
            System.out.println((i+1)+" "+st.getFullInfo());
           // System.out.println(i+"."+Config.students[i]);
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("Nece telebe qeydiyyatdan kecireceksiniz?");
        // Config.students = new Student[count];
        Student[] oldStudents = Config.students;
        Student[] newStudents = new Student[count];

        for (int i = 0; i <count; i++) {
            System.out.println((i + 1) + ".Register");

            newStudents[i]=StudentUtil.fillStudent();
            //Config.students[i] = StudentUtil.fillStudent();
        }

        Student[] result = new Student[oldStudents.length + newStudents.length];
         for (int i = 0; i < oldStudents.length; i++) {
            result[i]=oldStudents[i];
        }

        for (int i = 0; i < newStudents.length ; i++) {
            result[oldStudents.length+i]=newStudents[i];
        }
        Config.students=result;
       MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudents();
    }
    public static void findStudentsAndPrint(){
        String text=InputUtil.requireText("type name,surname or class name");
        Student [] result=findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }
    public static Student [] findStudents (String text){
        int count=0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st=Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                count++;
            }
        }

        Student [] result=new Student[count];
        int found=0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st=Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                result[found]=st;
                found++;
            }
        }
        return result;
    }

    public static void  uptadeStudentWithNewObject(){
        StudentUtil.printAllRegisteredStudents();
        int i=InputUtil.requireNumber("Necenci adami deyisiklik etmek isteyirsiniz?");
        System.out.println("Yeni melumatlari daxil edin");
        Student s=StudentUtil.fillStudent();
        Config.students[i-1]=s;
    }

    public static void uptadeStudentSameObject(){
        StudentUtil.printAllRegisteredStudents();
        int i=InputUtil.requireNumber("Necenci adami deyisiklik etmek isteyirsiniz?");
        System.out.println("Yeni melumatlari daxil edin");
        Student selected=Config.students[i-1];
        String changeParams=InputUtil.requireText("Neleri deyisdirmek isteyirsiniz? mes: 'name,'surname''");
        if (changeParams.contains("'name'"))
            selected.setName(MenuUtil.requireName());
        if (changeParams.contains("'surname'"))
            selected.setSurname(MenuUtil.requireSurname());
        if (changeParams.contains("'classname'"))
            selected.setClassName(MenuUtil.requireClassname());
        if (changeParams.contains("'age'"))
            selected.setAge(MenuUtil.requireAge());

    }
    public static void uptadeWithSplit(){
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("Necenci adami deyisiklik etmek isteyirsiniz?");
        System.out.println("Yeni melumatlari daxil edin");
        Student selected = Config.students[index - 1];
        String changeParams = InputUtil.requireText("Neleri deyisdirmek isteyirsiniz? mes:name,surname");
        String[] parameters = changeParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name"))
                selected.setName(MenuUtil.requireName());
            else if (param.equalsIgnoreCase("surname"))
                selected.setSurname(MenuUtil.requireSurname());
            else if (param.equalsIgnoreCase("classname"))
                selected.setClassName(MenuUtil.requireClassname());

            else if (param.equalsIgnoreCase("age"))
                selected.setAge(MenuUtil.requireAge());
        }
    }
}
