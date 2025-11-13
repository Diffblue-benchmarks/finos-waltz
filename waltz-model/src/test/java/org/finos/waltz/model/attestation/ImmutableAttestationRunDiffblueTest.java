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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.attestation.ImmutableAttestationRun.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRun.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunDiffblueTest {
  /**
   * Test {@link ImmutableAttestationRun#attestedEntityRef()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#attestedEntityRef()}
   */
  @Test
  @DisplayName("Test attestedEntityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationRun.attestedEntityRef()"})
  void testAttestedEntityRef() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        attestedEntityRef,
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .attestedEntityRef());
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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualAddAllInvolvementKindIdsResult =
        builderResult.addAllInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualAttestedEntityKindResult = builderResult.attestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#attestedEntityRef(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#attestedEntityRef(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityRef(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedEntityRef(Optional)"})
  void testBuilderAttestedEntityRefWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    // Act
    Builder actualAttestedEntityRefResult = builderResult.attestedEntityRef(attestedEntityRef);

    // Assert
    assertSame(builderResult, actualAttestedEntityRefResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#attestedEntityRef(EntityReference)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityReference(EntityReference)}
   *   <li>{@link Builder#issuedBy(String)}
   *   <li>{@link Builder#issuedOn(LocalDate)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#status(AttestationStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedEntityRef(EntityReference)",
    "ImmutableAttestationRun Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityReference(EntityReference)",
    "Builder Builder.issuedBy(String)",
    "Builder Builder.issuedOn(LocalDate)",
    "Builder Builder.provenance(String)",
    "Builder Builder.status(AttestationStatus)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAttestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    Builder actualAttestedEntityRefResult =
        actualAttestedEntityKindResult.attestedEntityRef(attestedEntityRef);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    Builder actualDueDateResult =
        actualAttestedEntityRefResult
            .attestedEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult = actualDueDateResult.entityReference(entityReference).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    Builder actualProvenanceResult =
        actualIdResult
            .id(id)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");
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
    ImmutableAttestationRun actualImmutableAttestationRun =
        actualProvenanceResult
            .selectionOptions(selectionOptions)
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Assert
    LocalDate dueDateResult = actualImmutableAttestationRun.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualImmutableAttestationRun.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualImmutableAttestationRun.issuedBy());
    assertEquals("Name", actualImmutableAttestationRun.name());
    assertEquals("Provenance", actualImmutableAttestationRun.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableAttestationRun.description());
    assertEquals(EntityKind.ALL, actualImmutableAttestationRun.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualImmutableAttestationRun.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualImmutableAttestationRun.status());
    assertTrue(actualImmutableAttestationRun.involvementKindIds().isEmpty());
    assertSame(entityReference, actualImmutableAttestationRun.entityReference());
    assertSame(selectionOptions, actualImmutableAttestationRun.selectionOptions());
    assertSame(dueDate, dueDateResult);
    assertSame(issuedOn, issuedOnResult);
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
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualDueDateResult = builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRun)} with {@code AttestationRun}.
   *
   * <p>Method under test: {@link Builder#from(AttestationRun)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRun) with 'AttestationRun'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRun)"})
  void testBuilderFromWithAttestationRun() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRun)} with {@code AttestationRun}.
   *
   * <p>Method under test: {@link Builder#from(AttestationRun)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRun) with 'AttestationRun'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRun)"})
  void testBuilderFromWithAttestationRun2() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    Optional<? extends EntityReference> attestedEntityRef = Optional.empty();

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRun)} with {@code AttestationRun}.
   *
   * <p>Method under test: {@link Builder#from(AttestationRun)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRun) with 'AttestationRun'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRun)"})
  void testBuilderFromWithAttestationRun3() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description(null)
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRun)} with {@code AttestationRun}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When builder addInvolvementKindIds one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AttestationRun)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationRun) with 'AttestationRun'; given one; when builder addInvolvementKindIds one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRun)"})
  void testBuilderFromWithAttestationRun_givenOne_whenBuilderAddInvolvementKindIdsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder builderResult2 = ImmutableAttestationRun.builder();
    builderResult2.addInvolvementKindIds(1L);

    Builder attestedEntityKindResult = builderResult2.attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
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
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

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
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
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
    Builder builderResult = ImmutableAttestationRun.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
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
    Builder builderResult = ImmutableAttestationRun.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableAttestationRun actualImmutableAttestationRun =
        builderResult.from((WaltzEntity) instance).build();
    assertEquals(instance, actualImmutableAttestationRun);
    ImmutableAttestationRun actualImmutableAttestationRun2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRun2);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();
    Optional<Long> id = Optional.of(42L);

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
    Builder builderResult = ImmutableAttestationRun.builder();

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
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
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
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#selectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder selectionOptions(IdSelectionOptions); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.selectionOptions(IdSelectionOptions)"})
  void testBuilderSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

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

    // Act
    Builder actualSelectionOptionsResult =
        builderResult.selectionOptions(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertSame(builderResult, actualSelectionOptionsResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#targetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityKind(EntityKind)"})
  void testBuilderTargetEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();

    // Act
    Builder actualTargetEntityKindResult = builderResult.targetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#copyOf(AttestationRun)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  @DisplayName("Test copyOf(AttestationRun); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.copyOf(AttestationRun)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun instance =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualCopyOfResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualCopyOfResult.dueDate());
    assertSame(issuedOn, actualCopyOfResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#entityReference()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference ImmutableAttestationRun.entityReference()"})
  void testEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    EntityReference actualEntityReferenceResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}, and {@link
   * ImmutableAttestationRun#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRun#equals(Object)}
   *   <li>{@link ImmutableAttestationRun#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun2 =
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRun, immutableAttestationRun2);
    assertEquals(immutableAttestationRun.hashCode(), immutableAttestationRun2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}, and {@link
   * ImmutableAttestationRun#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRun#equals(Object)}
   *   <li>{@link ImmutableAttestationRun#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRun, immutableAttestationRun);
    int expectedHashCodeResult = immutableAttestationRun.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationRun.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.addInvolvementKindIds(1L);

    Builder attestedEntityKindResult = builderResult.attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.now());

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Name")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.now())
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Provenance")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Name");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
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

    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableAttestationRun immutableAttestationRun =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance")
            .selectionOptions(selectionOptions)
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.PENDING)
            .targetEntityKind(EntityKind.ALL)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ACTOR)
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        immutableAttestationRun,
        provenanceResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationRun#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRun.equals(Object)",
    "int ImmutableAttestationRun.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableAttestationRun");
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return issuedOn toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return issuedOn toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnIssuedOnToStringIs19700101() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>Then return issuedOn toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; then return issuedOn toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_thenReturnIssuedOnToStringIs19700101() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) IssuedBy is {@code null}.
   *   <li>Then return issuedBy is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) IssuedBy is 'null'; then return issuedBy is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIssuedByIsNull_thenReturnIssuedByIsNull() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy(null);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.issuedBy());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) IssuedOn is {@code null}.
   *   <li>Then return issuedOn is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) IssuedOn is 'null'; then return issuedOn is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIssuedOnIsNull_thenReturnIssuedOnIsNull() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    json.setIssuedOn(null);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.issuedOn());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Status is {@code null}.
   *   <li>Then return status is {@code ISSUED}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Status is 'null'; then return status is 'ISSUED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonStatusIsNull_thenReturnStatusIsIssued() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(null);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.ISSUED, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return involvementKindIds size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return involvementKindIds size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_thenReturnInvolvementKindIdsSizeIsTwo() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(31L);
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(2, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertTrue(involvementKindIdsResult.contains(31L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    json.setIssuedOn(LocalDate.of(1970, 1, 1));
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(null);

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualFromJsonResult.selectionOptions();
    EntityReference entityReferenceResult = selectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult2 = actualFromJsonResult.entityReference();
    assertTrue(entityReferenceResult2 instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertNull(entityReferenceResult2.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, entityReferenceResult2.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ATTESTATION_RUN, entityReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedEntityRef is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) AttestedEntityRef is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_whenJsonAttestedEntityRefIsNull() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityRef(null);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.fromJson(Json)"})
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    LinkedHashSet<Long> involvementKindIds = new LinkedHashSet<>();
    involvementKindIds.add(1L);

    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setTargetEntityKind(EntityKind.ALL);

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
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setInvolvementKindIds(involvementKindIds);
    json.setAttestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    json.setAttestedEntityRef(attestedEntityRef);
    json.setIssuedBy("Json");
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setStatus(AttestationStatus.DRAFT);
    json.setProvenance(null);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAttestationRun actualFromJsonResult = ImmutableAttestationRun.fromJson(json);

    // Assert
    LocalDate issuedOnResult = actualFromJsonResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.issuedBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    Set<Long> involvementKindIdsResult = actualFromJsonResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(AttestationStatus.DRAFT, actualFromJsonResult.status());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRun#attestedEntityKind()}
   *   <li>{@link ImmutableAttestationRun#description()}
   *   <li>{@link ImmutableAttestationRun#dueDate()}
   *   <li>{@link ImmutableAttestationRun#involvementKindIds()}
   *   <li>{@link ImmutableAttestationRun#issuedBy()}
   *   <li>{@link ImmutableAttestationRun#issuedOn()}
   *   <li>{@link ImmutableAttestationRun#name()}
   *   <li>{@link ImmutableAttestationRun#selectionOptions()}
   *   <li>{@link ImmutableAttestationRun#targetEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableAttestationRun.attestedEntityKind()",
    "String ImmutableAttestationRun.description()",
    "LocalDate ImmutableAttestationRun.dueDate()",
    "Set ImmutableAttestationRun.involvementKindIds()",
    "String ImmutableAttestationRun.issuedBy()",
    "LocalDate ImmutableAttestationRun.issuedOn()",
    "String ImmutableAttestationRun.name()",
    "IdSelectionOptions ImmutableAttestationRun.selectionOptions()",
    "EntityKind ImmutableAttestationRun.targetEntityKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    EntityKind actualAttestedEntityKindResult = immutableAttestationRun.attestedEntityKind();
    String actualDescriptionResult = immutableAttestationRun.description();
    LocalDate actualDueDateResult = immutableAttestationRun.dueDate();
    Set<Long> actualInvolvementKindIdsResult = immutableAttestationRun.involvementKindIds();
    String actualIssuedByResult = immutableAttestationRun.issuedBy();
    LocalDate actualIssuedOnResult = immutableAttestationRun.issuedOn();
    String actualNameResult = immutableAttestationRun.name();
    IdSelectionOptions actualSelectionOptionsResult = immutableAttestationRun.selectionOptions();

    // Assert
    assertTrue(actualSelectionOptionsResult instanceof ImmutableIdSelectionOptions);
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("1970-01-01", actualIssuedOnResult.toString());
    assertEquals("Issued By", actualIssuedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualAttestedEntityKindResult);
    assertEquals(EntityKind.ALL, immutableAttestationRun.targetEntityKind());
    assertTrue(actualInvolvementKindIdsResult.isEmpty());
    assertSame(dueDate, actualDueDateResult);
    assertSame(issuedOn, actualIssuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#id()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationRun.id()"})
  void testId() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#attestedEntityRef()}.
   *
   * <p>Method under test: {@link Json#attestedEntityRef()}
   */
  @Test
  @DisplayName("Test Json attestedEntityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestedEntityRef()"})
  void testJsonAttestedEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityRef());
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
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
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
   * Test Json {@link Json#issuedBy()}.
   *
   * <p>Method under test: {@link Json#issuedBy()}
   */
  @Test
  @DisplayName("Test Json issuedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.issuedBy()"})
  void testJsonIssuedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuedBy());
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
    assertNull(actualJson.issuedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.entityReference);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.status);
    assertFalse(actualJson.attestedEntityRef.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
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
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
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
   * Test {@link ImmutableAttestationRun#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRun.provenance()"})
  void testProvenance() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        "Provenance",
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAttestationRun#status()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationStatus ImmutableAttestationRun.status()"})
  void testStatus() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        AttestationStatus.DRAFT,
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .status());
  }

  /**
   * Test {@link ImmutableAttestationRun#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRun.toString()"})
  void testToString() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        "AttestationRun{id=1, name=Name, targetEntityKind=ALL, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " attestedEntityKind=ALL, attestedEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " issuedBy=Issued By, issuedOn=1970-01-01, dueDate=1970-01-01, status=DRAFT, provenance=Provenance,"
            + " entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRun#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRun.toString()"})
  void testToString2() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    Optional<? extends EntityReference> attestedEntityRef = Optional.empty();

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        "AttestationRun{id=1, name=Name, targetEntityKind=ALL, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " attestedEntityKind=ALL, issuedBy=Issued By, issuedOn=1970-01-01, dueDate=1970-01-01, status=DRAFT,"
            + " provenance=Provenance, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE"
            + "}}",
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRun#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRun.toString()"})
  void testToString3() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy(null)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
        "AttestationRun{id=1, name=Name, targetEntityKind=ALL, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " attestedEntityKind=ALL, attestedEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " issuedOn=1970-01-01, dueDate=1970-01-01, status=DRAFT, provenance=Provenance, entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRun#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRun.toString()"})
  void testToString4() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(null)
            .name("Name")
            .provenance("Provenance");

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
        "AttestationRun{id=1, name=Name, targetEntityKind=ALL, selectionOptions=IdSelectionOptions{entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL,"
            + " entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}, involvementKindIds=[],"
            + " attestedEntityKind=ALL, attestedEntityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " issuedBy=Issued By, dueDate=1970-01-01, status=DRAFT, provenance=Provenance, entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRun#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithAttestedEntityKindResult =
        immutableAttestationRun.withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationRun, actualWithAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withAttestedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityKind(EntityKind); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithAttestedEntityKindResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertTrue(
        actualWithAttestedEntityKindResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithAttestedEntityKindResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithAttestedEntityKindResult.issuedBy());
    assertEquals("Name", actualWithAttestedEntityKindResult.name());
    assertEquals("Provenance", actualWithAttestedEntityKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithAttestedEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityKindResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityKindResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithAttestedEntityKindResult.status());
    assertTrue(actualWithAttestedEntityKindResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithAttestedEntityKindResult.dueDate());
    assertSame(issuedOn, actualWithAttestedEntityKindResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withAttestedEntityRef(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withAttestedEntityRef(Optional)}
   */
  @Test
  @DisplayName("Test withAttestedEntityRef(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withAttestedEntityRef(Optional)"
  })
  void testWithAttestedEntityRefWithOptional() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableAttestationRun actualWithAttestedEntityRefResult =
        immutableAttestationRun.withAttestedEntityRef(optional);

    // Assert
    assertEquals(immutableAttestationRun, actualWithAttestedEntityRefResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withAttestedEntityRef(EntityReference)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withAttestedEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withAttestedEntityRef(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withAttestedEntityRef(EntityReference)"
  })
  void testWithAttestedEntityRefWithValue() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithAttestedEntityRefResult =
        immutableAttestationRun.withAttestedEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAttestationRun, actualWithAttestedEntityRefResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithDescriptionResult =
        immutableAttestationRun.withDescription("42");

    // Assert
    assertEquals(immutableAttestationRun, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("42")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithDescriptionResult =
        immutableAttestationRun.withDescription("42");

    // Assert
    assertSame(immutableAttestationRun, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withDueDate(LocalDate)"})
  void testWithDueDate() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithDueDateResult =
        immutableAttestationRun.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAttestationRun, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithEntityReferenceResult =
        immutableAttestationRun.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAttestationRun, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationRun actualWithIdResult = immutableAttestationRun.withId(optional);

    // Assert
    assertSame(immutableAttestationRun, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withId(Optional)"})
  void testWithIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAttestationRun actualWithIdResult = immutableAttestationRun.withId(optional);

    // Assert
    assertTrue(actualWithIdResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithIdResult.issuedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithIdResult.status());
    assertTrue(actualWithIdResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithIdResult.dueDate());
    assertSame(issuedOn, actualWithIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithIdResult = immutableAttestationRun.withId(1L);

    // Assert
    assertSame(immutableAttestationRun, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withId(long)"})
  void testWithIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithIdResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    assertTrue(actualWithIdResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithIdResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithIdResult.issuedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithIdResult.status());
    assertTrue(actualWithIdResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithIdResult.dueDate());
    assertSame(issuedOn, actualWithIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withInvolvementKindIds(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withInvolvementKindIds(Iterable)"
  })
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAttestationRun actualWithInvolvementKindIdsResult =
        immutableAttestationRun.withInvolvementKindIds(elements);

    // Assert
    assertTrue(
        actualWithInvolvementKindIdsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithInvolvementKindIdsResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithInvolvementKindIdsResult.issuedBy());
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals("Provenance", actualWithInvolvementKindIdsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithInvolvementKindIdsResult.status());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
    assertSame(issuedOn, actualWithInvolvementKindIdsResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withInvolvementKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withInvolvementKindIds(long[])"
  })
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithInvolvementKindIdsResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withInvolvementKindIds(1L, -1L, 1L, -1L);

    // Assert
    assertTrue(
        actualWithInvolvementKindIdsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithInvolvementKindIdsResult.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithInvolvementKindIdsResult.issuedBy());
    assertEquals("Name", actualWithInvolvementKindIdsResult.name());
    assertEquals("Provenance", actualWithInvolvementKindIdsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithInvolvementKindIdsResult.description());
    assertEquals(2, actualWithInvolvementKindIdsResult.involvementKindIds().size());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithInvolvementKindIdsResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithInvolvementKindIdsResult.status());
    assertSame(dueDate, actualWithInvolvementKindIdsResult.dueDate());
    assertSame(issuedOn, actualWithInvolvementKindIdsResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withIssuedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withIssuedBy(String)}
   */
  @Test
  @DisplayName("Test withIssuedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withIssuedBy(String)"})
  void testWithIssuedBy() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("42")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithIssuedByResult = immutableAttestationRun.withIssuedBy("42");

    // Assert
    assertSame(immutableAttestationRun, actualWithIssuedByResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withIssuedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withIssuedBy(String)}
   */
  @Test
  @DisplayName("Test withIssuedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withIssuedBy(String)"})
  void testWithIssuedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithIssuedByResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withIssuedBy("42");

    // Assert
    assertTrue(actualWithIssuedByResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithIssuedByResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithIssuedByResult.issuedBy());
    assertEquals("Name", actualWithIssuedByResult.name());
    assertEquals("Provenance", actualWithIssuedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuedByResult.description());
    assertEquals(EntityKind.ALL, actualWithIssuedByResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithIssuedByResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithIssuedByResult.status());
    assertTrue(actualWithIssuedByResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithIssuedByResult.dueDate());
    assertSame(issuedOn, actualWithIssuedByResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withIssuedOn(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withIssuedOn(LocalDate)}
   */
  @Test
  @DisplayName("Test withIssuedOn(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withIssuedOn(LocalDate)"})
  void testWithIssuedOn() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithIssuedOnResult =
        immutableAttestationRun.withIssuedOn(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAttestationRun, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withName(String)"})
  void testWithName() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("42")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithNameResult = immutableAttestationRun.withName("42");

    // Assert
    assertSame(immutableAttestationRun, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withName(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withName(String)"})
  void testWithName_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithNameResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertTrue(actualWithNameResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithNameResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Issued By", actualWithNameResult.issuedBy());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithNameResult.status());
    assertTrue(actualWithNameResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithNameResult.dueDate());
    assertSame(issuedOn, actualWithNameResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("42");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithProvenanceResult =
        immutableAttestationRun.withProvenance("42");

    // Assert
    assertSame(immutableAttestationRun, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRun ImmutableAttestationRun.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithProvenanceResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withProvenance("42");

    // Assert
    assertTrue(actualWithProvenanceResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithProvenanceResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Issued By", actualWithProvenanceResult.issuedBy());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithProvenanceResult.status());
    assertTrue(actualWithProvenanceResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithProvenanceResult.dueDate());
    assertSame(issuedOn, actualWithProvenanceResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
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
    ImmutableAttestationRun actualWithSelectionOptionsResult =
        immutableAttestationRun.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableAttestationRun, actualWithSelectionOptionsResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withStatus(AttestationStatus)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withStatus(AttestationStatus)}
   */
  @Test
  @DisplayName("Test withStatus(AttestationStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withStatus(AttestationStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithStatusResult =
        immutableAttestationRun.withStatus(AttestationStatus.DRAFT);

    // Assert
    assertSame(immutableAttestationRun, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withStatus(AttestationStatus)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withStatus(AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(AttestationStatus); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withStatus(AttestationStatus)"
  })
  void testWithStatus_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithStatusResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.PENDING)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withStatus(AttestationStatus.DRAFT);

    // Assert
    assertTrue(actualWithStatusResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualWithStatusResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithStatusResult.issuedBy());
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals("Provenance", actualWithStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithStatusResult.description());
    assertEquals(EntityKind.ALL, actualWithStatusResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithStatusResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithStatusResult.status());
    assertTrue(actualWithStatusResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithStatusResult.dueDate());
    assertSame(issuedOn, actualWithStatusResult.issuedOn());
  }

  /**
   * Test {@link ImmutableAttestationRun#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun immutableAttestationRun =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationRun actualWithTargetEntityKindResult =
        immutableAttestationRun.withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationRun, actualWithTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationRun#withTargetEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRun#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withTargetEntityKind(EntityKind); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRun ImmutableAttestationRun.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

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
    ImmutableAttestationRun actualWithTargetEntityKindResult =
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ACTOR)
            .build()
            .withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertTrue(
        actualWithTargetEntityKindResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(
        actualWithTargetEntityKindResult.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertEquals("Issued By", actualWithTargetEntityKindResult.issuedBy());
    assertEquals("Name", actualWithTargetEntityKindResult.name());
    assertEquals("Provenance", actualWithTargetEntityKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithTargetEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualWithTargetEntityKindResult.status());
    assertTrue(actualWithTargetEntityKindResult.involvementKindIds().isEmpty());
    assertSame(dueDate, actualWithTargetEntityKindResult.dueDate());
    assertSame(issuedOn, actualWithTargetEntityKindResult.issuedOn());
  }
}
