package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyQuestionServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyQuestionService#findForSurveyTemplate(long)}
   */
  @Test
  void testFindForSurveyTemplate() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);

    // Act
    List<SurveyQuestion> actualFindForSurveyTemplateResult = (new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).findForSurveyTemplate(1L);

    // Assert
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
    assertSame(surveyQuestionList, actualFindForSurveyTemplateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForSurveyTemplate(long)}
   */
  @Test
  void testFindForSurveyTemplate2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).findForSurveyTemplate(1L));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForSurveyRun(long)}
   */
  @Test
  void testFindForSurveyRun() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    when(surveyQuestionDao.findForSurveyRun(anyLong())).thenReturn(surveyQuestionList);

    // Act
    List<SurveyQuestion> actualFindForSurveyRunResult = (new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).findForSurveyRun(1L);

    // Assert
    verify(surveyQuestionDao).findForSurveyRun(eq(1L));
    assertTrue(actualFindForSurveyRunResult.isEmpty());
    assertSame(surveyQuestionList, actualFindForSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForSurveyRun(long)}
   */
  @Test
  void testFindForSurveyRun2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForSurveyRun(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).findForSurveyRun(1L));
    verify(surveyQuestionDao).findForSurveyRun(eq(1L));
  }

  /**
   * Method under test: {@link SurveyQuestionService#create(SurveyQuestion)}
   */
  @Test
  void testCreate() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

    // Act
    long actualCreateResult = (new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).create(mock(SurveyQuestion.class));

    // Assert
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#create(SurveyQuestion)}
   */
  @Test
  void testCreate2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException("surveyQuestion cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class))))
                    .create(mock(SurveyQuestion.class)));
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
  }

  /**
   * Method under test: {@link SurveyQuestionService#update(SurveyQuestion)}
   */
  @Test
  void testUpdate() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.update(Mockito.<SurveyQuestion>any())).thenReturn(1);
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = surveyQuestionService.update(surveyQuestion);

    // Assert
    verify(surveyQuestionDao).update(isA(SurveyQuestion.class));
    verify(surveyQuestion).id();
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#update(SurveyQuestion)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.update(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException("surveyQuestion cannot be null"));
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyQuestionService.update(surveyQuestion));
    verify(surveyQuestionDao).update(isA(SurveyQuestion.class));
    verify(surveyQuestion).id();
  }

  /**
   * Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.hasResponses(anyLong())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).delete(1L));
    verify(surveyQuestionDao).hasResponses(eq(1L));
  }

  /**
   * Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  void testDelete2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.hasResponses(anyLong())).thenReturn(false);
    when(surveyQuestionDao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = (new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).delete(1L);

    // Assert
    verify(surveyQuestionDao).delete(eq(1L));
    verify(surveyQuestionDao).hasResponses(eq(1L));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  void testDelete3() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.hasResponses(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyQuestionService(surveyQuestionDao,
            new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
                mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)))).delete(1L));
    verify(surveyQuestionDao).hasResponses(eq(1L));
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  void testFindForIds() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));

    // Act and Assert
    assertTrue(surveyQuestionService.findForIds(new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  void testFindForIds2() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    HashSet<SurveyQuestion> surveyQuestionSet = new HashSet<>();
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any())).thenReturn(surveyQuestionSet);
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionService.findForIds(surveyQuestionsIds);

    // Assert
    verify(surveyQuestionDao).findForIds(isA(Set.class));
    assertTrue(actualFindForIdsResult.isEmpty());
    assertSame(surveyQuestionSet, actualFindForIdsResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  void testFindForIds3() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    HashSet<SurveyQuestion> surveyQuestionSet = new HashSet<>();
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any())).thenReturn(surveyQuestionSet);
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(0L);
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult = surveyQuestionService.findForIds(surveyQuestionsIds);

    // Assert
    verify(surveyQuestionDao).findForIds(isA(Set.class));
    assertTrue(actualFindForIdsResult.isEmpty());
    assertSame(surveyQuestionSet, actualFindForIdsResult);
  }

  /**
   * Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  void testFindForIds4() {
    // Arrange
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any())).thenThrow(new IllegalArgumentException("foo"));
    SurveyQuestionService surveyQuestionService = new SurveyQuestionService(surveyQuestionDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)));

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyQuestionService.findForIds(surveyQuestionsIds));
    verify(surveyQuestionDao).findForIds(isA(Set.class));
  }
}
