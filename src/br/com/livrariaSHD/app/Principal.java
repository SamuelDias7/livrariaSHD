package br.com.livrariaSHD.app;

import br.com.livrariaSDH.dao.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Instanciandoo objetos
		Conexao objCon = new Conexao();
		LivrosDAO manDados = new LivrosDAO();
		
	
		
		// Checa se a conexão com o banco de dados foi bem sucedida
		objCon.Conexao();
		
		// Escolha aa oeração que deseja fazer
		manDados.Escolha();
		
		// Recebe os dados e os manda para o banco de dados e checa se a conexão foi bem sucedida
		//manDados.inserirDados();
		
		//Recupera os dados e printa no console
		//manDados.recuperardados();
		
		manDados.continuar();
		
		
	}

}
