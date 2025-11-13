package org.finos.waltz.data.rating_scheme;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.rating.ImmutableRatingScheme;
import org.finos.waltz.model.rating.ImmutableRatingScheme.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingScheme;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItemUsageCount;
import org.finos.waltz.schema.tables.records.RatingSchemeItemRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.GroupField;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalCallable;
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
class RatingSchemeDAODiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private RatingSchemeDAO ratingSchemeDAO;

  /**
   * Test {@link RatingSchemeDAO#findAll()}.
   *
   * <p>Method under test: {@link RatingSchemeDAO#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RatingSchemeDAO.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectSeekStep1<RatingSchemeItemRecord, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.fetch(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new ArrayList<>());
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);

    // Act
    Collection<RatingScheme> actualFindAllResult = new RatingSchemeDAO(dsl).findAll();

    // Assert
    verify(dsl, atLeast(1)).selectFrom(Mockito.<Table<Record>>any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectWhereStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableRatingScheme}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableRatingScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingScheme RatingSchemeDAO.getById(long)"})
  void testGetById_thenReturnImmutableRatingScheme() throws DataAccessException {
    // Arrange
    SelectSeekStep1<RatingSchemeItemRecord, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);

    // Act
    RatingScheme actualById = new RatingSchemeDAO(dsl).getById(1L);

    // Assert
    verify(dsl, atLeast(1)).selectFrom(Mockito.<Table<Record>>any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectWhereStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualById instanceof ImmutableRatingScheme);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertTrue(actualById.ratings().isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#fetchItems(Condition)}.
   *
   * <p>Method under test: {@link RatingSchemeDAO#fetchItems(Condition)}
   */
  @Test
  @DisplayName("Test fetchItems(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeDAO.fetchItems(Condition)"})
  void testFetchItems() throws DataAccessException {
    // Arrange
    SelectSeekStep1<RatingSchemeItemRecord, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);

    // Act
    List<RatingSchemeItem> actualFetchItemsResult =
        new RatingSchemeDAO(dsl).fetchItems(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFetchItemsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForAssessmentDefinition(Long)}.
   *
   * <p>Method under test: {@link
   * RatingSchemeDAO#findRatingSchemeItemsForAssessmentDefinition(Long)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsForAssessmentDefinition(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeDAO.findRatingSchemeItemsForAssessmentDefinition(Long)"})
  void testFindRatingSchemeItemsForAssessmentDefinition() throws DataAccessException {
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

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsForAssessmentDefinitionResult =
        new RatingSchemeDAO(dsl).findRatingSchemeItemsForAssessmentDefinition(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForAssessmentDefinitionResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#getRatingSchemeItemById(long)} with {@code long}.
   *
   * <p>Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(long)}
   */
  @Test
  @DisplayName("Test getRatingSchemeItemById(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem RatingSchemeDAO.getRatingSchemeItemById(long)"})
  void testGetRatingSchemeItemByIdWithLong() throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);

    // Act
    RatingSchemeItem actualRatingSchemeItemById =
        new RatingSchemeDAO(dsl).getRatingSchemeItemById(1L);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualRatingSchemeItemById instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", actualRatingSchemeItemById.color());
    assertEquals("Name", actualRatingSchemeItemById.name());
    assertEquals("Rating Group", actualRatingSchemeItemById.ratingGroup());
    assertEquals("Rating", actualRatingSchemeItemById.rating());
    assertEquals(
        "The characteristics of someone or something", actualRatingSchemeItemById.description());
    assertEquals(0, actualRatingSchemeItemById.position());
    assertEquals(1L, actualRatingSchemeItemById.ratingSchemeId());
    assertFalse(actualRatingSchemeItemById.isRestricted());
    assertFalse(actualRatingSchemeItemById.requiresComment());
    assertTrue(actualRatingSchemeItemById.userSelectable());
  }

  /**
   * Test {@link RatingSchemeDAO#getRatingSchemeItemById(Long)} with {@code Long}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableRatingSchemeItem}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#getRatingSchemeItemById(Long)}
   */
  @Test
  @DisplayName(
      "Test getRatingSchemeItemById(Long) with 'Long'; then return ImmutableRatingSchemeItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem RatingSchemeDAO.getRatingSchemeItemById(Long)"})
  void testGetRatingSchemeItemByIdWithLong_thenReturnImmutableRatingSchemeItem()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);

    // Act
    RatingSchemeItem actualRatingSchemeItemById =
        new RatingSchemeDAO(dsl).getRatingSchemeItemById((Long) 1L);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualRatingSchemeItemById instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", actualRatingSchemeItemById.color());
    assertEquals("Name", actualRatingSchemeItemById.name());
    assertEquals("Rating Group", actualRatingSchemeItemById.ratingGroup());
    assertEquals("Rating", actualRatingSchemeItemById.rating());
    assertEquals(
        "The characteristics of someone or something", actualRatingSchemeItemById.description());
    assertEquals(0, actualRatingSchemeItemById.position());
    assertEquals(1L, actualRatingSchemeItemById.ratingSchemeId());
    assertFalse(actualRatingSchemeItemById.isRestricted());
    assertFalse(actualRatingSchemeItemById.requiresComment());
    assertTrue(actualRatingSchemeItemById.userSelectable());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link
   * RatingSchemeDAO#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsForEntityAndCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(EntityReference, long)"
  })
  void testFindRatingSchemeItemsForEntityAndCategory() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsForEntityAndCategoryResult =
        ratingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(
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
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForEntityAndCategoryResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link
   * RatingSchemeDAO#findRatingSchemeItemsForEntityAndCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsForEntityAndCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(EntityReference, long)"
  })
  void testFindRatingSchemeItemsForEntityAndCategory2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<RatingSchemeItem> actualFindRatingSchemeItemsForEntityAndCategoryResult =
        ratingSchemeDAO.findRatingSchemeItemsForEntityAndCategory(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build(),
            1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForEntityAndCategoryResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSchemeItemsByIds(Set); given minus one; when HashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_givenMinusOne_whenHashSetAddMinusOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    HashSet<Long> ids = new HashSet<>();
    ids.add(-1L);
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO#RatingSchemeDAO(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSchemeItemsByIds(Set); given RatingSchemeDAO(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_givenRatingSchemeDAOWithDslIsDSLContext()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    HashSet<Long> ids = new HashSet<>();
    ids.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsByIds(ids);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsByIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSchemeItemsByIds(Set); given RatingSchemeDAO; when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsByIds(Set)"})
  void testFindRatingSchemeItemsByIds_givenRatingSchemeDAO_whenHashSet_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(dSLContext.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any()))
        .thenReturn(selectWhereStep);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsByIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsByIds(new HashSet<>());

    // Assert
    verify(dSLContext).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsByIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSchemeItemsForSchemeIds(Set); given minus one; when HashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsForSchemeIds(Set)"})
  void testFindRatingSchemeItemsForSchemeIds_givenMinusOne_whenHashSetAddMinusOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(-1L);
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsForSchemeIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(schemeIds);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForSchemeIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO#RatingSchemeDAO(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findRatingSchemeItemsForSchemeIds(Set); given RatingSchemeDAO(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsForSchemeIds(Set)"})
  void testFindRatingSchemeItemsForSchemeIds_givenRatingSchemeDAOWithDslIsDSLContext()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(selectWhereStep);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    HashSet<Long> schemeIds = new HashSet<>();
    schemeIds.add(1L);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsForSchemeIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(schemeIds);

    // Assert
    verify(dsl).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForSchemeIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link RatingSchemeDAO}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#findRatingSchemeItemsForSchemeIds(Set)}
   */
  @Test
  @DisplayName("Test findRatingSchemeItemsForSchemeIds(Set); given RatingSchemeDAO; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RatingSchemeDAO.findRatingSchemeItemsForSchemeIds(Set)"})
  void testFindRatingSchemeItemsForSchemeIds_givenRatingSchemeDAO_whenHashSet()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<RatingSchemeItemRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<RatingSchemeItemRecord, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectWhereStep<RatingSchemeItemRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(dSLContext.selectFrom(Mockito.<Table<RatingSchemeItemRecord>>any()))
        .thenReturn(selectWhereStep);

    // Act
    Set<RatingSchemeItem> actualFindRatingSchemeItemsForSchemeIdsResult =
        ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(new HashSet<>());

    // Assert
    verify(dSLContext).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    assertTrue(actualFindRatingSchemeItemsForSchemeIdsResult.isEmpty());
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnFalse()
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
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = cast(? as varchar), \"rating_scheme\".\"description\" = cast(? as varchar), \"rating_scheme\".\"external_id\" = cast(? as varchar) where \"rating_scheme\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = cast(? as varchar(4)), \"rating_scheme\".\"description\" = cast(? as varchar(43)), \"rating_scheme\".\"external_id\" = cast(? as varchar(2)) where \"rating_scheme\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
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
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = ?, \"rating_scheme\".\"description\" = ?, \"rating_scheme\".\"external_id\" = ? where \"rating_scheme\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = ?, \"rating_scheme\".\"description\" = ?, \"rating_scheme\".\"external_id\" = ? where \"rating_scheme\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = ?, \"rating_scheme\".\"description\" = ?, \"rating_scheme\".\"external_id\" = ? where \"rating_scheme\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#save(RatingScheme)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#save(RatingScheme)}
   */
  @Test
  @DisplayName(
      "Test save(RatingScheme); given PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.save(RatingScheme)"})
  void testSave_givenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    Builder nameResult =
        ImmutableRatingScheme.builder().description(null).externalId("42").id(1L).name("Name");

    // Act
    Boolean actualSaveResult =
        ratingSchemeDAO.save(nameResult.addAllRatings(new ArrayList<>()).build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme\" set \"rating_scheme\".\"name\" = ?, \"rating_scheme\".\"description\" = ?, \"rating_scheme\".\"external_id\" = ? where \"rating_scheme\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(long, RatingSchemeItem); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RatingSchemeDAO.saveRatingItem(long, RatingSchemeItem)"})
  void testSaveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    // Act
    Long actualSaveRatingItemResult =
        ratingSchemeDAO.saveRatingItem(
            1L,
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme_item\" set \"rating_scheme_item\".\"scheme_id\" = cast(? as bigint), \"rating_scheme_item\".\"name\" = cast(? as varchar), \"rating_scheme_item\".\"description\" = cast(? as varchar), \"rating_scheme_item\".\"code\" = cast(? as varchar), \"rating_scheme_item\".\"color\" = cast(? as varchar), \"rating_scheme_item\".\"position\" = cast(? as int), \"rating_scheme_item\".\"user_selectable\" = cast(? as bit(1)), \"rating_scheme_item\".\"external_id\" = cast(? as varchar), \"rating_scheme_item\".\"rating_group\" = cast(? as varchar), \"rating_scheme_item\".\"requires_comment\" = cast(? as bit(1)) where \"rating_scheme_item\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(6, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Test {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(long, RatingSchemeItem); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RatingSchemeDAO.saveRatingItem(long, RatingSchemeItem)"})
  void testSaveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    // Act
    Long actualSaveRatingItemResult =
        ratingSchemeDAO.saveRatingItem(
            1L,
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme_item\" set \"rating_scheme_item\".\"scheme_id\" = cast(? as bigint), \"rating_scheme_item\".\"name\" = cast(? as varchar(4)), \"rating_scheme_item\".\"description\" = cast(? as varchar(43)), \"rating_scheme_item\".\"code\" = cast(? as varchar(6)), \"rating_scheme_item\".\"color\" = cast(? as varchar(5)), \"rating_scheme_item\".\"position\" = cast(? as integer), \"rating_scheme_item\".\"user_selectable\" = cast(? as boolean), \"rating_scheme_item\".\"external_id\" = cast(? as varchar(2)), \"rating_scheme_item\".\"rating_group\" = cast(? as varchar(12)), \"rating_scheme_item\".\"requires_comment\" = cast(? as boolean) where \"rating_scheme_item\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(6, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Test {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#saveRatingItem(long, RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(long, RatingSchemeItem); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RatingSchemeDAO.saveRatingItem(long, RatingSchemeItem)"})
  void testSaveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    RatingSchemeDAO ratingSchemeDAO = new RatingSchemeDAO(dsl);

    // Act
    Long actualSaveRatingItemResult =
        ratingSchemeDAO.saveRatingItem(
            1L,
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"rating_scheme_item\" set \"rating_scheme_item\".\"scheme_id\" = ?, \"rating_scheme_item\".\"name\" = ?, \"rating_scheme_item\".\"description\" = ?, \"rating_scheme_item\".\"code\" = ?, \"rating_scheme_item\".\"color\" = ?, \"rating_scheme_item\".\"position\" = ?, \"rating_scheme_item\".\"user_selectable\" = ?, \"rating_scheme_item\".\"external_id\" = ?, \"rating_scheme_item\".\"rating_group\" = ?, \"rating_scheme_item\".\"requires_comment\" = ? where \"rating_scheme_item\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement).setInt(6, 0);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from `rating_scheme_item` where `rating_scheme_item`.`id` = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from rating_scheme_item where rating_scheme_item.id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<RatingSchemeItemRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<RatingSchemeItemRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<RatingSchemeItemRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingItem(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingItem(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingItem(long); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingItem(long)"})
  void testRemoveRatingItem_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse()
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
    Boolean actualRemoveRatingItemResult = new RatingSchemeDAO(dsl).removeRatingItem(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"rating_scheme_item\" where \"rating_scheme_item\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveRatingItemResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DSLContext transactionResult(TransactionalCallable) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDSLContextTransactionResultReturnTrue_thenReturnTrue() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(true);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName(
      "Test removeRatingScheme(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#removeRatingScheme(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeDAO#removeRatingScheme(long)}
   */
  @Test
  @DisplayName("Test removeRatingScheme(long); given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RatingSchemeDAO.removeRatingScheme(long)"})
  void testRemoveRatingScheme_givenPreparedStatementGetWarningsReturnNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    Boolean actualRemoveRatingSchemeResult = new RatingSchemeDAO(dsl).removeRatingScheme(1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualRemoveRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeDAO#calcRatingUsageStats()}.
   *
   * <p>Method under test: {@link RatingSchemeDAO#calcRatingUsageStats()}
   */
  @Test
  @DisplayName("Test calcRatingUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSchemeDAO.calcRatingUsageStats()"})
  void testCalcRatingUsageStats() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep2 =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectHavingStep<Record4<Object, Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep2);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenReturn(mock(SelectHavingStep.class));

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep4 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep5 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);
    when(selectOnConditionStep5.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep5);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<RatingSchemeItemUsageCount> actualCalcRatingUsageStatsResult =
        ratingSchemeDAO.calcRatingUsageStats();

    // Assert
    verify(dSLContext, atLeast(1))
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            Mockito.<SelectField<Object>>any(),
            isA(SelectField.class));
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectOnConditionStep5).groupBy((GroupField[]) Mockito.any());
    verify(selectOnConditionStep, atLeast(1)).groupBy((GroupField[]) Mockito.any());
    verify(selectOnConditionStep5, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnConditionStep4, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectOnStep3, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep2, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep4, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectHavingStep).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    assertTrue(actualCalcRatingUsageStatsResult.isEmpty());
  }
}
