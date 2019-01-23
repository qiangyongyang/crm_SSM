package com.crm.mapper;

import java.util.List;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

public interface CustomerDao {
	//总条数
	public Integer customerCount(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	
	
	//根据id查询客户
	public Customer selectCustomerById(Integer id);
	
	public void updateCustomerById(Customer customer);
	
	public void deleteCustomerById(Integer id);
}
