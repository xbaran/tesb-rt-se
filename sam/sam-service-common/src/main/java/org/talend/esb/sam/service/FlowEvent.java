package org.talend.esb.sam.service;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;

import org.talend.esb.sam.common.event.EventTypeEnum;

@XmlRootElement
public class FlowEvent {
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String hostname) {
        this.host = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFlowID() {
        return flowID;
    }

    public void setFlowID(String flowID) {
        this.flowID = flowID;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public boolean isContentCut() {
        return isContentCut;
    }

    public void setContentCut(boolean isContentCut) {
        this.isContentCut = isContentCut;
    }

    public URL getDetails() {
        return details;
    }

    public void setDetails(URL details) {
        this.details = details;
    }
    
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    private long id;
    
    private long timestamp;
    
    private EventTypeEnum eventType;
    
    private String customId;
    
    private String process;
    
    private String host;

    private String ip;

    private String principal;
    
    private String port;
    
    private String operation;
    
    private String flowID;
    
    private String transport;
    
    private boolean isContentCut;
    
    private String customKey;
    
    private String customValue;
    
    public String getCustomKey() {
        return customKey;
    }

    public void setCustomKey(String customKey) {
        this.customKey = customKey;
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }

    private String messageID;
    
    private URL details;
}
