package design.behavioural.chainOfResp.eg2;

public class OrcCommander extends RequestHandler {
    public OrcCommander(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}