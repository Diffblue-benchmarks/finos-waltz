package org.finos.waltz.model.performance_metric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutablePerformanceMetricDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePerformanceMetricDefinition#builder()}
   *   <li>{@link ImmutablePerformanceMetricDefinition#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition.Builder actualIdResult = ImmutablePerformanceMetricDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#categoryDescription(String)}
   */
  @Test
  void testBuilderCategoryDescription() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryDescription("Category Description"));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#categoryName(String)}
   */
  @Test
  void testBuilderCategoryName() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryName("Category Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
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
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn(null);
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition#copyOf(PerformanceMetricDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition actualCopyOfResult = ImmutablePerformanceMetricDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
    assertEquals("Category Description", actualCopyOfResult.categoryDescription());
    assertEquals("Category Name", actualCopyOfResult.categoryName());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition#copyOf(PerformanceMetricDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PerformanceMetricDefinition instance = mock(PerformanceMetricDefinition.class);
    when(instance.categoryDescription()).thenReturn("Category Description");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.categoryName()).thenReturn("Category Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePerformanceMetricDefinition actualCopyOfResult = ImmutablePerformanceMetricDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryDescription();
    verify(instance).categoryName();
    assertEquals("Category Description", actualCopyOfResult.categoryDescription());
    assertEquals("Category Name", actualCopyOfResult.categoryName());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition#fromJson(ImmutablePerformanceMetricDefinition.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePerformanceMetricDefinition.Json json = new ImmutablePerformanceMetricDefinition.Json();
    json.setName("Json");
    json.setDescription(null);
    json.setId(null);
    json.setCategoryName("Json");
    json.setCategoryDescription("Json");

    // Act
    ImmutablePerformanceMetricDefinition actualFromJsonResult = ImmutablePerformanceMetricDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.categoryDescription());
    assertEquals("Json", actualFromJsonResult.categoryName());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Json#categoryDescription()}
   */
  @Test
  void testJsonCategoryDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePerformanceMetricDefinition.Json()).categoryDescription());
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Json#categoryName()}
   */
  @Test
  void testJsonCategoryName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePerformanceMetricDefinition.Json()).categoryName());
  }

  /**
   * Method under test:
   * {@link ImmutablePerformanceMetricDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePerformanceMetricDefinition.Json()).description());
  }

  /**
   * Method under test: {@link ImmutablePerformanceMetricDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerformanceMetricDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutablePerformanceMetricDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePerformanceMetricDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePerformanceMetricDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition.Json actualJson = new ImmutablePerformanceMetricDefinition.Json();

    // Assert
    assertNull(actualJson.categoryDescription);
    assertNull(actualJson.categoryName);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
  }
}
