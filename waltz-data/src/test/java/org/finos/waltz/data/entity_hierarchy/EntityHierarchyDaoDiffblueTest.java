package org.finos.waltz.data.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.GroupField;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityHierarchyDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityHierarchyDao entityHierarchyDao;

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); given DSLContext transactionResult(TransactionalCallable) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_givenDSLContextTransactionResultReturnOne_thenReturnOne() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_givenDefaultDSLContextWithConnectionAndDialectIsSql992()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName("Test replaceHierarchy(EntityKind, List, Condition); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_thenReturnZero() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, new ArrayList<>(), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_hierarchy\" where (\"entity_hierarchy\".\"kind\" = cast(? as varchar) and \"application\".\"entity_lifecycle_status\" = cast(? as varchar))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_thenThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityHierarchyDao.replaceHierarchy(
                EntityKind.ALL, new ArrayList<>(), ApplicationDao.IS_ACTIVE));
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName(
      "Test replaceHierarchy(EntityKind, List, Condition); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_whenArrayList_thenReturnZero() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, new ArrayList<>(), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_hierarchy\" where (\"entity_hierarchy\".\"kind\" = ? and \"application\".\"entity_lifecycle_status\" = ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>When {@link LogicalFlowDao#LOGICAL_NOT_REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName("Test replaceHierarchy(EntityKind, List, Condition); when LOGICAL_NOT_REMOVED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_whenLogical_not_removed() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, LogicalFlowDao.LOGICAL_NOT_REMOVED);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}.
   *
   * <ul>
   *   <li>When {@link LogicalFlowDao#SPEC_NOT_REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#replaceHierarchy(EntityKind, List, Condition)}
   */
  @Test
  @DisplayName("Test replaceHierarchy(EntityKind, List, Condition); when SPEC_NOT_REMOVED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyDao.replaceHierarchy(EntityKind, List, Condition)"})
  void testReplaceHierarchy_whenSpec_not_removed() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    ArrayList<EntityHierarchyItem> hierarchyItems = new ArrayList<>();
    hierarchyItems.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    int actualReplaceHierarchyResult =
        entityHierarchyDao.replaceHierarchy(
            EntityKind.ALL, hierarchyItems, LogicalFlowDao.SPEC_NOT_REMOVED);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(1, "ALL");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(4, actualReplaceHierarchyResult);
  }

  /**
   * Test {@link EntityHierarchyDao#tallyByKind()}.
   *
   * <ul>
   *   <li>Given {@link SelectHavingStep} {@link SelectHavingStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#tallyByKind()}
   */
  @Test
  @DisplayName(
      "Test tallyByKind(); given SelectHavingStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.tallyByKind()"})
  void testTallyByKind_givenSelectHavingStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<String>> actualTallyByKindResult = entityHierarchyDao.tallyByKind();

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualTallyByKindResult.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given DSLContext select(SelectField, SelectField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.getRootTallies());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#groupBy(GroupField[])} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given SelectConditionStep groupBy(GroupField[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenSelectConditionStepGroupByThrowIllegalArgumentException() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.getRootTallies());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link SelectHavingStep} {@link SelectHavingStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given SelectHavingStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenSelectHavingStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<String>> actualRootTallies = entityHierarchyDao.getRootTallies();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualRootTallies.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link SelectHavingStep} {@link SelectHavingStep#fetch(RecordMapper)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given SelectHavingStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenSelectHavingStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.getRootTallies());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.getRootTallies());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#getRootTallies()}
   */
  @Test
  @DisplayName(
      "Test getRootTallies(); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.getRootTallies()"})
  void testGetRootTallies_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.getRootTallies());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new EntityHierarchyDao(dsl).findDesendents(mock(EntityReference.class)));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#and(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectConditionStep and(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectConditionStepAndThrowIllegalArgumentException() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.findDesendents(ref));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#and(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectConditionStep and(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectConditionStepAndThrowIllegalArgumentException2() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityHierarchyDao.findDesendents(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<EntityHierarchyItem> actualFindDesendentsResult = entityHierarchyDao.findDesendents(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindDesendentsResult.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectConditionStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectConditionStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityHierarchyDao.findDesendents(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    EntityHierarchyDao entityHierarchyDao = new EntityHierarchyDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.findDesendents(ref));
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectJoinStepWhereThrowIllegalArgumentException2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityHierarchyDao.findDesendents(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new EntityHierarchyDao(dsl).findDesendents(mock(EntityReference.class)));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); when EntityReference id() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_whenEntityReferenceIdThrowIllegalArgumentException() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao =
        new EntityHierarchyDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new IllegalArgumentException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.findDesendents(ref));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link EntityHierarchyDao#findDesendents(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#kind()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#findDesendents(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDesendents(EntityReference); when EntityReference kind() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.findDesendents(EntityReference)"})
  void testFindDesendents_whenEntityReferenceKindThrowIllegalArgumentException() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao =
        new EntityHierarchyDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyDao.findDesendents(ref));
    verify(ref).kind();
  }

  /**
   * Test {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyDao.fetchHierarchyForKind(EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test fetchHierarchyForKind(EntityKind); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyDao.fetchHierarchyForKind(EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test fetchHierarchyForKind(EntityKind); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new EntityHierarchyDao(dsl).fetchHierarchyForKind(EntityKind.ALL));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test fetchHierarchyForKind(EntityKind); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new EntityHierarchyDao(dsl).fetchHierarchyForKind(EntityKind.ALL));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyDao#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyDao.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<EntityHierarchyItem> actualFetchHierarchyForKindResult =
        new EntityHierarchyDao(dsl).fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchHierarchyForKindResult.isEmpty());
  }
}
