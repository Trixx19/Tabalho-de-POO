
import java.util.Scanner;


public class Letreco{
    public final int maxTentativas = 6;
    boolean condicaoDeParada = false;

    public Palpite[] palpites;
    private Dicionario dicionario;
    private String palavraSecreta;

    public Letreco(Dicionario dicionario){
        this.palpites = new Palpite[maxTentativas];
        this.dicionario = dicionario;
        //carregarDicionario();
        geraPalavraSecreta();
    }

   

    
    public void verificaResposta(String tentativa, Integer ntentativa) {
        char[] linhaImpressao = {'*', '*', '*', '*', '*'};
        String palavraAux = this.palavraSecreta;

        for (int i = 0; i < tentativa.length()&& i < palavraAux.length(); i++) {
            if (Character.isLetter(tentativa.charAt(i))) {
                if(tentativa.charAt(i) == palavraAux.charAt(i)){
                linhaImpressao[i] = '+';
                } else if (palavraAux.indexOf(tentativa.charAt(i)) != -1) {
                linhaImpressao[i] = '-';
                }
            }
        }
        System.out.println("Seu feedback: " + new String(linhaImpressao));
        if(tentativa.equals(palavraAux)){
            System.out.println("Parabéns! Você adivinhou a palavra "+ palavraSecreta +" corretamente!");
            System.out.println("Obrigado por jogar Letrexto!");
            this.condicaoDeParada = true;
        }
        else if(ntentativa == 5){
            System.out.println("suas tentativas esgotaram a palavra era " + palavraSecreta + " !");
            //return false;
        }
    }

    private void geraPalavraSecreta() {
        this.palavraSecreta = dicionario.obterPalavraAleatoria();
    }

    public void inicializarJogo() {
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


    public void iniciarPartida() {
        
        Scanner scanner = new Scanner(System.in);
        String aux = "";
        for (int i = 0; i < maxTentativas && !condicaoDeParada; i++) {
            Palpite adPalpites= new Palpite();

            System.out.println("----- Insira seu palpite!!! -----");
            System.out.print("Palpite " + (i + 1) + ": ");
           
            aux= scanner.nextLine().toLowerCase();
            adPalpites.setPalpite(aux);
            this.palpites[i] = adPalpites;
            verificaResposta(aux,i);
            
            System.out.println();
        
        }
    }


    public void jogar(){
        inicializarJogo();
        iniciarPartida();
    }
}