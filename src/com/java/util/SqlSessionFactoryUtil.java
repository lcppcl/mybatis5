package com.java.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//mybatis���ݿ����ӹ���
public class SqlSessionFactoryUtil {
	//�����Ĺ���
	private static SqlSessionFactory sqlSessionFactory;
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream = null;
			try {
				//��������ȡmybatis�����ļ�
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				//��ȡ�����ļ���������
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;//����һ������
	}

	//���ݿ�����
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}
