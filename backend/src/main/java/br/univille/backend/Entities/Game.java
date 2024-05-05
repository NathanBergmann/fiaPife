package br.univille.backend.entities;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public void startRound(Deck deck, DeskPile deskPile, Player player1, Player player2){
        deck.resetAvailable();
        deskPile.resetPile();
        for(int i=0; i< 9;){
            player1.setNewCard(deck.deliveCards());
            player2.setNewCard(deck.deliveCards());
            i ++;
        }
        deskPile.push(deck.deliveCards());
    }

    public void play(Deck deck, DeskPile deskPile,Player player){
        if(!deskPile.isEmpty()){
            System.out.println("\nCarta da mesa: " + deskPile.top().toString());
        }
        Cards newCard;
        int choice = scanner.nextInt();
        if (choice == 0){
            newCard = deskPile.pop();
            System.out.println("Jogador "+ player.getName() + " Comprou carta da mesa.");
        }
        else{
            newCard = deck.deliveCards();
            System.out.println("Jogador "+ player.getName() + " Comprou carta do Monte.");
        }
        player.setNewCard(newCard);
        return;
    }

    public void discardCard (Deck deck, DeskPile deskPile,Player player){
        int positionCard = scanner.nextInt();
        deskPile.push(player.discardCard(positionCard -1));
    }
    
}
