package util;

import model.*;

public class CharacterFactory {

    public static Personagem criar(int tipo, String nome) {
        if (tipo == 1) return new Guerreiro(nome);
        if (tipo == 2) return new Mago(nome);
        return new Arqueiro(nome);
    }
}
