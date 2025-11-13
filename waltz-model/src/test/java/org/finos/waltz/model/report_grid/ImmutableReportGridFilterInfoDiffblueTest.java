package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridFilterInfo.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFilterInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFilterInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGridFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllGridFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGridFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllGridFilters(Iterable)"})
  void testBuilderAddAllGridFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualAddAllGridFiltersResult = builderResult.addAllGridFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllGridFiltersResult);
  }

  /**
   * Test Builder {@link Builder#addGridFilters(GridFilter)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableGridFilter.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGridFilters(GridFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder addGridFilters(GridFilter) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGridFilters(GridFilter)"})
  void testBuilderAddGridFiltersWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualAddGridFiltersResult =
        builderResult.addGridFilters(new ImmutableGridFilter.Json());

    // Assert
    assertSame(builderResult, actualAddGridFiltersResult);
  }

  /**
   * Test Builder {@link Builder#addGridFilters(GridFilter[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableGridFilter.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGridFilters(GridFilter[])}
   */
  @Test
  @DisplayName(
      "Test Builder addGridFilters(GridFilter[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGridFilters(GridFilter[])"})
  void testBuilderAddGridFiltersWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualAddGridFiltersResult =
        builderResult.addGridFilters(new ImmutableGridFilter.Json());

    // Assert
    assertSame(builderResult, actualAddGridFiltersResult);
  }

  /**
   * Test Builder {@link Builder#appGroupId(Long)}.
   *
   * <p>Method under test: {@link Builder#appGroupId(Long)}
   */
  @Test
  @DisplayName("Test Builder appGroupId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appGroupId(Long)"})
  void testBuilderAppGroupId() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualAppGroupIdResult = builderResult.appGroupId(1L);

    // Assert
    assertSame(builderResult, actualAppGroupIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridFilterInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAppGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);
    ImmutableReportGridDefinition gridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    Builder actualGridDefinitionResult = actualAppGroupIdResult.gridDefinition(gridDefinition);
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableReportGridFilterInfo actualImmutableReportGridFilterInfo =
        actualGridDefinitionResult.idSelectionOptions(idSelectionOptions).build();

    // Assert
    assertEquals(1L, actualImmutableReportGridFilterInfo.appGroupId().longValue());
    assertTrue(actualImmutableReportGridFilterInfo.gridFilters().isEmpty());
    assertSame(idSelectionOptions, actualImmutableReportGridFilterInfo.idSelectionOptions());
    assertSame(gridDefinition, actualImmutableReportGridFilterInfo.gridDefinition());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo instance =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridFilterInfo actualImmutableReportGridFilterInfo = builderResult.build();
    assertEquals(instance, actualImmutableReportGridFilterInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFilterInfo)}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFilterInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFilterInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    Builder builderResult2 = ImmutableReportGridFilterInfo.builder();
    builderResult2.addGridFilters(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());

    Builder appGroupIdResult = builderResult2.appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo instance =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridFilterInfo actualImmutableReportGridFilterInfo = builderResult.build();
    assertEquals(instance, actualImmutableReportGridFilterInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#gridDefinition(ReportGridDefinition)}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#gridDefinition(ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder gridDefinition(ReportGridDefinition); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gridDefinition(ReportGridDefinition)"})
  void testBuilderGridDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualGridDefinitionResult =
        builderResult.gridDefinition(new ImmutableReportGridDefinition.Json());

    // Assert
    assertSame(builderResult, actualGridDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#gridFilters(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#gridFilters(Iterable)}
   */
  @Test
  @DisplayName("Test Builder gridFilters(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gridFilters(Iterable)"})
  void testBuilderGridFilters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    // Act
    Builder actualGridFiltersResult = builderResult.gridFilters(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualGridFiltersResult);
  }

  /**
   * Test Builder {@link Builder#idSelectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.idSelectionOptions(IdSelectionOptions)"})
  void testBuilderIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Builder actualIdSelectionOptionsResult =
        builderResult.idSelectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#copyOf(ReportGridFilterInfo)}.
   *
   * <ul>
   *   <li>Then idSelectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#copyOf(ReportGridFilterInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridFilterInfo); then idSelectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.copyOf(ReportGridFilterInfo)"
  })
  void testCopyOf_thenIdSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo instance =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableReportGridFilterInfo actualCopyOfResult =
        ImmutableReportGridFilterInfo.copyOf(instance);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualCopyOfResult.idSelectionOptions();
    assertTrue(idSelectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(idSelectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    ReportGridDefinition gridDefinitionResult2 = actualCopyOfResult.gridDefinition();
    assertTrue(gridDefinitionResult2 instanceof ImmutableReportGridDefinition);
    assertEquals("2020-03-01", gridDefinitionResult2.lastUpdatedBy());
    assertEquals("Name", gridDefinitionResult2.name());
    assertEquals("Provenance", gridDefinitionResult2.provenance());
    assertEquals(
        "The characteristics of someone or something", gridDefinitionResult2.description());
    assertEquals(1L, actualCopyOfResult.appGroupId().longValue());
    assertEquals(EntityKind.ALL, gridDefinitionResult2.subjectKind());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertEquals(ReportGridKind.PUBLIC, gridDefinitionResult2.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        gridDefinitionResult2.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualCopyOfResult.gridFilters().isEmpty());
    assertSame(derivedColumnDefinitionsResult, gridDefinitionResult2.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}, and {@link
   * ImmutableReportGridFilterInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFilterInfo#equals(Object)}
   *   <li>{@link ImmutableReportGridFilterInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder appGroupIdResult2 = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult2 =
        appGroupIdResult2.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo2 =
        gridDefinitionResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableReportGridFilterInfo, immutableReportGridFilterInfo2);
    assertEquals(
        immutableReportGridFilterInfo.hashCode(), immutableReportGridFilterInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}, and {@link
   * ImmutableReportGridFilterInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFilterInfo#equals(Object)}
   *   <li>{@link ImmutableReportGridFilterInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableReportGridFilterInfo, immutableReportGridFilterInfo);
    int expectedHashCodeResult = immutableReportGridFilterInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridFilterInfo.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridFilterInfo.builder();
    builderResult.addGridFilters(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());

    Builder appGroupIdResult = builderResult.appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder appGroupIdResult2 = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult2 =
        appGroupIdResult2.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableReportGridFilterInfo,
        gridDefinitionResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(2L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder appGroupIdResult2 = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult2 =
        appGroupIdResult2.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableReportGridFilterInfo,
        gridDefinitionResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition gridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    Builder gridDefinitionResult =
        ImmutableReportGridFilterInfo.builder().appGroupId(1L).gridDefinition(gridDefinition);

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult2 =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableReportGridFilterInfo,
        gridDefinitionResult2
            .idSelectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFilterInfo.equals(Object)",
    "int ImmutableReportGridFilterInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        "Different type to ImmutableReportGridFilterInfo");
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) GridFilters is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) GridFilters is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonGridFiltersIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAppGroupId(1L);
    json.setGridDefinition(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setGridFilters(new HashSet<>());

    // Act
    ImmutableReportGridFilterInfo actualFromJsonResult =
        ImmutableReportGridFilterInfo.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.appGroupId().longValue());
    assertTrue(actualFromJsonResult.gridFilters().isEmpty());
    ReportGridDefinition expectedGridDefinitionResult = json.gridDefinition;
    assertSame(expectedGridDefinitionResult, actualFromJsonResult.gridDefinition());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return gridFilters is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return gridFilters is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.fromJson(Json)"})
  void testFromJson_thenReturnGridFiltersIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<GridFilter> gridFilters = new LinkedHashSet<>();
    gridFilters.add(
        ImmutableGridFilter.builder()
            .columnDefinitionId(2L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());
    gridFilters.add(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());

    Json json = new Json();
    json.setAppGroupId(1L);
    json.setGridDefinition(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setGridFilters(gridFilters);

    // Act
    ImmutableReportGridFilterInfo actualFromJsonResult =
        ImmutableReportGridFilterInfo.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.appGroupId().longValue());
    assertEquals(gridFilters, actualFromJsonResult.gridFilters());
    ReportGridDefinition expectedGridDefinitionResult = json.gridDefinition;
    assertSame(expectedGridDefinitionResult, actualFromJsonResult.gridDefinition());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return gridFilters size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return gridFilters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.fromJson(Json)"})
  void testFromJson_thenReturnGridFiltersSizeIsOne() {
    // Arrange
    LinkedHashSet<GridFilter> gridFilters = new LinkedHashSet<>();
    gridFilters.add(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());

    Json json = new Json();
    json.setAppGroupId(1L);
    json.setGridDefinition(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setGridFilters(gridFilters);

    // Act
    ImmutableReportGridFilterInfo actualFromJsonResult =
        ImmutableReportGridFilterInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.gridFilters().size());
    assertEquals(1L, actualFromJsonResult.appGroupId().longValue());
    ReportGridDefinition expectedGridDefinitionResult = json.gridDefinition;
    assertSame(expectedGridDefinitionResult, actualFromJsonResult.gridDefinition());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) GridFilters is {@code null}.
   *   <li>Then return gridFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) GridFilters is 'null'; then return gridFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.fromJson(Json)"})
  void testFromJson_whenJsonGridFiltersIsNull_thenReturnGridFiltersEmpty() {
    // Arrange
    Json json = new Json();
    json.setAppGroupId(1L);
    json.setGridDefinition(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setIdSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setGridFilters(null);

    // Act
    ImmutableReportGridFilterInfo actualFromJsonResult =
        ImmutableReportGridFilterInfo.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.appGroupId().longValue());
    assertTrue(actualFromJsonResult.gridFilters().isEmpty());
    ReportGridDefinition expectedGridDefinitionResult = json.gridDefinition;
    assertSame(expectedGridDefinitionResult, actualFromJsonResult.gridDefinition());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFilterInfo#toString()}
   *   <li>{@link ImmutableReportGridFilterInfo#appGroupId()}
   *   <li>{@link ImmutableReportGridFilterInfo#gridDefinition()}
   *   <li>{@link ImmutableReportGridFilterInfo#gridFilters()}
   *   <li>{@link ImmutableReportGridFilterInfo#idSelectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableReportGridFilterInfo.appGroupId()",
    "ReportGridDefinition ImmutableReportGridFilterInfo.gridDefinition()",
    "Set ImmutableReportGridFilterInfo.gridFilters()",
    "IdSelectionOptions ImmutableReportGridFilterInfo.idSelectionOptions()",
    "String ImmutableReportGridFilterInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableReportGridFilterInfo.toString();
    Long actualAppGroupIdResult = immutableReportGridFilterInfo.appGroupId();
    ReportGridDefinition actualGridDefinitionResult =
        immutableReportGridFilterInfo.gridDefinition();
    Set<GridFilter> actualGridFiltersResult = immutableReportGridFilterInfo.gridFilters();

    // Assert
    assertTrue(
        immutableReportGridFilterInfo.idSelectionOptions() instanceof ImmutableIdSelectionOptions);
    assertTrue(actualGridDefinitionResult instanceof ImmutableReportGridDefinition);
    assertEquals(
        "ReportGridFilterInfo{appGroupId=1, gridDefinition=ReportGridDefinition{id=1, name=Name, lastUpdatedAt"
            + "=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, externalId=42, fixedColumnDefinitions=[],"
            + " derivedColumnDefinitions=[], subjectKind=ALL, kind=PUBLIC}, idSelectionOptions=IdSelectionOptions"
            + "{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT,"
            + " joiningEntityKind=ALL, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}},"
            + " gridFilters=[]}",
        actualToStringResult);
    assertEquals(1L, actualAppGroupIdResult.longValue());
    assertTrue(actualGridFiltersResult.isEmpty());
  }

  /**
   * Test Json {@link Json#appGroupId()}.
   *
   * <p>Method under test: {@link Json#appGroupId()}
   */
  @Test
  @DisplayName("Test Json appGroupId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.appGroupId()"})
  void testJsonAppGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appGroupId());
  }

  /**
   * Test Json {@link Json#gridDefinition()}.
   *
   * <p>Method under test: {@link Json#gridDefinition()}
   */
  @Test
  @DisplayName("Test Json gridDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition Json.gridDefinition()"})
  void testJsonGridDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridDefinition());
  }

  /**
   * Test Json {@link Json#gridFilters()}.
   *
   * <p>Method under test: {@link Json#gridFilters()}
   */
  @Test
  @DisplayName("Test Json gridFilters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.gridFilters()"})
  void testJsonGridFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridFilters());
  }

  /**
   * Test Json {@link Json#idSelectionOptions()}.
   *
   * <p>Method under test: {@link Json#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test Json idSelectionOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.idSelectionOptions()"})
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().idSelectionOptions());
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
    assertNull(actualJson.appGroupId);
    assertNull(actualJson.idSelectionOptions);
    assertNull(actualJson.gridDefinition);
    assertTrue(actualJson.gridFilters.isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#withAppGroupId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#withAppGroupId(Long)}
   */
  @Test
  @DisplayName("Test withAppGroupId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.withAppGroupId(Long)"
  })
  void testWithAppGroupId() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableReportGridFilterInfo actualWithAppGroupIdResult =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .withAppGroupId(42L);

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualWithAppGroupIdResult.idSelectionOptions();
    assertTrue(idSelectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(idSelectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    ReportGridDefinition gridDefinitionResult2 = actualWithAppGroupIdResult.gridDefinition();
    assertTrue(gridDefinitionResult2 instanceof ImmutableReportGridDefinition);
    assertEquals("2020-03-01", gridDefinitionResult2.lastUpdatedBy());
    assertEquals("Name", gridDefinitionResult2.name());
    assertEquals("Provenance", gridDefinitionResult2.provenance());
    assertEquals(
        "The characteristics of someone or something", gridDefinitionResult2.description());
    assertEquals(42L, actualWithAppGroupIdResult.appGroupId().longValue());
    assertEquals(EntityKind.ALL, gridDefinitionResult2.subjectKind());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertEquals(ReportGridKind.PUBLIC, gridDefinitionResult2.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        gridDefinitionResult2.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualWithAppGroupIdResult.gridFilters().isEmpty());
    assertSame(derivedColumnDefinitionsResult, gridDefinitionResult2.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#withGridDefinition(ReportGridDefinition)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFilterInfo#withGridDefinition(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test withGridDefinition(ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.withGridDefinition(ReportGridDefinition)"
  })
  void testWithGridDefinition() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableReportGridFilterInfo actualWithGridDefinitionResult =
        immutableReportGridFilterInfo.withGridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableReportGridFilterInfo, actualWithGridDefinitionResult);
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#withGridFilters(GridFilter[])} with {@code
   * GridFilter[]}.
   *
   * <p>Method under test: {@link ImmutableReportGridFilterInfo#withGridFilters(GridFilter[])}
   */
  @Test
  @DisplayName("Test withGridFilters(GridFilter[]) with 'GridFilter[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.withGridFilters(GridFilter[])"
  })
  void testWithGridFiltersWithGridFilter() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableReportGridFilterInfo actualWithGridFiltersResult =
        immutableReportGridFilterInfo.withGridFilters(
            ImmutableGridFilter.builder()
                .columnDefinitionId(1L)
                .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
                .build());

    // Assert
    IdSelectionOptions idSelectionOptionsResult = actualWithGridFiltersResult.idSelectionOptions();
    assertTrue(idSelectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(idSelectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    ReportGridDefinition gridDefinitionResult2 = actualWithGridFiltersResult.gridDefinition();
    assertTrue(gridDefinitionResult2 instanceof ImmutableReportGridDefinition);
    assertEquals("2020-03-01", gridDefinitionResult2.lastUpdatedBy());
    assertEquals("Name", gridDefinitionResult2.name());
    assertEquals("Provenance", gridDefinitionResult2.provenance());
    assertEquals(
        "The characteristics of someone or something", gridDefinitionResult2.description());
    assertEquals(1, actualWithGridFiltersResult.gridFilters().size());
    assertEquals(1L, actualWithGridFiltersResult.appGroupId().longValue());
    assertEquals(EntityKind.ALL, gridDefinitionResult2.subjectKind());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptionsResult.scope());
    assertEquals(ReportGridKind.PUBLIC, gridDefinitionResult2.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        gridDefinitionResult2.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertTrue(idSelectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertSame(derivedColumnDefinitionsResult, gridDefinitionResult2.fixedColumnDefinitions());
  }

  /**
   * Test {@link ImmutableReportGridFilterInfo#withIdSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFilterInfo#withIdSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withIdSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFilterInfo ImmutableReportGridFilterInfo.withIdSelectionOptions(IdSelectionOptions)"
  })
  void testWithIdSelectionOptions() {
    // Arrange
    Builder appGroupIdResult = ImmutableReportGridFilterInfo.builder().appGroupId(1L);

    Builder gridDefinitionResult =
        appGroupIdResult.gridDefinition(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableReportGridFilterInfo immutableReportGridFilterInfo =
        gridDefinitionResult
            .idSelectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableReportGridFilterInfo actualWithIdSelectionOptionsResult =
        immutableReportGridFilterInfo.withIdSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableReportGridFilterInfo, actualWithIdSelectionOptionsResult);
  }
}
