package biz;

import java.util.ArrayList;

//import java.util.Map;
public class DoctorRetrival {

	
	
	public  ArrayList<model.Doctor> searchDoctor( String searchString)
	{
		
		return new dal.DoctorRetrival().searchDoctor(searchString);
	}
	

	public  ArrayList<model.Doctor> getDoctorBySpeciality(int speciality) {
		return new dal.DoctorRetrival().searchDoctorBySpeciality(speciality);
	}
}
/*
 * ArrayList<model.Doctor> doc; doc=dal.Doctor.responseDoctor(searchString); int
 * rank; for(model.Doctor str : doc) { rank = 0;
 * if(searchString.contains(dal.Doctor.)) rank++;
 * 
 * } return doc; return doc; } }
 * 
 * foreach ( .doc..) { rank = 0; if (searchString.contains(doc[i].doc.firstname)
 * rank++;
 * 
 * }
 */