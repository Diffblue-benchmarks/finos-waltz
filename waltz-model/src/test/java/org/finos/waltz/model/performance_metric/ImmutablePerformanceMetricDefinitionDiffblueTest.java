package org.finos.waltz.model.performance_metric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.performance_metric.ImmutablePerformanceMetricDefinition.Builder;
import org.finos.waltz.model.performance_metric.ImmutablePerformanceMetricDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePerformanceMetricDefinitionDiffblueTest {
  /**
   * Test {@link ImmutablePerformanceMetricDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePerformanceMetricDefinition#builder()}
   *   <li>{@link ImmutablePerformanceMetricDefinition#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePerformanceMetricDefinition Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutablePerformanceMetricDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#categoryDescription(String)}.
   * <p>
   * Method under test: {@link Builder#categoryDescription(String)}
   */
  @Test
  @DisplayName("Test Builder categoryDescription(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.categoryDescription(String)"})
  void testBuilderCategoryDescription() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryDescription("Category Description"));
  }

  /**
   * Test Builder {@link Builder#categoryName(String)}.
   * <p>
   * Method under test: {@link Builder#categoryName(String)}
   */
  @Test
  @DisplayName("Test Builder categoryName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.categoryName(String)"})
  void testBuilderCategoryName() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryName("Category Name"));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code PerformanceMetricDefinition}.
   * <p>
   * Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
    ImmutablePerformanceMetricDefinition buildResult = builderResult.build();
    assertEquals("Category Description", buildResult.categoryDescription());
    assertEquals("Category Name", buildResult.categoryName());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code PerformanceMetricDefinition}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
    ImmutablePerformanceMetricDefinition buildResult = builderResult.build();
    assertEquals("Category Description", buildResult.categoryDescription());
    assertEquals("Category Name", buildResult.categoryName());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code PerformanceMetricDefinition}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn(null);
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
    ImmutablePerformanceMetricDefinition buildResult = builderResult.build();
    assertEquals("Category Description", buildResult.categoryDescription());
    assertEquals("Category Name", buildResult.categoryName());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code PerformanceMetricDefinition}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#categoryDescription()}.
   * <p>
   * Method under test: {@link Json#categoryDescription()}
   */
  @Test
  @DisplayName("Test Json categoryDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.categoryDescription()"})
  void testJsonCategoryDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).categoryDescription());
  }

  /**
   * Test Json {@link Json#categoryName()}.
   * <p>
   * Method under test: {@link Json#categoryName()}
   */
  @Test
  @DisplayName("Test Json categoryName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.categoryName()"})
  void testJsonCategoryName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).categoryName());
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
    assertNull(actualJson.categoryDescription);
    assertNull(actualJson.categoryName);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
  }
}
