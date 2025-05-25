package com.amitit.webapp.service;

import com.amitit.webapp.entity.Syllabus;

public interface SyllabusService {
	void addSyllabus(Syllabus syllabus);

	Syllabus getSyllabus(Long sId);

	void deleteSyllabus(Long sId);
}
