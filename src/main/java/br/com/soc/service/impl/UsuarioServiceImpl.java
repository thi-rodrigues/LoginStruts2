package br.com.soc.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			sql.append(usuario.getTempoativividade() + ")");

			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
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
			ps.setString(1, usuario.getNome());
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					usuarioResult.setNome(rs.getString("NM_LOGIN"));
					usuarioResult.setTempoativividade(rs.getLong("QT_TEMPO_INATIVIDADE"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioResult;
	}

}
