/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisl
 */
class Fornecedor {
    private String nome;
    private String endereço;
    private String telefone;
    private String cnpj;

    public Fornecedor(String nome, String endereço, String telefone, String cnpj) {
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
