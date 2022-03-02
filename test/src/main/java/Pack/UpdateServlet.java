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



public class UpdateServlet extends HttpServlet{

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {
<<<<<<< HEAD

		// 1. parameterë¡œ ì „ì†¡ëœ idì–»ê¸°.

		String id=req.getParameter("id");

		

		// 2. idì— í•´ë‹¹í•˜ëŠ” ì •ë³´ë¥¼ dbì—ì„œ ì¡°íšŒí•´ì„œ ì¶œë ¥.

		resp.setContentType("text/html;charset=euc-kr");
=======

		// 1. parameter·Î Àü¼ÛµÈ id¾ò±â.

		String id=req.getParameter("id");

		

		// 2. id¿¡ ÇØ´çÇÏ´Â Á¤º¸¸¦ db¿¡¼­ Á¶È¸ÇØ¼­ Ãâ·Â.

		resp.setContentType("text/html;charset=UTF-8");
>>>>>>> main

		PrintWriter pw = resp.getWriter();

		pw.println("<html>");

		pw.println("<head></head>");

		pw.println("<body>");

		

		PreparedStatement pstmt = null;

		Connection con = null;

		ResultSet rs=null;

		try{

<<<<<<< HEAD
			// 2. ì „ì†¡ëœ ê°’ì„ dbì— ì €ìž¥.

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

			con = DriverManager.getConnection(url, "root", "1234");

=======
			// 2. Àü¼ÛµÈ °ªÀ» db¿¡ ÀúÀå.

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://18.205.188.103:3306/test?&useSSL=false";
		     con = DriverManager.getConnection(url, "lion", "1234");
			
//			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";
//			con = DriverManager.getConnection(url, "root", "1234");
>>>>>>> main
			

			String sql = "select * from members where id=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			

<<<<<<< HEAD
			//sqlêµ¬ë¬¸ ì‹¤í–‰í•˜ê¸°
=======
			//sql±¸¹® ½ÇÇàÇÏ±â
>>>>>>> main

			rs = pstmt.executeQuery();

			rs.next();

			String pwd = rs.getString("pwd");

			String email=rs.getString("email");

			String phone=rs.getString("phone");

			

			pw.println("<form method='post' action='updateok.do'>");

			pw.println("<input type='hidden' name='id' value='" + id + "'/>");

<<<<<<< HEAD
			pw.println("ì•„ì´ë””<input type='text' name='id' value='" + id + "' disabled='disabled'/><br/>");

			pw.println("ë¹„ë°€ë²ˆí˜¸<input type='text' name='pwd' value='" + pwd + "'/><br/>");
=======
			pw.println("¾ÆÀÌµð<input type='text' name='id' value='" + id + "' disabled='disabled'/><br/>");

			pw.println("ºñ¹Ð¹øÈ£<input type='text' name='pwd' value='" + pwd + "'/><br/>");
>>>>>>> main

			pw.println("email<input type='text' name='email' value='" + email + "'/><br/>");

			pw.println("phone<input type='text' name='phone' value='" + phone + "'/><br/>");

<<<<<<< HEAD
			pw.println("<input type='submit' value='ì €ìž¥'/><br/>");
=======
			pw.println("<input type='submit' value='ÀúÀå'/><br/>");
>>>>>>> main

			pw.println("</form>");

			

		}catch(ClassNotFoundException ce){

			System.out.println(ce.getMessage());

		}catch(SQLException se){

			System.out.println(se.getMessage());

		}finally{

			try{

				if(rs!=null) rs.close();

				if(pstmt!=null) pstmt.close();

				if(con!=null) con.close();

			}catch(SQLException se){

				System.out.println(se.getMessage());

			}

		}

		

		pw.println("</body>");

		pw.println("</html>");

		pw.close();

	}

}