package br.univille.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.univille.backend.Entities.*;
import java.util.Scanner;

@SpringBootApplication
public class Main {
	private static String namePlayer;

	public static void main(String[] args){
		/*Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o nome do Primeiro Jogador: ");
		namePlayer = scanner.nextLine();
		Player player1 = new Player(namePlayer);
		Player iaPlayer = new Player("IA");
		*/		
		Cards carta;
		Deck deck = new Deck();
		
		deck.deckLaunch();
		for(int i=0; i< 10;){
			System.out.println(deck.deliveCards());
			i ++;
		}
	}

}
