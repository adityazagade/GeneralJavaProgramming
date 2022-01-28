package design.behavioural.chainOfResp;

//A concrete handler
public class Director extends Employee {

    public Director(LeaveApprover nextApprover) {
        super("Director", nextApprover);
    }

    @Override
    protected boolean processLeave(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.PTO) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }

}
