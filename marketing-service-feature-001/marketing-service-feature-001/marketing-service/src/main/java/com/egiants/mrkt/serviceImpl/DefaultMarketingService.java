package com.egiants.mrkt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.mrkt.dao.MarketingDao;
import com.egiants.mrkt.entity.Marketing;
import com.egiants.mrkt.service.MarketingService;

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
        //TODO: throw custom error if there is no record
        return this.marketingDao.getCallDetail(callId);
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
        //TODO: may need to throw error based on
        this.marketingDao.deleteMarketing(callId);
    }
}
