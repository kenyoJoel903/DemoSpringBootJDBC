package com.kenyo.demo.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenyo.demo.model.Customer;

@Repository
public class CustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository {

	@Autowired
	public CustomerRepositoryImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	@Override
	public void create(Customer customer) {
		String sql = "INSERT INTO customer (first_name, last_name) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[] {customer.getFirstName(), customer.getLastName()});
		
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customer SET first_name = ?, last_name = ? WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] {customer.getFirstName(), customer.getLastName(), customer.getId()});
		
	}

	@Override
	public List<Customer> listAll() {
		String sql = "SELECT id, first_name, last_name FROM customer";
		List<Customer> list = getJdbcTemplate().query(sql, (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
				//getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
		return list;
	}

	@Override
	public Customer find(long id) {
		String sql = "SELECT id, first_name, last_name FROM customer  WHERE id = ?";
		Customer customer = getJdbcTemplate().queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<Customer>(Customer.class));
		return customer;
	}

	@Transactional("transactionManager")
	@Override
	public void delete(long id) {
		String sql ="DELETE FROM customer WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[] {id});
		
	}

	
}
