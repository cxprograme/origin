package com.codecrane.core.power.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽象实体
 * 
 * @author Crane(hehebaiy@gmail.com) <br/>
 *         <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1698604534136378686L;

	/**
	 * 编号
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createDate;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date modifyDate;

	/**
	 * 删除标志 0未删除 1已删除
	 */
	protected Integer deleted;

	/**
	 * 排序号
	 */
	protected Long orderId;

}
