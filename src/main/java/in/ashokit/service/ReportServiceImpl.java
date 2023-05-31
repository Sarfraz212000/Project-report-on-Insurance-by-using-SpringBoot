package in.ashokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.DTO.SearchRequest;
import in.ashokit.Util.EmailUtils;
import in.ashokit.Util.Excelgenrator;
import in.ashokit.Util.PdfGenrator;
import in.ashokit.entity.CitizenEntity;
import in.ashokit.repository.CitizenplanRepo;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenplanRepo repo;
	
	@Autowired
	private  Excelgenrator excelgenrator;
	
    @Autowired
	 private  PdfGenrator pdfgenrator;
    
    @Autowired
	private EmailUtils emailUtils;
    
	@Override
	public List<String> getPlanName() {
		return repo.getPlanName();
	}

	@Override
	public List<String> getplanStatus() {

		return repo.getplanStatus();
	}

	@Override
	public List<CitizenEntity> search(SearchRequest request) {

		CitizenEntity entity = new CitizenEntity();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {

			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {

			entity.setPlanStatus(request.getPlanStatus());

		}

		if (null != request.getGender() && !"".equals(request.getGender())) {

			entity.setGender(request.getGender());

		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {

			String startDate = request.getStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);

		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {

			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(endDate, formatter);

			entity.setPlanEndDate(localDate);
		}

		List<CitizenEntity> findAll = repo.findAll(Example.of(entity));
		return findAll;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		List<CitizenEntity> findAll = repo.findAll();
		
		File f=new File("Plans.xls");
		excelgenrator.genrateor(response,findAll,f);
		
		String subject="Test mail subject";
		String body="Test mail body";
		String to="bishwas855105@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		List<CitizenEntity> plans = repo.findAll();
        File f=new File("Plans.pdf");
        pdfgenrator.genrator(response, plans,f);
        
        String subject="Test mail subject";
		String body="Test mail body";
		String to="bishwas855105@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

}
