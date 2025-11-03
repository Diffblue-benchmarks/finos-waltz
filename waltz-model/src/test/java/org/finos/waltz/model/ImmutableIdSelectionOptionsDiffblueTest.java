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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableIdSelectionOptionsDiffblueTest {
  /**
   * Test {@link ImmutableIdSelectionOptions#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableIdSelectionOptions#builder()}
   *   <li>{@link ImmutableIdSelectionOptions#filters(SelectionFilters)}
   *   <li>{@link ImmutableIdSelectionOptions#joiningEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableIdSelectionOptions Builder.build()", "Builder Builder.filters(SelectionFilters)",
      "Builder Builder.joiningEntityKind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualFiltersResult = ImmutableIdSelectionOptions.builder().filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder actualJoiningEntityKindResult = actualFiltersResult.joiningEntityKind(joiningEntityKind);

    // Assert
    assertSame(actualJoiningEntityKindResult, actualJoiningEntityKindResult.joiningEntityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#addAllEntityLifecycleStatuses(Iterable)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityLifecycleStatuses(Iterable); given 'ACTIVE'; when LinkedHashSet() add 'ACTIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntityLifecycleStatuses(Iterable)"})
  void testBuilderAddAllEntityLifecycleStatuses_givenActive_whenLinkedHashSetAddActive() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(elements));
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
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
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
    Builder builderResult = ImmutableIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#entityLifecycleStatuses(Iterable)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityLifecycleStatuses(Iterable); given 'ACTIVE'; when LinkedHashSet() add 'ACTIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityLifecycleStatuses(Iterable)"})
  void testBuilderEntityLifecycleStatuses_givenActive_whenLinkedHashSetAddActive() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(elements));
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
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(new ImmutableEntityReference.Json()));
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions); given empty; when IdSelectionOptions joiningEntityKind() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom_givenEmpty_whenIdSelectionOptionsJoiningEntityKindReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(instance.joiningEntityKind()).thenReturn(emptyResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code ALL}.</li>
   *   <li>Then builder build scope is {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions); given Optional with 'ALL'; then builder build scope is 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom_givenOptionalWithAll_thenBuilderBuildScopeIsExact() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   * <ul>
   *   <li>Then return build entityLifecycleStatuses size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions); then return build entityLifecycleStatuses size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom_thenReturnBuildEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(new ImmutableEntityReference.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualFromResult.build().entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult2 = builderResult.build().entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult2.size());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult2.contains(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
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
   * Test Builder {@link Builder#joiningEntityKind(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#joiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test Builder joiningEntityKind(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.joiningEntityKind(Optional)"})
  void testBuilderJoiningEntityKindWithOptional() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    // Act and Assert
    assertSame(builderResult, builderResult.joiningEntityKind(joiningEntityKind));
  }

  /**
   * Test Builder {@link Builder#scope(HierarchyQueryScope)}.
   * <p>
   * Method under test: {@link Builder#scope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test Builder scope(HierarchyQueryScope)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scope(HierarchyQueryScope)"})
  void testBuilderScope() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scope(HierarchyQueryScope.EXACT));
  }

  /**
   * Test Json {@link Json#entityLifecycleStatuses()}.
   * <p>
   * Method under test: {@link Json#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.entityLifecycleStatuses()"})
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityLifecycleStatuses());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#filters()}.
   * <p>
   * Method under test: {@link Json#filters()}
   */
  @Test
  @DisplayName("Test Json filters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SelectionFilters Json.filters()"})
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).filters());
  }

  /**
   * Test Json {@link Json#joiningEntityKind()}.
   * <p>
   * Method under test: {@link Json#joiningEntityKind()}
   */
  @Test
  @DisplayName("Test Json joiningEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.joiningEntityKind()"})
  void testJsonJoiningEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).joiningEntityKind());
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
    assertNull(actualJson.entityReference);
    assertNull(actualJson.scope);
    assertNull(actualJson.filters);
    assertFalse(actualJson.joiningEntityKind.isPresent());
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Test Json {@link Json#scope()}.
   * <p>
   * Method under test: {@link Json#scope()}
   */
  @Test
  @DisplayName("Test Json scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HierarchyQueryScope Json.scope()"})
  void testJsonScope() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scope());
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(new HashSet<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
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
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Json json = new Json();

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
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName("Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsTwo() {
    // Arrange
    Json json = new Json();

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
