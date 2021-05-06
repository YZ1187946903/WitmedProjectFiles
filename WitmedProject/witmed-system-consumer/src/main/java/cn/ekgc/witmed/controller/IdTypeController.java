package cn.ekgc.witmed.controller;

import cn.ekgc.witmed.base.controller.BaseController;
import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.base.pojo.vo.QueryVO;
import cn.ekgc.witmed.base.pojo.vo.ResponseVO;
import cn.ekgc.witmed.pojo.system.entity.IdType;
import cn.ekgc.witmed.transport.system.IdTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗-系统功能-证件类型控制层类</b>
 * @author Arthur
 * @version 1.0.0
 */
@RestController("idTypeController")
@RequestMapping("/system")
public class IdTypeController extends BaseController {
	@Autowired
	private IdTypeTransport transport;

	/**
	 * <b>分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/pageNum/pageSize")
	public ResponseVO getPageByQuery(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                                 @RequestBody IdType query) throws Exception {
		// 创建 PageVO 对象
		PageVO<IdType> pageVO = new PageVO<IdType>(pageNum, pageSize);
		// 创建 QueryVO 对象
		QueryVO<IdType> queryVO = new QueryVO<IdType>();
		queryVO.setPageVO(pageVO);
		queryVO.setQuery(query);
		// 进行分页查询
		pageVO = transport.getPageByQuery(queryVO);
		return ResponseVO.getSuccessResponseVO(pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO getByQuery(@RequestBody IdType query) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getListByQuery(query));
	}

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public ResponseVO save(@RequestBody IdType entity) throws Exception {
		// 获得用户所给定的 code
		String code = entity.getCode();
		if (code != null && !"".equals(code)) {
			// 校验此时的 code 是否重复
			IdType idType = transport.getByCode(code);
			if (idType == null) {
				// 保存对象
				if (transport.save(entity)) {
					return ResponseVO.getSuccessResponseVO();
				}
				return ResponseVO.getErrorResponseVO("保存失败");
			}
			return ResponseVO.getErrorResponseVO("该编码已被占用");
		}
		return ResponseVO.getErrorResponseVO("请填写正确的信息");
	}

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public ResponseVO update(@RequestBody IdType entity) throws Exception {
		// 获得 code 信息
		String code = entity.getCode();
		if (code != null && !"".equals(code)) {
			// 此时用户修改 code 信息，那么判断是否重复
			IdType idType = transport.getByCode(code);
			if (idType == null || idType.getId().equals(entity.getId())) {
				// 此时的 code 可以使用
				// 此时用户未修改 code 信息，直接进行修改
				if (transport.update(entity)) {
					return ResponseVO.getSuccessResponseVO();
				}
				return ResponseVO.getErrorResponseVO("保存失败");
			}
			return ResponseVO.getErrorResponseVO("该编码已被占用");
		} else {
			// 此时用户未修改 code 信息，直接进行修改
			if (transport.update(entity)) {
				return ResponseVO.getSuccessResponseVO();
			}
			return ResponseVO.getErrorResponseVO("保存失败");
		}
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO getById(@PathVariable("id") String id) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getById(id));
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/code/{code}")
	public ResponseVO getByCode(@PathVariable("code") String code) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getByCode(code));
	}
}
