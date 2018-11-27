package org.bonitasoft.engine.page.impl;

import static java.lang.String.format;

import java.util.Date;

import org.assertj.core.api.AbstractAssert;


/**
 * {@link PageImpl} specific assertions - Generated by CustomAssertionGenerator.
 */
public class PageImplAssert extends AbstractAssert<PageImplAssert, PageImpl> {

  /**
   * Creates a new </code>{@link PageImplAssert}</code> to make assertions on actual PageImpl.
   * @param actual the PageImpl we want to make assertions on.
   */
  public PageImplAssert(PageImpl actual) {
    super(actual, PageImplAssert.class);
  }

  /**
   * An entry point for PageImplAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one's can write directly : <code>assertThat(myPageImpl)</code> and get specific assertion with code completion.
   * @param actual the PageImpl we want to make assertions on.
   * @return a new </code>{@link PageImplAssert}</code>
   */
  public static PageImplAssert assertThat(PageImpl actual) {
    return new PageImplAssert(actual);
  }

  /**
   * Verifies that the actual PageImpl's contentName is equal to the given one.
   * @param contentName the given contentName to compare the actual PageImpl's contentName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's contentName is not equal to the given one.
   */
  public PageImplAssert hasContentName(String contentName) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> contentName to be:\n  <%s>\n but was:\n  <%s>", actual, contentName, actual.getContentName());
    
    // check
    if (!actual.getContentName().equals(contentName)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's contentType is equal to the given one.
   * @param contentType the given contentType to compare the actual PageImpl's contentType to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's contentType is not equal to the given one.
   */
  public PageImplAssert hasContentType(String contentType) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> contentType to be:\n  <%s>\n but was:\n  <%s>", actual, contentType, actual.getContentType());
    
    // check
    if (!actual.getContentType().equals(contentType)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's description is equal to the given one.
   * @param description the given description to compare the actual PageImpl's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's description is not equal to the given one.
   */
  public PageImplAssert hasDescription(String description) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> description to be:\n  <%s>\n but was:\n  <%s>", actual, description, actual.getDescription());
    
    // check
    if (!actual.getDescription().equals(description)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's displayName is equal to the given one.
   * @param displayName the given displayName to compare the actual PageImpl's displayName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's displayName is not equal to the given one.
   */
  public PageImplAssert hasDisplayName(String displayName) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> displayName to be:\n  <%s>\n but was:\n  <%s>", actual, displayName, actual.getDisplayName());
    
    // check
    if (!actual.getDisplayName().equals(displayName)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's id is equal to the given one.
   * @param id the given id to compare the actual PageImpl's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's id is not equal to the given one.
   */
  public PageImplAssert hasId(long id) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> id to be:\n  <%s>\n but was:\n  <%s>", actual, id, actual.getId());
    
    // check
    if (actual.getId() != id) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's installationDate is equal to the given one.
   * @param installationDate the given installationDate to compare the actual PageImpl's installationDate to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's installationDate is not equal to the given one.
   */
  public PageImplAssert hasInstallationDate(Date installationDate) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> installationDate to be:\n  <%s>\n but was:\n  <%s>", actual, installationDate, actual.getInstallationDate());
    
    // check
    if (!actual.getInstallationDate().equals(installationDate)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's installedBy is equal to the given one.
   * @param installedBy the given installedBy to compare the actual PageImpl's installedBy to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's installedBy is not equal to the given one.
   */
  public PageImplAssert hasInstalledBy(long installedBy) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> installedBy to be:\n  <%s>\n but was:\n  <%s>", actual, installedBy, actual.getInstalledBy());
    
    // check
    if (actual.getInstalledBy() != installedBy) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's lastModificationDate is equal to the given one.
   * @param lastModificationDate the given lastModificationDate to compare the actual PageImpl's lastModificationDate to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's lastModificationDate is not equal to the given one.
   */
  public PageImplAssert hasLastModificationDate(Date lastModificationDate) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> lastModificationDate to be:\n  <%s>\n but was:\n  <%s>", actual, lastModificationDate, actual.getLastModificationDate());
    
    // check
    if (!actual.getLastModificationDate().equals(lastModificationDate)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's lastUpdatedBy is equal to the given one.
   * @param lastUpdatedBy the given lastUpdatedBy to compare the actual PageImpl's lastUpdatedBy to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's lastUpdatedBy is not equal to the given one.
   */
  public PageImplAssert hasLastUpdatedBy(long lastUpdatedBy) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> lastUpdatedBy to be:\n  <%s>\n but was:\n  <%s>", actual, lastUpdatedBy, actual.getLastUpdatedBy());
    
    // check
    if (actual.getLastUpdatedBy() != lastUpdatedBy) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's name is equal to the given one.
   * @param name the given name to compare the actual PageImpl's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's name is not equal to the given one.
   */
  public PageImplAssert hasName(String name) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> name to be:\n  <%s>\n but was:\n  <%s>", actual, name, actual.getName());
    
    // check
    if (!actual.getName().equals(name)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's pageId is equal to the given one.
   * @param pageId the given pageId to compare the actual PageImpl's pageId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's pageId is not equal to the given one.
   */
  public PageImplAssert hasPageId(long pageId) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> pageId to be:\n  <%s>\n but was:\n  <%s>", actual, pageId, actual.getPageId());
    
    // check
    if (actual.getPageId() != pageId) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl's processDefinitionId is equal to the given one.
   * @param processDefinitionId the given processDefinitionId to compare the actual PageImpl's processDefinitionId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl's processDefinitionId is not equal to the given one.
   */
  public PageImplAssert hasProcessDefinitionId(Long processDefinitionId) {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("\nExpected <%s> processDefinitionId to be:\n  <%s>\n but was:\n  <%s>", actual, processDefinitionId, actual.getProcessDefinitionId());
    
    // check
    if (!actual.getProcessDefinitionId().equals(processDefinitionId)) { throw new AssertionError(errorMessage); }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl is provided.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl is not provided.
   */
  public PageImplAssert isProvided() {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("Expected actual PageImpl to be provided but was not.", actual);
    
    // check
    if (!actual.isProvided()) throw new AssertionError(errorMessage);

    // return the current assertion for method chaining
    return this;
  }

   /**
   * Verifies that the actual PageImpl is hidden.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl is not hidden.
   */
  public PageImplAssert isHidden() {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("Expected actual PageImpl to be hidden but was not.", actual);

    // check
    if (!actual.isHidden()) throw new AssertionError(errorMessage);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual PageImpl is not provided.
   * @return this assertion object.
   * @throws AssertionError - if the actual PageImpl is provided.
   */
  public PageImplAssert isNotProvided() {
    // check that actual PageImpl we want to make assertions on is not null.
    isNotNull();

    // we overrides the default error message with a more explicit one
    String errorMessage = format("Expected actual PageImpl not to be provided but was.", actual);
    
    // check
    if (actual.isProvided()) throw new AssertionError(errorMessage);

    // return the current assertion for method chaining
    return this;
  }

}
