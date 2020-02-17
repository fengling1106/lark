package com.valen.lark.dao.fault;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.fault.FaultDetailInfo;
import com.valen.lark.dao.BaseDAO;


/**
 * <p>Title: IFaultDetailInfoDAO</p>  
 * <p>Description: ft_fault_detail_info</p>
 * @author fengling
 * @date 2019年7月17日
 */
@Mapper
@Repository
public interface IFaultDetailInfoDAO extends BaseDAO<FaultDetailInfo> {
	
	//根据故障标题查询故障订单
	public FaultDetailInfo getFaultDetailInfoByFaultTitle(FaultDetailInfo faultDetailInfo);	
	
	//查询所有的故障订单
	public List<FaultDetailInfo> getFaultDetailInfoAll();
	
}
