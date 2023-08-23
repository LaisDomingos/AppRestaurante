package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class TelaSeisController {
    @FXML
    private Text txtUmP;
    @FXML
    private Text txtDoisP;
    @FXML
    private Text txtTresP;
    @FXML
    private Text txtPrincipalUm;
    @FXML
    private Text txtPrincipalDois;
    @FXML
    private Text txtPrincipalTres;
    @FXML
    private Button btnAdicionadoP;
    private int quantidadePrincipalUm = 0;
    private int quantidadePrincipalDois = 0;
    private int quantidadePrincipalTres = 0;
    private List<Item> itensCarrinho = new ArrayList<>();
    public void setQuantidadePrincipalUm (int quantidadePrincipalUm) {
        this.quantidadePrincipalUm = quantidadePrincipalUm;
    }

    public void setQuantidadePrincipalDois (int quantidadePrincipalDois) {
        this.quantidadePrincipalDois = quantidadePrincipalDois;
    }

    public void setQuantidadePrincipalTres(int quantidadePrincipalTres) {
        this.quantidadePrincipalTres = quantidadePrincipalTres;
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
        quantidadePrincipalUm++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosUmButtonClick(){
        if(quantidadePrincipalUm <= 0){
            quantidadePrincipalUm = 0;
        } else {
            quantidadePrincipalUm--;
        }

        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisDoisButtonClick(){
        quantidadePrincipalDois++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosDoisButtonClick(){
        if(quantidadePrincipalDois <= 0){
            quantidadePrincipalDois = 0;
        } else {
            quantidadePrincipalDois--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void maisTresButtonClick(){
        quantidadePrincipalTres++;
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void menosTresButtonClick(){
        if(quantidadePrincipalTres <= 0){
            quantidadePrincipalTres = 0;
        } else {
            quantidadePrincipalTres--;
        }
        atualizarquantidade();
        adicionado();
    }
    @FXML
    protected void atualizarquantidade(){
        txtUmP.setText(String.valueOf(quantidadePrincipalUm));
        txtDoisP.setText(String.valueOf(quantidadePrincipalDois));
        txtTresP.setText(String.valueOf(quantidadePrincipalTres));
    }
    @FXML
    protected void adicionado(){
        btnAdicionadoP.setVisible(false);
    }
    @FXML
    protected void continuarButtonClick(){
        StringBuilder resumo = new StringBuilder("Resumo do Carrinho:\n");
        double total = 0;

        // Exemplo da classe TelaSeisController
        if (quantidadePrincipalUm >= 0) {
            Item item = new Item(txtPrincipalUm.getText(), quantidadePrincipalUm, 30);
            Carrinho.getInstancia().adicionarItem(item);
        }

        if (quantidadePrincipalDois >= 0) {
            Item item = new Item(txtPrincipalDois.getText(), quantidadePrincipalDois, 30);
            Carrinho.getInstancia().adicionarItem(item);

        }

        if (quantidadePrincipalTres >= 0) {
            Item item = new Item(txtPrincipalTres.getText(), quantidadePrincipalTres, 30);
            Carrinho.getInstancia().adicionarItem(item);
        }

        resumo.append("\nTotal: ").append(total).append("€");

        // Chame o método para mostrar o resumo no carrinho
        HelloApplication.getTelaCarrinhoController().addItemsToSharedCart(itensCarrinho);
        if ( quantidadePrincipalUm > 0 || quantidadePrincipalDois > 0 || quantidadePrincipalTres > 0){
            btnAdicionadoP.setVisible(true);
        }
    }
}


