package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableMyEntity.Builder;
import org.finos.waltz.jobs.tools.importers.ImmutableMyEntity.Json;
import org.finos.waltz.jobs.tools.importers.ImporterExperiment.MyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMyEntityDiffblueTest {
  /**
   * Test {@link ImmutableMyEntity#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMyEntity#builder()}
   *   <li>{@link ImmutableMyEntity#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMyEntity Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMyEntity.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(MyEntity)}.
   * <p>
   * Method under test: {@link Builder#from(MyEntity)}
   */
  @Test
  @DisplayName("Test Builder from(MyEntity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MyEntity)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();
    MyEntity instance = mock(MyEntity.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    ImmutableMyEntity buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MyEntity)}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MyEntity)}
   */
  @Test
  @DisplayName("Test Builder from(MyEntity); then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MyEntity)"})
  void testBuilderFrom_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();
    MyEntity instance = mock(MyEntity.class);
    when(instance.description()).thenReturn(null);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    ImmutableMyEntity buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MyEntity)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MyEntity)}
   */
  @Test
  @DisplayName("Test Builder from(MyEntity); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MyEntity)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();
    MyEntity instance = mock(MyEntity.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableMyEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setExternalId(String)",
      "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }
}
