/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisl
 */
public class Produto {
    private String nome;
    private String tipo;
    private float quantidade;
    private int id;
    private int codigo;
    private String fornecedor;

    public Produto(String nome, String tipo, float quantidade, int id, int codigo) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.id = id;
        this.codigo = codigo;
    }

    Produto(String nome, String tipo, float quantidade, int id, int codigo, String fornecedor) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.id = id;
        this.codigo = codigo;
        this.fornecedor = fornecedor;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
