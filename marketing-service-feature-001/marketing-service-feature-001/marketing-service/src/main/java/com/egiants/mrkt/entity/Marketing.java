package com.egiants.mrkt.entity;
import javax.validation.Valid;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName="MarketingSheet")
public class Marketing {
	private String callId;
	private String vendorName;
	private Integer vendorPhoneNo;
	private String clientName;
	private Integer clientPhoneNo;
	private String date;
	@Valid
	private MarketingStatus status;
	
	@DynamoDBHashKey(attributeName="callId")
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	@DynamoDBAttribute(attributeName="vendorName")
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@DynamoDBAttribute(attributeName="vendorPhoneNo")
	public Integer getVendorPhoneNo() {
		return vendorPhoneNo;
	}
	public void setVendorPhoneNo(Integer vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
	}
	@DynamoDBAttribute(attributeName="clientName")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@DynamoDBAttribute(attributeName="clientPhoneNo")
	public Integer getClientPhoneNo() {
		return clientPhoneNo;
	}
	public void setClientPhoneNo(Integer clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
	}
	@DynamoDBAttribute(attributeName="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@DynamoDBTypeConvertedJson
	@DynamoDBAttribute(attributeName="status")
	public MarketingStatus getStatus() {
		return status;
	}
	public void setStatus(MarketingStatus status) {
		this.status = status;
	}
	
	
	
	
}
