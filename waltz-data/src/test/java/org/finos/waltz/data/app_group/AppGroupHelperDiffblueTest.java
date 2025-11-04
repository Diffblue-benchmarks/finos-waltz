package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupHelperDiffblueTest {
  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, AppGroupHelper.processAdditionsAndRemovals(dsl, additions, new HashSet<>(), "42"));
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals2() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, AppGroupHelper.processAdditionsAndRemovals(dsl, additions, new HashSet<>(), "42"));
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals3() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple2);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions,
        new HashSet<>(), "42");

    // Assert
    verify(entityReference).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals4() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, entityReference2);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple22);
    additions.add(tuple2);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions,
        new HashSet<>(), "42");

    // Assert
    verify(entityReference2).kind();
    verify(entityReference).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals5() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, entityReference2);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple22);
    additions.add(tuple2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple23 = new Tuple2<>(1L, entityReference3);

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    removals.add(tuple23);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals,
        "42");

    // Assert
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(entityReference3).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals6() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, entityReference2);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple22);
    additions.add(tuple2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple23 = new Tuple2<>(1L, entityReference3);

    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple24 = new Tuple2<>(1L, entityReference4);

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    removals.add(tuple24);
    removals.add(tuple23);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals,
        "42");

    // Assert
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(entityReference4).kind();
    verify(entityReference3).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals7() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.APPLICATION);
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, entityReference2);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple22);
    additions.add(tuple2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple23 = new Tuple2<>(1L, entityReference3);

    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple24 = new Tuple2<>(1L, entityReference4);

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    removals.add(tuple24);
    removals.add(tuple23);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals,
        "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group_entry\" (\"group_id\", \"application_id\", \"is_readonly\", \"provenance\") values (?, ?, ?, ?)"));
    verify(preparedStatement).addBatch();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("waltz"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(entityReference4).kind();
    verify(entityReference3).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupHelper#processAdditionsAndRemovals(DSLContext, Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals8() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, entityReference);

    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.APPLICATION);
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, entityReference2);

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    additions.add(tuple22);
    additions.add(tuple2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple23 = new Tuple2<>(1L, entityReference3);

    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.kind()).thenReturn(EntityKind.ALL);
    Tuple2<Long, EntityReference> tuple24 = new Tuple2<>(1L, entityReference4);

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    removals.add(tuple24);
    removals.add(tuple23);

    // Act
    int actualProcessAdditionsAndRemovalsResult = AppGroupHelper.processAdditionsAndRemovals(dsl, additions, removals,
        "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group_entry\" (\"group_id\", \"application_id\", \"is_readonly\", \"provenance\") values (?, ?, ?, ?)"));
    verify(preparedStatement).addBatch();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("waltz"));
    verify(preparedStatement).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(entityReference4).kind();
    verify(entityReference3).kind();
    assertEquals(0, actualProcessAdditionsAndRemovalsResult);
  }
}
