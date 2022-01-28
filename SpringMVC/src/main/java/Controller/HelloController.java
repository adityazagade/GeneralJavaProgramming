package Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.HashMap;
import java.util.Map;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        Map<String, Object> map = new HashMap();
        map.put("msg", "hello " + fname + " " + lname);
        return new ModelAndView("success", map);
    }
}
