package com.egiants.mrkt.controller;


import com.egiants.mrkt.Exceptions.MismatchIdentifierException;
import com.egiants.mrkt.Exceptions.ResourceNotFoundException;
import com.egiants.mrkt.entity.Marketing;
import com.egiants.mrkt.service.MarketingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarketingControllerTest {

    private static final String callId = "7";
    private static final String mismatchCallId = "11";
    private static final String clientName = "ancestry";

    private Marketing marketing;
    private List<Marketing> marketings;

    @Mock
    private MarketingService marketingService;

    @InjectMocks
    private MarketingController marketingController;

    @Before
    public void setUp() throws Exception {

        this.marketing = Mockito.mock(Marketing.class);
        this.marketings = Arrays.asList(marketing);

        Mockito.doReturn(clientName)
                .when(marketing)
                .getClientName();
        Mockito.doReturn(callId)
                .when(this.marketing)
                .getCallId();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCalls() {
        Mockito.doReturn(this.marketings)
                .when(this.marketingService)
                .getCalls();

        ResponseEntity<List<Marketing>> responseEntity = this.marketingController.getCalls();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clientName, responseEntity.getBody().get(0).getClientName());
    }

    @Test
    public void testGetCallDetail() {
        Mockito.doReturn(marketing)
                .when(this.marketingService)
                .getCallDetail(callId);

        ResponseEntity<Marketing> responseEntity = this.marketingController.getCallDetail(callId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clientName, responseEntity.getBody().getClientName());
    }

    @Test
    public void testCreateMarketing() {
        Mockito.doReturn(this.marketing)
                .when(this.marketingService)
                .createMarketing(this.marketing);

        ResponseEntity<Marketing> responseEntity =
                this.marketingController.createMarketing( callId, marketing);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(clientName, responseEntity.getBody().getClientName());
    }

    
    
   @Test(expected = MismatchIdentifierException.class)
    public void testCreateMarketingException() {
        Mockito.doReturn(mismatchCallId)
                .when(this.marketing)
                .getCallId();

        this.marketingController.createMarketing(callId, marketing);
    }

    @Test
    public void testUpdateMarketing() {
        Mockito.doReturn(this.marketing)
                .when(this.marketingService)
                .updateMarketing(this.marketing);

        ResponseEntity<Marketing> responseEntity =
                this.marketingController.updateMarketing(callId, marketing);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clientName, responseEntity.getBody().getClientName());
    }

    
    @Test(expected = MismatchIdentifierException.class)
    public void testUpdateMarketingException() {
        Mockito.doReturn(mismatchCallId)
                .when(this.marketing)
                .getCallId();

        this.marketingController.updateMarketing(callId, marketing);
    }

    @Test
    public void testDeleteMarketing() {
        Mockito.doNothing()
                .when(this.marketingService)
                .deleteMarketing(callId);

        ResponseEntity<Void> responseEntity =
                this.marketingController.deleteMarketing(callId, marketing);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
    @Test(expected = MismatchIdentifierException.class)
    public void testdeleteMarketingException() {
        Mockito.doReturn(mismatchCallId)
                .when(this.marketing)
                .getCallId();

        this.marketingController.deleteMarketing(callId, marketing);
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void testdeleteException() {
   Mockito .doThrow(ResourceNotFoundException.class)
   .when(this.marketingService)
   .getCallDetail(mismatchCallId);
   marketingService.getCallDetail(mismatchCallId);
   this.marketingController.deleteMarketing(callId, marketing);
     }
}

