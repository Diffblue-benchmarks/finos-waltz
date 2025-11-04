package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.survey.SurveyQuestionDropdownEntryDao;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionDropdownEntryServiceDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  void testSaveEntries() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    doNothing().when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService = new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao);

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  void testSaveEntries2() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    doNothing().when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService = new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao);
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry);

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(1L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry).value();
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  void testSaveEntries3() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    doNothing().when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService = new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao);
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry);

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(2L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(2L), isA(Collection.class));
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry).value();
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  void testSaveEntries4() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    doNothing().when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService = new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao);
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(ofResult2);
    when(surveyQuestionDropdownEntry.value()).thenReturn("42");
    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry2 = mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry2.position()).thenReturn(1);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry2.id()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(surveyQuestionDropdownEntry2.questionId()).thenReturn(ofResult4);
    when(surveyQuestionDropdownEntry2.value()).thenReturn("42");

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(surveyQuestionDropdownEntry2);
    entries.add(surveyQuestionDropdownEntry);

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(1L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    verify(surveyQuestionDropdownEntry2).id();
    verify(surveyQuestionDropdownEntry).id();
    verify(surveyQuestionDropdownEntry2).position();
    verify(surveyQuestionDropdownEntry).position();
    verify(surveyQuestionDropdownEntry2).questionId();
    verify(surveyQuestionDropdownEntry).questionId();
    verify(surveyQuestionDropdownEntry2).value();
    verify(surveyQuestionDropdownEntry).value();
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#findForSurveyInstance(long)}
   */
  @Test
  void testFindForSurveyInstance() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    when(surveyQuestionDropdownEntryDao.findForSurveyInstance(anyLong())).thenReturn(surveyQuestionDropdownEntryList);

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyInstanceResult = (new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao)).findForSurveyInstance(1L);

    // Assert
    verify(surveyQuestionDropdownEntryDao).findForSurveyInstance(eq(1L));
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
    assertSame(surveyQuestionDropdownEntryList, actualFindForSurveyInstanceResult);
  }

  /**
   * Method under test:
   * {@link SurveyQuestionDropdownEntryService#findForSurveyTemplate(long)}
   */
  @Test
  void testFindForSurveyTemplate() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    when(surveyQuestionDropdownEntryDao.findForSurveyTemplate(anyLong())).thenReturn(surveyQuestionDropdownEntryList);

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyTemplateResult = (new SurveyQuestionDropdownEntryService(
        surveyQuestionDropdownEntryDao)).findForSurveyTemplate(1L);

    // Assert
    verify(surveyQuestionDropdownEntryDao).findForSurveyTemplate(eq(1L));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
    assertSame(surveyQuestionDropdownEntryList, actualFindForSurveyTemplateResult);
  }
}
