/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.selection.generics;

public class ErroneousTarget3 {

    private TypeB fooWildCardExtendsMBTypeBFailure;

    public TypeB getFooWildCardExtendsMBTypeBFailure() {
        return fooWildCardExtendsMBTypeBFailure;
    }

    public void setFooWildCardExtendsMBTypeBFailure(TypeB fooWildCardExtendsMBTypeBFailure) {
        this.fooWildCardExtendsMBTypeBFailure = fooWildCardExtendsMBTypeBFailure;
    }

}
