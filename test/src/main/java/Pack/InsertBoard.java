package Pack;

import java.io.IOException;


import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class InsertBoard extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
<<<<<<< HEAD
      // 1. íŒŒë¼ë¯¸í„°ë¡œ ì „ì†¡ëœ ê°’ì„ ì–»ì–´ì˜¤ê¸°.
=======
      // 1. ÆÄ¶ó¹ÌÅÍ·Î Àü¼ÛµÈ °ªÀ» ¾ò¾î¿À±â.
>>>>>>> main
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String content= request.getParameter("content");
      HttpSession session = request.getSession();
      String wr = (String) session.getAttribute("memberId");
      int n=0;
      PreparedStatement pstmt = null;
      Connection con = null;

      try{
<<<<<<< HEAD
         // 2. ì „ì†¡ëœ ê°’ì„ dbì— ì €ì¥.
=======
         // 2. Àü¼ÛµÈ °ªÀ» db¿¡ ÀúÀå.
>>>>>>> main

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";
			
			con = DriverManager.getConnection(url, "root", "1234");
         String sql = "insert into boards values( ?,?,?,?, now() )";
         pstmt = con.prepareStatement(sql);
         pstmt.setNull(1, Types.INTEGER );
         pstmt.setString(2, title);
         pstmt.setString(3, content);
         pstmt.setString(4, wr);

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
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
      pw.println("<html>");
      pw.println("<head></head>");
      pw.println("<body>");
      if(n>0){
<<<<<<< HEAD
         pw.println( wr + "ë‹˜! ê²Œì‹œê¸€ì´ ì‘ì„±ë˜ì—ˆìŠµë‹ˆë‹¤.<br/>");
         pw.println("<a href='listboard.do'>ë©”ì¸í˜ì´ì§€ë¡œ ê°€ê¸°</a>");
      }else{
    	 pw.println("<script type=\"text/javascript\">");
    	 pw.println("alert('ì¡´ì¬í•˜ì§€ ì•ŠëŠ” ì•„ì´ë””ì…ë‹ˆë‹¤.');");
    	 pw.println("</script>");
         pw.println("ê²Œì‹œê¸€ ì‘ì„±ì— ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>ì´ì „í˜ì´ì§€ë¡œ ê°€ê¸°</a>");
=======
         pw.println( wr + "´Ô! °Ô½Ã±ÛÀÌ ÀÛ¼ºµÇ¾ú½À´Ï´Ù.<br/>");
         pw.println("<a href='listboard.do'>°Ô½Ã±Û ¸®½ºÆ®·Î °¡±â</a>");
      }else{
    	 pw.println("<script type=\"text/javascript\">");
    	 pw.println("alert('Á¸ÀçÇÏÁö ¾Ê´Â ¾ÆÀÌµğÀÔ´Ï´Ù.');");
    	 pw.println("</script>");
         pw.println("°Ô½Ã±Û ÀÛ¼º¿¡ ½ÇÆĞÇß½À´Ï´Ù.<br/>");
         pw.println("<a href='javascript:history.go(-1)'>ÀÌÀüÆäÀÌÁö·Î °¡±â</a>");
>>>>>>> main
      }
      pw.println("</body>");
      pw.println("</html>");
   }
}