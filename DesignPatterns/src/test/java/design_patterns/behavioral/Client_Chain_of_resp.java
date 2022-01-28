package design_patterns.behavioral;

import design.behavioural.chainOfResp.Director;
import design.behavioural.chainOfResp.LeaveApplication;
import design.behavioural.chainOfResp.LeaveApprover;
import design.behavioural.chainOfResp.Manager;
import design.behavioural.chainOfResp.ProjectLead;
import design.behavioural.chainOfResp.eg2.OrcCommander;
import design.behavioural.chainOfResp.eg2.OrcOfficer;
import design.behavioural.chainOfResp.eg2.OrcSoldier;
import design.behavioural.chainOfResp.eg2.Request;
import design.behavioural.chainOfResp.eg2.RequestHandler;
import design.behavioural.chainOfResp.eg2.RequestType;

import java.time.LocalDate;

public class Client_Chain_of_resp {
    public static void main(String[] args) {
        LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.Sick)
                .from(LocalDate.now())
                .to(LocalDate.of(2020, 12, 22))
                .build();
        System.out.println("*******************");


        //create chain of leave approvers
        LeaveApprover lv = createChain();

        lv.processLeaveApplication(application);

        System.out.println(application);

        System.out.println("*********** ORCS EXAMPLE *************");
        OrcKing king = new OrcKing();
        king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle")); // Orc commander handling request "defend castle"
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner")); // Orc officer handling request "torture prisoner"
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax")); // Orc soldier handling request "collect tax"

    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead projectLead = new ProjectLead(manager);
        return projectLead;
    }

    static class OrcKing {
        RequestHandler chain;

        public OrcKing() {
            buildChain();
        }

        private void buildChain() {
            chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
        }

        public void makeRequest(Request req) {
            chain.handleRequest(req);
        }
    }
}
