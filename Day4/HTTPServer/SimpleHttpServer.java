package com.prathis.HTTPServer;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        server.createContext("/", new MyHandler());

        server.start();
        System.out.println("Server started on port 8080");
    }


}
class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Get the headers from the request
        Map<String, List<String>> headers = exchange.getRequestHeaders();

        StringBuilder response = new StringBuilder();
        response.append("Server's Date & Time: ").append(dateTime).append("\n");
        response.append("Received Headers:\n");

        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            List<String> headerValues = entry.getValue();
            response.append(headerName+" : "+headerValues).append("\n");
        }

        exchange.getResponseHeaders().set("Content-Type", "text/plain");

        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(response.toString().getBytes());
        }
    }
}

