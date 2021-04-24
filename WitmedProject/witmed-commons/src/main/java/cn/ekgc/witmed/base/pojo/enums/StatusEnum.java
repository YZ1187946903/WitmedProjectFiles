package cn.ekgc.witmed.base.pojo.enums;

/**
 * <b>智慧医疗-系统状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public enum StatusEnum {
	STATUS_ENABLE(EnumConstants.STATUS_ENABLE, "启用"),
	STATUS_DISABLE(EnumConstants.STATUS_DISABLE, "禁用");

	private String code;                        // 编码
	private String remark;                      // 说明

	private StatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
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
