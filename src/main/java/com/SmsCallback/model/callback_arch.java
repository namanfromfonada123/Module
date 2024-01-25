package com.SmsCallback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "callback_arch" , uniqueConstraints = @UniqueConstraint(columnNames = "txid"))
public class callback_arch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long corelationid;
	private long txid;
	private String tok;
	private String fromk;
	private String description;
	private int pdu;
	private String text;
	private boolean deliverystatus;
	private String deliverydt;
	private String response;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCorelationid() {
		return corelationid;
	}
	public void setCorelationid(long corelationid) {
		this.corelationid = corelationid;
	}
	public long getTxid() {
		return txid;
	}
	public void setTxid(long txid) {
		this.txid = txid;
	}
	public String getTok() {
		return tok;
	}
	public void setTok(String tok) {
		this.tok = tok;
	}
	public String getFromk() {
		return fromk;
	}
	public void setFromk(String fromk) {
		this.fromk = fromk;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPdu() {
		return pdu;
	}
	public void setPdu(int pdu) {
		this.pdu = pdu;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isDeliverystatus() {
		return deliverystatus;
	}
	public void setDeliverystatus(boolean deliverystatus) {
		this.deliverystatus = deliverystatus;
	}
	public String getDeliverydt() {
		return deliverydt;
	}
	public void setDeliverydt(String deliverydt) {
		this.deliverydt = deliverydt;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "callback_arch [id=" + id + ", corelationid=" + corelationid + ", txid=" + txid + ", tok=" + tok
				+ ", fromk=" + fromk + ", description=" + description + ", pdu=" + pdu + ", text=" + text
				+ ", deliverystatus=" + deliverystatus + ", deliverydt=" + deliverydt + ", response=" + response + "]";
	}
	
	
}
