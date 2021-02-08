package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.InventoryApiService;
import io.swagger.api.factories.InventoryApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.InventoryItem;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/inventory")


@io.swagger.annotations.Api(description = "the inventory API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2021-02-08T14:47:20.011Z")
public class InventoryApi  {
   private final InventoryApiService delegate;

   public InventoryApi(@Context ServletConfig servletContext) {
      InventoryApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("InventoryApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (InventoryApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = InventoryApiServiceFactory.getInventoryApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds an inventory item", notes = "Adds an item to the system", response = Void.class, tags={ "admins", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = Void.class) })
    public Response addInventory(@ApiParam(value = "Inventory item to add" ) InventoryItem inventoryItem
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addInventory(inventoryItem,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches inventory", notes = "By passing in the appropriate options, you can search for available inventory in the system ", response = InventoryItem.class, responseContainer = "List", tags={ "developers", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = InventoryItem.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response searchInventory(@ApiParam(value = "pass an optional search string for looking up inventory") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchInventory(searchString,skip,limit,securityContext);
    }
}
