package com.macnis.DynamicMarshallingUnmarshalling.modal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {
    int landline;
    int mobile;
    int office;

    public int getLandline() {
        return landline;
    }

    public void setLandline(int landline) {
        this.landline = landline;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }
}
