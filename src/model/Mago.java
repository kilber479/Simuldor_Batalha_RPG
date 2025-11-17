package model;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 100, 22, 6);
    }

    @Override
    public int especial() {
        return ataque + 15;
    }

    @Override
    public String tipoEspecial() {
        return "Bola de Fogo (alto dano mágico)";
    }
}
