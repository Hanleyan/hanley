package com.api.hanley.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hanley
 * @date 2019/7/17 11:32
 * 风萧萧兮易水寒
 */
public class GreetingClient {

    //GreetingClient 客户端程序
    //该程序通过socket连接到服务器并发送一个请求，然后等待一个响应
    public static void main(String[] args) {
        /*String serverName = args[0];
        int port = Integer.parseInt(args[1]);*/

        String serverName = "潘多拉服务器";
        int port = 1245;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("连接点主机："+serverName+",端口号："+port);

            Socket client = new Socket(serverName,port);
            System.out.println("远程主机地址："+client.getRemoteSocketAddress());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello form " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应："+in.readUTF());

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
