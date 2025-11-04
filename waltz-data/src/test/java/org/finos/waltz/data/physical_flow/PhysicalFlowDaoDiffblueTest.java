package org.finos.waltz.data.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlowInfo;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.schema.tables.records.PhysicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
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

class PhysicalFlowDaoDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalFlowDao#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() throws SQLException {
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
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<PhysicalFlow> actualFindByEntityReferenceResult = physicalFlowDao.findByEntityReference(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" join \"logical_flow\" on \"logical_flow\".\"id\" = \"physical_flow\".\"logical_flow_id\" where (((\"logical_flow\".\"target_entity_id\" = 1 and \"logical_flow\".\"target_entity_kind\" = 'ALL' and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> 'REMOVED')) and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?) union select distinct \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" join \"physical_specification\" on \"physical_specification\".\"id\" = \"physical_flow\".\"specification_id\" join \"logical_flow\" on \"logical_flow\".\"id\" = \"physical_flow\".\"logical_flow_id\" where (((\"logical_flow\".\"source_entity_id\" = 1 and \"logical_flow\".\"source_entity_kind\" = 'ALL' and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> 'REMOVED')) and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowDao#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() throws SQLException {
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
    List<PhysicalFlow> actualFindByExternalIdResult = (new PhysicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" left outer join \"external_identifier\" on (\"external_identifier\".\"entity_id\" = \"physical_flow\".\"id\" and \"external_identifier\".\"entity_kind\" = ?) where (\"physical_flow\".\"external_id\" = ? or \"external_identifier\".\"external_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowDao#getById(long)}
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
    PhysicalFlow actualById = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" where \"physical_flow\".\"id\" = ?"));
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
   * Method under test: {@link PhysicalFlowDao#getByIdAndIsRemoved(long, boolean)}
   */
  @Test
  void testGetByIdAndIsRemoved() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    PhysicalFlow actualByIdAndIsRemoved = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByIdAndIsRemoved(1L, true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" where (\"physical_flow\".\"id\" = ? and \"physical_flow\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(true));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByIdAndIsRemoved);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#findBySpecificationId(long)}
   */
  @Test
  void testFindBySpecificationId() throws SQLException {
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
    List<PhysicalFlow> actualFindBySpecificationIdResult = (new PhysicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findBySpecificationId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"id\", \"physical_flow\".\"specification_id\", \"physical_flow\".\"basis_offset\", \"physical_flow\".\"frequency\", \"physical_flow\".\"transport\", \"physical_flow\".\"description\", \"physical_flow\".\"provenance\", \"physical_flow\".\"last_updated_at\", \"physical_flow\".\"last_updated_by\", \"physical_flow\".\"logical_flow_id\", \"physical_flow\".\"specification_definition_id\", \"physical_flow\".\"is_removed\", \"physical_flow\".\"last_attested_at\", \"physical_flow\".\"last_attested_by\", \"physical_flow\".\"criticality\", \"physical_flow\".\"external_id\", \"physical_flow\".\"entity_lifecycle_status\", \"physical_flow\".\"created_at\", \"physical_flow\".\"created_by\", \"physical_flow\".\"is_readonly\", \"physical_flow\".\"name\" from \"physical_flow\" where \"physical_flow\".\"specification_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindBySpecificationIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).delete(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_flow\" set \"physical_flow\".\"is_removed\" = ?, \"physical_flow\".\"entity_lifecycle_status\" = ? where (\"physical_flow\".\"id\" = ? and \"physical_flow\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("REMOVED"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#delete(long)}
   */
  @Test
  void testDelete2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualDeleteResult = (new PhysicalFlowDao(dsl)).delete(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#create(PhysicalFlow)}
   */
  @Test
  void testCreate() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    UserTimestamp userTimestamp = mock(UserTimestamp.class);
    when(userTimestamp.by()).thenReturn("By");
    when(userTimestamp.atTimestamp()).thenReturn(mock(Timestamp.class));
    Optional<UserTimestamp> ofResult = Optional.of(userTimestamp);
    PhysicalFlow flow = mock(PhysicalFlow.class);
    when(flow.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(flow.externalId()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(flow.lastAttestedAt()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(flow.lastAttestedBy()).thenReturn(ofResult4);
    when(flow.isRemoved()).thenReturn(true);
    when(flow.description()).thenReturn("The characteristics of someone or something");
    when(flow.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flow.specificationId()).thenReturn(1L);
    when(flow.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(flow.basisOffset()).thenReturn(1);
    when(flow.criticality()).thenReturn(CriticalityValue.of("42"));
    when(flow.transport()).thenReturn(TransportKindValue.of("42"));
    when(flow.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(flow.id()).thenReturn(emptyResult);
    when(flow.logicalFlowId()).thenReturn(1L);
    when(flow.frequency()).thenReturn(FrequencyKindValue.of("42"));

    // Act
    long actualCreateResult = physicalFlowDao.create(flow);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"physical_flow\" (\"specification_id\", \"basis_offset\", \"frequency\", \"transport\", \"description\", \"provenance\", \"last_updated_at\", \"last_updated_by\", \"logical_flow_id\", \"is_removed\", \"last_attested_at\", \"last_attested_by\", \"criticality\", \"external_id\", \"created_at\", \"created_by\", \"name\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setBoolean(eq(10), eq(true));
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(flow, atLeast(1)).created();
    verify(flow).description();
    verify(flow).externalId();
    verify(flow).id();
    verify(flow).isRemoved();
    verify(flow).lastAttestedAt();
    verify(flow).lastAttestedBy();
    verify(flow, atLeast(1)).lastUpdatedAt();
    verify(flow, atLeast(1)).lastUpdatedBy();
    verify(userTimestamp).atTimestamp();
    verify(userTimestamp).by();
    verify(flow).basisOffset();
    verify(flow).criticality();
    verify(flow).frequency();
    verify(flow).logicalFlowId();
    verify(flow).name();
    verify(flow).specificationId();
    verify(flow).transport();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}
   */
  @Test
  void testUpdateSpecDefinition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateSpecDefinitionResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateSpecDefinition("janedoe", 1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_flow\" set \"physical_flow\".\"specification_definition_id\" = ?, \"physical_flow\".\"last_updated_by\" = ?, \"physical_flow\".\"last_updated_at\" = ? where (\"physical_flow\".\"id\" = ? and (\"physical_flow\".\"specification_definition_id\" is null or \"physical_flow\".\"specification_definition_id\" <> ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("janedoe"));
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSpecDefinitionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}
   */
  @Test
  void testUpdateSpecDefinition2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateSpecDefinitionResult = (new PhysicalFlowDao(dsl)).updateSpecDefinition("janedoe", 1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateSpecDefinitionResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCleanupOrphansResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualCleanupOrphansResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}
   */
  @Test
  void testUpdateCriticality() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateCriticalityResult = physicalFlowDao.updateCriticality(1L, CriticalityValue.of("42"));

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"criticality\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateCriticalityResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}
   */
  @Test
  void testUpdateCriticality2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateCriticalityResult = physicalFlowDao.updateCriticality(1L, CriticalityValue.of("42"));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateCriticalityResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}
   */
  @Test
  void testUpdateFrequency() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateFrequencyResult = physicalFlowDao.updateFrequency(1L, FrequencyKindValue.of("42"));

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"frequency\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFrequencyResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}
   */
  @Test
  void testUpdateFrequency2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateFrequencyResult = physicalFlowDao.updateFrequency(1L, FrequencyKindValue.of("42"));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateFrequencyResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateExternalId(long, String)}
   */
  @Test
  void testUpdateExternalId() throws SQLException {
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
    int actualUpdateExternalIdResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateExternalId(1L, "42");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"external_id\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateExternalId(long, String)}
   */
  @Test
  void testUpdateExternalId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateExternalIdResult = (new PhysicalFlowDao(dsl)).updateExternalId(1L, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  void testUpdateTransport() throws SQLException {
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
    int actualUpdateTransportResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateTransport(1L, "Transport");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_flow\" set \"physical_flow\".\"transport\" = ? where (\"physical_flow\".\"id\" = ? and exists (select \"enum_value\".\"type\", \"enum_value\".\"key\", \"enum_value\".\"display_name\", \"enum_value\".\"description\", \"enum_value\".\"icon_name\", \"enum_value\".\"position\", \"enum_value\".\"icon_color\" from \"enum_value\" where (\"enum_value\".\"type\" = ? and \"enum_value\".\"key\" = ?)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateTransportResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  void testUpdateTransport2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateTransportResult = (new PhysicalFlowDao(dsl)).updateTransport(1L, "Transport");

    // Assert
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateTransportResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  void testUpdateBasisOffset() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateBasisOffsetResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateBasisOffset(1L, 3);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"basis_offset\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(3));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateBasisOffsetResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  void testUpdateBasisOffset2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = (new PhysicalFlowDao(dsl)).updateBasisOffset(1L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  void testUpdateBasisOffset3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = (new PhysicalFlowDao(dsl)).updateBasisOffset(2L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  void testUpdateBasisOffset4() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = (new PhysicalFlowDao(dsl)).updateBasisOffset(3L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  void testUpdateBasisOffset5() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = (new PhysicalFlowDao(dsl)).updateBasisOffset(4L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
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
    int actualUpdateDescriptionResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"description\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("The characteristics of someone or something"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDescriptionResult = (new PhysicalFlowDao(dsl)).updateDescription(1L,
        "The characteristics of someone or something");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}
   */
  @Test
  void testUpdateEntityLifecycleStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdateEntityLifecycleStatusResult = (new PhysicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateEntityLifecycleStatus(1L,
            EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"physical_flow\" set \"physical_flow\".\"entity_lifecycle_status\" = ?, \"physical_flow\".\"is_removed\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}
   */
  @Test
  void testUpdateEntityLifecycleStatus2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateEntityLifecycleStatusResult = (new PhysicalFlowDao(dsl)).updateEntityLifecycleStatus(1L,
        EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}
   */
  @Test
  void testUpdateEntityLifecycleStatus3() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateEntityLifecycleStatusResult = (new PhysicalFlowDao(dsl)).updateEntityLifecycleStatus(1L,
        EntityLifecycleStatus.REMOVED);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  void testHasPhysicalFlows() throws SQLException {
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasPhysicalFlowsResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .hasPhysicalFlows(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  void testHasPhysicalFlows2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualHasPhysicalFlowsResult = (new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .hasPhysicalFlows(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Method under test: {@link PhysicalFlowDao#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  void testFindUnderlyingPhysicalFlows() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<PhysicalFlowInfo> actualFindUnderlyingPhysicalFlowsResult = (new PhysicalFlowDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findUnderlyingPhysicalFlows(1L);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualFindUnderlyingPhysicalFlowsResult.isEmpty());
  }
}
