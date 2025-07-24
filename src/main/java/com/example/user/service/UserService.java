package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void registerUser(String username, String email, String password) {
		String sql = """
				    WITH insert_user AS (
				        INSERT INTO users(username, email, password)
				        SELECT ?, ?, ?
				        WHERE NOT EXISTS (
				            SELECT 1 FROM users WHERE email = ?
				        )
				        RETURNING id
				    )
				    SELECT * FROM insert_user;
				""";
		jdbcTemplate.query(sql, rs -> {
		}, username, email, password, email);
	}
}
