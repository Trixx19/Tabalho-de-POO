import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Letreco{
public final int maxTentativas = 6;


public Palpite[] palpites;
private ArrayList <String> dicionario;
private String palavra_secreta;

public Letreco(){
    this.palpites = new Palpite[maxTentativas];
    this.dicionario = new ArrayList<>();
    inicializarJogo();
    carregarDicionario();
    GeraPalavraSecreta();

}

    private void carregarDicionario() {
        try (BufferedReader reader = new BufferedReader(new FileReader("br-utf8"))) {
            String palavra;
            while ((palavra = reader.readLine()) != null) {
                dicionario.add(palavra.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dicionário.");
            e.printStackTrace();
        }
    }

     public void GeraPalavraSecreta(){
		Random random = new Random(System.currentTimeMillis());
        this.palavra_secreta= dicionario.get(random.nextInt(dicionario.size()));
	}

    public void verifica_acertos(Palpite tentativa) {
        char[] linhaImpressao = {'#', '#', '#', '#'};
        String tentativaAux = this.resposta;
        String palavraAux = this.palavra_secreta;

        for (int i = 0; i < tentativaAux.length(); i++) {
            if (Character.isLetter(tentativa.charAt(i))) {
             linhaImpressao[i] = '+';
            } else if (palavraAux.indexOf(tentativa.charAt(i)) != -1) {
            linhaImpressao[i] = '-';
            }
        }

        System.out.println("Seu feedback: " + new String(linhaImpressao));

    }


    public void inicializarJogo() {
        System.out.println("=====================");
        System.out.println("BEM-VINDO AO LETRECO");
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

    public Palpite[] getPalpites() {
    return palpites;
    }

}






