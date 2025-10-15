package org.finos.waltz.model.attestation;

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
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.attestation.ImmutableAttestationRunCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunCreateCommandDiffblueTest {
  /**
   * Test {@link ImmutableAttestationRunCreateCommand#attestedEntityId()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#attestedEntityId()}
   */
  @Test
  @DisplayName("Test attestedEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationRunCreateCommand.attestedEntityId()"})
  void testAttestedEntityId() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Optional<Long> actualAttestedEntityIdResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .attestedEntityId();

    // Assert
    assertEquals(1L, actualAttestedEntityIdResult.get().longValue());
    assertTrue(actualAttestedEntityIdResult.isPresent());
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.addAllInvolvementKindIds(Iterable)"
  })
  void testBuilderAddAllInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAddAllInvolvementKindIdsResult =
        builderResult.addAllInvolvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.addAllInvolvementKindIds(Iterable)"
  })
  void testBuilderAddAllInvolvementKindIds_whenArrayList() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAddAllInvolvementKindIdsResult =
        builderResult.addAllInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long)}
   * with {@code element}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.addInvolvementKindIds(long)"
  })
  void testBuilderAddInvolvementKindIdsWithElement() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long[])}
   * with {@code elements}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.addInvolvementKindIds(long[])"
  })
  void testBuilderAddInvolvementKindIdsWithElements() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(long)} with
   * {@code long}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(long)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.attestedEntityId(long)"
  })
  void testBuilderAttestedEntityIdWithLong() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityIdResult =
        builderResult.attestedEntityId(1L);

    // Assert
    assertSame(builderResult, actualAttestedEntityIdResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(Optional)}
   * with {@code Optional}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.attestedEntityId(Optional)"
  })
  void testBuilderAttestedEntityIdWithOptional() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();
    Optional<Long> attestedEntityId = Optional.of(1L);

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityIdResult =
        builderResult.attestedEntityId(attestedEntityId);

    // Assert
    assertSame(builderResult, actualAttestedEntityIdResult);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#attestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.attestedEntityKind(EntityKind)"
  })
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityKindResult =
        builderResult.attestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand.Builder#build()}
   *   <li>{@link ImmutableAttestationRunCreateCommand.Builder#description(String)}
   *   <li>{@link ImmutableAttestationRunCreateCommand.Builder#issuedOn(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.Builder.build()",
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.description(String)",
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.issuedOn(LocalDate)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityIdResult =
        ImmutableAttestationRunCreateCommand.builder().attestedEntityId(1L);
    Optional<Long> attestedEntityId = Optional.of(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    ImmutableAttestationRunCreateCommand.Builder actualNameResult =
        actualAttestedEntityIdResult
            .attestedEntityId(attestedEntityId)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuedOn(issuedOn)
            .name("Name");
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        actualNameResult
            .selectionOptions(selectionOptions)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Assert
    LocalDate dueDateResult = actualImmutableAttestationRunCreateCommand.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualImmutableAttestationRunCreateCommand.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualImmutableAttestationRunCreateCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAttestationRunCreateCommand.description());
    assertEquals(EntityKind.ALL, actualImmutableAttestationRunCreateCommand.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualImmutableAttestationRunCreateCommand.targetEntityKind());
    assertTrue(actualImmutableAttestationRunCreateCommand.involvementKindIds().isEmpty());
    assertSame(selectionOptions, actualImmutableAttestationRunCreateCommand.selectionOptions());
    assertSame(dueDate, dueDateResult);
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#dueDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder dueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.dueDate(LocalDate)"
  })
  void testBuilderDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualDueDateResult =
        builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)} with {@code
   * AttestationRunCreateCommand}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(AttestationRunCreateCommand)"
  })
  void testBuilderFromWithAttestationRunCreateCommand() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand);
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand2);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)} with {@code
   * AttestationRunCreateCommand}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(AttestationRunCreateCommand)"
  })
  void testBuilderFromWithAttestationRunCreateCommand2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description(null)
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand);
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand2);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)} with {@code
   * AttestationRunCreateCommand}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationRunCreateCommand) with 'AttestationRunCreateCommand'; given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(AttestationRunCreateCommand)"
  })
  void testBuilderFromWithAttestationRunCreateCommand_givenOne() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    ImmutableAttestationRunCreateCommand.Builder builderResult2 =
        ImmutableAttestationRunCreateCommand.builder();
    builderResult2.addInvolvementKindIds(1L);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        builderResult2
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand);
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand2);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   * with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(DescriptionProvider)"
  })
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand);
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand2);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   * with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(DescriptionProvider)"
  })
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   * with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(DescriptionProvider)"
  })
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#from(NameProvider)} with
   * {@code NameProvider}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(NameProvider)"
  })
  void testBuilderFromWithNameProvider() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand);
    ImmutableAttestationRunCreateCommand actualImmutableAttestationRunCreateCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunCreateCommand2);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#from(NameProvider)} with
   * {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.from(NameProvider)"
  })
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.involvementKindIds(Iterable)"
  })
  void testBuilderInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualInvolvementKindIdsResult =
        builderResult.involvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.involvementKindIds(Iterable)"
  })
  void testBuilderInvolvementKindIds_whenArrayList() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualInvolvementKindIdsResult =
        builderResult.involvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand.Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.name(String)"
  })
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link
   * ImmutableAttestationRunCreateCommand.Builder#selectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder selectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.selectionOptions(IdSelectionOptions)"
  })
  void testBuilderSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualSelectionOptionsResult =
        builderResult.selectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualSelectionOptionsResult);
  }

  /**
   * Test Builder {@link ImmutableAttestationRunCreateCommand.Builder#targetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand.Builder ImmutableAttestationRunCreateCommand.Builder.targetEntityKind(EntityKind)"
  })
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualTargetEntityKindResult =
        builderResult.targetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationRunCreateCommand); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.copyOf(AttestationRunCreateCommand)"
  })
  void testCopyOf_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuedOn(issuedOn)
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand instance =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualCopyOfResult =
        ImmutableAttestationRunCreateCommand.copyOf(instance);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualCopyOfResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(dueDate, dueDateResult);
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}, and {@link
   * ImmutableAttestationRunCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand#equals(Object)}
   *   <li>{@link ImmutableAttestationRunCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand2 =
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunCreateCommand, immutableAttestationRunCreateCommand2);
    assertEquals(
        immutableAttestationRunCreateCommand.hashCode(),
        immutableAttestationRunCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}, and {@link
   * ImmutableAttestationRunCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand#equals(Object)}
   *   <li>{@link ImmutableAttestationRunCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunCreateCommand, immutableAttestationRunCreateCommand);
    int expectedHashCodeResult = immutableAttestationRunCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationRunCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult =
        ImmutableAttestationRunCreateCommand.builder();
    builderResult.addInvolvementKindIds(1L);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        builderResult
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(2L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.now())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.now())
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("attestedEntityKind");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .selectionOptions(selectionOptions)
            .targetEntityKind(EntityKind.ALL)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ACTOR)
            .build();

    ImmutableAttestationRunCreateCommand.Builder nameResult2 =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunCreateCommand,
        nameResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunCreateCommand.equals(Object)",
    "int ImmutableAttestationRunCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableAttestationRunCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand#attestedEntityKind()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#description()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#dueDate()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#involvementKindIds()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#issuedOn()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#name()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#selectionOptions()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#targetEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableAttestationRunCreateCommand.attestedEntityKind()",
    "String ImmutableAttestationRunCreateCommand.description()",
    "LocalDate ImmutableAttestationRunCreateCommand.dueDate()",
    "Set ImmutableAttestationRunCreateCommand.involvementKindIds()",
    "LocalDate ImmutableAttestationRunCreateCommand.issuedOn()",
    "String ImmutableAttestationRunCreateCommand.name()",
    "IdSelectionOptions ImmutableAttestationRunCreateCommand.selectionOptions()",
    "EntityKind ImmutableAttestationRunCreateCommand.targetEntityKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuedOn(issuedOn)
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    EntityKind actualAttestedEntityKindResult =
        immutableAttestationRunCreateCommand.attestedEntityKind();
    String actualDescriptionResult = immutableAttestationRunCreateCommand.description();
    LocalDate actualDueDateResult = immutableAttestationRunCreateCommand.dueDate();
    Set<Long> actualInvolvementKindIdsResult =
        immutableAttestationRunCreateCommand.involvementKindIds();
    LocalDate actualIssuedOnResult = immutableAttestationRunCreateCommand.issuedOn();
    String actualNameResult = immutableAttestationRunCreateCommand.name();
    IdSelectionOptions actualSelectionOptionsResult =
        immutableAttestationRunCreateCommand.selectionOptions();

    // Assert
    assertTrue(actualSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("1970-01-01", actualIssuedOnResult.toString());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualAttestedEntityKindResult);
    assertEquals(EntityKind.ALL, immutableAttestationRunCreateCommand.targetEntityKind());
    assertTrue(actualInvolvementKindIdsResult.isEmpty());
    assertSame(dueDate, actualDueDateResult);
    assertSame(issuedOn, actualIssuedOnResult);
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   *
   * <p>Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   *
   * <p>Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityKind());
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
   * Test Json {@link Json#issuedOn()}.
   *
   * <p>Method under test: {@link Json#issuedOn()}
   */
  @Test
  @DisplayName("Test Json issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.issuedOn()"})
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.selectionOptions);
    assertFalse(actualJson.attestedEntityId.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
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
   * Test Json {@link Json#targetEntityKind()}.
   *
   * <p>Method under test: {@link Json#targetEntityKind()}
   */
  @Test
  @DisplayName("Test Json targetEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.targetEntityKind()"})
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityKind());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRunCreateCommand.toString()"})
  void testToString() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertEquals(
        "AttestationRunCreateCommand{name=Name, targetEntityKind=ALL, selectionOptions=IdSelectionOptions"
            + "{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT,"
            + " joiningEntityKind=ALL, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}},"
            + " involvementKindIds=[], attestedEntityKind=ALL, attestedEntityId=1, issuedOn=1970-01-01, dueDate=1970"
            + "-01-01}",
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withAttestedEntityId(Optional)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityId(Optional)"
  })
  void testWithAttestedEntityIdWithOptional() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityIdResult =
        immutableAttestationRunCreateCommand.withAttestedEntityId(optional);

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithAttestedEntityIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withAttestedEntityId(Optional)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityId(Optional)"
  })
  void testWithAttestedEntityIdWithOptional2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(2L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityIdResult =
        immutableAttestationRunCreateCommand.withAttestedEntityId(optional);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithAttestedEntityIdResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("1970-01-01", actualWithAttestedEntityIdResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithAttestedEntityIdResult.issuedOn().toString());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityId(long)"
  })
  void testWithAttestedEntityIdWithValue() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityIdResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withAttestedEntityId(42L);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithAttestedEntityIdResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("1970-01-01", actualWithAttestedEntityIdResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithAttestedEntityIdResult.issuedOn().toString());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withAttestedEntityId(long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityId(long)"
  })
  void testWithAttestedEntityIdWithValue2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityIdResult =
        immutableAttestationRunCreateCommand.withAttestedEntityId(1L);

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithAttestedEntityIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityKindResult =
        immutableAttestationRunCreateCommand.withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableAttestationRunCreateCommand actualWithAttestedEntityKindResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withAttestedEntityKind(EntityKind.ALL);

    // Assert
    IdSelectionOptions selectionOptionsResult =
        actualWithAttestedEntityKindResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("1970-01-01", actualWithAttestedEntityKindResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithAttestedEntityKindResult.issuedOn().toString());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithDescriptionResult =
        immutableAttestationRunCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableAttestationRunCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("42")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithDescriptionResult =
        immutableAttestationRunCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withDueDate(LocalDate)"
  })
  void testWithDueDate() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithDueDateResult =
        immutableAttestationRunCreateCommand.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAttestationRunCreateCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withInvolvementKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withInvolvementKindIds(Iterable)"
  })
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuedOn(issuedOn)
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAttestationRunCreateCommand actualWithInvolvementKindIdsResult =
        immutableAttestationRunCreateCommand.withInvolvementKindIds(elements);

    // Assert
    IdSelectionOptions selectionOptionsResult =
        actualWithInvolvementKindIdsResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    LocalDate dueDateResult = actualWithInvolvementKindIdsResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualWithInvolvementKindIdsResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.targetEntityKind());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
    assertSame(dueDate, dueDateResult);
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withInvolvementKindIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withInvolvementKindIds(long[])"
  })
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .issuedOn(issuedOn)
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableAttestationRunCreateCommand actualWithInvolvementKindIdsResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
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
    assertEquals(2, actualWithInvolvementKindIdsResult.involvementKindIds().size());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.targetEntityKind());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
    assertSame(issuedOn, actualWithInvolvementKindIdsResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withIssuedOn(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withIssuedOn(LocalDate)}
   */
  @Test
  @DisplayName("Test withIssuedOn(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withIssuedOn(LocalDate)"
  })
  void testWithIssuedOn() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithIssuedOnResult =
        immutableAttestationRunCreateCommand.withIssuedOn(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAttestationRunCreateCommand, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("42");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithNameResult =
        immutableAttestationRunCreateCommand.withName("42");

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunCreateCommand#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withName(String)"
  })
  void testWithName_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableAttestationRunCreateCommand actualWithNameResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithNameResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("1970-01-01", actualWithNameResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithNameResult.issuedOn().toString());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableAttestationRunCreateCommand actualWithSelectionOptionsResult =
        immutableAttestationRunCreateCommand.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableAttestationRunCreateCommand, actualWithSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableAttestationRunCreateCommand immutableAttestationRunCreateCommand =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRunCreateCommand actualWithTargetEntityKindResult =
        immutableAttestationRunCreateCommand.withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationRunCreateCommand, actualWithTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRunCreateCommand#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunCreateCommand#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunCreateCommand ImmutableAttestationRunCreateCommand.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableAttestationRunCreateCommand actualWithTargetEntityKindResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ACTOR)
            .build()
            .withTargetEntityKind(EntityKind.ALL);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualWithTargetEntityKindResult.selectionOptions();
    assertTrue(selectionOptionsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectionOptionsResult.filters() instanceof ImmutableSelectionFilters);
    assertEquals("1970-01-01", actualWithTargetEntityKindResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithTargetEntityKindResult.issuedOn().toString());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
  }
}
