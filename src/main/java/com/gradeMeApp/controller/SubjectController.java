package com.gradeMeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gradeMeApp.controller.mapper.SubjectMapper;
import com.gradeMeApp.datatransferobject.SubjectDTO;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityAlreadySelectedException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.subject.SubjectService;

@RestController
@RequestMapping("v1/subjects")
public class SubjectController {

	private final SubjectService subjectService;

	@Autowired
	public SubjectController(final SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@PostMapping("/{teacherId}")
	@ResponseStatus(HttpStatus.CREATED)
	public SubjectDTO createSubject(@PathVariable final long teacherId, @Valid @RequestBody SubjectDTO subjectDTO)
			throws ConstraintsViolationException, EntityNotFoundException {
		Subject subject = SubjectMapper.mapToSubject(subjectDTO);
		return SubjectMapper.mapToSubjectDTO(subjectService.createSubject(teacherId, subject));
	}

	@PutMapping("/{subjectId}/pupil/{pupilId}")
	public void addPupilToSubject(@PathVariable final long subjectId, @PathVariable final long pupilId)
			throws EntityNotFoundException, EntityAlreadySelectedException, ConstraintsViolationException {
		subjectService.addPupilToSubject(subjectId, pupilId);
	}

	@GetMapping("/user/{userId}")
	public List<SubjectDTO> getSubjects(@PathVariable final long userId) throws EntityNotFoundException {
		List<Subject> modules = subjectService.findSubjects(userId);
		return SubjectMapper.maptToSubjectDTOList(modules);
	}

	@GetMapping("/{subjectId}")
	public SubjectDTO getSubject(@PathVariable final long subjectId) throws EntityNotFoundException {
		return SubjectMapper.mapToSubjectDTO(subjectService.getSubject(subjectId));
	}

	@PutMapping("/{subjectId}/teacher/{teacherId}")
	public SubjectDTO updateSubject(@PathVariable final long subjectId, @PathVariable final long teacherId,
			@RequestBody SubjectDTO moduleDTO) throws EntityNotFoundException, ConstraintsViolationException {
		Subject module = SubjectMapper.mapToSubject(moduleDTO);
		return SubjectMapper.mapToSubjectDTO(subjectService.updateSubject(subjectId, teacherId, module));
	}

	@DeleteMapping("/{subjectId}/teacher/{teacherId}")
	public void deleteSubject(@PathVariable final long subjectId, @PathVariable final long teacherId)
			throws EntityNotFoundException {
		subjectService.deleteSubject(subjectId, teacherId);
	}
}
