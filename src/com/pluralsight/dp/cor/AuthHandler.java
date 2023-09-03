package com.pluralsight.dp.cor;

public class AuthHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(HttpRequest request) {
        if (!request.authenticated()) {
            System.out.println("Authenticate the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for the request.");
        }
    }
}
