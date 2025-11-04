package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#loadExpandedCellMappingsForDiagram(DSLContext, long)}
   */
  @Test
  void testLoadExpandedCellMappingsForDiagram() throws SQLException {
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
    Set<Tuple2<String, EntityReference>> actualLoadExpandedCellMappingsForDiagramResult = AggregateOverlayDiagramUtilities
        .loadExpandedCellMappingsForDiagram(new DefaultDSLContext(connection, SQLDialect.SQL99), 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"aggregate_overlay_diagram_cell_data\".\"cell_external_id\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\", coalesce(\"entity_hierarchy\".\"id\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") \"related_entity_id\" from \"aggregate_overlay_diagram_cell_data\" left outer join \"entity_hierarchy\" on (\"aggregate_overlay_diagram_cell_data\".\"related_entity_id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\") where \"aggregate_overlay_diagram_cell_data\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualLoadExpandedCellMappingsForDiagramResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#loadCellExtIdToAggregatedEntities(DSLContext, Set, EntityKind, Select, Optional)}
   */
  @Test
  void testLoadCellExtIdToAggregatedEntities() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AggregateOverlayDiagramUtilities.loadCellExtIdToAggregatedEntities(dsl, cellMappings, EntityKind.ALL,
            inScopeEntityIdSelector, targetStateDate));
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  void testToMeasurableIds() {
    // Arrange and Act
    Set<Long> actualToMeasurableIdsResult = AggregateOverlayDiagramUtilities.toMeasurableIds(new HashSet<>());

    // Assert
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  void testToMeasurableIds2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", entityReference);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToMeasurableIdsResult = AggregateOverlayDiagramUtilities.toMeasurableIds(cellMappings);

    // Assert
    verify(entityReference).kind();
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  void testToMeasurableIds3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple22 = new Tuple2<>("V1", entityReference2);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    cellMappings.add(tuple22);
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToMeasurableIdsResult = AggregateOverlayDiagramUtilities.toMeasurableIds(cellMappings);

    // Assert
    verify(entityReference2).kind();
    verify(entityReference).kind();
    assertTrue(actualToMeasurableIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toMeasurableIds(Set)}
   */
  @Test
  void testToMeasurableIds4() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple22 = new Tuple2<>("V1", entityReference2);

    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenThrow(new IllegalArgumentException("foo"));
    Tuple2<String, EntityReference> tuple23 = new Tuple2<>("V1", entityReference3);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    cellMappings.add(tuple23);
    cellMappings.add(tuple22);
    cellMappings.add(tuple2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregateOverlayDiagramUtilities.toMeasurableIds(cellMappings));
    verify(entityReference3).kind();
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  void testToDataTypeIds() {
    // Arrange and Act
    Set<Long> actualToDataTypeIdsResult = AggregateOverlayDiagramUtilities.toDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  void testToDataTypeIds2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", entityReference);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToDataTypeIdsResult = AggregateOverlayDiagramUtilities.toDataTypeIds(cellMappings);

    // Assert
    verify(entityReference).kind();
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#toDataTypeIds(Set)}
   */
  @Test
  void testToDataTypeIds3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple2 = new Tuple2<>("V1", entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<String, EntityReference> tuple22 = new Tuple2<>("V1", entityReference2);

    HashSet<Tuple2<String, EntityReference>> cellMappings = new HashSet<>();
    cellMappings.add(tuple22);
    cellMappings.add(tuple2);

    // Act
    Set<Long> actualToDataTypeIdsResult = AggregateOverlayDiagramUtilities.toDataTypeIds(cellMappings);

    // Assert
    verify(entityReference2).kind();
    verify(entityReference).kind();
    assertTrue(actualToDataTypeIdsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#findMeasurableIdToAggregatedEntityIdMap(DSLContext, EntityKind, Select, Set, Optional)}
   */
  @Test
  void testFindMeasurableIdToAggregatedEntityIdMap() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    Select<Record1<Long>> inScopeEntityIdSelector = mock(Select.class);
    HashSet<Long> backingEntityIds = new HashSet<>();
    Optional<LocalDate> targetStateDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AggregateOverlayDiagramUtilities.findMeasurableIdToAggregatedEntityIdMap(dsl, EntityKind.ALL,
            inScopeEntityIdSelector, backingEntityIds, targetStateDate));
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramUtilities#loadEntityIdToRefMap(DSLContext, EntityKind, Select)}
   */
  @Test
  void testLoadEntityIdToRefMap() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregateOverlayDiagramUtilities
        .loadEntityIdToRefMap(new DefaultDSLContext(SQLDialect.SQL99), EntityKind.ALL, mock(Select.class)));
  }
}
