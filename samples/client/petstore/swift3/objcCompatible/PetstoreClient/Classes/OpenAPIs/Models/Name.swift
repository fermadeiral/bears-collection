//
// Name.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


/** Model for testing model name same as property name */
open class Name: JSONEncodable {

    public var name: Int32?
    public var nameNum: NSNumber? {
        get {
            return name.map({ return NSNumber(value: $0) })
        }
    }
    public var snakeCase: Int32?
    public var snakeCaseNum: NSNumber? {
        get {
            return snakeCase.map({ return NSNumber(value: $0) })
        }
    }
    public var property: String?
    public var _123number: Int32?
    public var _123numberNum: NSNumber? {
        get {
            return _123number.map({ return NSNumber(value: $0) })
        }
    }

    public init() {}

    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["name"] = self.name?.encodeToJSON()
        nillableDictionary["snake_case"] = self.snakeCase?.encodeToJSON()
        nillableDictionary["property"] = self.property
        nillableDictionary["123Number"] = self._123number?.encodeToJSON()

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}

