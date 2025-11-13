package org.finos.waltz.data.rel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.rel.ImmutableRelationshipKind;
import org.finos.waltz.model.rel.ImmutableUpdateRelationshipKindCommand;
import org.finos.waltz.model.rel.RelationshipKind;
import org.finos.waltz.model.rel.UpdateRelationshipKindCommand;
import org.finos.waltz.schema.tables.records.RelationshipKindRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
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
class RelationshipKindDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private RelationshipKindDao relationshipKindDao;

  /**
   * Test {@link RelationshipKindDao#findAll()}.
   *
   * <p>Method under test: {@link RelationshipKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RelationshipKindDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<RelationshipKind> actualFindAllResult = new RelationshipKindDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link RelationshipKindDao#getById(long)}.
   *
   * <p>Method under test: {@link RelationshipKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationshipKind RelationshipKindDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
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

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    RelationshipKind actualById = new RelationshipKindDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableRelationshipKind);
    assertEquals("Code", actualById.code());
    assertEquals("Name", actualById.name());
    assertEquals("Reverse Name", actualById.reverseName());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.categoryA().longValue());
    assertEquals(1L, actualById.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualById.kindA());
    assertEquals(EntityKind.ALL, actualById.kindB());
    assertFalse(actualById.isReadonly());
  }

  /**
   * Test {@link RelationshipKindDao#findRelationshipKindsBetweenEntites(EntityReference,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * RelationshipKindDao#findRelationshipKindsBetweenEntites(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test findRelationshipKindsBetweenEntites(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set RelationshipKindDao.findRelationshipKindsBetweenEntites(EntityReference, EntityReference)"
  })
  void testFindRelationshipKindsBetweenEntites() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);
    ImmutableEntityReference parent =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Set<RelationshipKind> actualFindRelationshipKindsBetweenEntitesResult =
        relationshipKindDao.findRelationshipKindsBetweenEntites(
            parent,
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
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindRelationshipKindsBetweenEntitesResult.isEmpty());
  }

  /**
   * Test {@link RelationshipKindDao#findRelationshipKindsBetweenEntites(EntityReference,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * RelationshipKindDao#findRelationshipKindsBetweenEntites(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test findRelationshipKindsBetweenEntites(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set RelationshipKindDao.findRelationshipKindsBetweenEntites(EntityReference, EntityReference)"
  })
  void testFindRelationshipKindsBetweenEntites2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference parent =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Set<RelationshipKind> actualFindRelationshipKindsBetweenEntitesResult =
        relationshipKindDao.findRelationshipKindsBetweenEntites(
            parent,
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
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindRelationshipKindsBetweenEntitesResult.isEmpty());
  }

  /**
   * Test {@link RelationshipKindDao#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.create(RelationshipKind)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualCreateResult =
        relationshipKindDao.create(
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
    verify(connection)
        .prepareStatement(
            "insert into \"relationship_kind\" (\"name\", \"description\", \"kind_a\", \"kind_b\", \"category_a\", \"category_b\", \"is_readonly\", \"code\", \"position\", \"reverse_name\") values (cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as bigint), cast(? as bigint), cast(? as bit(1)), cast(? as varchar), cast(? as int), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(7, false);
    verify(preparedStatement).setInt(9, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindDao#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.create(RelationshipKind)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualCreateResult =
        relationshipKindDao.create(
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
    verify(connection)
        .prepareStatement(
            "insert into \"relationship_kind\" (\"name\", \"description\", \"kind_a\", \"kind_b\", \"category_a\", \"category_b\", \"is_readonly\", \"code\", \"position\", \"reverse_name\") values (cast(? as varchar(4)), cast(? as varchar(43)), cast(? as varchar(3)), cast(? as varchar(3)), cast(? as bigint), cast(? as bigint), cast(? as boolean), cast(? as varchar(4)), cast(? as integer), cast(? as varchar(12)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(7, false);
    verify(preparedStatement).setInt(9, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindDao#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.create(RelationshipKind)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualCreateResult =
        relationshipKindDao.create(
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
    verify(connection)
        .prepareStatement(
            "insert into \"relationship_kind\" (\"name\", \"description\", \"kind_a\", \"kind_b\", \"category_a\", \"category_b\", \"is_readonly\", \"code\", \"position\", \"reverse_name\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(7, false);
    verify(preparedStatement).setInt(9, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindDao#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link RelationshipKind} {@link RelationshipKind#position()} return one.
   *   <li>Then calls {@link RelationshipKind#description()}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given one; when RelationshipKind position() return one; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.create(RelationshipKind)"})
  void testCreate_givenOne_whenRelationshipKindPositionReturnOne_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    RelationshipKind relationshipKind = mock(RelationshipKind.class);
    when(relationshipKind.position()).thenReturn(1);
    when(relationshipKind.categoryA()).thenReturn(1L);
    when(relationshipKind.categoryB()).thenReturn(1L);
    when(relationshipKind.reverseName()).thenReturn("Reverse Name");
    when(relationshipKind.isReadonly()).thenReturn(true);
    when(relationshipKind.kindB()).thenReturn(EntityKind.ALL);
    when(relationshipKind.description()).thenReturn("The characteristics of someone or something");
    when(relationshipKind.name()).thenReturn("Name");
    when(relationshipKind.code()).thenReturn("Code");
    when(relationshipKind.kindA()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualCreateResult = relationshipKindDao.create(relationshipKind);

    // Assert
    verify(relationshipKind).description();
    verify(relationshipKind).name();
    verify(relationshipKind).categoryA();
    verify(relationshipKind).categoryB();
    verify(relationshipKind).code();
    verify(relationshipKind).isReadonly();
    verify(relationshipKind).kindA();
    verify(relationshipKind).kindB();
    verify(relationshipKind).position();
    verify(relationshipKind).reverseName();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindDao#create(RelationshipKind)}.
   *
   * <ul>
   *   <li>Given {@link RelationshipKindDao#RelationshipKindDao(DSLContext)} with dsl is {@link
   *       DSLContext}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#create(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test create(RelationshipKind); given RelationshipKindDao(DSLContext) with dsl is DSLContext; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.create(RelationshipKind)"})
  void testCreate_givenRelationshipKindDaoWithDslIsDSLContext_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualCreateResult =
        relationshipKindDao.create(
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
    verify(dsl).executeInsert(isA(TableRecord.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"relationship_kind\" where \"relationship_kind\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsMariadb() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from `relationship_kind` where `relationship_kind`.`id` = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"relationship_kind\" where \"relationship_kind\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"relationship_kind\" where \"relationship_kind\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from relationship_kind where relationship_kind.id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<RelationshipKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<RelationshipKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<RelationshipKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.remove(Long)"})
  void testRemove_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRemoveResult = new RelationshipKindDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"relationship_kind\" where \"relationship_kind\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualUpdateResult =
        relationshipKindDao.update(
            1L,
            ImmutableUpdateRelationshipKindCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"relationship_kind\" set \"relationship_kind\".\"name\" = cast(? as varchar), \"relationship_kind\".\"reverse_name\" = cast(? as varchar), \"relationship_kind\".\"description\" = cast(? as varchar), \"relationship_kind\".\"position\" = cast(? as int) where \"relationship_kind\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(4, 1);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualUpdateResult =
        relationshipKindDao.update(
            1L,
            ImmutableUpdateRelationshipKindCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"relationship_kind\" set \"relationship_kind\".\"name\" = cast(? as varchar(4)), \"relationship_kind\".\"reverse_name\" = cast(? as varchar(12)), \"relationship_kind\".\"description\" = cast(? as varchar(43)), \"relationship_kind\".\"position\" = cast(? as integer) where \"relationship_kind\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(4, 1);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualUpdateResult =
        relationshipKindDao.update(
            1L,
            ImmutableUpdateRelationshipKindCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"relationship_kind\" set \"relationship_kind\".\"name\" = ?, \"relationship_kind\".\"reverse_name\" = ?, \"relationship_kind\".\"description\" = ?, \"relationship_kind\".\"position\" = ? where \"relationship_kind\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(4, 1);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RelationshipKindRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<RelationshipKindRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<RelationshipKindRecord>>any())).thenReturn(updateSetFirstStep);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualUpdateResult =
        relationshipKindDao.update(
            1L,
            ImmutableUpdateRelationshipKindCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link UpdateConditionStep#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link RelationshipKindDao#update(long, UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, UpdateRelationshipKindCommand); given UpdateConditionStep execute() return zero; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKindDao.update(long, UpdateRelationshipKindCommand)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnZero_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RelationshipKindRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<RelationshipKindRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<RelationshipKindRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<RelationshipKindRecord>>any())).thenReturn(updateSetFirstStep);
    RelationshipKindDao relationshipKindDao = new RelationshipKindDao(dsl);

    // Act
    boolean actualUpdateResult =
        relationshipKindDao.update(
            1L,
            ImmutableUpdateRelationshipKindCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertFalse(actualUpdateResult);
  }
}
