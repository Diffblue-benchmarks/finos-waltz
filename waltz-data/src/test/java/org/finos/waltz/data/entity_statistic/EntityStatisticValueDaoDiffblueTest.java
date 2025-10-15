package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_statistic.EntityStatisticValue;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue.Builder;
import org.finos.waltz.model.entity_statistic.StatisticValueState;
import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertValuesStep10;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
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
class EntityStatisticValueDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityStatisticValueDao entityStatisticValueDao;

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName("Test bulkSaveValues(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep10<
            Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep10 = mock(InsertValuesStep10.class);
    when(insertValuesStep10.values(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep10.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep10);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(false);
    values.add(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext)
        .insertInto(
            isA(Table.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep10)
        .values(
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSaveValues(List); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_givenStatementAddBatchDoesNothing_thenCallsAddBatch()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(dsl);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"entity_statistic_value\" (\"statistic_id\", \"entity_kind\", \"entity_id\", \"value\", \"outcome\", \"state\", \"reason\", \"created_at\", \"current\", \"provenance\") values (1, 'ALL', 1, '42', 'Outcome', 'EXEMPT', 'Just cause', timestamp '1970-01-01 00:00:00.0', true, 'Provenance')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSaveValues(List); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_givenStatementAddBatchDoesNothing_thenCallsAddBatch2()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(dsl);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(connection).createStatement();
    verify(statement, atLeast(1))
        .addBatch(
            "insert into \"entity_statistic_value\" (\"statistic_id\", \"entity_kind\", \"entity_id\", \"value\", \"outcome\", \"state\", \"reason\", \"created_at\", \"current\", \"provenance\") values (1, 'ALL', 1, '42', 'Outcome', 'EXEMPT', 'Just cause', timestamp '1970-01-01 00:00:00.0', true, 'Provenance')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#insertInto(Table, Field, Field, Field, Field, Field, Field,
   *       Field, Field, Field, Field)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSaveValues(List); then calls insertInto(Table, Field, Field, Field, Field, Field, Field, Field, Field, Field, Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_thenCallsInsertInto() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep10<
            Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep10 = mock(InsertValuesStep10.class);
    when(insertValuesStep10.values(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep10.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep10);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext)
        .insertInto(
            isA(Table.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep10)
        .values(
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#insertInto(Table, Field, Field, Field, Field, Field, Field,
   *       Field, Field, Field, Field)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSaveValues(List); then calls insertInto(Table, Field, Field, Field, Field, Field, Field, Field, Field, Field, Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_thenCallsInsertInto2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertValuesStep10<
            Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>
        insertValuesStep10 = mock(InsertValuesStep10.class);
    when(insertValuesStep10.values(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any()))
        .thenReturn(mock(InsertValuesStep10.class));
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep10);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    ArrayList<EntityStatisticValue> values = new ArrayList<>();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    values.add(
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(values);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1))
        .insertInto(
            isA(Table.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep10, atLeast(1))
        .values(
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName("Test bulkSaveValues(List); when ArrayList(); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_whenArrayList_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityStatisticValueDao entityStatisticValueDao = new EntityStatisticValueDao(dsl);

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }

  /**
   * Test {@link EntityStatisticValueDao#bulkSaveValues(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticValueDao#bulkSaveValues(List)}
   */
  @Test
  @DisplayName("Test bulkSaveValues(List); when ArrayList(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityStatisticValueDao.bulkSaveValues(List)"})
  void testBulkSaveValues_whenArrayList_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int[] actualBulkSaveValuesResult = entityStatisticValueDao.bulkSaveValues(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveValuesResult);
  }
}
