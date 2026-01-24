package org.finos.waltz.data.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Builder;
import org.finos.waltz.model.thumbnail.Thumbnail;
import org.finos.waltz.schema.tables.records.ThumbnailRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
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
class ThumbnailDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ThumbnailDao thumbnailDao;

  /**
   * Test {@link ThumbnailDao#getByReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#getByReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getByReference(EntityReference); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Thumbnail ThumbnailDao.getByReference(EntityReference)"})
  void testGetByReference_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException, DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            mimeTypeResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ThumbnailDao thumbnailDao = new ThumbnailDao(dsl);
    ImmutableEntityReference reference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Thumbnail actualByReference = thumbnailDao.getByReference(reference);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    EntityReference parentEntityReferenceResult = actualByReference.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualByReference instanceof ImmutableThumbnail);
    LocalDateTime lastUpdatedAtResult = actualByReference.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualByReference.lastUpdatedBy());
    assertEquals("Provenance", actualByReference.provenance());
    assertEquals("text/plain", actualByReference.mimeType());
    assertEquals(reference, parentEntityReferenceResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ThumbnailDao#create(Thumbnail)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#create(Thumbnail)}
   */
  @Test
  @DisplayName(
      "Test create(Thumbnail); given InsertSetMoreStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThumbnailDao.create(Thumbnail)"})
  void testCreate_givenInsertSetMoreStepExecuteReturnOne_thenReturnOne()
      throws UnsupportedEncodingException, DataAccessException {
    // Arrange
    InsertSetMoreStep<ThumbnailRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetStep<ThumbnailRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<ThumbnailRecord>>any())).thenReturn(insertSetStep);

    Thumbnail thumbnail = mock(Thumbnail.class);
    when(thumbnail.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(thumbnail.lastUpdatedBy()).thenReturn("2020-03-01");
    when(thumbnail.mimeType()).thenReturn("text/plain");
    Optional<String> ofResult = Optional.of("foo");
    when(thumbnail.externalId()).thenReturn(ofResult);
    when(thumbnail.provenance()).thenReturn("Provenance");
    when(thumbnail.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(thumbnail.parentEntityReference())
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
    int actualCreateResult = thumbnailDao.create(thumbnail);

    // Assert
    verify(thumbnail).externalId();
    verify(thumbnail).lastUpdatedAt();
    verify(thumbnail).lastUpdatedBy();
    verify(thumbnail).provenance();
    verify(thumbnail).blob();
    verify(thumbnail).mimeType();
    verify(thumbnail, atLeast(1)).parentEntityReference();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ThumbnailDao#create(Thumbnail)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#create(Thumbnail)}
   */
  @Test
  @DisplayName(
      "Test create(Thumbnail); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThumbnailDao.create(Thumbnail)"})
  void testCreate_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBytes(anyInt(), Mockito.<byte[]>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ThumbnailDao thumbnailDao = new ThumbnailDao(dsl);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    int actualCreateResult =
        thumbnailDao.create(
            mimeTypeResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"thumbnail\" (\"parent_entity_kind\", \"parent_entity_id\", \"last_updated_at\", \"last_updated_by\", \"mime_type\", \"blob\", \"external_id\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBytes(eq(6), isA(byte[].class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateResult);
  }

  /**
   * Test {@link ThumbnailDao#update(Thumbnail)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Thumbnail#externalId()}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#update(Thumbnail)}
   */
  @Test
  @DisplayName("Test update(Thumbnail); given 'AXAXAXAX' Bytes is 'UTF-8'; then calls externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailDao.update(Thumbnail)"})
  void testUpdate_givenAxaxaxaxBytesIsUtf8_thenCallsExternalId()
      throws UnsupportedEncodingException, DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    Thumbnail thumbnail = mock(Thumbnail.class);
    when(thumbnail.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(thumbnail.lastUpdatedBy()).thenReturn("2020-03-01");
    when(thumbnail.mimeType()).thenReturn("text/plain");
    Optional<String> ofResult = Optional.of("foo");
    when(thumbnail.externalId()).thenReturn(ofResult);
    when(thumbnail.provenance()).thenReturn("Provenance");
    when(thumbnail.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(thumbnail.parentEntityReference())
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
    boolean actualUpdateResult = thumbnailDao.update(thumbnail);

    // Assert
    verify(thumbnail).externalId();
    verify(thumbnail).lastUpdatedAt();
    verify(thumbnail).lastUpdatedBy();
    verify(thumbnail).provenance();
    verify(thumbnail).blob();
    verify(thumbnail).mimeType();
    verify(thumbnail, atLeast(1)).parentEntityReference();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link ThumbnailDao#update(Thumbnail)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#update(Thumbnail)}
   */
  @Test
  @DisplayName(
      "Test update(Thumbnail); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailDao.update(Thumbnail)"})
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBytes(anyInt(), Mockito.<byte[]>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ThumbnailDao thumbnailDao = new ThumbnailDao(dsl);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    boolean actualUpdateResult =
        thumbnailDao.update(
            mimeTypeResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"thumbnail\" set \"thumbnail\".\"last_updated_at\" = ?, \"thumbnail\".\"last_updated_by\" = ?, \"thumbnail\".\"mime_type\" = ?, \"thumbnail\".\"blob\" = ?, \"thumbnail\".\"external_id\" = ?, \"thumbnail\".\"provenance\" = ? where (\"thumbnail\".\"parent_entity_id\" = ? and \"thumbnail\".\"parent_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBytes(eq(4), isA(byte[].class));
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(1), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link ThumbnailDao#update(Thumbnail)}.
   *
   * <ul>
   *   <li>Given {@link ThumbnailDao#ThumbnailDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#update(Thumbnail)}
   */
  @Test
  @DisplayName(
      "Test update(Thumbnail); given ThumbnailDao(DSLContext) with dsl is DSLContext; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailDao.update(Thumbnail)"})
  void testUpdate_givenThumbnailDaoWithDslIsDSLContext_thenReturnTrue()
      throws UnsupportedEncodingException, DataAccessException {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    ThumbnailDao thumbnailDao = new ThumbnailDao(dsl);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    boolean actualUpdateResult =
        thumbnailDao.update(
            mimeTypeResult
                .parentEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Assert
    verify(dsl).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link ThumbnailDao#deleteByReference(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#deleteByReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test deleteByReference(EntityReference); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThumbnailDao.deleteByReference(EntityReference)"})
  void testDeleteByReference_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ThumbnailRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ThumbnailRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ThumbnailRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<ThumbnailRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteByReferenceResult =
        thumbnailDao.deleteByReference(
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
    assertEquals(1, actualDeleteByReferenceResult);
  }

  /**
   * Test {@link ThumbnailDao#deleteByReference(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailDao#deleteByReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test deleteByReference(EntityReference); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThumbnailDao.deleteByReference(EntityReference)"})
  void testDeleteByReference_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
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
    ThumbnailDao thumbnailDao = new ThumbnailDao(dsl);

    // Act
    int actualDeleteByReferenceResult =
        thumbnailDao.deleteByReference(
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
            "delete from \"thumbnail\" where (\"thumbnail\".\"parent_entity_id\" = ? and \"thumbnail\".\"parent_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteByReferenceResult);
  }
}
