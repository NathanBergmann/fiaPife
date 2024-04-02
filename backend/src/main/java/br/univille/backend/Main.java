package br.univille.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.univille.backend.Entities.Player;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Player player1 =  new Player("nathan");

		System.out.println(player1.getName());
		player1.addWins();
		System.out.println("QTD Wins: "+ player1.getWins());
	}

}
