package in.ashokit.dataloder;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenEntity;
import in.ashokit.repository.CitizenplanRepo;

@Component
 class DataLoader implements ApplicationRunner {

	@Autowired
	CitizenplanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repo.deleteAll();
		//  cash paln........................................................................................
		CitizenEntity c1 = new CitizenEntity();

		c1.setCitizenName("sarfraz");
		c1.setPlanName("cash");
		c1.setGender("Male");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmmount(55550.00);

		CitizenEntity c2 = new CitizenEntity();

		c2.setCitizenName("sumita");
		c2.setPlanName("cash");
		c2.setGender("feMale");
		c2.setPlanStatus("Approved");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setBenifitAmmount(5550.00);

		CitizenEntity c3 = new CitizenEntity();

		c3.setCitizenName("Abhishek");
		c3.setPlanName("cash");
		c3.setGender("Male");
		c3.setPlanStatus("denied");
		c3.setDenialReson("not stisfied");

		CitizenEntity c4 = new CitizenEntity();

		c4.setCitizenName("Sunny");
		c4.setPlanName("cash");
		c4.setGender("feMale");
		c4.setPlanStatus("denied");
		c4.setDenialReson("not stisfied");

		CitizenEntity c5 = new CitizenEntity();

		c5.setCitizenName("Amit");
		c5.setPlanName("cash");
		c5.setGender("Male");
		c5.setPlanStatus("terminated");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4));
		c5.setTermiantionReson("bad behiour");

		CitizenEntity c6 = new CitizenEntity();

		c6.setCitizenName("Rani");
		c6.setPlanName("cash");
		c6.setGender("feMale");
		c6.setPlanStatus("terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c6.setTermiantionReson("gotJob");

		// food
		// plan..............................................................................................
		CitizenEntity c7 = new CitizenEntity();

		c7.setCitizenName("murtuja");
		c7.setPlanName("food");
		c7.setGender("Male");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmmount(15550.00);

		CitizenEntity c8 = new CitizenEntity();

		c8.setCitizenName("sunny");
		c8.setPlanName("food");
		c8.setGender("feMale");
		c8.setPlanStatus("Approved");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setBenifitAmmount(25550.00);

		CitizenEntity c9 = new CitizenEntity();

		c9.setCitizenName("Guddu");
		c9.setPlanName("food");
		c9.setGender("Male");
		c9.setPlanStatus("denied");
		c9.setDenialReson("not payments");

		CitizenEntity c10 = new CitizenEntity();

		c10.setCitizenName("Salima");
		c10.setPlanName("food");
		c10.setGender("feMale");
		c10.setPlanStatus("denied");
		c10.setDenialReson("not patricipated");

		CitizenEntity c11 = new CitizenEntity();

		c11.setCitizenName("Amar");
		c11.setPlanName("food");
		c11.setGender("Male");
		c11.setPlanStatus("terminated");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4));
		c11.setTermiantionReson("not good behiour");

		CitizenEntity c12 = new CitizenEntity();

		c12.setCitizenName("Ragnii");
		c12.setPlanName("food");
		c12.setGender("feMale");
		c12.setPlanStatus("terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c12.setTermiantionReson("gotJob");

		// Medical
		// plan..............................................................................................
		CitizenEntity c13 = new CitizenEntity();

		c13.setCitizenName("Datta");
		c13.setPlanName("Medical");
		c13.setGender("Male");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now());
		c13.setPlanEndDate(LocalDate.now().plusMonths(6));
		c13.setBenifitAmmount(35550.00);

		CitizenEntity c14 = new CitizenEntity();

		c14.setCitizenName("soni");
		c14.setPlanName("Medical");
		c14.setGender("feMale");
		c14.setPlanStatus("Approved");
		c14.setPlanStartDate(LocalDate.now());
		c14.setPlanEndDate(LocalDate.now().plusMonths(6));
		c14.setBenifitAmmount(25550.00);

		CitizenEntity c15 = new CitizenEntity();

		c15.setCitizenName("Guddu");
		c15.setPlanName("Medical");
		c15.setGender("Male");
		c15.setPlanStatus("denied");
		c15.setDenialReson("leave");

		CitizenEntity c16 = new CitizenEntity();

		c16.setCitizenName("sabina");
		c16.setPlanName("Medical");
		c16.setGender("feMale");
		c16.setPlanStatus("denied");
		c16.setDenialReson("not aplicable");

		CitizenEntity c17 = new CitizenEntity();

		c17.setCitizenName("virat");
		c17.setPlanName("Medical");
		c17.setGender("Male");
		c17.setPlanStatus("terminated");
		c17.setPlanStartDate(LocalDate.now());
		c17.setPlanEndDate(LocalDate.now().plusMonths(6));
		c17.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4));
		c17.setTermiantionReson("retriments");

		CitizenEntity c18 = new CitizenEntity();

		c18.setCitizenName("Nasima");
		c18.setPlanName("Medical");
		c18.setGender("feMale");
		c18.setPlanStatus("terminated");
		c18.setPlanStartDate(LocalDate.now());
		c18.setPlanEndDate(LocalDate.now().plusMonths(6));
		c18.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c18.setTermiantionReson("gotJob");

		
		// Employeement plan..............................................................................................
		CitizenEntity c19 = new CitizenEntity();

		c19.setCitizenName("Ashok");
		c19.setPlanName("Employeement");
		c19.setGender("Male");
		c19.setPlanStatus("Approved");
		c19.setPlanStartDate(LocalDate.now());
		c19.setPlanEndDate(LocalDate.now().plusMonths(6));
		c19.setBenifitAmmount(395550.00);

		CitizenEntity c20 = new CitizenEntity();

		c20.setCitizenName("somiya");
		c20.setPlanName("Employeement");
		c20.setGender("feMale");
		c20.setPlanStatus("Approved");
		c20.setPlanStartDate(LocalDate.now());
		c20.setPlanEndDate(LocalDate.now().plusMonths(6));
		c20.setBenifitAmmount(95550.00);

		CitizenEntity c21 = new CitizenEntity();

		c21.setCitizenName("Rajiv");
		c21.setPlanName("Employeement");
		c21.setGender("Male");
		c21.setPlanStatus("denied");
		c21.setDenialReson("not pasent");

		CitizenEntity c22 = new CitizenEntity();

		c22.setCitizenName("Rajiya");
		c22.setPlanName("Employeement");
		c22.setGender("feMale");
		c22.setPlanStatus("denied");
		c22.setDenialReson("not aplicable");

		CitizenEntity c23 = new CitizenEntity();

		c23.setCitizenName("Sachin");
		c23.setPlanName("Employeement");
		c23.setGender("Male");
		c23.setPlanStatus("terminated");
		c23.setPlanStartDate(LocalDate.now());
		c23.setPlanEndDate(LocalDate.now().plusMonths(6));
		c23.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4));
		c23.setTermiantionReson("retriments");

		CitizenEntity c24 = new CitizenEntity();

		c24.setCitizenName("Shsita");
		c24.setPlanName("Employeement");
		c24.setGender("feMale");
		c24.setPlanStatus("terminated");
		c24.setPlanStartDate(LocalDate.now());
		c24.setPlanEndDate(LocalDate.now().plusMonths(6));
		c24.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c24.setTermiantionReson("gotJob");
		
		
      
		repo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24));
		
	}

}
