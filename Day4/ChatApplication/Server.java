package com.prathis.ChatApplication;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server listening on port 5000...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String clientMessage = reader.readLine();
                if(clientMessage.equals("quit")){
                	break;
                }
                System.out.println("Client: " + clientMessage);
                

                System.out.print("Server: ");
                String serverMessage = consoleReader.readLine();
                writer.write(serverMessage + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
