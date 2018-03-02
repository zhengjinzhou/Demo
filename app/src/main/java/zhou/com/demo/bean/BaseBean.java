package zhou.com.demo.bean;

/**
 * Created by zhou on 2018/2/28.
 * 用于登录的时候转换
 */

public class BaseBean{
    private String username;
    private String psd;

    public BaseBean(String username, String psd) {
        this.username = username;
        this.psd = psd;
    }

    @Override
    public String toString() {
        return "{" + "\"UserID\":\""+username+"\"," + "\"PSW\":\""+psd+"\"" +"}";
    }
}