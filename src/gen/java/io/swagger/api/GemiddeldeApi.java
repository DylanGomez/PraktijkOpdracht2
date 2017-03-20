package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.GemiddeldeApiService;
import io.swagger.api.factories.GemiddeldeApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Invoerwaardes;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/gemiddelde")


@io.swagger.annotations.Api(description = "the gemiddelde API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-16T10:05:48.620Z")
public class GemiddeldeApi  {
   private final GemiddeldeApiService delegate = GemiddeldeApiServiceFactory.getGemiddeldeApi();

    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "gemiddelde eerst, dan van elk cijfer afstand to gemiddelde, dan pak je van die afstanden en doe je die keer elkaar. ", response = Integer.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Integer.class) })
    public Response gemiddeldePost(@ApiParam(value = "Array input" ,required=true) Invoerwaardes gemiddelde
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.gemiddeldePost(gemiddelde,securityContext);
    }
}
