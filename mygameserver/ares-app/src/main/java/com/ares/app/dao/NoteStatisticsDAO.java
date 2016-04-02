package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.NoteStatisticsDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;

@Repository
@CollectionName("statistics")
public class NoteStatisticsDAO extends MongoDBDAO<NoteStatisticsDO>{

	public NoteStatisticsDAO() {
		super(NoteStatisticsDO.class);
		// TODO Auto-generated constructor stub
	}

}
