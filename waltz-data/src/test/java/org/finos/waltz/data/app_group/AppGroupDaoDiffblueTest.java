package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.schema.tables.records.ApplicationGroupRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppGroupDaoDiffblueTest {
  @InjectMocks private AppGroupDao appGroupDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AppGroupDao#findGroupsForUser(String)}.
   *
   * <p>Method under test: {@link AppGroupDao#findGroupsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.findGroupsForUser(String)"})
  void testFindGroupsForUser() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<AppGroup> actualFindGroupsForUserResult = new AppGroupDao(dsl).findGroupsForUser("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindGroupsForUserResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#findPrivateGroupsByOwner(String)}.
   *
   * <p>Method under test: {@link AppGroupDao#findPrivateGroupsByOwner(String)}
   */
  @Test
  @DisplayName("Test findPrivateGroupsByOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.findPrivateGroupsByOwner(String)"})
  void testFindPrivateGroupsByOwner() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<AppGroup> actualFindPrivateGroupsByOwnerResult =
        new AppGroupDao(dsl).findPrivateGroupsByOwner("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPrivateGroupsByOwnerResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#findPublicGroups()}.
   *
   * <p>Method under test: {@link AppGroupDao#findPublicGroups()}
   */
  @Test
  @DisplayName("Test findPublicGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.findPublicGroups()"})
  void testFindPublicGroups() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<AppGroup> actualFindPublicGroupsResult = new AppGroupDao(dsl).findPublicGroups();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPublicGroupsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link AppGroupDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.search(EntitySearchOptions)"})
  void testSearch() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.unionAll(Mockito.<Select<Record>>any()))
        .thenReturn(selectOrderByStep3);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<AppGroup> actualSearchResult =
        appGroupDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).unionAll(isA(Select.class));
    verify(selectOrderByStep3).unionAll(isA(Select.class));
    verify(selectOrderByStep2).unionAll(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link AppGroupDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(mock(DSLContext.class));

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        appGroupDao
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("[")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link AppGroupDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link AppGroupDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.search(EntitySearchOptions)"})
  void testSearch3() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.unionAll(Mockito.<Select<Record>>any()))
        .thenReturn(selectOrderByStep3);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<AppGroup> actualSearchResult =
        appGroupDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).unionAll(isA(Select.class));
    verify(selectOrderByStep3).unionAll(isA(Select.class));
    verify(selectOrderByStep2).unionAll(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#limit()} return one.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given one; when EntitySearchOptions limit() return one; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_whenEntitySearchOptionsLimitReturnOne_thenCallsLimit()
      throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOrderByStep<Record> selectOrderByStep2 = mock(SelectOrderByStep.class);
    when(selectOrderByStep2.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOrderByStep<Record> selectOrderByStep3 = mock(SelectOrderByStep.class);
    when(selectOrderByStep3.unionAll(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep2);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.unionAll(Mockito.<Select<Record>>any()))
        .thenReturn(selectOrderByStep3);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.userId()).thenReturn("42");
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<AppGroup> actualSearchResult = appGroupDao.search(options);

    // Assert
    verify(options).limit();
    verify(options).searchQuery();
    verify(options).userId();
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectOnStep, atLeast(1)).on(isA(Condition.class));
    verify(selectConditionStep).unionAll(isA(Select.class));
    verify(selectOrderByStep3).unionAll(isA(Select.class));
    verify(selectOrderByStep2).unionAll(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link AppGroupDao#update(AppGroup)}.
   *
   * <p>Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  @DisplayName("Test update(AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.update(AppGroup)"})
  void testUpdate() throws SQLException {
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
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    // Act
    int actualUpdateResult =
        appGroupDao.update(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"description\" = ?, \"application_group\".\"name\" = ?, \"application_group\".\"kind\" = ?, \"application_group\".\"external_id\" = ? where \"application_group\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link AppGroupDao#update(AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao#AppGroupDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test update(AppGroup); given AppGroupDao(DSLContext) with dsl is DSLContext; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.update(AppGroup)"})
  void testUpdate_givenAppGroupDaoWithDslIsDSLContext_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ApplicationGroupRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<ApplicationGroupRecord>>any())).thenReturn(updateSetFirstStep);
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link AppGroupDao#update(AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test update(AppGroup); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.update(AppGroup)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
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
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"description\" = cast(? as varchar), \"application_group\".\"name\" = cast(? as varchar), \"application_group\".\"kind\" = cast(? as varchar), \"application_group\".\"external_id\" = cast(? as varchar) where \"application_group\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link AppGroupDao#update(AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test update(AppGroup); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.update(AppGroup)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"description\" = cast(? as varchar(43)), \"application_group\".\"name\" = cast(? as varchar(4)), \"application_group\".\"kind\" = cast(? as varchar(6)), \"application_group\".\"external_id\" = cast(? as varchar(3)) where \"application_group\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link AppGroupDao#update(AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test update(AppGroup); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.update(AppGroup)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
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
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"description\" = ?, \"application_group\".\"name\" = ?, \"application_group\".\"kind\" = ?, \"application_group\".\"external_id\" = ? where \"application_group\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link AppGroupDao#insert(AppGroup)}.
   *
   * <p>Method under test: {@link AppGroupDao#insert(AppGroup)}
   */
  @Test
  @DisplayName("Test insert(AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupDao.insert(AppGroup)"})
  void testInsert() throws DataAccessException {
    // Arrange
    InsertResultStep<ApplicationGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new ApplicationGroupRecord());

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetStep<ApplicationGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    Long actualInsertResult =
        appGroupDao.insert(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualInsertResult);
  }

  /**
   * Test {@link AppGroupDao#insert(AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao#AppGroupDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then calls {@link AppGroup#description()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#insert(AppGroup)}
   */
  @Test
  @DisplayName(
      "Test insert(AppGroup); given AppGroupDao(DSLContext) with dsl is DSLContext; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupDao.insert(AppGroup)"})
  void testInsert_givenAppGroupDaoWithDslIsDSLContext_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    InsertResultStep<ApplicationGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new ApplicationGroupRecord());

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<ApplicationGroupRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetStep<ApplicationGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupRecord>>any())).thenReturn(insertSetStep);
    AppGroupDao appGroupDao = new AppGroupDao(dsl);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    when(appGroup.isRemoved()).thenReturn(true);
    when(appGroup.isFavouriteGroup()).thenReturn(true);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    Long actualInsertResult = appGroupDao.insert(appGroup);

    // Assert
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).isRemoved();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    verify(appGroup).isFavouriteGroup();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualInsertResult);
  }

  /**
   * Test {@link AppGroupDao#deleteGroup(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#deleteGroup(long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.deleteGroup(long)"})
  void testDeleteGroup_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteGroupResult = new AppGroupDao(dsl).deleteGroup(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"is_removed\" = cast(? as bit(1)) where (\"application_group\".\"id\" = cast(? as bigint) and \"application_group\".\"is_favourite_group\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteGroupResult);
  }

  /**
   * Test {@link AppGroupDao#deleteGroup(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#deleteGroup(long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.deleteGroup(long)"})
  void testDeleteGroup_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteGroupResult = new AppGroupDao(dsl).deleteGroup(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application_group\" set \"application_group\".\"is_removed\" = ? where (\"application_group\".\"id\" = ? and \"application_group\".\"is_favourite_group\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteGroupResult);
  }

  /**
   * Test {@link AppGroupDao#deleteGroup(long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#deleteGroup(long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.deleteGroup(long)"})
  void testDeleteGroup_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<ApplicationGroupRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ApplicationGroupRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualDeleteGroupResult = new AppGroupDao(dsl).deleteGroup(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualDeleteGroupResult);
  }

  /**
   * Test {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.processAdditionsAndRemovals(Set, Set, String)"})
  void testProcessAdditionsAndRemovals() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, immutableEntityReference);
    additions.add(tuple2);

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }

  /**
   * Test {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.processAdditionsAndRemovals(Set, Set, String)"})
  void testProcessAdditionsAndRemovals2() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(1L, immutableEntityReference);
    removals.add(tuple2);

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, removals, "42"));
  }

  /**
   * Test {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.processAdditionsAndRemovals(Set, Set, String)"})
  void testProcessAdditionsAndRemovals3() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));

    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(-1L, immutableEntityReference);
    additions.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, immutableEntityReference2);
    additions.add(tuple22);

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }

  /**
   * Test {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}.
   *
   * <p>Method under test: {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(Set, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.processAdditionsAndRemovals(Set, Set, String)"})
  void testProcessAdditionsAndRemovals4() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    HashSet<Tuple2<Long, EntityReference>> removals = new HashSet<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple2 = new Tuple2<>(-1L, immutableEntityReference);
    removals.add(tuple2);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Tuple2<Long, EntityReference> tuple22 = new Tuple2<>(1L, immutableEntityReference2);
    removals.add(tuple22);

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, removals, "42"));
  }

  /**
   * Test {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  @DisplayName("Test processAdditionsAndRemovals(Set, Set, String); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupDao.processAdditionsAndRemovals(Set, Set, String)"})
  void testProcessAdditionsAndRemovals_thenReturnZero() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }
}
