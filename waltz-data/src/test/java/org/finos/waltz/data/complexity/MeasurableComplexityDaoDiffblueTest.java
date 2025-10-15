package org.finos.waltz.data.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.GroupField;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
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
class MeasurableComplexityDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableComplexityDao measurableComplexityDao;

  /**
   * Test {@link MeasurableComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return doubleValue is {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return doubleValue is '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double MeasurableComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_thenReturnDoubleValueIs23() throws DataAccessException {
    // Arrange
    Record1<Object> record1 = mock(Record1.class);
    when(record1.value1()).thenReturn(new BigDecimal("2.3"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchOne()).thenReturn(record1);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenReturn(mock(SelectHavingStep.class));

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    Double actualCalculateBaselineResult = measurableComplexityDao.calculateBaseline();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(record1).value1();
    verify(selectJoinStep).fetchOne();
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertEquals(2.3d, actualCalculateBaselineResult.doubleValue());
  }

  /**
   * Test {@link MeasurableComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return doubleValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return doubleValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double MeasurableComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_thenReturnDoubleValueIsMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    Double actualCalculateBaselineResult = new MeasurableComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(score) from (select \"measurable_rating\".\"entity_id\", sum(coalesce((? / nullif(\"entity_hierarchy\".\"level\",?)), ?)) \"score\" from \"measurable_rating\" join \"entity_hierarchy\" on \"entity_hierarchy\".\"id\" = \"measurable_rating\".\"measurable_id\" where (1 = 1 and \"entity_hierarchy\".\"kind\" = ? and \"measurable_rating\".\"entity_kind\" = ?) group by \"measurable_rating\".\"entity_id\") \"alias_44076726\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1.0d, actualCalculateBaselineResult.doubleValue());
  }
}
