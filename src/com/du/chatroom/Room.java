package com.du.chatroom;

import com.du.util.Time;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created with IDEA
 *
 * 聊天室
 *
 * @author duzhentong
 * @Date 2018/6/12
 * @Time 14:27
 */
public class Room {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(55523);
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                byte[] mess = packet.getData();
                InetAddress allAdress = packet.getAddress();
                //主机名
                String host = allAdress.getHostName();
                //ip
                String ip = allAdress.getHostAddress();
                int len = packet.getLength();
                System.out.println(host + "(" + ip + "):  " + Time.getTime());
                String str = new String(mess, 0, len, "UTF-8");
                System.out.println(str);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
