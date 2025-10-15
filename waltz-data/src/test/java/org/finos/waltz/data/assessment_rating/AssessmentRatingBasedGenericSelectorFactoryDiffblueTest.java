package org.finos.waltz.data.assessment_rating;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.ImmutableGenericSelector;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter.Builder;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingBasedGenericSelectorFactoryDiffblueTest {
  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector,
   * Set)}.
   *
   * <ul>
   *   <li>Given builder addRatingIds one and zero.
   *   <li>Then calls {@link Select#intersect(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test applyFiltersToSelector(GenericSelector, Set); given builder addRatingIds one and zero; then calls intersect(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"
  })
  void testApplyFiltersToSelector_givenBuilderAddRatingIdsOneAndZero_thenCallsIntersect() {
    // Arrange
    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    builderResult.addRatingIds(1L, 0L, 1L, 0L);
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        builderResult.definitionId(1L).build();

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(immutableAssessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(selector).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector,
   * Set)}.
   *
   * <ul>
   *   <li>Given builder addRatingIds one.
   *   <li>Then calls {@link Select#intersect(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test applyFiltersToSelector(GenericSelector, Set); given builder addRatingIds one; then calls intersect(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"
  })
  void testApplyFiltersToSelector_givenBuilderAddRatingIdsOne_thenCallsIntersect() {
    // Arrange
    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    builderResult.addRatingIds(1L);
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        builderResult.definitionId(1L).build();

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(immutableAssessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(selector).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@link Select} {@link Select#intersect(Select)} return {@link Select}.
   *   <li>Then calls {@link Select#intersect(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test applyFiltersToSelector(GenericSelector, Set); given Select intersect(Select) return Select; then calls intersect(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"
  })
  void testApplyFiltersToSelector_givenSelectIntersectReturnSelect_thenCallsIntersect() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    when(select.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));

    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(select);
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    builderResult.addRatingIds(1L);
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        builderResult.definitionId(1L).build();

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());
    params.add(immutableAssessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(selector).intersect(isA(Select.class));
    verify(select).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@link Select}.
   *   <li>Then calls {@link Select#intersect(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName(
      "Test applyFiltersToSelector(GenericSelector, Set); given Select; then calls intersect(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"
  })
  void testApplyFiltersToSelector_givenSelect_thenCallsIntersect() {
    // Arrange
    Select<Record1<Long>> selector = mock(Select.class);
    when(selector.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(selector).intersect(isA(Select.class));
  }
}
