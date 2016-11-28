package com.wisezone.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.wisezone.base.BaseDao;
import com.wisezone.crm.model.SaleChance;
import com.wisezone.crm.query.SaleChanceQuery;

public interface SaleChanceDao extends BaseDao<SaleChance>
{

	/**
	 * 分页查询
	 * 
	 * @param query
	 * @param pageBounds
	 * @return
	 */
	public List<SaleChance> selectForPage(SaleChanceQuery query, PageBounds pageBounds);

	/**
	 * 插入数据
	 * 
	 * @param saleChance
	 * @return
	 */
	public int insert(SaleChance saleChance);

	/**
	 * 修改
	 * 
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteBatch(@Param(value = "ids") String ids);

}
