public class Runner {
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        Letreco letreco = new Letreco(dicionario);
        letreco.instrucoesJogo();;
    }
}
