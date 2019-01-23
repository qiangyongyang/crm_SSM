package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.mapper.BaseDictDao;
import com.crm.pojo.BaseDict;
import com.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictDao baseDictDao;
	
	public List<BaseDict> selectBaseDictByCode(String code){
		return baseDictDao.selectBaseDictByCode(code);
	}
}

















