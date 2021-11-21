/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabricaauto;

import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class FabricaAuto {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     *
     */
    public static void main(String[] args) throws InterruptedException {
        //rotina para mostrar mensagem de inicialização com delay e depois mostrar na tela mensagem Sistema inicializado.
        Utils start = new Utils();
        start.inicializaSistema();
        Thread.sleep(2000);
        start.limpaTela();       
        // fim da inicialização do sistema
        int opcao = 0;
        Scanner entrada = new Scanner(System.in);
        Utils.mostraMenu();
        System.out.print("Digite uma opção: ");
        opcao = entrada.nextInt();
        // opcao 1 - menu carro
        // opcao 2 - menu moto
        Tela tela = new Tela();
        tela.limpaTudo();
        // opcao 1 - menu carro
        if (opcao == 1) {
            Carro seleciona = new Carro();
            seleciona.selecionaAcaoCarro();
        // opcao 2 - menu moto
        } else if (opcao == 2) {
            Moto motoca = new Moto();
            motoca.selecionaAcaoMoto();
        }

    }
}
