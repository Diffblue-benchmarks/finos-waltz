package org.finos.waltz.model;

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
import org.junit.jupiter.api.Test;

class ImmutableIdSelectionOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityLifecycleStatuses() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityLifecycleStatuses2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderEntityLifecycleStatuses() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderEntityLifecycleStatuses2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(new ImmutableEntityReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    ImmutableIdSelectionOptions buildResult = builderResult.build();
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(json, buildResult.entityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    when(instance.joiningEntityKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(new ImmutableEntityReference.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(instance.joiningEntityKind()).thenReturn(emptyResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    ImmutableIdSelectionOptions buildResult = builderResult.build();
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(json, buildResult.entityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#from(IdSelectionOptions)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    ImmutableIdSelectionOptions buildResult = builderResult.build();
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = buildResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertSame(json, buildResult.entityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Builder#scope(HierarchyQueryScope)}
   */
  @Test
  void testBuilderScope() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scope(HierarchyQueryScope.EXACT));
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    SelectionFilters filtersResult = actualCopyOfResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(json, actualCopyOfResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(instance.joiningEntityKind()).thenReturn(emptyResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    SelectionFilters filtersResult = actualCopyOfResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(json, actualCopyOfResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    SelectionFilters filtersResult = actualCopyOfResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualCopyOfResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(json, actualCopyOfResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions#fromJson(ImmutableIdSelectionOptions.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();
    json.setScope(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json entityReference = new ImmutableEntityReference.Json();
    json.setEntityReference(entityReference);

    // Act
    ImmutableIdSelectionOptions actualFromJsonResult = ImmutableIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(entityReference, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions#fromJson(ImmutableIdSelectionOptions.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();
    json.setFilters(SelectionFilters.NO_FILTERS);
    json.setScope(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json entityReference = new ImmutableEntityReference.Json();
    json.setEntityReference(entityReference);

    // Act
    ImmutableIdSelectionOptions actualFromJsonResult = ImmutableIdSelectionOptions.fromJson(json);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertSame(entityReference, actualFromJsonResult.entityReference());
    SelectionFilters expectedFiltersResult = json.filters;
    assertSame(expectedFiltersResult, actualFromJsonResult.filters());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Json#entityLifecycleStatuses()}
   */
  @Test
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableIdSelectionOptions.Json()).entityLifecycleStatuses());
  }

  /**
   * Method under test: {@link ImmutableIdSelectionOptions.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdSelectionOptions.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableIdSelectionOptions.Json#filters()}
   */
  @Test
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdSelectionOptions.Json()).filters());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Json#joiningEntityKind()}
   */
  @Test
  void testJsonJoiningEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableIdSelectionOptions.Json()).joiningEntityKind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableIdSelectionOptions.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableIdSelectionOptions.Json actualJson = new ImmutableIdSelectionOptions.Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.scope);
    assertNull(actualJson.filters);
    assertFalse(actualJson.joiningEntityKind.isPresent());
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableIdSelectionOptions.Json#scope()}
   */
  @Test
  void testJsonScope() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdSelectionOptions.Json()).scope());
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(new HashSet<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses2() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses3() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();

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
   * {@link ImmutableIdSelectionOptions.Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses4() {
    // Arrange
    ImmutableIdSelectionOptions.Json json = new ImmutableIdSelectionOptions.Json();

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
}
