package com.valen.lark.dao.fault;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.valen.lark.bean.fault.FaultDetail;
import com.valen.lark.dao.BaseDAO;


/**
 * <p>Title: IFaultDetailInfoDAO</p>  
 * <p>Description: ft_fault_detail_info</p>
 * @author fengling
 * @date 2019年7月17日
 */
@Mapper
@Repository
public interface IFaultDetailDAO extends BaseDAO<FaultDetail> {
	
	//根据故障标题查询故障订单
	public FaultDetail getFaultDetailInfoByFaultTitle(FaultDetail faultDetailInfo);	
	
	//查询所有的故障订单
	public List<FaultDetail> getFaultDetailInfoAll();

	//新增一条故障订单
	public boolean insertSingle(FaultDetail faultDetailInfo);	
}
