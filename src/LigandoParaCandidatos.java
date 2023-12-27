import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LigandoParaCandidatos {
    
    public static void main(String[] args) {

        LigandoParaCandidatos analisar = new LigandoParaCandidatos();
        ArrayList<String> analisando = analisar.analisarCandidatos();
       
        LigandoParaCandidatos ligar = new LigandoParaCandidatos();
        ligar.ligarParaCandidatos(analisando);
    }

    public ArrayList<String> analisarCandidatos(){

        
        String [] candidatos = {"Hugo", "beto", "Vicente", "Betina", "Mormom"};
        int salarioBase = 2000;
        ArrayList<String> candidatoSelecionados = new ArrayList<>();

        for(String candidato : candidatos){
            int salarioPretendido = valorAleatorio();
            String mensagem = String.format("%s solicitou %d",candidato, salarioPretendido);
            if(salarioPretendido > salarioBase){
                System.out.println(mensagem + " aguardando resposta dos demais candidatos");
            } else if (salarioPretendido == salarioBase) {
                System.out.println(mensagem + " ligar para candidato com contraproposta");
            } else {
                System.out.println(mensagem + " e foi selecionado para a vaga");
                candidatoSelecionados.add(candidato);
            }
        }

        System.out.println("Total candidatos selecionados: " + candidatoSelecionados.size());
        System.out.println("Candidatos selecionados: " + candidatoSelecionados);

        return candidatoSelecionados;
    }
    
    public void ligarParaCandidatos(ArrayList<String> candidatosSelecionados){

        for(String candidato : candidatosSelecionados){
            int totalTentativas = 1;
            
            while(totalTentativas < 3 && !resultadoLigacao()){
            
                    totalTentativas++;
                }
            
            System.out.println( totalTentativas < 3 ? candidato + " nos atendeu na " + totalTentativas + "° tentativa" : candidato + " não nos atendeu");
        }
}


    public boolean resultadoLigacao(){
        return ThreadLocalRandom.current().nextInt(3)==1;
    }

    public int valorAleatorio(){
        return ThreadLocalRandom.current().nextInt(1800,2150);
    }

}
