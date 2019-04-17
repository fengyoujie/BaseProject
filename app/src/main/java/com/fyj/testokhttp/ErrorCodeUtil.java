package com.fyj.testokhttp;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ErrorCodeUtil {

    public static final int RES_0 = 0;

    //登录
    public static final int ACCOUNT_NEEDED = 29011;
    public static final int PASSWORD_NEEDED = 29009;
    public static final int ACCOUNT_OR_PASSWD_WRONG = 29001;
    public static final int ACCOUNT_LOCKED = 29002;
    public static final int LOGIN_FAILED = 29003;
    public static final int PHONE_ALREADY_EXIST = 29030;

    //忘记密码
    public static final int MOBILE_NUM_NEEDED = 29007;
    public static final int PASSWORD_IS_TOO_LONG = 29012;
    public static final int NUM_OR_VERIFY_CODE_IS_WRONG = 29015;
    public static final int VERIFY_CODE_EXPIRED = 29016;
    public static final int MOBILE_NUM_NOT_EXIST = 29004;

    //获取验证码
    public static final int CLIENT_NEEDED = 29013;
    public static final int CLIENT_WRONG = 29014;
    public static final int ONLY_ONCE_WITHIN_ONE_MIN = 29019;
    public static final int GET_VERIFY_CODE_OFTEN = 29020;
    public static final int MESSAGE_EMPTY = 29017;
    public static final int MESSAGE_SEND_FAILED = 29018;
    public static final int MOBILE_ERROR = 29021;

    //修改密码
    public static final int OLD_PASSWD_NEEDED = 29008;
    public static final int OLD_PASSWD_TOO_LONG = 29010;
    public static final int MODIFY_PASSWD_FAILED = 29006;

    //Token失效
    public static final int TOKEN_EXPIRED = 99007;

    //需要token
    public static final int TOKEN_NEEDED = 99005;

    //Token不存在
    public static final int TOKEN_NOT_EXIST = 99006;

    public static final int TEL_EMPTY = 10028;
    public static final int TEL_TOO_LONG = 10029;
    public static final int TEL_FORMAT_WRONG = 10009;
    public static final int DEFAULT_VALUE_IS_EMPTY = 10039;
    public static final int DEFAULT_VALUE_MUST_BE_INTEGER = 10040;
    public static final int ADDRESS_NOT_EXIST = 20086;
    public static final int ADDRESS_TOO_LONG = 20076;
    public static final int GOODS_STOCK_EMPTY = 30003;
    public static final int ORDER_STATUS_NOT_CORRECT = 43006;

    public static final int DATA_NOT_FOUND = 10000;
    public static final int NOT_SUPPORT_BY_BONUS = 43011;
    public static final int IN_REFUNDING = 33027;

    public static final int ORDER_NOT_EXIST = 33003;

    public static final int POINT_PURCHASE_SUCCESSFULLY = -1128;

    private ErrorCodeUtil() {
    }

    @IntDef({
            PASSWORD_NEEDED,
            ACCOUNT_OR_PASSWD_WRONG,
            ACCOUNT_NEEDED,
            ACCOUNT_LOCKED,
            LOGIN_FAILED,
            PHONE_ALREADY_EXIST,
            MOBILE_NUM_NEEDED,
            PASSWORD_IS_TOO_LONG,
            NUM_OR_VERIFY_CODE_IS_WRONG,
            VERIFY_CODE_EXPIRED,
            MOBILE_NUM_NOT_EXIST,
            CLIENT_NEEDED,
            CLIENT_WRONG,
            ONLY_ONCE_WITHIN_ONE_MIN,
            GET_VERIFY_CODE_OFTEN,
            MESSAGE_EMPTY,
            MESSAGE_SEND_FAILED,
            MOBILE_ERROR,
            OLD_PASSWD_NEEDED,
            OLD_PASSWD_TOO_LONG,
            MODIFY_PASSWD_FAILED,
            TOKEN_EXPIRED,
            TOKEN_NEEDED,
            TOKEN_NOT_EXIST,
            TEL_EMPTY,
            TEL_TOO_LONG,
            TEL_FORMAT_WRONG,
            DEFAULT_VALUE_IS_EMPTY,
            DEFAULT_VALUE_MUST_BE_INTEGER,
            ADDRESS_NOT_EXIST,
            ADDRESS_TOO_LONG,
            GOODS_STOCK_EMPTY,
            ORDER_STATUS_NOT_CORRECT,
            DATA_NOT_FOUND,
            NOT_SUPPORT_BY_BONUS,
            IN_REFUNDING,
            ORDER_NOT_EXIST,
            POINT_PURCHASE_SUCCESSFULLY
    })

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public static synchronized String getString(@ErrorCode int code) {
        String result = "";
        switch (code) {
            case ACCOUNT_LOCKED:
                result = "锁定用户";
                break;
            case ACCOUNT_NEEDED:
                result = "账号必须";
                break;
            case ACCOUNT_OR_PASSWD_WRONG:
                result = "账号或密码错误";
                break;
            case CLIENT_NEEDED:
                result = "客户端必填";
                break;
            case CLIENT_WRONG:
                result = "客户端错误";
                break;
            case GET_VERIFY_CODE_OFTEN:
                result = "发送次数过多";
                break;
            case LOGIN_FAILED:
                result = "登录失败";
                break;
            case MESSAGE_EMPTY:
                result = "短信内容为空";
                break;
            case MESSAGE_SEND_FAILED:
                result = "发送失败";
                break;
            case MOBILE_NUM_NEEDED:
                result = "手机号必须";
                break;
            case MOBILE_NUM_NOT_EXIST:
                result = "手机号不存在";
                break;
            case MODIFY_PASSWD_FAILED:
                result = "密码修改失败";
                break;
            case NUM_OR_VERIFY_CODE_IS_WRONG:
                result = "手机号或验证码错误";
                break;
            case OLD_PASSWD_NEEDED:
                result = "旧密码必须";
                break;
            case OLD_PASSWD_TOO_LONG:
                result = "旧密码过长";
                break;
            case ONLY_ONCE_WITHIN_ONE_MIN:
                result = "一分钟只能发送一次";
                break;
            case PASSWORD_IS_TOO_LONG:
                result = "密码过长";
                break;
            case PASSWORD_NEEDED:
                result = "密码必须";
                break;
            case VERIFY_CODE_EXPIRED:
                result = "验证码过期";
                break;
            case TOKEN_NEEDED:
                result = "需要Token";
                break;
            case TOKEN_EXPIRED:
                result = "Token过期";
                break;
            case TOKEN_NOT_EXIST:
                result = "Token不存在";
                break;
            case MOBILE_ERROR:
                result = "手机号不存在";
                break;
            case TEL_EMPTY:
                result = "电话不能为空";
                break;
            case TEL_TOO_LONG:
                result = "电话过长";
                break;
            case TEL_FORMAT_WRONG:
                result = "手机号格式错误";
                break;
            case DEFAULT_VALUE_IS_EMPTY:
                result = "默认值不能为空";
                break;
            case DEFAULT_VALUE_MUST_BE_INTEGER:
                result = "默认值必须为整数";
                break;
            case ADDRESS_NOT_EXIST:
                result = "地址不存在";
                break;
            case ADDRESS_TOO_LONG:
                result = "地址过长";
                break;
            case GOODS_STOCK_EMPTY:
                result = "商品已售罄";
                break;
            case ORDER_STATUS_NOT_CORRECT:
                result = "订单当前状态无法操作";
                break;
            case DATA_NOT_FOUND:
                result = "数据未找到";
                break;
            case NOT_SUPPORT_BY_BONUS:
                result = "积分支付的商品不支持退款、退货、换货";
                break;
            case IN_REFUNDING:
                result = "您要退款的订单已经存在退款单，不能重复提交退款";
                break;
            case POINT_PURCHASE_SUCCESSFULLY:
                result = "订单提交成功";//积分订单支付成功//目前用于提示积分订单支付成功与离线订单提交成功
                break;
            case ORDER_NOT_EXIST:
                result = "订单不存在";
                break;
            case PHONE_ALREADY_EXIST:
                result = "手机号已存在";
                break;
            default:
                result = "未知返回码";
                break;
        }
        return result;
    }
}
