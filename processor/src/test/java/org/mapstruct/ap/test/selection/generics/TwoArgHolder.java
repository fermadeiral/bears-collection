/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.selection.generics;

/**
 * @author sjaak
 */
public class TwoArgHolder<T1, T2> {

    private T1 arg1;
    private T2 arg2;

    public TwoArgHolder(T1 arg1, T2 arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public T1 getArg1() {
        return arg1;
    }

    public void setArg1(T1 arg1) {
        this.arg1 = arg1;
    }

    public T2 getArg2() {
        return arg2;
    }

    public void setArg2(T2 arg2) {
        this.arg2 = arg2;
    }
}
