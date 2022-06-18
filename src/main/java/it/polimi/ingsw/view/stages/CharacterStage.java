package it.polimi.ingsw.view.stages;

import it.polimi.ingsw.communication.client.ClientMain;
import it.polimi.ingsw.communication.common.messages.ModelMessage;
import it.polimi.ingsw.view.ActionController;
import it.polimi.ingsw.view.CharacterInfoController;
import it.polimi.ingsw.view.ClientApp;
import it.polimi.ingsw.view.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterStage {
    public CharacterStage(ClientMain client, int num, int choice, ModelMessage model, ActionController actionController) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApp.class.getResource("/CharacterInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage subStage = new Stage () ;
        subStage.setTitle ("CharacterEffect") ;
        CharacterInfoController controller = fxmlLoader.getController();
        controller.setClientMain(client);
        controller.init(num, choice, model);
        controller.setActionController(actionController);
        subStage.setResizable(false);
        subStage.setScene(scene);
        controller.setStage(subStage);
        subStage.show();
    }
}