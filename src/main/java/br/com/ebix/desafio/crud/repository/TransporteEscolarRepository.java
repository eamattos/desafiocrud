package br.com.ebix.desafio.crud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.ebix.desafio.crud.model.TransporteEscolar;

@Repository
public class TransporteEscolarRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<TransporteEscolar> list() {
		String sql = "SELECT id, nome, cnpj FROM transporte_escolar";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(TransporteEscolar.class));
	}

	public void insert(TransporteEscolar transporteEscolar) {
		String sql = "INSERT INTO transporte_escolar (nome, cnpj) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { transporteEscolar.getNome(), transporteEscolar.getCnpj() });
	}

	public void update(TransporteEscolar transporteEscolar) {
		String sql = "UPDATE transporte_escolar SET nome = ?, cnpj = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { transporteEscolar.getNome(), transporteEscolar.getCnpj(), transporteEscolar.getId() });
	}

	public void delete(int id) {
		String sql = "DELETE FROM transporte_escolar WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	public TransporteEscolar getById(int id) {
		String sql = "SELECT * FROM transporte_escolar WHERE id = ?";
		
		return (TransporteEscolar) jdbcTemplate.queryForObject(sql, new Object[] { id }, new TransporteEscolarMapper());
	}

	/**
	 * classe interna estática 
	 * RowMapper para Transporte Escolar
	 *
	 */
	private static final class TransporteEscolarMapper implements RowMapper<TransporteEscolar> {
		public TransporteEscolar mapRow(ResultSet rs, int rowNumber) throws SQLException {
			TransporteEscolar transporteEscolar = new TransporteEscolar();
			transporteEscolar.setId(rs.getInt("id"));
			transporteEscolar.setNome(rs.getString("nome"));
			transporteEscolar.setCnpj(rs.getString("cnpj"));
			
			return transporteEscolar;
		}
	}
}