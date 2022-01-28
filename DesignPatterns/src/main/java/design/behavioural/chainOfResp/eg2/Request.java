package design.behavioural.chainOfResp.eg2;

import java.util.Objects;

public class Request {
    private final RequestType requestType;
    private final String requestDescription;
    boolean isProcessed;

    public Request(RequestType requestType, String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void markHandled() {
        this.isProcessed = true;
    }

    public boolean isHandled() {
        return this.isProcessed;
    }

    @Override
    public String toString() {
        return getRequestDescription();
    }
}
