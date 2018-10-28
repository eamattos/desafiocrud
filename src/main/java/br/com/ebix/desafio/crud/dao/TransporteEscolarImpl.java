package br.com.ebix.desafio.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.ebix.desafio.crud.model.TransporteEscolar;

@Repository
public class TransporteEscolarImpl implements ITransporteEscolar {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<TransporteEscolar> list() {
		String sql = "SELECT id, nome FROM transporte_escolar";
		List<TransporteEscolar> listTransporteEscolar = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TransporteEscolarMapper());

		return listTransporteEscolar;
	}

	public void add(TransporteEscolar transporteEscolar) {
		String sql = "INSERT INTO transporte_escolar (nome, endereco) VALUES (:nome)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(transporteEscolar));
	}

	public void update(TransporteEscolar transporteEscolar) {
		String sql = "UPDATE transporte_escolar SET nome = :nome";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(transporteEscolar));
	}

	public void delete(TransporteEscolar transporteEscolar) {
		String sql = "DELETE FROM transporte_escolar WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(transporteEscolar));
	}

	public TransporteEscolar getById(TransporteEscolar transporteEscolar) {
		String sql = "SELECT * FROM transporte_escolar WHERE id = :id";
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(transporteEscolar), new TransporteEscolarMapper());
	}

	private SqlParameterSource getSqlParameterByModel(TransporteEscolar transporteEscolar) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (transporteEscolar != null) {
			parameterSource.addValue("id", transporteEscolar.getId());
			parameterSource.addValue("nome", transporteEscolar.getNome());
		}
		
		return parameterSource;
	}

	/**
	 * classe interna estática 
	 * RowMapper para Aluno
	 *
	 */
	private static final class TransporteEscolarMapper implements RowMapper {
		public TransporteEscolar mapRow(ResultSet rs, int rowNumber) throws SQLException {
			TransporteEscolar transporteEscolar = new TransporteEscolar();
			transporteEscolar.setId(rs.getString("id"));
			transporteEscolar.setNome(rs.getString("nome"));

			return transporteEscolar;
		}
	}
}