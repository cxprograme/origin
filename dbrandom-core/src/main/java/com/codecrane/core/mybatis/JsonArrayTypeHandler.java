package com.codecrane.core.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Json数组类型字段处理
 * @author Crane(hehebaiy@gmail.com)
 * <br/>
 * <br/>
 */
public class JsonArrayTypeHandler extends BaseTypeHandler<JSONArray>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, JSONArray parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, JSON.toJSONString(parameter));
	}

	@Override
	public JSONArray getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return JSON.parseArray(delColumnValueToUTF8(rs.getString(columnName)));
	}

	@Override
	public JSONArray getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return JSON.parseArray(delColumnValueToUTF8(rs.getString(columnIndex)));
	}

	@Override
	public JSONArray getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return JSON.parseArray(delColumnValueToUTF8(cs.getString(columnIndex)));
	}

	/**
	 * 列值转化为UTF8字符编码格式
	 * @param colValue
	 * @return
     */
	private String delColumnValueToUTF8(String colValue){
		if( StringUtils.isNotEmpty(colValue) ){
			try {
				return new String(colValue.getBytes("ISO8859-1"),"utf-8");
			}catch (UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}
		return null;
	}

}
