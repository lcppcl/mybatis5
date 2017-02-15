package com.java.mappers;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.model.Student;
//接口
public interface StudentMapper {
	//一对一关联映射
	@Select("select * from t_student where id=#{id}")
	@Results({
		//定义每个字段的映射 
		@Result(id=true,column="id",property="id"), //主键id为true，
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById"))
	})
	public Student selectStudentWithAddress(Integer id);
	
	//一对多关联映射
	@Select("select * from t_student where gradeId=#{gradeId}")
	@Results({
		//定义每个字段的映射 
		@Result(id=true,column="id",property="id"), //主键id为true，
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById"))
	})
	public Student selectStudentByGradeId(int gradeId);
	
	//多对多关联映射
		@Select("select * from t_student where gradeId=#{gradeId}")
		@Results({
			//定义每个字段的映射 
			@Result(id=true,column="id",property="id"), //主键id为true，
			@Result(column="name",property="name"),
			@Result(column="age",property="age"),
			@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById")),
			@Result(column="gradeId",property="grade",one=@One(select="com.java.mappers.GradeMapper.findById"))

		})
		public Student selectStudentByGradeIdAndAddress(int id);
}
