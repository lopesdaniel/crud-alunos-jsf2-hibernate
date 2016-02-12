package br.com.danieldev.Bean;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.danieldev.control.DAO.AlunoDAO;
import br.com.danieldev.model.Aluno;

@ManagedBean(name="alunoBean")
@SessionScoped
public class AlunoBean {
	
	private Aluno aluno = new Aluno();
	private DataModel<Aluno> alunos;
	
	public String delAluno(){
		String retorno = "listar";
		
		try {
			AlunoDAO.deletar(aluno);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String updateAluno(){
		String retorno = "listar";
		
		try {
			AlunoDAO.atualizar(aluno);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
//	public DataModel<Aluno> getAlunos(){
//		try {
//			List<Aluno> lista = AlunoDAO.listarTodos();
//			alunos = new ListDataModel<Aluno>(lista);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return alunos;
//	}
	
	
	
	public void setAlunos(DataModel<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public DataModel<Aluno> getAlunos() {
		
		try {
			List<Aluno> lista = new ArrayList<>();
			lista = AlunoDAO.listarTodos();
			
			alunos = new ListDataModel<Aluno>(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String addAluno(){
		String retorno = "listar";
		try {
			AlunoDAO.adicionar(aluno);
			} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public void selecionarReg(){
		this.aluno = alunos.getRowData();
	}
	
	public void novoReg(){
		this.aluno = new Aluno();
	}
	
}
