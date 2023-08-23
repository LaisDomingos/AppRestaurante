package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class TelaOitoController {
    @FXML
    private Text txtUmS;
    @FXML
    private Text txtDoisS;
    @FXML
    private Text txtTresS;
    @FXML
    private Text txtSobremesaUm;
    @FXML
    private Text txtSobremesaDois;
    @FXML
    private Text txtSobremesaTres;
    @FXML
    private Button btnAdicionadoS;
    private int quantidadeSobremesaUm = 0;
    private int quantidadeSobremesaDois = 0;
    private int quantidadeSobremesaTres = 0;
    private List<Item> itensCarrinho = new ArrayList<>();
    public void setQuantidadeSobremesaUm (int quantidadeSobremesaUm) {
        this.quantidadeSobremesaUm = quantidadeSobremesaUm;
    }

    public void setQuantidadeSobremesaDois (int quantidadeSobremesaDois) {
        this.quantidadeSobremesaDois = quantidadeSobremesaDois;
    }

    public void setQuantidadeSobremesaTres(int quantidadeSobremesaTres) {
        this.quantidadeSobremesaTres = quantidadeSobremesaTres;
    }

    private List<Item> carrinho = new ArrayList<>();
    @FXML
    protected void atendenteButtonClick() {
        //System.out.println("Chamou atendente");
        HelloApplication.changeScreen(3);
        adicionado();
    }
    @FXML
    protected void carrinhoButtonClick() {
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
        quantidadeSobremesaUm++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosUmButtonClick(){
        if(quantidadeSobremesaUm <= 0){
            quantidadeSobremesaUm = 0;
        } else {
            quantidadeSobremesaUm--;
        }

        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisDoisButtonClick(){
        quantidadeSobremesaDois++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosDoisButtonClick(){
        if(quantidadeSobremesaDois <= 0){
            quantidadeSobremesaDois = 0;
        } else {
            quantidadeSobremesaDois--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisTresButtonClick(){
        quantidadeSobremesaTres++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosTresButtonClick(){
        if(quantidadeSobremesaTres <= 0){
            quantidadeSobremesaTres = 0;
        } else {
            quantidadeSobremesaTres--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void atualizarquantidade(){
        txtUmS.setText(String.valueOf(quantidadeSobremesaUm));
        txtDoisS.setText(String.valueOf(quantidadeSobremesaDois));
        txtTresS.setText(String.valueOf(quantidadeSobremesaTres));
    }
    @FXML
    protected void adicionado(){
        btnAdicionadoS.setVisible(false);
    }
    @FXML
    protected void continuarButtonClick(){
        StringBuilder resumo = new StringBuilder("Resumo do Carrinho:\n");
        double total = 0;


        if (quantidadeSobremesaUm >= 0) {
            Item item = new Item(txtSobremesaUm.getText(), quantidadeSobremesaUm, 15);
            Carrinho.getInstancia().adicionarItem(item);
        }

        if (quantidadeSobremesaDois >= 0) {
            Item item = new Item(txtSobremesaDois.getText(), quantidadeSobremesaDois, 10);
            Carrinho.getInstancia().adicionarItem(item);

        }

        if (quantidadeSobremesaTres >= 0) {
            Item item = new Item(txtSobremesaTres.getText(), quantidadeSobremesaTres, 20);
            Carrinho.getInstancia().adicionarItem(item);
        }

        resumo.append("\nTotal: ").append(total).append("€");

        HelloApplication.getTelaCarrinhoController().addItemsToSharedCart(itensCarrinho);
        if ( quantidadeSobremesaUm > 0 || quantidadeSobremesaDois > 0 || quantidadeSobremesaTres > 0){
            btnAdicionadoS.setVisible(true);
        }
    }
}


