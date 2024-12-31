package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.DashboardDto;
import in.ashokit.dto.EnqFilterDto;
import in.ashokit.dto.EnquiryDto;

public interface EnquiryService {

	public DashboardDto getDashboardInfo(Integer counsellorId);

	public boolean addEnquiry(EnquiryDto enqDto,Integer counsellorId);
	
	public List<EnquiryDto> getEnquiries(Integer counsellorId);
	
	public List<EnquiryDto> getEnquiries(EnqFilterDto filterDto ,Integer counsellorId);
	
	public EnquiryDto getEnquiryById(Integer enqId);
}
