package com.pluralsight.dp.cor;

public interface Handler {

    void setNext(Handler nextHandler);

    void handleRequest(HttpRequest request);
}
