package it.polimi.ingsw;

import it.polimi.ingsw.model.GameManager;
import it.polimi.ingsw.model.Mage;
import it.polimi.ingsw.model.ComplexLobby;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    // testing lobbies functionalities
    @Test
    public void TestSameID() {
        ArrayList<ComplexLobby> Lobbies = new ArrayList<ComplexLobby>();
        GameManager GM = new GameManager(Lobbies);
        boolean added = GM.login("Cole", 3, true);
        assertTrue("not added first player", added);
        added = GM.login("Leo", 3, true);
        assertTrue("not added player", added);
        added = GM.login("Cole", 3, true);
        assertFalse("added duplicate player Cole", added);

        // bastard phase:
        added = GM.login("Cole1", 3, true);
        assertTrue("added Cole", added);

        added = GM.login("Cole2", 3, true);
        assertTrue("added duplicate player Cole", added);

        added = GM.login("Cole3", 3, true);
        assertTrue("added duplicate player Cole", added);

        int nOFLobbies = Lobbies.size();
        assertTrue("Lobbies must be 2 but are " + nOFLobbies, nOFLobbies == 2);
    }

    @Test
    public void TestFullLobby() {
        ArrayList<ComplexLobby> Lobbies = new ArrayList<ComplexLobby>();
        GameManager GM = new GameManager(Lobbies);
        GM.login("Cole", 3, true);
        GM.login("Leo", 3, true);
        GM.login("Ale", 3, true);
        GM.login("Gian", 3, true);
    }

    @Test
    // testing deck requests
    public void TestLoginAndDeck() {
        ArrayList<ComplexLobby> Lobbies = new ArrayList<ComplexLobby>();
        GameManager GM = new GameManager(Lobbies);

        boolean added = GM.login("Cole", 3, true);
        assertTrue("not added first player", added);

        boolean decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Cole").getID(), Mage.MAGE1, "Cole");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Leo", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Leo").getID(), Mage.MAGE2, "Leo");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Ale", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Ale").getID(), Mage.MAGE3, "Ale");
        assertTrue("not added deck", decksuccess);

    }

    @Test
    public void TestLoginAndDeckMultipleLobbies() {
        ArrayList<ComplexLobby> Lobbies = new ArrayList<ComplexLobby>();
        GameManager GM = new GameManager(Lobbies);

        boolean added = GM.login("Cole", 3, true);
        assertTrue("not added first player", added);

        boolean decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Cole").getID(), Mage.MAGE1, "Cole");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Leo", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Leo").getID(), Mage.MAGE2, "Leo");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Ale", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Ale").getID(), Mage.MAGE3, "Ale");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Gian", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Gian").getID(), Mage.MAGE1, "Gian");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Pore", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(GM.getPlayerComplexLobby("Pore").getID(), Mage.MAGE2, "Pore");
        assertTrue("not added deck", decksuccess);

    }

    @Test
    public void TestLoginAndDuplicateDeck() {
        ArrayList<ComplexLobby> Lobbies = new ArrayList<ComplexLobby>();
        GameManager GM = new GameManager(Lobbies);

        boolean added = GM.login("Cole", 3, true);
        assertTrue("not added first player", added);

        boolean decksuccess = GM.deckRequest(0, Mage.MAGE1, "Cole");
        assertTrue("not added deck", decksuccess);

        added = GM.login("Leo", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(0, Mage.MAGE1, "Leo");
        assertFalse("added deck", decksuccess);

        added = GM.login("Ale", 3, true);
        assertTrue("not added player", added);

        decksuccess = GM.deckRequest(0, Mage.MAGE3, "Ale");
        assertTrue("not added deck", decksuccess);

    }


}
