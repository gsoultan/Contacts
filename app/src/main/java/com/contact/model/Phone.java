package com.contact.model;

import java.io.Serializable;

/**
 * Created by Gembit Soultan on 5/20/2017.
 */

public class Phone implements Serializable {
    private String mobile;
    private String home;
    private String office;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
