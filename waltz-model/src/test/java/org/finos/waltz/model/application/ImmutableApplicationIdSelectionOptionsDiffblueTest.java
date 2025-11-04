package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.junit.jupiter.api.Test;

class ImmutableApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationKinds() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationKinds2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationKinds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityLifecycleStatuses() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityLifecycleStatuses2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addApplicationKinds(ApplicationKind)}
   */
  @Test
  void testBuilderAddApplicationKinds() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addApplicationKinds(ApplicationKind[])}
   */
  @Test
  void testBuilderAddApplicationKinds2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#applicationKinds(Iterable)}
   */
  @Test
  void testBuilderApplicationKinds() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#applicationKinds(Iterable)}
   */
  @Test
  void testBuilderApplicationKinds2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKinds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderEntityLifecycleStatuses() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderEntityLifecycleStatuses2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    when(instance.entityLifecycleStatuses()).thenThrow(new IllegalStateException("instance"));
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatuses();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    ImmutableApplicationIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    ImmutableApplicationIdSelectionOptions buildResult = builderResult.build();
    Set<ApplicationKind> applicationKindsResult = buildResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    when(instance.scope()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.entityLifecycleStatuses()).thenThrow(new IllegalStateException("instance"));
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatuses();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenReturn(new HashSet<>());
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    ImmutableApplicationIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
    ImmutableApplicationIdSelectionOptions buildResult = builderResult.build();
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(buildResult.applicationKinds().isEmpty());
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenThrow(new IllegalStateException("instance"));
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenReturn(applicationKindSet);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    ImmutableApplicationIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
    ImmutableApplicationIdSelectionOptions buildResult = builderResult.build();
    Set<ApplicationKind> applicationKindsResult = buildResult.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Builder#scope(HierarchyQueryScope)}
   */
  @Test
  void testBuilderScope() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scope(HierarchyQueryScope.EXACT));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions#copyOf(ApplicationIdSelectionOptions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenReturn(new HashSet<>());
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    ImmutableApplicationIdSelectionOptions actualCopyOfResult = ImmutableApplicationIdSelectionOptions.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
    SelectionFilters filtersResult = actualCopyOfResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.applicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions#copyOf(ApplicationIdSelectionOptions)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenReturn(applicationKindSet);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    ImmutableApplicationIdSelectionOptions actualCopyOfResult = ImmutableApplicationIdSelectionOptions.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
    SelectionFilters filtersResult = actualCopyOfResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<ApplicationKind> applicationKindsResult = actualCopyOfResult.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions#fromJson(ImmutableApplicationIdSelectionOptions.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();
    json.setScope(HierarchyQueryScope.EXACT);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableApplicationIdSelectionOptions actualFromJsonResult = ImmutableApplicationIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualFromJsonResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions#fromJson(ImmutableApplicationIdSelectionOptions.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();
    json.setFilters(SelectionFilters.NO_FILTERS);
    json.setScope(HierarchyQueryScope.EXACT);
    json.setEntityReference(mock(EntityReference.class));

    // Act
    ImmutableApplicationIdSelectionOptions actualFromJsonResult = ImmutableApplicationIdSelectionOptions.fromJson(json);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualFromJsonResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    SelectionFilters expectedFiltersResult = json.filters;
    assertSame(expectedFiltersResult, actualFromJsonResult.filters());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#applicationKinds()}
   */
  @Test
  void testJsonApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).applicationKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#entityLifecycleStatuses()}
   */
  @Test
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).entityLifecycleStatuses());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#filters()}
   */
  @Test
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).filters());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#joiningEntityKind()}
   */
  @Test
  void testJsonJoiningEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).joiningEntityKind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationIdSelectionOptions.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationIdSelectionOptions.Json actualJson = new ImmutableApplicationIdSelectionOptions.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.scope);
    assertNull(actualJson.filters);
    assertFalse(actualJson.joiningEntityKind.isPresent());
    assertFalse(actualJson.applicationKindsIsSet);
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.applicationKinds.isEmpty());
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#scope()}
   */
  @Test
  void testJsonScope() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationIdSelectionOptions.Json()).scope());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setApplicationKinds(Set)}
   */
  @Test
  void testJsonSetApplicationKinds() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    // Act
    json.setApplicationKinds(new HashSet<>());

    // Assert
    assertTrue(json.applicationKinds.isEmpty());
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setApplicationKinds(Set)}
   */
  @Test
  void testJsonSetApplicationKinds2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    // Act
    json.setApplicationKinds(null);

    // Assert
    assertNull(json.applicationKinds);
    assertFalse(json.applicationKindsIsSet);
    assertTrue(json.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setApplicationKinds(Set)}
   */
  @Test
  void testJsonSetApplicationKinds3() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    json.setApplicationKinds(applicationKinds);

    // Assert
    Set<ApplicationKind> applicationKindSet = json.applicationKinds;
    assertEquals(1, applicationKindSet.size());
    assertTrue(applicationKindSet.contains(ApplicationKind.IN_HOUSE));
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setApplicationKinds(Set)}
   */
  @Test
  void testJsonSetApplicationKinds4() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.INTERNALLY_HOSTED);
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    json.setApplicationKinds(applicationKinds);

    // Assert
    Set<ApplicationKind> applicationKindSet = json.applicationKinds;
    assertEquals(2, applicationKindSet.size());
    assertTrue(applicationKindSet.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindSet.contains(ApplicationKind.IN_HOUSE));
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setApplicationKinds(Set)}
   */
  @Test
  void testJsonSetApplicationKinds5() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setApplicationKinds(new HashSet<>());

    // Assert
    assertTrue(json.applicationKinds.isEmpty());
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(new HashSet<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses2() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses3() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusSet = json.entityLifecycleStatuses;
    assertEquals(1, entityLifecycleStatusSet.size());
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses4() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();

    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusSet = json.entityLifecycleStatuses;
    assertEquals(2, entityLifecycleStatusSet.size());
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.PENDING));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses5() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json json = new ImmutableApplicationIdSelectionOptions.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setEntityLifecycleStatuses(new HashSet<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }
}
