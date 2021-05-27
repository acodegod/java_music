package cn.bugjava.demo02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getMusicurl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        String gqname = request.getParameter("name");
        String id = request.getParameter("rid");
        String json = null;
        if (gqname != null){
            String name = huoqurid.huoqu(gqname);
            System.out.println(name);
            String regex = "\"rid\":(.*?),\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            matcher.find();
            json = getRid.getMusicUrl(matcher.group(1));
        }
        if (json != null) {
            response.getWriter().write(json);
        }

        if (id != null) {
            response.getWriter().write(getRid.getMusicUrl(id));

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
