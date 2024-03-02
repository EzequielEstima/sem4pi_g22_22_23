/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.usermanagement.domain;

import javax.persistence.Embeddable;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class MecanographicNumber implements ValueObject, Comparable<MecanographicNumber> {

    private static final long serialVersionUID = 1L;

    private String mecanographicNumber;

    public MecanographicNumber(final String mecanographicNumber) {
        if (StringPredicates.isNullOrEmpty(mecanographicNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }
        if (mecanographicNumber.length() != 9){
            throw new IllegalArgumentException(
                    "Mecanographic Number should have 9 digits");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.mecanographicNumber = mecanographicNumber;
    }
    public MecanographicNumber(final int number,final String year) {
        String mecanographicNumber = year + String.format("%05d", number);
        if (StringPredicates.isNullOrEmpty(mecanographicNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }
        if (mecanographicNumber.length() != 9){
            throw new IllegalArgumentException(
                    "Mecanographic Number should have 9 digits");
        }

        // expression
        this.mecanographicNumber = mecanographicNumber;
    }
    protected MecanographicNumber() {
        // for ORM
    }

    public boolean compareYear(String year){
        return mecanographicNumber.substring(0, 4).equals(year);
    }

    public static MecanographicNumber valueOf(final String mecanographicNumber) {
        return new MecanographicNumber(mecanographicNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MecanographicNumber)) {
            return false;
        }

        final MecanographicNumber that = (MecanographicNumber) o;
        return this.mecanographicNumber.equals(that.mecanographicNumber);
    }

    @Override
    public int hashCode() {
        return this.mecanographicNumber.hashCode();
    }

    @Override
    public String toString() {
        return this.mecanographicNumber;
    }

    @Override
    public int compareTo(final MecanographicNumber arg0) {
        return mecanographicNumber.compareTo(arg0.mecanographicNumber);
    }
}
