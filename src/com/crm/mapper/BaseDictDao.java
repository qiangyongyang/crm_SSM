package com.crm.mapper;

import java.util.List;

import com.crm.pojo.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictByCode(String code);
}
