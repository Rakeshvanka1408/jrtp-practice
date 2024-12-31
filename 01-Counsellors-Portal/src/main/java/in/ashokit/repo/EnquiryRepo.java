package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.EnquiryEntity;

public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Integer> {

	public List<EnquiryEntity> findByCounsellorCounsellorId(Integer counsellorId);
}