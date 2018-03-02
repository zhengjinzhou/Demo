package zhou.com.demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/1.
 * 按收文办理状态查询文件
 */

public class ListOfBLState implements Serializable {

    /**
     * Datas : [{"MGUID":"5405EDD04CFE4E929F8EA8C94BF8C239","WhereGUID":"CF5DCC4A1A66422CA7FC74F18352981A","FileID":"491428","HandleID":"490548","FileQZH":"999","SWBH":"SW201800040","jbrQZH":"999","Title":"测试派送","HJ":"普件","JBRUserID":null,"JBRName":null,"SendDate":"2018-03-01 08:35:44","LastDate":"2018-03-06","BLType":"拟办意见","BLSort":"拟办","WhoGiveName":"胡红林","BLDate":"","IFok":"0","BLStatus":"待办","SWDate":"2018-03-01","WHT":null,"WHN":null,"WHS":null,"WH":"〔〕号","LWDW":"","Memo":null,"YiJian":"","Signup":null,"XH":null,"BLYQ":null,"StarMark":"","SW_GRGZ":null},{"MGUID":"50c95c5e53f64c8f8c5c7a8b1dafe52f","WhereGUID":"91F2D22799394E869E53FA691CD26397","FileID":"491424","HandleID":"490546","FileQZH":"999","SWBH":"SW201800037","jbrQZH":"999","Title":"测试标题","HJ":"普件","JBRUserID":null,"JBRName":null,"SendDate":"2018-02-28 17:20:09","LastDate":"2018-03-05","BLType":"拟办意见","BLSort":"拟办","WhoGiveName":"胡红林","BLDate":"","IFok":"0","BLStatus":"待办","SWDate":"2018-02-28","WHT":null,"WHN":null,"WHS":null,"WH":"〔〕号","LWDW":"广东万维博通信息技术有限公司","Memo":null,"YiJian":"","Signup":null,"XH":null,"BLYQ":null,"StarMark":"","SW_GRGZ":null},{"MGUID":"1315D5E429B44F0BB278CC58E11333AA","WhereGUID":"DA45063B79FE4E4081970BB51F54FBF5","FileID":"491427","HandleID":"490544","FileQZH":"999","SWBH":"SW201800039","jbrQZH":"999","Title":"增加","HJ":"普件","JBRUserID":null,"JBRName":null,"SendDate":"2018-02-28 16:58:50","LastDate":"2018-03-05","BLType":"拟办意见","BLSort":"拟办","WhoGiveName":"胡红林","BLDate":"","IFok":"0","BLStatus":"待办","SWDate":"2018-02-28","WHT":null,"WHN":null,"WHS":null,"WH":"〔〕号","LWDW":"","Memo":null,"YiJian":"","Signup":null,"XH":null,"BLYQ":null,"StarMark":"","SW_GRGZ":null},{"MGUID":"5F877CAFC3364D12AB0C184280DE1685","WhereGUID":"8581A7623F0F4F839086E88B59201D14","FileID":"491064","HandleID":"490395","FileQZH":"999","SWBH":"SW20160010","jbrQZH":"999","Title":"关于组织申报2015年广东省前沿与关键技术创新专项资金项目（粤港联合创新领域）的通知","HJ":"普件","JBRUserID":null,"JBRName":null,"SendDate":"2017-02-16 11:27:35","LastDate":"2017-02-21","BLType":"文件传阅","BLSort":"传阅","WhoGiveName":"杨乐","BLDate":"2017-04-21 16:04:43","IFok":"0","BLStatus":"待办","SWDate":"2016-03-29","WHT":null,"WHN":null,"WHS":null,"WH":"〔〕号","LWDW":"广东省科学技术厅","Memo":null,"YiJian":"%u8bf7%u5e02%u573a%u90e8%u5f90%u73b2%u540c%u5fd7%u9605%u3002","Signup":null,"XH":null,"BLYQ":null,"StarMark":"","SW_GRGZ":null}]
     * RowCount : 4
     * PageCount : 1
     * IsSuccess : true
     * ErrorMessage :
     * ErrorCode : 000
     */

    private int RowCount;
    private int PageCount;
    private boolean IsSuccess;
    private String ErrorMessage;
    private String ErrorCode;
    private List<DatasBean> Datas;

    public int getRowCount() {
        return RowCount;
    }

    public void setRowCount(int RowCount) {
        this.RowCount = RowCount;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
    }

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

    public static class DatasBean implements Serializable {

        public DatasBean(String MGUID, String whereGUID, String fileID, String handleID, String fileQZH, String SWBH, String jbrQZH, String title, String HJ, Object JBRUserID, Object JBRName, String sendDate, String lastDate, String BLType, String BLSort, String whoGiveName, String BLDate, String IFok, String BLStatus, String SWDate, Object WHT, Object WHN, Object WHS, String WH, String LWDW, Object memo, String yiJian, Object signup, Object XH, Object BLYQ, String starMark, Object SW_GRGZ) {
            this.MGUID = MGUID;
            WhereGUID = whereGUID;
            FileID = fileID;
            HandleID = handleID;
            FileQZH = fileQZH;
            this.SWBH = SWBH;
            this.jbrQZH = jbrQZH;
            Title = title;
            this.HJ = HJ;
            this.JBRUserID = JBRUserID;
            this.JBRName = JBRName;
            SendDate = sendDate;
            LastDate = lastDate;
            this.BLType = BLType;
            this.BLSort = BLSort;
            WhoGiveName = whoGiveName;
            this.BLDate = BLDate;
            this.IFok = IFok;
            this.BLStatus = BLStatus;
            this.SWDate = SWDate;
            this.WHT = WHT;
            this.WHN = WHN;
            this.WHS = WHS;
            this.WH = WH;
            this.LWDW = LWDW;
            Memo = memo;
            YiJian = yiJian;
            Signup = signup;
            this.XH = XH;
            this.BLYQ = BLYQ;
            StarMark = starMark;
            this.SW_GRGZ = SW_GRGZ;
        }

        /**
         * MGUID : 5405EDD04CFE4E929F8EA8C94BF8C239
         * WhereGUID : CF5DCC4A1A66422CA7FC74F18352981A
         * FileID : 491428
         * HandleID : 490548
         * FileQZH : 999
         * SWBH : SW201800040
         * jbrQZH : 999
         * Title : 测试派送
         * HJ : 普件
         * JBRUserID : null
         * JBRName : null
         * SendDate : 2018-03-01 08:35:44
         * LastDate : 2018-03-06
         * BLType : 拟办意见
         * BLSort : 拟办
         * WhoGiveName : 胡红林
         * BLDate :
         * IFok : 0
         * BLStatus : 待办
         * SWDate : 2018-03-01
         * WHT : null
         * WHN : null
         * WHS : null
         * WH : 〔〕号
         * LWDW :
         * Memo : null
         * YiJian :
         * Signup : null
         * XH : null
         * BLYQ : null
         * StarMark :
         * SW_GRGZ : null
         */


        private String MGUID;
        private String WhereGUID;
        private String FileID;
        private String HandleID;
        private String FileQZH;
        private String SWBH;
        private String jbrQZH;
        private String Title;
        private String HJ;
        private Object JBRUserID;
        private Object JBRName;
        private String SendDate;
        private String LastDate;
        private String BLType;
        private String BLSort;
        private String WhoGiveName;
        private String BLDate;
        private String IFok;
        private String BLStatus;
        private String SWDate;
        private Object WHT;
        private Object WHN;
        private Object WHS;
        private String WH;
        private String LWDW;
        private Object Memo;
        private String YiJian;
        private Object Signup;
        private Object XH;
        private Object BLYQ;
        private String StarMark;
        private Object SW_GRGZ;

        public String getMGUID() {
            return MGUID;
        }

        public void setMGUID(String MGUID) {
            this.MGUID = MGUID;
        }

        public String getWhereGUID() {
            return WhereGUID;
        }

        public void setWhereGUID(String WhereGUID) {
            this.WhereGUID = WhereGUID;
        }

        public String getFileID() {
            return FileID;
        }

        public void setFileID(String FileID) {
            this.FileID = FileID;
        }

        public String getHandleID() {
            return HandleID;
        }

        public void setHandleID(String HandleID) {
            this.HandleID = HandleID;
        }

        public String getFileQZH() {
            return FileQZH;
        }

        public void setFileQZH(String FileQZH) {
            this.FileQZH = FileQZH;
        }

        public String getSWBH() {
            return SWBH;
        }

        public void setSWBH(String SWBH) {
            this.SWBH = SWBH;
        }

        public String getJbrQZH() {
            return jbrQZH;
        }

        public void setJbrQZH(String jbrQZH) {
            this.jbrQZH = jbrQZH;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getHJ() {
            return HJ;
        }

        public void setHJ(String HJ) {
            this.HJ = HJ;
        }

        public Object getJBRUserID() {
            return JBRUserID;
        }

        public void setJBRUserID(Object JBRUserID) {
            this.JBRUserID = JBRUserID;
        }

        public Object getJBRName() {
            return JBRName;
        }

        public void setJBRName(Object JBRName) {
            this.JBRName = JBRName;
        }

        public String getSendDate() {
            return SendDate;
        }

        public void setSendDate(String SendDate) {
            this.SendDate = SendDate;
        }

        public String getLastDate() {
            return LastDate;
        }

        public void setLastDate(String LastDate) {
            this.LastDate = LastDate;
        }

        public String getBLType() {
            return BLType;
        }

        public void setBLType(String BLType) {
            this.BLType = BLType;
        }

        public String getBLSort() {
            return BLSort;
        }

        public void setBLSort(String BLSort) {
            this.BLSort = BLSort;
        }

        public String getWhoGiveName() {
            return WhoGiveName;
        }

        public void setWhoGiveName(String WhoGiveName) {
            this.WhoGiveName = WhoGiveName;
        }

        public String getBLDate() {
            return BLDate;
        }

        public void setBLDate(String BLDate) {
            this.BLDate = BLDate;
        }

        public String getIFok() {
            return IFok;
        }

        public void setIFok(String IFok) {
            this.IFok = IFok;
        }

        public String getBLStatus() {
            return BLStatus;
        }

        public void setBLStatus(String BLStatus) {
            this.BLStatus = BLStatus;
        }

        public String getSWDate() {
            return SWDate;
        }

        public void setSWDate(String SWDate) {
            this.SWDate = SWDate;
        }

        public Object getWHT() {
            return WHT;
        }

        public void setWHT(Object WHT) {
            this.WHT = WHT;
        }

        public Object getWHN() {
            return WHN;
        }

        public void setWHN(Object WHN) {
            this.WHN = WHN;
        }

        public Object getWHS() {
            return WHS;
        }

        public void setWHS(Object WHS) {
            this.WHS = WHS;
        }

        public String getWH() {
            return WH;
        }

        public void setWH(String WH) {
            this.WH = WH;
        }

        public String getLWDW() {
            return LWDW;
        }

        public void setLWDW(String LWDW) {
            this.LWDW = LWDW;
        }

        public Object getMemo() {
            return Memo;
        }

        public void setMemo(Object Memo) {
            this.Memo = Memo;
        }

        public String getYiJian() {
            return YiJian;
        }

        public void setYiJian(String YiJian) {
            this.YiJian = YiJian;
        }

        public Object getSignup() {
            return Signup;
        }

        public void setSignup(Object Signup) {
            this.Signup = Signup;
        }

        public Object getXH() {
            return XH;
        }

        public void setXH(Object XH) {
            this.XH = XH;
        }

        public Object getBLYQ() {
            return BLYQ;
        }

        public void setBLYQ(Object BLYQ) {
            this.BLYQ = BLYQ;
        }

        public String getStarMark() {
            return StarMark;
        }

        public void setStarMark(String StarMark) {
            this.StarMark = StarMark;
        }

        public Object getSW_GRGZ() {
            return SW_GRGZ;
        }

        public void setSW_GRGZ(Object SW_GRGZ) {
            this.SW_GRGZ = SW_GRGZ;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "MGUID='" + MGUID + '\'' +
                    ", WhereGUID='" + WhereGUID + '\'' +
                    ", FileID='" + FileID + '\'' +
                    ", HandleID='" + HandleID + '\'' +
                    ", FileQZH='" + FileQZH + '\'' +
                    ", SWBH='" + SWBH + '\'' +
                    ", jbrQZH='" + jbrQZH + '\'' +
                    ", Title='" + Title + '\'' +
                    ", HJ='" + HJ + '\'' +
                    ", JBRUserID=" + JBRUserID +
                    ", JBRName=" + JBRName +
                    ", SendDate='" + SendDate + '\'' +
                    ", LastDate='" + LastDate + '\'' +
                    ", BLType='" + BLType + '\'' +
                    ", BLSort='" + BLSort + '\'' +
                    ", WhoGiveName='" + WhoGiveName + '\'' +
                    ", BLDate='" + BLDate + '\'' +
                    ", IFok='" + IFok + '\'' +
                    ", BLStatus='" + BLStatus + '\'' +
                    ", SWDate='" + SWDate + '\'' +
                    ", WHT=" + WHT +
                    ", WHN=" + WHN +
                    ", WHS=" + WHS +
                    ", WH='" + WH + '\'' +
                    ", LWDW='" + LWDW + '\'' +
                    ", Memo=" + Memo +
                    ", YiJian='" + YiJian + '\'' +
                    ", Signup=" + Signup +
                    ", XH=" + XH +
                    ", BLYQ=" + BLYQ +
                    ", StarMark='" + StarMark + '\'' +
                    ", SW_GRGZ=" + SW_GRGZ +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ListOfBLState{" +
                "RowCount=" + RowCount +
                ", PageCount=" + PageCount +
                ", IsSuccess=" + IsSuccess +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", Datas=" + Datas +
                '}';
    }
}
