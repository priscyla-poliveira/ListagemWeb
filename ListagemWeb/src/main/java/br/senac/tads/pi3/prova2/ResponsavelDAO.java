/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.prova2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ftsuda-senac
 */
public class ResponsavelDAO {

    private Connection obterConexao() throws ClassNotFoundException, SQLException {
	// 1) Declarar o driver JDBC de acordo com o Banco de dados usado
	Class.forName("org.h2.Driver");

	// 2) Abrir a conexão
	// O arquivo do banco de dados está localizado no diretório C:\Users\<NOME_USUARIO>\pi3b-tarefabd.mv
	Connection conn = DriverManager.getConnection(
		"jdbc:h2:file:~/pi3b-tarefabd;LOCK_TIMEOUT=10000;COLLATION=PORTUGUESE_BRAZIL",
		"sa",
		"");
	return conn;
    }

    /**
     * Cria a tabela de autores se não existir.
     */
    public void criarTabela() {
	String sql = "CREATE TABLE IF NOT EXISTS responsavel (id INT PRIMARY KEY auto_increment, nome VARCHAR(255) NOT NULL)";
	int resultados = 0;
	try (Connection conn = obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    resultados = stmt.executeUpdate();
	} catch (SQLException ex) {
	    ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}
    }
    
    /**
     * Obtém os responsaveis cadastrados no banco de dados
     * @return Lista com objetos do tipo {@link Responsavel}
     * 
     */
    public List<Responsavel> listar() {
        String sql = "SELECT id, nome FROM responsavel";
        List<Responsavel> resultados = new ArrayList<>();
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Responsavel responsavel = new Responsavel(rs.getInt("id"), rs.getString("nome"));
                resultados.add(responsavel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return resultados;
    }

    /**
     * Inclui um novo responsavel no banco de dados
     * @param responsavel Objeto com as informações do responsavel
     * @return quantidade de linhas afetadas no banco de dados após a execução do comando
     */
    public int salvar(Responsavel responsavel) {
	String sql = "INSERT INTO responsavel (nome) VALUES (?)";
	int qtResultados = 0;
	try (Connection conn = obterConexao();
		PreparedStatement stmt = conn.prepareStatement(sql)) {
	    stmt.setString(1, responsavel.getNome());
	    qtResultados = stmt.executeUpdate();
	} catch (SQLException ex) {
	    ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}
	return qtResultados;
    }
}
