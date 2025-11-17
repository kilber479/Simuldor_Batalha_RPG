package service;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class JogoService {

    private List<Personagem> personagens = new ArrayList<>();
    private List<String> historico = new ArrayList<>();

    public void adicionarPersonagem(Personagem p) {
        personagens.add(p);
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void registrarBatalha(String res) {
        historico.add(res);
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("personagens.txt"))) {
            for (Personagem p : personagens) {
                bw.write(p.getNome() + ";" + p.getClass().getSimpleName());
                bw.newLine();
            }
        } catch (Exception ignored) {}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("historico.txt"))) {
            for (String h : historico) {
                bw.write(h);
                bw.newLine();
            }
        } catch (Exception ignored) {}
    }

    public void carregarDados() {
        personagens.clear();
        historico.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("personagens.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p[1].equals("Guerreiro")) personagens.add(new Guerreiro(p[0]));
                else if (p[1].equals("Mago")) personagens.add(new Mago(p[0]));
                else personagens.add(new Arqueiro(p[0]));
            }
        } catch (Exception ignored) {}

        try (BufferedReader br = new BufferedReader(new FileReader("historico.txt"))) {
            String line;
            while ((line = br.readLine()) != null) historico.add(line);
        } catch (Exception ignored) {}
    }
}
