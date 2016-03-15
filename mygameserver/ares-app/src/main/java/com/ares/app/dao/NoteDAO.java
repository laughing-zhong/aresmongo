package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.NoteDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("notes")
public class NoteDAO extends MongoDBDAO<NoteDO> {

	public NoteDAO() {
		super(NoteDO.class);
		// TODO Auto-generated constructor stub
	}

}
