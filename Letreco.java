import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Letreco{
private final int Max_Tentativas = 6;


private Palpite[] Palpites;
private ArrayList <String> Dicionario;
private String palavra_secreta;

public Letreco(){
    this.Palpites = new Palpite[Max_Tentativas];

}

    private void carregarDicionario() {
        try (BufferedReader reader = new BufferedReader(new FileReader(br_utf8.txt))) {
            String palavra;
            while ((palavra = reader.readLine()) != null) {
                Dicionario.add(palavra.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dicionário de palavra.");
            e.printStackTrace();
        }
    }

    public void inicializarJogo() {
        Random random = new Random(System.currentTimeMillis());
        this.palavra_secreta= Dicionario.get(random.nextInt(Dicionario.size()));
        System.out.println("=====================");
        System.out.println("BEM-VINDO AO LETREXTO");
        System.out.println("=====================");
        System.out.println("Instruções:");
        System.out.println("- O computador escolherá uma palavra aleatória de cinco letras.");
        System.out.println("- Você tem seis tentativas para adivinhar a palavra.");
        System.out.println("- Após cada palpite, você receberá feedback sobre o seu palpite:");
        System.out.println("  Um \"+\" indica uma letra correta na posição correta.");
        System.out.println("  Um \"-\" indica uma letra correta na posição errada.");
        System.out.println("  Um \"*\" indica uma letra incorreta.");
        System.out.println("Vamos começar!\n");
    }

}
