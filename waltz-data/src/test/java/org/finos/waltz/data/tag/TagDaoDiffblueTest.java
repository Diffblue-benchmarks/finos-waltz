package org.finos.waltz.data.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.tag.ImmutableTag;
import org.finos.waltz.schema.tables.records.TagRecord;
import org.finos.waltz.schema.tables.records.TagUsageRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
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
class TagDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private TagDao tagDao;

  /**
   * Test {@link TagDao#findTagsForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#findTagsForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findTagsForEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagDao.findTagsForEntityReference(EntityReference)"})
  void testFindTagsForEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    TagDao tagDao = new TagDao(dsl);

    // Act
    List<org.finos.waltz.model.tag.Tag> actualFindTagsForEntityReferenceResult =
        tagDao.findTagsForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindTagsForEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link TagDao#findTagsForEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link TagDao#findTagsForEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findTagsForEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TagDao.findTagsForEntityKind(EntityKind)"})
  void testFindTagsForEntityKind() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<org.finos.waltz.model.tag.Tag> actualFindTagsForEntityKindResult =
        new TagDao(dsl).findTagsForEntityKind(EntityKind.ALL);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindTagsForEntityKindResult.isEmpty());
  }

  /**
   * Test {@link TagDao#getTagByNameAndTargetKind(EntityKind, String)}.
   *
   * <p>Method under test: {@link TagDao#getTagByNameAndTargetKind(EntityKind, String)}
   */
  @Test
  @DisplayName("Test getTagByNameAndTargetKind(EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.tag.Tag TagDao.getTagByNameAndTargetKind(EntityKind, String)"
  })
  void testGetTagByNameAndTargetKind() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    org.finos.waltz.model.tag.Tag actualTagByNameAndTargetKind =
        new TagDao(dsl).getTagByNameAndTargetKind(EntityKind.ALL, "Tag Name");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualTagByNameAndTargetKind instanceof ImmutableTag);
    assertEquals("Name", actualTagByNameAndTargetKind.name());
    assertEquals(EntityKind.ALL, actualTagByNameAndTargetKind.targetKind());
    assertTrue(actualTagByNameAndTargetKind.tagUsages().isEmpty());
  }

  /**
   * Test {@link TagDao#removeTagUsage(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#delete(Table)} return {@link DeleteUsingStep}.
   *   <li>Then calls {@link DSLContext#delete(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#removeTagUsage(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeTagUsage(EntityReference, String); given DSLContext delete(Table) return DeleteUsingStep; then calls delete(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.removeTagUsage(EntityReference, String)"})
  void testRemoveTagUsage_givenDSLContextDeleteReturnDeleteUsingStep_thenCallsDelete()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<TagUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<TagUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.execute()).thenReturn(1);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<TagUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<TagUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.delete(Mockito.<Table<TagUsageRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    tagDao.removeTagUsage(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build(),
        "Tag To Remove");

    // Assert
    verify(dSLContext, atLeast(1)).delete(Mockito.<Table<Record>>any());
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep3, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep2).execute();
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link TagDao#removeTagUsage(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#removeTagUsage(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeTagUsage(EntityReference, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.removeTagUsage(EntityReference, String)"})
  void testRemoveTagUsage_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.removeTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Tag To Remove");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link TagDao#removeTagUsage(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#removeTagUsage(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeTagUsage(EntityReference, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.removeTagUsage(EntityReference, String)"})
  void testRemoveTagUsage_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.removeTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Tag To Remove");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link TagDao#removeTagUsage(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#delete(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#removeTagUsage(EntityReference, String)}
   */
  @Test
  @DisplayName("Test removeTagUsage(EntityReference, String); then calls delete(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.removeTagUsage(EntityReference, String)"})
  void testRemoveTagUsage_thenCallsDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<TagUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<TagUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.execute()).thenReturn(1);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<TagUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<TagUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<TagUsageRecord>>any())).thenReturn(deleteUsingStep);
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.removeTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Tag To Remove");

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep3, atLeast(1)).and(Mockito.<Condition>any());
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep2).execute();
    verify(deleteConditionStep).execute();
    verify(dsl, atLeast(1)).delete(Mockito.<Table<Record>>any());
  }

  /**
   * Test {@link TagDao#createTag(EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@link InsertResultStep} {@link InsertResultStep#fetchOne()} return {@link
   *       TagRecord#TagRecord()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#createTag(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test createTag(EntityKind, String); given InsertResultStep fetchOne() return TagRecord(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TagDao.createTag(EntityKind, String)"})
  void testCreateTag_givenInsertResultStepFetchOneReturnTagRecord_thenReturnNull()
      throws DataAccessException {
    // Arrange
    InsertResultStep<TagRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new TagRecord());

    InsertSetMoreStep<TagRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<TagRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<TagRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<TagRecord>>any())).thenReturn(insertSetStep);

    // Act
    Long actualCreateTagResult = new TagDao(dsl).createTag(EntityKind.ALL, "Tag");

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualCreateTagResult);
  }

  /**
   * Test {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   *
   * <p>Method under test: {@link TagDao#createTagUsage(EntityReference, String, Long)}
   */
  @Test
  @DisplayName("Test createTagUsage(EntityReference, String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.createTagUsage(EntityReference, String, Long)"})
  void testCreateTagUsage() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    // Act
    tagDao.createTagUsage(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build(),
        "janedoe",
        1L);

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
  }

  /**
   * Test {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#createTagUsage(EntityReference, String, Long)}
   */
  @Test
  @DisplayName(
      "Test createTagUsage(EntityReference, String, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.createTagUsage(EntityReference, String, Long)"})
  void testCreateTagUsage_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.createTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "janedoe",
        1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"tag_usage\" (\"tag_id\", \"entity_id\", \"entity_kind\", \"created_by\", \"provenance\") values (cast(? as bigint), cast(? as bigint), cast(? as varchar), cast(? as varchar), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#createTagUsage(EntityReference, String, Long)}
   */
  @Test
  @DisplayName(
      "Test createTagUsage(EntityReference, String, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.createTagUsage(EntityReference, String, Long)"})
  void testCreateTagUsage_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.createTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "janedoe",
        1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"tag_usage\" (\"tag_id\", \"entity_id\", \"entity_kind\", \"created_by\", \"provenance\") values (cast(? as bigint), cast(? as bigint), cast(? as varchar(3)), cast(? as varchar(7)), cast(? as varchar(5)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#createTagUsage(EntityReference, String, Long)}
   */
  @Test
  @DisplayName(
      "Test createTagUsage(EntityReference, String, Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.createTagUsage(EntityReference, String, Long)"})
  void testCreateTagUsage_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.createTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "janedoe",
        1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"tag_usage\" (\"tag_id\", \"entity_id\", \"entity_kind\", \"created_by\", \"provenance\") values (?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link TagDao#createTagUsage(EntityReference, String, Long)}.
   *
   * <ul>
   *   <li>Given {@link TagDao#TagDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then calls {@link DSLContext#executeInsert(TableRecord)}.
   * </ul>
   *
   * <p>Method under test: {@link TagDao#createTagUsage(EntityReference, String, Long)}
   */
  @Test
  @DisplayName(
      "Test createTagUsage(EntityReference, String, Long); given TagDao(DSLContext) with dsl is DSLContext; then calls executeInsert(TableRecord)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagDao.createTagUsage(EntityReference, String, Long)"})
  void testCreateTagUsage_givenTagDaoWithDslIsDSLContext_thenCallsExecuteInsert()
      throws DataAccessException {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    TagDao tagDao = new TagDao(dsl);

    // Act
    tagDao.createTagUsage(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "janedoe",
        1L);

    // Assert
    verify(dsl).executeInsert(isA(TableRecord.class));
  }

  /**
   * Test {@link TagDao#getById(long)}.
   *
   * <p>Method under test: {@link TagDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.waltz.model.tag.Tag TagDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    org.finos.waltz.model.tag.Tag actualById = new TagDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableTag);
    assertEquals("Name", actualById.name());
    assertEquals(EntityKind.ALL, actualById.targetKind());
    assertTrue(actualById.tagUsages().isEmpty());
  }
}
