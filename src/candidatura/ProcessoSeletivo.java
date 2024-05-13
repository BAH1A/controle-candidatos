package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        setorRh();
    }

    //Case 04: Informando ao RH os candidatos Selecionados
    static void setorRh(){
        String[] candidatos = {"JEFERSON", "JOAO", "VALENTINA", "THIAGO", "YASMIN"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }//Case 04: Metódo que tenta ligar para o candidato
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso.");
            }
        }while (continuarTentando && tentativasRealizadas<3);

        if (atendeu){
            System.out.println("Contato estabelecido com o candidato " +candidato+" na "+tentativasRealizadas+"º tentativa.");
        }else{
            System.out.println("Contato não estabelecido com o candidato "+candidato+" número maximo de "+tentativasRealizadas+" tentativas.");
        }
    }

    //Case 04: Metódo auxiliar que gera número aleatório
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    //Case 03: Informando ao RH os candidatos Selecionados
    static void imprimirSelecionados(){
        String[] candidatos = {"JEFERSON", "JOAO", "VALENTINA", "THIAGO", "YASMIN"};
        for(int i=0 ; i<candidatos.length; i++){
            System.out.println("O ID do candidato "+candidatos[i] + " é o: " + (i+1));
        }
        System.out.println("\nSegue a lista dos canditados selecionados: ");
        selecaoCanditados();
    }

    //Case 02 = Metodo que simula a expectativa de salário do candidato
    static float valorPretendido(){
        return ThreadLocalRandom.current().nextFloat(1800,2200);
    }

    //Case 02 = Metodo que seleciona os candidatos
    static void selecaoCanditados(){
        String[] candidatos = {"JEFERSON", "JOAO", "VALENTINA", "THIAGO", "YASMIN", "CAROL", "CAIO", "DANIELA", "BRENO", "KEVIN"};
        double salarioBase = 2000.0;

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            if (salarioBase>=salarioPretendido){
                System.out.println("Candidato " + candidato + ".");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    //Case 01 = Metodo que gera ação de acordo com a pretenção dos candidatos
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase==salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
