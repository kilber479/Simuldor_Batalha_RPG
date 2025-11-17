package model;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 18, 10);
    }

    @Override
    public int especial() {
        return ataque * 2;
    }

    @Override
    public String tipoEspecial() {
        return "Golpe de Espada (dano dobrado)";
    }
}
