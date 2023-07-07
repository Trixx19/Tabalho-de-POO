import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Letreco jogo = new Letreco();

        Scanner scanner = new Scanner(System.in);

        //gambiarra pra testar

        for (int i = 0; i < jogo.maxTentativas; i++) {
            System.out.print("Palpite " + (i + 1) + ": ");
            String NovoPalpite = scanner.nextLine().toLowerCase();

            Palpite objPalpite = new Palpite();
            String resposta = objPalpite.setPalpite(NovoPalpite);

            jogo.palpites[i] = objPalpite;

            //jogo.verifica_acertos(NovoPalpite);

            System.out.println();
        }

        scanner.close();
    }
}
