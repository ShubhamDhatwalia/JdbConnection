package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    public void createDatabase(){
   
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm =  conn.createStatement();
            String query = "create database db";
            stm.execute(query);

            System.out.println("Connection made successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createTable() {
        try{
            String url = "jdbc:mysql://localhost:3306/db";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            String query = "Create table student(RollNo int primary key, name varchar(50), email varchar(100))";
            stm.execute(query);

            System.out.println("table ceated successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createData() {

        try{
            String url = "jdbc:mysql://localhost:3306/db";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);

            String query = "insert into student (name, email) values (?,?)";

            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, "Rahul");
            pstm.setString(2, "rahul@gmail.com");
            pstm.executeUpdate();

            System.out.println("Data ceated successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readData() {

         try{
            String url = "jdbc:mysql://localhost:3306/db";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            String query = "select*from student";
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()){
                System.out.println("RollNo "+rs.getInt(1));
                System.out.println("name "+rs.getString(2));
                System.out.println("email "+rs.getString(3));
            }

            System.out.println(" Read successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateData() {

        try{
            String url = "jdbc:mysql://localhost:3306/db";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            String query = "update student set name = 'Rahul Thakur' where RollNo = 3";
            stm.execute(query);

            System.out.println("Data updated successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteData() {

         try{
            String url = "jdbc:mysql://localhost:3306/db";
            String userName = "root";
            String password = "Shubham?2001";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            String query = "delete from student where RollNo = 5";
            stm.execute(query);

            System.out.println("Data deleted successfully");

            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
