package com.gradeMeApp.service.subject;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradeMeApp.dataaccessobject.SubjectRepository;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityAlreadySelectedException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.subPuMoCa.SubPuMoCaService;
import com.gradeMeApp.service.user.UserService;

@Service
public class DefaultSubjectService implements SubjectService {

	private final SubjectRepository subjectRepository;
	private final UserService userService;
	private final SubPuMoCaService subPuMoCaService;

	public DefaultSubjectService(final SubjectRepository subjectRepository, final UserService userService,
			final SubPuMoCaService subPuMoCaService) {
		this.subjectRepository = subjectRepository;
		this.userService = userService;
		this.subPuMoCaService = subPuMoCaService;
	}

	@Override
	public Subject createSubject(final long teacherId, Subject subject)
			throws ConstraintsViolationException, EntityNotFoundException {
		Teacher teacher = userService.getTeacher(teacherId);
		subject.setTeacher(teacher);
		try {
			return subjectRepository.save(subject);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"Module createn wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	public List<Subject> findSubjects(final long userId) throws EntityNotFoundException {
		User user = userService.getUser(userId);
		if (user instanceof Teacher) {
			return subjectRepository.findByTeacher((Teacher) user);
		} else {
			return subPuMoCaService.findAllSubjectsWithUser(user);
		}
	}

	@Override
	@Transactional
	public void addPupilToSubject(final long subjectId, final long pupilId)
			throws EntityNotFoundException, EntityAlreadySelectedException, ConstraintsViolationException {
		Pupil pupil = userService.getPupil(pupilId);// TODO
		Subject subject = this.getSubject(subjectId);
		if (subject.getPupils().contains(pupil)) {
			throw new EntityAlreadySelectedException("The given pupil is already selected to this module");
		}
		subject.addPupil(pupil);
		subPuMoCaService.createAllSubPuMoCas(subject, pupil);
	}

	@Override
	public Subject getSubject(final long subjectId) throws EntityNotFoundException {
		Subject module = subjectRepository.findById(subjectId).filter(mod -> Boolean.FALSE == mod.isDeleted())
				.orElseThrow(() -> new EntityNotFoundException("The module doesn't exist or is deleted"));
		return module;
	}

	@Override
	public Subject updateSubject(final long subjectId, final long teacherId, Subject subject)
			throws EntityNotFoundException, ConstraintsViolationException {
		Subject dbModule = this.getSubject(subjectId);
		subject.setQrcode(subjectId);
		subject.setTeacher(dbModule.getTeacher());
		try {
			return subjectRepository.save(subject);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"Module creation wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	@Transactional
	public void deleteSubject(final long subjectId, final long teacherId) throws EntityNotFoundException {
		Subject module = this.getSubject(subjectId);
		module.setDeleted(true);
	}

}
