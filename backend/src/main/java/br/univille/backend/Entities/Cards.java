package br.univille.backend.entities;

public class Cards {

    private String naipe;
    private String numero;
    private boolean isDisponivel;

    
    public Cards(String naipe, String numero) {
        setDisponivel(true);
        setNumero(numero);
        setNaipe(naipe);
    }

    public String getNaipe() {
        return naipe;
    }
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public boolean isDisponivel() {
        return isDisponivel;
    }
    public void setDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }
    public String toString(){
        return getNumero()+ " de " + getNaipe();
    }

}
