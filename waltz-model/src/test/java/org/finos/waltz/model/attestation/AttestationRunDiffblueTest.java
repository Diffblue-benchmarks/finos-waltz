package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.attestation.ImmutableAttestationRun.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttestationRunDiffblueTest {
  /**
   * Test {@link AttestationRun#status()}.
   *
   * <p>Method under test: {@link AttestationRun#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationStatus AttestationRun.status()"})
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
   * Test {@link AttestationRun#provenance()}.
   *
   * <p>Method under test: {@link AttestationRun#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AttestationRun.provenance()"})
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
   * Test {@link AttestationRun#entityReference()}.
   *
   * <p>Method under test: {@link AttestationRun#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference AttestationRun.entityReference()"})
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
}
