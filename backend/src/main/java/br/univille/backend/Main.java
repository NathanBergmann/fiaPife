package br.univille.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.univille.backend.entities.*;
import br.univille.backend.templates.DeskView;
import java.util.Scanner;


@SpringBootApplication
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
		
		while (!endGame){
			System.out.println("\nCartas Player: " + playerOne.getName() +"\n"+ playerOne.viewAllCards()+"\n");
			System.out.println("Comprar carta da mesa (0) ou Comprar do monte (1)");
			game.play(deck, deskPile, playerOne);
			System.out.println("Cartas Player: " + playerOne.getName() + "\n"+ playerOne.viewAllCards()+"\n");
        	System.out.println("Escolha uma carta para descartar, utilize os numeros de 1 à 10");
			game.discardCard(deck, deskPile, playerOne);

			
			// System.out.println("Cartas Player: \n"+ playerOne.viewAllCards()+"\n");
			//Logica da IA
		/*	game.play(deck, deskPile, playerOne);
			game.discardCard(deck, deskPile, playerAI);
			System.out.println("Cartas Player: \n"+ playerAI.viewAllCards()+"\n");
*/
		}


		System.out.println("Cartas IA: \n"+playerOne.viewAllCards());

		

	}

}
