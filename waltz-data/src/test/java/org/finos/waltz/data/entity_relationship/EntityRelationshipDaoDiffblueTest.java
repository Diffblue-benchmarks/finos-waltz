package org.finos.waltz.data.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.UpdateEntityRelationshipParams;
import org.finos.waltz.schema.tables.records.EntityRelationshipRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityRelationshipDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityRelationshipDao#findRelationshipsInvolving(EntityReference)}
   */
  @Test
  void testFindRelationshipsInvolving() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Collection<EntityRelationship> actualFindRelationshipsInvolvingResult = entityRelationshipDao
        .findRelationshipsInvolving(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_relationship\".\"kind_a\", \"entity_relationship\".\"id_a\", \"entity_relationship\".\"kind_b\", \"entity_relationship\".\"id_b\", \"entity_relationship\".\"relationship\", \"entity_relationship\".\"provenance\", \"entity_relationship\".\"description\", \"entity_relationship\".\"last_updated_at\", \"entity_relationship\".\"last_updated_by\", \"entity_relationship\".\"id\", case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end, case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end from \"entity_relationship\" where ((\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ?) or (\"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualFindRelationshipsInvolvingResult instanceof List);
    assertTrue(actualFindRelationshipsInvolvingResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#tallyRelationshipsInvolving(EntityReference)}
   */
  @Test
  void testTallyRelationshipsInvolving() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Map<EntityKind, Integer> actualTallyRelationshipsInvolvingResult = entityRelationshipDao
        .tallyRelationshipsInvolving(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_relationship\".\"kind_b\", count(*) from \"entity_relationship\" where (\"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"id_a\" = ?) group by \"entity_relationship\".\"kind_b\" union all select \"entity_relationship\".\"kind_a\", count(*) from \"entity_relationship\" where (\"entity_relationship\".\"kind_b\" = ? and \"entity_relationship\".\"id_b\" = ?) group by \"entity_relationship\".\"kind_a\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualTallyRelationshipsInvolvingResult.isEmpty());
  }

  /**
   * Method under test: {@link EntityRelationshipDao#getById(Long)}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    EntityRelationship actualById = (new EntityRelationshipDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_relationship\".\"kind_a\", \"entity_relationship\".\"id_a\", \"entity_relationship\".\"kind_b\", \"entity_relationship\".\"id_b\", \"entity_relationship\".\"relationship\", \"entity_relationship\".\"provenance\", \"entity_relationship\".\"description\", \"entity_relationship\".\"last_updated_at\", \"entity_relationship\".\"last_updated_by\", \"entity_relationship\".\"id\", case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"name\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end, case when \"entity_relationship\".\"kind_a\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_a\") when \"entity_relationship\".\"kind_a\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_a\") end, case when \"entity_relationship\".\"kind_b\" = ? then (select \"application\".\"asset_code\" from \"application\" where \"application\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"application_group\".\"external_id\" from \"application_group\" where \"application_group\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"actor\".\"external_id\" from \"actor\" where \"actor\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = \"entity_relationship\".\"id_b\") when \"entity_relationship\".\"kind_b\" = ? then (select \"change_initiative\".\"external_id\" from \"change_initiative\" where \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\") end from \"entity_relationship\" where \"entity_relationship\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(21), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b()).thenReturn(entityReference2);
    when(key.a()).thenReturn(entityReference);

    // Act
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);
    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b()).thenReturn(entityReference2);
    when(key.a()).thenReturn(entityReference);

    // Act
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<EntityRelationshipRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<EntityRelationshipRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(updateSetFirstStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b()).thenReturn(entityReference2);
    when(key.a()).thenReturn(entityReference);
    UpdateEntityRelationshipParams params = mock(UpdateEntityRelationshipParams.class);
    when(params.description()).thenReturn("The characteristics of someone or something");
    when(params.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    boolean actualUpdateResult = entityRelationshipDao.update(key, params, "janedoe");

    // Assert
    verify(params).description();
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(params).relationshipKind();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<EntityRelationshipRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<EntityRelationshipRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(updateSetFirstStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b()).thenReturn(entityReference2);
    when(key.a()).thenReturn(entityReference);
    UpdateEntityRelationshipParams params = mock(UpdateEntityRelationshipParams.class);
    when(params.description()).thenReturn("The characteristics of someone or something");
    when(params.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    boolean actualUpdateResult = entityRelationshipDao.update(key, params, "janedoe");

    // Assert
    verify(params).description();
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(params).relationshipKind();
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  void testSaveAll() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  void testSaveAll2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  void testSaveAll3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, changeInitiativeIds);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  void testSaveAll4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(2L);
    changeInitiativeIds.add(1L);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, changeInitiativeIds);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  void testRemoveAll() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"id_b\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  void testRemoveAll2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, new ArrayList<>());

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  void testRemoveAll3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, changeInitiativeIds);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  void testRemoveAll4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<EntityRelationshipRecord>>any())).thenReturn(deleteUsingStep);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(0L);
    changeInitiativeIds.add(1L);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, changeInitiativeIds);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Method under test:
   * {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference, String)}
   */
  @Test
  void testMigrateEntityRelationships() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    (new EntityRelationshipDao(dsl)).migrateEntityRelationships(null, null, "42");

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }
}
