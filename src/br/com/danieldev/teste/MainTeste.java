package br.com.danieldev.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.danieldev.control.ConBanco;
import br.com.danieldev.control.DAO.AlunoDAO;
import br.com.danieldev.model.Aluno;

public class MainTeste {

	public static void main(String[] args) {
		try {
			List<Aluno> lista = new ArrayList<>();
			lista = AlunoDAO.listarTodos();
			
			for(Aluno a : lista){
				System.out.println("ID: " + a.getId());
				System.out.println("Nome: " + a.getNome());
				System.out.println("Data de Nascimento: " + a.getDataN());
				System.out.println("Curso: " + a.getCurso());
				System.out.println("--------------------------------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println("Erro no teste : "+e.getMessage());
		}

	}

}
