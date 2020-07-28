package com.pohmelo.rndm.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.api.ItemlistApi;
import io.swagger.model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ItemListController {

    Logger logger = LoggerFactory.getLogger(ItemlistApi.class);

    @ApiOperation(value = "Add item list", nickname = "addItemList", notes = "", tags={ "itemlist", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request") })
    @RequestMapping(value = "/itemlist",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Void> addItemList(@ApiParam(value = "List with items" ,required=true )  @Valid @RequestBody ItemList body) {
        logger.info("addItemList called");
        if(getAcceptHeader().isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        } else {
            logger.warn("ObjectMapper or HttpServletRequest not configured in default ListApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    private Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    private Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }
}
