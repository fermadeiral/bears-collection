//
// OuterComposite.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


open class OuterComposite: JSONEncodable {

    public var myNumber: OuterNumber?
    public var myString: OuterString?
    public var myBoolean: OuterBoolean?


    public init(myNumber: OuterNumber?=nil, myString: OuterString?=nil, myBoolean: OuterBoolean?=nil) {
        self.myNumber = myNumber
        self.myString = myString
        self.myBoolean = myBoolean
    }
    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["my_number"] = self.myNumber?.encodeToJSON()
        nillableDictionary["my_string"] = self.myString?.encodeToJSON()
        nillableDictionary["my_boolean"] = self.myBoolean?.encodeToJSON()

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}

