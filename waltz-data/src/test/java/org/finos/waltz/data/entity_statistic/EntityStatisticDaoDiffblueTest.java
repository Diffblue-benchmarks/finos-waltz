package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_statistic.EntityStatistic;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityStatisticDao#findStatisticsForEntity(EntityReference, boolean)}
   */
  @Test
  void testFindStatisticsForEntity() throws SQLException {
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
    EntityStatisticDao entityStatisticDao = new EntityStatisticDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<EntityStatistic> actualFindStatisticsForEntityResult = entityStatisticDao.findStatisticsForEntity(ref, true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"es\".\"name\", \"es\".\"description\", \"es\".\"type\", \"es\".\"category\", \"es\".\"active\", \"es\".\"renderer\", \"es\".\"historic_renderer\", \"es\".\"provenance\", \"es\".\"parent_id\", \"es\".\"id\", \"es\".\"entity_visibility\", \"es\".\"rollup_visibility\", \"es\".\"rollup_kind\", \"es\".\"external_id\", \"esv\".\"id\", \"esv\".\"statistic_id\", \"esv\".\"entity_kind\", \"esv\".\"entity_id\", \"esv\".\"value\", \"esv\".\"outcome\", \"esv\".\"state\", \"esv\".\"reason\", \"esv\".\"created_at\", \"esv\".\"current\", \"esv\".\"provenance\" from \"entity_statistic_definition\" \"es\" join \"entity_statistic_value\" \"esv\" on \"esv\".\"statistic_id\" = \"es\".\"id\" where ((\"es\".\"active\" = true and \"es\".\"entity_visibility\" = true and \"esv\".\"entity_kind\" = 'ALL' and \"esv\".\"entity_id\" = 1 and \"esv\".\"current\" = true))"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindStatisticsForEntityResult.isEmpty());
  }
}
