package br.univille.backend.Entities;

public class Player {
    private String name;
    private int wins = 0;
    private Cards[] cards = new Cards[10];
    
    public Player(String name){
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addWins() {
        this.wins = this.wins +1;
    }

    public int getWins() {
        return wins;
    }
    
    public void setNewCard(){
    }

    public void getLastCardPlayed(){

    }

    public void calculateCombinations(){

    }

    public Cards[] getCards() {
        return cards;
    }
}
