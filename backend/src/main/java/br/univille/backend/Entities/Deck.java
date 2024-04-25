package br.univille.backend.Entities;

import java.util.ArrayList;
import java.util.Random;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Deck {

    private ArrayList<Cards> deck = new ArrayList<Cards>();
    
    public void deckLaunch(){
        File file = new File("src/main/resources/jsonCartas.json");
        try (JsonReader reader = Json.createReader(new FileReader(file.getAbsolutePath()))){
            // Lê o JSON em um objeto JsonObject
            JsonArray cartas = reader.readArray();

            // Percorre cada objeto no array JSON
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                // Obtém o número e o naipe da carta
                String numero = carta.getString("numero");
                String naipe = carta.getString("naipe");
                Cards newCard = new Cards(naipe, numero);
                addCard(newCard);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Cards cardsDistribute(int index){
        Cards card = deck.get(index);
        deck.get(index).setDisponivel(false);
        return card;
    }
    
    public void addCard(Cards card) {
        this.deck.add(card);
    }

    public boolean cardIsAvailable(int index){
        return deck.get(index).isDisponivel();
    }
    
    public Cards deliveCards(){
        Random random = new Random();
        int countCards = 0;
        while (countCards < 53){
            int randomCardIndex = random.nextInt(53);
            if (cardIsAvailable(randomCardIndex)){
                Cards card = cardsDistribute(randomCardIndex);
                return card;
            }
            else {
                System.out.println("Carta está indisponivel: "+ cardsDistribute(randomCardIndex));
                countCards ++;
                continue;
            }
        }
        System.out.println("Todas as cartas estão indisponiveis");
        return cardsDistribute(countCards);
    }

    
}
