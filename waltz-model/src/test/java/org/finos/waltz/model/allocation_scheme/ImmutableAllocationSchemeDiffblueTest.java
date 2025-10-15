package org.finos.waltz.model.allocation_scheme;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme.Builder;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocationSchemeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableAllocationScheme actualImmutableAllocationScheme =
        actualIdResult.id(id).measurableCategoryId(1L).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableAllocationScheme.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAllocationScheme.description());
    assertEquals(1L, actualImmutableAllocationScheme.measurableCategoryId());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AllocationScheme)} with {@code AllocationScheme}.
   *
   * <p>Method under test: {@link Builder#from(AllocationScheme)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationScheme) with 'AllocationScheme'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocationScheme)"})
  void testBuilderFromWithAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AllocationScheme)} with {@code AllocationScheme}.
   *
   * <p>Method under test: {@link Builder#from(AllocationScheme)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationScheme) with 'AllocationScheme'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocationScheme)"})
  void testBuilderFromWithAllocationScheme2() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
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
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
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
    Builder builderResult = ImmutableAllocationScheme.builder();

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
    Builder builderResult = ImmutableAllocationScheme.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
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
    Builder builderResult = ImmutableAllocationScheme.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableAllocationScheme.builder();

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
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
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
    Builder builderResult = ImmutableAllocationScheme.builder();
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableAllocationScheme actualImmutableAllocationScheme = builderResult.build();
    assertEquals(instance, actualImmutableAllocationScheme);
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
    Builder builderResult = ImmutableAllocationScheme.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableAllocationScheme.builder();

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
    Builder builderResult = ImmutableAllocationScheme.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#measurableCategoryId(long)}.
   *
   * <p>Method under test: {@link Builder#measurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCategoryId(long)"})
  void testBuilderMeasurableCategoryId() {
    // Arrange
    Builder builderResult = ImmutableAllocationScheme.builder();

    // Act
    Builder actualMeasurableCategoryIdResult = builderResult.measurableCategoryId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableCategoryIdResult);
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
    Builder builderResult = ImmutableAllocationScheme.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#copyOf(AllocationScheme)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#copyOf(AllocationScheme)}
   */
  @Test
  @DisplayName("Test copyOf(AllocationScheme); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme ImmutableAllocationScheme.copyOf(AllocationScheme)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableAllocationScheme instance =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualCopyOfResult = ImmutableAllocationScheme.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}, and {@link
   * ImmutableAllocationScheme#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationScheme#equals(Object)}
   *   <li>{@link ImmutableAllocationScheme#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    ImmutableAllocationScheme immutableAllocationScheme2 =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableAllocationScheme, immutableAllocationScheme2);
    assertEquals(immutableAllocationScheme.hashCode(), immutableAllocationScheme2.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}, and {@link
   * ImmutableAllocationScheme#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationScheme#equals(Object)}
   *   <li>{@link ImmutableAllocationScheme#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableAllocationScheme, immutableAllocationScheme);
    int expectedHashCodeResult = immutableAllocationScheme.hashCode();
    assertEquals(expectedHashCodeResult, immutableAllocationScheme.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocationScheme,
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocationScheme,
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(2L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocationScheme,
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("externalId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocationScheme,
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAllocationScheme#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationScheme.equals(Object)",
    "int ImmutableAllocationScheme.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build(),
        "Different type to ImmutableAllocationScheme");
  }

  /**
   * Test {@link ImmutableAllocationScheme#externalId()}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAllocationScheme.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationScheme#description()}
   *   <li>{@link ImmutableAllocationScheme#measurableCategoryId()}
   *   <li>{@link ImmutableAllocationScheme#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAllocationScheme.description()",
    "long ImmutableAllocationScheme.measurableCategoryId()",
    "String ImmutableAllocationScheme.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableAllocationScheme.description();
    long actualMeasurableCategoryIdResult = immutableAllocationScheme.measurableCategoryId();

    // Assert
    assertEquals("Name", immutableAllocationScheme.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualMeasurableCategoryIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#id()}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAllocationScheme.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
   * Test Json {@link Json#measurableCategoryId()}.
   *
   * <p>Method under test: {@link Json#measurableCategoryId()}
   */
  @Test
  @DisplayName("Test Json measurableCategoryId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableCategoryId()"})
  void testJsonMeasurableCategoryId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableCategoryId());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertEquals(0L, actualJson.measurableCategoryId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.measurableCategoryIdIsSet);
  }

  /**
   * Test Json {@link Json#setMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableCategoryId(long)"})
  void testJsonSetMeasurableCategoryId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableCategoryId(1L);

    // Assert
    assertEquals(1L, json.measurableCategoryId);
    assertTrue(json.measurableCategoryIdIsSet);
  }

  /**
   * Test {@link ImmutableAllocationScheme#toString()}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAllocationScheme.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AllocationScheme{id=1, name=Name, externalId=42, measurableCategoryId=1}",
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualWithDescriptionResult =
        immutableAllocationScheme.withDescription("42");

    // Assert
    assertEquals(immutableAllocationScheme, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualWithDescriptionResult =
        immutableAllocationScheme.withDescription("42");

    // Assert
    assertSame(immutableAllocationScheme, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme ImmutableAllocationScheme.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAllocationScheme actualWithExternalIdResult =
        immutableAllocationScheme.withExternalId(optional);

    // Assert
    assertSame(immutableAllocationScheme, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme ImmutableAllocationScheme.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAllocationScheme actualWithExternalIdResult =
        immutableAllocationScheme.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualWithExternalIdResult =
        immutableAllocationScheme.withExternalId("42");

    // Assert
    assertSame(immutableAllocationScheme, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableAllocationScheme actualWithExternalIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocationScheme actualWithIdResult = immutableAllocationScheme.withId(optional);

    // Assert
    assertSame(immutableAllocationScheme, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocationScheme actualWithIdResult = immutableAllocationScheme.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualWithIdResult = immutableAllocationScheme.withId(1L);

    // Assert
    assertSame(immutableAllocationScheme, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableAllocationScheme actualWithIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme ImmutableAllocationScheme.withMeasurableCategoryId(long)"
  })
  void testWithMeasurableCategoryId() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(42L)
            .name("Name")
            .build();

    // Act
    ImmutableAllocationScheme actualWithMeasurableCategoryIdResult =
        immutableAllocationScheme.withMeasurableCategoryId(42L);

    // Assert
    assertSame(immutableAllocationScheme, actualWithMeasurableCategoryIdResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withMeasurableCategoryId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableCategoryId(long); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationScheme ImmutableAllocationScheme.withMeasurableCategoryId(long)"
  })
  void testWithMeasurableCategoryId_thenReturnName() {
    // Arrange and Act
    ImmutableAllocationScheme actualWithMeasurableCategoryIdResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .withMeasurableCategoryId(42L);

    // Assert
    assertEquals("Name", actualWithMeasurableCategoryIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithMeasurableCategoryIdResult.description());
    assertEquals(42L, actualWithMeasurableCategoryIdResult.measurableCategoryId());
  }

  /**
   * Test {@link ImmutableAllocationScheme#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableAllocationScheme immutableAllocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("42")
            .build();

    // Act
    ImmutableAllocationScheme actualWithNameResult = immutableAllocationScheme.withName("42");

    // Assert
    assertSame(immutableAllocationScheme, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAllocationScheme#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationScheme#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationScheme ImmutableAllocationScheme.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableAllocationScheme actualWithNameResult =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.measurableCategoryId());
  }
}
