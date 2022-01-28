package design.behavioural.chainOfResp.eg2;

public class OrcSoldier extends RequestHandler {
    public OrcSoldier(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc soldier";
    }
}