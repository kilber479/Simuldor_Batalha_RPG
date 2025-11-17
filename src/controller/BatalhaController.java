package controller;

import model.Personagem;

public class BatalhaController {

    public String realizarTurno(Personagem atual, Personagem inimigo, int acao) {
        try { Thread.sleep(500); } catch (Exception ignored) {}

        int dano = 0;

        if (acao == 1) {
            dano = atual.atacar() - inimigo.defender();
            if (dano < 0) dano = 0;
            inimigo.receberDano(dano);
            return atual.getNome() + " ATACOU causando " + dano + " de dano!";
        }

        if (acao == 2) {
            int def = atual.defender();
            return atual.getNome() + " DEFENDEU (+ " + def + " DEF)";
        }

        if (acao == 3) {
            dano = atual.especial() - (inimigo.defender() / 2);
            if (dano < 0) dano = 0;
            inimigo.receberDano(dano);
            return atual.getNome() + " usou ESPECIAL (" + atual.tipoEspecial() + ") causando " + dano + "!";
        }

        return "Ação inválida.";
    }
}
