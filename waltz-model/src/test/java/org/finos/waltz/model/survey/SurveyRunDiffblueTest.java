package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

class SurveyRunDiffblueTest {
  /**
   * Test {@link SurveyRun#isDefault()}.
   *
   * <p>Method under test: {@link SurveyRun#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyRun.isDefault()"})
  void testIsDefault() {
    // Arrange
    ImmutableSurveyRun.Builder ownerIdResult =
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
    assertFalse(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build()
            .isDefault());
  }
}
