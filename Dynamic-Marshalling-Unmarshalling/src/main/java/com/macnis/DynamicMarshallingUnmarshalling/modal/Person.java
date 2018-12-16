package com.macnis.DynamicMarshallingUnmarshalling.modal;


import org.eclipse.persistence.oxm.annotations.XmlNamedAttributeNode;
import org.eclipse.persistence.oxm.annotations.XmlNamedObjectGraph;
import org.eclipse.persistence.oxm.annotations.XmlNamedSubgraph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlNamedObjectGraph(
        name="personWithoutNumberField",
        attributeNodes={
                @XmlNamedAttributeNode("fname"),
                @XmlNamedAttributeNode("lname"),
                @XmlNamedAttributeNode("address"),
                @XmlNamedAttributeNode(value="phoneNumbers", subgraph="phoneNumber")
        },
        subgraphs={
                @XmlNamedSubgraph(
                        name="phoneNumber",
                        attributeNodes = {
                                @XmlNamedAttributeNode("landline"),
                                @XmlNamedAttributeNode("mobile"),
                                @XmlNamedAttributeNode("office")
                        }
                )
        }
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    String fname;
    String lname;
    int age;
    @XmlElement(name="phoneNumber")
    PhoneNumber phoneNumber;
    String address;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
