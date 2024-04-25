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
		player.setNewCard(deck.deliveCards());
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

		System.out.println(playerAI.getCards());
		// game.startGame();
		/*Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o nome do Primeiro Jogador: ");
		namePlayer = scanner.nextLine();
		Player player1 = new Player(namePlayer);
		Player iaPlayer = new Player("IA");
		*/
		/*
		Cards[] mao1 = new Cards[9];
		Cards[] mao2 = new Cards[9];
		
		System.out.println("---------------");
		for(int i=0; i< 9;){
			mao2[i] = deck.deliveCards();
			System.out.println(mao2[i]);
			i ++;
		}
*/

	}

}
