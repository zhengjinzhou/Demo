package zhou.com.demo.bean;

import java.io.Serializable;

/**
 * Created by zhou on 2018/2/26.
 * 用户登录
 */

public class LoginBean implements Serializable {

    public LoginBean(boolean isSuccess, String errorManage, String errorCode, String activeCode) {
        IsSuccess = isSuccess;
        ErrorManage = errorManage;
        ErrorCode = errorCode;
        ActiveCode = activeCode;
    }
    /**
     * IsSuccess : true
     * ErrorManage :
     * ErrorCode :
     * ActiveCode :
     */

    private boolean IsSuccess;
    private String ErrorManage;
    private String ErrorCode;
    private String ActiveCode;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getErrorManage() {
        return ErrorManage;
    }

    public void setErrorManage(String ErrorManage) {
        this.ErrorManage = ErrorManage;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getActiveCode() {
        return ActiveCode;
    }

    public void setActiveCode(String ActiveCode) {
        this.ActiveCode = ActiveCode;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "IsSuccess=" + IsSuccess +
                ", ErrorManage='" + ErrorManage + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ActiveCode='" + ActiveCode + '\'' +
                '}';
    }
}
