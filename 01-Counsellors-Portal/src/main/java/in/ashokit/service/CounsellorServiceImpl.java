package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import in.ashokit.dto.CounsellorDto;
import in.ashokit.entity.CounsellorEntity;
import in.ashokit.repo.CounsellorRepo;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;

	@Override
	public CounsellorDto login(CounsellorDto counsellorDto) {

		CounsellorEntity counsellorEntity = counsellorRepo.findByEmailAndPwd(counsellorDto.getEmail(),
				counsellorDto.getPwd());
		if (counsellorEntity != null) {
			// copy entity obj data into dto obj and return dto obj
			CounsellorDto dto = new CounsellorDto();
			BeanUtils.copyProperties(counsellorEntity, dto);

			return dto;
		}
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		CounsellorEntity entity = counsellorRepo.findByEmail(email);
		if (entity == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean register(CounsellorDto counsellorDto) {

		CounsellorEntity entity = new CounsellorEntity();
		BeanUtils.copyProperties(counsellorDto, entity);
		CounsellorEntity savedEntity = counsellorRepo.save(entity);
		
		return null!= savedEntity.getCounsellorId();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends CounsellorEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<CounsellorEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public CounsellorEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CounsellorEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CounsellorEntity getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CounsellorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CounsellorEntity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CounsellorEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CounsellorEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends CounsellorEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CounsellorEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CounsellorEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends CounsellorEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CounsellorEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends CounsellorEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends CounsellorEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
