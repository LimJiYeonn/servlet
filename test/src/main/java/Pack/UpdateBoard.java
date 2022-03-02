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

public class UpdateBoard extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
<<<<<<< HEAD
		// 1. parameterÎ°ú Ï†ÑÏÜ°Îêú idÏñªÍ∏∞.
		Integer num = Integer.parseInt(req.getParameter("num"));

		// 2. idÏóê Ìï¥ÎãπÌïòÎäî Ï†ïÎ≥¥Î•º dbÏóêÏÑú Ï°∞ÌöåÌï¥ÏÑú Ï∂úÎ†•.
=======
		// 1. parameter∑Œ ¿¸º€µ» idæÚ±‚.
		Integer num = Integer.parseInt(req.getParameter("num"));

		// 2. idø° «ÿ¥Á«œ¥¬ ¡§∫∏∏¶ dbø°º≠ ¡∂»∏«ÿº≠ √‚∑¬.
>>>>>>> main
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>    <style>\r\n"
				+ "      * {\r\n"
				+ "        font-size: 16px;\r\n"
				+ "        font-family: Consolas, sans-serif;\r\n"
				+ "      }\r\n"
				+ "    </style></head>");
		pw.println("<body>");

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs=null;
		try{
<<<<<<< HEAD
			// 2. Ï†ÑÏÜ°Îêú Í∞íÏùÑ dbÏóê Ï†ÄÏû•.
=======
			// 2. ¿¸º€µ» ∞™¿ª dbø° ¿˙¿Â.
>>>>>>> main


			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test?&useSSL=false";

			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "select * from boards where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

<<<<<<< HEAD
			//sqlÍµ¨Î¨∏ Ïã§ÌñâÌïòÍ∏∞
=======
			//sql±∏πÆ Ω««‡«œ±‚
>>>>>>> main
			rs = pstmt.executeQuery();
			rs.next();
			String title = rs.getString("title");
			String content=rs.getString("content");
			String wr = rs.getString("wr");
			System.out.println(content);
			
			pw.println("<div class=\"container\">");
			//pw.println("<div class='container'>");
			pw.println("<form method='post' action='updateokboard.do'>");
			
			pw.println("<input type='hidden' name='num' value='" + num + "'/>");
<<<<<<< HEAD
			pw.println("Í∏Ä Î≤àÌò∏<input type='text' name='num' value='" + num + "' disabled='disabled'/><br/>");
			
			//pw.println("<input type='hidden' name='wr' value='" + wr + "'/>");
			pw.println("ÏûëÏÑ±Ïûê <input type='text' name='wr' value='" + wr + "' disabled='disabled'/><br/>");
			
			pw.println("Ï†úÎ™©  <input type='text' name='title' value='" + title + "'/><br/>");
			pw.println("<textarea rows='10' type='text' name='content'>"+ content +"</textarea><br/>");
			pw.println("<input type='submit' value='Ï†ÄÏû•'/><br/>");
=======
			pw.println("±€ π¯»£<input type='text' name='num' value='" + num + "' disabled='disabled'/><br/>");
			
			//pw.println("<input type='hidden' name='wr' value='" + wr + "'/>");
			pw.println("¿€º∫¿⁄ <input type='text' name='wr' value='" + wr + "' disabled='disabled'/><br/>");
			
			pw.println("¡¶∏Ò  <input type='text' name='title' value='" + title + "'/><br/>");
			pw.println("<textarea rows='10' type='text' name='content'>"+ content +"</textarea><br/>");
			pw.println("<input type='submit' value='¿˙¿Â'/><br/>");
>>>>>>> main
			pw.println("</form>");
			pw.println("</div>");
			
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