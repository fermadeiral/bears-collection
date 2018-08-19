//
// Animal.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation



open class Animal: Codable {

    public var className: String
    public var color: String?


    
    public init(className: String, color: String?) {
        self.className = className
        self.color = color
    }
    

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {

        var container = encoder.container(keyedBy: String.self)

        try container.encode(className, forKey: "className")
        try container.encodeIfPresent(color, forKey: "color")
    }

    // Decodable protocol methods

    public required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: String.self)

        className = try container.decode(String.self, forKey: "className")
        color = try container.decodeIfPresent(String.self, forKey: "color")
    }
}

