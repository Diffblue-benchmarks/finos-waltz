package org.finos.waltz.data.assessment_rating;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.EntityKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingBasedGenericSelectorFactoryDiffblueTest {
  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add one.</li>
   *   <li>Then calls {@link GenericSelector#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName("Test applyFiltersToSelector(GenericSelector, Set); given HashSet() add one; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"})
  void testApplyFiltersToSelector_givenHashSetAddOne_thenCallsKind() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    when(select.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    Select<Record1<Long>> select2 = mock(Select.class);
    when(select2.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(select);
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.kind()).thenReturn(EntityKind.ALL);
    when(genericSelector.selector()).thenReturn(select2);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(resultLongSet);

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(assessmentBasedSelectionFilter2);
    params.add(assessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(genericSelector, atLeast(1)).kind();
    verify(genericSelector).selector();
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(assessmentBasedSelectionFilter2, atLeast(1)).ratingIds();
    verify(select2).intersect(isA(Select.class));
    verify(select).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add zero.</li>
   *   <li>Then calls {@link GenericSelector#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName("Test applyFiltersToSelector(GenericSelector, Set); given HashSet() add zero; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"})
  void testApplyFiltersToSelector_givenHashSetAddZero_thenCallsKind() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    when(select.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    Select<Record1<Long>> select2 = mock(Select.class);
    when(select2.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(select);
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.kind()).thenReturn(EntityKind.ALL);
    when(genericSelector.selector()).thenReturn(select2);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(resultLongSet);

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(assessmentBasedSelectionFilter2);
    params.add(assessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(genericSelector, atLeast(1)).kind();
    verify(genericSelector).selector();
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(assessmentBasedSelectionFilter2, atLeast(1)).ratingIds();
    verify(select2).intersect(isA(Select.class));
    verify(select).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}.
   * <ul>
   *   <li>Given {@link Select} {@link Select#intersect(Select)} return {@link Select}.</li>
   *   <li>Then calls {@link GenericSelector#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName("Test applyFiltersToSelector(GenericSelector, Set); given Select intersect(Select) return Select; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"})
  void testApplyFiltersToSelector_givenSelectIntersectReturnSelect_thenCallsKind() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    when(select.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.kind()).thenReturn(EntityKind.ALL);
    when(genericSelector.selector()).thenReturn(select);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(assessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(genericSelector).kind();
    verify(genericSelector).selector();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(select).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}.
   * <ul>
   *   <li>Given {@link Select} {@link Select#intersect(Select)} return {@link Select}.</li>
   *   <li>Then calls {@link GenericSelector#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName("Test applyFiltersToSelector(GenericSelector, Set); given Select intersect(Select) return Select; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"})
  void testApplyFiltersToSelector_givenSelectIntersectReturnSelect_thenCallsKind2() {
    // Arrange
    Select<Record1<Long>> select = mock(Select.class);
    when(select.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(mock(Select.class));
    Select<Record1<Long>> select2 = mock(Select.class);
    when(select2.intersect(Mockito.<Select<Record1<Long>>>any())).thenReturn(select);
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.kind()).thenReturn(EntityKind.ALL);
    when(genericSelector.selector()).thenReturn(select2);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> params = new HashSet<>();
    params.add(assessmentBasedSelectionFilter2);
    params.add(assessmentBasedSelectionFilter);

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, params);

    // Assert
    verify(genericSelector, atLeast(1)).kind();
    verify(genericSelector).selector();
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(select2).intersect(isA(Select.class));
  }

  /**
   * Test {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}.
   * <ul>
   *   <li>Given {@link Select}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link GenericSelector#selector()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  @DisplayName("Test applyFiltersToSelector(GenericSelector, Set); given Select; when HashSet(); then calls selector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Select AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(GenericSelector, Set)"})
  void testApplyFiltersToSelector_givenSelect_whenHashSet_thenCallsSelector() {
    // Arrange
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.selector()).thenReturn(mock(Select.class));

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, new HashSet<>());

    // Assert
    verify(genericSelector).selector();
  }
}
