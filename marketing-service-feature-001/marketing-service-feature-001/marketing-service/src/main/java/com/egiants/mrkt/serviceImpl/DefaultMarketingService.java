package com.egiants.mrkt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.egiants.mrkt.dao.MarketingDao;
import com.egiants.mrkt.entity.Marketing;
import com.egiants.mrkt.service.MarketingService;
import com.egiants.mrkt.Exceptions.ResourceNotFoundException;

@Service
public class DefaultMarketingService implements MarketingService {

    @Autowired
    private MarketingDao marketingDao;

    @Override
    public List<Marketing> getCalls() {
        return this.marketingDao.getCalls();
    }

    @Override
    public Marketing getCallDetail(String callId) {
//        return this.marketingDao.getCallDetail(callId);
        Marketing marketing = this.marketingDao.getCallDetail(callId);
        if(marketing ==null) {
            throw new ResourceNotFoundException(callId);
        }
        return marketing;
    }

    @Override
    public Marketing createMarketing(Marketing marketing) {
        return this.marketingDao.createMarketing(marketing);
    }

    @Override
    public Marketing updateMarketing(Marketing marketing) {
        return this.marketingDao.updateMarketing(marketing);
    }

    @Override
    public void deleteMarketing(String callId) {
        
    	try {
            this.marketingDao.deleteMarketing(callId);
        } catch (Exception e) {
            throw new ResourceNotFoundException(callId);
        }
    }
}
