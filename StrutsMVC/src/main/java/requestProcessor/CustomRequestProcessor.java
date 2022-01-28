package requestProcessor;

import org.apache.struts.tiles.TilesRequestProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomRequestProcessor extends TilesRequestProcessor {

    @Override
    protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {

        // Struts 1.x framework can be extended in many ways. One of the way is creating custom (own) request processor.
        // Why we need to create custom request processor?. There may common tasks to be done on every request.
        // For example
        // 1)to check a user is logged in by checking the userName attribute in the session  before executing every request (i.e Validating user Session)
        // 2) Checking roles of a user whether the particular user has rights to access the particular action method
        // 3) capturing user activities in log table, etc.

        System.out.println("===== run preProcess on the request =======");
        //usually do security related stuff there. For the sake of practise, lets check a specific header is present in the request.
        String token = request.getHeader("magic-token");
        if (token!= null && token.equals("barbie")) {
            // hate this person. deny
            return false;
        }
        return super.processPreprocess(request, response);
    }
}
