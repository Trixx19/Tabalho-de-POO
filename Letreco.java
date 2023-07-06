import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Letreco{
private final int Max_Tentativas = 6;


private Palpite[] palpites;
private ArrayList <String> dicionario;
private String palavra_secreta;

public Letreco(){
    this.palpites = new Palpite[Max_Tentativas];

}

    private void CarregarDicionario(){
        try (BufferedReader reader = new BufferedReader(new FileReader("br_utf8.txt"))) {
            String palavra;
            while ((palavra = reader.readLine()) != null) {
                dicionario.add(palavra.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dicionário de palavra.");
            e.printStackTrace();
        }
    }

     public void geraPalavraSecreta(){
		Random random = new Random(System.currentTimeMillis());
        this.palavra_secreta= dicionario.get(random.nextInt(dicionario.size()));
	}


    public void inicializarJogo() {
       // geraPalavraSecreta();
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
