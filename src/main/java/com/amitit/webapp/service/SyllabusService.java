package com.amitit.webapp.service;

import com.amitit.webapp.entity.Syllabus;

public interface SyllabusService {
	Syllabus addSyllabus(Syllabus syllabus);

	Syllabus getSyllabus(Integer sId);

	void deleteSyllabus(Integer sId);
}
