import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Letreco{
public final int maxTentativas = 6;


public Palpite[] palpites;
private ArrayList <String> dicionario;
private String palavraSecreta;

public Letreco(){
    this.palpites = new Palpite[maxTentativas];
    this.dicionario = new ArrayList<>();
    carregarDicionario();
    geraPalavraSecreta();

}

    // carrega o dicionario

    private void carregarDicionario() {
        File file = new File("br-utf8.txt");
 
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                dicionario.add(line.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dicionário.");
            e.printStackTrace();
        }
    }

    // Gera a palavra secreta!!
     public void geraPalavraSecreta(){
		Random random = new Random(System.currentTimeMillis());
        this.palavraSecreta= dicionario.get(random.nextInt(dicionario.size()));
	}

    public void verificaResposta(String tentativa) {
        char[] linhaImpressao = {'#', '#', '#', '#', '#'};
        String palavraAux = this.palavraSecreta;

        for (int i = 0; i < tentativa.length(); i++) {
            if (Character.isLetter(tentativa.charAt(i))) {
                if(tentativa.charAt(i) == palavraAux.charAt(i)){
                linhaImpressao[i] = '+';
                } else if (palavraAux.indexOf(tentativa.charAt(i)) != -1) {
                linhaImpressao[i] = '-';
                }
            }
            if(tentativa.equals(palavraAux)){
            System.out.println("Parabéns! Você adivinhou a palavra "+ palavraSecreta +" corretamente!");
            System.out.println("Obrigado por jogar Letrexto!");
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
    
    public void iniciarPartida() {
        
        Scanner scanner = new Scanner(System.in);
        
        String aux = "";
        for (int i = 0; i < maxTentativas; i++) {
            Palpite adPalpites= new Palpite();

            System.out.println("----- Insira seu palpite!!! -----");
            System.out.print("Palpite " + (i + 1) + ": ");
           
            aux= scanner.nextLine().toLowerCase();
            adPalpites.setPalpite(aux);
            this.palpites[i] = adPalpites;
           
            verificaResposta(aux);
            

            System.out.println();
        
        }
        
        
        }

    public void jogar(){
        inicializarJogo();
        iniciarPartida();


    }

}






