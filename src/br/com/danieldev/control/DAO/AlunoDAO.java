package br.com.danieldev.control.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import br.com.danieldev.control.ConBanco;
import br.com.danieldev.model.Aluno;

public class AlunoDAO extends DAO {
   
	public static List<Aluno> listarTodos() throws Exception{
		
		List<Aluno> lista_alunos = new ArrayList<Aluno>();
		try {
			ConBanco.abrirCon();
			Criteria crit = ConBanco.getSession().createCriteria(Aluno.class);
			lista_alunos = crit.list();
			
			return lista_alunos;			
		} catch (Exception e) {
			throw new Exception("Erro ao listar alunos: " + e);
        }finally{
            ConBanco.fecharCon();
        }
	}
	
}
