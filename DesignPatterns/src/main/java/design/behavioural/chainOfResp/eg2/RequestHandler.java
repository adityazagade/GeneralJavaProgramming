package design.behavioural.chainOfResp.eg2;

import java.util.logging.Logger;

public abstract class RequestHandler {
    private static final Logger LOGGER = Logger.getLogger(RequestHandler.class.getName());
    private final RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request req) {
        if (next != null) {
            next.handleRequest(req);
        }
    }

    protected void printHandling(Request req) {
        LOGGER.info("{" + this + "} handling request \"{ " + req + " }\"");
    }

    @Override
    public abstract String toString();
}
