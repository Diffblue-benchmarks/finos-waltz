package org.finos.waltz.model.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement.Builder;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingReplacementDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualDecommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(createdAt)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLastUpdatedByResult =
        actualDecommissionIdResult
            .entityReference(entityReference)
            .id(1L)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01");
    Date plannedCommissionDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement =
        actualLastUpdatedByResult.plannedCommissionDate(plannedCommissionDate).build();

    // Assert
    assertEquals("2020-03-01", actualImmutableMeasurableRatingReplacement.lastUpdatedBy());
    assertEquals(
        "Jan 1, 2020 8:00am GMT+0100", actualImmutableMeasurableRatingReplacement.createdBy());
    assertEquals(1L, actualImmutableMeasurableRatingReplacement.decommissionId().longValue());
    assertEquals(1L, actualImmutableMeasurableRatingReplacement.id().longValue());
    assertSame(createdAt, actualImmutableMeasurableRatingReplacement.createdAt());
    assertSame(lastUpdatedAt, actualImmutableMeasurableRatingReplacement.lastUpdatedAt());
    assertSame(entityReference, actualImmutableMeasurableRatingReplacement.entityReference());
    assertSame(
        plannedCommissionDate, actualImmutableMeasurableRatingReplacement.plannedCommissionDate());
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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#decommissionId(Long)}.
   *
   * <p>Method under test: {@link Builder#decommissionId(Long)}
   */
  @Test
  @DisplayName("Test Builder decommissionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.decommissionId(Long)"})
  void testBuilderDecommissionId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualDecommissionIdResult = builderResult.decommissionId(1L);

    // Assert
    assertSame(builderResult, actualDecommissionIdResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement instance =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement =
        builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingReplacement);
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement2 =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingReplacement2);
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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement instance =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingReplacement);
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement2 =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingReplacement2);
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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

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
   * Test Builder {@link Builder#from(MeasurableRatingReplacement)} with {@code
   * MeasurableRatingReplacement}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingReplacement) with 'MeasurableRatingReplacement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingReplacement)"})
  void testBuilderFromWithMeasurableRatingReplacement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement instance =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingReplacement actualImmutableMeasurableRatingReplacement =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingReplacement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(Long)}.
   *
   * <p>Method under test: {@link Builder#id(Long)}
   */
  @Test
  @DisplayName("Test Builder id(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

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
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#plannedCommissionDate(Date)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plannedCommissionDate(Date)}
   */
  @Test
  @DisplayName("Test Builder plannedCommissionDate(Date); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedCommissionDate(Date)"})
  void testBuilderPlannedCommissionDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act
    Builder actualPlannedCommissionDateResult =
        builderResult.plannedCommissionDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(builderResult, actualPlannedCommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#copyOf(MeasurableRatingReplacement)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingReplacement#copyOf(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingReplacement); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.copyOf(MeasurableRatingReplacement)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement instance =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualCopyOfResult =
        ImmutableMeasurableRatingReplacement.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualCopyOfResult.decommissionId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualCopyOfResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableRatingReplacement.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    LocalDateTime actualCreatedAtResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}, and {@link
   * ImmutableMeasurableRatingReplacement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingReplacement#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingReplacement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement2 =
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingReplacement, immutableMeasurableRatingReplacement2);
    assertEquals(
        immutableMeasurableRatingReplacement.hashCode(),
        immutableMeasurableRatingReplacement2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}, and {@link
   * ImmutableMeasurableRatingReplacement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingReplacement#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingReplacement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingReplacement, immutableMeasurableRatingReplacement);
    int expectedHashCodeResult = immutableMeasurableRatingReplacement.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingReplacement.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("2020-03-01")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(2L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder decommissionIdResult2 =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult2 =
        decommissionIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingReplacement,
        lastUpdatedByResult2
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingReplacement.equals(Object)",
    "int ImmutableMeasurableRatingReplacement.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "Different type to ImmutableMeasurableRatingReplacement");
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CreatedAt is {@code null}.
   *   <li>Then return createdBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CreatedAt is 'null'; then return createdBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCreatedAtIsNull_thenReturnCreatedByIsJson() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDecommissionId(1L);
    json.setPlannedCommissionDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    ImmutableMeasurableRatingReplacement actualFromJsonResult =
        ImmutableMeasurableRatingReplacement.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals(1L, actualFromJsonResult.decommissionId().longValue());
    assertEquals(1L, actualFromJsonResult.id().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalDate is {@link LocalDate} with {@code 1970} and one and one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return createdAt toLocalDate is LocalDate with '1970' and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.fromJson(Json)"
  })
  void testFromJson_thenReturnCreatedAtToLocalDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDecommissionId(1L);
    json.setPlannedCommissionDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    ImmutableMeasurableRatingReplacement actualFromJsonResult =
        ImmutableMeasurableRatingReplacement.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals(1L, actualFromJsonResult.decommissionId().longValue());
    assertEquals(1L, actualFromJsonResult.id().longValue());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(json.createdAt, createdAtResult);
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingReplacement#toString()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#createdBy()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#decommissionId()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#entityReference()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#id()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#lastUpdatedBy()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#plannedCommissionDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableMeasurableRatingReplacement.createdBy()",
    "Long ImmutableMeasurableRatingReplacement.decommissionId()",
    "EntityReference ImmutableMeasurableRatingReplacement.entityReference()",
    "Long ImmutableMeasurableRatingReplacement.id()",
    "String ImmutableMeasurableRatingReplacement.lastUpdatedBy()",
    "Date ImmutableMeasurableRatingReplacement.plannedCommissionDate()",
    "String ImmutableMeasurableRatingReplacement.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    Date plannedCommissionDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult.plannedCommissionDate(plannedCommissionDate).build();

    // Act
    immutableMeasurableRatingReplacement.toString();
    String actualCreatedByResult = immutableMeasurableRatingReplacement.createdBy();
    Long actualDecommissionIdResult = immutableMeasurableRatingReplacement.decommissionId();
    EntityReference actualEntityReferenceResult =
        immutableMeasurableRatingReplacement.entityReference();
    Long actualIdResult = immutableMeasurableRatingReplacement.id();
    String actualLastUpdatedByResult = immutableMeasurableRatingReplacement.lastUpdatedBy();
    Date actualPlannedCommissionDateResult =
        immutableMeasurableRatingReplacement.plannedCommissionDate();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(1L, actualDecommissionIdResult.longValue());
    assertEquals(1L, actualIdResult.longValue());
    assertSame(plannedCommissionDate, actualPlannedCommissionDateResult);
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
   * Test Json {@link Json#decommissionId()}.
   *
   * <p>Method under test: {@link Json#decommissionId()}
   */
  @Test
  @DisplayName("Test Json decommissionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.decommissionId()"})
  void testJsonDecommissionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decommissionId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setCreatedBy(String)}
   *   <li>{@link Json#setDecommissionId(Long)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setId(Long)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setPlannedCommissionDate(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCreatedAt(LocalDateTime)",
    "void Json.setCreatedBy(String)",
    "void Json.setDecommissionId(Long)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setId(Long)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setPlannedCommissionDate(Date)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setDecommissionId(1L);
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setId(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult2.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setPlannedCommissionDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = actualJson.lastUpdatedAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals(1L, actualJson.decommissionId.longValue());
    assertEquals(1L, actualJson.id.longValue());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
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
  @MethodsUnderTest({"Long Json.id()"})
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
   * Test Json {@link Json#plannedCommissionDate()}.
   *
   * <p>Method under test: {@link Json#plannedCommissionDate()}
   */
  @Test
  @DisplayName("Test Json plannedCommissionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.plannedCommissionDate()"})
  void testJsonPlannedCommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedCommissionDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableRatingReplacement.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithCreatedAtResult =
        immutableMeasurableRatingReplacement.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingReplacement, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withCreatedBy(String)"
  })
  void testWithCreatedBy() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithCreatedByResult =
        immutableMeasurableRatingReplacement.withCreatedBy("42");

    // Assert
    assertSame(immutableMeasurableRatingReplacement, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement actualWithCreatedByResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withCreatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithCreatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithCreatedByResult.lastUpdatedBy());
    assertEquals("42", actualWithCreatedByResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithCreatedByResult.decommissionId().longValue());
    assertEquals(1L, actualWithCreatedByResult.id().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithCreatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithCreatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withDecommissionId(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withDecommissionId(Long)}
   */
  @Test
  @DisplayName("Test withDecommissionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withDecommissionId(Long)"
  })
  void testWithDecommissionId() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithDecommissionIdResult =
        immutableMeasurableRatingReplacement.withDecommissionId(1L);

    // Assert
    assertSame(immutableMeasurableRatingReplacement, actualWithDecommissionIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withDecommissionId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withDecommissionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDecommissionId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withDecommissionId(Long)"
  })
  void testWithDecommissionId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement actualWithDecommissionIdResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withDecommissionId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithDecommissionIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithDecommissionIdResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithDecommissionIdResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithDecommissionIdResult.id().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithDecommissionIdResult.decommissionId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithDecommissionIdResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithDecommissionIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingReplacement#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithEntityReferenceResult =
        immutableMeasurableRatingReplacement.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingReplacement, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withId(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withId(Long)"
  })
  void testWithId() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithIdResult =
        immutableMeasurableRatingReplacement.withId(1L);

    // Assert
    assertSame(immutableMeasurableRatingReplacement, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withId(Long)}
   */
  @Test
  @DisplayName(
      "Test withId(Long); when forty-two; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withId(Long)"
  })
  void testWithId_whenFortyTwo_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement actualWithIdResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithIdResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIdResult.decommissionId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingReplacement#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithLastUpdatedAtResult =
        immutableMeasurableRatingReplacement.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingReplacement, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithLastUpdatedByResult =
        immutableMeasurableRatingReplacement.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableMeasurableRatingReplacement, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingReplacement#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement actualWithLastUpdatedByResult =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithLastUpdatedByResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.decommissionId().longValue());
    assertEquals(1L, actualWithLastUpdatedByResult.id().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingReplacement#withPlannedCommissionDate(Date)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingReplacement#withPlannedCommissionDate(Date)}
   */
  @Test
  @DisplayName("Test withPlannedCommissionDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingReplacement ImmutableMeasurableRatingReplacement.withPlannedCommissionDate(Date)"
  })
  void testWithPlannedCommissionDate() {
    // Arrange
    Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableMeasurableRatingReplacement immutableMeasurableRatingReplacement =
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableMeasurableRatingReplacement actualWithPlannedCommissionDateResult =
        immutableMeasurableRatingReplacement.withPlannedCommissionDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableMeasurableRatingReplacement, actualWithPlannedCommissionDateResult);
  }
}
