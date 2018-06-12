package com.du.test.tcp.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 18:44
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 55523;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, len, "UTF-8"));
        }
        System.out.println("get message from server: " + stringBuilder);
        inputStream.close();
        inputStream.close();
        socket.close();
//        InetAddress ip = InetAddress.getLocalHost();
//        System.out.println(ip);
    }
}
