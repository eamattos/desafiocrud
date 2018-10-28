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

import br.com.ebix.desafio.crud.model.Aluno;

@Repository
public class AlunoDaoImpl implements IAlunoDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Aluno> list() {
		String sql = "SELECT id, nome, endereco FROM aluno";
		List<Aluno> listAluno = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new AlunoMapper());

		return listAluno;
	}

	public void add(Aluno aluno) {
		String sql = "INSERT INTO aluno (nome, endereco) VALUES (:nome, :endereco)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(aluno));
	}

	public void update(Aluno aluno) {
		String sql = "UPDATE aluno SET nome = :nome AND endereco = :endereco";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(aluno));
	}

	public void delete(Aluno aluno) {
		String sql = "DELETE FROM aluno WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(aluno));
	}

	public Aluno getById(Aluno aluno) {
		String sql = "SELECT * FROM aluno WHERE id = :id";
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(aluno), new AlunoMapper());
	}

	private SqlParameterSource getSqlParameterByModel(Aluno aluno) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		if (aluno != null) {
			parameterSource.addValue("id", aluno.getId());
			parameterSource.addValue("nome", aluno.getNome());
			parameterSource.addValue("endereco", aluno.getEndereco());
		}
		
		return parameterSource;
	}

	/**
	 * classe interna estática 
	 * RowMapper para Aluno
	 *
	 */
	private static final class AlunoMapper implements RowMapper {
		public Aluno mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Aluno aluno = new Aluno();
			aluno.setId(rs.getString("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setEndereco(rs.getString("endereco"));

			return aluno;
		}
	}
}