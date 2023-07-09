import java.util.Scanner;
public class Palpite{
    public String resposta;


public Palpite(){
            
    this.resposta = "";
    
}


//Recebe uma tentativa chama vericaPalpite caso não seja true ele avisa e pede que insira uma nova tentativa


public String setPalpite(String tentativa){
    boolean aux= this.verificaPalpite(tentativa);

    if(aux == false){
    System.out.println("Palpite invalido!!!, o número maximo de caracteres é 5:"+tentativa);
        System.out.println("\nInsira um novo palpite:");

        Scanner scanner = new Scanner(System.in);

        String nova_tentativa = scanner.nextLine().toLowerCase();
        return setPalpite(nova_tentativa);
    } else
    System.out.println("Seu palpite foi adicionado!");
    return this.resposta=tentativa;
            
}

public String getPalpite(){
    return this.resposta;
}

public boolean verificaPalpite(String N_tentativa){
    int cont=0;
    for(int i=0; i<N_tentativa.length(); i++){
        if(Character.isLetter(N_tentativa.charAt(i))){
            cont++;
        }
    }

    if(cont != 5){
        return false;
    } else
        return true;
}

    
}