package it.polimi.ingsw.model.cards.Characters;

import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.cards.CharacterCard;

public class Character2 extends CharacterCard {
    private int num;

    public Character2(int num) {
        this.num = num;
        super.setNum(num);
    }

    public void effect(Player activePlayer){
        //set an attribute in the activePlayer's schoolboard who indicates thad the character 2 is used.
        // in Game, the function colorDominance will take into account this boolean value to calculate
        // correctly the setting of professors.
        activePlayer.getSchoolBoard().setCharachter2used(true);
    }
}
