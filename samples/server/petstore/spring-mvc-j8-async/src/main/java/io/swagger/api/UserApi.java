/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Api(value = "user", description = "the user API")
public interface UserApi {

    Logger log = LoggerFactory.getLogger(UserApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Create user", nickname = "createUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    default CompletableFuture<ResponseEntity<Void>> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Creates list of users with given input array", nickname = "createUsersWithArrayInput", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user/createWithArray",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    default CompletableFuture<ResponseEntity<Void>> createUsersWithArrayInput(@ApiParam(value = "List of user object" ,required=true )  @Valid @RequestBody List<User> body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Creates list of users with given input array", nickname = "createUsersWithListInput", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user/createWithList",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    default CompletableFuture<ResponseEntity<Void>> createUsersWithListInput(@ApiParam(value = "List of user object" ,required=true )  @Valid @RequestBody List<User> body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Delete user", nickname = "deleteUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{username}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    default CompletableFuture<ResponseEntity<Void>> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("username") String username) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Get user by user name", nickname = "getUserByName", notes = "", response = User.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{username}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default CompletableFuture<ResponseEntity<User>> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true) @PathVariable("username") String username) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/xml")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("<User>  <id>123456789</id>  <username>aeiou</username>  <firstName>aeiou</firstName>  <lastName>aeiou</lastName>  <email>aeiou</email>  <password>aeiou</password>  <phone>aeiou</phone>  <userStatus>123</userStatus></User>", User.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"password\" : \"password\",  \"userStatus\" : 6,  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\"}", User.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Logs user into the system", nickname = "loginUser", notes = "", response = String.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(value = "/user/login",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default CompletableFuture<ResponseEntity<String>> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/xml")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("aeiou", String.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return CompletableFuture.completedFuture(new ResponseEntity<>(getObjectMapper().get().readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED));
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/user/logout",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    default CompletableFuture<ResponseEntity<Void>> logoutUser() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }


    @ApiOperation(value = "Updated user", nickname = "updateUser", notes = "This can only be done by the logged in user.", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid user supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/user/{username}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
    default CompletableFuture<ResponseEntity<Void>> updateUser(@ApiParam(value = "name that need to be deleted",required=true) @PathVariable("username") String username,@ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UserApi interface so no example is generated");
        }
        return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
    }

}
