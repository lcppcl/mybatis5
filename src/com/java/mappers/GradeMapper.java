package com.java.mappers;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.model.Address;
import com.java.model.Grade;
import com.java.model.Student;
import org.apache.ibatis.annotations.Many;
//ӳ��

//�ӿ�
public interface GradeMapper {

	// һ�Զ����ӳ��
	@Select("select * from t_grade where id=#{id}")
	@Results({
		//����ÿ���ֶε�ӳ�� 
		@Result(id=true,column="id",property="id"), //����idΪtrue��
		@Result(column="gradeName",property="gradeName"),
		@Result(column="id",property="students",many=@Many(select="com.java.mappers.StudentMapper.selectStudentByGradeId"))
	})
	public Grade findById(Integer id);
}
