
package com.egiants.mrkt.service;

import com.egiants.mrkt.Exceptions.MismatchIdentifierException;
import com.egiants.mrkt.Exceptions.ResourceNotFoundException;
import com.egiants.mrkt.dao.MarketingDao;
import com.egiants.mrkt.entity.Marketing;
import com.egiants.mrkt.serviceImpl.DefaultMarketingService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class MarketingServiceImplTest {


    private static final String callId = "7";
    private static final String clientName = "ancestry";
    private static final String mismatchCallId=null;

    private Marketing marketing;
    private List<Marketing> marketings;

    @Mock
    private MarketingDao marketingDao;

    @InjectMocks
    private DefaultMarketingService marketingService;

    @Before
    public void setUp() throws Exception {

        this.marketing = Mockito.mock(Marketing.class);
        this.marketings = Arrays.asList(marketing);

        Mockito.doReturn(clientName)
                .when(marketing)
                .getClientName();

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetCalls() {
        Mockito.doReturn(this.marketings)
                .when(this.marketingDao)
                .getCalls();

        List<Marketing> Marketings = this.marketingService.getCalls();
        assertEquals(clientName, Marketings.get(0).getClientName());
    }

    @Test
    public void testGetCallDetail() {
        Mockito.doReturn(marketing)
                .when(this.marketingDao)
                .getCallDetail(callId);

        Marketing actualMarketing = this.marketingService.getCallDetail(callId);
        assertEquals(clientName, actualMarketing.getClientName());
    }
   
    @Test(expected = ResourceNotFoundException.class)
       public void testGetCallDetailException() {
      Mockito .doThrow(ResourceNotFoundException.class)
      .when(this.marketingDao)
      .getCallDetail(mismatchCallId);
      marketingService.getCallDetail(mismatchCallId);
  }

    @Test
    public void testCreateMarketing() {
        Mockito.doReturn(this.marketing)
                .when(this.marketingDao)
                .createMarketing(this.marketing);

        Marketing actualMarketing = this.marketingService.createMarketing(marketing);
        assertEquals(clientName, actualMarketing.getClientName());
    }

    @Test
    public void testCreateOrUpdateMarketing() {
        Mockito.doReturn(this.marketing)
                .when(this.marketingDao)
                .updateMarketing(this.marketing);

        Marketing actualMarketing = this.marketingService.updateMarketing(marketing);
        assertEquals(clientName, actualMarketing.getClientName());
    }

    @Test
    public void testDeleteMarketing() {
        Mockito.doNothing()
                .when(this.marketingDao)
                .deleteMarketing(callId);

        this.marketingService.deleteMarketing(callId);
        verify(marketingDao).deleteMarketing(callId);
    }
   
    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteMarketingException() {
   Mockito .doThrow(ResourceNotFoundException.class)
   .when(this.marketingDao)
   .deleteMarketing(mismatchCallId);
   
   this.marketingService.deleteMarketing(mismatchCallId);
   }
}
