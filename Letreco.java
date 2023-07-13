
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Letreco{
    public final int maxTentativas = 6;
    boolean condicaoDeParada = false;

    public Palpite[] palpites;
    private Dicionario dicionario;
    private String palavraSecreta;
    private Integer pontuacao;
    public ArrayList<Usuario> listaUsuarios;

    public Letreco(Dicionario dicionario){
        this.palpites = new Palpite[maxTentativas];
        this.listaUsuarios = new ArrayList<>();
        this.dicionario = dicionario;
        this.pontuacao = 0;
        geraPalavraSecreta();
    }

   

    // verifica a resposta do usuario e printa o feedback.

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
            this.pontuacao = ntentativa;
        }
        else if(ntentativa == 5){
            System.out.println("suas tentativas esgotaram a palavra era " + palavraSecreta + " !");
            //return false;
        }
    }


    // Gera a palavra aleatoria.
    private void geraPalavraSecreta() {
        this.palavraSecreta = dicionario.obterPalavraAleatoria();
    }

    // Printa as instruções do jogo.

    public void instrucoesJogo() {
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
        menu();

        

    }

    // Inicia a partida

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

        
        criaUsuario();


        /*
        Integer op = 0;
        System.out.println("Deseja voltar ao menu?");
        System.out.println("1.Sim");
        System.out.println("2.Não");

        if(op == 1){
            menu();
        } else if(op<0 && op>2){
            System.out.println("Opção invalida!!!");
            
        }else*/

    


        scanner.close();


    }


    // Adiciona o usuario ao ArrayList.

    public void adicionarUsuario(Usuario usuarioAd){

        listaUsuarios.add(usuarioAd);

    }

    // Cria usuario.

    public void criaUsuario(){
        Usuario auxUsuario = new Usuario();
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        Integer auxiliar = this.pontuacao;

        System.out.println("Digite seu nome: ");
        nome= scanner.nextLine().toLowerCase();

        auxUsuario.setNomeUsuario(nome);
        auxUsuario.setScoreUsuario(auxiliar);

        adicionarUsuario(auxUsuario);

        System.out.println("Sua pontuação foi salva\n");

        scanner.close();

        
    }

    public void exibirRanking() {
        System.out.println("\n=== RANKING ===");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            System.out.println((i + 1) + ". Nome: " + usuario.getNomeUsuario() + ", Score: " + usuario.getScoreUsuario());
        }
    }

   /*  private void ordenarUsuariosPorScore() {
        Collections.sort(listaUsuarios);
    }*/

    
    public void menu(){
        Integer op=0;
        System.out.println("Escolha e digite uma das opções a seguir:\n");
        System.out.println("1.Iniciar a partida");
        System.out.println("2.Verificar ranking");
        System.out.println("3.encerrar o jogo");
        Scanner sc = new Scanner(System.in);
        op= sc.nextInt();

        switch(op){
            case 1:
            
                iniciarPartida();
                break;

            case 2:

                exibirRanking();
            break;

            case 3:

                System.out.println("Obrigado por jogar Letreco");
                break;

            default:

                    System.out.println("Opção inválida.");
                    break;

        }

        sc.close();
    }
    
      
    

}
