package br.univille.backend.entities;

import java.util.List;


public class AiChoice {
    

    public int BuyFromDeskPileOrDeck(Deck deck, DeskPile deskPile,Player player){
        int choice = 0;
        //System.out.println(deskPile.top());;
        Combinations getCombinations = new Combinations();
        List<List<Cards>> combinations = getCombinations.generateCombinations(player.getCards());
        
        for (List<Cards> combination : combinations) {
            System.out.println(combination);
        }
        /*  for (Cards cards  : player.getCards()) {
            
            System.out.println(cards);
        }*/
        return choice;
    }
}
