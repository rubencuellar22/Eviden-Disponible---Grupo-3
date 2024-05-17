package com.batch.services;

import java.util.List;

import com.batch.entities.Person;

public interface IPersonService {

	
	 void saveAll(List<Person> personList);
	 List<Person> getAll();
}
