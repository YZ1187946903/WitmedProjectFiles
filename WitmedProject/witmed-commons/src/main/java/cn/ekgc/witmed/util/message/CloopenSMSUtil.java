package cn.ekgc.witmed.util.message;

import cn.ekgc.witmed.util.ConstantUtils;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>智慧医疗-容联云短信发送工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
public class CloopenSMSUtil {
	/**
	 * <b>发送验证码短信</b>
	 * @param cellphone
	 * @param verificationCode
	 * @throws Exception
	 */
	public static void sendVerificationCode(String cellphone, String verificationCode) {
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init(ConstantUtils.CLOOPEN_SERVER_IP, ConstantUtils.CLOOPEN_SERVER_PORT);
		// 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
		restAPI.setAccount(ConstantUtils.CLOOPEN_ACCOUNT_SID, ConstantUtils.CLOOPEN_ACCOUNT_TOKEN);
		// 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
		restAPI.setAppId(ConstantUtils.CLOOPEN_APP_ID);
		// 请使用管理控制台中已创建应用的APPID。
		result = restAPI.sendTemplateSMS(cellphone, ConstantUtils.CLOOPEN_TEMPLATE_ID,
				new String[]{verificationCode, String.valueOf(ConstantUtils.CAPTCHA_EXPIRE_MILLIS / 1000 / 60)});
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))) {
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		} else {
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}
}
