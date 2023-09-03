package com.pluralsight.dp.cor;

public class ChainOfResponsibility {

    public static void main(String[] args) {

        AuthHandler authHandler = new AuthHandler();
        RequestHandler requestHandler = new RequestHandler();

        requestHandler.setNext(authHandler);

        requestHandler.handleRequest(new HttpRequest(true));
        requestHandler.handleRequest(new HttpRequest(false));
    }
}
