package design.behavioural.chainOfResp;

//A concrete handler
public class ProjectLead extends Employee {
    public ProjectLead(LeaveApprover successor) {
        super("ProjectLead", successor);
    }

    @Override
    protected boolean processLeave(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.Sick) {
            if (application.getNoOfDays() <= 2) {
                application.approve(getApproverRole());
                return true;
            }
        }
        return false;
    }
}
