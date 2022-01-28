package plugin;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;

public class StrutsSpringPlugin implements PlugIn {
    ConfigurableApplicationContext cap;

    @Override
    public void destroy() {
        cap.close();
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        System.out.println("Initializing Struts Spring Plugin");
        cap = new ClassPathXmlApplicationContext("spring/spring.xml");
        servlet.getServletContext().setAttribute("cap", cap);
    }
}
