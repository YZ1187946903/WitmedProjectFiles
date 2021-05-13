package cn.ekgc.witmed.util;

import java.util.Properties;

/**
 * <b>智慧医疗-系统常量工具类</b>
 */
public class ConstantUtils {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtils.class.getClassLoader().getResourceAsStream("props/system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统加密秘钥</b>
	 */
	public static final String SECRET_KEY = props.getProperty("secret.key");

	/**
	 * <b>Token 过期时间</b>
	 */
	public static final Long TOKEN_EXPIRE_MILLIS = Long.parseLong(props.getProperty("token.expire.millis"));

	/**
	 * <b>验证码过期时间</b>
	 */
	public static final Long CAPTCHA_EXPIRE_MILLIS = Long.parseLong(props.getProperty("captcha.expire.maillis"));

	/**
	 * <b>容联云短信功能：服务器 IP 地址</b>
	 */
	public static final String CLOOPEN_SERVER_IP = props.getProperty("cloopen.server.ip");

	/**
	 * <b>容联云短信功能：服务器端口号</b>
	 */
	public static final String CLOOPEN_SERVER_PORT = props.getProperty("cloopen.server.port");

	/**
	 * <b>容联云短信功能：账户 SID</b>
	 */
	public static final String CLOOPEN_ACCOUNT_SID = props.getProperty("cloopen.account.sid");

	/**
	 * <b>容联云短信功能：账户 TOKEN</b>
	 */
	public static final String CLOOPEN_ACCOUNT_TOKEN = props.getProperty("cloopen.account.token");

	/**
	 * <b>容联云短信功能：app id</b>
	 */
	public static final String CLOOPEN_APP_ID = props.getProperty("cloopen.app.id");

	/**
	 * <b>容联云短信功能：短信模板 id</b>
	 */
	public static final String CLOOPEN_TEMPLATE_ID = props.getProperty("cloopen.template.id");
}
