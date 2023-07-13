public class Usuario{
    private String nome;
    private Integer score;

    public Usuario(){
        this.nome = "";
        this.score=0;
    }


    public void setNomeUsuario(String nomeUsuario){

        this.nome = nomeUsuario;
        
    }

    public void setScoreUsuario(Integer pontos){

        this.score = pontos;

    }

    public String getNomeUsuario(){

        return this.nome;

    }

    public Integer getScoreUsuario(){
        return this.score;
    }


 

}