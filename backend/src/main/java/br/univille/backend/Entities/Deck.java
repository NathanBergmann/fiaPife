package br.univille.backend.Entities;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Cards> deck = new ArrayList<Cards>();
    private Cards card;
    public Deck(){}

    public Cards cardsDistribute(int index){
        Cards card = deck.get(index);
        deck.get(index).setDisponivel(false);
        return card;
    }
    public void addCard() {
        this.deck.add(this.card);
    }
}
