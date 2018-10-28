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

import br.com.ebix.desafio.crud.model.Escola;

@Repository
public class EscolaDaoImpl implements IEscolaDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Escola> list() {
		String sql = "SELECT id, nome, endereco FROM aluno";
		List<Escola> listAluno = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EscolaMapper());

		return listAluno;
	}

	public void add(Escola escola) {
		String sql = "INSERT INTO aluno (nome, endereco) VALUES (:nome, :endereco)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(escola));
	}

	public void update(Escola escola) {
		String sql = "UPDATE aluno SET nome = :nome AND endereco = :endereco";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(escola));
	}

	public void delete(Escola escola) {
		String sql = "DELETE FROM aluno WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(escola));
	}

	public Escola getById(Escola escola) {
		String sql = "SELECT * FROM aluno WHERE id = :id";
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(escola), new EscolaMapper());
	}

	private SqlParameterSource getSqlParameterByModel(Escola escola) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (escola != null) {
			parameterSource.addValue("id", escola.getId());
			parameterSource.addValue("nome", escola.getNome());
			parameterSource.addValue("endereco", escola.getEndereco());
		}
		
		return parameterSource;
	}

	/**
	 * classe interna estática 
	 * RowMapper para Aluno
	 *
	 */
	private static final class EscolaMapper implements RowMapper {
		public Escola mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Escola escola = new Escola();
			escola.setId(rs.getString("id"));
			escola.setNome(rs.getString("nome"));
			escola.setEndereco(rs.getString("endereco"));

			return escola;
		}
	}
}
