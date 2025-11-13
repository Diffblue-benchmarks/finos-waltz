package org.finos.waltz.model.performance_metric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        actualIdResult.id(id).name("Name").build();

    // Assert
    assertEquals(
        "Category Description", actualImmutablePerformanceMetricDefinition.categoryDescription());
    assertEquals("Category Name", actualImmutablePerformanceMetricDefinition.categoryName());
    assertEquals("Name", actualImmutablePerformanceMetricDefinition.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePerformanceMetricDefinition.description());
  }

  /**
   * Test Builder {@link Builder#categoryDescription(String)}.
   *
   * <ul>
   *   <li>When {@code Category Description}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#categoryDescription(String)}
   */
  @Test
  @DisplayName(
      "Test Builder categoryDescription(String); when 'Category Description'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.categoryDescription(String)"})
  void testBuilderCategoryDescription_whenCategoryDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act
    Builder actualCategoryDescriptionResult =
        builderResult.categoryDescription("Category Description");

    // Assert
    assertSame(builderResult, actualCategoryDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#categoryName(String)}.
   *
   * <ul>
   *   <li>When {@code Category Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#categoryName(String)}
   */
  @Test
  @DisplayName("Test Builder categoryName(String); when 'Category Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.categoryName(String)"})
  void testBuilderCategoryName_whenCategoryName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act
    Builder actualCategoryNameResult = builderResult.categoryName("Category Name");

    // Assert
    assertSame(builderResult, actualCategoryNameResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description(null)
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
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
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code
   * PerformanceMetricDefinition}.
   *
   * <p>Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PerformanceMetricDefinition)} with {@code
   * PerformanceMetricDefinition}.
   *
   * <p>Method under test: {@link Builder#from(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PerformanceMetricDefinition) with 'PerformanceMetricDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PerformanceMetricDefinition)"})
  void testBuilderFromWithPerformanceMetricDefinition2() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description(null)
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePerformanceMetricDefinition actualImmutablePerformanceMetricDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutablePerformanceMetricDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePerformanceMetricDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#copyOf(PerformanceMetricDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Category Description}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePerformanceMetricDefinition#copyOf(PerformanceMetricDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(PerformanceMetricDefinition); then return 'Category Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.copyOf(PerformanceMetricDefinition)"
  })
  void testCopyOf_thenReturnCategoryDescription() {
    // Arrange
    ImmutablePerformanceMetricDefinition instance =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualCopyOfResult =
        ImmutablePerformanceMetricDefinition.copyOf(instance);

    // Assert
    assertEquals("Category Description", actualCopyOfResult.categoryDescription());
    assertEquals("Category Name", actualCopyOfResult.categoryName());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}, and {@link
   * ImmutablePerformanceMetricDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerformanceMetricDefinition#equals(Object)}
   *   <li>{@link ImmutablePerformanceMetricDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition2 =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutablePerformanceMetricDefinition, immutablePerformanceMetricDefinition2);
    assertEquals(
        immutablePerformanceMetricDefinition.hashCode(),
        immutablePerformanceMetricDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}, and {@link
   * ImmutablePerformanceMetricDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerformanceMetricDefinition#equals(Object)}
   *   <li>{@link ImmutablePerformanceMetricDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutablePerformanceMetricDefinition, immutablePerformanceMetricDefinition);
    int expectedHashCodeResult = immutablePerformanceMetricDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutablePerformanceMetricDefinition.hashCode());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Name")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerformanceMetricDefinition,
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerformanceMetricDefinition,
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerformanceMetricDefinition,
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Category Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePerformanceMetricDefinition,
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePerformanceMetricDefinition.equals(Object)",
    "int ImmutablePerformanceMetricDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        "Different type to ImmutablePerformanceMetricDefinition");
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCategoryName("Json");
    json.setCategoryDescription("Json");

    // Act
    ImmutablePerformanceMetricDefinition actualFromJsonResult =
        ImmutablePerformanceMetricDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.categoryDescription());
    assertEquals("Json", actualFromJsonResult.categoryName());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setId(null);
    json.setCategoryName("Json");
    json.setCategoryDescription("Json");

    // Act
    ImmutablePerformanceMetricDefinition actualFromJsonResult =
        ImmutablePerformanceMetricDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.categoryDescription());
    assertEquals("Json", actualFromJsonResult.categoryName());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of forty-two; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setCategoryName("Json");
    json.setCategoryDescription("Json");

    // Act
    ImmutablePerformanceMetricDefinition actualFromJsonResult =
        ImmutablePerformanceMetricDefinition.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.categoryDescription());
    assertEquals("Json", actualFromJsonResult.categoryName());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePerformanceMetricDefinition#categoryDescription()}
   *   <li>{@link ImmutablePerformanceMetricDefinition#categoryName()}
   *   <li>{@link ImmutablePerformanceMetricDefinition#description()}
   *   <li>{@link ImmutablePerformanceMetricDefinition#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePerformanceMetricDefinition.categoryDescription()",
    "String ImmutablePerformanceMetricDefinition.categoryName()",
    "String ImmutablePerformanceMetricDefinition.description()",
    "String ImmutablePerformanceMetricDefinition.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    String actualCategoryDescriptionResult =
        immutablePerformanceMetricDefinition.categoryDescription();
    String actualCategoryNameResult = immutablePerformanceMetricDefinition.categoryName();
    String actualDescriptionResult = immutablePerformanceMetricDefinition.description();

    // Assert
    assertEquals("Category Description", actualCategoryDescriptionResult);
    assertEquals("Category Name", actualCategoryNameResult);
    assertEquals("Name", immutablePerformanceMetricDefinition.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePerformanceMetricDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#categoryDescription()}.
   *
   * <p>Method under test: {@link Json#categoryDescription()}
   */
  @Test
  @DisplayName("Test Json categoryDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.categoryDescription()"})
  void testJsonCategoryDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryDescription());
  }

  /**
   * Test Json {@link Json#categoryName()}.
   *
   * <p>Method under test: {@link Json#categoryName()}
   */
  @Test
  @DisplayName("Test Json categoryName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.categoryName()"})
  void testJsonCategoryName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryName());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePerformanceMetricDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PerformanceMetricDefinition{name=Name, id=1, categoryName=Category Name, categoryDescription=Category"
            + " Description}",
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withCategoryDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutablePerformanceMetricDefinition#withCategoryDescription(String)}
   */
  @Test
  @DisplayName("Test withCategoryDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withCategoryDescription(String)"
  })
  void testWithCategoryDescription() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("42")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithCategoryDescriptionResult =
        immutablePerformanceMetricDefinition.withCategoryDescription("42");

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithCategoryDescriptionResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withCategoryDescription(String)}.
   *
   * <ul>
   *   <li>Then return categoryDescription is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePerformanceMetricDefinition#withCategoryDescription(String)}
   */
  @Test
  @DisplayName("Test withCategoryDescription(String); then return categoryDescription is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withCategoryDescription(String)"
  })
  void testWithCategoryDescription_thenReturnCategoryDescriptionIs42() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition actualWithCategoryDescriptionResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withCategoryDescription("42");

    // Assert
    assertEquals("42", actualWithCategoryDescriptionResult.categoryDescription());
    assertEquals("Category Name", actualWithCategoryDescriptionResult.categoryName());
    assertEquals("Name", actualWithCategoryDescriptionResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithCategoryDescriptionResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withCategoryName(String)}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withCategoryName(String)}
   */
  @Test
  @DisplayName("Test withCategoryName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withCategoryName(String)"
  })
  void testWithCategoryName() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("42")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithCategoryNameResult =
        immutablePerformanceMetricDefinition.withCategoryName("42");

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithCategoryNameResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withCategoryName(String)}.
   *
   * <ul>
   *   <li>Then return categoryName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withCategoryName(String)}
   */
  @Test
  @DisplayName("Test withCategoryName(String); then return categoryName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withCategoryName(String)"
  })
  void testWithCategoryName_thenReturnCategoryNameIs42() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition actualWithCategoryNameResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withCategoryName("42");

    // Assert
    assertEquals("42", actualWithCategoryNameResult.categoryName());
    assertEquals("Category Description", actualWithCategoryNameResult.categoryDescription());
    assertEquals("Name", actualWithCategoryNameResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithCategoryNameResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithDescriptionResult =
        immutablePerformanceMetricDefinition.withDescription("42");

    // Assert
    assertEquals(immutablePerformanceMetricDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithDescriptionResult =
        immutablePerformanceMetricDefinition.withDescription("42");

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePerformanceMetricDefinition actualWithIdResult =
        immutablePerformanceMetricDefinition.withId(optional);

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Category Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return 'Category Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnCategoryDescription() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePerformanceMetricDefinition actualWithIdResult =
        immutablePerformanceMetricDefinition.withId(optional);

    // Assert
    assertEquals("Category Description", actualWithIdResult.categoryDescription());
    assertEquals("Category Name", actualWithIdResult.categoryName());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithIdResult =
        immutablePerformanceMetricDefinition.withId(1L);

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Category Description}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Category Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnCategoryDescription() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition actualWithIdResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Category Description", actualWithIdResult.categoryDescription());
    assertEquals("Category Name", actualWithIdResult.categoryName());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutablePerformanceMetricDefinition immutablePerformanceMetricDefinition =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("42")
            .build();

    // Act
    ImmutablePerformanceMetricDefinition actualWithNameResult =
        immutablePerformanceMetricDefinition.withName("42");

    // Assert
    assertSame(immutablePerformanceMetricDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePerformanceMetricDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePerformanceMetricDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePerformanceMetricDefinition ImmutablePerformanceMetricDefinition.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutablePerformanceMetricDefinition actualWithNameResult =
        ImmutablePerformanceMetricDefinition.builder()
            .categoryDescription("Category Description")
            .categoryName("Category Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Category Description", actualWithNameResult.categoryDescription());
    assertEquals("Category Name", actualWithNameResult.categoryName());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }
}
