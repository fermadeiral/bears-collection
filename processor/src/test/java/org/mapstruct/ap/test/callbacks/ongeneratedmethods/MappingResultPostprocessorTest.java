/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.callbacks.ongeneratedmethods;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

/**
 *
 * @author Sjaak Derksen
 */

@WithClasses({
    Company.class,
    CompanyDto.class,
    Employee.class,
    EmployeeDto.class,
    Address.class,
    AddressDto.class,
    CompanyMapper.class,
    CompanyMapperPostProcessing.class
})
@IssueKey("183")
@RunWith(AnnotationProcessorTestRunner.class)
public class MappingResultPostprocessorTest {

    @Test
    public void test() {

        // setup
        Address address = new Address();
        address.setAddressLine( "RoadToNowhere;5" );
        address.setTown( "SmallTown" );
        Employee employee = new Employee();
        employee.setAddress( address );
        Company company = new Company();
        company.setEmployees( Arrays.asList( new Employee[] { employee } ) );

        // test
        CompanyDto companyDto = CompanyMapper.INSTANCE.toCompanyDto( company );

        // verify
        assertThat( companyDto.getEmployees() ).isNotEmpty();
        assertThat( companyDto.getEmployees().size() ).isEqualTo( 1 );
        assertThat( companyDto.getEmployees().get( 0 ).getAddress() ).isNotNull();
        assertThat( companyDto.getEmployees().get( 0 ).getAddress().getHouseNumber() ).isEqualTo( 5 );
        assertThat( companyDto.getEmployees().get( 0 ).getAddress().getStreet() ).isEqualTo( "RoadToNowhere" );
        assertThat( companyDto.getEmployees().get( 0 ).getAddress().getTown() ).isEqualTo( "SmallTown" );
    }

}
