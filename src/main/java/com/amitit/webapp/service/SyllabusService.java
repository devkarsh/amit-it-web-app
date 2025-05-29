package com.amitit.webapp.service;

import com.amitit.webapp.entity.Syllabus;

public interface SyllabusService {
	void addSyllabus(Syllabus syllabus);

	Syllabus getSyllabus(int sId);

	void deleteSyllabus(int sId);
}
