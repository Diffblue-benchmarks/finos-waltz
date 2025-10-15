package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyRunCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCreateCommandDiffblueTest {
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -65L, 1L, -65L);

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualAddOwnerInvKindIdsResult = builderResult.addOwnerInvKindIds(1L, -65L, 1L, -65L);

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualNameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");
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
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        actualNameResult.selectionOptions(selectionOptions).surveyTemplateId(1L).build();

    // Assert
    LocalDate approvalDueDateResult = actualImmutableSurveyRunCreateCommand.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualImmutableSurveyRunCreateCommand.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Name", actualImmutableSurveyRunCreateCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSurveyRunCreateCommand.description());
    assertEquals("jane.doe@example.org", actualImmutableSurveyRunCreateCommand.contactEmail());
    assertEquals(1L, actualImmutableSurveyRunCreateCommand.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualImmutableSurveyRunCreateCommand.issuanceKind());
    assertTrue(actualImmutableSurveyRunCreateCommand.involvementKindIds().isEmpty());
    assertSame(selectionOptions, actualImmutableSurveyRunCreateCommand.selectionOptions());
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand);
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand2);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand);
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand2);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand);
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder builderResult2 = ImmutableSurveyRunCreateCommand.builder();
    builderResult2.addInvolvementKindIds(1L);

    Builder nameResult =
        builderResult2
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand);
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder builderResult2 = ImmutableSurveyRunCreateCommand.builder();
    builderResult2.addOwnerInvKindIds(-2L);
    builderResult2.addInvolvementKindIds(1L);

    Builder nameResult =
        builderResult2
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        builderResult
            .from(
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .surveyTemplateId(1L)
                    .build())
            .build();
    Set<Long> involvementKindIdsResult = immutableSurveyRunCreateCommand.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    Set<Long> ownerInvKindIdsResult = immutableSurveyRunCreateCommand.ownerInvKindIds();
    assertEquals(1, ownerInvKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(ownerInvKindIdsResult.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCreateCommand)} with {@code SurveyRunCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunCreateCommand) with 'SurveyRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCreateCommand)"})
  void testBuilderFromWithSurveyRunCreateCommand4() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description(null)
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand);
    ImmutableSurveyRunCreateCommand actualImmutableSurveyRunCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCreateCommand2);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualIssuanceKindResult = builderResult.issuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertSame(builderResult, actualIssuanceKindResult);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualSelectionOptionsResult =
        builderResult.selectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualSelectionOptionsResult);
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
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();

    // Act
    Builder actualSurveyTemplateIdResult = builderResult.surveyTemplateId(1L);

    // Assert
    assertSame(builderResult, actualSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#copyOf(SurveyRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#copyOf(SurveyRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyRunCreateCommand); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.copyOf(SurveyRunCreateCommand)"
  })
  void testCopyOf_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualCopyOfResult =
        ImmutableSurveyRunCreateCommand.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("jane.doe@example.org", actualCopyOfResult.contactEmail());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualCopyOfResult.approvalDueDate());
    assertSame(dueDate, actualCopyOfResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand2 =
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunCreateCommand, immutableSurveyRunCreateCommand2);
    assertEquals(
        immutableSurveyRunCreateCommand.hashCode(), immutableSurveyRunCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunCreateCommand, immutableSurveyRunCreateCommand);
    int expectedHashCodeResult = immutableSurveyRunCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRunCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    builderResult.addInvolvementKindIds(1L);

    Builder nameResult =
        builderResult
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCreateCommand.builder();
    builderResult.addOwnerInvKindIds(1L);

    Builder nameResult =
        builderResult
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.now())
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("john.smith@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.now())
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.INDIVIDUAL)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("jane.doe@example.org");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name")
            .selectionOptions(selectionOptions)
            .surveyTemplateId(1L)
            .build();

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(2L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        immutableSurveyRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCreateCommand.equals(Object)",
    "int ImmutableSurveyRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build(),
        "Different type to ImmutableSurveyRunCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCreateCommand#toString()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#approvalDueDate()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#contactEmail()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#description()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#dueDate()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#involvementKindIds()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#issuanceKind()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#name()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#ownerInvKindIds()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#selectionOptions()}
   *   <li>{@link ImmutableSurveyRunCreateCommand#surveyTemplateId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableSurveyRunCreateCommand.approvalDueDate()",
    "String ImmutableSurveyRunCreateCommand.contactEmail()",
    "String ImmutableSurveyRunCreateCommand.description()",
    "LocalDate ImmutableSurveyRunCreateCommand.dueDate()",
    "Set ImmutableSurveyRunCreateCommand.involvementKindIds()",
    "SurveyIssuanceKind ImmutableSurveyRunCreateCommand.issuanceKind()",
    "String ImmutableSurveyRunCreateCommand.name()",
    "Set ImmutableSurveyRunCreateCommand.ownerInvKindIds()",
    "IdSelectionOptions ImmutableSurveyRunCreateCommand.selectionOptions()",
    "Long ImmutableSurveyRunCreateCommand.surveyTemplateId()",
    "String ImmutableSurveyRunCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyRunCreateCommand.toString();
    LocalDate actualApprovalDueDateResult = immutableSurveyRunCreateCommand.approvalDueDate();
    String actualContactEmailResult = immutableSurveyRunCreateCommand.contactEmail();
    String actualDescriptionResult = immutableSurveyRunCreateCommand.description();
    LocalDate actualDueDateResult = immutableSurveyRunCreateCommand.dueDate();
    Set<Long> actualInvolvementKindIdsResult = immutableSurveyRunCreateCommand.involvementKindIds();
    SurveyIssuanceKind actualIssuanceKindResult = immutableSurveyRunCreateCommand.issuanceKind();
    String actualNameResult = immutableSurveyRunCreateCommand.name();
    Set<Long> actualOwnerInvKindIdsResult = immutableSurveyRunCreateCommand.ownerInvKindIds();
    IdSelectionOptions actualSelectionOptionsResult =
        immutableSurveyRunCreateCommand.selectionOptions();

    // Assert
    assertTrue(actualSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals("1970-01-01", actualApprovalDueDateResult.toString());
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("Name", actualNameResult);
    assertEquals(
        "SurveyRunCreateCommand{name=Name, surveyTemplateId=1, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " dueDate=1970-01-01, approvalDueDate=1970-01-01, issuanceKind=GROUP, contactEmail=jane.doe@example.org,"
            + " ownerInvKindIds=[]}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("jane.doe@example.org", actualContactEmailResult);
    assertEquals(1L, immutableSurveyRunCreateCommand.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualIssuanceKindResult);
    assertTrue(actualInvolvementKindIdsResult.isEmpty());
    assertSame(actualInvolvementKindIdsResult, actualOwnerInvKindIdsResult);
    assertSame(approvalDueDate, actualApprovalDueDateResult);
    assertSame(dueDate, actualDueDateResult);
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
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.contactEmail);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertTrue(actualJson.involvementKindIds.isEmpty());
    assertTrue(actualJson.ownerInvKindIds.isEmpty());
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
   * Test {@link ImmutableSurveyRunCreateCommand#withApprovalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withApprovalDueDate(LocalDate)"
  })
  void testWithApprovalDueDate() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithApprovalDueDateResult =
        immutableSurveyRunCreateCommand.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRunCreateCommand, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withContactEmail(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withContactEmail(String)}
   */
  @Test
  @DisplayName("Test withContactEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withContactEmail(String)"
  })
  void testWithContactEmail() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("42")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithContactEmailResult =
        immutableSurveyRunCreateCommand.withContactEmail("42");

    // Assert
    assertSame(immutableSurveyRunCreateCommand, actualWithContactEmailResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withContactEmail(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withContactEmail(String)}
   */
  @Test
  @DisplayName(
      "Test withContactEmail(String); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withContactEmail(String)"
  })
  void testWithContactEmail_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithContactEmailResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    assertEquals(1L, actualWithContactEmailResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithContactEmailResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualWithContactEmailResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithContactEmailResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithContactEmailResult.approvalDueDate());
    assertSame(dueDate, actualWithContactEmailResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithDescriptionResult =
        immutableSurveyRunCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableSurveyRunCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("42")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithDescriptionResult =
        immutableSurveyRunCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableSurveyRunCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withDueDate(LocalDate)"
  })
  void testWithDueDate() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithDueDateResult =
        immutableSurveyRunCreateCommand.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRunCreateCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withInvolvementKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withInvolvementKindIds(Iterable)"
  })
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyRunCreateCommand actualWithInvolvementKindIdsResult =
        immutableSurveyRunCreateCommand.withInvolvementKindIds(elements);

    // Assert
    assertTrue(
        actualWithInvolvementKindIdsResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithInvolvementKindIdsResult.contactEmail());
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
    assertSame(approvalDueDate, actualWithInvolvementKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withInvolvementKindIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withInvolvementKindIds(long[])"
  })
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithInvolvementKindIdsResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    assertEquals(2, actualWithInvolvementKindIdsResult.involvementKindIds().size());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
    assertSame(approvalDueDate, actualWithInvolvementKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunCreateCommand#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test withIssuanceKind(SurveyIssuanceKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withIssuanceKind(SurveyIssuanceKind)"
  })
  void testWithIssuanceKind() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithIssuanceKindResult =
        immutableSurveyRunCreateCommand.withIssuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertSame(immutableSurveyRunCreateCommand, actualWithIssuanceKindResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunCreateCommand#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName(
      "Test withIssuanceKind(SurveyIssuanceKind); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withIssuanceKind(SurveyIssuanceKind)"
  })
  void testWithIssuanceKind_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.INDIVIDUAL)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithIssuanceKindResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    assertEquals(1L, actualWithIssuanceKindResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIssuanceKindResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualWithIssuanceKindResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithIssuanceKindResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithIssuanceKindResult.approvalDueDate());
    assertSame(dueDate, actualWithIssuanceKindResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("42");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithNameResult =
        immutableSurveyRunCreateCommand.withName("42");

    // Assert
    assertSame(immutableSurveyRunCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withName(String)"
  })
  void testWithName_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithNameResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build()
            .withName("42");

    // Assert
    assertTrue(actualWithNameResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("jane.doe@example.org", actualWithNameResult.contactEmail());
    assertEquals(1L, actualWithNameResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithNameResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualWithNameResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithNameResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithNameResult.approvalDueDate());
    assertSame(dueDate, actualWithNameResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withOwnerInvKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withOwnerInvKindIds(Iterable)"
  })
  void testWithOwnerInvKindIdsWithIterable() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyRunCreateCommand actualWithOwnerInvKindIdsResult =
        immutableSurveyRunCreateCommand.withOwnerInvKindIds(elements);

    // Assert
    assertTrue(
        actualWithOwnerInvKindIdsResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualWithOwnerInvKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerInvKindIdsResult.description());
    assertEquals("jane.doe@example.org", actualWithOwnerInvKindIdsResult.contactEmail());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
    assertEquals(elements, actualWithOwnerInvKindIdsResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithOwnerInvKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithOwnerInvKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withOwnerInvKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withOwnerInvKindIds(long[])}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withOwnerInvKindIds(long[])"
  })
  void testWithOwnerInvKindIdsWithLong() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithOwnerInvKindIdsResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    assertEquals(2, actualWithOwnerInvKindIdsResult.ownerInvKindIds().size());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
    assertSame(approvalDueDate, actualWithOwnerInvKindIdsResult.approvalDueDate());
    assertSame(dueDate, actualWithOwnerInvKindIdsResult.dueDate());
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunCreateCommand#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    ImmutableSurveyRunCreateCommand actualWithSelectionOptionsResult =
        immutableSurveyRunCreateCommand.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableSurveyRunCreateCommand, actualWithSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withSurveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withSurveyTemplateId(Long)"
  })
  void testWithSurveyTemplateId() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand immutableSurveyRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunCreateCommand actualWithSurveyTemplateIdResult =
        immutableSurveyRunCreateCommand.withSurveyTemplateId(1L);

    // Assert
    assertSame(immutableSurveyRunCreateCommand, actualWithSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCreateCommand#withSurveyTemplateId(Long)}.
   *
   * <ul>
   *   <li>Then selectionOptions return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCreateCommand#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyTemplateId(Long); then selectionOptions return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCreateCommand ImmutableSurveyRunCreateCommand.withSurveyTemplateId(Long)"
  })
  void testWithSurveyTemplateId_thenSelectionOptionsReturnImmutableIdSelectionOptions() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("Name");

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
    ImmutableSurveyRunCreateCommand actualWithSurveyTemplateIdResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
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
    assertEquals(42L, actualWithSurveyTemplateIdResult.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithSurveyTemplateIdResult.issuanceKind());
    Set<Long> involvementKindIdsResult = actualWithSurveyTemplateIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithSurveyTemplateIdResult.ownerInvKindIds());
    assertSame(approvalDueDate, actualWithSurveyTemplateIdResult.approvalDueDate());
    assertSame(dueDate, actualWithSurveyTemplateIdResult.dueDate());
  }
}
