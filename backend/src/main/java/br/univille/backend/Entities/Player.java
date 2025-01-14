package br.univille.backend.entities;

public class Player {
    private String name;
    private int wins = 0;
    private Cards[] cards = new Cards[10];
    
    public Player(String name){
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addWins() {
        this.wins = this.wins +1;
    }

    public int getWins() {
        return wins;
    }
    
    public void setNewCard(Cards newCard){
        for (int i = 0; i < 10; i++){
            if (cards[i] == null){
                cards[i] = newCard;
                return;
            }
        }
    }
    public Cards discardCard(int index){
        Cards returnCard = cards[index];
        cards[index] = null;
        return returnCard;
    }

    
    public Cards[] getCards() {
        return this.cards;
    }

    public String viewAllCards(){
        String txtReturn = "";
        String txtAux = "";
        String txtFormat = "";
        for(int i=0; i< 10;){
            txtFormat = (this.cards[i] == null ? "" : this.cards[i].toString() + " | ");
			txtReturn += txtFormat ;
            i ++;
            int comprimento = txtFormat.length();
            int meioDaPosicao = (comprimento / 2);

            for (int countSeparador=0; countSeparador< comprimento;countSeparador++){
               if (countSeparador == meioDaPosicao){
                    txtAux = (txtAux+=i) ;
               } else {
                    txtAux = txtAux+= " ";
               }
            }
		}
        return txtReturn +"\n"+ txtAux;
    }
}
