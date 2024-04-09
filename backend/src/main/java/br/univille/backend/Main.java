package br.univille.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.univille.backend.Entities.*;

@SpringBootApplication
public class Main {

	public static void main(String[] args){
		Cards carta;
		Deck deck = new Deck();
		
		deck.deckLaunch();;
		

		carta = deck.cardsDistribute(13);
		System.out.println(carta.toString());

	}

}
