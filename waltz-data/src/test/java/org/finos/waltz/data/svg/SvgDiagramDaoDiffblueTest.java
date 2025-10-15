package org.finos.waltz.data.svg;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.svg.ImmutableSvgDiagram;
import org.finos.waltz.model.svg.SvgDiagram;
import org.finos.waltz.schema.tables.records.SvgDiagramRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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
class SvgDiagramDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SvgDiagramDao svgDiagramDao;

  /**
   * Test {@link SvgDiagramDao#findByGroups(String[])}.
   *
   * <p>Method under test: {@link SvgDiagramDao#findByGroups(String[])}
   */
  @Test
  @DisplayName("Test findByGroups(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SvgDiagramDao.findByGroups(String[])"})
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
    List<SvgDiagram> actualFindByGroupsResult = svgDiagramDao.findByGroups(new String[] {"Groups"});

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Test {@link SvgDiagramDao#findAll()}.
   *
   * <p>Method under test: {@link SvgDiagramDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SvgDiagramDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<SvgDiagram> actualFindAllResult = svgDiagramDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link SvgDiagramDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SvgDiagramRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SvgDiagramRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<SvgDiagramRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveResult = svgDiagramDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link SvgDiagramDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SvgDiagramRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<SvgDiagramRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<SvgDiagramRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    Boolean actualRemoveResult = svgDiagramDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link SvgDiagramDao#save(SvgDiagram)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramDao#save(SvgDiagram)}
   */
  @Test
  @DisplayName(
      "Test save(SvgDiagram); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramDao.save(SvgDiagram)"})
  void testSave_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SvgDiagramDao svgDiagramDao = new SvgDiagramDao(dsl);

    // Act
    Boolean actualSaveResult =
        svgDiagramDao.save(
            ImmutableSvgDiagram.builder()
                .description("The characteristics of someone or something")
                .displayHeightPercent(1)
                .displayWidthPercent(1)
                .group("Group")
                .id(1L)
                .keyProperty("Key Property")
                .name("Name")
                .priority(1)
                .product("Product")
                .svg("Svg")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"svg_diagram\" set \"svg_diagram\".\"name\" = ?, \"svg_diagram\".\"group\" = ?, \"svg_diagram\".\"priority\" = ?, \"svg_diagram\".\"description\" = ?, \"svg_diagram\".\"svg\" = ?, \"svg_diagram\".\"key_property\" = ?, \"svg_diagram\".\"product\" = ?, \"svg_diagram\".\"display_width_percent\" = ?, \"svg_diagram\".\"display_height_percent\" = ? where \"svg_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setLong(10, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link SvgDiagramDao#save(SvgDiagram)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SvgDiagramDao#save(SvgDiagram)}
   */
  @Test
  @DisplayName(
      "Test save(SvgDiagram); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SvgDiagramDao.save(SvgDiagram)"})
  void testSave_givenPreparedStatementExecuteReturnTrue_thenReturnFalse() throws SQLException {
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
    SvgDiagramDao svgDiagramDao = new SvgDiagramDao(dsl);

    // Act
    Boolean actualSaveResult =
        svgDiagramDao.save(
            ImmutableSvgDiagram.builder()
                .description("The characteristics of someone or something")
                .displayHeightPercent(1)
                .displayWidthPercent(1)
                .group("Group")
                .id(1L)
                .keyProperty("Key Property")
                .name("Name")
                .priority(1)
                .product("Product")
                .svg("Svg")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"svg_diagram\" set \"svg_diagram\".\"name\" = ?, \"svg_diagram\".\"group\" = ?, \"svg_diagram\".\"priority\" = ?, \"svg_diagram\".\"description\" = ?, \"svg_diagram\".\"svg\" = ?, \"svg_diagram\".\"key_property\" = ?, \"svg_diagram\".\"product\" = ?, \"svg_diagram\".\"display_width_percent\" = ?, \"svg_diagram\".\"display_height_percent\" = ? where \"svg_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(1));
    verify(preparedStatement).setLong(10, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }
}
