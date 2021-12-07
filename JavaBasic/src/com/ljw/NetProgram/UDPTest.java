package com.ljw.NetProgram;


import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "abc";
        byte[] data = new byte[1024];
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);
        socket.send(packet);

        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
