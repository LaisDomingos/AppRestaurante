package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PagamentoController {
    @FXML
    private Button btnPagar;
    @FXML
    private RadioButton mbwayRadioButton;

    @FXML
    private RadioButton multibancoRadioButton;

    @FXML
    private RadioButton dinheiroRadioButton;

    @FXML
    protected void initialize() {
        ToggleGroup pagamentoToggleGroup = new ToggleGroup();
        mbwayRadioButton.setToggleGroup(pagamentoToggleGroup);
        multibancoRadioButton.setToggleGroup(pagamentoToggleGroup);
        dinheiroRadioButton.setToggleGroup(pagamentoToggleGroup);
        pagamentoToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                btnPagar.setVisible(true);
            } else{

            }
        });
    }

    @FXML
    protected void atendenteButtonClick() {
        //System.out.println("Chamou atendente");
        HelloApplication.changeScreen(3);
    }
    @FXML
    protected void carrinhoButtonClick(){
        //System.out.println("Carrinho");
        HelloApplication.changeScreen(7);
    }
    @FXML
    protected void voltarButtonClick() {
        HelloApplication.changeScreen(7);
    }
    @FXML
    protected void pagamentoButtonClick() {
        HelloApplication.changeScreen(11);
    }
}
