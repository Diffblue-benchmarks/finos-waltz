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
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Builder;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationIdSelectionOptions#builder()}
   *   <li>{@link ImmutableApplicationIdSelectionOptions#filters(SelectionFilters)}
   *   <li>{@link ImmutableApplicationIdSelectionOptions#joiningEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableApplicationIdSelectionOptions Builder.build()",
      "Builder Builder.filters(SelectionFilters)", "Builder Builder.joiningEntityKind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualFiltersResult = ImmutableApplicationIdSelectionOptions.builder().filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder actualJoiningEntityKindResult = actualFiltersResult.joiningEntityKind(joiningEntityKind);

    // Assert
    assertSame(actualJoiningEntityKindResult, actualJoiningEntityKindResult.joiningEntityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#addAllApplicationKinds(Iterable)}.
   * <ul>
   *   <li>Given {@code IN_HOUSE}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code IN_HOUSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationKinds(Iterable); given 'IN_HOUSE'; when LinkedHashSet() add 'IN_HOUSE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationKinds(Iterable)"})
  void testBuilderAddAllApplicationKinds_givenInHouse_whenLinkedHashSetAddInHouse() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationKinds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllApplicationKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationKinds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationKinds(Iterable)"})
  void testBuilderAddAllApplicationKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationKinds(new ArrayList<>()));
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplicationKinds(ApplicationKind)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addApplicationKinds(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder addApplicationKinds(ApplicationKind) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationKinds(ApplicationKind)"})
  void testBuilderAddApplicationKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test Builder {@link Builder#addApplicationKinds(ApplicationKind[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationKinds(ApplicationKind[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationKinds(ApplicationKind[])"})
  void testBuilderAddApplicationKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE));
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#applicationKinds(Iterable)}.
   * <ul>
   *   <li>Given {@code IN_HOUSE}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code IN_HOUSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationKinds(Iterable); given 'IN_HOUSE'; when LinkedHashSet() add 'IN_HOUSE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationKinds(Iterable)"})
  void testBuilderApplicationKinds_givenInHouse_whenLinkedHashSetAddInHouse() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKinds(elements));
  }

  /**
   * Test Builder {@link Builder#applicationKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationKinds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationKinds(Iterable)"})
  void testBuilderApplicationKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKinds(new ArrayList<>()));
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityLifecycleStatuses(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code ApplicationIdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code ApplicationIdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code ApplicationIdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions3() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    verify(instance).applicationKinds();
    Set<ApplicationKind> applicationKindsResult = actualFromResult.build().applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    Set<ApplicationKind> applicationKindsResult2 = builderResult.build().applicationKinds();
    assertEquals(1, applicationKindsResult2.size());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code ApplicationIdSelectionOptions}.
   * <ul>
   *   <li>Then builder build scope is {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'; then builder build scope is 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions_thenBuilderBuildScopeIsExact() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    ApplicationIdSelectionOptions instance = mock(ApplicationIdSelectionOptions.class);
    when(instance.applicationKinds()).thenReturn(new HashSet<>());
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    IdSelectionOptions instance = mock(IdSelectionOptions.class);
    when(instance.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(instance.joiningEntityKind()).thenReturn(ofResult);
    when(instance.filters()).thenReturn(SelectionFilters.NO_FILTERS);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatuses();
    verify(instance).entityReference();
    verify(instance).filters();
    verify(instance).joiningEntityKind();
    verify(instance).scope();
    ImmutableApplicationIdSelectionOptions buildResult = builderResult.build();
    assertEquals(7, buildResult.applicationKinds().size());
    assertEquals(HierarchyQueryScope.EXACT, buildResult.scope());
    assertTrue(buildResult.entityLifecycleStatuses().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions3() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scope(HierarchyQueryScope.EXACT));
  }

  /**
   * Test Json {@link Json#applicationKinds()}.
   * <p>
   * Method under test: {@link Json#applicationKinds()}
   */
  @Test
  @DisplayName("Test Json applicationKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.applicationKinds()"})
  void testJsonApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationKinds());
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
    assertFalse(actualJson.applicationKindsIsSet);
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.applicationKinds.isEmpty());
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
   * Test Json {@link Json#setApplicationKinds(Set)}.
   * <ul>
   *   <li>Given {@code IN_HOUSE}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName("Test Json setApplicationKinds(Set); given 'IN_HOUSE'; then Json (default constructor) applicationKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_givenInHouse_thenJsonApplicationKindsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    json.setApplicationKinds(applicationKinds);

    // Assert
    Set<ApplicationKind> applicationKindSet = json.applicationKinds;
    assertEquals(1, applicationKindSet.size());
    assertTrue(applicationKindSet.contains(ApplicationKind.IN_HOUSE));
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName("Test Json setApplicationKinds(Set); then Json (default constructor) applicationKinds size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_thenJsonApplicationKindsSizeIsTwo() {
    // Arrange
    Json json = new Json();

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
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName("Test Json setApplicationKinds(Set); when HashSet(); then Json (default constructor) applicationKinds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_whenHashSet_thenJsonApplicationKindsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationKinds(new HashSet<>());

    // Assert
    assertTrue(json.applicationKinds.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName("Test Json setApplicationKinds(Set); when 'null'; then Json (default constructor) applicationKinds is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_whenNull_thenJsonApplicationKindsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationKinds(null);

    // Assert
    assertNull(json.applicationKinds);
    assertFalse(json.applicationKindsIsSet);
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
