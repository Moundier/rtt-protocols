package org.TCP;

import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {
    final String host = "localhost";
    final int port = 8080;
    long startTime = System.currentTimeMillis(); // Start timing
    runClient(host, port);
    long endTime = System.currentTimeMillis(); // Stop timing
    double rtt = (endTime - startTime) / 2.0;
    System.out.println("[Round-Trip Time]: " + rtt + "ms");
  }

  public static void runClient(String host, int port) throws IOException {
    // Client sends "Ping" and expects "Pong" in response
    Socket socket = new Socket(host, port);

    try (
      InputStream input = socket.getInputStream();
      OutputStream output = socket.getOutputStream();
    ) {

      // Send "Ping" to the server
      output.write("Ping".getBytes());

      // Receive and print the server's response
      byte[] response = new byte[100];
      int bytesRead = input.read(response);
      String responseData = new String(response, 0, bytesRead);
      System.out.println("[Client received]: " + responseData);
    } finally {
      socket.close();
    }
  }
}
