package org.sopera.monitoring.server.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dozer.DozerBeanMapper;
import org.sopera.monitoring._2010._09.common.EventType;
import org.sopera.monitoring._2010._09.fault.FaultType;
import org.sopera.monitoring.event.Event;
import org.sopera.monitoring.exception.MonitoringException;
import org.sopera.monitoring.monitoringservice.v1.MonitoringService;
import org.sopera.monitoring.monitoringservice.v1.PutEventsFault;

public class MonitoringWebService implements MonitoringService {

	private static Logger logger = Logger
			.getLogger(MonitoringWebService.class.getName());

	private org.sopera.monitoring.service.MonitoringService monitoringService;
	private DozerBeanMapper mapper;

	public String putEvents(List<EventType> eventTypes) throws PutEventsFault {
		logger.info("Received Events");
		List<Event> events = new ArrayList<Event>();

		try {
			for (EventType eventType : eventTypes) {
			    Event event = mapper.map(eventType, Event.class);
			    events.add(event);
			}
		} catch (RuntimeException e) {
			throwFault("004", "Could not map web service data to event.", e);
		}

		try {
			monitoringService.putEvents(events);
		} catch (MonitoringException e) {
			e.logException(Level.SEVERE);
			throwFault(e.getCode(), e.getMessage(), e);
		} catch (Throwable t) {
			throwFault("000", "Unknown error", t);
		}

		return "success";
	}

	private static void throwFault(String code, String message, Throwable t)
			throws PutEventsFault {
		logger.severe("Throw Fault " + code + " " + message);

		FaultType faultType = new FaultType();
		faultType.setFaultCode(code);
		faultType.setFaultMessage(message);

		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		t.printStackTrace(printWriter);
		String exception = stringWriter.toString();

		faultType.setStackTrace(exception);

		logger.log(Level.SEVERE, "Exception", t);

		throw new PutEventsFault(message, faultType);
	}

	public void setMonitoringService(
			org.sopera.monitoring.service.MonitoringService monitoringService) {
		this.monitoringService = monitoringService;
	}

	public void setMapper(DozerBeanMapper mapper) {
		this.mapper = mapper;
	}

}