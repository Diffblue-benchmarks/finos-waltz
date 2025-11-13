package org.finos.waltz.model.physical_specification_definition;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionField.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionField.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionFieldDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLogicalDataElementIdResult =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L);
    Optional<Long> logicalDataElementId = Optional.of(42L);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        actualLogicalDataElementIdResult
            .logicalDataElementId(logicalDataElementId)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutablePhysicalSpecDefinitionField.lastUpdatedBy());
    assertEquals("Name", actualImmutablePhysicalSpecDefinitionField.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalSpecDefinitionField.description());
    assertEquals(1, actualImmutablePhysicalSpecDefinitionField.position());
    assertEquals(1L, actualImmutablePhysicalSpecDefinitionField.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualImmutablePhysicalSpecDefinitionField.type());
    assertSame(lastUpdatedAt, actualImmutablePhysicalSpecDefinitionField.lastUpdatedAt());
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField2);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField2);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
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
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField2);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description(null)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionField)} with {@code
   * PhysicalSpecDefinitionField}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionField) with 'PhysicalSpecDefinitionField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionField)"})
  void testBuilderFromWithPhysicalSpecDefinitionField() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionField)} with {@code
   * PhysicalSpecDefinitionField}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionField) with 'PhysicalSpecDefinitionField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionField)"})
  void testBuilderFromWithPhysicalSpecDefinitionField2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description(null)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionField actualImmutablePhysicalSpecDefinitionField =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionField);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#logicalDataElementId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#logicalDataElementId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalDataElementId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalDataElementId(long)"})
  void testBuilderLogicalDataElementIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualLogicalDataElementIdResult = builderResult.logicalDataElementId(1L);

    // Assert
    assertSame(builderResult, actualLogicalDataElementIdResult);
  }

  /**
   * Test Builder {@link Builder#logicalDataElementId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#logicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test Builder logicalDataElementId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalDataElementId(Optional)"})
  void testBuilderLogicalDataElementIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();
    Optional<Long> logicalDataElementId = Optional.of(42L);

    // Act
    Builder actualLogicalDataElementIdResult =
        builderResult.logicalDataElementId(logicalDataElementId);

    // Assert
    assertSame(builderResult, actualLogicalDataElementIdResult);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#specDefinitionId(long)}.
   *
   * <p>Method under test: {@link Builder#specDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder specDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specDefinitionId(long)"})
  void testBuilderSpecDefinitionId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualSpecDefinitionIdResult = builderResult.specDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualSpecDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#type(FieldDataType)}.
   *
   * <p>Method under test: {@link Builder#type(FieldDataType)}
   */
  @Test
  @DisplayName("Test Builder type(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(FieldDataType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionField.builder();

    // Act
    Builder actualTypeResult = builderResult.type(FieldDataType.DATE);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#copyOf(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalSpecDefinitionField); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.copyOf(PhysicalSpecDefinitionField)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutablePhysicalSpecDefinitionField instance =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualCopyOfResult =
        ImmutablePhysicalSpecDefinitionField.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionField#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField2 =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalSpecDefinitionField, immutablePhysicalSpecDefinitionField2);
    assertEquals(
        immutablePhysicalSpecDefinitionField.hashCode(),
        immutablePhysicalSpecDefinitionField2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionField#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalSpecDefinitionField, immutablePhysicalSpecDefinitionField);
    int expectedHashCodeResult = immutablePhysicalSpecDefinitionField.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecDefinitionField.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(2L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("2020-03-01")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(0)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(2L)
            .type(FieldDataType.DATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATETIME)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionField,
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionField.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionField.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build(),
        "Different type to ImmutablePhysicalSpecDefinitionField");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#description()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#lastUpdatedAt()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#lastUpdatedBy()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#name()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#position()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#specDefinitionId()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionField#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecDefinitionField.description()",
    "LocalDateTime ImmutablePhysicalSpecDefinitionField.lastUpdatedAt()",
    "String ImmutablePhysicalSpecDefinitionField.lastUpdatedBy()",
    "String ImmutablePhysicalSpecDefinitionField.name()",
    "int ImmutablePhysicalSpecDefinitionField.position()",
    "long ImmutablePhysicalSpecDefinitionField.specDefinitionId()",
    "FieldDataType ImmutablePhysicalSpecDefinitionField.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    String actualDescriptionResult = immutablePhysicalSpecDefinitionField.description();
    LocalDateTime actualLastUpdatedAtResult = immutablePhysicalSpecDefinitionField.lastUpdatedAt();
    String actualLastUpdatedByResult = immutablePhysicalSpecDefinitionField.lastUpdatedBy();
    String actualNameResult = immutablePhysicalSpecDefinitionField.name();
    int actualPositionResult = immutablePhysicalSpecDefinitionField.position();
    long actualSpecDefinitionIdResult = immutablePhysicalSpecDefinitionField.specDefinitionId();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualPositionResult);
    assertEquals(1L, actualSpecDefinitionIdResult);
    assertEquals(FieldDataType.DATE, immutablePhysicalSpecDefinitionField.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionField.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
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
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#logicalDataElementId()}.
   *
   * <p>Method under test: {@link Json#logicalDataElementId()}
   */
  @Test
  @DisplayName("Test Json logicalDataElementId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.logicalDataElementId()"})
  void testJsonLogicalDataElementId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalDataElementId());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.type);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.specDefinitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.logicalDataElementId.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.specDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link Json#setSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSpecDefinitionId(long)"})
  void testJsonSetSpecDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.specDefinitionId);
    assertTrue(json.specDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#specDefinitionId()}.
   *
   * <p>Method under test: {@link Json#specDefinitionId()}
   */
  @Test
  @DisplayName("Test Json specDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.specDefinitionId()"})
  void testJsonSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specDefinitionId());
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldDataType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#logicalDataElementId()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#logicalDataElementId()}
   */
  @Test
  @DisplayName("Test logicalDataElementId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionField.logicalDataElementId()"})
  void testLogicalDataElementId() {
    // Arrange and Act
    Optional<Long> actualLogicalDataElementIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .logicalDataElementId();

    // Assert
    assertEquals(1L, actualLogicalDataElementIdResult.get().longValue());
    assertTrue(actualLogicalDataElementIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinitionField.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PhysicalSpecDefinitionField{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " specDefinitionId=1, position=1, type=DATE, logicalDataElementId=1}",
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithDescriptionResult =
        immutablePhysicalSpecDefinitionField.withDescription("42");

    // Assert
    assertEquals(immutablePhysicalSpecDefinitionField, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithDescriptionResult =
        immutablePhysicalSpecDefinitionField.withDescription("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithIdResult =
        immutablePhysicalSpecDefinitionField.withId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithIdResult =
        immutablePhysicalSpecDefinitionField.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithIdResult =
        immutablePhysicalSpecDefinitionField.withId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withId(long)"
  })
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLastUpdatedAtResult =
        immutablePhysicalSpecDefinitionField.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalSpecDefinitionField, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLastUpdatedByResult =
        immutablePhysicalSpecDefinitionField.withLastUpdatedBy("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLastUpdatedByResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1, actualWithLastUpdatedByResult.position());
    assertEquals(1L, actualWithLastUpdatedByResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithLastUpdatedByResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLogicalDataElementId(Optional)"
  })
  void testWithLogicalDataElementIdWithOptional() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionField.withLogicalDataElementId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLogicalDataElementIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithLogicalDataElementIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithLogicalDataElementIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLogicalDataElementIdResult.description());
    assertEquals(1, actualWithLogicalDataElementIdResult.position());
    assertEquals(1L, actualWithLogicalDataElementIdResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithLogicalDataElementIdResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLogicalDataElementId(Optional)"
  })
  void testWithLogicalDataElementIdWithOptional2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionField.withLogicalDataElementId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithLogicalDataElementIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(long)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLogicalDataElementId(long)"
  })
  void testWithLogicalDataElementIdWithValue() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLogicalDataElementIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withLogicalDataElementId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLogicalDataElementIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithLogicalDataElementIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithLogicalDataElementIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLogicalDataElementIdResult.description());
    assertEquals(1, actualWithLogicalDataElementIdResult.position());
    assertEquals(1L, actualWithLogicalDataElementIdResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithLogicalDataElementIdResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionField#withLogicalDataElementId(long)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withLogicalDataElementId(long)"
  })
  void testWithLogicalDataElementIdWithValue2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionField.withLogicalDataElementId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithLogicalDataElementIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("42")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithNameResult =
        immutablePhysicalSpecDefinitionField.withName("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withName(String)"
  })
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithNameResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithNameResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(42)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithPositionResult =
        immutablePhysicalSpecDefinitionField.withPosition(42);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withPosition(int)"
  })
  void testWithPosition_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithPositionResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withPosition(42);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithPositionResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithPositionResult.lastUpdatedBy());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.specDefinitionId());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(FieldDataType.DATE, actualWithPositionResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withSpecDefinitionId(long)"
  })
  void testWithSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(42L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithSpecDefinitionIdResult =
        immutablePhysicalSpecDefinitionField.withSpecDefinitionId(42L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithSpecDefinitionIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withSpecDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withSpecDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withSpecDefinitionId(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withSpecDefinitionId(long)"
  })
  void testWithSpecDefinitionId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithSpecDefinitionIdResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build()
            .withSpecDefinitionId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithSpecDefinitionIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithSpecDefinitionIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithSpecDefinitionIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecDefinitionIdResult.description());
    assertEquals(1, actualWithSpecDefinitionIdResult.position());
    assertEquals(42L, actualWithSpecDefinitionIdResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithSpecDefinitionIdResult.type());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withType(FieldDataType)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withType(FieldDataType)}
   */
  @Test
  @DisplayName("Test withType(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withType(FieldDataType)"
  })
  void testWithType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionField immutablePhysicalSpecDefinitionField =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithTypeResult =
        immutablePhysicalSpecDefinitionField.withType(FieldDataType.DATE);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionField, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionField#withType(FieldDataType)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionField#withType(FieldDataType)}
   */
  @Test
  @DisplayName(
      "Test withType(FieldDataType); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionField ImmutablePhysicalSpecDefinitionField.withType(FieldDataType)"
  })
  void testWithType_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutablePhysicalSpecDefinitionField actualWithTypeResult =
        ImmutablePhysicalSpecDefinitionField.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .specDefinitionId(1L)
            .type(FieldDataType.DATETIME)
            .build()
            .withType(FieldDataType.DATE);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithTypeResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithTypeResult.lastUpdatedBy());
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(1, actualWithTypeResult.position());
    assertEquals(1L, actualWithTypeResult.specDefinitionId());
    assertEquals(FieldDataType.DATE, actualWithTypeResult.type());
    assertSame(ofResult, toLocalDateResult);
  }
}
