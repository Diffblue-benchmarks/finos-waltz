package org.finos.waltz.model.entity_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutableEntitySearchOptionsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntitySearchOptions#builder()}
   *   <li>{@link ImmutableEntitySearchOptions#userId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntitySearchOptions.Builder actualBuilderResult = ImmutableEntitySearchOptions.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addAllEntityKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityKinds() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityLifecycleStatuses() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addEntityKinds(EntityKind)}
   */
  @Test
  void testBuilderAddEntityKinds() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityKinds(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addEntityKinds(EntityKind[])}
   */
  @Test
  void testBuilderAddEntityKinds2() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityKinds(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  void testBuilderAddEntityLifecycleStatuses2() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#entityKinds(Iterable)}
   */
  @Test
  void testBuilderEntityKinds() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  void testBuilderEntityLifecycleStatuses() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#from(EntitySearchOptions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntitySearchOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    ImmutableEntitySearchOptions buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Search Query", buildResult.searchQuery());
    assertEquals(1, buildResult.limit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#from(EntitySearchOptions)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.entityLifecycleStatuses()).thenThrow(new IllegalStateException("instance"));
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).searchQuery();
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#from(EntitySearchOptions)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntitySearchOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    ImmutableEntitySearchOptions buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Search Query", buildResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = buildResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1, buildResult.limit());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#from(EntitySearchOptions)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    ArrayList<EntityKind> entityKindList = new ArrayList<>();
    entityKindList.add(EntityKind.ALL);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(entityKindList);

    // Act
    ImmutableEntitySearchOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    ImmutableEntitySearchOptions buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("Search Query", buildResult.searchQuery());
    List<EntityKind> entityKindsResult = buildResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    assertEquals(1, buildResult.limit());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Builder#limit(int)}
   */
  @Test
  void testBuilderLimit() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.limit(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Builder#searchQuery(String)}
   */
  @Test
  void testBuilderSearchQuery() {
    // Arrange
    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions.Builder actualSearchQueryResult = builderResult.searchQuery("Search Query");

    // Assert
    ImmutableEntitySearchOptions buildResult = builderResult.build();
    assertEquals("Search Query", buildResult.searchQuery());
    assertEquals("UNKNOWN", buildResult.userId());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = buildResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, buildResult.limit());
    assertSame(builderResult, actualSearchQueryResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntitySearchOptions actualCopyOfResult = ImmutableEntitySearchOptions.copyOf(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Search Query", actualCopyOfResult.searchQuery());
    assertEquals(1, actualCopyOfResult.limit());
    List<EntityKind> entityKindsResult = actualCopyOfResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertSame(entityKindsResult, actualCopyOfResult.entityLifecycleStatuses());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntitySearchOptions actualCopyOfResult = ImmutableEntitySearchOptions.copyOf(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Search Query", actualCopyOfResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualCopyOfResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1, actualCopyOfResult.limit());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertTrue(actualCopyOfResult.entityKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    ImmutableEntitySearchOptions actualCopyOfResult = ImmutableEntitySearchOptions.copyOf(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Search Query", actualCopyOfResult.searchQuery());
    assertEquals(1, actualCopyOfResult.limit());
    assertTrue(actualCopyOfResult.entityKinds().isEmpty());
    assertEquals(entityLifecycleStatusList, actualCopyOfResult.entityLifecycleStatuses());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<EntityKind> entityKindList = new ArrayList<>();
    entityKindList.add(EntityKind.ALL);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(entityKindList);

    // Act
    ImmutableEntitySearchOptions actualCopyOfResult = ImmutableEntitySearchOptions.copyOf(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Search Query", actualCopyOfResult.searchQuery());
    List<EntityKind> entityKindsResult = actualCopyOfResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    assertEquals(1, actualCopyOfResult.limit());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#fromJson(ImmutableEntitySearchOptions.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();
    json.setSearchQuery("searchQuery");

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("UNKNOWN", actualFromJsonResult.userId());
    assertEquals("searchQuery", actualFromJsonResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    List<EntityKind> entityKindsResult = actualFromJsonResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
    assertSame(json.entityLifecycleStatuses, entityKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#fromJson(ImmutableEntitySearchOptions.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();
    json.setUserId("42");
    json.setSearchQuery("searchQuery");

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.userId());
    assertEquals("searchQuery", actualFromJsonResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    List<EntityKind> entityKindsResult = actualFromJsonResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
    assertSame(json.entityLifecycleStatuses, entityKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#fromJson(ImmutableEntitySearchOptions.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<EntityKind> entityKinds = new ArrayList<>();
    entityKinds.add(EntityKind.ALL);

    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();
    json.setSearchQuery("entityKinds element");
    json.setEntityKinds(entityKinds);

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("UNKNOWN", actualFromJsonResult.userId());
    assertEquals("entityKinds element", actualFromJsonResult.searchQuery());
    List<EntityKind> entityKindsResult = actualFromJsonResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions#fromJson(ImmutableEntitySearchOptions.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<EntityKind> entityKinds = new ArrayList<>();
    entityKinds.add(EntityKind.ALL);
    entityKinds.add(EntityKind.ALL);

    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();
    json.setSearchQuery("entityKinds element");
    json.setEntityKinds(entityKinds);

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("UNKNOWN", actualFromJsonResult.userId());
    assertEquals("entityKinds element", actualFromJsonResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertEquals(entityKinds, actualFromJsonResult.entityKinds());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Json#entityKinds()}
   */
  @Test
  void testJsonEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySearchOptions.Json()).entityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#entityLifecycleStatuses()}
   */
  @Test
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntitySearchOptions.Json()).entityLifecycleStatuses());
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Json#limit()}
   */
  @Test
  void testJsonLimit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySearchOptions.Json()).limit());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntitySearchOptions.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntitySearchOptions.Json actualJson = new ImmutableEntitySearchOptions.Json();

    // Assert
    assertNull(actualJson.searchQuery);
    assertNull(actualJson.userId);
    assertEquals(0, actualJson.limit);
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertFalse(actualJson.limitIsSet);
    assertTrue(actualJson.entityKinds.isEmpty());
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Json#searchQuery()}
   */
  @Test
  void testJsonSearchQuery() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySearchOptions.Json()).searchQuery());
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses2() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses3() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    List<EntityLifecycleStatus> entityLifecycleStatusList = json.entityLifecycleStatuses;
    assertEquals(1, entityLifecycleStatusList.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusList.get(0));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses4() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    List<EntityLifecycleStatus> entityLifecycleStatusList = json.entityLifecycleStatuses;
    assertEquals(2, entityLifecycleStatusList.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusList.get(1));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusList.get(0));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntitySearchOptions.Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  void testJsonSetEntityLifecycleStatuses5() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    // Act
    json.setEntityLifecycleStatuses(mock(COWArrayList.class));

    // Assert
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Json#setLimit(int)}
   */
  @Test
  void testJsonSetLimit() {
    // Arrange
    ImmutableEntitySearchOptions.Json json = new ImmutableEntitySearchOptions.Json();

    // Act
    json.setLimit(1);

    // Assert
    assertEquals(1, json.limit);
    assertTrue(json.limitIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntitySearchOptions.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntitySearchOptions.Json()).userId());
  }
}
