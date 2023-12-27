import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnalisandoCandidatos {
    public static void main(String[] args) {
        
        analisarCandidatos();

    }

    public static void analisarCandidatos(){

        String [] candidatos = {"Jose", "Veronia", "Magalu", "Iriane", "Leticia", "Vitoria", "Jessica", "Bete", "Hugo"};
        int totalCandidatosSelecionados = 0;
        double salarioBase = 2000.00;

        ArrayList<String> candidatosSelecionados = new ArrayList<>();

        for(String candidato : candidatos){
            double salarioPretendido = valorAleatorio();

            System.out.println(candidato + " solicitou R$" + salarioPretendido);
            if(salarioPretendido > salarioBase){
                System.out.println("Aguardando resposta dos demais candidatos");
            } else if(salarioPretendido == salarioBase){
                System.out.println("Ligar para candidato com contraproposta");
            } else {
                System.out.println(candidato + " foi selecionado para a vaga");
                totalCandidatosSelecionados++;
                candidatosSelecionados.add(candidato);
            }
            
        }
        System.out.println("Total candidatos selecionados: " + totalCandidatosSelecionados);
        System.out.println("Candidatos selecionados: " + candidatosSelecionados);
    }

    static int valorAleatorio(){

        return ThreadLocalRandom.current().nextInt(1800,2200);
        
    }
}
