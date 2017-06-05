/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAHUL
 */
public class Login extends HttpServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
    //PrintWriter out=res.getWriter();
  String result="<!doctype html>\n" +
"<html>\n" +
"<head>\n" +
"<meta charset=\"utf-8\">\n" +
"<title>Untitled Document</title>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"hom.css\">\n" +
"<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js\"></script>\n" +"<style>\n" +
"#n1\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:0px;\n" +
"		background:#6D1635;\n" +
"		left:1px;\n" +
"		width:1364px;\n" +
"		height:100px;\n" +
"	}\n" +
"#jj\n" +
"	{\n" +
"		position:absolute;\n" +
"		top:81px;\n" +
"		background:#030;\n" +
"		left:1px;\n" +
"		text-align:center;\n" +
"		color:#F09;\n" +
"		font-size:25px;\n" +
"		width:1364px;\n" +
"		height:46px;\n" +
"	}\n" +
"#n2\n" +
"	{\n" +
"		position:absolute;\n" +
"		left:5px;\n" +
"		top:120px;\n" +
"		width:1355px;\n" +
"		height:60px;\n"  +
"		text-align:center;\n" +
"		font-size:20px;\n" +
"		color:#62224A;\n" +
"	}\n" +
"#n3\n" +
"{\n" +
"	font-size:30px;\n" +
"	color:#003;\n" +
"	font-weight:bold;\n" +
"}\n"  +
"</style>\n"+
"</head>\n" +
"\n" +
"<body>\n" +
"<div id=\"t1\">\n" +
"<p id=\"e1\">brightentreatment123@gmail.com</p>\n" +
"<img id=\"pn\" src=\"g.png\">\n" +
"<div class=\"t2\">\n" +
"<p id=\"e2\">Brighten</p>\n" +
"<p id=\"e3\">Treatments</p>\n" +
"<p class=\"p1\"><b><a href=\"doctor.html\">HOME</a></p>\n" +
"<p class=\"p2\"><a href=\"service.html\">SERVICES</a></p>\n" +
"<p class=\"p3\"><a href=\"dt.html\">DOCTORS</a></p>\n" +
"<p class=\"p4\"><a href=\"blog.html\">BLOGS</a></p>\n" +
"<p class=\"p5\"><a href=\"contact.html\">CONTACTUS</a></b></p>\n" +
"\n" +
"<a href=\"login-2.html\"><input type=\"submit\" class=\"b1\" value=\"Show Appointment\"></a>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"</div>\n" +
"";
  result+="<table id=n2 cellpadding=10 cellspacing=5><tr id=n3><td>NAME</td><td>EMAIL ID</td><td>MOBILE</td><td>DOA</td><td>SYMPTOMS</td></tr>";

  String uid=req.getParameter("uid");
  String pwd=req.getParameter("pwd");
  
  PrintWriter out=res.getWriter();
 try{  
     
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");  
                               
PreparedStatement ps=con.prepareStatement("select * from DOCTOR where id=?");  
ps.setString(1,uid);
   ResultSet rs=ps.executeQuery();
   
    if(rs.next())
      {
          
 String pass=rs.getString(2);
 if(pwd.equals(pass))
    {
        String nm=rs.getString(3);
        PreparedStatement ps1=con.prepareStatement("select * from PATIENT where dr=?");  
ps1.setString(1,nm);
   ResultSet rs1=ps1.executeQuery();
    while(rs1.next())
    {
        String nam=rs1.getString(1);
        String mail=rs1.getString(2);
        String mob=rs1.getString(3);
        String doa=rs1.getString(4);
        String sym=rs1.getString(6);
        result+="<tr><td>"+nam+"</td><td>"+mail+"</td><td>"+mob+"</td><td>"+doa+"</td><td>"+sym+"</td></tr>";
        
    }
    }
   // JOptionPane.showMessageDialog(null,"You are  registered now !");
}
    result+="</table></body></html>";
   out.println(result);
 }catch(Exception e){} }

}