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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntitySearchOptionsDiffblueTest {
  /**
   * Test {@link ImmutableEntitySearchOptions#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntitySearchOptions#builder()}
   *   <li>{@link ImmutableEntitySearchOptions#userId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEntitySearchOptions Builder.build()", "Builder Builder.userId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntitySearchOptions.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.userId("42"));
  }

  /**
   * Test Builder {@link Builder#addAllEntityKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityKinds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntityKinds(Iterable)"})
  void testBuilderAddAllEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityKinds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllEntityLifecycleStatuses(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntityLifecycleStatuses(Iterable)"})
  void testBuilderAddAllEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addEntityKinds(EntityKind)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addEntityKinds(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder addEntityKinds(EntityKind) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityKinds(EntityKind)"})
  void testBuilderAddEntityKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityKinds(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#addEntityKinds(EntityKind[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addEntityKinds(EntityKind[])}
   */
  @Test
  @DisplayName("Test Builder addEntityKinds(EntityKind[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityKinds(EntityKind[])"})
  void testBuilderAddEntityKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityKinds(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus)"})
  void testBuilderAddEntityLifecycleStatusesWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus[])"})
  void testBuilderAddEntityLifecycleStatusesWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#entityKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityKinds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityKinds(Iterable)"})
  void testBuilderEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKinds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#entityLifecycleStatuses(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityLifecycleStatuses(Iterable)"})
  void testBuilderEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code ALL}.</li>
   *   <li>Then return build entityKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions); given ArrayList() add 'ALL'; then return build entityKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom_givenArrayListAddAll_thenReturnBuildEntityKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    ArrayList<EntityKind> entityKindList = new ArrayList<>();
    entityKindList.add(EntityKind.ALL);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(entityKindList);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    ImmutableEntitySearchOptions buildResult = actualFromResult.build();
    List<EntityKind> entityKindsResult = buildResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    List<EntityKind> entityKindsResult2 = builderResult.build().entityKinds();
    assertEquals(1, entityKindsResult2.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertEquals(EntityKind.ALL, entityKindsResult2.get(0));
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions); given one; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom_givenOne_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   * <ul>
   *   <li>Then return build entityLifecycleStatuses size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions); then return build entityLifecycleStatuses size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom_thenReturnBuildEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatusList = new ArrayList<>();
    entityLifecycleStatusList.add(EntityLifecycleStatus.ACTIVE);
    EntitySearchOptions instance = mock(EntitySearchOptions.class);
    when(instance.limit()).thenReturn(1);
    when(instance.userId()).thenReturn("42");
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusList);
    when(instance.searchQuery()).thenReturn("Search Query");
    when(instance.entityKinds()).thenReturn(new ArrayList<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityKinds();
    verify(instance).entityLifecycleStatuses();
    verify(instance).limit();
    verify(instance).searchQuery();
    verify(instance).userId();
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromResult.build().entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult2 = builderResult.build().entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult2.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult2.get(0));
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
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
   * Test Builder {@link Builder#limit(int)}.
   * <p>
   * Method under test: {@link Builder#limit(int)}
   */
  @Test
  @DisplayName("Test Builder limit(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.limit(int)"})
  void testBuilderLimit() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.limit(1));
  }

  /**
   * Test Builder {@link Builder#searchQuery(String)}.
   * <p>
   * Method under test: {@link Builder#searchQuery(String)}
   */
  @Test
  @DisplayName("Test Builder searchQuery(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.searchQuery(String)"})
  void testBuilderSearchQuery() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualSearchQueryResult = builderResult.searchQuery("Search Query");

    // Assert
    ImmutableEntitySearchOptions buildResult = builderResult.build();
    assertEquals("Search Query", buildResult.searchQuery());
    assertEquals("UNKNOWN", buildResult.userId());
    assertEquals(2, buildResult.entityLifecycleStatuses().size());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, buildResult.limit());
    assertSame(builderResult, actualSearchQueryResult);
  }

  /**
   * Test Json {@link Json#entityKinds()}.
   * <p>
   * Method under test: {@link Json#entityKinds()}
   */
  @Test
  @DisplayName("Test Json entityKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.entityKinds()"})
  void testJsonEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityKinds());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatuses()}.
   * <p>
   * Method under test: {@link Json#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.entityLifecycleStatuses()"})
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityLifecycleStatuses());
  }

  /**
   * Test Json {@link Json#limit()}.
   * <p>
   * Method under test: {@link Json#limit()}
   */
  @Test
  @DisplayName("Test Json limit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.limit()"})
  void testJsonLimit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).limit());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#searchQuery()}.
   * <p>
   * Method under test: {@link Json#searchQuery()}
   */
  @Test
  @DisplayName("Test Json searchQuery()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.searchQuery()"})
  void testJsonSearchQuery() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).searchQuery());
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Json json = new Json();

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
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsTwo() {
    // Arrange
    Json json = new Json();

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
   * Test Json {@link Json#setLimit(int)}.
   * <p>
   * Method under test: {@link Json#setLimit(int)}
   */
  @Test
  @DisplayName("Test Json setLimit(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLimit(int)"})
  void testJsonSetLimit() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLimit(1);

    // Assert
    assertEquals(1, json.limit);
    assertTrue(json.limitIsSet);
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
