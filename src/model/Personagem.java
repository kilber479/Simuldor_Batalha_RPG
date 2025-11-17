package model;

import java.util.Random;

public abstract class Personagem implements AcaoPersonagem {

    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected Random random = new Random();

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    @Override
    public int atacar() {
        return ataque + random.nextInt(6);
    }

    @Override
    public int defender() {
        return defesa + random.nextInt(4);
    }

    @Override
    public abstract int especial();

    @Override
    public abstract String tipoEspecial();
}