import java.util.LinkedList;
//Tính kế thừa cho phép bạn tạo ra các lớp mới bằng cách sử dụng thông tin và hành vi từ các lớp đã tồn tại.
//Tính đa hình cho phép bạn thực hiện cùng một hành động trên các đối tượng khác nhau mà không cần quan tâm đến loại đối tượng cụ thể.

//Lớp trừu tượng - không thể tạo đối tượng
abstract class animal {
    protected String name;
    //Phương thức trừu tượng
    public abstract void getInfo();
}

//Lớp human kế thừa từ lớp animal
class human extends animal {
    human (String name) {
        this.name = name;
    }
    public void getInfo() {
        System.out.println("Name: " + name);
    }
  
    //final method: Phương thức không thể ghi đè từ lớp con
    public final void display() {
        System.out.println("This is a final method");
    }
}

//Lớp studen kế thừa từ lớp human
class student extends human {
    private String mssv;
    student(String name, String mssv) {
        super(name);
        this.mssv = mssv;
    }
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("MSSV: " + mssv);
    }
}

//Lớp clazz kết tập từ student
class clazz {
    private LinkedList<student> a = new LinkedList<>();
    public void addStudent(student student) {
        a.add(student);
        System.out.println("Student " + student.name + " has been added to the class.");
    }
    public void remoteStudent(student student) {
        if(a.contains(student)) {
            a.remove(student);
            System.out.println("Student " + student.name + " has been removed to the class.");
        } else {
            System.out.println("There is no student " + student.name + " in the class.");
        }
    }
    public void getInfo() {
        for(int i = 0; i < a.size(); i++) {
            a.get(i).getInfo();
        }
    }
}

public class Inheritance {
        public static void main(String[] args) {
            human human = new human("XXXX XXXX");
            human.getInfo();
            student student1 = new student("Nguyen Van A", "20231111");
            student1.getInfo();
            student student2 = new student("Nguyen Van B", "20232222");
            student student3 = new student("Nguyen Van C", "20233333");
            student student4 = new student("Nguyen Van D", "20234444");
            student student5 = new student("Nguyen Van E", "20235555");
            clazz clazz = new clazz();
            clazz.addStudent(student1);
            clazz.addStudent(student2);
            clazz.addStudent(student3);
            clazz.addStudent(student4);
            clazz.remoteStudent(student3);
            clazz.remoteStudent(student5);
            clazz.getInfo();
        }
}