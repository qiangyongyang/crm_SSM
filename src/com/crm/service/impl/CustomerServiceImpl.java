package com.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.mapper.CustomerDao;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.CustomerService;
import com.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	
	//通过四个条件，分页查询对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page=new Page<Customer>();
		vo.setSize(5);
		page.setSize(10);
		
		if(vo!=null){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() -1)*vo.getSize());
			}
			if(vo.getCustName()!=null ){
				vo.setCustName(vo.getCustName());
			}
			if(vo.getCustSource()!=null){
				vo.setCustSource(vo.getCustSource());
			}
			if(vo.getCustIndustry()!=null){
				vo.setCustIndustry(vo.getCustIndustry());
			}
			if(vo.getCustLevel()!=null){
				vo.setCustLevel(vo.getCustLevel());
			}
		}
		//
		page.setTotal(customerDao.customerCount(vo));
		page.setRows(customerDao.selectCustomerListByQueryVo(vo));
	
		
		
		return page;
	}
	
	
	public Customer selectCustomerById(Integer id){
		return customerDao.selectCustomerById(id);
	}

	public void updateCustomerById(Customer customer){
		customerDao.updateCustomerById(customer);
	}
	
	public void deleteCustomerById(Integer id){
		customerDao.deleteCustomerById(id);
	}
}
