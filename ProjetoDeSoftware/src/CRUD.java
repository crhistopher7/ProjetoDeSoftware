
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisl
 */
public class CRUD {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
   
    private static final String USER = "ufnprojetomove";

    private static final String PASS = "USc5KrG_77nwVC";
    
    private static final String URL = "jdbc:mysql://ufnprojetomove.mysql.dbaas.com.br:3306/ufnprojetomove?useTimeZone=true&serverTimezone=UTC&user="+USER+"&password="+PASS;
    
    Connection c;
    Statement stmt = null;
    
    public void connect() {
        try {
            Class.forName(DRIVER).newInstance();
             c = DriverManager.getConnection(URL);
            System.out.println("Conectado!");           
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        }
    }

    public String login(String email, String pass) throws SQLException {
        try {
            connect();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `email` FROM `Pessoa` WHERE '"+email+"' = email"); 
            
            if (rs != null && rs.next()) {
                rs = stmt.executeQuery("SELECT `nome` FROM `Pessoa` WHERE `email` = '"+rs.getString("email")+"' and `senha` = '"+pass+"'");
                if (rs != null && rs.next()) {
                    JOptionPane.showMessageDialog(null, "Bem vindo "+rs.getString("nome")+"!");
                    return rs.getString("nome");
                }
            }
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return null;
    }

    ResultSet getEstoque() throws SQLException {
        try {
            connect();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Estoque`"); 
           
            return rs;
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return null;
    }

    int[] addProduto(String codigo, String produto, String quantidade, String tipo, String fornecedor) {
        try {
            connect();
            stmt = c.createStatement();
            int[] result = new int[2];
            result[0] = stmt.executeUpdate("INSERT INTO `Estoque`( `CODIGO`, `NOME`, `TIPO`, `QUANTIDADE`, `FORNECEDOR`) VALUES ("+
                    codigo+",'"+produto+"','"+tipo+"',"+quantidade+",'"+fornecedor+"')" , Statement.RETURN_GENERATED_KEYS);
            System.out.println("Result:" + result);
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                System.out.println("rs: " +rs.getString(1));
                result[1] = Integer.parseInt(rs.getString(1));
            } else {
                result[1] = -1;
            }
               return result;
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return null;
    }

    boolean deleteProduct(int index) {
        try {
            connect();
            stmt = c.createStatement();
            int result = stmt.executeUpdate("DELETE FROM `Estoque` WHERE `ID` = "+index+";"); 

           if (result == 1)
               return true;
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return false;
    }
    
    boolean updateProduct(Produto p) {
        try {
            connect();
            stmt = c.createStatement();
            int result = stmt.executeUpdate("UPDATE `Estoque` SET `CODIGO`= "+p.getCodigo()+
                    ",`NOME`='"+p.getNome()+
                    "',`TIPO`='"+p.getTipo()+
                    "',`QUANTIDADE`= "+p.getQuantidade()+
                    ",`FORNECEDOR`='"+p.getFornecedor()+
                    "' WHERE `ID` = "+p.getId()); 

           if (result == 1)
               return true;
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return false;
    }
}



