package com.egiants.mrkt.service;

import java.util.List;
import java.util.Optional;

import com.egiants.mrkt.entity.Marketing;


public interface MarketingService {
	

	    List<Marketing> getCalls();
       Marketing getCallDetail(String callId);

	    Marketing createMarketing(Marketing marketing);

	    Marketing updateMarketing(Marketing  marketing);

	    void deleteMarketing(String callId);

	}



