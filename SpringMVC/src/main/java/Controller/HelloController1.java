package Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloController1 extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        Map<String, Object> map = new HashMap();
        map.put("msg", "hello " + fname + " " + lname);
        return new ModelAndView("success", map);
    }
}
