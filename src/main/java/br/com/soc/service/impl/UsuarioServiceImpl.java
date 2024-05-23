package br.com.soc.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			sql.append("md5('" + usuario.getSenha() + "'), ");
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

	public List<Usuario> listUsuario() throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		List<Usuario> usuarios = new LinkedList<>();
//		try {
//			String sql = "SELECT * FROM LOGIN WHERE IC_ATIVO = 1 ORDER BY NM_LOGIN LIMIT 5 ";
//			PreparedStatement ps = getConnection().prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//
//			if (rs != null) {
//				while (rs.next()) {
//					Usuario bean = new Usuario();
//					bean.setNome(rs.getString("NM_LOGIN"));
//					bean.setSenha(rs.getString("DS_SENHA"));
//					usuarios.add(bean);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return usuarios;
	}

	@Override
	public List<Usuario> buscarUsuarios(Usuario usuario) throws SQLException, Exception {
		List<Usuario> usuarios = new LinkedList<>();
		getConnection().setAutoCommit(false);
//		try {
//			StringBuilder sql = new StringBuilder("SELECT * FROM LOGIN WHERE 1=1 ");
//			if (usuario.getId() != null)
//				sql.append(" AND CD_LOGIN = " + usuario.getId());
//			
//			if (usuario.getNome() != null && !usuario.getNome().equals(""))
//				sql.append(" AND NM_LOGIN = '" + usuario.getNome() + "'");
//			
//			if (usuario.getAtivo() != null && !usuario.getAtivo().equals(2L))
//				sql.append(" AND IC_ATIVO = " + usuario.getAtivo());
//			else if (usuario.getAtivo() != null)
//				sql.append(" AND IC_ATIVO IN (0, 1) ");
//
//			sql.append(" LIMIT 20 ");
//			
//			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
//			ResultSet rs = ps.executeQuery();
//
//			if (rs != null) {
//				while (rs.next()) {
//					usuario.setId(rs.getLong("CD_LOGIN"));
//					usuario.setNome(rs.getString("NM_LOGIN"));
//					usuario.setAtivo(rs.getLong("IC_ATIVO"));
//					usuarios.add(usuario);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (getConnection() != null) {
//				getConnection().close();
//			}
//		}
		return usuarios;
	}
	
	@Override
	public Usuario buscarUsuarioPorId(Long usuarioId) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		Usuario usuario = new Usuario();
//		try {
//			StringBuilder sql = new StringBuilder("SELECT * FROM LOGIN WHERE 1=1 ");
//			if (usuarioId != null)
//				sql.append(" AND CD_LOGIN = " + usuarioId);
			
//			PreparedStatement ps = getConnection().prepareStatement(sql.toString());
//			ResultSet rs = ps.executeQuery();
			
//			if (rs != null) {
//				while (rs.next()) {
//					usuario.setId(rs.getLong("CD_LOGIN"));
//					usuario.setNome(rs.getString("NM_LOGIN"));
//					usuario.setAtivo(rs.getLong("IC_ATIVO"));
//				}
//			}
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (getConnection() != null) {
//				getConnection().close();
//			}
//		}
		return usuario;
	}

	@Override
	public void deleteUsuario(Long usuarioId) throws SQLException, Exception {
//		getConnection().setAutoCommit(false);
//		// NÃO DELETA LOGIN SE ESTIVER LOGIN REALIZADO
//		if (!usuarioRealizado(usuarioId)) {
//			try {
//				String sql = "DELETE FROM LOGIN WHERE CD_LOGIN=?";
//				PreparedStatement ps = getConnection().prepareStatement(sql);
//				ps.setLong(1, usuarioId);
//				ps.executeUpdate();
//			} catch (Exception e) {
//				transaction.rollback();
//				e.printStackTrace();
//			}
//		}
	}

	private Boolean usuarioRealizado(Long usuarioId) {
		int usuarioRealizado = 0;
//		try {
//			String sql = "SELECT COUNT(*) AS COUNT FROM LOGIN_REALIZADO WHERE CD_LOGIN=?";
//			PreparedStatement ps = getConnection().prepareStatement(sql);
//			ps.setLong(1, usuarioId);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if (rs != null) {
//				while (rs.next()) {
//					usuarioRealizado = rs.getInt("COUNT");
//				}
//			}
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//		}
		return usuarioRealizado > 0;
	}

	@Override
	public void updateUsuario(Usuario usuario) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
//		try {
//			String sql = "UPDATE LOGIN SET NM_LOGIN=?, IC_ATIVO =? WHERE CD_LOGIN=? ";
//			PreparedStatement ps = getConnection().prepareStatement(sql);
//			ps.setString(1, usuario.getNome());
//			ps.setString(2, usuario.getSenha());
//			ps.setLong(3, usuario.getTempoativividade());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			getConnection().rollback();
//		} finally {
//			if (getConnection() != null) {
//				getConnection().close();
//			}
//		}
	}
	
}
