package cn.ekgc.witmed.dao;

import cn.ekgc.witmed.pojo.system.entity.IdType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>智慧医疗-系统功能-证件类型数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
@Repository
public interface IdTypeDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<IdType> findListByQuery(IdType query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(IdType entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(IdType entity) throws Exception;
}
