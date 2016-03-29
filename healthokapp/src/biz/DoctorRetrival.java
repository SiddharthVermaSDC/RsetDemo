package biz;

import java.util.ArrayList;

//import java.util.Map;
public class DoctorRetrival {

	public static ArrayList<model.DoctorRetrival> getDoctor(String fname, String mname, String lname, int count) {
		ArrayList<model.DoctorRetrival> docs;
		int rank;
		docs = new dal.DoctorRetrival().responseDoctor(fname, mname, lname, count);
		// int n=docs.size;
		if (count == 3) {
			for (model.DoctorRetrival doc : docs) {
				rank = 0;
				if (doc.getFirstName().contains(fname) || doc.getMiddleName().contains(fname)
						|| doc.getLastName().contains(fname))
					doc.setRank(++rank);
				if (doc.getFirstName().contains(mname) || doc.getMiddleName().contains(mname)
						|| doc.getLastName().contains(mname))
					doc.setRank(++rank);
				if (doc.getFirstName().contains(lname) || doc.getMiddleName().contains(lname)
						|| doc.getLastName().contains(lname))
					doc.setRank(++rank);
			}
		} else if (count == 2) {
			for (model.DoctorRetrival doc : docs) {
				rank = 0;
				if (doc.getFirstName().contains(fname) || doc.getMiddleName().contains(fname)
						|| doc.getLastName().contains(fname))
					doc.setRank(++rank);
				if (doc.getFirstName().contains(mname) || doc.getMiddleName().contains(mname)
						|| doc.getLastName().contains(mname))
					doc.setRank(++rank);
			}
		} else if (count == 1) {
			for (model.DoctorRetrival doc : docs) {
				rank = 0;
				if (doc.getFirstName().contains(fname) || doc.getMiddleName().contains(fname)
						|| doc.getLastName().contains(fname))
					doc.setRank(++rank);
			}
		}
		return docs;
	}

	public static ArrayList<model.DoctorRetrival> getDoctorBySpeciality(int speciality) {
		return dal.DoctorRetrival.responseDoctorBySpeciality(speciality);
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