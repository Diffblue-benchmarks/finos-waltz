package org.finos.waltz.data.assessment_rating;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.EntityKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingBasedGenericSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  void testApplyFiltersToSelector() {
    // Arrange
    GenericSelector genericSelector = mock(GenericSelector.class);
    when(genericSelector.selector()).thenReturn(mock(Select.class));

    // Act
    AssessmentRatingBasedGenericSelectorFactory.applyFiltersToSelector(genericSelector, new HashSet<>());

    // Assert
    verify(genericSelector).selector();
  }

  /**
   * Method under test:
   * {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  void testApplyFiltersToSelector2() {
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
   * Method under test:
   * {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  void testApplyFiltersToSelector3() {
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
   * Method under test:
   * {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  void testApplyFiltersToSelector4() {
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
   * Method under test:
   * {@link AssessmentRatingBasedGenericSelectorFactory#applyFiltersToSelector(GenericSelector, Set)}
   */
  @Test
  void testApplyFiltersToSelector5() {
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
}
