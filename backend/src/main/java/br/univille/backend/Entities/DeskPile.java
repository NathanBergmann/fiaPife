package br.univille.backend.Entities;

public class DeskPile {
    
    private Cards deskPile[] ;
    int topo;

    public DeskPile(){
        deskPile = new Cards[36];
        topo = -1;
    }
    public void push(Cards card){
        topo++;
        deskPile[topo] = card;
    }
    public Cards pop(){
        Cards card = deskPile[topo];
        topo--;
        return card;

    }
    public Cards top(){
        return deskPile[topo];
    }
    public boolean isEmpty(){
        return (topo == -1);
    }
    public boolean isFull(){
        return (topo == 35);
    }
}
