package com.du.chatroom;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IDEA
 *
 * 发送端3
 *
 * @author duzhentong
 * @Date 2018/6/12
 * @Time 14:29
 */
public class Send3 {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress allAdress = InetAddress.getLocalHost();
            //设置连接到主聊天室的ip（这里是本机）
            InetAddress address = InetAddress.getByName("127.0.0.1");
            System.out.println("当前主机名："+allAdress.getHostName());
            System.out.println("当前ip地址："+allAdress.getHostAddress());
            while (true) {
                System.out.println("发送端发送消息:");
                Scanner sc = new Scanner(System.in);
                String mess = sc.next();
                byte[] buf = mess.getBytes("UTF-8");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 55523);
                socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
