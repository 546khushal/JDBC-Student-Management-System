package studentms;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
        public void addStudent(Student s){
            String sql = "Insert into students (name,course,email) Values(?,?,?)";
            try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){

                ps.setString(1, s.getName());
                ps.setString(2,s.getCourse());
                ps.setString(3, s.getEmail());

                ps.executeUpdate();
                System.out.println("Student added successfully!");
            }catch(Exception e){
                e.printStackTrace();
            }    
        }    
        public List<Student> getAllStudents(){
            List<Student> list = new ArrayList<>();
            String sql = "Select * from students";
            try(Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)){
                    
                 while(rs.next()){
                 Student s= new Student(
                         rs.getInt("id"),
                         rs.getString("name"),
                         rs.getString("course"),
                         rs.getString("email")
                 );
                 list.add(s);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
        }
            
        public void deleteStudent(int id){
            String sql  = "DELETE FROM students where id=?";
            try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setInt(1,id);
                int rows = ps.executeUpdate();
                if(rows>0){
                    System.out.println("Students Deleted");
                }else{
                    System.out.println("No Student found with this ID.");
                }
            
            }catch(Exception e){
            e.printStackTrace();
            }
        }
        
        public void updateStudent(Student s){
            String sql = "UPDATE students SET name = ?,course=?,email=? WHERE id=?";
            try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setString(1,s.getName());
                ps.setString(2,s.getCourse());
                ps.setString(3,s.getEmail());
                ps.setInt(4, s.getId());
                ps.executeUpdate();
                System.out.println("Student updated Successfully!");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    
}
