package cn.ekgc.witmed.pojo.system.entity;

import cn.ekgc.witmed.base.pojo.entity.BaseEntity;

/**
 * <b>智慧医疗-系统功能-证件类型实体信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public class IdType extends BaseEntity {
	private static final long serialVersionUID = 789858995457329976L;
	private String id;                      // 主键
	private String text;                    // 名称
	private String code;                    // 编码
	private String remark;                  // 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
