/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaauto;

import java.io.IOException;

/**
 *
 * @author vinicius
 * métodos para limpar console
 */
public class Tela {
    // limpa tela com For
    public void limpaTudo() {
        for (int i = 0; i < 40; ++i) {
            System.out.println("\b");        }
    }
    //limpa tela detectando sistema operacional
    public void limpaClsClear() {
        try {
            final String sistemaOperacional = System.getProperty("sistemaOperacional.name");
            if (sistemaOperacional.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException e) {
        }

    }
}
