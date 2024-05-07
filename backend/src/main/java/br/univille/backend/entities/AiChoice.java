package br.univille.backend.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AiChoice {
    

    public int BuyFromDeskPileOrDeck(Deck deck, DeskPile deskPile,Player player){
        int menorPeso = 0;
        Combinations getCombinations = new Combinations();
        List<List<Cards>> combinations = getCombinations.generateCombinations(player.getCards(),3);
        
        // System.out.println("qtd de combinações"+combinations.size());
        // System.out.println(player.viewAllCards());
        List<Cards> cards = Arrays.asList(player.getCards());
        // List<Cards> listCards = ;
        for (int i = 0; i < cards.size(); i++) {

            if (cards.get(i) == null){
                continue;
            }
        //    System.out.println("cartas: "+ cards.get(i));
           verificaSequencia(cards, cards.get(i));
           verificaCombinação(cards, cards.get(i));
           if (i == 0){
                menorPeso = cards.get(i).getPeso();
            }
           if (cards.get(i).getPeso() <= menorPeso){
                menorPeso = cards.get(i).getPeso();
           }
            //System.out.println("Possui sequencia: "+ verificaSequencia(cards, cards.get(i)));
            // System.out.println("tem combinações de numeros: "+ verificaCombinação(cards, cards.get(i)));
            // System.out.println("Peso: "+ cards.get(i).getPeso());
        }
        verificaSequencia(cards, deskPile.top());
        verificaCombinação(cards, deskPile.top());
        if (deskPile.top().getPeso() > menorPeso){
            return 1;
        }
        else{
            return 0;
        }
            
    }

    public boolean verificaSequencia(List<Cards> cartas, Cards cartaAtual) {
        for (int i = 0; i < cartas.size() - 1; i++) {
            Cards proximaCarta = cartas.get(i + 1);
            if (proximaCarta == null || cartaAtual == null){
                continue;
            }
            if (cartaAtual.getNaipe().equals(proximaCarta.getNaipe())) {
                int valorAtual = cartaAtual.getSequencia();
                int proximoValor = proximaCarta.getSequencia();

                if (Math.abs(valorAtual - proximoValor) <= 2 && Math.abs(valorAtual - proximoValor) > 0 ) {
                    cartaAtual.setPeso(1);
                    return true; // Sequência encontrada
                }
            }
        }
        return false; // Nenhuma sequência encontrada
    }

    public  boolean verificaCombinação(List<Cards> cartas, Cards cartaAtual) {
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i) == null){
                continue;
            }
            if (Math.abs(cartas.get(i).getSequencia() - cartaAtual.getSequencia()) == 0 && cartas.get(i).getNaipe() != cartaAtual.getNaipe()) {
                cartaAtual.setPeso(1);
                return true; // Combinação encontrada
            }
        }
        return false; // Nenhuma combinação encontrada
    }



}
