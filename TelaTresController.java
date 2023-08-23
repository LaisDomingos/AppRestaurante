package com.example.appallwally;

import javafx.fxml.FXML;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;


public class TelaTresController {
    private Timer timer; //Timer -> Classe no pacote java.util

    private boolean offTempo = false;
    @FXML
    public void tempo() {
        //System.out.println("Chamou Atendente");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                offTempo = true;
                verificarOffTempo();
                timer.cancel();
            }
        }, 5000); // 10000 milissegundos = 10 segundos
    }

    private void verificarOffTempo() {
        if (offTempo) {
            //System.out.println("ok");
            Platform.runLater(() -> { //Platform.runLater() -> garante que o código dentro dele seja executado na thread principal do JavaFX
                HelloApplication.changeScreen(1);
            });
        } else {
            System.out.println("Erro ao chamar o atendente");
        }
    }
}


