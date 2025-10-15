package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.SelectionFilters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttestationRunCreateCommandDiffblueTest {
  /**
   * Test {@link AttestationRunCreateCommand#issuedOn()}.
   *
   * <p>Method under test: {@link AttestationRunCreateCommand#issuedOn()}
   */
  @Test
  @DisplayName("Test issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate AttestationRunCreateCommand.issuedOn()"})
  void testIssuedOn() {
    // Arrange
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
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
    LocalDate actualIssuedOnResult =
        nameResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .targetEntityKind(EntityKind.ALL)
            .build()
            .issuedOn();

    // Assert
    assertEquals("1970-01-01", actualIssuedOnResult.toString());
    assertSame(issuedOn, actualIssuedOnResult);
  }
}
