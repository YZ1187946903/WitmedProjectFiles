package cn.ekgc.witmed.service;

import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.pojo.system.entity.IdType;

import java.util.List;

/**
 * <b>智慧医疗-系统功能-证件类型业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
public interface IdTypeService {
	/**
	 * <b>分页查询</b>
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<IdType> getPageByQuery(IdType query, PageVO<IdType> pageVO) throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<IdType> getListByQuery(IdType query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean save(IdType entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(IdType entity) throws Exception;

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	IdType getById(String id) throws Exception;

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	IdType getByCode(String code) throws Exception;
}
