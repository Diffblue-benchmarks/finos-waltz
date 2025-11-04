package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.Set;
import org.finos.waltz.model.legal_entity.LegalEntityRelKindStat;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipKindDaoDiffblueTest {
  /**
   * Method under test: {@link LegalEntityRelationshipKindDao#getById(long)}
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
    LegalEntityRelationshipKind actualById = (new LegalEntityRelationshipKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship_kind\".\"id\", \"legal_entity_relationship_kind\".\"name\", \"legal_entity_relationship_kind\".\"description\", \"legal_entity_relationship_kind\".\"target_kind\", \"legal_entity_relationship_kind\".\"cardinality\", \"legal_entity_relationship_kind\".\"required_role\", \"legal_entity_relationship_kind\".\"external_id\", \"legal_entity_relationship_kind\".\"last_updated_at\", \"legal_entity_relationship_kind\".\"last_updated_by\", \"legal_entity_relationship_kind\".\"provenance\" from \"legal_entity_relationship_kind\" where \"legal_entity_relationship_kind\".\"id\" = ?"));
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
   * Method under test: {@link LegalEntityRelationshipKindDao#findAll()}
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<LegalEntityRelationshipKind> actualFindAllResult = (new LegalEntityRelationshipKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship_kind\".\"id\", \"legal_entity_relationship_kind\".\"name\", \"legal_entity_relationship_kind\".\"description\", \"legal_entity_relationship_kind\".\"target_kind\", \"legal_entity_relationship_kind\".\"cardinality\", \"legal_entity_relationship_kind\".\"required_role\", \"legal_entity_relationship_kind\".\"external_id\", \"legal_entity_relationship_kind\".\"last_updated_at\", \"legal_entity_relationship_kind\".\"last_updated_by\", \"legal_entity_relationship_kind\".\"provenance\" from \"legal_entity_relationship_kind\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link LegalEntityRelationshipKindDao#findUsageStats()}
   */
  @Test
  void testFindUsageStats() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<LegalEntityRelKindStat> actualFindUsageStatsResult = (new LegalEntityRelationshipKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findUsageStats();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"legal_entity_relationship_kind\".\"id\", coalesce(\"alias_113203163\".\"leCount\", ?), coalesce(\"alias_92550347\".\"teCount\", ?), coalesce(\"alias_123785241\".\"relCount\", ?) from \"legal_entity_relationship_kind\" left outer join (select \"leRels\".\"relationship_kind_id\", count(distinct \"leRels\".\"legal_entity_id\") \"leCount\" from \"legal_entity_relationship\" \"leRels\" where 1 = 1 group by \"leRels\".\"relationship_kind_id\") \"alias_113203163\" on \"legal_entity_relationship_kind\".\"id\" = \"alias_113203163\".\"relationship_kind_id\" left outer join (select \"teRels\".\"relationship_kind_id\", count(distinct \"teRels\".\"target_id\") \"teCount\" from \"legal_entity_relationship\" \"teRels\" where 1 = 1 group by \"teRels\".\"relationship_kind_id\") \"alias_92550347\" on \"legal_entity_relationship_kind\".\"id\" = \"alias_92550347\".\"relationship_kind_id\" left outer join (select \"rels\".\"relationship_kind_id\", count(distinct \"rels\".\"id\") \"relCount\" from \"legal_entity_relationship\" \"rels\" where 1 = 1 group by \"rels\".\"relationship_kind_id\") \"alias_123785241\" on \"legal_entity_relationship_kind\".\"id\" = \"alias_123785241\".\"relationship_kind_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindUsageStatsResult.size());
  }
}
