import java.util.Scanner;
public class Palpite{
    private String Resposta;


public Palpite(){
            
    this.Resposta = " ";

}


public String setPalpite(String tentativa){
    boolean aux= verifica_palpite(tentativa);

    if(aux == false){
    System.out.println("Palpite invalido!!!, ultrapassou o número maximo de caracteres:"+tentativa);
        System.out.println("/nInsira um novo palpite:");

        Scanner scanner = new Scanner(System.in);

        String nova_tentativa = scanner.nextLine().toLowerCase();
        scanner.close();
        return setPalpite(nova_tentativa);
    } else
        
        return this.Resposta=tentativa;
        
    
}

public boolean verifica_palpite(String N_tentativa){
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

public String getPalpite(){
    return this.Resposta;
}
    
}