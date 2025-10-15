package org.finos.waltz.data.entity_statistic;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_statistic.EntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticDefinition;
import org.finos.waltz.model.entity_statistic.RollupKind;
import org.finos.waltz.model.entity_statistic.StatisticCategory;
import org.finos.waltz.model.entity_statistic.StatisticType;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
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
class EntityStatisticDefinitionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityStatisticDefinitionDao entityStatisticDefinitionDao;

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test insert(EntityStatisticDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    // Act
    boolean actualInsertResult =
        entityStatisticDefinitionDao.insert(
            ImmutableEntityStatisticDefinition.builder()
                .active(true)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test insert(EntityStatisticDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert2() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    // Act
    boolean actualInsertResult =
        entityStatisticDefinitionDao.insert(
            ImmutableEntityStatisticDefinition.builder()
                .active(false)
                .category(StatisticCategory.COMPLIANCE)
                .description("The characteristics of someone or something")
                .entityVisibility(true)
                .historicRenderer("Historic Renderer")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .provenance("Provenance")
                .renderer("Renderer")
                .rollupKind(RollupKind.COUNT_BY_ENTITY)
                .rollupVisibility(true)
                .type(StatisticType.BOOLEAN)
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return nine.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test insert(EntityStatisticDefinition); given DSLContext executeInsert(TableRecord) return nine; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert_givenDSLContextExecuteInsertReturnNine_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(9);

    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertFalse(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test insert(EntityStatisticDefinition); given DSLContext executeInsert(TableRecord) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert_givenDSLContextExecuteInsertReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertTrue(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test insert(EntityStatisticDefinition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityStatisticDefinitionDao entityStatisticDefinitionDao =
        new EntityStatisticDefinitionDao(dsl);

    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_statistic_definition\" (\"name\", \"description\", \"type\", \"category\", \"active\", \"renderer\", \"historic_renderer\", \"provenance\", \"parent_id\", \"id\", \"entity_visibility\", \"rollup_visibility\", \"rollup_kind\") values (cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as bit(1)), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as bigint), cast(? as bigint), cast(? as bit(1)), cast(? as bit(1)), cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    assertFalse(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test insert(EntityStatisticDefinition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    EntityStatisticDefinitionDao entityStatisticDefinitionDao =
        new EntityStatisticDefinitionDao(dsl);

    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_statistic_definition\" (\"name\", \"description\", \"type\", \"category\", \"active\", \"renderer\", \"historic_renderer\", \"provenance\", \"parent_id\", \"id\", \"entity_visibility\", \"rollup_visibility\", \"rollup_kind\") values (cast(? as varchar(4)), cast(? as varchar(43)), cast(? as varchar(7)), cast(? as varchar(10)), cast(? as boolean), cast(? as varchar(8)), cast(? as varchar(17)), cast(? as varchar(10)), cast(? as bigint), cast(? as bigint), cast(? as boolean), cast(? as boolean), cast(? as varchar(15)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    assertFalse(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#insert(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName(
      "Test insert(EntityStatisticDefinition); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityStatisticDefinitionDao.insert(EntityStatisticDefinition)"})
  void testInsert_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityStatisticDefinitionDao entityStatisticDefinitionDao =
        new EntityStatisticDefinitionDao(dsl);

    EntityStatisticDefinition entityStatistic = mock(EntityStatisticDefinition.class);
    when(entityStatistic.entityVisibility()).thenReturn(true);
    when(entityStatistic.rollupVisibility()).thenReturn(true);
    when(entityStatistic.historicRenderer()).thenReturn("Historic Renderer");
    when(entityStatistic.renderer()).thenReturn("Renderer");
    when(entityStatistic.provenance()).thenReturn("Provenance");
    when(entityStatistic.active()).thenReturn(true);
    when(entityStatistic.rollupKind()).thenReturn(RollupKind.COUNT_BY_ENTITY);
    when(entityStatistic.category()).thenReturn(StatisticCategory.COMPLIANCE);
    when(entityStatistic.description()).thenReturn("The characteristics of someone or something");
    when(entityStatistic.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
    when(entityStatistic.parentId()).thenReturn(ofResult);
    when(entityStatistic.type()).thenReturn(StatisticType.BOOLEAN);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(entityStatistic.id()).thenReturn(ofResult2);

    // Act
    boolean actualInsertResult = entityStatisticDefinitionDao.insert(entityStatistic);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"entity_statistic_definition\" (\"name\", \"description\", \"type\", \"category\", \"active\", \"renderer\", \"historic_renderer\", \"provenance\", \"parent_id\", \"id\", \"entity_visibility\", \"rollup_visibility\", \"rollup_kind\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityStatistic).description();
    verify(entityStatistic).id();
    verify(entityStatistic).name();
    verify(entityStatistic).parentId();
    verify(entityStatistic).provenance();
    verify(entityStatistic).active();
    verify(entityStatistic).category();
    verify(entityStatistic).entityVisibility();
    verify(entityStatistic).historicRenderer();
    verify(entityStatistic).renderer();
    verify(entityStatistic).rollupKind();
    verify(entityStatistic).rollupVisibility();
    verify(entityStatistic).type();
    assertFalse(actualInsertResult);
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#findAllActiveDefinitions(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#findAllActiveDefinitions(boolean)}
   */
  @Test
  @DisplayName("Test findAllActiveDefinitions(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findAllActiveDefinitions(boolean)"})
  void testFindAllActiveDefinitions_whenFalse() throws DataAccessException {
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
    List<EntityStatisticDefinition> actualFindAllActiveDefinitionsResult =
        entityStatisticDefinitionDao.findAllActiveDefinitions(false);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllActiveDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#findAllActiveDefinitions(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#findAllActiveDefinitions(boolean)}
   */
  @Test
  @DisplayName("Test findAllActiveDefinitions(boolean); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findAllActiveDefinitions(boolean)"})
  void testFindAllActiveDefinitions_whenTrue() throws DataAccessException {
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
    List<EntityStatisticDefinition> actualFindAllActiveDefinitionsResult =
        entityStatisticDefinitionDao.findAllActiveDefinitions(true);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllActiveDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#findByIds(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#findByIds(List)}
   */
  @Test
  @DisplayName("Test findByIds(List); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findByIds(List)"})
  void testFindByIds_givenOne_whenArrayListAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<EntityStatisticDefinition> actualFindByIdsResult =
        entityStatisticDefinitionDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#findByIds(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#findByIds(List)}
   */
  @Test
  @DisplayName("Test findByIds(List); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findByIds(List)"})
  void testFindByIds_givenZero_whenArrayListAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<EntityStatisticDefinition> actualFindByIdsResult =
        entityStatisticDefinitionDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#findByIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityStatisticDefinitionDao#findByIds(List)}
   */
  @Test
  @DisplayName("Test findByIds(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findByIds(List)"})
  void testFindByIds_whenArrayList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<EntityStatisticDefinition> actualFindByIdsResult =
        entityStatisticDefinitionDao.findByIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }
}
