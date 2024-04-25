package br.univille.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.univille.backend.Entities.*;
import br.univille.backend.templates.DeskView;
import java.util.Scanner;


@SpringBootApplication
public class Main {
	public static Player playerAI = new Player("The Best IA");
	public static Player playerOne = new Player("Desafiante");
	

	public static void startGame(Player player){
		Deck deck = new Deck();
		deck.deckLaunch();
		for(int i=0; i< 9;){
			player.setNewCard(deck.deliveCards());
			i ++;
		}
	}

	public static void main(String[] args){
		// Game game = new Game();
        DeskView view = new DeskView();
        Scanner scanner = new Scanner(System.in);

        System.out.println(view.textWelcome());
        
        System.out.print("Digite o nome do Jogador: ");
		playerOne.setName(scanner.nextLine());
		System.out.println("\nConfronto entre: \'"+playerOne.getName()+"\' X \'"+ playerAI.getName()+"\'");
		
		startGame(playerAI);
		startGame(playerOne);

		System.out.println("Cartas Player: \n"+ playerAI.viewAllCards()+"\n");
		System.out.println("Cartas IA: \n"+playerOne.viewAllCards());
		

	}

}
