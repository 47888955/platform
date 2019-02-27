package com.yaoyong.demo.base.exception;

/**
 * 错误码定义枚举
 *
 * @author xuziqian@duojia.com
 * @version 1.0.0
 * @touch date 2018/7/24.
 */
public enum ExceptionEnum {
    INVALID_PARAMS(1001, "InvalidParams"),

    //20000 状态的为返回成功值,尽量定1个值
    SUCCESS(20000,"操作成功"),

    //30000~40000 状态为各种已经存在的状态
    INFO_IS_EXIST(30000,"信息已存在"),
    USER_IS_EXIST(30100,"用户已经存在"),
    APPSEQ_IS_EXIST(30101,"重复请求"),
    CARDNO_IS_EXIST(30102,"证件号重复"),
    WECHAT_REDIRECT(30300,"微信跳转链接"),

    //40000~50000 状态的为各种查询失败的状态
    NO_DATA(40000,"数据不存在"),
    PARAMETER_ERROR(40001,"参数不合法"),
    NO_LIMIT(40002,"用户权限不足"),
    USER_NO_EXIST(40100,"用户不存在"),
    USER_EXIST(40101,"用户登录入口错误"),
    USER_LOGIN_ERROR(40102,"用户名或密码不正确"),
    INSERT_ERROR(40103,"插入失败"),
    UPDATE_ERROR(40104,"更新失败"),
    DELETE_ERROR(40105,"删除失败"),

    //50000~60000 状态的为各种更新操作失败状态
    ERROR(50000,"异常"),
    NO_LOGIN(50001,"请先登录"),
    NO_ACTIVE(50002,"对不起，您的账号尚未激活"),
    AUDIT_REJECTION(500022,"对不起，您的账号审核未通过，请联系客服"),
    NO_APPLY(50003,"请您先完善个人信息"),
    USER_LOCK(50004,"用户已锁定"),
    NO_CONTACT(50005,"请完善合同"),
    ORDER_LOCK(50101,"订单已冻结"),
    NO_ORDER(50008,"虚拟订单不存在"),
    YST_CONTRACT(50006,"请完善云商通个人合同"),
    YST_QY_CONTRACT(50007,"请完善云商通企业合同"),
    /**
     * 短信模块状态值
     */
    SMS_OVER_TIME(60201,"短信验证码超时,请获取验证码"),
    SMS_CODE_FAIL(60202,"短信验证码错误"),
    SMS_GET_CODE_ERROR(60203,"获取短信验证码失败"),
    SMS_CODE_LOSE(60204,"短信验证码失效,请获取验证码"),

    /**
     * 图片验证码模块状态值
     */
    IMS_OVER_TIME(60301,"图片验证码超时,请获取验证码"),
    IMS_CODE_FAIL(60302,"图片验证码错误"),
    IMS_CODE_LOSE(60303,"图片验证码失效,请获取验证码"),

    /**
     * POS查询订单模块状态值
     */
    POS_STATUS_ERROR(70401,"订单状态不正确"),
    POS_MERSIGN_ERROR(70402,"签名验证未通过"),
    POS_PARAMETER_ERROR(70403,"参数验证未通过"),
    POS_ORDERLOCK_ERROR(70404,"插入订单锁失败"),

    BANK_CARD_ONLYDC(80001,"仅支持储蓄卡类型的银行卡"),

    /**
     * 登录模块
     */
    LOGIN_LOGINNAME_ERRORT(90002,"登录名错误"),
    LOGIN_LOGINNAME_REPEAT(90003,"该用户名已存在"),


    /**
     * 邀请模块
     */
    INVITE_NO_APPEND(100001,"对不起，此用户无法添加！"),
    INVITE_NO_EXIST(100002,"搜索无结果"),
    INVITE_NO_EXIST_USERNO(100003,"搜索无结果"),

    PAY(80001,"支付相关"),


    /**
     * 搜索模块
     */
    Error_PRAM(110001,"页面编号和大小必须为数值型字符串！"),
    ;


    private int status;//返回状态值
    private String message;//返回信息

    private ExceptionEnum(int status, String message){
        this.status=status;
        this.message=message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static String getResultMessage(int key){

        ExceptionEnum[] values = ExceptionEnum.values();
        for(ExceptionEnum resultStatusEnum:values){
            if(resultStatusEnum.getStatus() == key){
                return resultStatusEnum.getMessage();
            }
        }
        return "";
    }



}
