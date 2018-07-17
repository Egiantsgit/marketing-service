package com.egiants.mrkt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.mrkt.Exceptions.MismatchIdentifierException;
import com.egiants.mrkt.entity.Marketing;

import com.egiants.mrkt.service.MarketingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/calls")
@Api(value = "Marketing", description = "Operations pertaining to marketings")
public class MarketingController {

    @Autowired
    private MarketingService marketingService;


    @ApiOperation(value = "List of Marketings")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Marketing>> getCalls() {
        return new ResponseEntity<>(this.marketingService
                .getCalls(), HttpStatus.OK);
    }


    @ApiOperation(value = "Get Marketing with callId")
    @RequestMapping(value = "/call/{callId}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Marketing> getCallDetail(
            @PathVariable("callId") String callId) {

        return new ResponseEntity<>(this.marketingService
                .getCallDetail(callId), HttpStatus.OK);
    }

    @ApiOperation(value = "Add Marketing")
    @RequestMapping(value = "/call", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Marketing> createMarketing(@Valid @RequestBody Marketing marketing) {

        return new ResponseEntity<>(this.marketingService.createMarketing(marketing), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Marketing")
    @RequestMapping(value = "/call/{callId}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Marketing> updateMarketing(
            @PathVariable("callId") String callId, @RequestBody Marketing marketing) {

        return new ResponseEntity<>(this.marketingService.updateMarketing(marketing), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/{callId:.+}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Void> deleteMarketing(@PathVariable("callId") String callId) {

        this.marketingService.deleteMarketing(callId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
