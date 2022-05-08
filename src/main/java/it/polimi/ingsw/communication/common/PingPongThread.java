package it.polimi.ingsw.communication.common;

import it.polimi.ingsw.communication.common.messages.PingPongMessage;
import it.polimi.ingsw.communication.server.ServerThread;
import it.polimi.ingsw.controller.ComplexLobby;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PingPongThread extends Thread{
    private final Socket socket;
    private  ServerThread serverThread;
    private ObjectToJSON sendMessage;

    public PingPongThread(Socket socket, String host, ServerThread serverThread) {
        this.socket = socket;
        this.serverThread = serverThread;
        sendMessage = new ObjectToJSON(socket);

        startThread(host);
    }

    public PingPongThread(Socket socket, String host){
        this.socket = socket;
        startThread(host);
    }

    private void startThread(String host){
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if(host.equals("server")){
                    try{
                        if(socket.getInetAddress().isReachable( 5000)){
                            //System.out.println("Is reachable.\r");

                        } else {
                            System.out.println("Is not reachable.\r");
                            serverThread.closeConnection();
                        }
                        if(socket.isClosed()){
                            System.out.println("Is not reachable.\r");
                            serverThread.closeConnection();
                        }
                    } catch (IOException e) {
                        serverThread.closeConnection();
                        e.printStackTrace();
                    }
                } else if (host.equals("client")){
                    try{
                        if(socket.getInetAddress().isReachable( 5000)){
                            //System.out.println("Is reachable.\r");
                        } else {
                            //System.out.println("Is not reachable.\r");
                            System.out.println("Connection lost.\r");
                            socket.close();
                        }
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        }, 0, 10, TimeUnit.SECONDS);
    }
}


