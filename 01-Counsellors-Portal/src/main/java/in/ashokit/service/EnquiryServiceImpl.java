package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardDto;
import in.ashokit.dto.EnqFilterDto;
import in.ashokit.dto.EnquiryDto;
import in.ashokit.entity.CounsellorEntity;
import in.ashokit.entity.EnquiryEntity;
import in.ashokit.repo.CounsellorRepo;
import in.ashokit.repo.EnquiryRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepo enquiryRepo;
	
	@Autowired
	private CounsellorRepo counsellorRepo;

	@Override
	public DashboardDto getDashboardInfo(Integer counsellorId) {
		DashboardDto dto = new DashboardDto();
		List<EnquiryEntity> enqsList = enquiryRepo.findByCounsellorCounsellorId(counsellorId);
		int openCnt = enqsList.stream()
				.filter(enq-> enq.getEnqStatus().equals("OPEN"))
				.collect(Collectors.toList())
				.size();
		int enrolledCnt = enqsList.stream()
				.filter(enq ->enq.getEnqStatus().equals(enqsList))
				.collect(Collectors.toList())
				.size()
				;
		int lostCnt = enqsList.stream().filter(enq -> enq.getEnqStatus().equals("LOST"))
				.collect(Collectors.toList())
				.size();
		dto.setTotalEnq(enqsList.size());
		dto.setOpnEnq(openCnt);
		dto.setLstEnq(lostCnt);
		dto.setEnrldEnq(enrolledCnt);
		return null;
	}

	@Override
	public boolean addEnquiry(EnquiryDto enqDto, Integer counsellorId) {
		
		EnquiryEntity entity = new EnquiryEntity();
		BeanUtils.copyProperties(enqDto, entity);
		Optional<CounsellorEntity> byId = counsellorRepo.findById(counsellorId);
		if(byId.isPresent()) {
			CounsellorEntity counsellor = byId.get();
			entity.setCounsellor(counsellor);
			
		}
		EnquiryEntity save = enquiryRepo.save(entity);
		return save.getEnqId()!=null;
	}

	@Override
	public List<EnquiryDto> getEnquiries(Integer counsellorId) {
		List<EnquiryDto>enqsDtoList = new ArrayList<>();
		List<EnquiryEntity> enqList = enquiryRepo.findByCounsellorCounsellorId(counsellorId);
		for(EnquiryEntity entity : enqList) {
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(entity, dto);
			enqsDtoList.add(dto);
		}
		return enqsDtoList;
	}

	@Override
	public List<EnquiryDto> getEnquiries(EnqFilterDto filterDto, Integer counsellorId) {
		EnquiryEntity entity = new EnquiryEntity();
		if(filterDto.getClsMode()!=null && !filterDto.getClsMode().equals("")) {
			entity.setClsMode(filterDto.getClsMode());
		}
		if(filterDto.getCourse()!=null && !filterDto.getCourse().equals("")) {
			entity.setCourse(filterDto.getCourse());
		}
		if(filterDto.getEnqStatus()!=null && !filterDto.getEnqStatus().equals("")) {
			entity.setCourse(filterDto.getCourse());
		}
		CounsellorEntity counsellor = new CounsellorEntity();
		counsellor.setCounsellorId(counsellorId);
		entity.setCounsellor(counsellor);
		Example<EnquiryEntity> of = Example.of(entity);
		List<EnquiryEntity> enqList = enquiryRepo.findAll(of);
		List<EnquiryDto>enqsDtoList = new ArrayList<>();

		for(EnquiryEntity enq : enqList) {
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(entity, dto);
			enqsDtoList.add(dto);
		}
		return enqsDtoList;
	}

	@Override
	public EnquiryDto getEnquiryById(Integer enqId) {
		Optional<EnquiryEntity> byId = enquiryRepo.findById(enqId);
		if(byId.isPresent()) {
			EnquiryEntity enquiryEntity = byId.get()
					;
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(enquiryEntity, dto);
			return dto;
		}
		return null;
	}

}
