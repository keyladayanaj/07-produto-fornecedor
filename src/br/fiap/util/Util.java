package br.fiap.util;
import br.fiap.fornecedor.Fornecedor;
import produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Util {

    private Produto[] produto = new Produto[200];
    private Fornecedor[] fornecedor = new Fornecedor[200];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    public void menu() {

        int opcao;
        String msg = "1. Cadastrar produto \n2. Pesquisar produto\n"+
                "3. Pesquisar fornecedor\n4. Finalizar";

        while(true){
            opcao = parseInt(showInputDialog(msg));
            if(opcao == 4){
                return;
            }
            switch(opcao){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                default:
                    showInputDialog(null, "Opção inválida");

            }
        }
    }

    private void pesquisar(){
        String aux = " ";
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor != null){
            aux += "Fornecedor" + fornecedor.getNome() + "\n";
            aux += "CNPJ" + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, aux);
        }
    }

    private void cadastrarProduto(){
        String nome;
        int quantidadeEstoque;
        double valorUnitario;
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor == null){
            fornecedor = cadastrarFornecedor();
        }

        nome = showInputDialog("Nome do produto");
        quantidadeEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        valorUnitario = parseDouble(showInputDialog("Valor unitário"));
        produto[idxProduto] = new Produto(nome, fornecedor, valorUnitario, quantidadeEstoque);
        idxProduto++;

    }

    private Fornecedor cadastrarFornecedor (){

        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        String nome = showInputDialog("Nome");

        fornecedor[idxFornecedor] = new Fornecedor(nome,cnpj);
        idxFornecedor++;

        return fornecedor[idxFornecedor-1];
    }

    private void pesquisarProduto(){

        String aux = "Produto não encontrado";
        String nome = showInputDialog("Nome do produto");

        for(int i =0; i< idxProduto; i++){
            if(produto[i].getNome().equalsIgnoreCase(nome)){
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário: R$ " + produto[i].getValorUnitario() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";


            }
        }

        showInputDialog(null,aux);

    }

    private Fornecedor pesquisarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));

        for(int i =0; i< idxFornecedor; i++) {
            if(fornecedor[i].getCnpj() == cnpj){
                return fornecedor[i];

            }
        }

        showInputDialog(null,"CNPJ não cadastrado");
        return null;
    }


}
