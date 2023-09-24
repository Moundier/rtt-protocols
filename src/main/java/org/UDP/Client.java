package org.UDP;

import java.io.IOException;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {
    final String host = "localhost";
    final int port = 8080;
    DatagramSocket socket = new DatagramSocket();

    // Send "Ping" to the server
    String pingMessage = "Ping";
    byte[] sendData = pingMessage.getBytes();
    InetAddress serverAddress = InetAddress.getByName(host);
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
    socket.send(sendPacket);

    // Start timing
    long startTime = System.currentTimeMillis();

    // Receive "Pong" from the server
    byte[] receiveData = new byte[100];
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    socket.receive(receivePacket);
    String responseData = new String(receivePacket.getData(), 0, receivePacket.getLength());
    System.out.println("[Client received]: " + responseData);

    // Stop timing
    long endTime = System.currentTimeMillis();
    double rtt = (endTime - startTime) / 2.0;
    System.out.println("[Round-Trip Time]: " + rtt + "ms");

    socket.close();
  }
}
