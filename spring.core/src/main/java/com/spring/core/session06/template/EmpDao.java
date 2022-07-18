package com.spring.core.session06.template;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.core.session06.entity.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired 
	private ComboPooledDataSource dataSource;
	
	
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid, ename, age, createtime from emp";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Emp> queryAllEmps1() {
		String sql = "select eid, ename, age, createtime from emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreatetime(rs.getDate("createTime"));
			
			return emp;
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Emp> queryAllEmps2() {
		String sql = "select eid, ename, age, createtime from emp";
	
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
	}
	
	
	
}
