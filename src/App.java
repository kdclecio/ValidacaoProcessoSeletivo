import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    
   public static void main(String[] args) {

    App maracuja = new App();
    maracuja.analisandoCandidatos();

    //precisamos fazer isso aqui para não imprimir duas vezes os dados de analisandoCandidatos
    App ligacao = new App();//instanciomos um objeto
    //e atraves dessa instancia criamos uma variavel para armazenar os dados de analisandoCandidatos()
    ArrayList<String> candidatosSelecionados2 = ligacao.analisandoCandidatos();

    LigandoParaCandidatos(candidatosSelecionados2);

   }

        public static ArrayList<String> analisandoCandidatos(){

            String [] candidatos = {"Jurandi", "Beto" , "Ana", "Mozar", "Monalisa", "Vicente", "Betina", "Manda"};

            int salarioBase = 2000;
            int salarioPretendido;
            int totalCandidatosSelecionados = 0;
            ArrayList<String> candidatosSelecionados = new ArrayList<>();

            for(String candidato : candidatos){
                salarioPretendido = valorAleatorio();
                if(salarioPretendido > salarioBase){
                    System.out.println(candidato + " solicitou R$:" + salarioPretendido + " e não foi selecionado para vaga");
                } else if (salarioPretendido == salarioBase) {
                    System.out.println(candidato + " solicitou R$:" + salarioPretendido );
                } else {
                    System.out.println(candidato + " solicitou R$:" + salarioPretendido + " e foi selecionado para a vaga");
                    totalCandidatosSelecionados++;
                    candidatosSelecionados.add(candidato);

                }

            }

            System.out.println("Total candidatos selecionados: " + totalCandidatosSelecionados);
            System.out.println("Candidatos selecionados: " + candidatosSelecionados);

            return candidatosSelecionados;

        }

        public static void LigandoParaCandidatos(ArrayList<String> listaCandidatos){

            for(String candidato : listaCandidatos){

                int numeroTentativas = 1;
                boolean continuarLigando = true;
                boolean atendeu = false;

                do{
                    atendeu = resultadoLigacao();
                    continuarLigando = !atendeu;
                    if(continuarLigando){
                        numeroTentativas++;
                    } else{
                        System.out.println("Conseguimos contato com " + candidato);
                    }
                } while (continuarLigando && numeroTentativas < 3);
                if(atendeu){
                    System.out.println("Conseguimos contato com " + candidato);
                } else{
                    System.out.println(candidato + " não nos atendeu.");
                }

            }

        }

        static boolean resultadoLigacao(){
            return ThreadLocalRandom.current().nextInt(3)==1;
        }

        static int valorAleatorio(){
            return ThreadLocalRandom.current().nextInt(1800, 2200);
        }
}