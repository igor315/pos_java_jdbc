package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {// metodo de insert no banco de dados
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Magalhaes");
		userposjava.setEmail("magalhaes@.com.br");

		userPosDAO.salvar(userposjava);
	}

	/*
	 * @Test public void initListar() { UserPosDAO dao = new UserPosDAO(); try {
	 * List<Userposjava> list = dao.listar();
	 * 
	 * for (Userposjava userposjava : list) { System.out.println(userposjava); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 */

	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {
		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(7L);

			objetoBanco.setNome("breda");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {

		try {

			UserPosDAO dao = new UserPosDAO();
			dao.deletar(8L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void TesteInsertTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(68)7433-1982");
		telefone.setTipo("condominio");
		telefone.setUsuario(11L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);

	}

	@Test
	public void testeCarregaFonesUser() {

		UserPosDAO dao = new UserPosDAO();

		List<BeanUserFone> beanUserFones = dao.ListaUserFone(10L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-----------------------");
		}

	}

	@Test
	public void testDeleUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(10L);
	}
	
}
