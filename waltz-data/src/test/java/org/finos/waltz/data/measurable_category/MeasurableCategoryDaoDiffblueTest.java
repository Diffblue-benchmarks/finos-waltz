package org.finos.waltz.data.measurable_category;

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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableCategoryDaoDiffblueTest {
  /**
   * Test {@link MeasurableCategoryDao#findAll()}.
   *
   * <p>Method under test: {@link MeasurableCategoryDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<MeasurableCategory> actualFindAllResult = new MeasurableCategoryDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(objectList, actualFindAllResult);
  }

  /**
   * Test {@link MeasurableCategoryDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableCategoryDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableCategory MeasurableCategoryDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    MeasurableCategory actualById = new MeasurableCategoryDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableMeasurableCategory);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Icon", actualById.icon());
    assertEquals("Name", actualById.name());
    assertEquals("Rating Editor Role", actualById.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(0, actualById.position());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.editable());
    assertFalse(actualById.isDeprecated());
    assertTrue(actualById.allowPrimaryRatings());
  }

  /**
   * Test {@link MeasurableCategoryDao#findByExternalId(String)}.
   *
   * <p>Method under test: {@link MeasurableCategoryDao#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableCategoryDao.findByExternalId(String)"})
  void testFindByExternalId() throws DataAccessException {
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

    // Act
    Set<MeasurableCategory> actualFindByExternalIdResult =
        new MeasurableCategoryDao(dsl).findByExternalId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableCategoryDao#findCategoriesByDirectOrgUnit(long)}.
   *
   * <p>Method under test: {@link MeasurableCategoryDao#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  @DisplayName("Test findCategoriesByDirectOrgUnit(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryDao.findCategoriesByDirectOrgUnit(long)"})
  void testFindCategoriesByDirectOrgUnit() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<MeasurableCategory> actualFindCategoriesByDirectOrgUnitResult =
        new MeasurableCategoryDao(dsl).findCategoriesByDirectOrgUnit(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindCategoriesByDirectOrgUnitResult instanceof List);
    assertTrue(actualFindCategoriesByDirectOrgUnitResult.isEmpty());
    assertSame(objectList, actualFindCategoriesByDirectOrgUnitResult);
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = cast(? as varchar), \"measurable_category\".\"description\" = cast(? as varchar), \"measurable_category\".\"external_id\" = cast(? as varchar), \"measurable_category\".\"last_updated_at\" = cast(? as datetime), \"measurable_category\".\"last_updated_by\" = cast(? as varchar), \"measurable_category\".\"rating_scheme_id\" = cast(? as bigint), \"measurable_category\".\"editable\" = cast(? as bit(1)), \"measurable_category\".\"rating_editor_role\" = cast(? as varchar), \"measurable_category\".\"constraining_assessment_definition_id\" = cast(? as bigint), \"measurable_category\".\"position\" = cast(? as int), \"measurable_category\".\"icon_name\" = cast(? as varchar), \"measurable_category\".\"allow_primary_ratings\" = cast(? as bit(1)) where \"measurable_category\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = cast(? as varchar(4)), \"measurable_category\".\"description\" = cast(? as varchar(43)), \"measurable_category\".\"external_id\" = cast(? as varchar(2)), \"measurable_category\".\"last_updated_at\" = cast(? as timestamp), \"measurable_category\".\"last_updated_by\" = cast(? as varchar(7)), \"measurable_category\".\"rating_scheme_id\" = cast(? as bigint), \"measurable_category\".\"editable\" = cast(? as boolean), \"measurable_category\".\"rating_editor_role\" = cast(? as varchar(18)), \"measurable_category\".\"constraining_assessment_definition_id\" = cast(? as bigint), \"measurable_category\".\"position\" = cast(? as integer), \"measurable_category\".\"icon_name\" = cast(? as varchar(4)), \"measurable_category\".\"allow_primary_ratings\" = cast(? as boolean) where \"measurable_category\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = ?, \"measurable_category\".\"description\" = ?, \"measurable_category\".\"external_id\" = ?, \"measurable_category\".\"last_updated_at\" = ?, \"measurable_category\".\"last_updated_by\" = ?, \"measurable_category\".\"rating_scheme_id\" = ?, \"measurable_category\".\"editable\" = ?, \"measurable_category\".\"rating_editor_role\" = ?, \"measurable_category\".\"constraining_assessment_definition_id\" = ?, \"measurable_category\".\"position\" = ?, \"measurable_category\".\"icon_name\" = ?, \"measurable_category\".\"allow_primary_ratings\" = ? where \"measurable_category\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = ?, \"measurable_category\".\"description\" = ?, \"measurable_category\".\"external_id\" = ?, \"measurable_category\".\"last_updated_at\" = ?, \"measurable_category\".\"last_updated_by\" = ?, \"measurable_category\".\"rating_scheme_id\" = ?, \"measurable_category\".\"editable\" = ?, \"measurable_category\".\"rating_editor_role\" = ?, \"measurable_category\".\"constraining_assessment_definition_id\" = ?, \"measurable_category\".\"position\" = ?, \"measurable_category\".\"icon_name\" = ?, \"measurable_category\".\"allow_primary_ratings\" = ? where \"measurable_category\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given PreparedStatement getWarnings() return 'null'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenPreparedStatementGetWarningsReturnNull_thenReturnLongValueIsOne()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = ?, \"measurable_category\".\"description\" = ?, \"measurable_category\".\"external_id\" = ?, \"measurable_category\".\"last_updated_at\" = ?, \"measurable_category\".\"last_updated_by\" = ?, \"measurable_category\".\"rating_scheme_id\" = ?, \"measurable_category\".\"editable\" = ?, \"measurable_category\".\"rating_editor_role\" = ?, \"measurable_category\".\"constraining_assessment_definition_id\" = ?, \"measurable_category\".\"position\" = ?, \"measurable_category\".\"icon_name\" = ?, \"measurable_category\".\"allow_primary_ratings\" = ? where \"measurable_category\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryDao#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryDao.save(MeasurableCategory, String)"})
  void testSave_givenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Long actualSaveResult =
        measurableCategoryDao.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description(null)
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_category\" set \"measurable_category\".\"name\" = ?, \"measurable_category\".\"description\" = ?, \"measurable_category\".\"external_id\" = ?, \"measurable_category\".\"last_updated_at\" = ?, \"measurable_category\".\"last_updated_by\" = ?, \"measurable_category\".\"rating_scheme_id\" = ?, \"measurable_category\".\"editable\" = ?, \"measurable_category\".\"rating_editor_role\" = ?, \"measurable_category\".\"constraining_assessment_definition_id\" = ?, \"measurable_category\".\"position\" = ?, \"measurable_category\".\"icon_name\" = ?, \"measurable_category\".\"allow_primary_ratings\" = ? where \"measurable_category\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(10, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryDao#findRatingCountsByCategoryId(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryDao#findRatingCountsByCategoryId(EntityReference)}
   */
  @Test
  @DisplayName("Test findRatingCountsByCategoryId(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableCategoryDao.findRatingCountsByCategoryId(EntityReference)"})
  void testFindRatingCountsByCategoryId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record2<Object, Object>> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch()).thenReturn(null);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record2<Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep4 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<Record2<Object, Object>> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(dsl);

    // Act
    Map<Long, Long> actualFindRatingCountsByCategoryIdResult =
        measurableCategoryDao.findRatingCountsByCategoryId(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(selectOrderByStep).fetch();
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnStep4, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep3, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep3).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl, atLeast(1)).select(isA(SelectField.class), isA(SelectField.class));
    assertTrue(actualFindRatingCountsByCategoryIdResult.isEmpty());
  }
}
