package com.du.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 21:48
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(55523);
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            InetAddress ip = packet.getAddress();
            int len = packet.getLength();
            System.out.println("接收端"+ip+"接收消息：");
            String str = new String(packet.getData(), 0, len, "UTF-8");
            System.out.println(str);
        }
    }
}
