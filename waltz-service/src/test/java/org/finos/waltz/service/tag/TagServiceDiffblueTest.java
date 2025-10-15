package org.finos.waltz.service.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.tag.ImmutableTag;
import org.finos.waltz.model.tag.ImmutableTagUsage;
import org.finos.waltz.model.tag.Tag;
import org.finos.waltz.model.tag.TagUsage;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TagServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private TagDao tagDao;

  @InjectMocks private TagService tagService;

  /**
   * Test {@link TagService#findTagsForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findTagsForEntityReference(EntityReference)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.findTagsForEntityReference(EntityReference)"})
  void testFindTagsForEntityReference() {
    // Arrange
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Tag> actualFindTagsForEntityReferenceResult = tagService.findTagsForEntityReference(null);

    // Assert
    verify(tagDao).findTagsForEntityReference(isNull());
    assertTrue(actualFindTagsForEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKind(EntityKind)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.findTagsForEntityKind(EntityKind)"})
  void testFindTagsForEntityKind() {
    // Arrange
    when(tagDao.findTagsForEntityKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());

    // Act
    List<Tag> actualFindTagsForEntityKindResult = tagService.findTagsForEntityKind(EntityKind.ALL);

    // Assert
    verify(tagDao).findTagsForEntityKind(EntityKind.ALL);
    assertTrue(actualFindTagsForEntityKindResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector2() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector3() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector4() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector5() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

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
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector6() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions); given 'INTERNALLY_HOSTED'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector_givenInternallyHosted() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#findTagsForEntityKindAndTargetSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions); given 'PENDING'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TagService.findTagsForEntityKindAndTargetSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindTagsForEntityKindAndTargetSelector_givenPending() {
    // Arrange
    when(tagDao.findTagsForEntityKindAndTargetSelector(
            Mockito.<EntityKind>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

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
    List<Tag> actualFindTagsForEntityKindAndTargetSelectorResult =
        tagService.findTagsForEntityKindAndTargetSelector(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(tagDao)
        .findTagsForEntityKindAndTargetSelector(eq(EntityKind.APPLICATION), isA(Select.class));
    assertTrue(actualFindTagsForEntityKindAndTargetSelectorResult.isEmpty());
  }

  /**
   * Test {@link TagService#getById(long)}.
   *
   * <p>Method under test: {@link TagService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tag TagService.getById(long)"})
  void testGetById() {
    // Arrange
    when(tagDao.getById(anyLong()))
        .thenReturn(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    // Act
    Tag actualById = tagService.getById(1L);

    // Assert
    verify(tagDao).getById(1L);
    assertTrue(actualById instanceof ImmutableTag);
    assertEquals("Name", actualById.name());
    assertEquals(EntityKind.ALL, actualById.targetKind());
    assertTrue(actualById.tagUsages().isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName("Test updateTags(EntityReference, Collection, String)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(-2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ImmutableTag.Builder builderResult2 = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult2.addTagUsages(
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag2 =
        builderResult2.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(immutableTag2);
    tagList.add(immutableTag);

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    TagService tagService = new TagService(tagDao, changeLogService);

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals("Name", getResult2.name());
    assertEquals(1, getResult.tagUsages().size());
    assertEquals(1, getResult2.tagUsages().size());
    assertEquals(EntityKind.ALL, getResult2.targetKind());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName("Test updateTags(EntityReference, Collection, String)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags2() {
    // Arrange
    TagDao tagDao = mock(TagDao.class);
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(ref, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    assertTrue(actualUpdateTagsResult.isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link TagService#TagService(TagDao, ChangeLogService)} with {@link TagDao} and
   *       {@link ChangeLogService}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); given TagService(TagDao, ChangeLogService) with TagDao and ChangeLogService")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_givenTagServiceWithTagDaoAndChangeLogService() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());

    ImmutableTagUsage.Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ImmutableTag.Builder builderResult2 = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult3 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult2.addTagUsages(
        createdByResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag2 =
        builderResult2.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(immutableTag2);
    tagList.add(immutableTag);

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    TagService tagService = new TagService(tagDao, changeLogService);

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals(1, getResult.tagUsages().size());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link TagService}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); given TagService; when ArrayList(); then return Empty")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_givenTagService_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(), eq("janedoe"), eq(""), eq(Operation.UPDATE));
    assertTrue(actualUpdateTagsResult.isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then calls createTagUsage(EntityReference, String, Long)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenCallsCreateTagUsage() {
    // Arrange
    when(tagDao.getTagByNameAndTargetKind(Mockito.<EntityKind>any(), Mockito.<String>any()))
        .thenReturn(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    doNothing()
        .when(tagDao)
        .createTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<Long>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<String> tags = new ArrayList<>();
    tags.add("foo");

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(ref, tags, "janedoe");

    // Assert
    verify(tagDao).createTagUsage(isA(EntityReference.class), eq("janedoe"), eq(1L));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao).getTagByNameAndTargetKind(EntityKind.ALL, "foo");
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq(" Added tags: [foo]. "),
            eq(Operation.UPDATE));
    assertTrue(actualUpdateTagsResult.isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then calls createTagUsage(EntityReference, String, Long)")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenCallsCreateTagUsage2() {
    // Arrange
    when(tagDao.getTagByNameAndTargetKind(Mockito.<EntityKind>any(), Mockito.<String>any()))
        .thenReturn(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    doNothing()
        .when(tagDao)
        .createTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<Long>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<String> tags = new ArrayList<>();
    tags.add("Adding tags {} for entity ref {}");
    tags.add("foo");

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(ref, tags, "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).createTagUsage(isA(EntityReference.class), eq("janedoe"), eq(1L));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao, atLeast(1)).getTagByNameAndTargetKind(eq(EntityKind.ALL), Mockito.<String>any());
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq(" Added tags: [foo, Adding tags {} for entity ref {}]. "),
            eq(Operation.UPDATE));
    assertTrue(actualUpdateTagsResult.isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName("Test updateTags(EntityReference, Collection, String); then return ArrayList()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenReturnArrayList() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(immutableTag);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertSame(tagList, actualUpdateTagsResult);
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then return first tagUsages size is one.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then return first tagUsages size is one")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenReturnFirstTagUsagesSizeIsOne() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ImmutableTag.Builder builderResult2 = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult2.addTagUsages(
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag2 =
        builderResult2.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(immutableTag2);
    tagList.add(immutableTag);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals(1, getResult.tagUsages().size());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then return second name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then return second name is 'Name'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenReturnSecondNameIsName() {
    // Arrange
    ImmutableTag.Builder builderResult = ImmutableTag.builder();

    ImmutableTagUsage.Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    builderResult.addTagUsages(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
    ImmutableTag immutableTag =
        builderResult.id(1L).name("Name").targetKind(EntityKind.ALL).build();

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    tagList.add(immutableTag);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals("Name", getResult2.name());
    assertEquals(1, getResult2.tagUsages().size());
    assertEquals(EntityKind.ALL, getResult2.targetKind());
    assertTrue(getResult.tagUsages().isEmpty());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then return second name is {@code tags cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then return second name is 'tags cannot be null'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenReturnSecondNameIsTagsCannotBeNull() {
    // Arrange
    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    tagList.add(
        ImmutableTag.builder()
            .id(1L)
            .name("tags cannot be null")
            .targetKind(EntityKind.ALL)
            .build());
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao, atLeast(1)).removeTagUsage(isNull(), Mockito.<String>any());
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [tags cannot be null, Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals("tags cannot be null", getResult2.name());
    assertEquals(EntityKind.ALL, getResult2.targetKind());
    Set<TagUsage> tagUsagesResult = getResult.tagUsages();
    assertTrue(tagUsagesResult.isEmpty());
    assertSame(tagUsagesResult, getResult2.tagUsages());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>Then return second name is {@code tags cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); then return second name is 'tags cannot be null'")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_thenReturnSecondNameIsTagsCannotBeNull2() {
    // Arrange
    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    tagList.add(
        ImmutableTag.builder()
            .id(1L)
            .name("tags cannot be null")
            .targetKind(EntityKind.ALL)
            .build());
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ArrayList<String> tags = new ArrayList<>();
    tags.add("tags cannot be null");

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, tags, "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertEquals("tags cannot be null", getResult2.name());
    assertEquals(EntityKind.ALL, getResult2.targetKind());
    Set<TagUsage> tagUsagesResult = getResult.tagUsages();
    assertTrue(tagUsagesResult.isEmpty());
    assertSame(tagUsagesResult, getResult2.tagUsages());
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); when ArrayList(); then return ArrayList()")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertSame(tagList, actualUpdateTagsResult);
  }

  /**
   * Test {@link TagService#updateTags(EntityReference, Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return second is first.
   * </ul>
   *
   * <p>Method under test: {@link TagService#updateTags(EntityReference, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateTags(EntityReference, Collection, String); when ArrayList(); then return second is first")
  @org.junit.jupiter.api.Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagService.updateTags(EntityReference, Collection, String)"})
  void testUpdateTags_whenArrayList_thenReturnSecondIsFirst() {
    // Arrange
    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    // Act
    List<Tag> actualUpdateTagsResult = tagService.updateTags(null, new ArrayList<>(), "janedoe");

    // Assert
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isNull());
    verify(tagDao).removeTagUsage(isNull(), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            (EntityReference) isNull(),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    assertEquals(2, actualUpdateTagsResult.size());
    Tag getResult = actualUpdateTagsResult.get(0);
    assertTrue(getResult instanceof ImmutableTag);
    Tag getResult2 = actualUpdateTagsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTag);
    assertTrue(getResult.tagUsages().isEmpty());
    assertEquals(getResult, getResult2);
  }
}
