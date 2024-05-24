package br.com.soc.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import br.com.soc.dao.ConnectionDao;
import br.com.soc.domain.Usuario;
import br.com.soc.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	public static Connection getConnection() throws Exception {
		return ConnectionDao.getConnection();
	}

	@Override
	public void saveUsuario(Usuario usuario) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		try {
			StringBuilder sql = new StringBuilder("INSERT INTO USUARIO VALUES ('");
			sql.append(usuario.getNome() + "', ");
			sql.append("MD5('" + usuario.getSenha() + "'), ");
			sql.append(usuario.getTempoInativividade() + ")");

			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
			System.out.println("method saveUsuario: " + sql.toString());
			ps.executeUpdate();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		Usuario usuarioResult = new Usuario();
		try {
			StringBuilder sql = new StringBuilder("SELECT NM_LOGIN, QT_TEMPO_INATIVIDADE FROM USUARIO WHERE ");
			sql.append("NM_LOGIN =? ");
			sql.append("AND DS_SENHA = MD5('" + usuario.getSenha() + "') ");

			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
			System.out.println("method buscarUsuario: " + sql.toString());
			ps.setString(1, usuario.getNome());
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					usuarioResult.setNome(rs.getString("NM_LOGIN"));
					usuarioResult.setTempoInativividade(rs.getLong("QT_TEMPO_INATIVIDADE"));
					// SETAR O HORARIO DA AUTENTICACAO
					registrarUsuarioAltenticado(usuarioResult.getNome(), usuarioResult.getTempoInativividade());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioResult;
	}

	private void registrarUsuarioAltenticado(String nome, Long tempoInativividade) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		try {
			
			String sql = "UPDATE USUARIO SET AUTENTICADO = CURRENT_TIMESTAMP + INTERVAL ? MINUTE"
					+ "		WHERE NM_LOGIN = ?";

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, tempoInativividade);
			ps.setString(2, nome);
			System.out.println("method registrarUsuarioAltenticado: " + sql);
			ps.executeUpdate();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public boolean usuarioAutenticado(Usuario usuario) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		boolean usuarioAutenticado = false;
		try {
			StringBuilder sql = new StringBuilder("SELECT EXISTS( "
					+ "	SELECT * FROM USUARIO WHERE NM_LOGIN =? AND AUTENTICADO > CURRENT_TIMESTAMP() "
					+ ") IS_AUTENTICADO ;");

			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
			System.out.println("method usuarioAutenticado: " + sql);
			ps.setString(1, usuario.getNome());
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					usuarioAutenticado = rs.getBoolean("IS_AUTENTICADO");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioAutenticado;
	}

	@Override
	public List<Usuario> buscarUsuarios() throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		List<Usuario> usuarios = new LinkedList<>();
		Usuario usuario = new Usuario();
		
		try {
			StringBuilder sql = new StringBuilder("SELECT NM_LOGIN, QT_TEMPO_INATIVIDADE FROM USUARIO");

			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					usuario.setNome(rs.getString("NM_LOGIN"));
					usuario.setTempoInativividade(rs.getLong("QT_TEMPO_INATIVIDADE"));
					usuarios.add(usuario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
