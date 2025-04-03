package produto;


import br.fiap.fornecedor.Fornecedor;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Produto {

    private String nome;
    private int quantidadeEstoque;
    private double valorUnitario;
    private Fornecedor fornecedor;



    public Produto(String nome, Fornecedor fornecedor, double valorUnitario, int quantidadeEstoque) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public String getNome() {
        return nome;
    }

    public void setNomeProduto(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
