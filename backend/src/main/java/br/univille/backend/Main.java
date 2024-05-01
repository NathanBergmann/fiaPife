package br.univille.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.univille.backend.Entities.*;
import br.univille.backend.templates.DeskView;
import java.util.Scanner;


@SpringBootApplication
public class Main {
	public static Player playerAI = new Player("The Best IA");
	public static Player playerOne = new Player("Desafiante");
	public static Deck deck = new Deck();
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
		
		System.out.println("Cartas Player: \n"+ playerAI.viewAllCards()+"\n");
		System.out.println("Cartas IA: \n"+playerOne.viewAllCards());

		

	}

}
