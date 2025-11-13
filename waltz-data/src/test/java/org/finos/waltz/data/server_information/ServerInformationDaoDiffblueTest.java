package org.finos.waltz.data.server_information;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.server_information.ImmutableServerInformation;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Builder;
import org.finos.waltz.model.server_information.ServerInformation;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertValuesStep11;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerInformationDaoDiffblueTest {
  /**
   * Test {@link ServerInformationDao#findByAssetCode(String)}.
   *
   * <p>Method under test: {@link ServerInformationDao#findByAssetCode(String)}
   */
  @Test
  @DisplayName("Test findByAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationDao.findByAssetCode(String)"})
  void testFindByAssetCode() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<ServerInformation> actualFindByAssetCodeResult =
        new ServerInformationDao(dsl).findByAssetCode("Asset Code");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnConditionStep2).join(isA(TableLike.class));
    verify(selectOnConditionStep3).and(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByAssetCodeResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationDao#findByAppId(long)}.
   *
   * <p>Method under test: {@link ServerInformationDao#findByAppId(long)}
   */
  @Test
  @DisplayName("Test findByAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerInformationDao.findByAppId(long)"})
  void testFindByAppId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<ServerInformation> actualFindByAppIdResult = new ServerInformationDao(dsl).findByAppId(1L);

    // Assert
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByAppIdResult.isEmpty());
  }

  /**
   * Test {@link ServerInformationDao#getById(long)}.
   *
   * <p>Method under test: {@link ServerInformationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ServerInformation actualById = new ServerInformationDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualById.operatingSystemVersion());
    assertEquals("GB", actualById.country());
    assertEquals("Location", actualById.location());
    assertEquals("Operating System", actualById.operatingSystem());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("localhost", actualById.hostname());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualById.lifecycleStatus());
    assertFalse(actualById.virtual());
  }

  /**
   * Test {@link ServerInformationDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link ServerInformationDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationDao.getByExternalId(String)"})
  void testGetByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ServerInformation actualByExternalId = new ServerInformationDao(dsl).getByExternalId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByExternalId instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualByExternalId.operatingSystemVersion());
    assertEquals("GB", actualByExternalId.country());
    assertEquals("Location", actualByExternalId.location());
    assertEquals("Operating System", actualByExternalId.operatingSystem());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("localhost", actualByExternalId.hostname());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualByExternalId.lifecycleStatus());
    assertFalse(actualByExternalId.virtual());
  }

  /**
   * Test {@link ServerInformationDao#getByHostname(String)}.
   *
   * <p>Method under test: {@link ServerInformationDao#getByHostname(String)}
   */
  @Test
  @DisplayName("Test getByHostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServerInformation ServerInformationDao.getByHostname(String)"})
  void testGetByHostname() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            operatingSystemResult
                .operatingSystemEndOfLifeDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .operatingSystemVersion("1.0.2")
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ServerInformation actualByHostname = new ServerInformationDao(dsl).getByHostname("localhost");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByHostname instanceof ImmutableServerInformation);
    assertEquals("1.0.2", actualByHostname.operatingSystemVersion());
    assertEquals("GB", actualByHostname.country());
    assertEquals("Location", actualByHostname.location());
    assertEquals("Operating System", actualByHostname.operatingSystem());
    assertEquals("Provenance", actualByHostname.provenance());
    assertEquals("localhost", actualByHostname.hostname());
    assertEquals(EntityKind.ALL, actualByHostname.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualByHostname.lifecycleStatus());
    assertFalse(actualByHostname.virtual());
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    ArrayList<ServerInformation> servers = new ArrayList<>();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"server_information\" (\"hostname\", \"operating_system\", \"operating_system_version\", \"country\", \"is_virtual\", \"location\", \"hw_end_of_life_date\", \"os_end_of_life_date\", \"lifecycle_status\", \"provenance\", \"external_id\") values ('localhost', 'Operating System', '1.0.2', 'GB', false, 'Location', date '1970-01-01', date '1970-01-01', 'ACTIVE', 'Provenance', '')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave2() throws DataAccessException {
    // Arrange
    InsertValuesStep11<
            Record,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        insertValuesStep11 = mock(InsertValuesStep11.class);
    when(insertValuesStep11.values(
            Mockito.<Object>any(),
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
        .thenReturn(mock(InsertValuesStep11.class));

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dsl.insertInto(
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
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep11);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    ArrayList<ServerInformation> servers = new ArrayList<>();

    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl)
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
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep11)
        .values(
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            (Object) isNull(),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSave(List); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave_givenStatementAddBatchDoesNothing_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    ArrayList<ServerInformation> servers = new ArrayList<>();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"server_information\" (\"hostname\", \"operating_system\", \"operating_system_version\", \"country\", \"is_virtual\", \"location\", \"hw_end_of_life_date\", \"os_end_of_life_date\", \"lifecycle_status\", \"provenance\", \"external_id\") values ('localhost', 'Operating System', '1.0.2', 'GB', false, 'Location', date '1970-01-01', date '1970-01-01', 'ACTIVE', 'Provenance', '42')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSave(List); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave_givenStatementAddBatchDoesNothing_thenCallsAddBatch2() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    ArrayList<ServerInformation> servers = new ArrayList<>();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(connection).createStatement();
    verify(statement, atLeast(1))
        .addBatch(
            "insert into \"server_information\" (\"hostname\", \"operating_system\", \"operating_system_version\", \"country\", \"is_virtual\", \"location\", \"hw_end_of_life_date\", \"os_end_of_life_date\", \"lifecycle_status\", \"provenance\", \"external_id\") values ('localhost', 'Operating System', '1.0.2', 'GB', false, 'Location', date '1970-01-01', date '1970-01-01', 'ACTIVE', 'Provenance', '42')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <ul>
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave_thenCallsExecute() throws DataAccessException {
    // Arrange
    InsertValuesStep11<
            Record,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        insertValuesStep11 = mock(InsertValuesStep11.class);
    when(insertValuesStep11.values(
            Mockito.<Object>any(),
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
        .thenReturn(mock(InsertValuesStep11.class));

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dsl.insertInto(
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
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep11);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    ArrayList<ServerInformation> servers = new ArrayList<>();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    servers.add(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl)
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
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep11)
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
            isA(Object.class),
            isA(Object.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link ServerInformationDao#bulkSave(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List); when ArrayList(); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ServerInformationDao.bulkSave(List)"})
  void testBulkSave_whenArrayList_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }
}
