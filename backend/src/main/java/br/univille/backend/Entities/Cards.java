package br.univille.backend.entities;

public class Cards {

    private String naipe;
    private String numero;
    private int sequencia;
    private boolean isDisponivel;

    
    public Cards(String naipe, String numero, int sequencia) {
        setDisponivel(true);
        setNumero(numero);
        setNaipe(naipe);
        setSequencia(sequencia);
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
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
    @Override
    public String toString(){
        return getNumero()+ " de " + getNaipe();
    }

}
