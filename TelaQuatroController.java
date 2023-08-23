package com.example.appallwally;

import javafx.application.Platform;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class TelaQuatroController {
    private List<Item> itensCarrinho = new ArrayList<>();
    @FXML
    protected void atendenteButtonClick() {
        //System.out.println("Chamou atendente");
        HelloApplication.changeScreen(3);
    }
    @FXML
    protected void carrinhoButtonClick() {
        //System.out.println("Carrinho");
        HelloApplication.getTelaCarrinhoController().initialize();
        HelloApplication.changeScreen(7);
    }
    @FXML
    protected void voltarButtonClick() {
        HelloApplication.changeScreen(2);
    }
    @FXML
    protected void entradasButtonClick() {
        //System.out.println("Entrada");
        HelloApplication.changeScreen(5);
    }
    @FXML
    protected void principalButtonClick() {
        //System.out.println("Principal");
        HelloApplication.changeScreen(6);
    }
    @FXML
    protected void bebibasButtonClick() {
        //System.out.println("Bebidas");
        HelloApplication.changeScreen(8);
    }
    @FXML
    protected void sobremesasButtonClick() {
        //System.out.println("Sobremesas");
        HelloApplication.changeScreen(9);
    }
}


