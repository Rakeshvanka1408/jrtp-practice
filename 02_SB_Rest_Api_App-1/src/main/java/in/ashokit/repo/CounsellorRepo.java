package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.CounsellorsEntity;

public interface CounsellorRepo extends JpaRepository<CounsellorsEntity,Integer> {

}
