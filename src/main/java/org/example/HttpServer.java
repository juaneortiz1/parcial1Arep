package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 36000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            request.append(inputLine);
            if (!in.ready()) {
                break;
            }
        }

        System.out.println("Recibí: " + request.toString());

        StringBuilder response = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/index.html"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println();
        out.println(response.toString());

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}