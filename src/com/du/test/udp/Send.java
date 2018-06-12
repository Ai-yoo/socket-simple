package com.du.test.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 21:34
 */
public class Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address =InetAddress.getByName("192.168.182.1");
        while (true) {
            System.out.println("发送端发送消息:");
            Scanner sc = new Scanner(System.in);
            String mess = sc.next();
            byte[] buf = mess.getBytes("UTF-8");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 55523);
            socket.send(packet);
        }
    }
}
