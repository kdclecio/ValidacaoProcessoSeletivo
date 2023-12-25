import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LigandoParaCandidatos {
    public static void main(String[] args) {

        //se o metodo analisandoCandidatos() fosse somente public void, então
        // eu precisaria criar um objeto dele aqui para poder usalo
        // segue exemplo:
        /*
        LigandoParaCandidatos Myobj = new LigandoParaCandidatos();
        Myobj.analisandoCandidatos();
        */
        
        analisandoCandidatos();
        ligarParaCandidatos(analisandoCandidatos());
    }


    //mudei esse metodo de void para ArrayList
    //e retornei os valores selecionados dentro do array candidatosSelecionados
    //na chamada do metodo ligar para candidatos selecioados
    //eu so passo o array candidatosSelecionados como parametro.

    //Aqui se eu definir esse metodo como public void
    // então eu preciso criar um objeto dele la na classe main para poder acessalo
    public static ArrayList<String> analisandoCandidatos(){

        String [] candidatos = {"Ana", "Hugo", "Bete", "Jonas", "Vicente", "Damiania", "Damares", "Prego"};
        double salarioBase = 2000.00;
        
        int candidatoAtual = 0;

        int totalCandidatosSelecionados = 0;

        ArrayList<String> candidatosSelecionados = new ArrayList<>();

        do{

            int salarioPretendido = valorAleatorio();
            System.out.println(candidatos[candidatoAtual] + " solicitou R$" + salarioPretendido);
            
            if(salarioPretendido > salarioBase){
                System.out.println("Aguardando resposta dos demais candidatos");
            } else if (salarioPretendido == salarioBase){
                System.out.println("Ligar para o candidato com contraproposta ");
            } else {
                System.out.println(candidatos[candidatoAtual] + " foi selecionado para vaga");
                candidatosSelecionados.add(candidatos[candidatoAtual]);
                totalCandidatosSelecionados++;
            } 
            candidatoAtual++;
            
        } while (candidatoAtual < candidatos.length);
            System.out.println("Total candidatos selecionados : " + totalCandidatosSelecionados);
            System.out.println("Candidatos selecionados: " + candidatosSelecionados);
            System.out.println("FIM");

            return candidatosSelecionados;

    }


    public static void ligarParaCandidatos(ArrayList<String> candidatos){

        for(String candidato : candidatos){
            tentativaLigacao();
            int ligacoesFeitas = 1;
            boolean continuarLigando = true;
            boolean atendeu = false;

            do{
                atendeu = tentativaLigacao();
                continuarLigando = !atendeu;

                if(continuarLigando){
                ligacoesFeitas++;
       }     else {
                System.out.println("Conseguimos contato com " + candidato);
            }
        } while(continuarLigando && ligacoesFeitas <3);

        if(atendeu){
        System.out.println("Conseguimos ligar para " + candidato + " na " + ligacoesFeitas + "° tentativa ");
        } else {
        System.out.println("Tentamos ligar para " + candidato + " " + ligacoesFeitas + " vezes, mas não fomos atendidos" );
        }
        }
}

    public static int valorAleatorio (){
        int valorGerado = ThreadLocalRandom.current().nextInt(1800,2100);
        return valorGerado;
    }

    static boolean tentativaLigacao(){
        return new Random().nextInt(3)==1;
    }

}
