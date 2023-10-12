/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaauto;

import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class Carro extends Automovel {

    public int tetoSolar;
    public static int aberto;

    public void selecionaAcaoCarro() throws InterruptedException {
        inicializaSensores();
        int opcao = 0;
        Carro novoCarro = new Carro();
        acionaSensoresVeiculo();
        do {
            Utils.mostraMenuCarro();
            Scanner menuCarro = new Scanner(System.in);
            System.out.print("Digite uma opção: ");
            opcao = menuCarro.nextInt();

            switch (opcao) {
                //abrir e fechar
                case 1:
                    limpaConsole();
                    if (sensorAbertoFechado == 1 && sensorMovimentacao == 1 && sensorImobilidade == 0 && sensorLigadoDesligado == 1){
                        System.out.println("O carro já está em movimento");
                        emMovimento = 0;
                        System.out.println("Parando veículo...");
                        parado = 1;
                        System.out.println("Desligando veículo...");
                        ligado = 0;
                        System.out.println("Fechando veículo...");
                        Carro.aberto = 0;
                        acionaSensoresVeiculo();
                    } else if (sensorAbertoFechado == 0 || sensorAbertoFechado == 1) {
                        int resultadoTranca = abrirFechar(Carro.aberto);
                        aberto = resultadoTranca;
                        Utils.mostraStatusVeiculo();
                        if (resultadoTranca == 0) {
                            System.out.println("Carro fechado");
                            Carro.aberto = 0;
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        } else if (resultadoTranca == 1) {
                            Carro.aberto = 1;
                            aberto = Carro.aberto;
                            System.out.println("Carro aberto");
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        }
                        System.out.println("                       ");
                    }
                    break;
                // ligar e desligar    
                case 2:
                    limpaConsole();
                    int ligarCarro = novoCarro.ligar(ligado);
                    ligado = ligarCarro;
                    break;
                // movimentar o veículo    
                case 3:
                    opcao = 0;
                    limpaConsole();
                    int movimentacao = novoCarro.mover(emMovimento);
                    emMovimento = movimentacao;
                    acionaSensoresVeiculo();
                    break;
                // parar o veículo
                case 4:
                    limpaConsole();
                    opcao = 0;
                    int veiculoParado = novoCarro.parar(parado);
                    parado = veiculoParado;
                    acionaSensoresVeiculo();
                    break;
                case 5:
                    limpaConsole();
                    Utils.mostraLegendaSensores();
                    System.out.println("Verificando sensores...");
                    verificaAbertoFechado();
                    verificaLigadoDesligado();
                    verificaImobilidade();
                    verificaMovimentacao();
                    System.out.println("");                   
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 6);
    }

    public int abrirFechar(int statusAbrirFechar) throws InterruptedException {
        Thread.sleep(2000);
        //acionaSensoresVeiculo();
        int ehFechado = 0;
        int ehAberto = 1;
        if (statusAbrirFechar == ehFechado) {
            statusAbrirFechar = 1;
            aberto = statusAbrirFechar;
            System.out.println("Abrindo veículo...! ");
            acionaSensoresVeiculo();
        } else if (statusAbrirFechar == ehAberto) {
            statusAbrirFechar = 0;
            aberto = statusAbrirFechar;
            System.out.println("Fechando veículo...! ");
            acionaSensoresVeiculo();
        }
        return statusAbrirFechar;

    }

}
