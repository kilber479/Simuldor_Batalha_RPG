package view;

import model.Personagem;
import util.CharacterFactory;
import util.LogManager;
import service.JogoService;
import controller.BatalhaController;
import java.util.Scanner;

public class JogoView {

    private Scanner scan = new Scanner(System.in);
    private JogoService service = new JogoService();
    private BatalhaController controller = new BatalhaController();

    public void iniciarMenu() {

        service.carregarDados();

        while (true) {
            System.out.println("\n=== SIMULADOR RPG ===");
            System.out.println("1 - Criar personagem");
            System.out.println("2 - Listar personagens");
            System.out.println("3 - Iniciar batalha");
            System.out.println("4 - Ver histórico");
            System.out.println("5 - Salvar dados");
            System.out.println("0 - Sair");
            System.out.print("> ");

            int op = Integer.parseInt(scan.nextLine());

            if (op == 1) criar();
            else if (op == 2) listar();
            else if (op == 3) batalha();
            else if (op == 4) historico();
            else if (op == 5) service.salvarDados();
            else if (op == 0) return;
        }
    }

    private void criar() {
        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.println("1- Guerreiro | 2- Mago | 3- Arqueiro");
        int tipo = Integer.parseInt(scan.nextLine());

        Personagem p = CharacterFactory.criar(tipo, nome);
        service.adicionarPersonagem(p);

        System.out.println("Criado: " + nome);
    }

    private void listar() {
        int i = 1;
        for (Personagem p : service.getPersonagens()) {
            System.out.println(i++ + " - " + p.getNome() + " (" + p.getClass().getSimpleName() + ")");
        }
    }

    private void batalha() {
        if (service.getPersonagens().size() < 2) {
            System.out.println("Crie pelo menos 2 personagens.");
            return;
        }

        listar();
        System.out.print("Jogador 1: ");
        int j1 = Integer.parseInt(scan.nextLine()) - 1;

        System.out.print("Jogador 2: ");
        int j2 = Integer.parseInt(scan.nextLine()) - 1;

        Personagem p1 = service.getPersonagens().get(j1);
        Personagem p2 = service.getPersonagens().get(j2);

        while (p1.estaVivo() && p2.estaVivo()) {

            System.out.println("\nAção de " + p1.getNome() + " (1-Atacar 2-Defender 3-Especial)");
            int a1 = Integer.parseInt(scan.nextLine());
            String r1 = controller.realizarTurno(p1, p2, a1);
            System.out.println(r1);
            LogManager.registrar(r1);

            if (!p2.estaVivo()) break;

            System.out.println("\nAção de " + p2.getNome() + " (1-Atacar 2-Defender 3-Especial)");
            int a2 = Integer.parseInt(scan.nextLine());
            String r2 = controller.realizarTurno(p2, p1, a2);
            System.out.println(r2);
            LogManager.registrar(r2);
        }

        String vencedor = p1.estaVivo() ? p1.getNome() : p2.getNome();
        System.out.println("\nVencedor: " + vencedor);
        service.registrarBatalha("Vencedor: " + vencedor);
    }

    private void historico() {
        for (String h : service.getHistorico()) {
            System.out.println(h);
        }
    }
}
