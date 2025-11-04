package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.entity_statistic.EntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.RollupKind;
import org.finos.waltz.model.entity_statistic.StatisticCategory;
import org.finos.waltz.model.entity_statistic.StatisticType;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticDefinitionDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  void testInsert() throws SQLException {
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
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"entity_statistic_definition\" (\"name\", \"description\", \"type\", \"category\", \"active\", \"renderer\", \"historic_renderer\", \"provenance\", \"parent_id\", \"id\", \"entity_visibility\", \"rollup_visibility\", \"rollup_kind\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    assertFalse(actualInsertResult);
  }

  /**
   * Method under test:
   * {@link EntityStatisticDefinitionDao#findAllActiveDefinitions(boolean)}
   */
  @Test
  void testFindAllActiveDefinitions() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<EntityStatisticDefinition> actualFindAllActiveDefinitionsResult = (new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllActiveDefinitions(true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where (\"esd\".\"active\" = ? and \"esd\".\"rollup_visibility\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllActiveDefinitionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityStatisticDefinitionDao#findRelated(long, boolean)}
   */
  @Test
  void testFindRelated() throws SQLException {
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
    List<EntityStatisticDefinition> actualFindRelatedResult = (new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRelated(1L, true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where ((\"esd\".\"parent_id\" = ? or \"esd\".\"id\" = ? or \"esd\".\"id\" = (select \"esd\".\"parent_id\" from \"entity_statistic_definition\" \"esd\" where \"esd\".\"id\" = ?)) and \"esd\".\"active\" = ? and \"esd\".\"rollup_visibility\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Method under test: {@link EntityStatisticDefinitionDao#getById(long)}
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
    EntityStatisticDefinition actualById = (new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where \"esd\".\"id\" = ?"));
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
   * Method under test: {@link EntityStatisticDefinitionDao#findByIds(List)}
   */
  @Test
  void testFindByIds() throws SQLException {
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
    EntityStatisticDefinitionDao entityStatisticDefinitionDao = new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<EntityStatisticDefinition> actualFindByIdsResult = entityStatisticDefinitionDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where \"esd\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByIdsResult.isEmpty());
  }
}
