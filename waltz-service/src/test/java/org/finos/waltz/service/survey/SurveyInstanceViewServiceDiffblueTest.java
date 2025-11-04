package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyViewDao;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.SurveyInstanceFormDetails;
import org.finos.waltz.model.survey.SurveyInstanceInfo;
import org.finos.waltz.model.survey.SurveyInstanceUserInvolvement;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyInstanceViewServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceViewService#getInfoById(long)}
   */
  @Test
  void testGetInfoById() {
    // Arrange
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.getById(anyLong())).thenReturn(null);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    SurveyInstanceInfo actualInfoById = (new SurveyInstanceViewService(personDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        surveyViewDao)).getInfoById(1L);

    // Assert
    verify(surveyViewDao).getById(eq(1L));
    assertNull(actualInfoById);
  }

  /**
   * Method under test: {@link SurveyInstanceViewService#findByPersonId(long)}
   */
  @Test
  void testFindByPersonId() {
    // Arrange
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);

    // Act
    Set<SurveyInstanceInfo> actualFindByPersonIdResult = (new SurveyInstanceViewService(personDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        surveyViewDao)).findByPersonId(1L);

    // Assert
    verify(surveyViewDao).findForOwner(eq(1L));
    verify(surveyViewDao).findForRecipient(eq(1L));
    assertTrue(actualFindByPersonIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyInstanceViewService#getFormDetailsById(long)}
   */
  @Test
  void testGetFormDetailsById() {
    // Arrange
    SurveyInstanceEvaluator instanceEvaluator = mock(SurveyInstanceEvaluator.class);
    when(instanceEvaluator.eval(anyLong())).thenReturn(null);

    // Act
    SurveyInstanceFormDetails actualFormDetailsById = (new SurveyInstanceViewService(mock(PersonDao.class),
        instanceEvaluator, mock(SurveyViewDao.class))).getFormDetailsById(1L);

    // Assert
    verify(instanceEvaluator).eval(eq(1L));
    assertNull(actualFormDetailsById);
  }

  /**
   * Method under test: {@link SurveyInstanceViewService#findForUser(String)}
   */
  @Test
  void testFindForUser() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstanceUserInvolvement> actualFindForUserResult = (new SurveyInstanceViewService(personDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        surveyViewDao)).findForUser("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyViewDao).findForOwner(eq(1L));
    verify(surveyViewDao).findForRecipient(eq(1L));
    verify(person, atLeast(1)).id();
    assertEquals(2, actualFindForUserResult.size());
  }

  /**
   * Method under test: {@link SurveyInstanceViewService#findForUser(String)}
   */
  @Test
  void testFindForUser2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(mock(SurveyInstanceInfo.class));
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyInstanceInfoSet);
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstanceUserInvolvement> actualFindForUserResult = (new SurveyInstanceViewService(personDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        surveyViewDao)).findForUser("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyViewDao).findForOwner(eq(1L));
    verify(surveyViewDao).findForRecipient(eq(1L));
    verify(person, atLeast(1)).id();
    assertEquals(2, actualFindForUserResult.size());
  }

  /**
   * Method under test: {@link SurveyInstanceViewService#findForUser(String)}
   */
  @Test
  void testFindForUser3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(mock(SurveyInstanceInfo.class));
    surveyInstanceInfoSet.add(mock(SurveyInstanceInfo.class));
    SurveyViewDao surveyViewDao = mock(SurveyViewDao.class);
    when(surveyViewDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyInstanceInfoSet);
    when(surveyViewDao.findForRecipient(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<SurveyInstanceUserInvolvement> actualFindForUserResult = (new SurveyInstanceViewService(personDao,
        new SurveyInstanceEvaluator(new DefaultDSLContext(SQLDialect.SQL99), mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class), mock(SurveyQuestionResponseDao.class)),
        surveyViewDao)).findForUser("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyViewDao).findForOwner(eq(1L));
    verify(surveyViewDao).findForRecipient(eq(1L));
    verify(person, atLeast(1)).id();
    assertEquals(2, actualFindForUserResult.size());
  }
}
