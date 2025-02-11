package java_programs.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class kmit {
        public static void main(String[] args) throws IOException{
        String url = "jdbc:mysql://localhost:3306/preFS";
        String username = "root";
        String password = "Prahas@135";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
            return; // Exit the program if the driver is not found
        }

        // Using try-with-resources to ensure resources are closed automatically
        try (
            // Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create statement
            Statement statement = connection.createStatement()
        ) {
            // String query = "create table kmit_student_data(sno int(10) not null,rno varchar(200),id int(200),class varchar(200),sec varchar(200),tid varchar(200),doa varchar(200),name varchar(200) not null,fname varchar(200),dob varchar(200),adhar varchar(200),branch varchar(5),parentcell varchar(200),studentcell varchar(200),sex varchar(5))";
            // Execute the SQL statement
            FileReader f=new FileReader("C:\\Users\\praha\\OneDrive\\Desktop\\javaprograms\\Java_programs\\DAA\\java_programs\\jdbc\\Managers.csv");
            BufferedReader f2=new BufferedReader(f);
            String s=f2.readLine();
            String[] arr;
            int c=0;
            while(s!=null){
                try{
                    s=f2.readLine();
                    arr=s.split(",");
                    String ref="(";
                    int i=0;
                    int j=arr.length;
                    for(String g:arr){
                        try{
                            int x=Integer.parseInt(g);
                            ref+=g;      
                        }
                        catch(Exception e){
                            try{
                            float y=Float.parseFloat(g);
                            ref+=g;
            
                            }
                            catch(Exception e2){
                                ref+="'"+g+"'";
                            }
                        }
                        finally{
                            if(i!=j-1){
                                ref+=',';
                            }
                        }
                        i++;
                    }
                    ref+=")";
                    // System.out.println(ref);
                    String createTableSQL="insert into Managers(ManagerID,ManagerName) values"+ref;
                    statement.executeUpdate(createTableSQL);
                    // System.out.println("Table 'created successfully.");
                    // break;
            }
            catch(Exception e){
                System.out.println(e);
            }
            finally{
                // System.out.println("No errors occured");
                // System.out.println("Table created successfully");
            }
        }
            // String createTableSQL="insert into table2 (dept_id,dept_name) values(6,'Accounts');";
            // statement.executeUpdate(createTableSQL);
            // System.out.println("Table 'created successfully.");
            // // statement.executeUpdate(query);
            // System.out.println("Task done successfully;");
            // Process the result set
            // while (resultSet.next()) {
            //     String brand = "|"+resultSet.getString("name")+"|"+resultSet.getString("brand")+"|"+resultSet.getString("model")+"|"+resultSet.getString("ram")+"|"+resultSet.getString("storage")+"|"+resultSet.getString("final_price")+"|";
            //     System.out.println(brand);
            // }
        }
        catch (SQLException e) {
            System.err.println("SQL error occurred.");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("exception "+e);
        }
        finally{
            System.out.println("Table created successfully");
        }
    }
}
/*
String name=new Scanner(System.in).next()
 String sql="insert into students values" (101,'+name+','cse',+age+")";
 */


