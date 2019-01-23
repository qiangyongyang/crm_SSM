package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.BaseDictService;
import com.crm.service.CustomerService;
import com.crm.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType",levelType);
		
		//通过四个条件，查询分页对象
		Page<Customer> page=customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		//页面回显
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		
		
		return "customer";
	}
	
	
	//去修改页面，返回一个json数据
	@RequestMapping("/customer/edit.action")
	public  @ResponseBody
	Customer edit(Integer id){
		return  customerService.selectCustomerById(id);
	}
	
	//更新客户
	@RequestMapping("customer/update.action")
	public @ResponseBody 
	String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	//删除客户
	@RequestMapping("customer/delete.action")
	public @ResponseBody 
	String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "ok";
	}
}















