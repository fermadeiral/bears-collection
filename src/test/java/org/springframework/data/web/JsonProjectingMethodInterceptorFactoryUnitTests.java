/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.web;

import static org.assertj.core.api.Assertions.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

/**
 * Unit tests for {@link JsonProjectingMethodInterceptorFactory}.
 *
 * @author Oliver Gierke
 * @since 1.13
 * @soundtrack Richard Spaven - Assemble (Whole Other*)
 */
public class JsonProjectingMethodInterceptorFactoryUnitTests {

	ProjectionFactory projectionFactory;
	Customer customer;

	@Before
	public void setUp() {

		String json = "{\"firstname\" : \"Dave\", "//
				+ "\"address\" : { \"zipCode\" : \"01097\", \"city\" : \"Dresden\" }," //
				+ "\"addresses\" : [ { \"zipCode\" : \"01097\", \"city\" : \"Dresden\" }]" + " }";

		SpelAwareProxyProjectionFactory projectionFactory = new SpelAwareProxyProjectionFactory();

		MappingProvider mappingProvider = new JacksonMappingProvider(new ObjectMapper());
		projectionFactory.registerMethodInvokerFactory(new JsonProjectingMethodInterceptorFactory(mappingProvider));

		this.projectionFactory = projectionFactory;
		this.customer = projectionFactory.createProjection(Customer.class, new ByteArrayInputStream(json.getBytes()));
	}

	@Test // DATCMNS-885
	public void accessSimpleProperty() {
		assertThat(customer.getFirstname()).isEqualTo("Dave");
	}

	@Test // DATCMNS-885
	public void accessPropertyWithExplicitAnnotation() {
		assertThat(customer.getBar()).isEqualTo("Dave");
	}

	@Test // DATCMNS-885
	public void accessPropertyWithComplexReturnType() {
		assertThat(customer.getAddress()).isEqualTo(new Address("01097", "Dresden"));
	}

	@Test // DATCMNS-885
	public void accessComplexPropertyWithProjection() {
		assertThat(customer.getAddressProjection().getCity()).isEqualTo("Dresden");
	}

	@Test // DATCMNS-885
	public void accessPropertyWithNestedJsonPath() {
		assertThat(customer.getNestedZipCode()).isEqualTo("01097");
	}

	@Test // DATCMNS-885
	public void accessCollectionProperty() {
		assertThat(customer.getAddresses().get(0)).isEqualTo(new Address("01097", "Dresden"));
	}

	@Test // DATCMNS-885
	public void accessPropertyOnNestedProjection() {
		assertThat(customer.getAddressProjections().get(0).getZipCode()).isEqualTo("01097");
	}

	@Test // DATCMNS-885
	public void accessPropertyThatUsesJsonPathProjectionInTurn() {
		assertThat(customer.getAnotherAddressProjection().getZipCodeButNotCity()).isEqualTo("01097");
	}

	@Test // DATCMNS-885
	public void accessCollectionPropertyThatUsesJsonPathProjectionInTurn() {

		List<AnotherAddressProjection> projections = customer.getAnotherAddressProjections();

		assertThat(projections).hasSize(1);
		assertThat(projections.get(0).getZipCodeButNotCity()).isEqualTo("01097");
	}

	@Test // DATCMNS-885
	public void accessAsCollectionPropertyThatUsesJsonPathProjectionInTurn() {

		Set<AnotherAddressProjection> projections = customer.getAnotherAddressProjectionAsCollection();

		assertThat(projections).hasSize(1);
		assertThat(projections.iterator().next().getZipCodeButNotCity()).isEqualTo("01097");
	}

	@Test // DATCMNS-885
	public void accessNestedPropertyButStayOnRootLevel() {

		Name name = customer.getName();

		assertThat(name).isNotNull();
		assertThat(name.getFirstname()).isEqualTo("Dave");
	}

	@Test // DATACMNS-885
	public void accessNestedFields() {

		assertThat(customer.getNestedCity()).isEqualTo("Dresden");
		assertThat(customer.getNestedCities()).hasSize(2);
	}

	@Test // DATACMNS-1144
	public void returnsNullForNonExistantValue() {
		assertThat(customer.getName().getLastname()).isNull();
	}

	@Test // DATACMNS-1144
	public void triesMultipleDeclaredPathsIfNotAvailable() {
		assertThat(customer.getName().getSomeName()).isEqualTo(customer.getName().getFirstname());
	}

	interface Customer {

		String getFirstname();

		@JsonPath("$")
		Name getName();

		Address getAddress();

		List<Address> getAddresses();

		@JsonPath("$.addresses")
		List<AddressProjection> getAddressProjections();

		@JsonPath("$.firstname")
		String getBar();

		@JsonPath("$.address")
		AddressProjection getAddressProjection();

		@JsonPath("$.address.zipCode")
		String getNestedZipCode();

		@JsonPath("$.address")
		AnotherAddressProjection getAnotherAddressProjection();

		@JsonPath("$.addresses")
		List<AnotherAddressProjection> getAnotherAddressProjections();

		@JsonPath("$.address")
		Set<AnotherAddressProjection> getAnotherAddressProjectionAsCollection();

		@JsonPath("$..city")
		String getNestedCity();

		@JsonPath("$..city")
		List<String> getNestedCities();
	}

	interface AddressProjection {

		String getZipCode();

		String getCity();
	}

	interface Name {

		@JsonPath("$.firstname")
		String getFirstname();

		// Not available in the payload
		@JsonPath("$.lastname")
		String getLastname();

		// First one not available in the payload
		@JsonPath({ "$.lastname", "$.firstname" })
		String getSomeName();
	}

	interface AnotherAddressProjection {

		@JsonPath("$.zipCode")
		String getZipCodeButNotCity();
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class Address {
		private String zipCode, city;
	}
}
