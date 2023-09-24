// Server.java
package org.TCP;

import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws IOException {
    final int port = 8080;
    runServer(port);
  }

  public static void runServer(int port) throws IOException {
    // Server sends "Pong" in response to "Ping"
    ServerSocket serverSocket = new ServerSocket(port);
    Socket clientSocket = serverSocket.accept();

    try (InputStream input = clientSocket.getInputStream();
         OutputStream output = clientSocket.getOutputStream()) {

      // Waits for the Client "Ping"
      byte[] buffer = new byte[100];
      int bytesRead = input.read(buffer);
      String receivedData = new String(buffer, 0, bytesRead);
      System.out.println("[Server received]: " + receivedData);

      // Respond to the client with "Pong"
      output.write("Pong".getBytes());
    } finally {
      clientSocket.close();
      serverSocket.close();
    }
  }
}
