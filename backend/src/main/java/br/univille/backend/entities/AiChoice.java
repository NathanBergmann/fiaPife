package br.univille.backend.entities;

import java.util.Arrays;
import java.util.List;


public class AiChoice {
    

    public int BuyFromDeskPileOrDeck(DeskPile deskPile,Player player){
           
        List<Cards> cards = Arrays.asList(player.getCards());
        int indexMenorPeso = encontraMenorPeso(cards);
        int menorPeso = cards.get(indexMenorPeso).getPeso();

        verificaSequencia(cards, deskPile.top());
        verificaCombinacao(cards, deskPile.top());

        if (deskPile.top().getPeso() > menorPeso){
            return 0;
        }
        else{
            return 1;
        }
            
    }

    public int encontraMenorPeso(List<Cards> cards){
        int indexMenorPeso = 0;
        int menorPeso = 200;
        for (int i = 0; i < cards.size(); i++) {

            if (cards.get(i) == null){
                continue;
            }
            cards.get(i).resetPeso();

            if (cards.get(i).getSequencia()==20){
                cards.get(i).setPeso(20);
                continue;
            }
            verificaSequencia(cards, cards.get(i));
            verificaCombinacao(cards, cards.get(i));

            if (cards.get(i).getPeso() < menorPeso){
                menorPeso = cards.get(i).getPeso();
                indexMenorPeso = i;
            }
        }
        return indexMenorPeso;
    }

    public boolean verificaSequencia(List<Cards> cartas, Cards cartaAtual) {
        for (Cards proximaCarta: cartas){
            if (proximaCarta == null || proximaCarta.equals(cartaAtual)){
                continue;
            }
            if (cartaAtual.getNaipe().equals(proximaCarta.getNaipe())) {
                int valorAtual = cartaAtual.getSequencia();
                int proximoValor = proximaCarta.getSequencia();

                if (Math.abs(valorAtual - proximoValor) == 2) {
                    cartaAtual.setPeso(1);
                    return true;
                }else if (Math.abs(valorAtual - proximoValor) == 1) {
                    cartaAtual.setPeso(2);
                    return true;
                } 
            }
        }
        return false;
    }

    public  boolean verificaCombinacao(List<Cards> cartas, Cards cartaAtual) {
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i) == null || cartas.get(i).equals(cartaAtual)){
                continue;
            }
            if (Math.abs(cartas.get(i).getSequencia() - cartaAtual.getSequencia()) == 0) {
                cartaAtual.setPeso(2);
                return true;
            }
        }
        return false;
    }

    public int descartCard(Player player){
        int indexCard = encontraMenorPeso(Arrays.asList(player.getCards()));
        return indexCard;
        
    }

}
