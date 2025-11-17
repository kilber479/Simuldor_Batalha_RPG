package model;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 110, 16, 8);
    }

    @Override
    public int especial() {
        return ataque + 10;
    }

    @Override
    public String tipoEspecial() {
        return "Rajada de Flechas (3 tiros rápidos)";
    }
}
