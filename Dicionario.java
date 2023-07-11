import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Dicionario {
    private ArrayList<String> palavras;

    public Dicionario() {
        palavras = carregarDicionario();
    }

    private ArrayList<String> carregarDicionario() {
        File file = new File("br-utf8.txt");
        ArrayList<String> dicionario = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                dicionario.add(line.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o dicionário.");
            e.printStackTrace();
        }

        return dicionario;
    }

    public String obterPalavraAleatoria() {
        Random random = new Random(System.currentTimeMillis());
        return palavras.get(random.nextInt(palavras.size()));
    }
}