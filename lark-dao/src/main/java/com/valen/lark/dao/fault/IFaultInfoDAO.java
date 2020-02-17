package com.valen.lark.dao.fault;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.fault.FaultInfo;
import com.valen.lark.dao.BaseDAO;

/**
 * @author fengling
 * @create 2019-7-10
 * @Description ft_fault_info表dao访问接口
 */
@Mapper
@Repository
public interface IFaultInfoDAO extends BaseDAO<FaultInfo> {
	
	//根据故障标题查询故障订单
	public FaultInfo getFaultInfoByFaultTitle(FaultInfo faultInfo);	
	
	//查询所有的故障订单
	public List<FaultInfo> getFaultInfoAll();
	
}
