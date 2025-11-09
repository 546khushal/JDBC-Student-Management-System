
package studentms;
import java.util.*;


public class StudentManagenentApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        
        while(true){
            System.out.println("\n----Student Management System---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();
            sc.nextLine();
            
            switch(ch){
                case 1:
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.println("Enter Email: ");
                    String email = sc.nextLine();
                    
                    dao.addStudent(new Student(0,name,course,email));
                    break;
                case 2:
                    List<Student> list = dao.getAllStudents();
                    for(Student s: list){
                        System.out.println("ID: "+s.getId()+"\nName: "+s.getName()+"\nCourse: "+s.getCourse()+"\nEmail: "+s.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: ");
                    String nname = sc.nextLine();
                    System.out.print("New Course: ");
                    String ncourse = sc.nextLine();
                    System.out.print("New Email: ");
                    String nemail = sc.nextLine();
                    dao.updateStudent(new Student(uid,nname,ncourse,nemail));
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
