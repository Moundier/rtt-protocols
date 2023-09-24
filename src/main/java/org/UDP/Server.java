package org.UDP;

import java.io.IOException;
import java.net.*;

public class Server {
  public static void main(String[] args) throws IOException {
    final int port = 8080;
    DatagramSocket socket = new DatagramSocket(port);

    // Create a buffer for receiving data
    byte[] receiveData = new byte[100];

    // Wait for "Ping" from the client
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    socket.receive(receivePacket);
    String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
    System.out.println("[Server received]: " + receivedData);

    // Respond to the client with "Pong"
    String pongMessage = "Pong";
    byte[] sendData = pongMessage.getBytes();
    InetAddress clientAddress = receivePacket.getAddress();
    int clientPort = receivePacket.getPort();
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
    socket.send(sendPacket);

    socket.close();
  }
}
