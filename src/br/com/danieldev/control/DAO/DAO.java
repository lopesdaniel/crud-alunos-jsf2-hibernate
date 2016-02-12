package br.com.danieldev.control.DAO;

import br.com.danieldev.control.ConBanco;

public class DAO {
	
	public static void adicionar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().save(obj);
			ConBanco.getTransaction().commit();			
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao salvar objeto... " + e.getMessage());
			
		}finally {
			ConBanco.fecharCon();
		}
	}
	
	public static void deletar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().delete(obj);
			ConBanco.getTransaction().commit();
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao deletar objeto... " + e.getMessage());
		}finally {
			ConBanco.fecharCon();
		}
	}
	
	public static void atualizar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().update(obj);
			ConBanco.getTransaction().commit();
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao atualizar objeto... " + e.getMessage());
		}finally {
			ConBanco.fecharCon();
		}
	}

}
