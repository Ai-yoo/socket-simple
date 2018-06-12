package com.du.test.tcp.test1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/6/11
 * @Time 18:28
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55523;
        ServerSocket server = new ServerSocket(port);
        System.out.println("server一直在等待消息");
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, len, "UTF-8"));
        }
        System.out.println(stringBuilder);
        server.close();
        socket.close();
        inputStream.close();

    }
}
