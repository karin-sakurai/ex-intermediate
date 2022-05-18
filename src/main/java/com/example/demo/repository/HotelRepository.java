package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};

//	料金からホテルを検索するメソッド
	public List<Hotel> findByPrice(Integer price) {
		String sql = "SELECT * FROM hotels WHERE price<=:price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> list = template.query(sql, param, HOTEL_ROW_MAPPER);
		return list;
	}

//	全件検索するメソッド
	public List<Hotel> findAll() {
		String sql = "SELECT * FROM hotels;";
		List<Hotel> list = template.query(sql, HOTEL_ROW_MAPPER);
		return list;
	}

}
