package allPay.payment.integration;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import allPay.payment.integration.allPayOperator.AllPayFunction;
import allPay.payment.integration.errorMsg.ErrorMessage;
import allPay.payment.integration.exception.AllPayException;

public class AllInOneBase {
	protected static String operatingMode;
	protected static String mercProfile;
	protected static String isProjectContractor;
	protected static String HashKey;
	protected static String HashIV;
	protected static String MerchantID;
	protected static String PlatformID;
	protected static String aioCheckOutUrl;
	protected static String doActionUrl;
	protected static String queryCreditTradeUrl;
	protected static String queryTradeInfoUrl;
	protected static String captureUrl;
	protected static String queryTradeUrl;
	protected static String tradeNoAioUrl;
	protected static String fundingReconDetailUrl;
	protected static String aioChargebackUrl;
	protected static String[] ignorePayment;
	public AllInOneBase() throws UnsupportedEncodingException{
		Document doc;
		 String confPath = "/payment_conf.xml";
		/* when using web project, please use the following code with try/catch wrapped*/
			//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//String configPath = URLDecoder.decode(classLoader.getResource("/payment_conf.xml").getPath(), "UTF-8");
			URL fileURL = this.getClass().getResource(confPath);
			doc = AllPayFunction.xmlParser(fileURL.toString());
		/* when using testing code*/
//		String paymentConfPath = "./src/main/resources/payment_conf.xml";
//		doc = AllPayFunction.xmlParser(paymentConfPath);
		
		doc.getDocumentElement().normalize();
		//OperatingMode
		Element ele = (Element)doc.getElementsByTagName("OperatingMode").item(0);
		operatingMode = ele.getTextContent();
		//MercProfile
		ele = (Element)doc.getElementsByTagName("MercProfile").item(0);
		mercProfile = ele.getTextContent();
		//IsProjectContractor
		ele = (Element)doc.getElementsByTagName("IsProjectContractor").item(0);
		isProjectContractor = ele.getTextContent();
		//MID, HashKey, HashIV, PlatformID
		NodeList nodeList = doc.getElementsByTagName("MInfo");
		for(int i = 0; i < nodeList.getLength(); i++){
			ele = (Element)nodeList.item(i);
			if(ele.getAttribute("name").equalsIgnoreCase(mercProfile)){
				MerchantID = ele.getElementsByTagName("MerchantID").item(0).getTextContent();
				HashKey = ele.getElementsByTagName("HashKey").item(0).getTextContent();
				HashIV = ele.getElementsByTagName("HashIV").item(0).getTextContent();
				PlatformID = isProjectContractor.equalsIgnoreCase("N")? "" : MerchantID;
			}
		}
		//IgnorePayment
		ele = (Element)doc.getElementsByTagName("IgnorePayment").item(0);
		nodeList = ele.getElementsByTagName("Method");
		ignorePayment = new String[nodeList.getLength()];
		for(int i = 0; i < nodeList.getLength(); i++){
			ignorePayment[i] = nodeList.item(i).getTextContent();
		}
		if(HashKey == null){
			throw new AllPayException(ErrorMessage.MInfo_NOT_SETTING);
		}
	}
}
