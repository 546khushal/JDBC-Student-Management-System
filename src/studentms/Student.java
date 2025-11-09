
package studentms;
import java.util.*;
import java.sql.*;

public class Student {
    private int id;
    private String name;
    private String course;
    private String email;
    
    public Student(){}
    
    public Student(int id,String name,String course,String email){
        this.id = id;
        this.name = name;
        this.course = course;
        this.email= email;
    }
    //getter setter methods
    public int getId(){return id;}
    public String getName(){return name;}
    public String getCourse(){return course;}
    public String getEmail(){return email;}
    
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name=name;}
    public void setCourse(String course){this.course=course;}
    public void setEmail(String email){this.email=email;}
}
