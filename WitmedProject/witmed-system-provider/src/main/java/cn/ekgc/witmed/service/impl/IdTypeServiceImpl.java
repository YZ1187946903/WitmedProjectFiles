package cn.ekgc.witmed.service.impl;

import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.dao.IdTypeDao;
import cn.ekgc.witmed.pojo.system.entity.IdType;
import cn.ekgc.witmed.service.IdTypeService;
import cn.ekgc.witmed.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>智慧医疗-系统功能-证件类型业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Service("idTypeService")
@Transactional
public class IdTypeServiceImpl implements IdTypeService {
	@Autowired
	private IdTypeDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>分页查询</b>
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	public PageVO<IdType> getPageByQuery(IdType query, PageVO<IdType> pageVO) throws Exception {
		// 要想进行分页查询，那么在分页查询的开始，打开 PageHelper 的分页过滤器，那么 PageHelper 会自动将紧跟着他的列表查询进行分页
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 那么一下的列表查询将自动进行分页查询
		List<IdType> list = dao.findListByQuery(query);

		// 要想获得分页查询的各个数据，需要获得 PageInfo 对象
		PageInfo<IdType> pageInfo = new PageInfo<IdType>(list);
		// 从 PageInfo 中提取数据
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalSize((long) pageInfo.getPages());

		return pageVO;
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<IdType> getListByQuery(IdType query) throws Exception {
		return dao.findListByQuery(query);
	}

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(IdType entity) throws Exception {
		// 设定主键
		entity.setId(idGenerator.createId());
		// 进行保存
		if (dao.save(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(IdType entity) throws Exception {
		if (dao.update(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public IdType getById(String id) throws Exception {
		// 创建查询参数
		IdType query = new IdType();
		query.setId(id);
		// 进行列表查询
		List<IdType> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public IdType getByCode(String code) throws Exception {
		// 创建查询参数
		IdType query = new IdType();
		query.setCode(code);
		// 进行列表查询
		List<IdType> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
