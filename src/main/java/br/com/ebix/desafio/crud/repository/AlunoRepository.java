package br.com.ebix.desafio.crud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.ebix.desafio.crud.model.Aluno;
import br.com.ebix.desafio.crud.model.TransporteEscolar;

@Repository
public class AlunoRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Aluno> list() {
		String sql = "SELECT id, nome, endereco FROM aluno";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Aluno.class));
	}

	public void insert(Aluno aluno) {
		String sql = "INSERT INTO aluno (nome, endereco) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { aluno.getNome(), aluno.getEndereco() });
	}

	public void update(Aluno aluno) {
		String sql = "UPDATE aluno SET nome = ? AND endereco = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { aluno.getNome(), aluno.getEndereco(), aluno.getId() });
	}

	public void delete(int id) {
		String sql = "DELETE FROM aluno WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	public Aluno getById(int id) {
		String sql = "SELECT * FROM aluno WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new AlunoMapper());
	}

	/**
	 * classe interna estática 
	 * RowMapper para Aluno
	 *
	 */
	private static final class AlunoMapper implements RowMapper<Aluno> {
		public Aluno mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Aluno aluno = new Aluno();
			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setEndereco(rs.getString("endereco"));

			return aluno;
		}
	}
}