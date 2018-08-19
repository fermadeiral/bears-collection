#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>


#import "SWGTagManagedObject.h"
#import "SWGTag.h"

/**
* Swagger Petstore
* This is a sample server Petstore server.  You can find out more about Swagger at <a href=\"http://swagger.io\">http://swagger.io</a> or on irc.freenode.net, #swagger.  For this sample, you can use the api key \"special-key\" to test the authorization filters
*
* OpenAPI spec version: 1.0.0
* Contact: apiteam@wordnik.com
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/


@interface SWGTagManagedObjectBuilder : NSObject



-(SWGTagManagedObject*)createNewSWGTagManagedObjectInContext:(NSManagedObjectContext*)context;

-(SWGTagManagedObject*)SWGTagManagedObjectFromSWGTag:(SWGTag*)object context:(NSManagedObjectContext*)context;

-(void)updateSWGTagManagedObject:(SWGTagManagedObject*)object withSWGTag:(SWGTag*)object2;

-(SWGTag*)SWGTagFromSWGTagManagedObject:(SWGTagManagedObject*)obj;

-(void)updateSWGTag:(SWGTag*)object withSWGTagManagedObject:(SWGTagManagedObject*)object2;

@end
