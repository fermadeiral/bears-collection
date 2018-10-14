/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.template.erroneous;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ap.test.template.Source;
import org.mapstruct.ap.test.template.Target;
import org.mapstruct.factory.Mappers;

/**
 * @author Sjaak Derksen
 */
@Mapper
public interface SourceTargetMapperNonMatchingName {

    SourceTargetMapperNonMatchingName INSTANCE = Mappers.getMapper( SourceTargetMapperNonMatchingName.class );

   @Mappings({
        @Mapping(target = "stringPropY", source = "stringPropX" ),
        @Mapping(target = "integerPropY", source = "integerPropX" ),
        @Mapping(target = "nestedResultProp", source = "nestedSourceProp.nested"),
        @Mapping(target = "constantProp", constant = "constant"),
        @Mapping(target = "expressionProp", expression = "java(\"expression\")")
    })
    Target forwardCreate(Source source);

    @InheritConfiguration( name = "blah" )
    void forwardUpdate(Source source, @MappingTarget Target target);
}
