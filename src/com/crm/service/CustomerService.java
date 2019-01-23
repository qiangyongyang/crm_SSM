package com.crm.service;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.utils.Page;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	public Customer selectCustomerById(Integer id);
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(Integer id);
}
