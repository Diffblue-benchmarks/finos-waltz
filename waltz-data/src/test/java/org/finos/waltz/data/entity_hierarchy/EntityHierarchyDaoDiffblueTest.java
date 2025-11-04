package org.finos.waltz.data.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
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
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TransactionalCallable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityHierarchyDaoDiffblueTest {
  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualReplaceHierarchyResult = entityHierarchyDao.replaceHierarchy(EntityKind.ALL, new ArrayList<>(),
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_hierarchy\" where (\"entity_hierarchy\".\"kind\" = ? and \"application\".\"entity_lifecycle_status\" = ?)"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReplaceHierarchyResult);
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(
        new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    int actualReplaceHierarchyResult = entityHierarchyDao.replaceHierarchy(EntityKind.ALL, new ArrayList<>(),
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_hierarchy\" where (\"entity_hierarchy\".\"kind\" = cast(? as varchar) and \"application\".\"entity_lifecycle_status\" = cast(? as varchar))"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReplaceHierarchyResult);
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    // Act
    int actualReplaceHierarchyResult = entityHierarchyDao.replaceHierarchy(EntityKind.ALL, new ArrayList<>(),
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceHierarchyResult);
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy4() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(mock(DSLContext.class));
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    when(entityHierarchyItem.parentId()).thenThrow(new IllegalArgumentException("kind cannot be null"));
    when(entityHierarchyItem.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(entityHierarchyItem);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityHierarchyDao.replaceHierarchy(EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE));
    verify(entityHierarchyItem).id();
    verify(entityHierarchyItem).parentId();
    verify(entityHierarchyItem).kind();
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy5() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    when(entityHierarchyItem.ancestorLevel()).thenReturn(1);
    when(entityHierarchyItem.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityHierarchyItem.parentId()).thenReturn(ofResult);
    when(entityHierarchyItem.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult2);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(entityHierarchyItem);

    // Act
    int actualReplaceHierarchyResult = entityHierarchyDao.replaceHierarchy(EntityKind.ALL, hierarchyItems,
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(entityHierarchyItem).id();
    verify(entityHierarchyItem).parentId();
    verify(entityHierarchyItem).ancestorLevel();
    verify(entityHierarchyItem).descendantLevel();
    verify(entityHierarchyItem).kind();
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceHierarchyResult);
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy6() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(mock(DSLContext.class));
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityHierarchyItem.parentId()).thenReturn(ofResult);
    when(entityHierarchyItem.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult2);
    EntityHierarchyItem entityHierarchyItem2 = mock(EntityHierarchyItem.class);
    when(entityHierarchyItem2.parentId()).thenThrow(new IllegalArgumentException("kind cannot be null"));
    when(entityHierarchyItem2.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(entityHierarchyItem2.id()).thenReturn(ofResult3);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(entityHierarchyItem2);
    hierarchyItems.add(entityHierarchyItem);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> entityHierarchyDao.replaceHierarchy(EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE));
    verify(entityHierarchyItem2).id();
    verify(entityHierarchyItem2).parentId();
    verify(entityHierarchyItem2).kind();
  }

  /**
   * Method under test:
   * {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  void testReplaceHierarchy7() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);
    EntityHierarchyItem entityHierarchyItem = mock(EntityHierarchyItem.class);
    when(entityHierarchyItem.ancestorLevel()).thenReturn(1);
    when(entityHierarchyItem.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(entityHierarchyItem.parentId()).thenReturn(ofResult);
    when(entityHierarchyItem.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(entityHierarchyItem.id()).thenReturn(ofResult2);
    EntityHierarchyItem entityHierarchyItem2 = mock(EntityHierarchyItem.class);
    when(entityHierarchyItem2.ancestorLevel()).thenReturn(1);
    when(entityHierarchyItem2.descendantLevel()).thenReturn(3);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(entityHierarchyItem2.parentId()).thenReturn(ofResult3);
    when(entityHierarchyItem2.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(entityHierarchyItem2.id()).thenReturn(ofResult4);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(entityHierarchyItem2);
    hierarchyItems.add(entityHierarchyItem);

    // Act
    int actualReplaceHierarchyResult = entityHierarchyDao.replaceHierarchy(EntityKind.ALL, hierarchyItems,
        ApplicationDao.IS_ACTIVE);

    // Assert
    verify(entityHierarchyItem2).id();
    verify(entityHierarchyItem).id();
    verify(entityHierarchyItem2).parentId();
    verify(entityHierarchyItem).parentId();
    verify(entityHierarchyItem2).ancestorLevel();
    verify(entityHierarchyItem).ancestorLevel();
    verify(entityHierarchyItem2).descendantLevel();
    verify(entityHierarchyItem).descendantLevel();
    verify(entityHierarchyItem2).kind();
    verify(entityHierarchyItem).kind();
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceHierarchyResult);
  }

  /**
   * Method under test: {@link EntityHierarchyDao#tallyByKind()}
   */
  @Test
  void testTallyByKind() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<Tally<String>> actualTallyByKindResult = (new EntityHierarchyDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).tallyByKind();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_hierarchy\".\"kind\", count(\"entity_hierarchy\".\"kind\") \"count\" from \"entity_hierarchy\" where (1 = 1) group by \"entity_hierarchy\".\"kind\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualTallyByKindResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  void testGetRootTallies() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
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
    List<Tally<String>> actualRootTallies = (new EntityHierarchyDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getRootTallies();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"entity_hierarchy\".\"kind\", count(*) from \"entity_hierarchy\" where (\"entity_hierarchy\".\"level\" = ? and \"entity_hierarchy\".\"id\" = \"entity_hierarchy\".\"ancestor_id\") group by \"entity_hierarchy\".\"kind\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<String> getResult2 = actualRootTallies.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals("String", getResult.id());
    assertEquals(1.0d, getResult.count());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  void testFindDesendents() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(new DefaultDSLContext(SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new IllegalArgumentException("ref cannot be null"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.findDesendents(ref));
    verify(ref).id();
    verify(ref).kind();
  }
}
