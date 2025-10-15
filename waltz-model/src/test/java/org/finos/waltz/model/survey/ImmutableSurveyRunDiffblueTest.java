package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyRun.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRun.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllInvolvementKindIdsResult = builderResult.addAllInvolvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddAllInvolvementKindIdsResult =
        builderResult.addAllInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOwnerInvKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOwnerInvKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOwnerInvKindIds(Iterable)"})
  void testBuilderAddAllOwnerInvKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllOwnerInvKindIdsResult = builderResult.addAllOwnerInvKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOwnerInvKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOwnerInvKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOwnerInvKindIds(Iterable)"})
  void testBuilderAddAllOwnerInvKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddAllOwnerInvKindIdsResult =
        builderResult.addAllOwnerInvKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long)"})
  void testBuilderAddInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult = builderResult.addInvolvementKindIds(1L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long[])"})
  void testBuilderAddInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -257L, 1L, -257L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addOwnerInvKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addOwnerInvKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addOwnerInvKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOwnerInvKindIds(long)"})
  void testBuilderAddOwnerInvKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddOwnerInvKindIdsResult = builderResult.addOwnerInvKindIds(1L);

    // Assert
    assertSame(builderResult, actualAddOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addOwnerInvKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOwnerInvKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addOwnerInvKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOwnerInvKindIds(long[])"})
  void testBuilderAddOwnerInvKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualAddOwnerInvKindIdsResult = builderResult.addOwnerInvKindIds(1L, -257L, 1L, -257L);

    // Assert
    assertSame(builderResult, actualAddOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#approvalDueDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#approvalDueDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder approvalDueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.approvalDueDate(LocalDate)"})
  void testBuilderApprovalDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualApprovalDueDateResult = builderResult.approvalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualApprovalDueDateResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#issuedOn(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRun Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.issuedOn(LocalDate)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualIssuedOnResult =
        actualIdResult
            .id(id)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> issuedOn = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualOwnerIdResult = actualIssuedOnResult.issuedOn(issuedOn).name("Name").ownerId(1L);
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
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableSurveyRun actualImmutableSurveyRun =
        actualOwnerIdResult
            .selectionOptions(selectionOptions)
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Assert
    LocalDate approvalDueDateResult = actualImmutableSurveyRun.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualImmutableSurveyRun.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualImmutableSurveyRun.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableSurveyRun.description());
    assertEquals("jane.doe@example.org", actualImmutableSurveyRun.contactEmail());
    assertEquals(1L, actualImmutableSurveyRun.ownerId().longValue());
    assertEquals(1L, actualImmutableSurveyRun.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualImmutableSurveyRun.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualImmutableSurveyRun.status());
    assertFalse(actualImmutableSurveyRun.isDefault());
    assertTrue(actualImmutableSurveyRun.involvementKindIds().isEmpty());
    assertSame(selectionOptions, actualImmutableSurveyRun.selectionOptions());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test Builder {@link Builder#contactEmail(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#contactEmail(String)}
   */
  @Test
  @DisplayName(
      "Test Builder contactEmail(String); when 'jane.doe@example.org'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.contactEmail(String)"})
  void testBuilderContactEmail_whenJaneDoeExampleOrg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualContactEmailResult = builderResult.contactEmail("jane.doe@example.org");

    // Assert
    assertSame(builderResult, actualContactEmailResult);
  }

  /**
   * Test Builder {@link Builder#dueDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dueDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder dueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dueDate(LocalDate)"})
  void testBuilderDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualDueDateResult = builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRun actualImmutableSurveyRun =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRun);
    ImmutableSurveyRun actualImmutableSurveyRun2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRun2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRun actualImmutableSurveyRun = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRun);
    ImmutableSurveyRun actualImmutableSurveyRun2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRun2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRun actualImmutableSurveyRun =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRun);
    ImmutableSurveyRun actualImmutableSurveyRun2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRun2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRun)} with {@code SurveyRun}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRun)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRun) with 'SurveyRun'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRun)"})
  void testBuilderFromWithSurveyRun() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRun actualImmutableSurveyRun = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRun);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRun)} with {@code SurveyRun}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRun)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRun) with 'SurveyRun'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRun)"})
  void testBuilderFromWithSurveyRun2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder builderResult2 = ImmutableSurveyRun.builder();
    builderResult2.addInvolvementKindIds(1L);

    Builder ownerIdResult =
        builderResult2
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRun actualImmutableSurveyRun = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRun);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRun)} with {@code SurveyRun}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return build involvementKindIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyRun)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyRun) with 'SurveyRun'; given two; then return build involvementKindIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRun)"})
  void testBuilderFromWithSurveyRun_givenTwo_thenReturnBuildInvolvementKindIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    Builder builderResult2 = ImmutableSurveyRun.builder();
    builderResult2.addOwnerInvKindIds(2L);
    builderResult2.addInvolvementKindIds(1L);

    Builder ownerIdResult =
        builderResult2
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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

    // Act and Assert
    ImmutableSurveyRun immutableSurveyRun =
        builderResult
            .from(
                ownerIdResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .status(SurveyRunStatus.DRAFT)
                    .surveyTemplateId(1L)
                    .build())
            .build();
    Set<Long> involvementKindIdsResult = immutableSurveyRun.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    Set<Long> ownerInvKindIdsResult = immutableSurveyRun.ownerInvKindIds();
    assertEquals(1, ownerInvKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(ownerInvKindIdsResult.contains(2L));
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#isDefault(boolean)}.
   *
   * <p>Method under test: {@link Builder#isDefault(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isDefault(boolean)"})
  void testBuilderIsDefault() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualIsDefaultResult = builderResult.isDefault(true);

    // Assert
    assertSame(builderResult, actualIsDefaultResult);
  }

  /**
   * Test Builder {@link Builder#issuanceKind(SurveyIssuanceKind)}.
   *
   * <p>Method under test: {@link Builder#issuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test Builder issuanceKind(SurveyIssuanceKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.issuanceKind(SurveyIssuanceKind)"})
  void testBuilderIssuanceKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualIssuanceKindResult = builderResult.issuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertSame(builderResult, actualIssuanceKindResult);
  }

  /**
   * Test Builder {@link Builder#issuedOn(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#issuedOn(Optional)}
   */
  @Test
  @DisplayName("Test Builder issuedOn(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.issuedOn(Optional)"})
  void testBuilderIssuedOnWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();
    Optional<? extends LocalDate> issuedOn = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualIssuedOnResult = builderResult.issuedOn(issuedOn);

    // Assert
    assertSame(builderResult, actualIssuedOnResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ownerId(Long)}.
   *
   * <p>Method under test: {@link Builder#ownerId(Long)}
   */
  @Test
  @DisplayName("Test Builder ownerId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerId(Long)"})
  void testBuilderOwnerId() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualOwnerIdResult = builderResult.ownerId(1L);

    // Assert
    assertSame(builderResult, actualOwnerIdResult);
  }

  /**
   * Test Builder {@link Builder#ownerInvKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ownerInvKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerInvKindIds(Iterable)"})
  void testBuilderOwnerInvKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualOwnerInvKindIdsResult = builderResult.ownerInvKindIds(elements);

    // Assert
    assertSame(builderResult, actualOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#ownerInvKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ownerInvKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerInvKindIds(Iterable)"})
  void testBuilderOwnerInvKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualOwnerInvKindIdsResult = builderResult.ownerInvKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#selectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder selectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.selectionOptions(IdSelectionOptions)"})
  void testBuilderSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualSelectionOptionsResult =
        builderResult.selectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualSelectionOptionsResult);
  }

  /**
   * Test Builder {@link Builder#status(SurveyRunStatus)}.
   *
   * <p>Method under test: {@link Builder#status(SurveyRunStatus)}
   */
  @Test
  @DisplayName("Test Builder status(SurveyRunStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(SurveyRunStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualStatusResult = builderResult.status(SurveyRunStatus.DRAFT);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#surveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link Builder#surveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyTemplateId(Long)"})
  void testBuilderSurveyTemplateId() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();

    // Act
    Builder actualSurveyTemplateIdResult = builderResult.surveyTemplateId(1L);

    // Assert
    assertSame(builderResult, actualSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#copyOf(SurveyRun)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#copyOf(SurveyRun)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyRun); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.copyOf(SurveyRun)"})
  void testCopyOf_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun instance =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualCopyOfResult = ImmutableSurveyRun.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.status());
    assertFalse(actualCopyOfResult.isDefault());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualCopyOfResult.approvalDueDate());
    assertSame(dueDate, actualCopyOfResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}, and {@link ImmutableSurveyRun#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRun#equals(Object)}
   *   <li>{@link ImmutableSurveyRun#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun2 =
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRun, immutableSurveyRun2);
    assertEquals(immutableSurveyRun.hashCode(), immutableSurveyRun2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}, and {@link ImmutableSurveyRun#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRun#equals(Object)}
   *   <li>{@link ImmutableSurveyRun#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRun, immutableSurveyRun);
    int expectedHashCodeResult = immutableSurveyRun.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRun.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();
    builderResult.addInvolvementKindIds(1L);

    Builder ownerIdResult =
        builderResult
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRun.builder();
    builderResult.addOwnerInvKindIds(1L);

    Builder ownerIdResult =
        builderResult
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.now())
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("john.smith@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.now())
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(2L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.INDIVIDUAL)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.now())
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("jane.doe@example.org")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(2L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableSurveyRun immutableSurveyRun =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L)
            .selectionOptions(selectionOptions)
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.ISSUED)
            .surveyTemplateId(1L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(2L)
            .build();

    Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        immutableSurveyRun,
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRun.equals(Object)",
    "int ImmutableSurveyRun.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build(),
        "Different type to ImmutableSurveyRun");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRun#approvalDueDate()}
   *   <li>{@link ImmutableSurveyRun#contactEmail()}
   *   <li>{@link ImmutableSurveyRun#description()}
   *   <li>{@link ImmutableSurveyRun#dueDate()}
   *   <li>{@link ImmutableSurveyRun#involvementKindIds()}
   *   <li>{@link ImmutableSurveyRun#isDefault()}
   *   <li>{@link ImmutableSurveyRun#issuanceKind()}
   *   <li>{@link ImmutableSurveyRun#name()}
   *   <li>{@link ImmutableSurveyRun#ownerId()}
   *   <li>{@link ImmutableSurveyRun#ownerInvKindIds()}
   *   <li>{@link ImmutableSurveyRun#selectionOptions()}
   *   <li>{@link ImmutableSurveyRun#status()}
   *   <li>{@link ImmutableSurveyRun#surveyTemplateId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableSurveyRun.approvalDueDate()",
    "String ImmutableSurveyRun.contactEmail()",
    "String ImmutableSurveyRun.description()",
    "LocalDate ImmutableSurveyRun.dueDate()",
    "Set ImmutableSurveyRun.involvementKindIds()",
    "boolean ImmutableSurveyRun.isDefault()",
    "SurveyIssuanceKind ImmutableSurveyRun.issuanceKind()",
    "String ImmutableSurveyRun.name()",
    "Long ImmutableSurveyRun.ownerId()",
    "Set ImmutableSurveyRun.ownerInvKindIds()",
    "IdSelectionOptions ImmutableSurveyRun.selectionOptions()",
    "SurveyRunStatus ImmutableSurveyRun.status()",
    "Long ImmutableSurveyRun.surveyTemplateId()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    LocalDate actualApprovalDueDateResult = immutableSurveyRun.approvalDueDate();
    String actualContactEmailResult = immutableSurveyRun.contactEmail();
    String actualDescriptionResult = immutableSurveyRun.description();
    LocalDate actualDueDateResult = immutableSurveyRun.dueDate();
    Set<Long> actualInvolvementKindIdsResult = immutableSurveyRun.involvementKindIds();
    boolean actualIsDefaultResult = immutableSurveyRun.isDefault();
    SurveyIssuanceKind actualIssuanceKindResult = immutableSurveyRun.issuanceKind();
    String actualNameResult = immutableSurveyRun.name();
    Long actualOwnerIdResult = immutableSurveyRun.ownerId();
    Set<Long> actualOwnerInvKindIdsResult = immutableSurveyRun.ownerInvKindIds();
    IdSelectionOptions actualSelectionOptionsResult = immutableSurveyRun.selectionOptions();
    SurveyRunStatus actualStatusResult = immutableSurveyRun.status();
    Long actualSurveyTemplateIdResult = immutableSurveyRun.surveyTemplateId();

    // Assert
    assertTrue(actualSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals("1970-01-01", actualApprovalDueDateResult.toString());
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("jane.doe@example.org", actualContactEmailResult);
    assertEquals(1L, actualOwnerIdResult.longValue());
    assertEquals(1L, actualSurveyTemplateIdResult.longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualIssuanceKindResult);
    assertEquals(SurveyRunStatus.DRAFT, actualStatusResult);
    assertFalse(actualIsDefaultResult);
    assertTrue(actualInvolvementKindIdsResult.isEmpty());
    assertSame(actualInvolvementKindIdsResult, actualOwnerInvKindIdsResult);
    assertSame(approvalDueDate, actualApprovalDueDateResult);
    assertSame(dueDate, actualDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyRun.id()"})
  void testId() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    Optional<Long> actualIdResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyRun#issuedOn()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#issuedOn()}
   */
  @Test
  @DisplayName("Test issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyRun.issuedOn()"})
  void testIssuedOn() {
    // Arrange
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(issuedOn)
            .name("Name")
            .ownerId(1L);

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
    Optional<LocalDate> actualIssuedOnResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .issuedOn();

    // Assert
    LocalDate getResult = actualIssuedOnResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualIssuedOnResult.isPresent());
    assertSame(issuedOn, getResult);
  }

  /**
   * Test Json {@link Json#approvalDueDate()}.
   *
   * <p>Method under test: {@link Json#approvalDueDate()}
   */
  @Test
  @DisplayName("Test Json approvalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.approvalDueDate()"})
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().approvalDueDate());
  }

  /**
   * Test Json {@link Json#contactEmail()}.
   *
   * <p>Method under test: {@link Json#contactEmail()}
   */
  @Test
  @DisplayName("Test Json contactEmail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.contactEmail()"})
  void testJsonContactEmail() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().contactEmail());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#dueDate()}.
   *
   * <p>Method under test: {@link Json#dueDate()}
   */
  @Test
  @DisplayName("Test Json dueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.dueDate()"})
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dueDate());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#involvementKindIds()}.
   *
   * <p>Method under test: {@link Json#involvementKindIds()}
   */
  @Test
  @DisplayName("Test Json involvementKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.involvementKindIds()"})
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvementKindIds());
  }

  /**
   * Test Json {@link Json#isDefault()}.
   *
   * <p>Method under test: {@link Json#isDefault()}
   */
  @Test
  @DisplayName("Test Json isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDefault()"})
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDefault());
  }

  /**
   * Test Json {@link Json#issuanceKind()}.
   *
   * <p>Method under test: {@link Json#issuanceKind()}
   */
  @Test
  @DisplayName("Test Json issuanceKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyIssuanceKind Json.issuanceKind()"})
  void testJsonIssuanceKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuanceKind());
  }

  /**
   * Test Json {@link Json#issuedOn()}.
   *
   * <p>Method under test: {@link Json#issuedOn()}
   */
  @Test
  @DisplayName("Test Json issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.issuedOn()"})
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuedOn());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.ownerId);
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.contactEmail);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.issuedOn.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
    assertTrue(actualJson.involvementKindIds.isEmpty());
    assertTrue(actualJson.ownerInvKindIds.isEmpty());
  }

  /**
   * Test Json {@link Json#ownerId()}.
   *
   * <p>Method under test: {@link Json#ownerId()}
   */
  @Test
  @DisplayName("Test Json ownerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.ownerId()"})
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerId());
  }

  /**
   * Test Json {@link Json#ownerInvKindIds()}.
   *
   * <p>Method under test: {@link Json#ownerInvKindIds()}
   */
  @Test
  @DisplayName("Test Json ownerInvKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ownerInvKindIds()"})
  void testJsonOwnerInvKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerInvKindIds());
  }

  /**
   * Test Json {@link Json#selectionOptions()}.
   *
   * <p>Method under test: {@link Json#selectionOptions()}
   */
  @Test
  @DisplayName("Test Json selectionOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.selectionOptions()"})
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().selectionOptions());
  }

  /**
   * Test Json {@link Json#setIsDefault(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsDefault(boolean)"})
  void testJsonSetIsDefault() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRunStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test Json {@link Json#surveyTemplateId()}.
   *
   * <p>Method under test: {@link Json#surveyTemplateId()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.surveyTemplateId()"})
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyTemplateId());
  }

  /**
   * Test {@link ImmutableSurveyRun#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyRun.toString()"})
  void testToString() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    assertEquals(
        "SurveyRun{id=1, name=Name, surveyTemplateId=1, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " issuedOn=1970-01-01, dueDate=1970-01-01, approvalDueDate=1970-01-01, issuanceKind=GROUP, ownerId=1,"
            + " contactEmail=jane.doe@example.org, status=DRAFT, ownerInvKindIds=[], isDefault=false}",
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyRun#withApprovalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withApprovalDueDate(LocalDate)"})
  void testWithApprovalDueDate() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithApprovalDueDateResult =
        immutableSurveyRun.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRun, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withContactEmail(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withContactEmail(String)}
   */
  @Test
  @DisplayName("Test withContactEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withContactEmail(String)"})
  void testWithContactEmail() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("42")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithContactEmailResult = immutableSurveyRun.withContactEmail("42");

    // Assert
    assertSame(immutableSurveyRun, actualWithContactEmailResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withContactEmail(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withContactEmail(String)}
   */
  @Test
  @DisplayName(
      "Test withContactEmail(String); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withContactEmail(String)"})
  void testWithContactEmail_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithContactEmailResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withContactEmail("42");

    // Assert
    assertTrue(
        actualWithContactEmailResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithContactEmailResult.contactEmail());
    assertEquals("Name", actualWithContactEmailResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithContactEmailResult.description());
    assertEquals(1L, actualWithContactEmailResult.ownerId().longValue());
    assertEquals(1L, actualWithContactEmailResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithContactEmailResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithContactEmailResult.status());
    assertFalse(actualWithContactEmailResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithContactEmailResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithContactEmailResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithContactEmailResult.approvalDueDate());
    assertSame(dueDate, actualWithContactEmailResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithDescriptionResult = immutableSurveyRun.withDescription("42");

    // Assert
    assertEquals(immutableSurveyRun, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("42")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithDescriptionResult = immutableSurveyRun.withDescription("42");

    // Assert
    assertSame(immutableSurveyRun, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withDueDate(LocalDate)"})
  void testWithDueDate() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithDueDateResult =
        immutableSurveyRun.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRun, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyRun actualWithIdResult = immutableSurveyRun.withId(optional);

    // Assert
    assertSame(immutableSurveyRun, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withId(Optional)"})
  void testWithIdWithOptional_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(2L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyRun actualWithIdResult = immutableSurveyRun.withId(optional);

    // Assert
    assertTrue(actualWithIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("jane.doe@example.org", actualWithIdResult.contactEmail());
    assertEquals(1L, actualWithIdResult.ownerId().longValue());
    assertEquals(1L, actualWithIdResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIdResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithIdResult.status());
    assertFalse(actualWithIdResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithIdResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithIdResult.approvalDueDate());
    assertSame(dueDate, actualWithIdResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithIdResult = immutableSurveyRun.withId(1L);

    // Assert
    assertSame(immutableSurveyRun, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withId(long)"})
  void testWithIdWithValue_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithIdResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withId(42L);

    // Assert
    assertTrue(actualWithIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("jane.doe@example.org", actualWithIdResult.contactEmail());
    assertEquals(1L, actualWithIdResult.ownerId().longValue());
    assertEquals(1L, actualWithIdResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIdResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithIdResult.status());
    assertFalse(actualWithIdResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithIdResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithIdResult.approvalDueDate());
    assertSame(dueDate, actualWithIdResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withInvolvementKindIds(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withInvolvementKindIds(Iterable)"})
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyRun actualWithInvolvementKindIdsResult =
        immutableSurveyRun.withInvolvementKindIds(elements);

    // Assert
    assertTrue(
        actualWithInvolvementKindIdsResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithInvolvementKindIdsResult.contactEmail());
    assertEquals(1L, actualWithInvolvementKindIdsResult.ownerId().longValue());
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithInvolvementKindIdsResult.status());
    assertFalse(actualWithInvolvementKindIdsResult.isDefault());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
    assertSame(approvalDueDate, actualWithInvolvementKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withInvolvementKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withInvolvementKindIds(long[])"})
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithInvolvementKindIdsResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withInvolvementKindIds(1L, -1L, 1L, -1L);

    // Assert
    assertTrue(
        actualWithInvolvementKindIdsResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithInvolvementKindIdsResult.contactEmail());
    assertEquals(1L, actualWithInvolvementKindIdsResult.ownerId().longValue());
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    assertEquals(2, actualWithInvolvementKindIdsResult.involvementKindIds().size());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithInvolvementKindIdsResult.status());
    assertFalse(actualWithInvolvementKindIdsResult.isDefault());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
    assertSame(approvalDueDate, actualWithInvolvementKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withIsDefault(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test withIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIsDefault(boolean)"})
  void testWithIsDefault() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithIsDefaultResult = immutableSurveyRun.withIsDefault(false);

    // Assert
    assertSame(immutableSurveyRun, actualWithIsDefaultResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withIsDefault(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIsDefault(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsDefault(boolean); when 'true'; then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIsDefault(boolean)"})
  void testWithIsDefault_whenTrue_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithIsDefaultResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withIsDefault(true);

    // Assert
    assertTrue(actualWithIsDefaultResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithIsDefaultResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsDefaultResult.description());
    assertEquals("jane.doe@example.org", actualWithIsDefaultResult.contactEmail());
    assertEquals(1L, actualWithIsDefaultResult.ownerId().longValue());
    assertEquals(1L, actualWithIsDefaultResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIsDefaultResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithIsDefaultResult.status());
    Set<Long> involvementKindIdsResult = actualWithIsDefaultResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertTrue(actualWithIsDefaultResult.isDefault());
    assertSame(involvementKindIdsResult, actualWithIsDefaultResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithIsDefaultResult.approvalDueDate());
    assertSame(dueDate, actualWithIsDefaultResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test withIssuanceKind(SurveyIssuanceKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIssuanceKind(SurveyIssuanceKind)"})
  void testWithIssuanceKind() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithIssuanceKindResult =
        immutableSurveyRun.withIssuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertSame(immutableSurveyRun, actualWithIssuanceKindResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName(
      "Test withIssuanceKind(SurveyIssuanceKind); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIssuanceKind(SurveyIssuanceKind)"})
  void testWithIssuanceKind_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.INDIVIDUAL)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithIssuanceKindResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withIssuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertTrue(
        actualWithIssuanceKindResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithIssuanceKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuanceKindResult.description());
    assertEquals("jane.doe@example.org", actualWithIssuanceKindResult.contactEmail());
    assertEquals(1L, actualWithIssuanceKindResult.ownerId().longValue());
    assertEquals(1L, actualWithIssuanceKindResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIssuanceKindResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithIssuanceKindResult.status());
    assertFalse(actualWithIssuanceKindResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithIssuanceKindResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithIssuanceKindResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithIssuanceKindResult.approvalDueDate());
    assertSame(dueDate, actualWithIssuanceKindResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withIssuedOn(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIssuedOn(Optional)}
   */
  @Test
  @DisplayName("Test withIssuedOn(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIssuedOn(Optional)"})
  void testWithIssuedOnWithOptional() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyRun actualWithIssuedOnResult = immutableSurveyRun.withIssuedOn(optional);

    // Assert
    assertEquals(immutableSurveyRun, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withIssuedOn(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withIssuedOn(LocalDate)}
   */
  @Test
  @DisplayName("Test withIssuedOn(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withIssuedOn(LocalDate)"})
  void testWithIssuedOnWithValue() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithIssuedOnResult =
        immutableSurveyRun.withIssuedOn(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRun, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withName(String)"})
  void testWithName() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("42")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithNameResult = immutableSurveyRun.withName("42");

    // Assert
    assertSame(immutableSurveyRun, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withName(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withName(String)"})
  void testWithName_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithNameResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withName("42");

    // Assert
    assertTrue(actualWithNameResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("jane.doe@example.org", actualWithNameResult.contactEmail());
    assertEquals(1L, actualWithNameResult.ownerId().longValue());
    assertEquals(1L, actualWithNameResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithNameResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithNameResult.status());
    assertFalse(actualWithNameResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithNameResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithNameResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithNameResult.approvalDueDate());
    assertSame(dueDate, actualWithNameResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withOwnerId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withOwnerId(Long)}
   */
  @Test
  @DisplayName("Test withOwnerId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withOwnerId(Long)"})
  void testWithOwnerId() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithOwnerIdResult = immutableSurveyRun.withOwnerId(1L);

    // Assert
    assertSame(immutableSurveyRun, actualWithOwnerIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withOwnerId(Long)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withOwnerId(Long)}
   */
  @Test
  @DisplayName("Test withOwnerId(Long); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withOwnerId(Long)"})
  void testWithOwnerId_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithOwnerIdResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withOwnerId(42L);

    // Assert
    assertTrue(actualWithOwnerIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithOwnerIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithOwnerIdResult.description());
    assertEquals("jane.doe@example.org", actualWithOwnerIdResult.contactEmail());
    assertEquals(1L, actualWithOwnerIdResult.surveyTemplateId().longValue());
    assertEquals(42L, actualWithOwnerIdResult.ownerId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerIdResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithOwnerIdResult.status());
    assertFalse(actualWithOwnerIdResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithOwnerIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithOwnerIdResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithOwnerIdResult.approvalDueDate());
    assertSame(dueDate, actualWithOwnerIdResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withOwnerInvKindIds(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withOwnerInvKindIds(Iterable)"})
  void testWithOwnerInvKindIdsWithIterable() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyRun actualWithOwnerInvKindIdsResult =
        immutableSurveyRun.withOwnerInvKindIds(elements);

    // Assert
    assertTrue(
        actualWithOwnerInvKindIdsResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithOwnerInvKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerInvKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithOwnerInvKindIdsResult.contactEmail());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.ownerId().longValue());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithOwnerInvKindIdsResult.status());
    assertFalse(actualWithOwnerInvKindIdsResult.isDefault());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
    assertEquals(elements, actualWithOwnerInvKindIdsResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithOwnerInvKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithOwnerInvKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withOwnerInvKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withOwnerInvKindIds(long[])}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withOwnerInvKindIds(long[])"})
  void testWithOwnerInvKindIdsWithLong() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithOwnerInvKindIdsResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withOwnerInvKindIds(1L, -1L, 1L, -1L);

    // Assert
    assertTrue(
        actualWithOwnerInvKindIdsResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithOwnerInvKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerInvKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithOwnerInvKindIdsResult.contactEmail());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.ownerId().longValue());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    assertEquals(2, actualWithOwnerInvKindIdsResult.ownerInvKindIds().size());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithOwnerInvKindIdsResult.status());
    assertFalse(actualWithOwnerInvKindIdsResult.isDefault());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
    assertSame(approvalDueDate, actualWithOwnerInvKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithOwnerInvKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRun ImmutableSurveyRun.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
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
    ImmutableSurveyRun actualWithSelectionOptionsResult =
        immutableSurveyRun.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableSurveyRun, actualWithSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withStatus(SurveyRunStatus)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName("Test withStatus(SurveyRunStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withStatus(SurveyRunStatus)"})
  void testWithStatus() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithStatusResult =
        immutableSurveyRun.withStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertSame(immutableSurveyRun, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withStatus(SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(SurveyRunStatus); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withStatus(SurveyRunStatus)"})
  void testWithStatus_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithStatusResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.ISSUED)
            .surveyTemplateId(1L)
            .build()
            .withStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertTrue(actualWithStatusResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithStatusResult.description());
    assertEquals("jane.doe@example.org", actualWithStatusResult.contactEmail());
    assertEquals(1L, actualWithStatusResult.ownerId().longValue());
    assertEquals(1L, actualWithStatusResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithStatusResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithStatusResult.status());
    assertFalse(actualWithStatusResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithStatusResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithStatusResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithStatusResult.approvalDueDate());
    assertSame(dueDate, actualWithStatusResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRun#withSurveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withSurveyTemplateId(Long)"})
  void testWithSurveyTemplateId() {
    // Arrange
    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun immutableSurveyRun =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRun actualWithSurveyTemplateIdResult =
        immutableSurveyRun.withSurveyTemplateId(1L);

    // Assert
    assertSame(immutableSurveyRun, actualWithSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRun#withSurveyTemplateId(Long)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRun#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyTemplateId(Long); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRun ImmutableSurveyRun.withSurveyTemplateId(Long)"})
  void testWithSurveyTemplateId_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

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
    ImmutableSurveyRun actualWithSurveyTemplateIdResult =
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .withSurveyTemplateId(42L);

    // Assert
    assertTrue(
        actualWithSurveyTemplateIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithSurveyTemplateIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSurveyTemplateIdResult.description());
    assertEquals("jane.doe@example.org", actualWithSurveyTemplateIdResult.contactEmail());
    assertEquals(1L, actualWithSurveyTemplateIdResult.ownerId().longValue());
    assertEquals(42L, actualWithSurveyTemplateIdResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithSurveyTemplateIdResult.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualWithSurveyTemplateIdResult.status());
    assertFalse(actualWithSurveyTemplateIdResult.isDefault());
    Set<Long> involvementKindIdsResult = actualWithSurveyTemplateIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithSurveyTemplateIdResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithSurveyTemplateIdResult.approvalDueDate());
    assertSame(dueDate, actualWithSurveyTemplateIdResult.dueDate());
  }
}
