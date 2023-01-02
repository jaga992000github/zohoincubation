package json;

/**
 * Servlet implementation class Iman
 */
//@WebServlet("/Iman")
//public class Iman extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		var url="login?a="+a+"&b="+b;
//		const request=new XMLHttpRequest();
//		var value;
//		try {
//			alert("try");
//			request.open("POST",url,true);
//			request.send();
//			alert("djksfs");
//			request.onreadystatechange=function(){
//				if(request.readyState==4){
//					value=JSON.parse(request.responseText);
//					console.log(value);
//				}
//			}
//
//		}
//	}
//}try {
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","Immanuvel*27");
//	Statement st=con.createStatement();
//	ResultSet rs=st.executeQuery("select * from admin where email='"+a+"' and password='"+b+"' ");
//	if(rs.next()) {
//		user u=new user();
//		u.setUname(a);
//		u.setPass(b);
//		String uString=new Gson().toJson(u);
//		out.write(uString);
//	}else {
//		response.sendRedirect("login.html");
//	}
//} catch (Exception e) {
//	// TODO: handle exception
//}