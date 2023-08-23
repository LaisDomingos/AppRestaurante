package com.example.appallwally;

import javafx.fxml.FXML;

public class TelaDoisController {
    @FXML
    protected void atendenteButtonClick() {
        //System.out.println("Chamou atendente");
        HelloApplication.changeScreen(3);
    }
    @FXML
    protected void continuarAppButtonClick() {
        //System.out.println("Continuar APP");
        HelloApplication.changeScreen(4);
    }
}
