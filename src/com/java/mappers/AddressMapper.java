package com.java.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.java.model.Address;
//映射

//接口
public interface AddressMapper {

	//查找   一对一关联映射
	@Select("select * from t_address where id=#{id}")
	public Address findById(Integer id);
}
