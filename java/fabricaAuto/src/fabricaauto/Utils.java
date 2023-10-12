/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaauto;

/**
 *
 * @author vinicius
 */
public class Utils extends Automovel {

    //metodo para mostrar o menu e deixar o codigo mais enxuto
    public String mensagem = "Inicializando sistema....";

    public static void mostraMenu() {
        System.out.println("----------MENU----------");
        System.out.println("--Cadastro de veículos--");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Sair");
        System.out.println("------------------------");
    }

    public static void mostraMenuCarro() {
        System.out.println("----------CARRO-----------");
        System.out.println("1 - Abrir/Fechar carro");
        System.out.println("2 - Ligar/Desligar carro");
        System.out.println("3 - Mover");
        System.out.println("4 - Parar");
        System.out.println("5 - Verificar sensores");
        System.out.println("6 - Sair");
        System.out.println("------------------------");
    }

    public static void mostraMenuMoto() {
        System.out.println("------------MOTO-------------");
        System.out.println("1 - Ativa/Desativa freios ABS");
        System.out.println("2 - Abrir/Fechar baú         ");
        System.out.println("3 - Sair                     ");
        System.out.println("-----------------------------");
    }

    public static void mostraLegendaSensores() {
        System.out.println("------SENSORES------");
        System.out.println("Legenda: 0-não 1-sim");
        System.out.println("--------------------");
    }

    public void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        mensagem = "Sistema Inicializado.";
        System.out.println(mensagem);
    }

    public void inicializaSistema() {
        System.out.println(mensagem);
    }

    public void mostraSensores() {
        System.out.println("Sensor de partida:  " + sensorLigadoDesligado);
        System.out.println("Sensor de Imobilidade:  " + sensorImobilidade);
        System.out.println("Sensor de Movimento:  " + sensorMovimentacao);
        System.out.println("Sensor de Abertura/Fechamento:  " + sensorAbertoFechado);
    }

    public static void mostraStatusVeiculo() {
        System.out.println("-----------------------");
        System.out.println("---- STATUS VEICULO----");
        System.out.println("-----------------------");
    }
}
