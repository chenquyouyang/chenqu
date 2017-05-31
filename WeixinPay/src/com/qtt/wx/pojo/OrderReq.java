package com.qtt.wx.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class OrderReq {
	//公众号id
	@XStreamAlias("appid")
	private String appid;
	
	//公众号商户id
	@XStreamAlias("mch_id")
	private String mch_id;
	
	//设备号，PC网页或公众号支付填WEB
	@XStreamAlias("device_info")
	private String device_info;
	
	//随机字符串
	@XStreamAlias("nonce_str")
	private String nonce_str;
	
	//签名
	@XStreamAlias("sign")
	private String sign;
	
	//签名类型
	@XStreamAlias("sign_type")
	private String sign_type;
	
	//商品简单描述
	@XStreamAlias("body")
	private String body;
	
	//商品详情
	@XStreamAlias("detail")
	private String detail;
	
	//附加参数
	@XStreamAlias("attach")
	private String attach;
	
	//商户订单号
	@XStreamAlias("out_trade_no")
	private String out_trade_no;
	
	//币种，CNY人民币
	@XStreamAlias("fee_type")
	private String fee_type;
	
	//标价金额，单位（分）
	@XStreamAlias("total_fee")
	private String total_fee;
	
	//终端IP
	@XStreamAlias("spbill_create_ip")
	private String spbill_create_ip;
	
	//交易起始时间
	@XStreamAlias("time_start")
	private String time_start;
	
	//交易结束时间
	@XStreamAlias("time_expire")
	private String time_expire;
	
	//订单优惠标记
	@XStreamAlias("goods_tag")
	private String goods_tag;
	
	//通知地址
	@XStreamAlias("notify_url")
	private String notify_url;
	
	//交易类型
	@XStreamAlias("trade_type")
	private String trade_type;
	
	//商品ID
	@XStreamAlias("product_id")
	private String product_id;
	
	//指定支付方式 	
	@XStreamAlias("limit_pay")
	private String limit_pay;
	
	//用户标识
	@XStreamAlias("openid")
	private String openid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
