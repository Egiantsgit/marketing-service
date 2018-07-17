package com.egiants.mrkt.dao.springdata;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.mrkt.entity.Marketing;

@EnableScan
public interface MarketingRepo extends DynamoDBCrudRepository<Marketing, String> {





	
}
