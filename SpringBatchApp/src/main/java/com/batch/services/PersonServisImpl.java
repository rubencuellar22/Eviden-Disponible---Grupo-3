package com.batch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.entities.Person;
import com.batch.persistence.IPersonDao;
@Service
public class PersonServisImpl implements IPersonService {

	@Autowired
	private IPersonDao personaDao;
	
	
	@Override
	@Transactional
	public void saveAll(List<Person> personList) {
	personaDao.saveAll(personList);
		
	}


	@Override
	public List<Person> getAll() {
		return (List<Person>) personaDao.findAll();
	}

}
