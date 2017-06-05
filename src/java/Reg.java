/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAHUL
 */
public class Reg extends HttpServlet 
{
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
  String name=req.getParameter("n1");
  String mail=req.getParameter("n2");
  String mob=req.getParameter("n5");
  String dr=req.getParameter("n4");
  String pwd=req.getParameter("n3");
 
  
  PrintWriter out=res.getWriter();
 // out.println(name+uid+pwd+mob+gen+dob);
 try{  
     
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");  
                                
PreparedStatement ps=con.prepareStatement("insert into DOCTOR values(?,?,?,?,?)");  
  
ps.setString(1,mail);  
ps.setString(2,pwd);  
ps.setString(3,name);  
ps.setString(4,mob);  
ps.setString(5,dr);    

          
int i=ps.executeUpdate();  
if(i>0)
{
    
     res.setStatus(res.SC_MOVED_TEMPORARILY);  
    res.setHeader("location", "login-2.html");
   // JOptionPane.showMessageDialog(null,"You are  registered now !");
}

 else
{
out.println("no");
}  
          
}catch (Exception e2) {System.out.println(e2);}  
  
}
    
}