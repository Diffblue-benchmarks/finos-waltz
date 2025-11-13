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
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#delimiter(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.delimiter(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualDelimiterResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(createdAt)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("42");
    Builder actualIdResult = actualDelimiterResult.delimiter(delimiter).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutablePhysicalSpecDefinition.version());
    assertEquals("2020-03-01", actualImmutablePhysicalSpecDefinition.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutablePhysicalSpecDefinition.createdBy());
    assertEquals("Provenance", actualImmutablePhysicalSpecDefinition.provenance());
    assertEquals(1L, actualImmutablePhysicalSpecDefinition.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualImmutablePhysicalSpecDefinition.status());
    assertEquals(
        PhysicalSpecDefinitionType.DELIMITED, actualImmutablePhysicalSpecDefinition.type());
    assertSame(createdAt, actualImmutablePhysicalSpecDefinition.createdAt());
    assertSame(lastUpdatedAt, actualImmutablePhysicalSpecDefinition.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#delimiter(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#delimiter(Optional)}
   */
  @Test
  @DisplayName("Test Builder delimiter(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.delimiter(Optional)"})
  void testBuilderDelimiterWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    Optional<String> delimiter = Optional.of("42");

    // Act
    Builder actualDelimiterResult = builderResult.delimiter(delimiter);

    // Assert
    assertSame(builderResult, actualDelimiterResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition =
        builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition);
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException());
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition);
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition2);
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition);
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition2);
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
   * Test Builder {@link Builder#from(PhysicalSpecDefinition)} with {@code PhysicalSpecDefinition}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinition) with 'PhysicalSpecDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinition)"})
  void testBuilderFromWithPhysicalSpecDefinition() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition);
    ImmutablePhysicalSpecDefinition actualImmutablePhysicalSpecDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#specificationId(long)}.
   *
   * <p>Method under test: {@link Builder#specificationId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specificationId(long)"})
  void testBuilderSpecificationId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualSpecificationIdResult = builderResult.specificationId(1L);

    // Assert
    assertSame(builderResult, actualSpecificationIdResult);
  }

  /**
   * Test Builder {@link Builder#status(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ReleaseLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#type(PhysicalSpecDefinitionType)}.
   *
   * <p>Method under test: {@link Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test Builder type(PhysicalSpecDefinitionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(PhysicalSpecDefinitionType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualTypeResult = builderResult.type(PhysicalSpecDefinitionType.DELIMITED);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinition.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#copyOf(PhysicalSpecDefinition)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#copyOf(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalSpecDefinition); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.copyOf(PhysicalSpecDefinition)"
  })
  void testCopyOf_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutablePhysicalSpecDefinition instance =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualCopyOfResult =
        ImmutablePhysicalSpecDefinition.copyOf(instance);

    // Assert
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#createdAt()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutablePhysicalSpecDefinition.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#delimiter()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#delimiter()}
   */
  @Test
  @DisplayName("Test delimiter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinition.delimiter()"})
  void testDelimiter() {
    // Arrange and Act
    Optional<String> actualDelimiterResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .delimiter();

    // Assert
    assertEquals("Delimiter", actualDelimiterResult.get());
    assertTrue(actualDelimiterResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinition#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition2 =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalSpecDefinition, immutablePhysicalSpecDefinition2);
    assertEquals(
        immutablePhysicalSpecDefinition.hashCode(), immutablePhysicalSpecDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinition#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalSpecDefinition, immutablePhysicalSpecDefinition);
    int expectedHashCodeResult = immutablePhysicalSpecDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecDefinition.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("2020-03-01")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Jan 1, 2020 8:00am GMT+0100")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(2L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("Jan 1, 2020 8:00am GMT+0100")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinition,
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinition.equals(Object)",
    "int ImmutablePhysicalSpecDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build(),
        "Different type to ImmutablePhysicalSpecDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinition#createdBy()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#lastUpdatedBy()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#specificationId()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#status()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#type()}
   *   <li>{@link ImmutablePhysicalSpecDefinition#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecDefinition.createdBy()",
    "String ImmutablePhysicalSpecDefinition.lastUpdatedBy()",
    "long ImmutablePhysicalSpecDefinition.specificationId()",
    "ReleaseLifecycleStatus ImmutablePhysicalSpecDefinition.status()",
    "PhysicalSpecDefinitionType ImmutablePhysicalSpecDefinition.type()",
    "String ImmutablePhysicalSpecDefinition.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    String actualCreatedByResult = immutablePhysicalSpecDefinition.createdBy();
    String actualLastUpdatedByResult = immutablePhysicalSpecDefinition.lastUpdatedBy();
    long actualSpecificationIdResult = immutablePhysicalSpecDefinition.specificationId();
    ReleaseLifecycleStatus actualStatusResult = immutablePhysicalSpecDefinition.status();
    PhysicalSpecDefinitionType actualTypeResult = immutablePhysicalSpecDefinition.type();

    // Assert
    assertEquals("1.0.2", immutablePhysicalSpecDefinition.version());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(1L, actualSpecificationIdResult);
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualStatusResult);
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
  }

  /**
   * Test Json {@link Json#delimiter()}.
   *
   * <p>Method under test: {@link Json#delimiter()}
   */
  @Test
  @DisplayName("Test Json delimiter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.delimiter()"})
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().delimiter());
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
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.version);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setSpecificationId(long)}.
   *
   * <p>Method under test: {@link Json#setSpecificationId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSpecificationId(long)"})
  void testJsonSetSpecificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#specificationId()}.
   *
   * <p>Method under test: {@link Json#specificationId()}
   */
  @Test
  @DisplayName("Test Json specificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.specificationId()"})
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specificationId());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
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
  @MethodsUnderTest({"PhysicalSpecDefinitionType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test Json {@link Json#version()}.
   *
   * <p>Method under test: {@link Json#version()}
   */
  @Test
  @DisplayName("Test Json version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.version()"})
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().version());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutablePhysicalSpecDefinition.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#provenance()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinition.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PhysicalSpecDefinition{id=1, createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, specificationId=1,"
            + " version=1.0.2, delimiter=Delimiter, type=DELIMITED, status=DRAFT}",
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithCreatedAtResult =
        immutablePhysicalSpecDefinition.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalSpecDefinition, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withCreatedBy(String)"
  })
  void testWithCreatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithCreatedByResult =
        immutablePhysicalSpecDefinition.withCreatedBy("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithCreatedByResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withCreatedBy("42");

    // Assert
    LocalDateTime createdAtResult = actualWithCreatedByResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithCreatedByResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withDelimiter(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withDelimiter(Optional)}
   */
  @Test
  @DisplayName("Test withDelimiter(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withDelimiter(Optional)"
  })
  void testWithDelimiterWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalSpecDefinition actualWithDelimiterResult =
        immutablePhysicalSpecDefinition.withDelimiter(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithDelimiterResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withDelimiter(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withDelimiter(Optional)}
   */
  @Test
  @DisplayName(
      "Test withDelimiter(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withDelimiter(Optional)"
  })
  void testWithDelimiterWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalSpecDefinition actualWithDelimiterResult =
        immutablePhysicalSpecDefinition.withDelimiter(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithDelimiterResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithDelimiterResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withDelimiter(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withDelimiter(String)}
   */
  @Test
  @DisplayName("Test withDelimiter(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withDelimiter(String)"
  })
  void testWithDelimiterWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithDelimiterResult =
        immutablePhysicalSpecDefinition.withDelimiter("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithDelimiterResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withDelimiter(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withDelimiter(String)}
   */
  @Test
  @DisplayName(
      "Test withDelimiter(String) with 'value'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withDelimiter(String)"
  })
  void testWithDelimiterWithValue_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithDelimiterResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withDelimiter("42");

    // Assert
    LocalDateTime createdAtResult = actualWithDelimiterResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithDelimiterResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinition actualWithIdResult =
        immutablePhysicalSpecDefinition.withId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalSpecDefinition actualWithIdResult =
        immutablePhysicalSpecDefinition.withId(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithIdResult = immutablePhysicalSpecDefinition.withId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithIdResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithLastUpdatedAtResult =
        immutablePhysicalSpecDefinition.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalSpecDefinition, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithLastUpdatedByResult =
        immutablePhysicalSpecDefinition.withLastUpdatedBy("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithLastUpdatedByResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime createdAtResult = actualWithLastUpdatedByResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("42")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithProvenanceResult =
        immutablePhysicalSpecDefinition.withProvenance("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withProvenance(String)"
  })
  void testWithProvenance_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithProvenanceResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime createdAtResult = actualWithProvenanceResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withSpecificationId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withSpecificationId(long)}
   */
  @Test
  @DisplayName("Test withSpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withSpecificationId(long)"
  })
  void testWithSpecificationId() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(42L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithSpecificationIdResult =
        immutablePhysicalSpecDefinition.withSpecificationId(42L);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithSpecificationIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withSpecificationId(long)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withSpecificationId(long)}
   */
  @Test
  @DisplayName(
      "Test withSpecificationId(long); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withSpecificationId(long)"
  })
  void testWithSpecificationId_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithSpecificationIdResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withSpecificationId(42L);

    // Assert
    LocalDateTime createdAtResult = actualWithSpecificationIdResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithSpecificationIdResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinition#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithStatusResult =
        immutablePhysicalSpecDefinition.withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinition#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(ReleaseLifecycleStatus); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithStatusResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    LocalDateTime createdAtResult = actualWithStatusResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithStatusResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withType(PhysicalSpecDefinitionType)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinition#withType(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test withType(PhysicalSpecDefinitionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withType(PhysicalSpecDefinitionType)"
  })
  void testWithType() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithTypeResult =
        immutablePhysicalSpecDefinition.withType(PhysicalSpecDefinitionType.DELIMITED);

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withVersion(String)"
  })
  void testWithVersion() {
    // Arrange
    ImmutablePhysicalSpecDefinition immutablePhysicalSpecDefinition =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("42")
            .build();

    // Act
    ImmutablePhysicalSpecDefinition actualWithVersionResult =
        immutablePhysicalSpecDefinition.withVersion("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinition, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinition#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinition#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinition ImmutablePhysicalSpecDefinition.withVersion(String)"
  })
  void testWithVersion_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinition actualWithVersionResult =
        ImmutablePhysicalSpecDefinition.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .delimiter("Delimiter")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .specificationId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withVersion("42");

    // Assert
    LocalDateTime createdAtResult = actualWithVersionResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", createdAtResult.toLocalDate().toString());
    LocalDateTime lastUpdatedAtResult = actualWithVersionResult.lastUpdatedAt();
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
  }
}
