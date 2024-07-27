import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoDeCandidatos();
    }
    static void entrarEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando ){
                tentativasRealizadas++;
            }
            else{
                System.out.println("Contato realizado com sucesso\n");
            }
        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " apos " + tentativasRealizadas + " tentativas\n");
        }
        else{
            System.out.println("Nao conseguimos contato com " + candidato + " ,numero maximo de tentativas atingido\n");
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void selecaoDeCandidatos(){
        String[] candidatos = {"Amanda", "Felipe", "Caio", "Thiago", "Camila", "Jeferson", "Yago"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou esse valor de salario " + salarioPretendido + "\n");
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga\n");
                candidatosSelecionados++;
                entrarEmContato(candidato);
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase> salarioPretendido){
            System.out.println("Ligar para o candidato");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
