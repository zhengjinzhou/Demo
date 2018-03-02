package zhou.com.demo.bean;

import java.io.Serializable;

/**
 * Created by zhou on 2018/3/2.
 * 科室人员列表
 * 用于请求特定科室人员
 */

public class KSUserBean implements Serializable{

    /**
     * UserID : lhf
     * UserPsw : null
     * UserName : 林红菲
     * UserSNID : 20110514150818_100
     * QZH : 999
     * DWName : 广东万维博通
     * KSCode : 03
     * KSName : 策划科
     * Title : 科长
     * JobDuty : null
     * isKSJR : null
     * vacInfo :
     * LoginTime : 0001-01-01T00:00:00
     */

    private String UserID;
    private Object UserPsw;
    private String UserName;
    private String UserSNID;
    private String QZH;
    private String DWName;
    private String KSCode;
    private String KSName;
    private String Title;
    private Object JobDuty;
    private Object isKSJR;
    private String vacInfo;
    private String LoginTime;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public Object getUserPsw() {
        return UserPsw;
    }

    public void setUserPsw(Object UserPsw) {
        this.UserPsw = UserPsw;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserSNID() {
        return UserSNID;
    }

    public void setUserSNID(String UserSNID) {
        this.UserSNID = UserSNID;
    }

    public String getQZH() {
        return QZH;
    }

    public void setQZH(String QZH) {
        this.QZH = QZH;
    }

    public String getDWName() {
        return DWName;
    }

    public void setDWName(String DWName) {
        this.DWName = DWName;
    }

    public String getKSCode() {
        return KSCode;
    }

    public void setKSCode(String KSCode) {
        this.KSCode = KSCode;
    }

    public String getKSName() {
        return KSName;
    }

    public void setKSName(String KSName) {
        this.KSName = KSName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Object getJobDuty() {
        return JobDuty;
    }

    public void setJobDuty(Object JobDuty) {
        this.JobDuty = JobDuty;
    }

    public Object getIsKSJR() {
        return isKSJR;
    }

    public void setIsKSJR(Object isKSJR) {
        this.isKSJR = isKSJR;
    }

    public String getVacInfo() {
        return vacInfo;
    }

    public void setVacInfo(String vacInfo) {
        this.vacInfo = vacInfo;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String LoginTime) {
        this.LoginTime = LoginTime;
    }

    @Override
    public String toString() {
        return "KSUserBean{" +
                "UserID='" + UserID + '\'' +
                ", UserPsw=" + UserPsw +
                ", UserName='" + UserName + '\'' +
                ", UserSNID='" + UserSNID + '\'' +
                ", QZH='" + QZH + '\'' +
                ", DWName='" + DWName + '\'' +
                ", KSCode='" + KSCode + '\'' +
                ", KSName='" + KSName + '\'' +
                ", Title='" + Title + '\'' +
                ", JobDuty=" + JobDuty +
                ", isKSJR=" + isKSJR +
                ", vacInfo='" + vacInfo + '\'' +
                ", LoginTime='" + LoginTime + '\'' +
                '}';
    }
}
