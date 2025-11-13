package org.finos.waltz.service.system_version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.finos.waltz.model.system_version.ImmutableSystemVersionInfo;
import org.finos.waltz.model.system_version.SystemVersionInfo;
import org.jooq.CommonTableExpression;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.WithStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SystemVersionServiceDiffblueTest {
  /**
   * Test {@link SystemVersionService#getVersionInfo()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return databaseVersions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  @DisplayName(
      "Test getVersionInfo(); given ArrayList() add '42'; then return databaseVersions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemVersionInfo SystemVersionService.getVersionInfo()"})
  void testGetVersionInfo_givenArrayListAdd42_thenReturnDatabaseVersionsIsArrayList()
      throws DataAccessException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");

    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<Field<Object>>any())).thenReturn(objectList);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act
    SystemVersionInfo actualVersionInfo = new SystemVersionService(dsl).getVersionInfo();

    // Assert
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(withStep).select(isA(SelectField.class));
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    assertEquals(objectList, actualVersionInfo.databaseVersions());
  }

  /**
   * Test {@link SystemVersionService#getVersionInfo()}.
   *
   * <ul>
   *   <li>Then return databaseVersions Empty.
   * </ul>
   *
   * <p>Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  @DisplayName("Test getVersionInfo(); then return databaseVersions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemVersionInfo SystemVersionService.getVersionInfo()"})
  void testGetVersionInfo_thenReturnDatabaseVersionsEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act
    SystemVersionInfo actualVersionInfo = new SystemVersionService(dsl).getVersionInfo();

    // Assert
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(withStep).select(isA(SelectField.class));
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    assertEquals("null - null - null", actualVersionInfo.packageVersion());
    assertTrue(actualVersionInfo.databaseVersions().isEmpty());
  }

  /**
   * Test {@link SystemVersionService#getVersionInfo()}.
   *
   * <ul>
   *   <li>Then return databaseVersions size is one.
   * </ul>
   *
   * <p>Method under test: {@link SystemVersionService#getVersionInfo()}
   */
  @Test
  @DisplayName("Test getVersionInfo(); then return databaseVersions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemVersionInfo SystemVersionService.getVersionInfo()"})
  void testGetVersionInfo_thenReturnDatabaseVersionsSizeIsOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    SystemVersionInfo actualVersionInfo = new SystemVersionService(dsl).getVersionInfo();

    // Assert
    verify(connection)
        .prepareStatement(
            "with \"raw\"(\"filename\", \"rn\") as (select \"databasechangelog\".\"filename\", row_number() over (partition by \"databasechangelog\".\"filename\" order by \"databasechangelog\".\"dateexecuted\") from \"databasechangelog\" order by \"databasechangelog\".\"dateexecuted\" desc) select filename from \"raw\" where rn = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualVersionInfo instanceof ImmutableSystemVersionInfo);
    List<String> databaseVersionsResult = actualVersionInfo.databaseVersions();
    assertEquals(1, databaseVersionsResult.size());
    assertEquals("-1", databaseVersionsResult.get(0));
    assertEquals("null - null - null", actualVersionInfo.packageVersion());
  }
}
