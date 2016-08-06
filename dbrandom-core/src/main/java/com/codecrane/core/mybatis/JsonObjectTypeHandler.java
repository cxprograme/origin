package com.codecrane.core.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Json类型字段处理
 * @author Crane(hehebaiy@gmail.com)
 * <br/>
 * <br/>
 */
public class JsonObjectTypeHandler extends BaseTypeHandler<JSONObject>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, JSONObject parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, JSON.toJSONString(parameter));
	}

	@Override
	public JSONObject getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String jsonValue = null;
		try {
			jsonValue= new String(rs.getString(columnName).getBytes("ISO8859-1"),"utf-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return JSON.parseObject(jsonValue);
	}

	@Override
	public JSONObject getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String jsonValue = null;
		try {
			jsonValue= new String(rs.getString(columnIndex).getBytes("ISO8859-1"),"utf-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return JSON.parseObject(jsonValue);
	}

	@Override
	public JSONObject getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String jsonValue = null;
		try {
			jsonValue= new String(cs.getString(columnIndex).getBytes("ISO8859-1"),"utf-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return JSON.parseObject(jsonValue);
	}

}
