package org.finos.waltz.data.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.schema.tables.records.EntityNamedNoteRecord;
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
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
class EntityNamedNoteDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityNamedNoteDao entityNamedNoteDao;

  /**
   * Test {@link EntityNamedNoteDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link EntityNamedNoteDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityNamedNoteDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() throws DataAccessException {
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<EntityNamedNote> actualFindByEntityReferenceResult =
        entityNamedNoteDao.findByEntityReference(
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
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByEntityReference(EntityReference); given one; when EntityReference id() return one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityNamedNoteDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_givenOne_whenEntityReferenceIdReturnOne_thenCallsId()
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<EntityNamedNote> actualFindByEntityReferenceResult =
        entityNamedNoteDao.findByEntityReference(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName("Test save(EntityReference, long, String, UserTimestamp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.newRecord(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(new EntityNamedNoteRecord());
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualSaveResult =
        entityNamedNoteDao.save(
            ref,
            1L,
            "Note Text",
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then calls {@link DSLContext#executeInsert(TableRecord)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, UserTimestamp); given DSLContext executeInsert(TableRecord) return one; then calls executeInsert(TableRecord)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave_givenDSLContextExecuteInsertReturnOne_thenCallsExecuteInsert()
      throws DataAccessException {
    // Arrange
    EntityNamedNoteRecord entityNamedNoteRecord = mock(EntityNamedNoteRecord.class);
    doNothing().when(entityNamedNoteRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setNamedNoteTypeId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setNoteText(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setProvenance(Mockito.<String>any());
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(0);
    when(dSLContext.newRecord(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(entityNamedNoteRecord);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    when(ref.id()).thenReturn(1L);

    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    verify(entityNamedNoteRecord).setEntityId(1L);
    verify(entityNamedNoteRecord).setEntityKind("ALL");
    verify(entityNamedNoteRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(entityNamedNoteRecord).setLastUpdatedBy("By");
    verify(entityNamedNoteRecord).setNamedNoteTypeId(1L);
    verify(entityNamedNoteRecord).setNoteText("Note Text");
    verify(entityNamedNoteRecord).setProvenance("waltz");
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, UserTimestamp); given DSLContext executeInsert(TableRecord) return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave_givenDSLContextExecuteInsertReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    EntityNamedNoteRecord entityNamedNoteRecord = mock(EntityNamedNoteRecord.class);
    doNothing().when(entityNamedNoteRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setNamedNoteTypeId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setNoteText(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setProvenance(Mockito.<String>any());
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(0);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(0);
    when(dSLContext.newRecord(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(entityNamedNoteRecord);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    when(ref.id()).thenReturn(1L);

    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    verify(entityNamedNoteRecord).setEntityId(1L);
    verify(entityNamedNoteRecord).setEntityKind("ALL");
    verify(entityNamedNoteRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(entityNamedNoteRecord).setLastUpdatedBy("By");
    verify(entityNamedNoteRecord).setNamedNoteTypeId(1L);
    verify(entityNamedNoteRecord).setNoteText("Note Text");
    verify(entityNamedNoteRecord).setProvenance("waltz");
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#newRecord(Table)} return {@link
   *       EntityNamedNoteRecord#EntityNamedNoteRecord()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, UserTimestamp); given DSLContext newRecord(Table) return EntityNamedNoteRecord(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave_givenDSLContextNewRecordReturnEntityNamedNoteRecord_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.newRecord(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(new EntityNamedNoteRecord());

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    when(ref.id()).thenReturn(1L);

    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <ul>
   *   <li>Given {@link EntityNamedNoteRecord} {@link EntityNamedNoteRecord#setEntityId(Long)} does
   *       nothing.
   *   <li>Then calls {@link EntityNamedNoteRecord#setEntityId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, UserTimestamp); given EntityNamedNoteRecord setEntityId(Long) does nothing; then calls setEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave_givenEntityNamedNoteRecordSetEntityIdDoesNothing_thenCallsSetEntityId()
      throws DataAccessException {
    // Arrange
    EntityNamedNoteRecord entityNamedNoteRecord = mock(EntityNamedNoteRecord.class);
    doNothing().when(entityNamedNoteRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(entityNamedNoteRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setNamedNoteTypeId(Mockito.<Long>any());
    doNothing().when(entityNamedNoteRecord).setNoteText(Mockito.<String>any());
    doNothing().when(entityNamedNoteRecord).setProvenance(Mockito.<String>any());
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.newRecord(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(entityNamedNoteRecord);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    when(ref.id()).thenReturn(1L);

    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    verify(entityNamedNoteRecord).setEntityId(1L);
    verify(entityNamedNoteRecord).setEntityKind("ALL");
    verify(entityNamedNoteRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(entityNamedNoteRecord).setLastUpdatedBy("By");
    verify(entityNamedNoteRecord).setNamedNoteTypeId(1L);
    verify(entityNamedNoteRecord).setNoteText("Note Text");
    verify(entityNamedNoteRecord).setProvenance("waltz");
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#save(EntityReference, long, String, UserTimestamp)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#save(EntityReference, long, String,
   * UserTimestamp)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, UserTimestamp); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteDao.save(EntityReference, long, String, UserTimestamp)"
  })
  void testSave_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityNamedNoteDao entityNamedNoteDao = new EntityNamedNoteDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    UserTimestamp lastUpdate = mock(UserTimestamp.class);
    when(lastUpdate.by()).thenReturn("By");
    when(lastUpdate.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualSaveResult = entityNamedNoteDao.save(ref, 1L, "Note Text", lastUpdate);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    verify(lastUpdate).at();
    verify(lastUpdate).by();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference)} with {@code ref}.
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference)}
   */
  @Test
  @DisplayName("Test remove(EntityReference) with 'ref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference)"})
  void testRemoveWithRef() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult =
        entityNamedNoteDao.remove(
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
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference, long)} with {@code ref}, {@code
   * namedNoteTypeId}.
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference, long)}
   */
  @Test
  @DisplayName("Test remove(EntityReference, long) with 'ref', 'namedNoteTypeId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference, long)"})
  void testRemoveWithRefNamedNoteTypeId() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult =
        entityNamedNoteDao.remove(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference, long)} with {@code ref}, {@code
   * namedNoteTypeId}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference, long) with 'ref', 'namedNoteTypeId'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference, long)"})
  void testRemoveWithRefNamedNoteTypeId_thenReturnFalse() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference, long)} with {@code ref}, {@code
   * namedNoteTypeId}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference, long) with 'ref', 'namedNoteTypeId'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference, long)"})
  void testRemoveWithRefNamedNoteTypeId_thenReturnTrue() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference) with 'ref'; given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference)"})
  void testRemoveWithRef_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#remove(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#remove(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference) with 'ref'; given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteDao.remove(EntityReference)"})
  void testRemoveWithRef_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<EntityNamedNoteRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityNamedNoteRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityNamedNoteRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualRemoveResult = entityNamedNoteDao.remove(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteDao#findByNoteTypeExtId(String)}.
   *
   * <p>Method under test: {@link EntityNamedNoteDao#findByNoteTypeExtId(String)}
   */
  @Test
  @DisplayName("Test findByNoteTypeExtId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityNamedNoteDao.findByNoteTypeExtId(String)"})
  void testFindByNoteTypeExtId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdResult =
        entityNamedNoteDao.findByNoteTypeExtId("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByNoteTypeExtIdResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteDao#findByNoteTypeExtIdAndEntityReference(String, EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteDao#findByNoteTypeExtIdAndEntityReference(String,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByNoteTypeExtIdAndEntityReference(String, EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set EntityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(String, EntityReference)"
  })
  void testFindByNoteTypeExtIdAndEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdAndEntityReferenceResult =
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(
            "42",
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
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByNoteTypeExtIdAndEntityReferenceResult.isEmpty());
  }
}
