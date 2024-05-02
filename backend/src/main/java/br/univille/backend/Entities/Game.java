package br.univille.backend.Entities;

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
    }

    public void play(Deck deck, DeskPile deskPile,Player player){
        System.out.println("Comprar carta da mesa (0) ou Comprar do monte (1)");
        if(!deskPile.isEmpty()){
            System.out.println("Carta da mesa: " + deskPile.top().toString());
        }
        Cards newCard;
        int choice = scanner.nextInt();
        if (choice == 0){
            newCard = deskPile.pop();
        }
        else{
            newCard = deck.deliveCards();
        }
        player.setNewCard(newCard);
        return;
    }

    public void discardCard (Deck deck, DeskPile deskPile,Player player){
        System.out.println("Escolha uma carta para descartar, utilize os numeros de 1 à 10");
        int positionCard = scanner.nextInt();
        player.discardCard(positionCard -1);
        

    }
    
}
