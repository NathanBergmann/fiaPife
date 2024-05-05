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
        System.out.println("Comprar carta da mesa (0) ou Comprar do monte (1)");
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
        System.out.println("Cartas Player: " + player.getName() + "\n"+ player.viewAllCards()+"\n");
        System.out.println("Escolha uma carta para descartar, utilize os numeros de 1 à 10");
        int positionCard = scanner.nextInt();
        deskPile.push(player.discardCard(positionCard -1));
    }
    
}
