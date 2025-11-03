package org.finos.waltz.data.licence;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LicenceIdSelectorFactoryDiffblueTest {
  /**
   * Test new {@link LicenceIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link LicenceIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LicenceIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LicenceIdSelectorFactory.<init>()"})
  void testNewLicenceIdSelectorFactory_thenCallsId() {
    // Arrange and Act
    LicenceIdSelectorFactory actualLicenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    actualLicenceIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ACTOR}.</li>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ACTOR'; then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnActor_thenCallsScope() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code AGGREGATE_OVERLAY_DIAGRAM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'AGGREGATE_OVERLAY_DIAGRAM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAggregateOverlayDiagram() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> licenceIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAll() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code APP_GROUP}.</li>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'APP_GROUP'; then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAppGroup_thenCallsScope() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code APPLICATION}.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'APPLICATION'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnApplication_thenCallsId() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code CHANGE_INITIATIVE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'CHANGE_INITIATIVE'; then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnChangeInitiative_thenCallsScope() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddActive_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code IN_HOUSE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'IN_HOUSE'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddInHouse_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.</li>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'PENDING'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddPending_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    licenceIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_thenThrowUnsupportedOperationException() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> licenceIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
  }
}
