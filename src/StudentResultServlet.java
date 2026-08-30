import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");

        int javaMark = Integer.parseInt(request.getParameter("java"));
        int dbmsMark = Integer.parseInt(request.getParameter("dbms"));
        int webMark = Integer.parseInt(request.getParameter("web"));

        int total = javaMark + dbmsMark + webMark;
        double average = total / 3.0;

        String result;
        String grade;

        if (javaMark >= 40 && dbmsMark >= 40 && webMark >= 40) {

            result = "PASS";

            if (average >= 90)
                grade = "A+";
            else if (average >= 80)
                grade = "A";
            else if (average >= 70)
                grade = "B";
            else if (average >= 60)
                grade = "C";
            else
                grade = "D";

        } else {
            result = "FAIL";
            grade = "F";
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<title>Student Result</title>");

        // CSS generated directly by Servlet
        out.println("<style>");

        out.println("* { box-sizing: border-box; }");

        out.println("body {");
        out.println("margin: 0;");
        out.println("font-family: Arial, sans-serif;");
        out.println("background: #f2f5f9;");
        out.println("color: #222;");
        out.println("}");

        out.println(".container {");
        out.println("width: 90%;");
        out.println("max-width: 750px;");
        out.println("margin: 50px auto;");
        out.println("}");

        out.println(".card {");
        out.println("background: white;");
        out.println("padding: 35px;");
        out.println("border-radius: 15px;");
        out.println("box-shadow: 0 5px 20px rgba(0,0,0,0.12);");
        out.println("}");

        out.println("h1 {");
        out.println("text-align: center;");
        out.println("margin-bottom: 30px;");
        out.println("color: #1e293b;");
        out.println("}");

        out.println(".student-info {");
        out.println("background: #f8fafc;");
        out.println("padding: 18px;");
        out.println("border-radius: 10px;");
        out.println("margin-bottom: 25px;");
        out.println("}");

        out.println(".student-info p {");
        out.println("margin: 8px 0;");
        out.println("font-size: 16px;");
        out.println("}");

        out.println("table {");
        out.println("width: 100%;");
        out.println("border-collapse: collapse;");
        out.println("margin: 20px 0;");
        out.println("}");

        out.println("th {");
        out.println("background: #2563eb;");
        out.println("color: white;");
        out.println("padding: 14px;");
        out.println("}");

        out.println("td {");
        out.println("padding: 13px;");
        out.println("text-align: center;");
        out.println("border-bottom: 1px solid #ddd;");
        out.println("}");

        out.println("tr:nth-child(even) {");
        out.println("background: #f8fafc;");
        out.println("}");

        out.println(".summary {");
        out.println("display: grid;");
        out.println("grid-template-columns: 1fr 1fr;");
        out.println("gap: 15px;");
        out.println("margin-top: 25px;");
        out.println("}");

        out.println(".summary-box {");
        out.println("background: #f8fafc;");
        out.println("padding: 18px;");
        out.println("border-radius: 10px;");
        out.println("text-align: center;");
        out.println("}");

        out.println(".summary-box h3 {");
        out.println("margin: 5px;");
        out.println("font-size: 14px;");
        out.println("color: #64748b;");
        out.println("}");

        out.println(".summary-box p {");
        out.println("margin: 8px;");
        out.println("font-size: 22px;");
        out.println("font-weight: bold;");
        out.println("}");

        out.println(".pass {");
        out.println("color: #16a34a;");
        out.println("}");

        out.println(".fail {");
        out.println("color: #dc2626;");
        out.println("}");

        out.println(".grade {");
        out.println("color: #2563eb;");
        out.println("}");

        out.println(".back {");
        out.println("display: block;");
        out.println("width: 200px;");
        out.println("margin: 30px auto 0;");
        out.println("padding: 12px;");
        out.println("background: #2563eb;");
        out.println("color: white;");
        out.println("text-decoration: none;");
        out.println("text-align: center;");
        out.println("border-radius: 8px;");
        out.println("font-weight: bold;");
        out.println("}");

        out.println(".back:hover {");
        out.println("background: #1d4ed8;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<div class='card'>");

        out.println("<h1>Student Result</h1>");

        // Student information
        out.println("<div class='student-info'>");
        out.println("<p><b>Student Name:</b> " + name + "</p>");
        out.println("<p><b>Register Number:</b> " + regno + "</p>");
        out.println("</div>");

        // Marks table
        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Subject</th>");
        out.println("<th>Mark</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Java</td>");
        out.println("<td>" + javaMark + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>DBMS</td>");
        out.println("<td>" + dbmsMark + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Web Technology</td>");
        out.println("<td>" + webMark + "</td>");
        out.println("</tr>");

        out.println("</table>");

        // Result summary
        out.println("<div class='summary'>");

        out.println("<div class='summary-box'>");
        out.println("<h3>TOTAL</h3>");
        out.println("<p>" + total + " / 300</p>");
        out.println("</div>");

        out.println("<div class='summary-box'>");
        out.println("<h3>AVERAGE</h3>");
        out.println("<p>" + String.format("%.2f", average) + "%</p>");
        out.println("</div>");

        String resultClass = result.equals("PASS") ? "pass" : "fail";

        out.println("<div class='summary-box'>");
        out.println("<h3>RESULT</h3>");
        out.println("<p class='" + resultClass + "'>" + result + "</p>");
        out.println("</div>");

        out.println("<div class='summary-box'>");
        out.println("<h3>GRADE</h3>");
        out.println("<p class='grade'>" + grade + "</p>");
        out.println("</div>");

        out.println("</div>");

        out.println("<a class='back' href='index.html'>Enter Another Result</a>");

        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}