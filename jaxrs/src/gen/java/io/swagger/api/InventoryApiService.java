package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.InventoryItem;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2021-02-08T14:47:20.011Z")
public abstract class InventoryApiService {
    public abstract Response addInventory(InventoryItem inventoryItem,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchInventory( String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
}
