package server.sub;

import java.net.ServerSocket;
import java.net.Socket;
import server.runner.ServerRun;

import java.io.*;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    public Server() {

    }

    public void setUpServer(int port) throws IOException, ClassNotFoundException {
        System.out.println("SERVER --");
        System.out.println("waiting for a client to connect...");
        this.serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = this.serverSocket.accept();
            Thread th = new Thread(new ServerRun(socket));
            th.start();
        }

    }

    public Socket getSocket() {
        return this.socket;
    }

    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }
}