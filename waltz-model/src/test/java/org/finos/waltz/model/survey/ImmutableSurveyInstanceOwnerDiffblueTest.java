package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwner.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwner.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwnerDiffblueTest {
  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwner)} with {@code SurveyInstanceOwner}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwner)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwner) with 'SurveyInstanceOwner'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwner)"})
  void testBuilderFromWithSurveyInstanceOwner_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwner)} with {@code SurveyInstanceOwner}.
   * <ul>
   *   <li>Then builder build surveyInstance is {@link ImmutableSurveyInstance.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwner)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwner) with 'SurveyInstanceOwner'; then builder build surveyInstance is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwner)"})
  void testBuilderFromWithSurveyInstanceOwner_thenBuilderBuildSurveyInstanceIsJson() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    SurveyInstanceOwner instance = mock(SurveyInstanceOwner.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    ImmutableSurveyInstance.Json json = new ImmutableSurveyInstance.Json();
    when(instance.surveyInstance()).thenReturn(json);
    when(instance.person()).thenReturn(mock(Person.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).person();
    verify(instance).surveyInstance();
    assertSame(json, builderResult.build().surveyInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwner)} with {@code SurveyInstanceOwner}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwner)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwner) with 'SurveyInstanceOwner'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwner)"})
  void testBuilderFromWithSurveyInstanceOwner_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
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
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#person(Person)}.
   * <ul>
   *   <li>When {@link Person}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#person(Person)}
   */
  @Test
  @DisplayName("Test Builder person(Person); when Person; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.person(Person)"})
  void testBuilderPerson_whenPerson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.person(mock(Person.class)));
  }

  /**
   * Test Builder {@link Builder#surveyInstance(SurveyInstance)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstance.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyInstance(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder surveyInstance(SurveyInstance); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInstance(SurveyInstance)"})
  void testBuilderSurveyInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwner.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstance(new ImmutableSurveyInstance.Json()));
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.person);
    assertNull(actualJson.surveyInstance);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#person()}.
   * <p>
   * Method under test: {@link Json#person()}
   */
  @Test
  @DisplayName("Test Json person()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person Json.person()"})
  void testJsonPerson() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).person());
  }

  /**
   * Test Json {@link Json#surveyInstance()}.
   * <p>
   * Method under test: {@link Json#surveyInstance()}
   */
  @Test
  @DisplayName("Test Json surveyInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstance Json.surveyInstance()"})
  void testJsonSurveyInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyInstance());
  }
}
