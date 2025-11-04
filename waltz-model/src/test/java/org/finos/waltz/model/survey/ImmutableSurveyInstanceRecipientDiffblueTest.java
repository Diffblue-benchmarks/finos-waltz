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

class ImmutableSurveyInstanceRecipientDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(SurveyInstanceRecipient)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    SurveyInstanceRecipient instance = mock(SurveyInstanceRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(SurveyInstanceRecipient)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    SurveyInstanceRecipient instance = mock(SurveyInstanceRecipient.class);
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
   * {@link ImmutableSurveyInstanceRecipient.Builder#from(SurveyInstanceRecipient)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    SurveyInstanceRecipient instance = mock(SurveyInstanceRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceRecipient.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#person(Person)}
   */
  @Test
  void testBuilderPerson() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  void testBuilderSurveyInstance2() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Builder builderResult = ImmutableSurveyInstanceRecipient.builder();

    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    surveyInstance.setSurveyEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(surveyInstance));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient#copyOf(SurveyInstanceRecipient)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceRecipient instance = mock(SurveyInstanceRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceRecipient actualCopyOfResult = ImmutableSurveyInstanceRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, actualCopyOfResult.surveyInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient#copyOf(SurveyInstanceRecipient)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyInstanceRecipient instance = mock(SurveyInstanceRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    ImmutableSurveyInstanceRecipient actualCopyOfResult = ImmutableSurveyInstanceRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, actualCopyOfResult.surveyInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient#fromJson(ImmutableSurveyInstanceRecipient.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceRecipient.Json json = new ImmutableSurveyInstanceRecipient.Json();
    json.setId(null);
    ImmutableSurveyInstance.Json surveyInstance = new ImmutableSurveyInstance.Json();
    json.setSurveyInstance(surveyInstance);
    json.setPerson(mock(Person.class));

    // Act
    ImmutableSurveyInstanceRecipient actualFromJsonResult = ImmutableSurveyInstanceRecipient.fromJson(json);

    // Assert
    assertSame(surveyInstance, actualFromJsonResult.surveyInstance());
    Person expectedPersonResult = json.person;
    assertSame(expectedPersonResult, actualFromJsonResult.person());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceRecipient.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceRecipient.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceRecipient.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipient.Json actualJson = new ImmutableSurveyInstanceRecipient.Json();

    // Assert
    assertNull(actualJson.person);
    assertNull(actualJson.surveyInstance);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceRecipient.Json#person()}
   */
  @Test
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyInstanceRecipient.Json()).person());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipient.Json#surveyInstance()}
   */
  @Test
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipient.Json()).surveyInstance());
  }
}
