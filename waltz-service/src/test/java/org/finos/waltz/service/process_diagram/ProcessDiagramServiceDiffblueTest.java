package org.finos.waltz.service.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.process_diagram.ProcessDiagramDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagramAndEntities;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagramKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramServiceDiffblueTest {
  /**
   * Test {@link ProcessDiagramService#getByExternalId(String)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramService.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(dao.getDiagramByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableProcessDiagram.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    ProcessDiagram actualByExternalId = new ProcessDiagramService(dao).getByExternalId("42");

    // Assert
    verify(dao).getDiagramByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableProcessDiagram);
    assertEquals("2020-03-01", actualByExternalId.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualByExternalId.createdBy());
    assertEquals("Name", actualByExternalId.name());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("The characteristics of someone or something", actualByExternalId.description());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualByExternalId.diagramKind());
    assertSame(ofResult, actualByExternalId.createdAt().toLocalDate());
    assertSame(ofResult2, actualByExternalId.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector3() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector4() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector5() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given 'CHILDREN'; then calls joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenChildren_thenCallsJoiningEntityKind() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenHashSetAddActive() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenHashSetAddPending() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenHashSetAddPending2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenHashSetAddRemoved() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); given of 'ALL'; then calls joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_givenOfAll_thenCallsJoiningEntityKind() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_whenChangeInitiative() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByGenericSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_whenChangeInitiative2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_whenChangeUnit() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findByGenericSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findByGenericSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericSelector(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ProcessDiagramService.findByGenericSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByGenericSelector_whenFlowDiagram() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindByGenericSelectorResult =
        processDiagramService.findByGenericSelector(EntityKind.FLOW_DIAGRAM, selectionOptions);

    // Assert
    verify(dao).findByGenericSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericSelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector3() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'EXACT'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(selectionOptions);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    ProcessDiagramService processDiagramService = new ProcessDiagramService(dao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ProcessDiagram> actualFindBySelectorResult =
        processDiagramService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}.
   *
   * <ul>
   *   <li>Then return entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}
   */
  @Test
  @DisplayName("Test getDiagramAndEntitiesById(long); then return entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessDiagramAndEntities ProcessDiagramService.getDiagramAndEntitiesById(long)"
  })
  void testGetDiagramAndEntitiesById_thenReturnEntitiesEmpty() {
    // Arrange
    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findDiagramEntitiesById(anyLong())).thenReturn(new HashSet<>());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(dao.getDiagramById(anyLong()))
        .thenReturn(
            ImmutableProcessDiagram.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    ProcessDiagramAndEntities actualDiagramAndEntitiesById =
        new ProcessDiagramService(dao).getDiagramAndEntitiesById(1L);

    // Assert
    verify(dao).findDiagramEntitiesById(1L);
    verify(dao).getDiagramById(1L);
    ProcessDiagram diagramResult = actualDiagramAndEntitiesById.diagram();
    assertTrue(diagramResult instanceof ImmutableProcessDiagram);
    assertTrue(actualDiagramAndEntitiesById instanceof ImmutableProcessDiagramAndEntities);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", diagramResult.createdBy());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, diagramResult.diagramKind());
    assertTrue(actualDiagramAndEntitiesById.entities().isEmpty());
    assertSame(ofResult, diagramResult.createdAt().toLocalDate());
    assertSame(ofResult2, diagramResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}.
   *
   * <ul>
   *   <li>Then return entities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDiagramService#getDiagramAndEntitiesById(long)}
   */
  @Test
  @DisplayName("Test getDiagramAndEntitiesById(long); then return entities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessDiagramAndEntities ProcessDiagramService.getDiagramAndEntitiesById(long)"
  })
  void testGetDiagramAndEntitiesById_thenReturnEntitiesSizeIsOne() {
    // Arrange
    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();

    ImmutableProcessDiagramEntity.Builder diagramIdResult =
        ImmutableProcessDiagramEntity.builder().diagramId(1L);
    processDiagramEntitySet.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ProcessDiagramDao dao = mock(ProcessDiagramDao.class);
    when(dao.findDiagramEntitiesById(anyLong())).thenReturn(processDiagramEntitySet);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(dao.getDiagramById(anyLong()))
        .thenReturn(
            ImmutableProcessDiagram.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    ProcessDiagramAndEntities actualDiagramAndEntitiesById =
        new ProcessDiagramService(dao).getDiagramAndEntitiesById(1L);

    // Assert
    verify(dao).findDiagramEntitiesById(1L);
    verify(dao).getDiagramById(1L);
    ProcessDiagram diagramResult = actualDiagramAndEntitiesById.diagram();
    assertTrue(diagramResult instanceof ImmutableProcessDiagram);
    assertTrue(actualDiagramAndEntitiesById instanceof ImmutableProcessDiagramAndEntities);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", diagramResult.createdBy());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(1, actualDiagramAndEntitiesById.entities().size());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, diagramResult.diagramKind());
    assertSame(ofResult, diagramResult.createdAt().toLocalDate());
    assertSame(ofResult2, diagramResult.lastUpdatedAt().toLocalDate());
  }
}
