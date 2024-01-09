package fish.payara.micro.sample.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("sample")
public class SampleRest {
    @GET
    @Path("/sample")
    @Produces(MediaType.TEXT_PLAIN)
    public String all() {
        return "Hello world";
    }
}
