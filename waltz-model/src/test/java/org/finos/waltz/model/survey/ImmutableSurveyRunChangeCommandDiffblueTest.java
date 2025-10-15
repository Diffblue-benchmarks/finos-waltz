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
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyRunChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutableSurveyRunChangeCommand#approvalDueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#approvalDueDate()}
   */
  @Test
  @DisplayName("Test approvalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyRunChangeCommand.approvalDueDate()"})
  void testApprovalDueDate() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(approvalDueDate)
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

    // Act
    Optional<LocalDate> actualApprovalDueDateResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build()
            .approvalDueDate();

    // Assert
    LocalDate getResult = actualApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualApprovalDueDateResult.isPresent());
    assertSame(approvalDueDate, getResult);
  }

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -9L, 1L, -9L);

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act
    Builder actualAddOwnerInvKindIdsResult = builderResult.addOwnerInvKindIds(1L, -9L, 1L, -9L);

    // Assert
    assertSame(builderResult, actualAddOwnerInvKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#approvalDueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#approvalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder approvalDueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.approvalDueDate(Optional)"})
  void testBuilderApprovalDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    Optional<? extends LocalDate> approvalDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualApprovalDueDateResult = builderResult.approvalDueDate(approvalDueDate);

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
   *   <li>{@link Builder#approvalDueDate(LocalDate)}
   *   <li>{@link Builder#contactEmail(String)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#dueDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.approvalDueDate(LocalDate)",
    "ImmutableSurveyRunChangeCommand Builder.build()",
    "Builder Builder.contactEmail(String)",
    "Builder Builder.description(String)",
    "Builder Builder.dueDate(LocalDate)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualApprovalDueDateResult =
        ImmutableSurveyRunChangeCommand.builder().approvalDueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> approvalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualContactEmailResult =
        actualApprovalDueDateResult
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org");
    Optional<String> contactEmail = Optional.of("foo");
    Builder actualDueDateResult =
        actualContactEmailResult
            .contactEmail(contactEmail)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> dueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualNameResult =
        actualDueDateResult.dueDate(dueDate).issuanceKind(SurveyIssuanceKind.GROUP).name("Name");
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
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand =
        actualNameResult.selectionOptions(selectionOptions).surveyTemplateId(1L).build();

    // Assert
    assertEquals("Name", actualImmutableSurveyRunChangeCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSurveyRunChangeCommand.description());
    assertEquals(1L, actualImmutableSurveyRunChangeCommand.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualImmutableSurveyRunChangeCommand.issuanceKind());
    assertTrue(actualImmutableSurveyRunChangeCommand.involvementKindIds().isEmpty());
    assertSame(selectionOptions, actualImmutableSurveyRunChangeCommand.selectionOptions());
  }

  /**
   * Test Builder {@link Builder#contactEmail(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#contactEmail(Optional)}
   */
  @Test
  @DisplayName("Test Builder contactEmail(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.contactEmail(Optional)"})
  void testBuilderContactEmailWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    Optional<String> contactEmail = Optional.of("foo");

    // Act
    Builder actualContactEmailResult = builderResult.contactEmail(contactEmail);

    // Assert
    assertSame(builderResult, actualContactEmailResult);
  }

  /**
   * Test Builder {@link Builder#dueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#dueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder dueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dueDate(Optional)"})
  void testBuilderDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
    Optional<? extends LocalDate> dueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualDueDateResult = builderResult.dueDate(dueDate);

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand);
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand2);
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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand);
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand2);
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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunChangeCommand)} with {@code SurveyRunChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunChangeCommand) with 'SurveyRunChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunChangeCommand)"})
  void testBuilderFromWithSurveyRunChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunChangeCommand)} with {@code SurveyRunChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunChangeCommand) with 'SurveyRunChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunChangeCommand)"})
  void testBuilderFromWithSurveyRunChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    Builder builderResult2 = ImmutableSurveyRunChangeCommand.builder();
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
    ImmutableSurveyRunChangeCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRunChangeCommand actualImmutableSurveyRunChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunChangeCommand)} with {@code SurveyRunChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunChangeCommand) with 'SurveyRunChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunChangeCommand)"})
  void testBuilderFromWithSurveyRunChangeCommand3() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    Builder builderResult2 = ImmutableSurveyRunChangeCommand.builder();
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
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
    Set<Long> involvementKindIdsResult = immutableSurveyRunChangeCommand.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    Set<Long> ownerInvKindIdsResult = immutableSurveyRunChangeCommand.ownerInvKindIds();
    assertEquals(1, ownerInvKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(ownerInvKindIdsResult.contains(-2L));
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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();

    // Act
    Builder actualSurveyTemplateIdResult = builderResult.surveyTemplateId(1L);

    // Assert
    assertSame(builderResult, actualSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#contactEmail()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#contactEmail()}
   */
  @Test
  @DisplayName("Test contactEmail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyRunChangeCommand.contactEmail()"})
  void testContactEmail() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    Optional<String> actualContactEmailResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build()
            .contactEmail();

    // Assert
    assertEquals("jane.doe@example.org", actualContactEmailResult.get());
    assertTrue(actualContactEmailResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#copyOf(SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#copyOf(SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyRunChangeCommand); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.copyOf(SurveyRunChangeCommand)"
  })
  void testCopyOf_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualCopyOfResult =
        ImmutableSurveyRunChangeCommand.copyOf(instance);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualCopyOfResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualCopyOfResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualCopyOfResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#dueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#dueDate()}
   */
  @Test
  @DisplayName("Test dueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyRunChangeCommand.dueDate()"})
  void testDueDate() {
    // Arrange
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
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
    Optional<LocalDate> actualDueDateResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build()
            .dueDate();

    // Assert
    LocalDate getResult = actualDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualDueDateResult.isPresent());
    assertSame(dueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand2 =
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunChangeCommand, immutableSurveyRunChangeCommand2);
    assertEquals(
        immutableSurveyRunChangeCommand.hashCode(), immutableSurveyRunChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyRunChangeCommand, immutableSurveyRunChangeCommand);
    int expectedHashCodeResult = immutableSurveyRunChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRunChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunChangeCommand.builder();
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .name("approvalDueDate");

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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        ImmutableSurveyRunChangeCommand.builder()
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
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(2L)
            .build();

    Builder nameResult2 =
        ImmutableSurveyRunChangeCommand.builder()
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
        immutableSurveyRunChangeCommand,
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
   * Test {@link ImmutableSurveyRunChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunChangeCommand.equals(Object)",
    "int ImmutableSurveyRunChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
        "Different type to ImmutableSurveyRunChangeCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunChangeCommand#description()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#involvementKindIds()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#issuanceKind()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#name()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#ownerInvKindIds()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#selectionOptions()}
   *   <li>{@link ImmutableSurveyRunChangeCommand#surveyTemplateId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyRunChangeCommand.description()",
    "Set ImmutableSurveyRunChangeCommand.involvementKindIds()",
    "SurveyIssuanceKind ImmutableSurveyRunChangeCommand.issuanceKind()",
    "String ImmutableSurveyRunChangeCommand.name()",
    "Set ImmutableSurveyRunChangeCommand.ownerInvKindIds()",
    "IdSelectionOptions ImmutableSurveyRunChangeCommand.selectionOptions()",
    "Long ImmutableSurveyRunChangeCommand.surveyTemplateId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    String actualDescriptionResult = immutableSurveyRunChangeCommand.description();
    Set<Long> actualInvolvementKindIdsResult = immutableSurveyRunChangeCommand.involvementKindIds();
    SurveyIssuanceKind actualIssuanceKindResult = immutableSurveyRunChangeCommand.issuanceKind();
    String actualNameResult = immutableSurveyRunChangeCommand.name();
    Set<Long> actualOwnerInvKindIdsResult = immutableSurveyRunChangeCommand.ownerInvKindIds();
    IdSelectionOptions actualSelectionOptionsResult =
        immutableSurveyRunChangeCommand.selectionOptions();

    // Assert
    assertTrue(actualSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableSurveyRunChangeCommand.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualIssuanceKindResult);
    assertTrue(actualInvolvementKindIdsResult.isEmpty());
    assertSame(actualInvolvementKindIdsResult, actualOwnerInvKindIdsResult);
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
  @MethodsUnderTest({"Optional Json.approvalDueDate()"})
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
  @MethodsUnderTest({"Optional Json.contactEmail()"})
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
  @MethodsUnderTest({"Optional Json.dueDate()"})
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.issuanceKind);
    assertFalse(actualJson.approvalDueDate.isPresent());
    assertFalse(actualJson.contactEmail.isPresent());
    assertFalse(actualJson.dueDate.isPresent());
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
   * Test {@link ImmutableSurveyRunChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyRunChangeCommand.toString()"})
  void testToString() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    assertEquals(
        "SurveyRunChangeCommand{name=Name, surveyTemplateId=1, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " dueDate=1970-01-01, approvalDueDate=1970-01-01, issuanceKind=GROUP, contactEmail=jane.doe@example.org,"
            + " ownerInvKindIds=[]}",
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withApprovalDueDate(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withApprovalDueDate(Optional)"
  })
  void testWithApprovalDueDateWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyRunChangeCommand actualWithApprovalDueDateResult =
        immutableSurveyRunChangeCommand.withApprovalDueDate(optional);

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withApprovalDueDate(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withApprovalDueDate(LocalDate)"
  })
  void testWithApprovalDueDateWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithApprovalDueDateResult =
        immutableSurveyRunChangeCommand.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withContactEmail(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withContactEmail(Optional)}
   */
  @Test
  @DisplayName("Test withContactEmail(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withContactEmail(Optional)"
  })
  void testWithContactEmailWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyRunChangeCommand actualWithContactEmailResult =
        immutableSurveyRunChangeCommand.withContactEmail(optional);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithContactEmailResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithContactEmailResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithContactEmailResult.description());
    assertEquals(1L, actualWithContactEmailResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithContactEmailResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualWithContactEmailResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithContactEmailResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withContactEmail(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withContactEmail(String)}
   */
  @Test
  @DisplayName("Test withContactEmail(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withContactEmail(String)"
  })
  void testWithContactEmailWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithContactEmailResult =
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
    IdSelectionOptions selectionOptionsResult = actualWithContactEmailResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithContactEmailResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithContactEmailResult.description());
    assertEquals(1L, actualWithContactEmailResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithContactEmailResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualWithContactEmailResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithContactEmailResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withContactEmail(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withContactEmail(String)}
   */
  @Test
  @DisplayName("Test withContactEmail(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withContactEmail(String)"
  })
  void testWithContactEmailWithValue2() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithContactEmailResult =
        immutableSurveyRunChangeCommand.withContactEmail("42");

    // Assert
    assertSame(immutableSurveyRunChangeCommand, actualWithContactEmailResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithDescriptionResult =
        immutableSurveyRunChangeCommand.withDescription("42");

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithDescriptionResult =
        immutableSurveyRunChangeCommand.withDescription("42");

    // Assert
    assertSame(immutableSurveyRunChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withDueDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withDueDate(Optional)"
  })
  void testWithDueDateWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyRunChangeCommand actualWithDueDateResult =
        immutableSurveyRunChangeCommand.withDueDate(optional);

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withDueDate(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withDueDate(LocalDate)"
  })
  void testWithDueDateWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithDueDateResult =
        immutableSurveyRunChangeCommand.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withInvolvementKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withInvolvementKindIds(Iterable)"
  })
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
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
    ImmutableSurveyRunChangeCommand actualWithInvolvementKindIdsResult =
        immutableSurveyRunChangeCommand.withInvolvementKindIds(elements);

    // Assert
    IdSelectionOptions selectionOptionsResult =
        actualWithInvolvementKindIdsResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withInvolvementKindIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withInvolvementKindIds(long[])"
  })
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithInvolvementKindIdsResult =
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
    IdSelectionOptions selectionOptionsResult =
        actualWithInvolvementKindIdsResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals(1L, actualWithInvolvementKindIdsResult.surveyTemplateId().longValue());
    Set<Long> involvementKindIdsResult = actualWithInvolvementKindIdsResult.involvementKindIds();
    assertEquals(2, involvementKindIdsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithInvolvementKindIdsResult.issuanceKind());
    assertTrue(involvementKindIdsResult.contains(-1L));
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualWithInvolvementKindIdsResult.ownerInvKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunChangeCommand#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test withIssuanceKind(SurveyIssuanceKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withIssuanceKind(SurveyIssuanceKind)"
  })
  void testWithIssuanceKind() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithIssuanceKindResult =
        immutableSurveyRunChangeCommand.withIssuanceKind(SurveyIssuanceKind.GROUP);

    // Assert
    assertSame(immutableSurveyRunChangeCommand, actualWithIssuanceKindResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withIssuanceKind(SurveyIssuanceKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunChangeCommand#withIssuanceKind(SurveyIssuanceKind)}
   */
  @Test
  @DisplayName("Test withIssuanceKind(SurveyIssuanceKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withIssuanceKind(SurveyIssuanceKind)"
  })
  void testWithIssuanceKind2() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithIssuanceKindResult =
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
    IdSelectionOptions selectionOptionsResult = actualWithIssuanceKindResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithIssuanceKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuanceKindResult.description());
    assertEquals(1L, actualWithIssuanceKindResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithIssuanceKindResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualWithIssuanceKindResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithIssuanceKindResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithNameResult =
        immutableSurveyRunChangeCommand.withName("42");

    // Assert
    assertSame(immutableSurveyRunChangeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withName(String)"
  })
  void testWithName_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithNameResult =
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
    IdSelectionOptions selectionOptionsResult = actualWithNameResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithNameResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualWithNameResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithNameResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withOwnerInvKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withOwnerInvKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withOwnerInvKindIds(Iterable)"
  })
  void testWithOwnerInvKindIdsWithIterable() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
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
    ImmutableSurveyRunChangeCommand actualWithOwnerInvKindIdsResult =
        immutableSurveyRunChangeCommand.withOwnerInvKindIds(elements);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithOwnerInvKindIdsResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithOwnerInvKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerInvKindIdsResult.description());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
    assertEquals(elements, actualWithOwnerInvKindIdsResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withOwnerInvKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withOwnerInvKindIds(long[])}
   */
  @Test
  @DisplayName("Test withOwnerInvKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withOwnerInvKindIds(long[])"
  })
  void testWithOwnerInvKindIdsWithLong() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithOwnerInvKindIdsResult =
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
    IdSelectionOptions selectionOptionsResult = actualWithOwnerInvKindIdsResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithOwnerInvKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOwnerInvKindIdsResult.description());
    assertEquals(1L, actualWithOwnerInvKindIdsResult.surveyTemplateId().longValue());
    Set<Long> ownerInvKindIdsResult = actualWithOwnerInvKindIdsResult.ownerInvKindIds();
    assertEquals(2, ownerInvKindIdsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithOwnerInvKindIdsResult.issuanceKind());
    assertTrue(ownerInvKindIdsResult.contains(-1L));
    assertTrue(ownerInvKindIdsResult.contains(1L));
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualWithOwnerInvKindIdsResult.involvementKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunChangeCommand#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
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
    ImmutableSurveyRunChangeCommand actualWithSelectionOptionsResult =
        immutableSurveyRunChangeCommand.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableSurveyRunChangeCommand, actualWithSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withSurveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withSurveyTemplateId(Long)"
  })
  void testWithSurveyTemplateId() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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

    // Act
    ImmutableSurveyRunChangeCommand actualWithSurveyTemplateIdResult =
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
    IdSelectionOptions selectionOptionsResult = actualWithSurveyTemplateIdResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("Name", actualWithSurveyTemplateIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSurveyTemplateIdResult.description());
    assertEquals(42L, actualWithSurveyTemplateIdResult.surveyTemplateId().longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertEquals(SurveyIssuanceKind.GROUP, actualWithSurveyTemplateIdResult.issuanceKind());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    Set<Long> involvementKindIdsResult = actualWithSurveyTemplateIdResult.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualWithSurveyTemplateIdResult.ownerInvKindIds());
  }

  /**
   * Test {@link ImmutableSurveyRunChangeCommand#withSurveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunChangeCommand#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunChangeCommand ImmutableSurveyRunChangeCommand.withSurveyTemplateId(Long)"
  })
  void testWithSurveyTemplateId2() {
    // Arrange
    Builder nameResult =
        ImmutableSurveyRunChangeCommand.builder()
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
    ImmutableSurveyRunChangeCommand immutableSurveyRunChangeCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyRunChangeCommand actualWithSurveyTemplateIdResult =
        immutableSurveyRunChangeCommand.withSurveyTemplateId(1L);

    // Assert
    assertSame(immutableSurveyRunChangeCommand, actualWithSurveyTemplateIdResult);
  }
}
