package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class TelaCincoController {
    @FXML
    private Text txtUm;
    @FXML
    private Text txtDois;
    @FXML
    private Text txtTres;
    @FXML
    private Text txtEntradaUm;
    @FXML
    private Text txtEntradaDois;
    @FXML
    private Text txtEntradaTres;
    @FXML
    private Button btnAdicionadoE;
    private int quantidadeEntradaUm = 0;
    private int quantidadeEntradaDois = 0;
    private int quantidadeEntradaTres = 0;

    public void setquantidadeEntradaUm (int quantidadeEntradaUm) {
        this.quantidadeEntradaUm = quantidadeEntradaUm;
    }

    public void setquantidadeEntradaDois (int quantidadeEntradaDois) {
        this.quantidadeEntradaDois = quantidadeEntradaDois;
    }

    public void setquantidadeEntradaTres(int quantidadeEntradaTres) {
        this.quantidadeEntradaTres = quantidadeEntradaTres;
    }

    private List<Item> itensCarrinho = new ArrayList<>();
    @FXML
    protected void atendenteButtonClick() {
        //System.out.println("Chamou atendente");
        adicionado();
        HelloApplication.changeScreen(3);
    }
    @FXML
    protected void carrinhoButtonClick(){
        //System.out.println("Carrinho");
        adicionado();
        Carrinho carrinho = Carrinho.getInstancia();
        carrinho.getItens().addAll(itensCarrinho);
        HelloApplication.getTelaCarrinhoController().initialize();
        HelloApplication.changeScreen(7);
    }
    @FXML
    protected void voltarButtonClick() {
        HelloApplication.changeScreen(4);
        adicionado();
    }
    @FXML
    protected void maisUmButtonClick(){
        quantidadeEntradaUm++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosUmButtonClick(){
        if(quantidadeEntradaUm <= 0){
            quantidadeEntradaUm = 0;
        } else {
            quantidadeEntradaUm--;
        }

        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisDoisButtonClick(){
        quantidadeEntradaDois++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosDoisButtonClick(){
        if(quantidadeEntradaDois <= 0){
            quantidadeEntradaDois = 0;
        } else {
            quantidadeEntradaDois--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisTresButtonClick(){
        quantidadeEntradaTres++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosTresButtonClick(){
        if(quantidadeEntradaTres <= 0){
            quantidadeEntradaTres = 0;
        } else {
            quantidadeEntradaTres--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void atualizarquantidade(){
        txtUm.setText(String.valueOf(quantidadeEntradaUm));
        txtDois.setText(String.valueOf(quantidadeEntradaDois));
        txtTres.setText(String.valueOf(quantidadeEntradaTres));
    }
    @FXML
    protected void adicionado(){
        btnAdicionadoE.setVisible(false);
    }
    @FXML
    protected void continuarButtonClick(){
        StringBuilder resumo = new StringBuilder("Resumo do Carrinho:\n");
        double total = 0;


        if (quantidadeEntradaUm >= 0) {
            Item item = new Item(txtEntradaUm.getText(), quantidadeEntradaUm, 15);
            Carrinho.getInstancia().adicionarItem(item);
        }


        if (quantidadeEntradaDois >= 0) {
            Item item = new Item(txtEntradaDois.getText(), quantidadeEntradaDois, 15);
            Carrinho.getInstancia().adicionarItem(item);
        }

        if (quantidadeEntradaTres >= 0) {
            Item item = new Item(txtEntradaTres.getText(), quantidadeEntradaTres, 10);
            Carrinho.getInstancia().adicionarItem(item);
        }

        resumo.append("\nTotal: ").append(total).append("€");

        // Chame o método para mostrar o resumo no carrinho
        HelloApplication.getTelaCarrinhoController().addItemsToSharedCart(itensCarrinho);

        if ( quantidadeEntradaUm > 0 || quantidadeEntradaDois > 0 || quantidadeEntradaTres > 0){
            btnAdicionadoE.setVisible(true);
        }

    }



}


