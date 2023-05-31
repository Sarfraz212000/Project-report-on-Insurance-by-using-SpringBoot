package in.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.DTO.SearchRequest;
import in.ashokit.entity.CitizenEntity;
import in.ashokit.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		String headerkey = "content-disposition";
		String headerValue = "attchement;filename=plans.pdf";
		response.addHeader(headerkey, headerValue);
		service.exportPdf(response);
	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");

		service.exportExcel(response);

	}

	@GetMapping("/")
	public String indexPage(Model model) {

		model.addAttribute("serach", new SearchRequest());
		init(model);
		return "index";
	}
	private void init(Model model) {
		model.addAttribute("name", service.getPlanName());
		model.addAttribute("status", service.getplanStatus());
	}

	@PostMapping("/serach")
	public String handelSearch(@ModelAttribute("serach") SearchRequest request, Model model) {

		// model.addAttribute("serach",new SearchRequest());
		List<CitizenEntity> plans = service.search(request);

		model.addAttribute("plans", plans);

		init(model);
		return "index";

	}

}
