package com.example.appallwally;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene mainScene;
    private static Scene telaDoisScene;
    private static Scene telaTresScene;
    private static Scene telaQuatroScene;
    private static Scene telaCincoScene;
    private static Scene telaSeteScene;
    private static Scene telaOitoScene;
    private static Scene telaSeisScene;
    private static Scene telaCarrinhoScene;
    private static Scene telaPagamentoScene;
    private static Scene telaFinalScene;
    private static TelaTresController telaTresController;
    private static TelaCarrinhoController telaCarrinhoController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        stage.setTitle("All Wally");

        //Tela Main
        Parent fxmlMain = FXMLLoader.load(getClass().getResource("mainTela.fxml"));
        mainScene = new Scene(fxmlMain, 320,510);

        //Tela Dois
        Parent fxmlDois = FXMLLoader.load(getClass().getResource("doisTela.fxml"));
        telaDoisScene = new Scene(fxmlDois, 320, 510);

        //Tela Três
        FXMLLoader telaTresLoader = new FXMLLoader(getClass().getResource("tresTela.fxml"));
        Parent fxmlTres = telaTresLoader.load();
        telaTresScene = new Scene(fxmlTres, 320, 510);
        telaTresController = telaTresLoader.getController(); // Obter a referência do controlador

        //Tela Quatro
        Parent fxmlQuatro = FXMLLoader.load(getClass().getResource("quatroTela.fxml"));
        telaQuatroScene = new Scene(fxmlQuatro, 320, 510);

        //Tela Cinco -> entrada
        FXMLLoader telaCincoLoader = new FXMLLoader(getClass().getResource("cincoTela.fxml"));
        Parent fxmlCinco = telaCincoLoader.load();
        telaCincoScene = new Scene(fxmlCinco, 320, 510);
        TelaCincoController telaCincoController = telaCincoLoader.getController();
        MainController.setTelaCincoController(telaCincoController);

        //Tela Seis -> principal
        FXMLLoader telaSeisLoader = new FXMLLoader(getClass().getResource("seisTela.fxml"));
        Parent fxmlSeis = telaSeisLoader.load();
        telaSeisScene = new Scene(fxmlSeis, 320, 510);
        TelaSeisController telaSeisController = telaSeisLoader.getController();
        MainController.setTelaSeisController(telaSeisController);

        //Tela Sete -> bebida
        FXMLLoader telaSeteLoader = new FXMLLoader(getClass().getResource("seteTela.fxml"));
        Parent fxmlSete = telaSeteLoader.load();
        telaSeteScene = new Scene(fxmlSete, 320, 510);
        TelaSeteController telaSeteController = telaSeteLoader.getController();
        MainController.setTelaSeteController(telaSeteController);

        //Tela Oito -> sobremesa
        FXMLLoader telaOitoLoader = new FXMLLoader(getClass().getResource("oitoTela.fxml"));
        Parent fxmlOito = telaOitoLoader.load();
        telaOitoScene = new Scene(fxmlOito, 320, 510);
        TelaOitoController telaOitoController = telaOitoLoader.getController();
        MainController.setTelaOitoController(telaOitoController);

        //Tela Resumo Carrinho
        FXMLLoader telaCarrinhoLoader = new FXMLLoader(getClass().getResource("carrinhoTela.fxml"));
        Parent fxmlCarrinho = telaCarrinhoLoader.load();
        telaCarrinhoScene = new Scene(fxmlCarrinho, 320, 510);
        telaCarrinhoController = telaCarrinhoLoader.getController();

        //Tela Pagamento
        FXMLLoader telaPagamentoLoader = new FXMLLoader(getClass().getResource("pagarTela.fxml"));
        Parent fxmlPagamento = telaPagamentoLoader.load();
        telaPagamentoScene = new Scene(fxmlPagamento, 320, 510);

        //Tela Final
        FXMLLoader telaFinalLoader = new FXMLLoader(getClass().getResource("finalTela.fxml"));
        Parent fxmlFinal = telaFinalLoader.load();
        telaFinalScene = new Scene(fxmlFinal, 320, 510);

        stage.setScene(mainScene);

        stage.show();
    }
    public static TelaCarrinhoController getTelaCarrinhoController() {
        return telaCarrinhoController;
    }
    public static void changeScreen(int tela){
        switch (tela){
            case 1 :
                stage.setScene(mainScene);
                break;
            case 2:
                stage.setScene(telaDoisScene);
                break;
            case 3:
                stage.setScene(telaTresScene);
                telaTresController.tempo();
                break;
            case 4:
                stage.setScene(telaQuatroScene);
                break;
            case 5:
                stage.setScene(telaCincoScene);
                break;
            case 6:
                stage.setScene(telaSeisScene);
                break;
            case 7:
                stage.setScene(telaCarrinhoScene);
                break;
            case 8:
                stage.setScene(telaSeteScene);
                break;
            case 9:
                stage.setScene(telaOitoScene);
                break;
            case 10:
                stage.setScene(telaPagamentoScene);
                break;
            case 11:
                stage.setScene(telaFinalScene);
                telaTresController.tempo();
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}