package com.gradeMeApp.service.moPuMoCa;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gradeMeApp.dataaccessobject.SubPuMoCaRepository;
import com.gradeMeApp.domainobject.MonthCategory;
import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.SubPuMoCa;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.service.monthCategory.MonthCategoryService;

@Service
public class DefaultSubPuMoCaService implements SubPuMoCaService {

	private final SubPuMoCaRepository subPuMoCaRepository;
	private final MonthCategoryService monthCategoryService;

	public DefaultSubPuMoCaService(final SubPuMoCaRepository subPuMoCaRepository,
			final MonthCategoryService monthCategoryService) {
		this.subPuMoCaRepository = subPuMoCaRepository;
		this.monthCategoryService = monthCategoryService;
	}

	@Override
	public void createAllSubPuMoCas(Subject subject, Pupil pupil) throws ConstraintsViolationException {
		List<MonthCategory> moCaList = monthCategoryService.createAndSaveAllMonthCategories();
		SubPuMoCa subPuMoCa = new SubPuMoCa(subject, pupil);
		subPuMoCa.setMonthCategories(moCaList);
		this.createSubPuMoCa(subPuMoCa);
	}

	@Override
	public SubPuMoCa createSubPuMoCa(SubPuMoCa subPuMoCa) throws ConstraintsViolationException {
		try {
			return subPuMoCaRepository.save(subPuMoCa);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"SubPuMoCa createn wasn't successfull. Is some critical condition not fulfilled?");
		}
	}
}