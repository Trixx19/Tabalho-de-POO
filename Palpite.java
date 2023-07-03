import java.util.Scanner;
public class Palpite{
    private String Resposta;


public Palpite(){
            
    this.Resposta = " ";

}

//public String setPalpite(String tentativa){
  //  return this.Resposta=tentativa;
//}

public String setPalpite(String N_tentativa){
    int cont=0;
    for(int i=0; i<N_tentativa.length(); i++){
        if(Character.isLetter(N_tentativa.charAt(i))){
            cont++;
        }
    }
    if(cont > 5){
        System.out.println("Palpite invalido!!!, ultrapassou o número maximo de caracteres:"+N_tentativa);
        System.out.println("/nInsira um novo palpite:");

        Scanner scanner = new Scanner(System.in);

        String nova_tentativa = scanner.nextLine().toLowerCase();
        return setPalpite(nova_tentativa);
    } else
    return this.Resposta=N_tentativa;

}

public String getPalpite(){
    return this.Resposta;
}
    
}