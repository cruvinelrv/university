/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaauto;

/**
 *
 * @author vinicius
 */
public class Automovel {

    public String cor;
    public String placa;
    public String modelo;
    public static int ligado;
    public static int emMovimento;
    public static int parado;
    //variaveis do Vinicius
    public static int alarme;
    public static int sensorAbertoFechado;
    public static int sensorLigadoDesligado;
    public static int sensorImobilidade;
    public static int sensorMovimentacao;

    public void inicializaSensores() {
        ligado = 0;
        Carro.aberto = 0;
        Moto.freiosAbs = 0;
        Moto.temBau = 0 ;
        alarme = 0;
        parado = 1;
        emMovimento = 0;
        acionaSensoresVeiculo();
        verificaAbertoFechado();
        verificaLigadoDesligado();
        verificaImobilidade();
        verificaMovimentacao();
    }

    public int ligar(int sensorLigado) {
        if (sensorAbertoFechado == 1 && sensorImobilidade == 1 & sensorMovimentacao == 0 & sensorLigadoDesligado == 0) {
            ligado = 1;
            parado = 1;
            emMovimento = 0;
            Carro.aberto = 1;
            sensorLigado = ligado;
            System.out.println("Ligando veículo! ");
            //atualizando valores dos sensores
            acionaSensoresVeiculo();
        } else if (sensorAbertoFechado == 1 && sensorImobilidade == 1 & sensorMovimentacao == 0 && sensorLigadoDesligado == 1) {
            ligado = 0;
            System.out.println("Desligando veículo! ");
            sensorLigado = ligado;
            //atualizando valores dos sensores
            acionaSensoresVeiculo();
        }
        return sensorLigado;
    }

    public int mover(int sensorMovimento) {
        if (sensorAbertoFechado == 0 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 0) {
            System.out.println("Abra o veículo primeiro!");
        }
        if (sensorAbertoFechado == 1 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 0) {
            System.out.println("Ligue o veículo primeiro!");
        }
        if (sensorAbertoFechado == 1 && sensorImobilidade == 0 && sensorMovimentacao == 1 && sensorLigadoDesligado == 1) {
            System.out.println("Veículo já se encontra em movimento! " + emMovimento);
        }
        if (sensorAbertoFechado == 1 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 1) {
            emMovimento = 1;
            parado = 0;
            sensorMovimento = emMovimento;
            //atualizando valores dos sensores
            acionaSensoresVeiculo();
            System.out.println("Veículo iniciando movimento...! ");
        } 
        return sensorMovimento;
    }

    public int parar(int sensorParado) {
        if (sensorAbertoFechado == 0 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 0) {
            acionaSensoresVeiculo();
            System.out.println("O veículo está fechado, abra o veículo primeiro!");
        } 
        if (sensorAbertoFechado == 1 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 0) {
            parado = 1;
            ligado = 0;
            emMovimento = 0;
            acionaSensoresVeiculo();
            System.out.println("O veículo está parado e desligado!");
        }     
        if (sensorAbertoFechado == 1 && sensorImobilidade == 1 && sensorMovimentacao == 0 && sensorLigadoDesligado == 1) {
            parado = 1;
            emMovimento = 0;
            acionaSensoresVeiculo();
            System.out.println("Veículo já está parado e se encontra ligado!");
        } 
        if (sensorAbertoFechado == 1 && sensorImobilidade == 0 && sensorMovimentacao == 1 && sensorLigadoDesligado == 1) {
            parado = 1;
            emMovimento = 0;
            Carro.aberto = 1;
            ligado = 1;           
            sensorParado = parado;
            acionaSensoresVeiculo();
            System.out.println("Parando veículo...");
        }       
        return sensorParado;
    }

    public void acionaSensoresVeiculo() {
        sensorLigadoDesligado = ligado;
        sensorMovimentacao = emMovimento;
        sensorImobilidade = parado;
        sensorAbertoFechado = Carro.aberto;
    }

    public void verificaAbertoFechado() {
        System.out.print("Sensor Aberto/Fechado: " + sensorAbertoFechado);
        if (sensorAbertoFechado == 1) {
            System.out.println(" Veiculo aberto");
        } else if (sensorAbertoFechado == 0) {
            System.out.println(" Veículo fechado");
        }
    }

    public void verificaLigadoDesligado() {
        System.out.print("Sensor Ligado/Desligado: " + sensorLigadoDesligado);
        if (sensorLigadoDesligado == 1) {
            System.out.println(" Veículo ligado");
        } else if (sensorLigadoDesligado == 0) {
            System.out.println(" Veículo desligado");
        }
    }

    public void verificaImobilidade() {
        System.out.print("Sensor Imobilidade: " + sensorImobilidade);
        if (sensorImobilidade == 1) {
            System.out.println(" Veículo parado");
        } else if (sensorImobilidade == 0) {
            System.out.println(" Veículo não está parado");
        }
    }

    public void verificaMovimentacao() {
        System.out.print("Sensor de Movimento: " + sensorMovimentacao);
        if (sensorMovimentacao == 1) {
            System.out.println(" Veículo em movimento");
        } else if (sensorMovimentacao == 0) {
            System.out.println(" Veículo sem movimentação");
        }
    }

    public void limpaConsole() {
        Tela tela = new Tela();
        tela.limpaTudo();
    }

}
