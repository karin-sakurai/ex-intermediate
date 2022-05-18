package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Baseballteam;

@Repository
public class BaseballRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Baseballteam> TEAM_ROW_MAPPER = (rs, i) -> {
		Baseballteam team=new Baseballteam();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	// 野球チームの主キー検索をするメソッド
	public Baseballteam load(Integer id) {
		String sql = "SELECT * FROM teams WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Baseballteam baseballteam = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return baseballteam;
	}

	// 野球チームの全件検索を行うメソッド
	public List<Baseballteam> findAll() {
		String sql = "SELECT * FROM teams ORDER BY inauguration";
		List<Baseballteam> baseballteam = template.query(sql, TEAM_ROW_MAPPER);
		return baseballteam;
	}

}
