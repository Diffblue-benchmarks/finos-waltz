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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.model.Duration;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.tally.TallyPack;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticSummaryDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityStatisticSummaryDao#generateWithAvgByValue(Collection, Select)}
   */
  @Test
  void testGenerateWithAvgByValue() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(
        new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(entityStatisticSummaryDao.generateWithAvgByValue(new ArrayList<>(), mock(Select.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticSummaryDao#generateWithSumByValue(Collection, Select)}
   */
  @Test
  void testGenerateWithSumByValue() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(
        new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(entityStatisticSummaryDao.generateWithSumByValue(new ArrayList<>(), mock(Select.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticSummaryDao#generateWithCountByEntity(Collection, Select)}
   */
  @Test
  void testGenerateWithCountByEntity() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(
        new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(entityStatisticSummaryDao.generateWithCountByEntity(new ArrayList<>(), mock(Select.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticSummaryDao#generateWithNoRollup(Collection, EntityReference)}
   */
  @Test
  void testGenerateWithNoRollup() {
    // Arrange
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(
        new DefaultDSLContext(SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));

    // Act and Assert
    assertTrue(
        entityStatisticSummaryDao.generateWithNoRollup(new ArrayList<>(), mock(EntityReference.class)).isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticSummaryDao#generateHistoricWithNoRollup(Long, EntityReference, Duration)}
   */
  @Test
  void testGenerateHistoricWithNoRollup() throws SQLException {
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
    EntityStatisticSummaryDao entityStatisticSummaryDao = new EntityStatisticSummaryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99), mock(DBExecutorPoolInterface.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<TallyPack<String>> actualGenerateHistoricWithNoRollupResult = entityStatisticSummaryDao
        .generateHistoricWithNoRollup(1L, entityReference, Duration.DAY);

    // Assert
    verify(connection).prepareStatement(eq(
        "select cast(\"esv\".\"created_at\" as date) \"esv_created_at_date_only\", \"esv\".\"statistic_id\", \"esv\".\"outcome\", \"esv\".\"value\" from \"entity_statistic_value\" \"esv\" where (((\"esv\".\"statistic_id\" in (1) and \"esv\".\"entity_kind\" = 'ALL' and \"esv\".\"entity_id\" = 1 and \"esv\".\"current\" = false)) and (\"esv\".\"created_at\" > (current_timestamp() - 1))) group by cast(\"esv\".\"created_at\" as date), \"esv\".\"statistic_id\", \"esv\".\"outcome\", \"esv\".\"value\" order by \"esv_created_at_date_only\" asc"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityReference).id();
    verify(entityReference).kind();
    assertTrue(actualGenerateHistoricWithNoRollupResult.isEmpty());
  }
}
