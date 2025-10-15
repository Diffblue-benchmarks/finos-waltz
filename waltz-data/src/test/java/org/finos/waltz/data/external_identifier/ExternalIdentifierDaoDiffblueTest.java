package org.finos.waltz.data.external_identifier;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Builder;
import org.finos.waltz.schema.tables.records.ExternalIdentifierRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
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
class ExternalIdentifierDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ExternalIdentifierDao externalIdentifierDao;

  /**
   * Test {@link ExternalIdentifierDao#create(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link ExternalIdentifier#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#create(ExternalIdentifier)}
   */
  @Test
  @DisplayName(
      "Test create(ExternalIdentifier) with 'externalIdentifier'; given '42'; then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.create(ExternalIdentifier)"})
  void testCreateWithExternalIdentifier_given42_thenCallsEntityReference()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    ExternalIdentifier externalIdentifier = mock(ExternalIdentifier.class);
    when(externalIdentifier.externalId()).thenReturn("42");
    when(externalIdentifier.system()).thenReturn("System");
    when(externalIdentifier.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualCreateResult = externalIdentifierDao.create(externalIdentifier);

    // Assert
    verify(externalIdentifier, atLeast(1)).entityReference();
    verify(externalIdentifier).externalId();
    verify(externalIdentifier).system();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#create(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#create(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test create(ExternalIdentifier) with 'externalIdentifier'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.create(ExternalIdentifier)"})
  void testCreateWithExternalIdentifier_thenReturnOne() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    int actualCreateResult =
        externalIdentifierDao.create(
            builderResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .externalId("42")
                .system("System")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#create(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#create(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test create(ExternalIdentifier) with 'externalIdentifier'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.create(ExternalIdentifier)"})
  void testCreateWithExternalIdentifier_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(dsl);

    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    int actualCreateResult =
        externalIdentifierDao.create(
            builderResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .externalId("42")
                .system("System")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"external_identifier\" (\"entity_kind\", \"entity_id\", \"system\", \"external_id\") values (?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#create(Set)} with {@code externalIdentifiers}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#create(Set)}
   */
  @Test
  @DisplayName("Test create(Set) with 'externalIdentifiers'; then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ExternalIdentifierDao.create(Set)"})
  void testCreateWithExternalIdentifiers_thenReturnEmptyArrayOfInt() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao =
        new ExternalIdentifierDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, externalIdentifierDao.create(new HashSet<>()));
  }

  /**
   * Test {@link ExternalIdentifierDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ExternalIdentifierDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ExternalIdentifier> actualFindByEntityReferenceResult =
        externalIdentifierDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link ExternalIdentifierDao#findByKind(EntityKind, String)}.
   *
   * <p>Method under test: {@link ExternalIdentifierDao#findByKind(EntityKind, String)}
   */
  @Test
  @DisplayName("Test findByKind(EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ExternalIdentifierDao.findByKind(EntityKind, String)"})
  void testFindByKind() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ExternalIdentifier> actualFindByKindResult =
        externalIdentifierDao.findByKind(EntityKind.ALL, "42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(EntityReference)} with {@code entityRef}.
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(EntityReference)}
   */
  @Test
  @DisplayName("Test delete(EntityReference) with 'entityRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(EntityReference)"})
  void testDeleteWithEntityRef() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ExternalIdentifierRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ExternalIdentifierRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ExternalIdentifierRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ExternalIdentifierRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult =
        externalIdentifierDao.delete(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(EntityReference)} with {@code entityRef}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference) with 'entityRef'; given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(EntityReference)"})
  void testDeleteWithEntityRef_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ExternalIdentifierRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ExternalIdentifierRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ExternalIdentifierRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ExternalIdentifierRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult =
        externalIdentifierDao.delete(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(EntityReference)} with {@code entityRef}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference) with 'entityRef'; given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(EntityReference)"})
  void testDeleteWithEntityRef_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(dsl);

    // Act
    int actualDeleteResult =
        externalIdentifierDao.delete(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"external_identifier\" where (\"external_identifier\".\"entity_kind\" = ? and \"external_identifier\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link ExternalIdentifier#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(ExternalIdentifier)}
   */
  @Test
  @DisplayName(
      "Test delete(ExternalIdentifier) with 'externalIdentifier'; given '42'; then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(ExternalIdentifier)"})
  void testDeleteWithExternalIdentifier_given42_thenCallsEntityReference()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeDelete(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    ExternalIdentifier externalIdentifier = mock(ExternalIdentifier.class);
    when(externalIdentifier.externalId()).thenReturn("42");
    when(externalIdentifier.system()).thenReturn("System");
    when(externalIdentifier.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteResult = externalIdentifierDao.delete(externalIdentifier);

    // Assert
    verify(externalIdentifier, atLeast(1)).entityReference();
    verify(externalIdentifier).externalId();
    verify(externalIdentifier).system();
    verify(dSLContext).executeDelete(isA(UpdatableRecord.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test delete(ExternalIdentifier) with 'externalIdentifier'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(ExternalIdentifier)"})
  void testDeleteWithExternalIdentifier_thenReturnOne() throws DataAccessException {
    // Arrange
    when(dSLContext.executeDelete(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    int actualDeleteResult =
        externalIdentifierDao.delete(
            builderResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .externalId("42")
                .system("System")
                .build());

    // Assert
    verify(dSLContext).executeDelete(isA(UpdatableRecord.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(ExternalIdentifier)} with {@code externalIdentifier}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test delete(ExternalIdentifier) with 'externalIdentifier'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierDao.delete(ExternalIdentifier)"})
  void testDeleteWithExternalIdentifier_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ExternalIdentifierDao externalIdentifierDao = new ExternalIdentifierDao(dsl);

    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    int actualDeleteResult =
        externalIdentifierDao.delete(
            builderResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .externalId("42")
                .system("System")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"external_identifier\" where (\"external_identifier\".\"entity_id\" = ? and \"external_identifier\".\"entity_kind\" = ? and \"external_identifier\".\"system\" = ? and \"external_identifier\".\"external_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierDao#delete(Collection)} with {@code externalIdentifiers}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierDao#delete(Collection)}
   */
  @Test
  @DisplayName("Test delete(Collection) with 'externalIdentifiers'; then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ExternalIdentifierDao.delete(Collection)"})
  void testDeleteWithExternalIdentifiers_thenReturnEmptyArrayOfInt() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao =
        new ExternalIdentifierDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, externalIdentifierDao.delete(new ArrayList<>()));
  }
}
