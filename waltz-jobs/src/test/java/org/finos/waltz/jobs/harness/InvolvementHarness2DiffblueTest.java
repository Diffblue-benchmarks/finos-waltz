package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.rating.RagRating;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementHarness2DiffblueTest {
  /**
   * Method under test: {@link InvolvementHarness2#foo(DSLContext, String)}
   */
  @Test
  void testFoo() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<Application> actualFooResult = InvolvementHarness2
        .foo(new DefaultDSLContext(connection, SQLDialect.SQL99), "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" in (select distinct \"involvement\".\"entity_id\" from \"involvement\" where (\"involvement\".\"entity_kind\" = ? and \"involvement\".\"employee_id\" in (select distinct \"person_hierarchy\".\"employee_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"manager_id\" = ? union select ? from \"person_hierarchy\")))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualFooResult instanceof List);
    assertEquals(2, actualFooResult.size());
    Application getResult = ((List<Application>) actualFooResult).get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = ((List<Application>) actualFooResult).get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link InvolvementHarness2#foo2(DSLContext, String)}
   */
  @Test
  void testFoo2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Result<Record1<String>> actualFoo2Result = InvolvementHarness2
        .foo2(new DefaultDSLContext(connection, SQLDialect.SQL99), "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"person_hierarchy\".\"employee_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"manager_id\" = ? union select ? from \"person_hierarchy\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFoo2Result.size());
    assertEquals(actualFoo2Result.get(0), actualFoo2Result.get(1));
  }
}
