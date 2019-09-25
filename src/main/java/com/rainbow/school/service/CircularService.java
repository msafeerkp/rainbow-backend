package com.rainbow.school.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.rainbow.school.model.CircularModel;

@Service
public class CircularService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public boolean addCircular(CircularModel circularModel) {
		MongoOperations mongoOperations = new MongoTemplate(new MongoClient(), "school");
		mongoOperations.insert(circularModel);
		return true;
	}

	public List<String> getDifferentCircularDateList() {
		MongoOperations mongoOperations = new MongoTemplate(new MongoClient(), "school");
		List<String> distinctDateList = mongoOperations.getCollection("circular").distinct("createdDate", String.class).into(new ArrayList<String>());
		return distinctDateList;
	}
	
	public List<CircularModel> getCircularListByDate(String date) {
		MongoOperations mongoOperations = new MongoTemplate(new MongoClient(), "school");
		List<CircularModel> circModels = mongoOperations.find(query(where("createdDate").is(date)), CircularModel.class);
		return circModels;
	}
	
}
