package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.model.survey.SurveyTemplateChangeCommand;
import org.finos.waltz.schema.tables.records.SurveyTemplateRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyTemplateDaoDiffblueTest {
  /**
   * Method under test: {@link SurveyTemplateDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SurveyTemplate actualById = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\" from \"survey_template\" where \"survey_template\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#findForOwner(Long)}
   */
  @Test
  void testFindForOwner() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForOwner(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\" from \"survey_template\" where (\"survey_template\".\"status\" = ? or (\"survey_template\".\"status\" = ? and \"survey_template\".\"owner_id\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindForOwnerResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyTemplateDao#findAllActive()}
   */
  @Test
  void testFindAllActive() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyTemplate> actualFindAllActiveResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllActive();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\" from \"survey_template\" where \"survey_template\".\"status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllActiveResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyTemplateDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<SurveyTemplate> actualFindAllResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\" from \"survey_template\" where \"survey_template\".\"status\" <> ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("DRAFT"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyTemplateDao#findByCondition(Condition)}
   */
  @Test
  void testFindByCondition() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<SurveyTemplate> actualFindByConditionResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\" from \"survey_template\" where \"application\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByConditionResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyTemplateDao#create(SurveyTemplate)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult);
    when(surveyTemplate.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(surveyTemplate.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(surveyTemplate.ownerId()).thenReturn(1L);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    long actualCreateResult = surveyTemplateDao.create(surveyTemplate);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"survey_template\" (\"name\", \"description\", \"target_entity_kind\", \"owner_id\", \"created_at\", \"status\", \"external_id\", \"issuance_role\") values (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(surveyTemplate).description();
    verify(surveyTemplate).externalId();
    verify(surveyTemplate).name();
    verify(surveyTemplate).createdAt();
    verify(surveyTemplate).issuanceRole();
    verify(surveyTemplate).ownerId();
    verify(surveyTemplate).status();
    verify(surveyTemplate).targetEntityKind();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_template\" set \"survey_template\".\"name\" = ?, \"survey_template\".\"description\" = ?, \"survey_template\".\"external_id\" = ?, \"survey_template\".\"target_entity_kind\" = ?, \"survey_template\".\"issuance_role\" = ? where \"survey_template\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(6), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#update(SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyTemplateDao surveyTemplateDao = new SurveyTemplateDao(dsl);
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    int actualUpdateResult = surveyTemplateDao.update(command);

    // Assert
    verify(command).description();
    verify(command).externalId();
    verify(command).id();
    verify(command).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}
   */
  @Test
  void testUpdateStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateStatusResult = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateStatus(1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"survey_template\" set \"survey_template\".\"status\" = ? where (\"survey_template\".\"status\" <> ? and \"survey_template\".\"id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#updateStatus(long, ReleaseLifecycleStatus)}
   */
  @Test
  void testUpdateStatus2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyTemplateRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<SurveyTemplateRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<SurveyTemplateRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusResult = (new SurveyTemplateDao(dsl)).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .delete(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_template\" where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyTemplateRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<SurveyTemplateRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<SurveyTemplateRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<SurveyTemplateRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteResult = (new SurveyTemplateDao(dsl)).delete(1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  void testDelete3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.FIREBIRD)))
        .delete(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_template\" where (\"survey_template\".\"id\" = cast(? as bigint) and \"survey_template\".\"status\" = cast(? as varchar(5)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  void testDelete4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .delete(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"survey_template\" where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#delete(long)}
   */
  @Test
  void testDelete5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteResult = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .delete(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from survey_template where (survey_template.id = ? and survey_template.status = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DRAFT"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateDao#getByQuestionId(long)}
   */
  @Test
  void testGetByQuestionId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    SurveyTemplate actualByQuestionId = (new SurveyTemplateDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByQuestionId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"survey_template\".\"id\", \"survey_template\".\"name\", \"survey_template\".\"description\", \"survey_template\".\"target_entity_kind\", \"survey_template\".\"owner_id\", \"survey_template\".\"created_at\", \"survey_template\".\"status\", \"survey_template\".\"external_id\", \"survey_template\".\"issuance_role\", \"survey_question\".\"id\", \"survey_question\".\"survey_template_id\", \"survey_question\".\"question_text\", \"survey_question\".\"field_type\", \"survey_question\".\"section_name\", \"survey_question\".\"position\", \"survey_question\".\"is_mandatory\", \"survey_question\".\"allow_comment\", \"survey_question\".\"help_text\", \"survey_question\".\"external_id\", \"survey_question\".\"inclusion_predicate\", \"survey_question\".\"entity_qualifier_id\", \"survey_question\".\"entity_qualifier_kind\", \"survey_question\".\"parent_external_id\", \"survey_question\".\"label\" from \"survey_template\" join \"survey_question\" on \"survey_template\".\"id\" = \"survey_question\".\"survey_template_id\" where \"survey_question\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByQuestionId);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}
   */
  @Test
  void testCanUserIssueAgainstTemplate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualCanUserIssueAgainstTemplateResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).canUserIssueAgainstTemplate(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"survey_template\".\"id\" from \"survey_template\" left outer join \"user_role\" on (\"user_role\".\"role\" in (\"survey_template\".\"issuance_role\", ?) and \"user_role\".\"user_name\" = ?) where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ? and (\"user_role\".\"role\" is not null or \"survey_template\".\"issuance_role\" is null))) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUserIssueAgainstTemplateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateDao#canUserIssueAgainstTemplate(Long, String)}
   */
  @Test
  void testCanUserIssueAgainstTemplate2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualCanUserIssueAgainstTemplateResult = (new SurveyTemplateDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).canUserIssueAgainstTemplate(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"survey_template\".\"id\" from \"survey_template\" left outer join \"user_role\" on (\"user_role\".\"role\" in (\"survey_template\".\"issuance_role\", ?) and \"user_role\".\"user_name\" = ?) where (\"survey_template\".\"id\" = ? and \"survey_template\".\"status\" = ? and (\"user_role\".\"role\" is not null or \"survey_template\".\"issuance_role\" is null))) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCanUserIssueAgainstTemplateResult);
  }
}
