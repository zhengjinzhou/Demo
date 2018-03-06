package zhou.com.demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/6.
 * 收文附件列表
 * 文档出现错误 请求参数中的Main_GUID要改为GUID
 */

public class GetSWQWListBean implements Serializable {

    /**
     * Datas : [{"Name":"07合同清单中间计量汇总表18_看图王.pdf","GUID":"7e90e5db1f8444319ab1c9643b0ff31d","XH":"1"}]
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
         * Name : 07合同清单中间计量汇总表18_看图王.pdf
         * GUID : 7e90e5db1f8444319ab1c9643b0ff31d
         * XH : 1
         */

        private String Name;
        private String GUID;
        private String XH;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getGUID() {
            return GUID;
        }

        public void setGUID(String GUID) {
            this.GUID = GUID;
        }

        public String getXH() {
            return XH;
        }

        public void setXH(String XH) {
            this.XH = XH;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "Name='" + Name + '\'' +
                    ", GUID='" + GUID + '\'' +
                    ", XH='" + XH + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetSWQWListBean{" +
                "IsSuccess=" + IsSuccess +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", Datas=" + Datas +
                '}';
    }
}
