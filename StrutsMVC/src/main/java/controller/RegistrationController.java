package controller;

import beans.forms.RegistrationFormBean;
import model.PlayerManager;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegistrationFormBean regForm = (RegistrationFormBean) form;
        ConfigurableApplicationContext cap = (ConfigurableApplicationContext) request.getSession().getServletContext().getAttribute("cap");
        PlayerManager plManager = (PlayerManager) cap.getBean("playerManager");
        int id = plManager.registerPlayer(regForm.getName(), regForm.getAddress(), regForm.getEmail(), regForm.getGender(), regForm.getAge());
        form.reset(mapping, request);
        return mapping.findForward("success");
    }
}
