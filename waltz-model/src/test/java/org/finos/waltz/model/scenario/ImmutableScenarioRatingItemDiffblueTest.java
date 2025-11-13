package org.finos.waltz.model.scenario;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.scenario.ImmutableScenarioRatingItem.Builder;
import org.finos.waltz.model.scenario.ImmutableScenarioRatingItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingItemDiffblueTest {
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
    "ImmutableScenarioRatingItem Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableScenarioRatingItem.builder();
    ImmutableEntityReference column =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualDescriptionResult =
        actualBuilderResult
            .column(column)
            .description("The characteristics of someone or something");
    ImmutableEntityReference item =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualRatingResult =
        actualDescriptionResult
            .item(item)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableEntityReference row =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem =
        actualRatingResult.row(row).scenarioId(1L).build();

    // Assert
    assertEquals("2020-03-01", actualImmutableScenarioRatingItem.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableScenarioRatingItem.description());
    assertEquals('A', actualImmutableScenarioRatingItem.rating());
    assertEquals(1L, actualImmutableScenarioRatingItem.scenarioId());
    assertSame(lastUpdatedAt, actualImmutableScenarioRatingItem.lastUpdatedAt());
    assertSame(column, actualImmutableScenarioRatingItem.column());
    assertSame(item, actualImmutableScenarioRatingItem.item());
    assertSame(row, actualImmutableScenarioRatingItem.row());
  }

  /**
   * Test Builder {@link Builder#column(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#column(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder column(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.column(EntityReference)"})
  void testBuilderColumn_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualColumnResult =
        builderResult.column(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualColumnResult);
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem instance =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableScenarioRatingItem);
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem2 = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingItem2);
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem instance =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableScenarioRatingItem);
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem2 = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingItem2);
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

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
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   *
   * <p>Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem instance =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableScenarioRatingItem);
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem2 = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingItem2);
  }

  /**
   * Test Builder {@link Builder#from(ScenarioRatingItem)} with {@code ScenarioRatingItem}.
   *
   * <p>Method under test: {@link Builder#from(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingItem) with 'ScenarioRatingItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingItem)"})
  void testBuilderFromWithScenarioRatingItem2() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description(null);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem instance =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableScenarioRatingItem);
    ImmutableScenarioRatingItem actualImmutableScenarioRatingItem2 = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingItem2);
  }

  /**
   * Test Builder {@link Builder#item(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#item(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder item(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.item(EntityReference)"})
  void testBuilderItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualItemResult =
        builderResult.item(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualItemResult);
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
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#rating(char)}.
   *
   * <p>Method under test: {@link Builder#rating(char)}
   */
  @Test
  @DisplayName("Test Builder rating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(char)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualRatingResult = builderResult.rating('A');

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test Builder {@link Builder#row(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#row(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder row(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.row(EntityReference)"})
  void testBuilderRow_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualRowResult =
        builderResult.row(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualRowResult);
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   *
   * <p>Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    // Act
    Builder actualScenarioIdResult = builderResult.scenarioId(1L);

    // Assert
    assertSame(builderResult, actualScenarioIdResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#copyOf(ScenarioRatingItem)}.
   *
   * <ul>
   *   <li>Then column return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#copyOf(ScenarioRatingItem)}
   */
  @Test
  @DisplayName("Test copyOf(ScenarioRatingItem); then column return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.copyOf(ScenarioRatingItem)"
  })
  void testCopyOf_thenColumnReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem instance =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualCopyOfResult = ImmutableScenarioRatingItem.copyOf(instance);

    // Assert
    EntityReference columnResult = actualCopyOfResult.column();
    assertTrue(columnResult instanceof ImmutableEntityReference);
    EntityReference itemResult = actualCopyOfResult.item();
    assertTrue(itemResult instanceof ImmutableEntityReference);
    EntityReference rowResult = actualCopyOfResult.row();
    assertTrue(rowResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", columnResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, columnResult.id());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertEquals(EntityKind.ALL, columnResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnResult.entityLifecycleStatus());
    assertEquals(columnResult, itemResult);
    assertEquals(columnResult, rowResult);
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}, and {@link
   * ImmutableScenarioRatingItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingItem#equals(Object)}
   *   <li>{@link ImmutableScenarioRatingItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem2 =
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableScenarioRatingItem, immutableScenarioRatingItem2);
    assertEquals(immutableScenarioRatingItem.hashCode(), immutableScenarioRatingItem2.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}, and {@link
   * ImmutableScenarioRatingItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingItem#equals(Object)}
   *   <li>{@link ImmutableScenarioRatingItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableScenarioRatingItem, immutableScenarioRatingItem);
    int expectedHashCodeResult = immutableScenarioRatingItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableScenarioRatingItem.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('\u0001');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(2L)
            .build();

    Builder builderResult2 = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult2 =
        builderResult2
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult2 =
        descriptionResult2
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingItem,
        ratingResult2
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingItem.equals(Object)",
    "int ImmutableScenarioRatingItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act and Assert
    assertNotEquals(
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build(),
        "Different type to ImmutableScenarioRatingItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingItem#toString()}
   *   <li>{@link ImmutableScenarioRatingItem#column()}
   *   <li>{@link ImmutableScenarioRatingItem#description()}
   *   <li>{@link ImmutableScenarioRatingItem#item()}
   *   <li>{@link ImmutableScenarioRatingItem#lastUpdatedAt()}
   *   <li>{@link ImmutableScenarioRatingItem#lastUpdatedBy()}
   *   <li>{@link ImmutableScenarioRatingItem#rating()}
   *   <li>{@link ImmutableScenarioRatingItem#row()}
   *   <li>{@link ImmutableScenarioRatingItem#scenarioId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableScenarioRatingItem.column()",
    "String ImmutableScenarioRatingItem.description()",
    "EntityReference ImmutableScenarioRatingItem.item()",
    "LocalDateTime ImmutableScenarioRatingItem.lastUpdatedAt()",
    "String ImmutableScenarioRatingItem.lastUpdatedBy()",
    "char ImmutableScenarioRatingItem.rating()",
    "EntityReference ImmutableScenarioRatingItem.row()",
    "long ImmutableScenarioRatingItem.scenarioId()",
    "String ImmutableScenarioRatingItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    String actualToStringResult = immutableScenarioRatingItem.toString();
    EntityReference actualColumnResult = immutableScenarioRatingItem.column();
    String actualDescriptionResult = immutableScenarioRatingItem.description();
    EntityReference actualItemResult = immutableScenarioRatingItem.item();
    LocalDateTime actualLastUpdatedAtResult = immutableScenarioRatingItem.lastUpdatedAt();
    String actualLastUpdatedByResult = immutableScenarioRatingItem.lastUpdatedBy();
    char actualRatingResult = immutableScenarioRatingItem.rating();
    EntityReference actualRowResult = immutableScenarioRatingItem.row();

    // Assert
    assertTrue(actualColumnResult instanceof ImmutableEntityReference);
    assertTrue(actualItemResult instanceof ImmutableEntityReference);
    assertTrue(actualRowResult instanceof ImmutableEntityReference);
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "ScenarioRatingItem{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, scenarioId=1, rating=A,"
            + " item=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, row=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, column=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals('A', actualRatingResult);
    assertEquals(1L, immutableScenarioRatingItem.scenarioId());
    assertEquals(actualColumnResult, actualItemResult);
    assertEquals(actualColumnResult, actualRowResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#column()}.
   *
   * <p>Method under test: {@link Json#column()}
   */
  @Test
  @DisplayName("Test Json column()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.column()"})
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().column());
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setColumn(EntityReference)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setItem(EntityReference)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setRow(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setColumn(EntityReference)",
    "void Json.setDescription(String)",
    "void Json.setItem(EntityReference)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setRow(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setColumn(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setItem(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setRow(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#item()}.
   *
   * <p>Method under test: {@link Json#item()}
   */
  @Test
  @DisplayName("Test Json item()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.item()"})
  void testJsonItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().item());
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
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#row()}.
   *
   * <p>Method under test: {@link Json#row()}
   */
  @Test
  @DisplayName("Test Json row()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.row()"})
  void testJsonRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().row());
  }

  /**
   * Test Json {@link Json#scenarioId()}.
   *
   * <p>Method under test: {@link Json#scenarioId()}
   */
  @Test
  @DisplayName("Test Json scenarioId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.scenarioId()"})
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenarioId());
  }

  /**
   * Test Json {@link Json#setRating(char)}.
   *
   * <p>Method under test: {@link Json#setRating(char)}
   */
  @Test
  @DisplayName("Test Json setRating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRating(char)"})
  void testJsonSetRating() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Test Json {@link Json#setScenarioId(long)}.
   *
   * <p>Method under test: {@link Json#setScenarioId(long)}
   */
  @Test
  @DisplayName("Test Json setScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setScenarioId(long)"})
  void testJsonSetScenarioId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withColumn(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withColumn(EntityReference)}
   */
  @Test
  @DisplayName("Test withColumn(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withColumn(EntityReference)"
  })
  void testWithColumn() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithColumnResult =
        immutableScenarioRatingItem.withColumn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableScenarioRatingItem, actualWithColumnResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithDescriptionResult =
        immutableScenarioRatingItem.withDescription("42");

    // Assert
    assertEquals(immutableScenarioRatingItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("42");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithDescriptionResult =
        immutableScenarioRatingItem.withDescription("42");

    // Assert
    assertSame(immutableScenarioRatingItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withItem(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withItem(EntityReference)}
   */
  @Test
  @DisplayName("Test withItem(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withItem(EntityReference)"
  })
  void testWithItem() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithItemResult =
        immutableScenarioRatingItem.withItem(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableScenarioRatingItem, actualWithItemResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithLastUpdatedAtResult =
        immutableScenarioRatingItem.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableScenarioRatingItem, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithLastUpdatedByResult =
        immutableScenarioRatingItem.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableScenarioRatingItem, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then column return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then column return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenColumnReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act
    ImmutableScenarioRatingItem actualWithLastUpdatedByResult =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference columnResult = actualWithLastUpdatedByResult.column();
    assertTrue(columnResult instanceof ImmutableEntityReference);
    EntityReference itemResult = actualWithLastUpdatedByResult.item();
    assertTrue(itemResult instanceof ImmutableEntityReference);
    EntityReference rowResult = actualWithLastUpdatedByResult.row();
    assertTrue(rowResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", columnResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals('A', actualWithLastUpdatedByResult.rating());
    assertEquals(1L, columnResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.scenarioId());
    assertEquals(EntityKind.ALL, columnResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnResult.entityLifecycleStatus());
    assertEquals(columnResult, itemResult);
    assertEquals(columnResult, rowResult);
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withRating(char)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withRating(char)"})
  void testWithRating() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithRatingResult =
        immutableScenarioRatingItem.withRating('A');

    // Assert
    assertSame(immutableScenarioRatingItem, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withRating(char)}.
   *
   * <ul>
   *   <li>Then column return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char); then column return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withRating(char)"})
  void testWithRating_thenColumnReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('\u0000');

    // Act
    ImmutableScenarioRatingItem actualWithRatingResult =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build()
            .withRating('A');

    // Assert
    EntityReference columnResult = actualWithRatingResult.column();
    assertTrue(columnResult instanceof ImmutableEntityReference);
    EntityReference itemResult = actualWithRatingResult.item();
    assertTrue(itemResult instanceof ImmutableEntityReference);
    EntityReference rowResult = actualWithRatingResult.row();
    assertTrue(rowResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithRatingResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", columnResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingResult.description());
    assertEquals('A', actualWithRatingResult.rating());
    assertEquals(1L, columnResult.id());
    assertEquals(1L, actualWithRatingResult.scenarioId());
    assertEquals(EntityKind.ALL, columnResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnResult.entityLifecycleStatus());
    assertEquals(columnResult, itemResult);
    assertEquals(columnResult, rowResult);
    assertSame(ofResult, actualWithRatingResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withRow(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withRow(EntityReference)}
   */
  @Test
  @DisplayName("Test withRow(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withRow(EntityReference)"
  })
  void testWithRow() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithRowResult =
        immutableScenarioRatingItem.withRow(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableScenarioRatingItem, actualWithRowResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withScenarioId(long)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withScenarioId(long)"
  })
  void testWithScenarioId() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');
    ImmutableScenarioRatingItem immutableScenarioRatingItem =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(42L)
            .build();

    // Act
    ImmutableScenarioRatingItem actualWithScenarioIdResult =
        immutableScenarioRatingItem.withScenarioId(42L);

    // Assert
    assertSame(immutableScenarioRatingItem, actualWithScenarioIdResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingItem#withScenarioId(long)}.
   *
   * <ul>
   *   <li>Then column return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingItem#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long); then column return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingItem ImmutableScenarioRatingItem.withScenarioId(long)"
  })
  void testWithScenarioId_thenColumnReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingItem.builder();

    Builder descriptionResult =
        builderResult
            .column(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder ratingResult =
        descriptionResult
            .item(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .rating('A');

    // Act
    ImmutableScenarioRatingItem actualWithScenarioIdResult =
        ratingResult
            .row(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .scenarioId(1L)
            .build()
            .withScenarioId(42L);

    // Assert
    EntityReference columnResult = actualWithScenarioIdResult.column();
    assertTrue(columnResult instanceof ImmutableEntityReference);
    EntityReference itemResult = actualWithScenarioIdResult.item();
    assertTrue(itemResult instanceof ImmutableEntityReference);
    EntityReference rowResult = actualWithScenarioIdResult.row();
    assertTrue(rowResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithScenarioIdResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", columnResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithScenarioIdResult.description());
    assertEquals('A', actualWithScenarioIdResult.rating());
    assertEquals(1L, columnResult.id());
    assertEquals(42L, actualWithScenarioIdResult.scenarioId());
    assertEquals(EntityKind.ALL, columnResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnResult.entityLifecycleStatus());
    assertEquals(columnResult, itemResult);
    assertEquals(columnResult, rowResult);
    assertSame(ofResult, actualWithScenarioIdResult.lastUpdatedAt().toLocalDate());
  }
}
