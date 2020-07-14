import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {

    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, NullPointerException {

        counter++;

        String reset = request.getParameter("reset");

//        if(reset.equals("true") || reset.equals("yes")){
//            counter = 0;
//        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>This page has been visited " + counter + " times.</h1>");

    }
}
