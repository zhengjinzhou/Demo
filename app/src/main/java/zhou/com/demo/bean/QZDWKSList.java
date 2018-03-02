package zhou.com.demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/2/28.
 * 科室列表
 */

public class QZDWKSList implements Serializable{

    /**
     * Datas : [{"QZH":"999","KSName":"局领导","KSCode":"01","XH":"1.00","KSHisName":"","KSMasterUserID":"yl","KSMasterName":"依林","ParkLeaderID":"lindao","ParkLeaderName":"领导","SWYID":"","SWYName":""},{"QZH":"999","KSName":"办公室","KSCode":"02","XH":"2.00","KSHisName":"","KSMasterUserID":"xh","KSMasterName":"谢欢","ParkLeaderID":"wll","ParkLeaderName":"王莉莉","SWYID":"20110514150818_94","SWYName":"张慧"},{"QZH":"999","KSName":"策划科","KSCode":"03","XH":"3.00","KSHisName":"","KSMasterUserID":"lh","KSMasterName":"刘欢","ParkLeaderID":"yl","ParkLeaderName":"依林","SWYID":"","SWYName":""},{"QZH":"999","KSName":"人事科","KSCode":"04","XH":"4.00","KSHisName":"","KSMasterUserID":"zl","KSMasterName":"张玲","ParkLeaderID":"lszjl","ParkLeaderName":"立升何总","SWYID":"","SWYName":""},{"QZH":"999","KSName":"财务科","KSCode":"06","XH":"6.00","KSHisName":"","KSMasterUserID":"mobileTest","KSMasterName":"mobileTest","ParkLeaderID":"","ParkLeaderName":"傅文财","SWYID":"","SWYName":""},{"QZH":"999","KSName":"工程部","KSCode":"08","XH":"8.00","KSHisName":"","KSMasterUserID":"lsgcb","KSMasterName":"工程部张三","ParkLeaderID":"wll","ParkLeaderName":"王莉莉","SWYID":"","SWYName":""},{"QZH":"999","KSName":"行政部","KSCode":"09","XH":"9.00","KSHisName":"","KSMasterUserID":"lsxzb","KSMasterName":"行政部李四","ParkLeaderID":"hpl","ParkLeaderName":"胡沛林","SWYID":"","SWYName":""},{"QZH":"999","KSName":"市场部","KSCode":"10","XH":"10.00","KSHisName":"","KSMasterUserID":"lsscb","KSMasterName":"市场部赵五","ParkLeaderID":"mobileTest","ParkLeaderName":"mobileTest","SWYID":"","SWYName":""},{"QZH":"999","KSName":"采购部","KSCode":"11","XH":"11.00","KSHisName":"","KSMasterUserID":"lscgb","KSMasterName":"采购部许六","ParkLeaderID":"system","ParkLeaderName":"系统管理员","SWYID":"","SWYName":""},{"QZH":"999","KSName":"三防办","KSCode":"12","XH":"12.00","KSHisName":"","KSMasterUserID":"lsck","KSMasterName":"仓库刘七","ParkLeaderID":"","ParkLeaderName":"系统管理员","SWYID":"","SWYName":""},{"QZH":"999","KSName":"政策法规科","KSCode":"13","XH":"13.00","KSHisName":"","KSMasterUserID":"lqx","KSMasterName":"李清秀","ParkLeaderID":"hhl","ParkLeaderName":"胡红林","SWYID":"","SWYName":""}]
     * IsSuccess : true
     * ErrorMessage :
     * ErrorCode : 000
     */

    private boolean IsSuccess;
    private String ErrorMessage;
    private String ErrorCode;
    private List<DatasBean> Datas;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public List<DatasBean> getDatas() {
        return Datas;
    }

    public void setDatas(List<DatasBean> Datas) {
        this.Datas = Datas;
    }

    public static class DatasBean {
        /**
         * QZH : 999
         * KSName : 局领导
         * KSCode : 01
         * XH : 1.00
         * KSHisName :
         * KSMasterUserID : yl
         * KSMasterName : 依林
         * ParkLeaderID : lindao
         * ParkLeaderName : 领导
         * SWYID :
         * SWYName :
         */

        private String QZH;
        private String KSName;
        private String KSCode;
        private String XH;
        private String KSHisName;
        private String KSMasterUserID;
        private String KSMasterName;
        private String ParkLeaderID;
        private String ParkLeaderName;
        private String SWYID;
        private String SWYName;

        public String getQZH() {
            return QZH;
        }

        public void setQZH(String QZH) {
            this.QZH = QZH;
        }

        public String getKSName() {
            return KSName;
        }

        public void setKSName(String KSName) {
            this.KSName = KSName;
        }

        public String getKSCode() {
            return KSCode;
        }

        public void setKSCode(String KSCode) {
            this.KSCode = KSCode;
        }

        public String getXH() {
            return XH;
        }

        public void setXH(String XH) {
            this.XH = XH;
        }

        public String getKSHisName() {
            return KSHisName;
        }

        public void setKSHisName(String KSHisName) {
            this.KSHisName = KSHisName;
        }

        public String getKSMasterUserID() {
            return KSMasterUserID;
        }

        public void setKSMasterUserID(String KSMasterUserID) {
            this.KSMasterUserID = KSMasterUserID;
        }

        public String getKSMasterName() {
            return KSMasterName;
        }

        public void setKSMasterName(String KSMasterName) {
            this.KSMasterName = KSMasterName;
        }

        public String getParkLeaderID() {
            return ParkLeaderID;
        }

        public void setParkLeaderID(String ParkLeaderID) {
            this.ParkLeaderID = ParkLeaderID;
        }

        public String getParkLeaderName() {
            return ParkLeaderName;
        }

        public void setParkLeaderName(String ParkLeaderName) {
            this.ParkLeaderName = ParkLeaderName;
        }

        public String getSWYID() {
            return SWYID;
        }

        public void setSWYID(String SWYID) {
            this.SWYID = SWYID;
        }

        public String getSWYName() {
            return SWYName;
        }

        public void setSWYName(String SWYName) {
            this.SWYName = SWYName;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "QZH='" + QZH + '\'' +
                    ", KSName='" + KSName + '\'' +
                    ", KSCode='" + KSCode + '\'' +
                    ", XH='" + XH + '\'' +
                    ", KSHisName='" + KSHisName + '\'' +
                    ", KSMasterUserID='" + KSMasterUserID + '\'' +
                    ", KSMasterName='" + KSMasterName + '\'' +
                    ", ParkLeaderID='" + ParkLeaderID + '\'' +
                    ", ParkLeaderName='" + ParkLeaderName + '\'' +
                    ", SWYID='" + SWYID + '\'' +
                    ", SWYName='" + SWYName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "QZDWKSList{" +
                "IsSuccess=" + IsSuccess +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", Datas=" + Datas +
                '}';
    }
}
