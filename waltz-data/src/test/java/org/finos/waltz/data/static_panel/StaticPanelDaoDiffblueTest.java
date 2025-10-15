package org.finos.waltz.data.static_panel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.model.staticpanel.ContentKind;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel;
import org.finos.waltz.model.staticpanel.StaticPanel;
import org.finos.waltz.schema.tables.records.StaticPanelRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep1;
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
class StaticPanelDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private StaticPanelDao staticPanelDao;

  /**
   * Test {@link StaticPanelDao#findByGroups(String[])}.
   *
   * <p>Method under test: {@link StaticPanelDao#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelDao.findByGroups(String[])"})
  void testFindByGroups() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<StaticPanel> actualFindByGroupsResult = staticPanelDao.findByGroups("Groups");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Test {@link StaticPanelDao#findAll()}.
   *
   * <p>Method under test: {@link StaticPanelDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticPanelDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<StaticPanel> actualFindAllResult = staticPanelDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link StaticPanelDao#update(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return minus
   *       one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelDao#update(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test update(StaticPanel); given DSLContext executeUpdate(UpdatableRecord) return minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelDao.update(StaticPanel)"})
  void testUpdate_givenDSLContextExecuteUpdateReturnMinusOne_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(-1);
    StaticPanelRecord staticPanelRecord =
        new StaticPanelRecord(
            2L, "Group", "Dr", "Icon", 1, 1, "UTF-8", "Not all who wander are lost");
    when(dSLContext.newRecord(Mockito.<Table<StaticPanelRecord>>any()))
        .thenReturn(staticPanelRecord);

    // Act
    boolean actualUpdateResult =
        staticPanelDao.update(
            ImmutableStaticPanel.builder()
                .content("Not all who wander are lost")
                .encoding(ContentKind.HTML)
                .group("Group")
                .icon("Icon")
                .id(1L)
                .priority(1)
                .title("Dr")
                .build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link StaticPanelDao#update(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#newRecord(Table)} return {@link
   *       StaticPanelRecord#StaticPanelRecord()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelDao#update(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test update(StaticPanel); given DSLContext newRecord(Table) return StaticPanelRecord(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelDao.update(StaticPanel)"})
  void testUpdate_givenDSLContextNewRecordReturnStaticPanelRecord_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.newRecord(Mockito.<Table<StaticPanelRecord>>any()))
        .thenReturn(new StaticPanelRecord());

    // Act
    boolean actualUpdateResult =
        staticPanelDao.update(
            ImmutableStaticPanel.builder()
                .content("Not all who wander are lost")
                .encoding(ContentKind.HTML)
                .group("Group")
                .icon("Icon")
                .id(1L)
                .priority(1)
                .title("Dr")
                .build());

    // Assert
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link StaticPanelDao#update(StaticPanel)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link StaticPanelDao#update(StaticPanel)}
   */
  @Test
  @DisplayName(
      "Test update(StaticPanel); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticPanelDao.update(StaticPanel)"})
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException {
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
    StaticPanelDao staticPanelDao = new StaticPanelDao(dsl);

    // Act
    boolean actualUpdateResult =
        staticPanelDao.update(
            ImmutableStaticPanel.builder()
                .content("Not all who wander are lost")
                .encoding(ContentKind.HTML)
                .group("Group")
                .icon("Icon")
                .id(1L)
                .priority(1)
                .title("Dr")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"static_panel\" set \"static_panel\".\"group\" = ?, \"static_panel\".\"title\" = ?, \"static_panel\".\"icon\" = ?, \"static_panel\".\"priority\" = ?, \"static_panel\".\"width\" = ?, \"static_panel\".\"encoding\" = ?, \"static_panel\".\"content\" = ? where \"static_panel\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement).setLong(8, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }
}
