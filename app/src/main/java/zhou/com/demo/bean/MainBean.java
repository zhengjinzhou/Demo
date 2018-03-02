package zhou.com.demo.bean;

import java.io.Serializable;

/**
 * Created by zhou on 2018/2/26.
 */

public class MainBean implements Serializable{

    public MainBean(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    private String name;
    private int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
