package br.com.ebix.desafio.crud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.ebix.desafio.crud.model.Escola;

@Repository
public class EscolaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Escola> list() {
		String sql = "SELECT id, nome, endereco FROM escola";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Escola.class));
	}

	public void insert(Escola escola) {
		String sql = "INSERT INTO escola (nome, endereco) VALUES (:nome, :endereco)";
		jdbcTemplate.update(sql, escola);
	}

	public void update(Escola escola) {
		String sql = "UPDATE escola SET nome = :nome AND endereco = :endereco";
		jdbcTemplate.update(sql, escola);
	}

	public void delete(Escola escola) {
		String sql = "DELETE FROM escola WHERE id = :id";
		jdbcTemplate.update(sql, escola);
	}

	public Escola getById(int id) {
		String sql = "SELECT * FROM escola WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new EscolaMapper());
	}

	/**
	 * classe interna estática 
	 * RowMapper para Escola
	 *
	 */
	private static final class EscolaMapper implements RowMapper<Escola> {
		public Escola mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Escola escola = new Escola();
			escola.setId(rs.getInt("id"));
			escola.setNome(rs.getString("nome"));
			escola.setEndereco(rs.getString("endereco"));

			return escola;
		}
	}
}
