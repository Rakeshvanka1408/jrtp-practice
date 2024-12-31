package in.ashokit.service;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.dto.CounsellorDto;
import in.ashokit.entity.CounsellorEntity;

public interface CounsellorService  extends JpaRepository<CounsellorEntity,Integer>{

	public CounsellorDto login (CounsellorDto counsellorDto);
	
	public boolean uniqueEmailCheck(String email);
	
	public boolean register(CounsellorDto counsellorDto);
}
