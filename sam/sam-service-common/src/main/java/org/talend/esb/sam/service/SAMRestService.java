package org.talend.esb.sam.service;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")
public interface SAMRestService {

    @GET
    @Path("event/{id}")
    @Produces({ "application/json" })
    Response getEvent(@PathParam("id") String id);

    @GET
    @Path("flow")
    @Produces({ "application/json" })
    Response getFlows(@QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("10") Integer limit, @MatrixParam("params") @DefaultValue("") List<String> params);
    
    @GET
    @Path("flow/{id}")
    @Produces({ "application/json" })
    Response getFlow(@PathParam("id") String id);
}
