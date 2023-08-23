package com.example.appallwally;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class TelaCarrinhoController {
    @FXML
    private TextArea txtResumoCarrinho; // Vincule isso ao elemento TextArea em seu FXML
    @FXML
    private Button btnPagar;
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
        HelloApplication.changeScreen(4);
    }
    private List<Item> sharedItemsCarrinho = new ArrayList<>();

    public void addItemsToSharedCart(List<Item> items) {
        sharedItemsCarrinho.addAll(items);
    }
    @FXML
    public void initialize() {
        Carrinho carrinho = Carrinho.getInstancia();
        List<Item> itensCarrinho = carrinho.getItens();

        // Exibir itens do carrinho e total
        StringBuilder resumo = new StringBuilder("Resumo do Carrinho:\n");
        double total = 0;

        for (Item item : itensCarrinho) {
            resumo.append(item.getNome()).append(" - ").append(item.getQuantidade())
                    .append(" x ").append(item.getPreco()).append("\n");
            total += item.getQuantidade() * item.getPreco();
        }

        resumo.append("\nTotal: ").append(total).append("€");

        txtResumoCarrinho.setText(resumo.toString());
        if(total > 0){
            btnPagar.setVisible(true);
        } else{
            btnPagar.setVisible(false);
        }
    }

    @FXML
    protected void limparTela() {
        Carrinho carrinho = Carrinho.getInstancia();
        carrinho.limparCarrinho();

        txtResumoCarrinho.setText("Resumo do Carrinho:\nTotal: 0,00€");
    }

    @FXML
    protected void pagamentoButtonClick(){
        HelloApplication.changeScreen(10);
    }


}
