package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.Console;

public class MainController {
    private static TelaCincoController telaCincoController;
    private static TelaSeisController telaSeisController;
    private static TelaSeteController telaSeteController;
    private static TelaOitoController telaOitoController;
    private static TelaCarrinhoController telaCarrinhoController;

    public static void setTelaCincoController(TelaCincoController controller) {
        telaCincoController = controller;
    }

    public static void setTelaSeisController(TelaSeisController controller) {
        telaSeisController = controller;
    }
    public static void setTelaSeteController(TelaSeteController controller) {
        telaSeteController = controller;
    }
    public static void setTelaOitoController(TelaOitoController controller) {
        telaOitoController = controller;
    }

    @FXML
    protected void inciarButtonClick() {
        if (telaCincoController != null || telaSeisController != null || telaSeteController != null || telaOitoController != null) {
            telaCarrinhoController = HelloApplication.getTelaCarrinhoController();
            telaCincoController.setquantidadeEntradaUm(0);
            telaCincoController.setquantidadeEntradaDois(0);
            telaCincoController.setquantidadeEntradaTres(0);
            telaSeisController.setQuantidadePrincipalUm(0);
            telaSeisController.setQuantidadePrincipalDois(0);
            telaSeisController.setQuantidadePrincipalTres(0);
            telaSeteController.setQuantidadeBebidaUm(0);
            telaSeteController.setQuantidadeBebidaDois(0);
            telaSeteController.setQuantidadeBebidaTres(0);
            telaOitoController.setQuantidadeSobremesaUm(0);
            telaOitoController.setQuantidadeSobremesaDois(0);
            telaOitoController.setQuantidadeSobremesaTres(0);

            //System.out.println("Iniciar");
            HelloApplication.changeScreen(2);

            telaOitoController.atualizarquantidade();
            telaSeteController.atualizarquantidade();
            telaSeisController.atualizarquantidade();
            telaCincoController.atualizarquantidade();
            telaCarrinhoController.limparTela();

        } else{
            System.out.println("Erro");
        }
    }
}