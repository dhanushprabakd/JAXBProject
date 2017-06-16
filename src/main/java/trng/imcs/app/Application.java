package trng.imcs.app;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.Marks;
import trng.imcs.jaxb.Student;

public class Application {
	public static void main(String[] args) throws DatatypeConfigurationException {
		studentMarshaller();
		studentUnMarshaller();
	}

	private static void studentUnMarshaller() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student stud = (Student) jaxbUnmarshaller.unmarshal(new File("C:\\IMCS\\workspace-web\\MyJAXBProject\\src\\main\\resources\\XML\\studentDetails.xml"));
			System.out.println(stud);
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

	private static void studentMarshaller() {
		try {

			File file = new File("C:\\IMCS\\workspace-web\\MyJAXBProject\\src\\main\\resources\\XML\\studentDetails.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(getStudent(), file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}		
	}

	private static Student getStudent() {
		Student stud = new Student();
		Marks marks = new Marks();
		Address address = new Address();
		marks.setMarks(60);
		marks.setSubject("Maths");
		marks.setMaxMark(100);
		address.setAddressType("HOME");
		address.setStreet("908 Greek Row");
		address.setZipCode("76013");
		address.setCountry("USA");
		Address address2 = new Address();
		address2.setAddressType("COMMUNICATION");
		address2.setStreet("908 Greek Row");
		address2.setZipCode("76013");
		address2.setCountry("USA");
		
		stud.setId(1);
		stud.setFirstName("Dhanush");
		stud.setLastName("Prabakaran");
		stud.getAddress().add(address);
		stud.getAddress().add(address2);
		stud.getMarks().add(marks);
		
		return stud;
	}
}
