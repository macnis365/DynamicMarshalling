package com.macnis.DynamicMarshallingUnmarshalling.modal;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DynamicMarshalUsingMetaDataOnClass {

    @Test
    public void testPersonWithoutNumber() throws JAXBException {
        Person person = new Person();
        PhoneNumber phoneNumber = new PhoneNumber();
        person.setFname("Willom");
        person.setLname("Jack");
        person.setAddress("London, England");
        person.setAge(100);
        phoneNumber.setLandline(000001211);
        phoneNumber.setMobile(999999999);
        phoneNumber.setOffice(01010101010);

        JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[]{Person.class}, null);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, "personWithoutNumberField");
        marshaller.marshal(person, System.out);

    }

    @Test
    public void testPersonWithNumber() throws JAXBException {
        Person person = new Person();
        PhoneNumber phoneNumber = new PhoneNumber();
        person.setFname("Willom");
        person.setLname("Jack");
        person.setAddress("London, England");
        person.setAge(100);
        phoneNumber.setLandline(000001211);
        phoneNumber.setMobile(999999999);
        phoneNumber.setOffice(01010101010);
        person.setPhoneNumber(phoneNumber);

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(person, System.out);

    }
}
