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
import java.util.Optional;
import org.finos.waltz.data.survey.SurveyQuestionDropdownEntryDao;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyQuestionDropdownEntryServiceDiffblueTest {
  @Mock private SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao;

  @InjectMocks private SurveyQuestionDropdownEntryService surveyQuestionDropdownEntryService;

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
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

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
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

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
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

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
   *   <li>Given {@link SurveyQuestionDropdownEntry} {@link SurveyQuestionDropdownEntry#id()} return
   *       empty.
   *   <li>Then calls {@link SurveyQuestionDropdownEntry#id()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, List); given SurveyQuestionDropdownEntry id() return empty; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_givenSurveyQuestionDropdownEntryIdReturnEmpty_thenCallsId() {
    // Arrange
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry =
        mock(SurveyQuestionDropdownEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(surveyQuestionDropdownEntry.id()).thenReturn(emptyResult);
    Optional<Long> emptyResult2 = Optional.empty();
    when(surveyQuestionDropdownEntry.questionId()).thenReturn(emptyResult2);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
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
   * Test {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDropdownEntry} {@link SurveyQuestionDropdownEntry#id()} return
   *       of one.
   *   <li>Then calls {@link SurveyQuestionDropdownEntry#id()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntryService#saveEntries(long, List)}
   */
  @Test
  @DisplayName(
      "Test saveEntries(long, List); given SurveyQuestionDropdownEntry id() return of one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyQuestionDropdownEntryService.saveEntries(long, List)"})
  void testSaveEntries_givenSurveyQuestionDropdownEntryIdReturnOfOne_thenCallsId() {
    // Arrange
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

    SurveyQuestionDropdownEntry surveyQuestionDropdownEntry =
        mock(SurveyQuestionDropdownEntry.class);
    when(surveyQuestionDropdownEntry.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.of(1L);
    when(surveyQuestionDropdownEntry.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.of(1L);
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
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());

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
    when(surveyQuestionDropdownEntryDao.findForSurveyInstance(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyInstanceResult =
        surveyQuestionDropdownEntryService.findForSurveyInstance(1L);

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
    when(surveyQuestionDropdownEntryDao.findForSurveyTemplate(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestionDropdownEntry> actualFindForSurveyTemplateResult =
        surveyQuestionDropdownEntryService.findForSurveyTemplate(1L);

    // Assert
    verify(surveyQuestionDropdownEntryDao).findForSurveyTemplate(1L);
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }
}
