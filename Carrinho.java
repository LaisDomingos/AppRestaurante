package com.example.appallwally;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static Carrinho instancia;
    private List<Item> itens;

    private Carrinho() {
        itens = new ArrayList<>();
    }

    public static Carrinho getInstancia() {
        if (instancia == null) {
            instancia = new Carrinho();
        }
        return instancia;
    }

    public List<Item> getItens() {
        return itens;
    }
    public void adicionarItem(Item item) {

            boolean itemJaExistente = false;
            for (Item carrinhoItem : itens) {
                if (carrinhoItem.mesmoNome(item)) {
                    carrinhoItem.setQuantidade(item.getQuantidade()); // Atualiza a quantidade
                    itemJaExistente = true;
                    if (item.getQuantidade() == 0) {
                        removerItemPeloNome(item.getNome()); // Remove o item pelo nome
                    }
                    break;
                }

            }

            if (!itemJaExistente) {
                if (item.getQuantidade() != 0){
                    itens.add(item);
                }

            }
    }


    public void removerItemPeloNome(String nome) {
        itens.removeIf(item -> item.getNome().equals(nome));
    }

    public void limparCarrinho() {
        itens.clear();
    }
}
