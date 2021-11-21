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
public class Moto extends Automovel {

    public static int freiosAbs;
    public static int temBau;

    public void alarme() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Alarme ligado");
        Thread.sleep(2000);
        System.out.println("Sistema encerrado");

    }

    public int ligarDesligarAlarme(int statusAlarme) {

        return statusAlarme;
    }
    public int abreFechaBau(int statusBauAbertoFechado) throws InterruptedException {
        Thread.sleep(2000);
        //acionaSensoresVeiculo();
        int ehFechado = 0;
        int ehAberto = 1;
        if (statusBauAbertoFechado == ehFechado) {
            statusBauAbertoFechado = 1;
            freiosAbs = statusBauAbertoFechado;
            System.out.println("Baú aberto...! ");
            acionaSensoresVeiculo();
        } else if (statusBauAbertoFechado == ehAberto) {
            statusBauAbertoFechado = 0;
            freiosAbs = statusBauAbertoFechado;
            System.out.println("Baú fechado...! ");
            acionaSensoresVeiculo();
        }
        return statusBauAbertoFechado;
    }

    public int ativaDesativaFreiosAbs(int statusFreiosAbs) throws InterruptedException {

        Thread.sleep(2000);
        //acionaSensoresVeiculo();
        int ehFechado = 0;
        int ehAberto = 1;
        if (statusFreiosAbs == ehFechado) {
            statusFreiosAbs = 1;
            freiosAbs = statusFreiosAbs;
            System.out.println("Ativando freios ABS...! ");
            acionaSensoresVeiculo();
        } else if (statusFreiosAbs == ehAberto) {
            statusFreiosAbs = 0;
            freiosAbs = statusFreiosAbs;
            System.out.println("Desativando freios ABS...! ");
            acionaSensoresVeiculo();
        }
        return statusFreiosAbs;
    }

    public void selecionaAcaoMoto() throws InterruptedException {
        int opcao = 0;
        Moto motoca = new Moto();
        do {
            Utils.mostraMenuMoto();
            Scanner menuMoto = new Scanner(System.in);
            System.out.print("Digite uma opção: ");
            opcao = menuMoto.nextInt();

            switch (opcao) {
                //abrir e fechar
                case 1:
                    limpaConsole();
                    if (sensorAbertoFechado == 1 && sensorMovimentacao == 1 && sensorImobilidade == 0 && sensorLigadoDesligado == 1) {
                        System.out.println("A moto já está em movimento");
                        emMovimento = 0;
                        System.out.println("Parando veículo...");
                        parado = 1;
                        System.out.println("Desligando veículo...");
                        ligado = 0;
                        System.out.println("Fechando veículo...");
                        Moto.freiosAbs = 0;
                        acionaSensoresVeiculo();
                    } else if (sensorAbertoFechado == 0 || sensorAbertoFechado == 1) {
                        int resultadoTranca = ativaDesativaFreiosAbs(Moto.freiosAbs);
                        freiosAbs = resultadoTranca;
                        Utils.mostraStatusVeiculo();
                        if (resultadoTranca == 0) {
                            System.out.println("Moto sem freios ABS");
                            Moto.freiosAbs = 0;
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        } else if (resultadoTranca == 1) {
                            Moto.freiosAbs = 1;
                            freiosAbs = Moto.freiosAbs;
                            System.out.println("Moto com freios ABS");
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        }
                        System.out.println("                       ");
                    }
                    break;
                case 2:
                    System.out.println("Outra opção");
                    limpaConsole();
                    if (sensorAbertoFechado == 1 && sensorMovimentacao == 1 && sensorImobilidade == 0 && sensorLigadoDesligado == 1) {
                        System.out.println("A moto já está em movimento");
                        emMovimento = 0;
                        System.out.println("Parando veículo...");
                        parado = 1;
                        System.out.println("Desligando veículo...");
                        ligado = 0;
                        System.out.println("Fechando veículo...");
                        Moto.temBau = 0;
                        acionaSensoresVeiculo();
                    } else if (sensorAbertoFechado == 0 || sensorAbertoFechado == 1) {
                        int resultadoTranca = abreFechaBau(Moto.temBau);
                        freiosAbs = resultadoTranca;
                        Utils.mostraStatusVeiculo();
                        if (resultadoTranca == 0) {
                            System.out.println("Moto sem baú");
                            Moto.temBau = 0;
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        } else if (resultadoTranca == 1) {
                            Moto.temBau = 1;
                            temBau = Moto.temBau;
                            System.out.println("Moto com baú");
                            emMovimento = 0;
                            parado = 1;
                            ligado = 0;
                            acionaSensoresVeiculo();
                        }
                        System.out.println("                       ");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcao != 3);
    }
}
