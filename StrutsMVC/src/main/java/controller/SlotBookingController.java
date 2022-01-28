package controller;

import beans.forms.SlotBookingFormBean;
import model.BookingManager;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SlotBookingController extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SlotBookingFormBean slotBookingForm = (SlotBookingFormBean) form;
        ConfigurableApplicationContext cap = (ConfigurableApplicationContext) request.getSession().getServletContext().getAttribute("cap");
        BookingManager bookingManager = (BookingManager) cap.getBean("bookingManager");
        int bookingId = bookingManager.bookSlot(slotBookingForm.getStadium(), slotBookingForm.getStartTime(), slotBookingForm.getEndTime());
        form.reset(mapping, request);
        return mapping.findForward("success");
    }
}
