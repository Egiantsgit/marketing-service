package com.egiants.mrkt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.mrkt.dao.MarketingDao;
import com.egiants.mrkt.dao.config.DynamoDbConfig;
import com.egiants.mrkt.dao.springdata.MarketingRepo;
import com.egiants.mrkt.entity.Marketing;
@Repository
public class SpringDataMarketingDao implements MarketingDao {
	@Autowired
	DynamoDbConfig dynamoDbConfig;
	@Autowired
	private MarketingRepo marketingRepo;

	@Override
	public List<Marketing> getCalls() {
		Iterable<Marketing> marketings = this.marketingRepo.findAll();

        return (List<Marketing>) marketings;
	}

	@Override
	public Marketing getCallDetail(String callId) {
		// TODO Auto-generated method stub
		return this.marketingRepo.findOne(callId);
	}

	@Override
	public Marketing createMarketing(Marketing marketing) {
		 return this.marketingRepo.save(marketing);
	}

	@Override
	public Marketing updateMarketing(Marketing marketing) {
		// TODO Auto-generated method stub
		return this.marketingRepo.save(marketing);//customUpdate(user);
	}

	@Override
	public void deleteMarketing(String callId) {
		this.marketingRepo.delete(callId);
		
	}

}
