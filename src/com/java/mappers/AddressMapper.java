package com.java.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.java.model.Address;
//ӳ��

//�ӿ�
public interface AddressMapper {

	//����   һ��һ����ӳ��
	@Select("select * from t_address where id=#{id}")
	public Address findById(Integer id);
}
