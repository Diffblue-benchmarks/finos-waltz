package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.survey.SurveyQuestionDropdownEntryDao;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionDropdownEntryServiceDiffblueTest {
  /**
   * Test {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}.
   *
   * <ul>
   *   <li>Given builder id one position one questionId one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, List); given builder id one position one questionId one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_givenBuilderIdOnePositionOneQuestionIdOneValue42Build() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(1L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}.
   *
   * <ul>
   *   <li>Given builder id one position one questionId one value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, List); given builder id one position one questionId one value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_givenBuilderIdOnePositionOneQuestionIdOneValue42Build2() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(1L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}.
   *
   * <ul>
   *   <li>Given builder id one position one questionId one value {@code 42} build.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, List); given builder id one position one questionId one value '42' build; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_givenBuilderIdOnePositionOneQuestionIdOneValue42Build_whenTwo() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao);

    ArrayList<SurveyQuestionDropdownEntry> entries = new ArrayList<>();
    entries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    // Act
    boolean actualSaveEntriesResult = surveyQuestionDropdownEntryService.saveEntries(2L, entries);

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(2L), isA(Collection.class));
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName("Test saveEntries(long, List); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_whenArrayList_thenReturnTrue() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
    SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao);

    // Act
    boolean actualSaveEntriesResult =
        surveyQuestionDropdownEntryService.saveEntries(1L, new ArrayList<>());

    // Assert
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    assertTrue(actualSaveEntriesResult);
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryService#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDropdownEntryService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.findForSurveyInstance(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyInstanceResult =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao)
            .findForSurveyInstance(1L);

    // Assert
    verify(surveyQuestionDropdownEntryDao).findForSurveyInstance(1L);
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionDropdownEntryService#findForSurveyTemplate(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#findForSurveyTemplate(long)}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionDropdownEntryService.findForSurveyTemplate(long)"})
  void testFindForSurveyTemplate() {
    // Arrange
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.findForSurveyTemplate(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyTemplateResult =
        new SurveyQuestionDropdownEntryService(surveyQuestionDropdownEntryDao)
            .findForSurveyTemplate(1L);

    // Assert
    verify(surveyQuestionDropdownEntryDao).findForSurveyTemplate(1L);
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }
}
