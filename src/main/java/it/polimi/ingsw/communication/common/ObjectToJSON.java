package it.polimi.ingsw.communication.common;

import com.google.gson.Gson;
import it.polimi.ingsw.communication.common.errors.ConnectionError;
import it.polimi.ingsw.communication.common.errors.LoginError;
import it.polimi.ingsw.communication.common.errors.MageError;
import it.polimi.ingsw.communication.common.errors.NoError;
import it.polimi.ingsw.communication.common.messages.*;

import java.io.*;
import java.net.Socket;

public class ObjectToJSON {
    private Socket socket;
    private DataOutputStream dataOutputStream;
    private PrintWriter output;
    private Gson gson;

    public ObjectToJSON(Socket socket) {
        this.socket = socket;
        try{
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            output = new PrintWriter(dataOutputStream, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gson = new Gson();
    }

    public void sendPingPongMessage(PingPongMessage pingPong){
        output.println(gson.toJson(pingPong));
    }

    public void sendConnectionError(){
        output.println(gson.toJson(new ConnectionError()));
    }

    public void sendLoginMessage(LoginMessage loginMessage){
        output.println(gson.toJson(loginMessage));
    }

    public void sendLoginError(){
        output.println(gson.toJson(new LoginError()));
    }

    public void sendNoError(){
        output.println(gson.toJson(new NoError()));
    }

    public void sendLobbiesMessage(LobbiesMessage lobbiesMessage){
        output.println(gson.toJson(lobbiesMessage));
    }

    public void sendMageMessage(MageMessage mageMessage){
        output.println(gson.toJson(mageMessage));
    }

    public void sendMageError(){
        output.println(gson.toJson(new MageError()));
    }

    public void sendPlayCardMessage(PlayCardMessage playCardMessage){output.println(gson.toJson(playCardMessage));}

    public void sendAssistantCardsMessage(AssistantCardsMessage assistantCardsMessage){output.println(gson.toJson(assistantCardsMessage));}

    public void sendModelMessage(ModelMessage modelMessage){output.println(gson.toJson(modelMessage));}

    public void sendMoveStudentsMessage(MoveStudentMessage moveStudentMessage){output.println(gson.toJson(moveStudentMessage));}






}
