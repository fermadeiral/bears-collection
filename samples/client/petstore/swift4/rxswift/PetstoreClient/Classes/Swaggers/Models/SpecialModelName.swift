//
// SpecialModelName.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation



open class SpecialModelName: Codable {

    public var specialPropertyName: Int64?


    
    public init(specialPropertyName: Int64?) {
        self.specialPropertyName = specialPropertyName
    }
    

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {

        var container = encoder.container(keyedBy: String.self)

        try container.encodeIfPresent(specialPropertyName, forKey: "$special[property.name]")
    }

    // Decodable protocol methods

    public required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: String.self)

        specialPropertyName = try container.decodeIfPresent(Int64.self, forKey: "$special[property.name]")
    }
}

