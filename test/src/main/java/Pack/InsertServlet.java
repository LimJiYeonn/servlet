package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
<<<<<<< HEAD
      // 1. íŒŒë¼ë¯¸í„°ë¡œ ì „ì†¡ëœ ê°’ì„ ì–»ì–´ì˜¤ê¸°.
=======
      // 1. ÆÄ¶ó¹ÌÅÍ·Î Àü¼ÛµÈ °ªÀ» ¾ò¾î¿À±â.
>>>>>>> main
      request.setCharacterEncoding("UTF-8");
      String id = request.getParameter("id");
      String pwd= request.getParameter("pwd");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");      

      int n=0;
      PreparedStatement pstmt2 = null;
      PreparedStatement pstmt = null;
      Connection con = null;
      ResultSet rs = null;

      try{
<<<<<<< HEAD
         // 2. ì „ì†¡ëœ ê°’ì„ dbì— ì €ì¥.
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";
         con = DriverManager.getConnection(url, "root", "1234");
=======
         // 2. Àü¼ÛµÈ °ªÀ» db¿¡ ÀúÀå.
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
	     con = DriverManager.getConnection(url, "lion", "1234");
         
//			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";
//			con = DriverManager.getConnection(url, "root", "1234");
>>>>>>> main
         
         String checksql = "select * from members where id=?";
         pstmt2 = con.prepareStatement(checksql);
         pstmt2.setString(1, id);
         rs = pstmt2.executeQuery();
         while(rs.next()) {
            if(rs.getString(1).equals(id) == true) {
               pw.println("<html>");
               pw.println("<head></head>");
               pw.println("<body>");
<<<<<<< HEAD
               pw.println("ì•„ì´ë””ì¤‘ë³µ ì¸í•´ ê°€ì…ì— ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.<br/>");
               pw.println("<a href='javascript:history.go(-1)'>ì´ì „í˜ì´ì§€ë¡œ ê°€ê¸°</a>");
=======
               pw.println("¾ÆÀÌµğÁßº¹ ÀÎÇØ °¡ÀÔ¿¡ ½ÇÆĞÇß½À´Ï´Ù.<br/>");
               pw.println("<a href='javascript:history.go(-1)'>ÀÌÀüÆäÀÌÁö·Î °¡±â</a>");
>>>>>>> main
               pw.println("</body>");
               pw.println("</html>");
               pstmt2.close();
               rs.close();
               return;
            }
            pstmt2.close();
            rs.close();
         }
         
         String sql = "insert into members values( ?,?,?,?, now() )";
            
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.setString(2, pwd);
         pstmt.setString(3, email);
         pstmt.setString(4, phone);

<<<<<<< HEAD
         //sqlêµ¬ë¬¸ ì‹¤í–‰í•˜ê¸°
=======
         //sql±¸¹® ½ÇÇàÇÏ±â
>>>>>>> main
         n=pstmt.executeUpdate();


      }catch(ClassNotFoundException ce){
         System.out.println(ce.getMessage());
      }catch(SQLException se){
         System.out.println(se.getMessage());
      }finally{
         try{
            if(pstmt!=null) pstmt.close();
            if(con!=null) con.close();
         }catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }

<<<<<<< HEAD
      // 3. ì‚¬ìš©ì(í´ë¼ì´ì–¸íŠ¸)ì— ê²°ê³¼ë¥¼ ì‘ë‹µí•˜ê¸°.
=======
      // 3. »ç¿ëÀÚ(Å¬¶óÀÌ¾ğÆ®)¿¡ °á°ú¸¦ ÀÀ´äÇÏ±â.
>>>>>>> main
      pw.println("<html>");
      pw.println("<head></head>");
      pw.println("<body>");

      if(n>0){
<<<<<<< HEAD
         pw.println( id + "ë‹˜! ì„±ê³µì ìœ¼ë¡œ ê°€ì…ë˜ì—ˆìŠµë‹ˆë‹¤.<br/>");
         pw.println("<a href='index.html'>ë©”ì¸í˜ì´ì§€ ì´ë™</a>");

      }else{
         pw.println("ì˜¤ë¥˜ë¡œ ì¸í•´ ê°€ì…ì— ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>ì´ì „í˜ì´ì§€ë¡œ ê°€ê¸°</a>");
=======
         pw.println( id + "´Ô! ¼º°øÀûÀ¸·Î °¡ÀÔµÇ¾ú½À´Ï´Ù.<br/>");
         pw.println("<a href='index.html'>¸ŞÀÎÆäÀÌÁö ÀÌµ¿</a>");

      }else{
         pw.println("¿À·ù·Î ÀÎÇØ °¡ÀÔ¿¡ ½ÇÆĞÇß½À´Ï´Ù.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>ÀÌÀüÆäÀÌÁö·Î °¡±â</a>");
>>>>>>> main
      }   
      pw.println("</body>");
      pw.println("</html>");
   }

}