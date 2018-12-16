package com.macnis.DynamicMarshallingUnmarshalling.modal;

import org.eclipse.persistence.jaxb.*;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DynamicMarshalWithMetaDataProgramatically {

    @Test
    public void dynamicMarshallingProgramatically() throws JAXBException {
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

        JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[]{Person.class}, null);
        Marshaller marshaller = jaxbContext.createMarshaller();
        ObjectGraph personWithoutPhoneNumber = JAXBHelper.getJAXBContext(jaxbContext).createObjectGraph(Person.class);
        personWithoutPhoneNumber.addAttributeNodes("fname");
        personWithoutPhoneNumber.addAttributeNodes("lname");
        personWithoutPhoneNumber.addAttributeNodes("address");
        Subgraph withoutOffice = personWithoutPhoneNumber.addSubgraph("phoneNumber");
        withoutOffice.addAttributeNodes("landline");
        withoutOffice.addAttributeNodes("mobile");
        marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, personWithoutPhoneNumber);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, System.out);
    }
}
