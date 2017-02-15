package com.java.mappers;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java.model.Student;
//�ӿ�
public interface StudentMapper {
	//һ��һ����ӳ��
	@Select("select * from t_student where id=#{id}")
	@Results({
		//����ÿ���ֶε�ӳ�� 
		@Result(id=true,column="id",property="id"), //����idΪtrue��
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById"))
	})
	public Student selectStudentWithAddress(Integer id);
	
	//һ�Զ����ӳ��
	@Select("select * from t_student where gradeId=#{gradeId}")
	@Results({
		//����ÿ���ֶε�ӳ�� 
		@Result(id=true,column="id",property="id"), //����idΪtrue��
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById"))
	})
	public Student selectStudentByGradeId(int gradeId);
	
	//��Զ����ӳ��
		@Select("select * from t_student where gradeId=#{gradeId}")
		@Results({
			//����ÿ���ֶε�ӳ�� 
			@Result(id=true,column="id",property="id"), //����idΪtrue��
			@Result(column="name",property="name"),
			@Result(column="age",property="age"),
			@Result(column="addressId",property="address",one=@One(select="com.java.mappers.AddressMapper.findById")),
			@Result(column="gradeId",property="grade",one=@One(select="com.java.mappers.GradeMapper.findById"))

		})
		public Student selectStudentByGradeIdAndAddress(int id);
}
