import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EscolhendoAte5Candidatos {
    
    public static void main(String[] args) {
        
        analisarCandidatos();

    }

    public static void analisarCandidatos(){

        String [] candidatos = {"Jose", "Veronia", "Magalu", "Iriane", "Leticia", "Vitoria", "Jessica", "Bete", "Hugo"};
        int totalCandidatosSelecionados = 0;
        double salarioBase = 2000.00;
        int candidatoAtual = 0;
        ArrayList<String> candidatosSelecionados = new ArrayList<>();

        while(totalCandidatosSelecionados < 5 && candidatoAtual < candidatos.length){

            double salarioPretendido = valorAleatorio();

            System.out.println(candidatos[candidatoAtual] + " solicitou R$" + salarioPretendido);
            if(salarioPretendido > salarioBase){
                System.out.println("Aguardando resposta dos demais candidatos");
            } else if(salarioPretendido == salarioBase){
                System.out.println("Ligar para candidato com contraproposta");
            } else {
                System.out.println(candidatos[candidatoAtual] + " foi selecionado para a vaga");
                totalCandidatosSelecionados++;
                candidatosSelecionados.add(candidatos[candidatoAtual]);
            }
                
                candidatoAtual++;
            
        }
        System.out.println("Total candidatos selecionados: " + totalCandidatosSelecionados);
        System.out.println("Candidatos selecionados: " + candidatosSelecionados);
    }

    static int valorAleatorio(){

        return ThreadLocalRandom.current().nextInt(1800,2200);
        
    }
}
