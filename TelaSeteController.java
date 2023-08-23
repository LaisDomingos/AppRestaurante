package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class TelaSeteController {
    @FXML
    private Text txtUmB;
    @FXML
    private Text txtDoisB;
    @FXML
    private Text txtTresB;
    @FXML
    private Text txtBebidaUm;
    @FXML
    private Text txtBebidaDois;
    @FXML
    private Text txtBebidaTres;
    @FXML
    private Button btnAdicionadoB;
    private int quantidadeBebidaUm = 0;
    private int quantidadeBebidaDois = 0;
    private int quantidadeBebidaTres = 0;
    private List<Item> itensCarrinho = new ArrayList<>();
    public void setQuantidadeBebidaUm (int quantidadeBebidaUm) {
        this.quantidadeBebidaUm = quantidadeBebidaUm;
    }

    public void setQuantidadeBebidaDois (int quantidadeBebidaDois) {
        this.quantidadeBebidaDois = quantidadeBebidaDois;
    }

    public void setQuantidadeBebidaTres(int quantidadeBebidaTres) {
        this.quantidadeBebidaTres = quantidadeBebidaTres;
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
        quantidadeBebidaUm++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosUmButtonClick(){
        if(quantidadeBebidaUm <= 0){
            quantidadeBebidaUm = 0;
        } else {
            quantidadeBebidaUm--;
        }

        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisDoisButtonClick(){
        quantidadeBebidaDois++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosDoisButtonClick(){
        if(quantidadeBebidaDois <= 0){
            quantidadeBebidaDois = 0;
        } else {
            quantidadeBebidaDois--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisTresButtonClick(){
        quantidadeBebidaTres++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosTresButtonClick(){
        if(quantidadeBebidaTres <= 0){
            quantidadeBebidaTres = 0;
        } else {
            quantidadeBebidaTres--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void atualizarquantidade(){
        txtUmB.setText(String.valueOf(quantidadeBebidaUm));
        txtDoisB.setText(String.valueOf(quantidadeBebidaDois));
        txtTresB.setText(String.valueOf(quantidadeBebidaTres));
    }
    @FXML
    protected void adicionado(){
        btnAdicionadoB.setVisible(false);
    }
    @FXML
    protected void continuarButtonClick(){
        StringBuilder resumo = new StringBuilder("Resumo do Carrinho:\n");
        double total = 0;


        if (quantidadeBebidaUm >= 0) {
            Item item = new Item(txtBebidaUm.getText(), quantidadeBebidaUm, 8);
            Carrinho.getInstancia().adicionarItem(item);
        }

        if (quantidadeBebidaDois >= 0) {
            Item item = new Item(txtBebidaDois.getText(), quantidadeBebidaDois, 6);
            Carrinho.getInstancia().adicionarItem(item);

        }

        if (quantidadeBebidaTres >= 0) {
            Item item = new Item(txtBebidaTres.getText(), quantidadeBebidaTres, 2);
            Carrinho.getInstancia().adicionarItem(item);
        }

        resumo.append("\nTotal: ").append(total).append("€");

        // Chame o método para mostrar o resumo no carrinho
        HelloApplication.getTelaCarrinhoController().addItemsToSharedCart(itensCarrinho);
        if ( quantidadeBebidaUm > 0 || quantidadeBebidaDois > 0 || quantidadeBebidaTres > 0) {
            btnAdicionadoB.setVisible(true);
        }
    }
}


