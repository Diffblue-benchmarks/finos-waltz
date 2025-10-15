package org.finos.waltz.data.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams;
import org.finos.waltz.model.entity_relationship.UpdateEntityRelationshipParams;
import org.finos.waltz.model.rel.ImmutableRelationshipKind;
import org.finos.waltz.model.rel.RelationshipKind;
import org.finos.waltz.schema.tables.records.EntityRelationshipRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
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
class EntityRelationshipDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityRelationshipDao entityRelationshipDao;

  /**
   * Test {@link EntityRelationshipDao#findRelationshipsInvolving(EntityReference)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#findRelationshipsInvolving(EntityReference)}
   */
  @Test
  @DisplayName("Test findRelationshipsInvolving(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipDao.findRelationshipsInvolving(EntityReference)"
  })
  void testFindRelationshipsInvolving() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Collection<EntityRelationship> actualFindRelationshipsInvolvingResult =
        entityRelationshipDao.findRelationshipsInvolving(
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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindRelationshipsInvolvingResult instanceof List);
    assertTrue(actualFindRelationshipsInvolvingResult.isEmpty());
    assertSame(objectList, actualFindRelationshipsInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#findRelationshipsInvolving(EntityReference)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#findRelationshipsInvolving(EntityReference)}
   */
  @Test
  @DisplayName("Test findRelationshipsInvolving(EntityReference); given one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipDao.findRelationshipsInvolving(EntityReference)"
  })
  void testFindRelationshipsInvolving_givenOne_thenCallsId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Collection<EntityRelationship> actualFindRelationshipsInvolvingResult =
        entityRelationshipDao.findRelationshipsInvolving(ref);

    // Assert
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindRelationshipsInvolvingResult instanceof List);
    assertTrue(actualFindRelationshipsInvolvingResult.isEmpty());
    assertSame(objectList, actualFindRelationshipsInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#save(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#save(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test save(EntityRelationship); given DSLContext fetchExists(Select) return 'false'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.save(EntityRelationship)"})
  void testSave_givenDSLContextFetchExistsReturnFalse_thenReturnOne() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualSaveResult =
        entityRelationshipDao.save(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#save(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#save(EntityRelationship)}
   */
  @Test
  @DisplayName("Test save(EntityRelationship); given DSLContext fetchExists(Select) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.save(EntityRelationship)"})
  void testSave_givenDSLContextFetchExistsReturnTrue() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualSaveResult =
        entityRelationshipDao.save(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#save(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#save(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test save(EntityRelationship); given DSLContext fetchExists(Select) return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.save(EntityRelationship)"})
  void testSave_givenDSLContextFetchExistsReturnTrue_thenReturnZero() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    EntityRelationship entityRelationship = mock(EntityRelationship.class);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(entityRelationship.toKey())
        .thenReturn(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build());

    // Act
    int actualSaveResult = entityRelationshipDao.save(entityRelationship);

    // Assert
    verify(entityRelationship).toKey();
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#save(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#save(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test save(EntityRelationship); given PreparedStatement getResultSet() return 'null'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.save(EntityRelationship)"})
  void testSave_givenPreparedStatementGetResultSetReturnNull_thenCallsPrepareStatement()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    EntityRelationship entityRelationship = mock(EntityRelationship.class);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(entityRelationship.toKey())
        .thenReturn(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build());

    // Act
    int actualSaveResult = entityRelationshipDao.save(entityRelationship);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"entity_relationship\".\"kind_a\", \"entity_relationship\".\"id_a\", \"entity_relationship\".\"kind_b\", \"entity_relationship\".\"id_b\", \"entity_relationship\".\"relationship\", \"entity_relationship\".\"provenance\", \"entity_relationship\".\"description\", \"entity_relationship\".\"last_updated_at\", \"entity_relationship\".\"last_updated_by\", \"entity_relationship\".\"id\" from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ? and \"entity_relationship\".\"relationship\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRelationship).toKey();
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#save(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@code The characteristics of someone or something}.
   *   <li>Then calls {@link EntityRelationship#description()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#save(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test save(EntityRelationship); given 'The characteristics of someone or something'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.save(EntityRelationship)"})
  void testSave_givenTheCharacteristicsOfSomeoneOrSomething_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    EntityRelationship entityRelationship = mock(EntityRelationship.class);
    when(entityRelationship.description())
        .thenReturn("The characteristics of someone or something");
    when(entityRelationship.lastUpdatedBy()).thenReturn("2020-03-01");
    when(entityRelationship.provenance()).thenReturn("Provenance");
    when(entityRelationship.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(entityRelationship.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(entityRelationship.a())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(entityRelationship.relationship()).thenReturn("127.0.0.1");

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(entityRelationship.toKey())
        .thenReturn(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build());

    // Act
    int actualSaveResult = entityRelationshipDao.save(entityRelationship);

    // Assert
    verify(entityRelationship).description();
    verify(entityRelationship).lastUpdatedAt();
    verify(entityRelationship).lastUpdatedBy();
    verify(entityRelationship).provenance();
    verify(entityRelationship, atLeast(1)).a();
    verify(entityRelationship, atLeast(1)).b();
    verify(entityRelationship).relationship();
    verify(entityRelationship).toKey();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return four.
   *   <li>Then calls {@link DSLContext#executeInsert(TableRecord)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given DSLContext executeInsert(TableRecord) return four; then calls executeInsert(TableRecord)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenDSLContextExecuteInsertReturnFour_thenCallsExecuteInsert()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(4);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualCreateResult =
        entityRelationshipDao.create(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given DSLContext executeInsert(TableRecord) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenDSLContextExecuteInsertReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualCreateResult =
        entityRelationshipDao.create(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualCreateResult =
        entityRelationshipDao.create(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_relationship\" (\"kind_a\", \"id_a\", \"kind_b\", \"id_b\", \"relationship\", \"provenance\", \"description\", \"last_updated_at\", \"last_updated_by\") values (cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as datetime), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(8), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualCreateResult =
        entityRelationshipDao.create(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_relationship\" (\"kind_a\", \"id_a\", \"kind_b\", \"id_b\", \"relationship\", \"provenance\", \"description\", \"last_updated_at\", \"last_updated_by\") values (cast(? as varchar(3)), cast(? as bigint), cast(? as varchar(3)), cast(? as bigint), cast(? as varchar(9)), cast(? as varchar(10)), cast(? as varchar(43)), cast(? as timestamp), cast(? as varchar(10)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(8), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualCreateResult =
        entityRelationshipDao.create(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_relationship\" (\"kind_a\", \"id_a\", \"kind_b\", \"id_b\", \"relationship\", \"provenance\", \"description\", \"last_updated_at\", \"last_updated_by\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(8), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#create(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@code The characteristics of someone or something}.
   *   <li>Then calls {@link EntityRelationship#description()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#create(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test create(EntityRelationship); given 'The characteristics of someone or something'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.create(EntityRelationship)"})
  void testCreate_givenTheCharacteristicsOfSomeoneOrSomething_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    EntityRelationship relationship = mock(EntityRelationship.class);
    when(relationship.description()).thenReturn("The characteristics of someone or something");
    when(relationship.lastUpdatedBy()).thenReturn("2020-03-01");
    when(relationship.provenance()).thenReturn("Provenance");
    when(relationship.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(relationship.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(relationship.a())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(relationship.relationship()).thenReturn("127.0.0.1");

    // Act
    boolean actualCreateResult = entityRelationshipDao.create(relationship);

    // Assert
    verify(relationship).description();
    verify(relationship).lastUpdatedAt();
    verify(relationship).lastUpdatedBy();
    verify(relationship).provenance();
    verify(relationship, atLeast(1)).a();
    verify(relationship, atLeast(1)).b();
    verify(relationship).relationship();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test remove(EntityRelationshipKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        entityRelationshipDao.remove(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(key.a())
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
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = cast(? as bigint) and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"id_b\" = cast(? as bigint) and \"entity_relationship\".\"kind_b\" = cast(? as varchar) and \"entity_relationship\".\"relationship\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(key.a())
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
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = cast(? as bigint) and \"entity_relationship\".\"kind_a\" = cast(? as varchar(3)) and \"entity_relationship\".\"id_b\" = cast(? as bigint) and \"entity_relationship\".\"kind_b\" = cast(? as varchar(3)) and \"entity_relationship\".\"relationship\" = cast(? as varchar(17)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(key.a())
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
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ? and \"entity_relationship\".\"relationship\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(key.a())
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
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#remove(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#remove(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityRelationshipDao.remove(EntityRelationshipKey)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.relationshipKind()).thenReturn("Relationship Kind");
    when(key.b())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(key.a())
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
    boolean actualRemoveResult = entityRelationshipDao.remove(key);

    // Assert
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(key).relationshipKind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationshipDao.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        entityRelationshipDao.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"entity_relationship\" set \"entity_relationship\".\"relationship\" = cast(? as varchar), \"entity_relationship\".\"description\" = cast(? as varchar), \"entity_relationship\".\"last_updated_by\" = cast(? as varchar), \"entity_relationship\".\"last_updated_at\" = cast(? as datetime) where (\"entity_relationship\".\"id_a\" = cast(? as bigint) and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"id_b\" = cast(? as bigint) and \"entity_relationship\".\"kind_b\" = cast(? as varchar) and \"entity_relationship\".\"relationship\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationshipDao.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        entityRelationshipDao.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"entity_relationship\" set \"entity_relationship\".\"relationship\" = ?, \"entity_relationship\".\"description\" = ?, \"entity_relationship\".\"last_updated_by\" = ?, \"entity_relationship\".\"last_updated_at\" = ? where (\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ? and \"entity_relationship\".\"relationship\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationshipDao.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<EntityRelationshipRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<EntityRelationshipRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(updateSetFirstStep);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        entityRelationshipDao.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given UpdateConditionStep execute() return zero; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationshipDao.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenUpdateConditionStepExecuteReturnZero_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<EntityRelationshipRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<EntityRelationshipRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<EntityRelationshipRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(updateSetFirstStep);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        entityRelationshipDao.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}
   */
  @Test
  @DisplayName("Test removeAnyInvolving(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAnyInvolving(EntityReference)"})
  void testRemoveAnyInvolving() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveAnyInvolvingResult =
        entityRelationshipDao.removeAnyInvolving(
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
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveAnyInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test removeAnyInvolving(EntityReference); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAnyInvolving(EntityReference)"})
  void testRemoveAnyInvolving_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int actualRemoveAnyInvolvingResult =
        entityRelationshipDao.removeAnyInvolving(
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
            "delete from \"entity_relationship\" where ((\"entity_relationship\".\"id_a\" = cast(? as bigint) and \"entity_relationship\".\"kind_a\" = cast(? as varchar)) or (\"entity_relationship\".\"id_b\" = cast(? as bigint) and \"entity_relationship\".\"kind_b\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveAnyInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test removeAnyInvolving(EntityReference); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAnyInvolving(EntityReference)"})
  void testRemoveAnyInvolving_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int actualRemoveAnyInvolvingResult =
        entityRelationshipDao.removeAnyInvolving(
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
            "delete from \"entity_relationship\" where ((\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ?) or (\"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveAnyInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAnyInvolving(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test removeAnyInvolving(EntityReference); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAnyInvolving(EntityReference)"})
  void testRemoveAnyInvolving_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveAnyInvolvingResult =
        entityRelationshipDao.removeAnyInvolving(
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
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveAnyInvolvingResult);
  }

  /**
   * Test {@link EntityRelationshipDao#getEntityRelationshipsByKind(RelationshipKind)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipDao#getEntityRelationshipsByKind(RelationshipKind)}
   */
  @Test
  @DisplayName("Test getEntityRelationshipsByKind(RelationshipKind); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipDao.getEntityRelationshipsByKind(RelationshipKind)"
  })
  void testGetEntityRelationshipsByKind_thenReturnList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<EntityRelationship> actualEntityRelationshipsByKind =
        entityRelationshipDao.getEntityRelationshipsByKind(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualEntityRelationshipsByKind instanceof List);
    assertTrue(actualEntityRelationshipsByKind.isEmpty());
    assertSame(objectList, actualEntityRelationshipsByKind);
  }

  /**
   * Test {@link EntityRelationshipDao#saveAll(String, long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test saveAll(String, long, List); given one; when ArrayList() add one; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityRelationshipDao.saveAll(String, long, List)"})
  void testSaveAll_givenOne_whenArrayListAddOne_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, changeInitiativeIds);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#saveAll(String, long, List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test saveAll(String, long, List); given two; when ArrayList() add two; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityRelationshipDao.saveAll(String, long, List)"})
  void testSaveAll_givenTwo_whenArrayListAddTwo_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(2L);
    changeInitiativeIds.add(1L);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, changeInitiativeIds);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#saveAll(String, long, List)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  @DisplayName("Test saveAll(String, long, List); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityRelationshipDao.saveAll(String, long, List)"})
  void testSaveAll_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#saveAll(String, long, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#saveAll(String, long, List)}
   */
  @Test
  @DisplayName("Test saveAll(String, long, List); when ArrayList(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityRelationshipDao.saveAll(String, long, List)"})
  void testSaveAll_whenArrayList_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    // Act
    int[] actualSaveAllResult = entityRelationshipDao.saveAll("42", 1L, new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualSaveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAll(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAll(long, List)"})
  void testRemoveAll_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = cast(? as bigint) and 1 = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAll(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAll(long, List)"})
  void testRemoveAll_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"id_b\" in ())");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAll(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeAll(long, List); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAll(long, List)"})
  void testRemoveAll_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, new ArrayList<>());

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAll(long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  @DisplayName("Test removeAll(long, List); given one; when ArrayList() add one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAll(long, List)"})
  void testRemoveAll_givenOne_whenArrayListAddOne_thenReturnOne() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, changeInitiativeIds);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#removeAll(long, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#removeAll(long, List)}
   */
  @Test
  @DisplayName("Test removeAll(long, List); given zero; when ArrayList() add zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityRelationshipDao.removeAll(long, List)"})
  void testRemoveAll_givenZero_whenArrayListAddZero_thenReturnOne() throws DataAccessException {
    // Arrange
    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<EntityRelationshipRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<EntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<EntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(0L);
    changeInitiativeIds.add(1L);

    // Act
    int actualRemoveAllResult = entityRelationshipDao.removeAll(1L, changeInitiativeIds);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveAllResult);
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(2), Mockito.<Timestamp>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships7() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);
    EntityRelationshipDao entityRelationshipDao = new EntityRelationshipDao(dsl);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    entityRelationshipDao.migrateEntityRelationships(
        sourceReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipDao#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test migrateEntityRelationships(EntityReference, EntityReference, String); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipDao.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    entityRelationshipDao.migrateEntityRelationships(null, null, "42");

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }
}
