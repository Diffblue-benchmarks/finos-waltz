package org.finos.waltz.model.checkpoint;

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
import org.finos.waltz.model.Quarter;
import org.finos.waltz.model.checkpoint.ImmutableCheckpoint.Builder;
import org.finos.waltz.model.checkpoint.ImmutableCheckpoint.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCheckpointDiffblueTest {
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
  @MethodsUnderTest({"ImmutableCheckpoint Builder.build()", "Builder Builder.description(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableCheckpoint actualImmutableCheckpoint =
        actualIdResult.id(id).name("Name").quarter(Quarter.Q1).year(1).build();

    // Assert
    assertEquals("Name", actualImmutableCheckpoint.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableCheckpoint.description());
    assertEquals(1, actualImmutableCheckpoint.year());
    assertEquals(Quarter.Q1, actualImmutableCheckpoint.quarter());
  }

  /**
   * Test Builder {@link Builder#from(Checkpoint)} with {@code Checkpoint}.
   *
   * <p>Method under test: {@link Builder#from(Checkpoint)}
   */
  @Test
  @DisplayName("Test Builder from(Checkpoint) with 'Checkpoint'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Checkpoint)"})
  void testBuilderFromWithCheckpoint() {
    // Arrange
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Checkpoint)} with {@code Checkpoint}.
   *
   * <p>Method under test: {@link Builder#from(Checkpoint)}
   */
  @Test
  @DisplayName("Test Builder from(Checkpoint) with 'Checkpoint'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Checkpoint)"})
  void testBuilderFromWithCheckpoint2() {
    // Arrange
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description(null)
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
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
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
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
    Builder builderResult = ImmutableCheckpoint.builder();
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description(null)
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableCheckpoint actualImmutableCheckpoint = builderResult.build();
    assertEquals(instance, actualImmutableCheckpoint);
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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();

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
    Builder builderResult = ImmutableCheckpoint.builder();
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
    Builder builderResult = ImmutableCheckpoint.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#quarter(Quarter)}.
   *
   * <p>Method under test: {@link Builder#quarter(Quarter)}
   */
  @Test
  @DisplayName("Test Builder quarter(Quarter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.quarter(Quarter)"})
  void testBuilderQuarter() {
    // Arrange
    Builder builderResult = ImmutableCheckpoint.builder();

    // Act
    Builder actualQuarterResult = builderResult.quarter(Quarter.Q1);

    // Assert
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Test Builder {@link Builder#year(int)}.
   *
   * <p>Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableCheckpoint.builder();

    // Act
    Builder actualYearResult = builderResult.year(1);

    // Assert
    assertSame(builderResult, actualYearResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#copyOf(Checkpoint)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#copyOf(Checkpoint)}
   */
  @Test
  @DisplayName("Test copyOf(Checkpoint); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.copyOf(Checkpoint)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableCheckpoint instance =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualCopyOfResult = ImmutableCheckpoint.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(Quarter.Q1, actualCopyOfResult.quarter());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}, and {@link ImmutableCheckpoint#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpoint#equals(Object)}
   *   <li>{@link ImmutableCheckpoint#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();
    ImmutableCheckpoint immutableCheckpoint2 =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableCheckpoint, immutableCheckpoint2);
    assertEquals(immutableCheckpoint.hashCode(), immutableCheckpoint2.hashCode());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}, and {@link ImmutableCheckpoint#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpoint#equals(Object)}
   *   <li>{@link ImmutableCheckpoint#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableCheckpoint, immutableCheckpoint);
    int expectedHashCodeResult = immutableCheckpoint.hashCode();
    assertEquals(expectedHashCodeResult, immutableCheckpoint.hashCode());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpoint,
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("java.lang.Long")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpoint,
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q2)
            .year(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpoint,
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpoint,
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCheckpoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpoint.equals(Object)",
    "int ImmutableCheckpoint.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build(),
        "Different type to ImmutableCheckpoint");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpoint#description()}
   *   <li>{@link ImmutableCheckpoint#name()}
   *   <li>{@link ImmutableCheckpoint#quarter()}
   *   <li>{@link ImmutableCheckpoint#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCheckpoint.description()",
    "String ImmutableCheckpoint.name()",
    "Quarter ImmutableCheckpoint.quarter()",
    "int ImmutableCheckpoint.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    String actualDescriptionResult = immutableCheckpoint.description();
    String actualNameResult = immutableCheckpoint.name();
    Quarter actualQuarterResult = immutableCheckpoint.quarter();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, immutableCheckpoint.year());
    assertEquals(Quarter.Q1, actualQuarterResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#id()}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCheckpoint.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.quarter);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Test Json {@link Json#quarter()}.
   *
   * <p>Method under test: {@link Json#quarter()}
   */
  @Test
  @DisplayName("Test Json quarter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Quarter Json.quarter()"})
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().quarter());
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   *
   * <p>Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableCheckpoint#toString()}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCheckpoint.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Checkpoint{id=1, name=Name, year=1, quarter=Q1}",
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableCheckpoint#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualWithDescriptionResult = immutableCheckpoint.withDescription("42");

    // Assert
    assertEquals(immutableCheckpoint, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("42")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualWithDescriptionResult = immutableCheckpoint.withDescription("42");

    // Assert
    assertSame(immutableCheckpoint, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableCheckpoint actualWithIdResult = immutableCheckpoint.withId(optional);

    // Assert
    assertSame(immutableCheckpoint, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableCheckpoint actualWithIdResult = immutableCheckpoint.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.year());
    assertEquals(Quarter.Q1, actualWithIdResult.quarter());
  }

  /**
   * Test {@link ImmutableCheckpoint#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualWithIdResult = immutableCheckpoint.withId(1L);

    // Assert
    assertSame(immutableCheckpoint, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableCheckpoint actualWithIdResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.year());
    assertEquals(Quarter.Q1, actualWithIdResult.quarter());
  }

  /**
   * Test {@link ImmutableCheckpoint#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("42")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualWithNameResult = immutableCheckpoint.withName("42");

    // Assert
    assertSame(immutableCheckpoint, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableCheckpoint actualWithNameResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.year());
    assertEquals(Quarter.Q1, actualWithNameResult.quarter());
  }

  /**
   * Test {@link ImmutableCheckpoint#withQuarter(Quarter)}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withQuarter(Quarter)}
   */
  @Test
  @DisplayName("Test withQuarter(Quarter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withQuarter(Quarter)"})
  void testWithQuarter() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build();

    // Act
    ImmutableCheckpoint actualWithQuarterResult = immutableCheckpoint.withQuarter(Quarter.Q1);

    // Assert
    assertSame(immutableCheckpoint, actualWithQuarterResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withQuarter(Quarter)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withQuarter(Quarter)}
   */
  @Test
  @DisplayName("Test withQuarter(Quarter); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withQuarter(Quarter)"})
  void testWithQuarter_thenReturnName() {
    // Arrange and Act
    ImmutableCheckpoint actualWithQuarterResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q2)
            .year(1)
            .build()
            .withQuarter(Quarter.Q1);

    // Assert
    assertEquals("Name", actualWithQuarterResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithQuarterResult.description());
    assertEquals(1, actualWithQuarterResult.year());
    assertEquals(Quarter.Q1, actualWithQuarterResult.quarter());
  }

  /**
   * Test {@link ImmutableCheckpoint#withYear(int)}.
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withYear(int)"})
  void testWithYear() {
    // Arrange
    ImmutableCheckpoint immutableCheckpoint =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(42)
            .build();

    // Act
    ImmutableCheckpoint actualWithYearResult = immutableCheckpoint.withYear(42);

    // Assert
    assertSame(immutableCheckpoint, actualWithYearResult);
  }

  /**
   * Test {@link ImmutableCheckpoint#withYear(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpoint#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpoint ImmutableCheckpoint.withYear(int)"})
  void testWithYear_thenReturnName() {
    // Arrange and Act
    ImmutableCheckpoint actualWithYearResult =
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build()
            .withYear(42);

    // Assert
    assertEquals("Name", actualWithYearResult.name());
    assertEquals("The characteristics of someone or something", actualWithYearResult.description());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(Quarter.Q1, actualWithYearResult.quarter());
  }
}
