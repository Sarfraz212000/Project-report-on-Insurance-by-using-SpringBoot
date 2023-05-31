package in.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import in.ashokit.DTO.SearchRequest;
import in.ashokit.entity.CitizenEntity;


@Service
public interface ReportService {
	
	List<String> getPlanName();
	
	List<String> getplanStatus();
	
	List<CitizenEntity> search(SearchRequest request);
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;

}
