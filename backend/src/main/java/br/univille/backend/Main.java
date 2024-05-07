package br.univille.backend;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.id.uuid.LocalObjectUuidHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.univille.backend.entities.Cards;
import br.univille.backend.entities.Combinations;
import br.univille.backend.entities.Deck;
import br.univille.backend.entities.DeskPile;
import br.univille.backend.entities.Game;
import br.univille.backend.entities.Player;
import br.univille.backend.templates.DeskView;


public class Main {
	public static Player playerAI = new Player("The Best IA");
	public static Player playerOne = new Player("Desafiante");
	public static Deck deck = new Deck();
	public static boolean endGame = false;
	public static void main(String[] args){
		Game game = new Game();
		DeskPile deskPile = new DeskPile();

		deck.deckLaunch();
        DeskView view = new DeskView();
        Scanner scanner = new Scanner(System.in);

        System.out.println(view.textWelcome());
        
        System.out.print("Digite o nome do Jogador: ");
		playerOne.setName(scanner.nextLine());
		System.out.println("\nConfronto entre: \'"+playerOne.getName()+"\' X \'"+ playerAI.getName()+"\'");
		
		game.startRound(deck, deskPile, playerOne, playerAI);
		Combinations validator = new Combinations();
		boolean isAiTurn = true;
		
		while (!endGame){
			if (isAiTurn){
			
			}else{
			System.out.println("\nCartas Player: " + playerOne.getName() +"\n"+ playerOne.viewAllCards()+"\n");
			System.out.println("Comprar carta da mesa (0) ou Comprar do monte (1)");
			game.play(deck, deskPile, playerOne);
			System.out.println("Cartas Player: " + playerOne.getName() + "\n"+ playerOne.viewAllCards()+"\n");
        	System.out.println("Escolha uma carta para descartar, utilize os numeros de 1 à 10");
			game.discardCard(deck, deskPile, playerOne);
			endGame = validator.isWinner(playerOne.getCards());
			if (endGame){
				System.out.println(playerOne.getName()+ " ganhou!");
			}
			}
			
			isAiTurn = !isAiTurn;
		}


		scanner.close();

	}

}
