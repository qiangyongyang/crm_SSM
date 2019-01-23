package com.crm.service;

import java.util.List;

import com.crm.pojo.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> selectBaseDictByCode(String code);
}	
