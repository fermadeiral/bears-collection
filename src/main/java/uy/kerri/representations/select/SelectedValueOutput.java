/*
 * MIT License
 *
 * Copyright (c) 2018 Pablo Da Costa Porto
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package uy.kerri.representations.select;

import uy.kerri.representations.Fields;
import uy.kerri.representations.FixedOutput;
import uy.kerri.representations.Output;
import uy.kerri.representations.RepresentationsException;
import uy.kerri.representations.Values;

/**
 * An {@link uy.kerri.representations.Output} that shows the last value that is
 *  printed on it.
 *
 * @since 2.0
 */
final class SelectedValueOutput implements Output {
    /**
     * The output with the selected value.
     */
    private final Output selected;

    /**
     * Constructs an output that shows the last value that is printed on it or
     *   shows some other output if no values were printed.
     *
     * @param selected The output to show.
     */
    private SelectedValueOutput(final Output selected) {
        this.selected = selected;
    }

    /**
     * Constructs an output that shows the last value that is printed on it or
     *  throws some exception if no values were printed.
     *
     * @param exception The exception to throw.
     */
    SelectedValueOutput(final RepresentationsException exception) {
        this(new InvalidOutput(exception));
    }

    /**
     * Constructs an output that shows the last value that is printed on it or
     *  throws an exception if no values were printed.
     */
    SelectedValueOutput() {
        this(new ValueNotSelectedException("The value wasn't selected yet."));
    }

    @Override
    public String show() throws RepresentationsException {
        return this.selected.show();
    }

    @Override
    public Output print(final String key, final String value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Integer value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Boolean value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Double value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Long value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Fields value) {
        return this.select(value);
    }

    @Override
    public Output print(final String key, final Values values) {
        return this.select(values);
    }

    /**
     * Selects the value.
     *
     * @param value The value to be selected.
     * @return An output that shows the selected value.
     */
    private static Output select(final Object value) {
        return new SelectedValueOutput(new FixedOutput(value));
    }
}
