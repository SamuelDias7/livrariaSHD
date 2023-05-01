package br.com.livrariaSDH.dao;

import br.com.livrariaSHD.pojo.*;

import javax.swing.JOptionPane;

import java.sql.*;

public class LivrosDAO {
	
	Usuario dados = new Usuario();
	
	public void Escolha() {
		Object[] opcao = {"Cadastrar","Consultar"};
		Object valorOpcao;
		valorOpcao = JOptionPane.showInputDialog(null, "Escolha a opcao:" , "Escolha", JOptionPane.INFORMATION_MESSAGE,null, opcao,opcao[0]);

		if(valorOpcao == "Cadastrar") {
			this.inserirDados();
			
		}else {
			this.recuperardados();
			
		}
		
	}
	
	public void inserirDados() {
		dados.setNome(JOptionPane.showInputDialog("Informe o seu nome:"));
		dados.setLivro(JOptionPane.showInputDialog("Informe o nome do livro:"));
		dados.setAutor(JOptionPane.showInputDialog("Informe o autor do livro:"));
		String ano = JOptionPane.showInputDialog("Informe o ano de lançamento do livro:");
		dados.setAno(Integer.parseInt(ano));
		
		//JOptionPane.showMessageDialog(null, dados.getNome() + "\n" + dados.getLivro() + "\n" + dados.getAutor() + "\n" + dados.getAno());
		JOptionPane.showMessageDialog(null, "Os dados foram inseridos");
		
		Connection Conn = Conexao.Conexao();
		
		String sql = "INSERT INTO livros (nome, livro, autor,ano) VALUES (?,?,?,?)";

		try {
			
			PreparedStatement stmt = Conn.prepareStatement(sql);
			
			stmt.setString(1, dados.getNome());
			stmt.setString(2, dados.getLivro());
			stmt.setString(3, dados.getAutor());
			stmt.setInt(4, dados.getAno());
			
			int resultado = stmt.executeUpdate();
			
			if(resultado>0) {
				System.out.println("Dados inseridos");
				
			}else {
				System.out.println("Erro ao inserir dados");
				
			}
			
			stmt.close();
			Conn.close();
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
		
	}
	public void recuperardados() {
		Connection Conn = Conexao.Conexao();
		String sql = "SELECT * FROM livros";
		
		try {
			PreparedStatement stmt = Conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				String livro = rs.getString("livro");
				String autor = rs.getString("autor");
				int ano = rs.getInt("ano");
				
				System.out.println("Nome:" + nome + " Livro:" + livro + " Autor:" + autor + " Ano:" + ano);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		
	}
	
	// Tem que arrumar isso ai, if else acho que ajudaria
	public void continuar() {
		Object[] continuar = {"Continuar", "Sair"};
		Object valorContinuar;
		
		
		do {
		//this.Escolha();
		valorContinuar = JOptionPane.showInputDialog(null, "Fazer novamente?" , "Deseja Continaur?" , JOptionPane.INFORMATION_MESSAGE,null,continuar,continuar[0]);

		if(valorContinuar=="Continuar") {
			this.Escolha();
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Tenha um bom dia!");
			System.exit(0);
		}

			
		}while(valorContinuar != "Sair");
		
		
		//System.exit(0);
	}

}
