package com.yaoyong.demo.base.constant;


public final class BaseConstant {



    private BaseConstant() {
    }

//投诉 申请 进行中 已审批
    public static final Integer COMPLAINT_SOLVE_APPLY = 0;
    public static final Integer COMPLAINT_SOLVE_ING = 1;
    public static final Integer COMPLAINT_SOLVE_APPROVE = 2;

    //评论配置
    public static final Integer COMMENT_ENABLE_OPEN = 0;
    public static final Integer COMMENT_ENABLE_CLOSE = 1;
    public static final Integer COMMENT_PRAIS = 0;

    public static final Integer COMMENT_THIRD_TYPE_CONTENT = 0;
    public static final Integer COMMENT_THIRD_TYPE_PRODUCT = 1;
    public static final Integer COMMENT_THIRD_TYPE_ACTIVITY = 2;
    public static final Integer COMMENT_THIRD_TYPE_SHOP = 3;


    //评论根节点
    public static final String COMMENT_ROOT = "0";


    public static final Integer IS_VIEW = 1;
    public static final Integer IS_NOT_VIEW = 0;

    public static final Integer IS_ONE_TOP = 1;
    public static final Integer IS_TWO_TOP = 2;
    public static final Integer IS_THREE_TOP = 3;
    public static final Integer IS_NOT_TOP = 0;

    //文章列表显示模板
    public static final Integer STYLE_TEMPLATE_ONE = 1;
    public static final Integer STYLE_TEMPLATE_TWO = 2;
    public static final Integer STYLE_TEMPLATE_THREE = 3;
    public static final Integer STYLE_TEMPLATE_NONE = 0;

    //平台类型-其他
    public static final Integer TYPE_OTHER = 1;
    //平台类型
    public static final Integer TYPE_PLATFORM = 1;
    //商家类型
    public static final Integer TYPE_SHOP = 0;
    // 删除 初始化状态
    public static final Integer DELETE_NATURAL = 0;
    // 删除 删除状态
    public static final Integer DELETE_ED = 1;
    // app应用渠道
    public static final String APPID_DOGO = "100000";

    // 促销计划部分act_range
    // 全部商品
    public static final Integer ACT_RANGE_ALL_PRODUCT = 0;
    // 按分类
    public static final Integer ACT_RANGE_BY_SORT = 1;
    // 按商品
    public static final Integer ACT_RANGE_BY_PRODUCT = 2;

    // 参加活动的优惠方式type
    // 送赠品
    public static final Integer ACT_TYPE_GIFT = 0;
    // 现金减免
    public static final Integer ACT_TYPE_CASH = 1;
    // 价格打折
    public static final Integer ACT_TYPE_DISCOUNTED = 2;
    // 拼团
    public static final Integer ACT_TYPE_GROUP = 3;

    // 活动开启
    public static final Integer ACT_IS_ENABLE_OPEN = 0;
    // 活动关闭
    public static final Integer ACT_IS_ENABLE_CLOSE = 1;


    //用户部分
    //企业负责人
    public static final Integer USER_TYPE_COMPANY = 0;
    //普通用户
    public static final Integer USER_TYPE_PERSON = 1;

    //帐号状态0-启用
    public static final Integer USER_STATUS_CLOSE = 0;
    //帐号状态1-停用
    public static final Integer USER_STATUS_OPEN = 0;


    //审批状态approve_status
    //初始待审核
    public static final Integer USER_APP_STATUS_INI = 0;
    //审核中
    public static final Integer USER_APP_STATUS_ING = 1;
    //审核通过
    public static final Integer USER_APP_STATUS_PASS = 2;
    //审核拒绝
    public static final Integer USER_APP_STATUS_REFUSE = 3;


    //具体的VALUE 可以改。
    //店铺类型，B－企业渠道；C－个人渠道；P－机构供应商; D-医生供应商
    //B－企业渠道
    public static final String SHOP_TYPE_COM = "B";
    //C－个人渠道
    public static final String SHOP_TYPE_PERSON = "C";
    //P－机构供应商
    public static final String SHOP_TYPE_ORG = "P";
    //D-医生供应商
    public static final String SHOP_TYPE_DOCTOR = "D";


    //媒体类型
    public static final String MEDIA_TYPE_VODEO = "0";
    public static final String MEDIA_TYPE_IMG = "1";
    public static final String MEDIA_TYPE_ARTICLE = "2";
    public static final String MEDIA_TYPE_COMMON_ARTICLE = "3";
    public static final String MEDIA_TYPE_AD_ARTICLE = "4";
    public static final String MEDIA_TYPE_SHOP_ARTICLE = "5";
    public static final String MEDIA_TYPE_HELP_ARTICLE = "6";

    //删除状态
    public static final Integer IS_DELETED = 0;
    public static final Integer IS_DEL = 1;

    //绑定状态
    public static final Integer IS_BANGDING = 1;





    /**
     * 定义字典表绑定资源列表
     * 投诉处理原因
     */
    public static final String COMPLAINT_CAUSE = "complaint-cause";








}
