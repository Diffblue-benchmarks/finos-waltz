package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.CommonTableFields;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableCommonTableFields;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.DefaultSchema;
import org.finos.waltz.schema.tables.AccessLog;
import org.finos.waltz.schema.tables.Actor;
import org.finos.waltz.schema.tables.AllocationScheme;
import org.finos.waltz.schema.tables.Application;
import org.finos.waltz.schema.tables.ApplicationGroup;
import org.finos.waltz.schema.tables.AssessmentDefinition;
import org.finos.waltz.schema.tables.ChangeInitiative;
import org.finos.waltz.schema.tables.ChangeSet;
import org.finos.waltz.schema.tables.ChangeUnit;
import org.finos.waltz.schema.tables.CostKind;
import org.finos.waltz.schema.tables.records.ActorRecord;
import org.finos.waltz.schema.tables.records.AllocationSchemeRecord;
import org.finos.waltz.schema.tables.records.ApplicationGroupRecord;
import org.finos.waltz.schema.tables.records.ApplicationRecord;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.finos.waltz.schema.tables.records.ChangeInitiativeRecord;
import org.finos.waltz.schema.tables.records.ChangeLogRecord;
import org.finos.waltz.schema.tables.records.ChangeSetRecord;
import org.finos.waltz.schema.tables.records.ChangeUnitRecord;
import org.finos.waltz.schema.tables.records.CostKindRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.Name;
import org.jooq.QueryPart;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableLike;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JooqUtilitiesDiffblueTest {
  /**
   * Test {@link JooqUtilities#calculateStringTallies(Collection, Field)} with {@code records},
   * {@code fieldToTally}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#calculateStringTallies(Collection, Field)}
   */
  @Test
  @DisplayName(
      "Test calculateStringTallies(Collection, Field) with 'records', 'fieldToTally'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JooqUtilities.calculateStringTallies(Collection, Field)"})
  void testCalculateStringTalliesWithRecordsFieldToTally_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Tally<String>> actualCalculateStringTalliesResult =
        JooqUtilities.calculateStringTallies(
            new ArrayList<>(), PhysicalSpecificationDao.owningEntityNameField);

    // Assert
    assertTrue(actualCalculateStringTalliesResult.isEmpty());
  }

  /**
   * Test {@link JooqUtilities#isPostgres(SQLDialect)}.
   *
   * <ul>
   *   <li>When {@link SQLDialect#POSTGRES}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#isPostgres(SQLDialect)}
   */
  @Test
  @DisplayName("Test isPostgres(SQLDialect); when POSTGRES; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JooqUtilities.isPostgres(SQLDialect)"})
  void testIsPostgres_whenPostgres_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JooqUtilities.isPostgres(SQLDialect.POSTGRES));
  }

  /**
   * Test {@link JooqUtilities#isPostgres(SQLDialect)}.
   *
   * <ul>
   *   <li>When {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#isPostgres(SQLDialect)}
   */
  @Test
  @DisplayName("Test isPostgres(SQLDialect); when 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JooqUtilities.isPostgres(SQLDialect)"})
  void testIsPostgres_whenSql99_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isPostgres(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#isMariaDB(SQLDialect)}.
   *
   * <ul>
   *   <li>When {@link SQLDialect#MARIADB}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#isMariaDB(SQLDialect)}
   */
  @Test
  @DisplayName("Test isMariaDB(SQLDialect); when MARIADB; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JooqUtilities.isMariaDB(SQLDialect)"})
  void testIsMariaDB_whenMariadb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(JooqUtilities.isMariaDB(SQLDialect.MARIADB));
  }

  /**
   * Test {@link JooqUtilities#isMariaDB(SQLDialect)}.
   *
   * <ul>
   *   <li>When {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#isMariaDB(SQLDialect)}
   */
  @Test
  @DisplayName("Test isMariaDB(SQLDialect); when 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JooqUtilities.isMariaDB(SQLDialect)"})
  void testIsMariaDB_whenSql99_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isMariaDB(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#isSQLServer(SQLDialect)}.
   *
   * <p>Method under test: {@link JooqUtilities#isSQLServer(SQLDialect)}
   */
  @Test
  @DisplayName("Test isSQLServer(SQLDialect)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JooqUtilities.isSQLServer(SQLDialect)"})
  void testIsSQLServer() {
    // Arrange, Act and Assert
    assertFalse(JooqUtilities.isSQLServer(SQLDialect.SQL99));
  }

  /**
   * Test {@link JooqUtilities#makeTallyQuery(DSLContext, Table, Field, Condition)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectSelectStep#from(TableLike)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#makeTallyQuery(DSLContext, Table, Field, Condition)}
   */
  @Test
  @DisplayName(
      "Test makeTallyQuery(DSLContext, Table, Field, Condition); then calls from(TableLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SelectHavingStep JooqUtilities.makeTallyQuery(DSLContext, Table, Field, Condition)"
  })
  void testMakeTallyQuery_thenCallsFrom() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenReturn(mock(SelectHavingStep.class));

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    JooqUtilities.makeTallyQuery(dsl, ActorDao.actor, mock(Field.class), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link JooqUtilities#makeOrderedTallyQuery(DSLContext, Table, Field, Condition)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectSelectStep#from(TableLike)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#makeOrderedTallyQuery(DSLContext, Table, Field,
   * Condition)}
   */
  @Test
  @DisplayName(
      "Test makeOrderedTallyQuery(DSLContext, Table, Field, Condition); then calls from(TableLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SelectHavingStep JooqUtilities.makeOrderedTallyQuery(DSLContext, Table, Field, Condition)"
  })
  void testMakeOrderedTallyQuery_thenCallsFrom() {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenReturn(mock(SelectHavingStep.class));

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    JooqUtilities.makeOrderedTallyQuery(
        dsl, ActorDao.actor, mock(Field.class), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link JooqUtilities#mkEndOfLifeStatusDerivedField(Field)}.
   *
   * <p>Method under test: {@link JooqUtilities#mkEndOfLifeStatusDerivedField(Field)}
   */
  @Test
  @DisplayName("Test mkEndOfLifeStatusDerivedField(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field JooqUtilities.mkEndOfLifeStatusDerivedField(Field)"})
  void testMkEndOfLifeStatusDerivedField() {
    // Arrange
    Field<Date> endOfLifeDateField = mock(Field.class);
    when(endOfLifeDateField.lt(Mockito.<Field<Date>>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkEndOfLifeStatusDerivedField(endOfLifeDateField);

    // Assert
    verify(endOfLifeDateField).lt(isA(Field.class));
  }

  /**
   * Test {@link JooqUtilities#mkBasicTermSearch(Field, List)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link Field#containsIgnoreCase(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkBasicTermSearch(Field, List)}
   */
  @Test
  @DisplayName(
      "Test mkBasicTermSearch(Field, List); given IS_ACTIVE; then calls containsIgnoreCase(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkBasicTermSearch(Field, List)"})
  void testMkBasicTermSearch_givenIs_active_thenCallsContainsIgnoreCase() {
    // Arrange
    Field<String> field = mock(Field.class);
    when(field.containsIgnoreCase(Mockito.<String>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<String> terms = new ArrayList<>();
    terms.add("foo");

    // Act
    JooqUtilities.mkBasicTermSearch(field, terms);

    // Assert
    verify(field).containsIgnoreCase("foo");
  }

  /**
   * Test {@link JooqUtilities#mkStartsWithTermSearch(Field, List)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link Field#startsWithIgnoreCase(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkStartsWithTermSearch(Field, List)}
   */
  @Test
  @DisplayName(
      "Test mkStartsWithTermSearch(Field, List); given IS_ACTIVE; then calls startsWithIgnoreCase(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkStartsWithTermSearch(Field, List)"})
  void testMkStartsWithTermSearch_givenIs_active_thenCallsStartsWithIgnoreCase() {
    // Arrange
    Field<String> field = mock(Field.class);
    when(field.startsWithIgnoreCase(Mockito.<String>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    ArrayList<String> terms = new ArrayList<>();
    terms.add("foo");

    // Act
    JooqUtilities.mkStartsWithTermSearch(field, terms);

    // Assert
    verify(field).startsWithIgnoreCase("foo");
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link Condition#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(field, new Date(1L));

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link Condition#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date, Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd2() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date startDate = new Date(1L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, startDate, new Date(1L));

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   *
   * <ul>
   *   <li>Given {@link Condition} {@link Condition#and(Condition)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link Condition#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, java.util.Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date); given Condition and(Condition) return IS_ACTIVE; then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, java.util.Date)"})
  void testMkDateRangeCondition_givenConditionAndReturnIs_active_thenCallsAnd3() {
    // Arrange
    Condition condition = mock(Condition.class);
    when(condition.and(Mockito.<Condition>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(condition);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(
        field,
        java.util.Date.from(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(condition).and(isA(Condition.class));
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   *
   * <ul>
   *   <li>When {@link TableField} {@link TableField#ge(Object)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link TableField#ge(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date); when TableField ge(Object) return IS_ACTIVE; then calls ge(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active_thenCallsGe() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(field, new Date(1L));

    // Assert
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}.
   *
   * <ul>
   *   <li>When {@link TableField} {@link TableField#ge(Object)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link TableField#ge(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, Date, Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date, Date); when TableField ge(Object) return IS_ACTIVE; then calls ge(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, Date, Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active_thenCallsGe2() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    Date startDate = new Date(1L);

    // Act
    JooqUtilities.mkDateRangeCondition(field, startDate, new Date(1L));

    // Assert
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#mkDateRangeCondition(TableField, Date)}.
   *
   * <ul>
   *   <li>When {@link TableField} {@link TableField#ge(Object)} return {@link
   *       ApplicationDao#IS_ACTIVE}.
   *   <li>Then calls {@link TableField#ge(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#mkDateRangeCondition(TableField, java.util.Date)}
   */
  @Test
  @DisplayName(
      "Test mkDateRangeCondition(TableField, Date); when TableField ge(Object) return IS_ACTIVE; then calls ge(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Condition JooqUtilities.mkDateRangeCondition(TableField, java.util.Date)"})
  void testMkDateRangeCondition_whenTableFieldGeReturnIs_active_thenCallsGe3() {
    // Arrange
    TableField<ChangeLogRecord, Timestamp> field = mock(TableField.class);
    when(field.ge(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);
    when(field.lt(Mockito.<Timestamp>any())).thenReturn(ApplicationDao.IS_ACTIVE);

    // Act
    JooqUtilities.mkDateRangeCondition(
        field,
        java.util.Date.from(
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(field).ge(isA(Timestamp.class));
    verify(field).lt(isA(Timestamp.class));
  }

  /**
   * Test {@link JooqUtilities#selectorToCTE(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Select#getSelect()}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#selectorToCTE(String, GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test selectorToCTE(String, GenericSelector); given ArrayList(); then calls getSelect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.CommonTableExpression JooqUtilities.selectorToCTE(String, GenericSelector)"
  })
  void testSelectorToCTE_givenArrayList_thenCallsGetSelect() {
    // Arrange
    Select<Record1<Long>> selector = mock(Select.class);
    Mockito.<List<Field<?>>>when(selector.getSelect()).thenReturn(new ArrayList<>());
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    // Act
    JooqUtilities.selectorToCTE("Name", genericSelector);

    // Assert
    verify(selector).getSelect();
  }

  /**
   * Test {@link JooqUtilities#selectorToCTE(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link Field#getDataType()}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#selectorToCTE(String, GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test selectorToCTE(String, GenericSelector); given 'java.lang.Object'; then calls getDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.CommonTableExpression JooqUtilities.selectorToCTE(String, GenericSelector)"
  })
  void testSelectorToCTE_givenJavaLangObject_thenCallsGetDataType() {
    // Arrange
    Field<Object> field = mock(Field.class);
    Class<Object> type = Object.class;
    when(field.getDataType())
        .thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type, "Type Name"));

    ArrayList<Field<?>> fieldList = new ArrayList<>();
    fieldList.add(field);

    Select<Record1<Long>> selector = mock(Select.class);
    Mockito.<List<Field<?>>>when(selector.getSelect()).thenReturn(fieldList);
    ImmutableGenericSelector genericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    // Act
    JooqUtilities.selectorToCTE("Name", genericSelector);

    // Assert
    verify(selector).getSelect();
    verify(field).getDataType();
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>Given {@link Name} {@link Name#last()} return {@code Last}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName(
      "Test fieldsWithout(Table, Field[]); given Name last() return 'Last'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_givenNameLastReturnLast_thenReturnSizeIsOne() {
    // Arrange
    Name name = mock(Name.class);
    when(name.last()).thenReturn("Last");

    Name alias = mock(Name.class);
    when(alias.append(Mockito.<Name>any())).thenReturn(name);

    // Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AccessLog(alias), mock(Field.class));

    // Assert
    verify(alias, atLeast(1)).append(Mockito.<Name>any());
    verify(name, atLeast(1)).last();
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(1, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>Given {@link Name} {@link Name#last()} return {@code Last}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName(
      "Test fieldsWithout(Table, Field[]); given Name last() return 'Last'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_givenNameLastReturnLast_thenReturnSizeIsOne2() {
    // Arrange
    Name name = mock(Name.class);
    when(name.last()).thenReturn("Last");

    Name alias = mock(Name.class);
    when(alias.append(Mockito.<Name>any())).thenReturn(name);

    // Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AccessLog(alias));

    // Assert
    verify(alias, atLeast(1)).append(Mockito.<Name>any());
    verify(name, atLeast(1)).last();
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(1, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link AccessLog#AccessLog()}.
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AccessLog(); then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAccessLog_thenReturnSizeIsFive() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AccessLog(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link AccessLog#AccessLog()}.
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AccessLog(); then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAccessLog_thenReturnSizeIsFive2() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AccessLog(), null);

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link Actor#Actor()}.
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when Actor(); then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenActor_thenReturnSizeIsEight() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new Actor(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(8, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link AllocationScheme#AllocationScheme()}.
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName(
      "Test fieldsWithout(Table, Field[]); when AllocationScheme(); then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAllocationScheme_thenReturnSizeIsFive() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AllocationScheme(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(5, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link ApplicationGroup#ApplicationGroup()}.
   *   <li>Then return size is seven.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName(
      "Test fieldsWithout(Table, Field[]); when ApplicationGroup(); then return size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenApplicationGroup_thenReturnSizeIsSeven() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new ApplicationGroup(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(7, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link Application#Application()}.
   *   <li>Then return size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName(
      "Test fieldsWithout(Table, Field[]); when Application(); then return size is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenApplication_thenReturnSizeIsEighteen() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new Application(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(18, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#fieldsWithout(Table, Field[])}.
   *
   * <ul>
   *   <li>When {@link AssessmentDefinition#AssessmentDefinition()}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#fieldsWithout(Table, Field[])}
   */
  @Test
  @DisplayName("Test fieldsWithout(Table, Field[]); when AssessmentDefinition(); then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection JooqUtilities.fieldsWithout(Table, Field[])"})
  void testFieldsWithout_whenAssessmentDefinition_thenReturnSize() {
    // Arrange and Act
    Collection<? extends Field<?>> actualFieldsWithoutResult =
        JooqUtilities.fieldsWithout(new AssessmentDefinition(), mock(Field.class));

    // Assert
    assertTrue(actualFieldsWithoutResult instanceof Set);
    assertEquals(Short.SIZE, actualFieldsWithoutResult.size());
  }

  /**
   * Test {@link JooqUtilities#summarizeResults(int[])}.
   *
   * <p>Method under test: {@link JooqUtilities#summarizeResults(int[])}
   */
  @Test
  @DisplayName("Test summarizeResults(int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JooqUtilities.summarizeResults(int[])"})
  void testSummarizeResults() {
    // Arrange, Act and Assert
    assertEquals(0, JooqUtilities.summarizeResults(new int[] {1, -1, 1, -1}));
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return AllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ALLOCATION_SCHEME, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(EntityKind.ALLOCATION_SCHEME, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AllocationSchemeRecord> expectedRecordType = AllocationSchemeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link Application}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return Application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.APPLICATION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(3, tableResult.getIndexes().size());
    assertEquals(EntityKind.APPLICATION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationRecord> expectedRecordType = ApplicationRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link ApplicationGroup}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ApplicationGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.APP_GROUP, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.APP_GROUP, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationGroupRecord> expectedRecordType = ApplicationGroupRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return AssessmentDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(2, tableResult.getKeys().size());
    assertEquals(
        EntityKind.ASSESSMENT_DEFINITION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AssessmentDefinitionRecord> expectedRecordType = AssessmentDefinitionRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ChangeInitiative")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_INITIATIVE, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertNull(tableResult.getIdentity());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeInitiativeRecord> expectedRecordType = ChangeInitiativeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeSet}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ChangeSet")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnChangeSet() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_SET, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeSet);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_SET, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeSetRecord> expectedRecordType = ChangeSetRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeUnit}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; then table return ChangeUnit")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_thenTableReturnChangeUnit() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_UNIT, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeUnit);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(2, tableResult.getIndexes().size());
    assertEquals(EntityKind.CHANGE_UNIT, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeUnitRecord> expectedRecordType = ChangeUnitRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind, String)} with {@code kind},
   * {@code alias}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then table return {@link Actor}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind, String) with 'kind', 'alias'; when 'ACTOR'; then table return Actor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind, String)"
  })
  void testDetermineCommonTableFieldsWithKindAlias_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ACTOR, "Alias");

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(EntityKind.ACTOR, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ActorRecord> expectedRecordType = ActorRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then table return {@link AllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; then table return AllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnAllocationScheme() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ALLOCATION_SCHEME);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AllocationScheme);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(EntityKind.ALLOCATION_SCHEME, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AllocationSchemeRecord> expectedRecordType = AllocationSchemeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then table return {@link Application}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; then table return Application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnApplication() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.APPLICATION);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Application);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(3, tableResult.getIndexes().size());
    assertEquals(EntityKind.APPLICATION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationRecord> expectedRecordType = ApplicationRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then table return {@link ApplicationGroup}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; then table return ApplicationGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnApplicationGroup() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.APP_GROUP);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ApplicationGroup);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.APP_GROUP, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ApplicationGroupRecord> expectedRecordType = ApplicationGroupRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then table return {@link AssessmentDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; then table return AssessmentDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnAssessmentDefinition() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ASSESSMENT_DEFINITION);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof AssessmentDefinition);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getReferences().size());
    assertEquals(2, tableResult.getKeys().size());
    assertEquals(
        EntityKind.ASSESSMENT_DEFINITION, actualDetermineCommonTableFieldsResult.entityKind());
    Class<AssessmentDefinitionRecord> expectedRecordType = AssessmentDefinitionRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then table return {@link ChangeInitiative}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; then table return ChangeInitiative")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_thenTableReturnChangeInitiative() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_INITIATIVE);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeInitiative);
    assertNull(tableResult.getIdentity());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeInitiativeRecord> expectedRecordType = ChangeInitiativeRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then table return {@link Actor}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; when 'ACTOR'; then table return Actor")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenActor_thenTableReturnActor() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.ACTOR);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof Actor);
    assertEquals(3, tableResult.getKeys().size());
    assertEquals(EntityKind.ACTOR, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ActorRecord> expectedRecordType = ActorRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code CHANGE_SET}.
   *   <li>Then table return {@link ChangeSet}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; when 'CHANGE_SET'; then table return ChangeSet")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenChangeSet_thenTableReturnChangeSet() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_SET);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeSet);
    assertEquals(1, tableResult.getIndexes().size());
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.CHANGE_SET, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeSetRecord> expectedRecordType = ChangeSetRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then table return {@link ChangeUnit}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; when 'CHANGE_UNIT'; then table return ChangeUnit")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenChangeUnit_thenTableReturnChangeUnit() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.CHANGE_UNIT);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof ChangeUnit);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(2, tableResult.getIndexes().size());
    assertEquals(EntityKind.CHANGE_UNIT, actualDetermineCommonTableFieldsResult.entityKind());
    Class<ChangeUnitRecord> expectedRecordType = ChangeUnitRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }

  /**
   * Test {@link JooqUtilities#determineCommonTableFields(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>When {@code COST_KIND}.
   *   <li>Then table return {@link CostKind}.
   * </ul>
   *
   * <p>Method under test: {@link JooqUtilities#determineCommonTableFields(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineCommonTableFields(EntityKind) with 'kind'; when 'COST_KIND'; then table return CostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CommonTableFields JooqUtilities.determineCommonTableFields(EntityKind)"})
  void testDetermineCommonTableFieldsWithKind_whenCostKind_thenTableReturnCostKind() {
    // Arrange and Act
    CommonTableFields<?> actualDetermineCommonTableFieldsResult =
        JooqUtilities.determineCommonTableFields(EntityKind.COST_KIND);

    // Assert
    assertTrue(actualDetermineCommonTableFieldsResult instanceof ImmutableCommonTableFields);
    Table<?> tableResult = actualDetermineCommonTableFieldsResult.table();
    assertTrue(tableResult.getSchema() instanceof DefaultSchema);
    assertTrue(tableResult instanceof CostKind);
    assertEquals(1, tableResult.getKeys().size());
    assertEquals(EntityKind.COST_KIND, actualDetermineCommonTableFieldsResult.entityKind());
    Class<CostKindRecord> expectedRecordType = CostKindRecord.class;
    assertEquals(expectedRecordType, tableResult.getRecordType());
    assertEquals(tableResult, tableResult.getQualifiedName());
  }
}
