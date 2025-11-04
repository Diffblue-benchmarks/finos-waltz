package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.person.Person;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwnerDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyInstanceOwner.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstanceOwner.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(SurveyInstanceOwner)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceOwner.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(SurveyInstanceOwner)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyInstance()).thenReturn(new ImmutableSurveyInstance.Json());
    when(instance.person()).thenReturn(mock(Person.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#from(SurveyInstanceOwner)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceOwner.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceOwner.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceOwner.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#person(Person)}
   */
  @Test
  void testBuilderPerson() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance2() {
    // Arrange
    ImmutableSurveyInstanceOwner.Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    surveyInstance.setSurveyEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(surveyInstance));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner#copyOf(SurveyInstanceOwner)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceOwner actualCopyOfResult = ImmutableSurveyInstanceOwner.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, actualCopyOfResult.surveyInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner#copyOf(SurveyInstanceOwner)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceOwner actualCopyOfResult = ImmutableSurveyInstanceOwner.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, actualCopyOfResult.surveyInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwner#fromJson(ImmutableSurveyInstanceOwner.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceOwner.Json json = new ImmutableSurveyInstanceOwner.Json();
    json.setId(null);
    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    json.setSurveyInstance(surveyInstance);
    json.setPerson(mock(Person.class));

    // Act
    ImmutableSurveyInstanceOwner actualFromJsonResult = ImmutableSurveyInstanceOwner.fromJson(json);

    // Assert
    assertSame(surveyInstance, actualFromJsonResult.surveyInstance());
    Person expectedPersonResult = json.person;
    assertSame(expectedPersonResult, actualFromJsonResult.person());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceOwner.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceOwner.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceOwner.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceOwner.Json actualJson = new ImmutableSurveyInstanceOwner.Json();

    // Assert
    assertNull(actualJson.person);
    assertNull(actualJson.surveyInstance);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceOwner.Json#person()}
   */
  @Test
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceOwner.Json()).person());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceOwner.Json#surveyInstance()}
   */
  @Test
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceOwner.Json()).surveyInstance());
  }
}
