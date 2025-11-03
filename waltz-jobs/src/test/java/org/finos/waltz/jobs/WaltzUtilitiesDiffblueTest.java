package org.finos.waltz.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.schema.tables.LogicalFlow;
import org.finos.waltz.schema.tables.LogicalFlowDecorator;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WaltzUtilitiesDiffblueTest {
  /**
   * Test {@link WaltzUtilities#getOrCreateMeasurableCategory(DSLContext, String, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link Connection#prepareStatement(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#getOrCreateMeasurableCategory(DSLContext, String, String)}
   */
  @Test
  @DisplayName("Test getOrCreateMeasurableCategory(DSLContext, String, String); given 'true'; then calls prepareStatement(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long WaltzUtilities.getOrCreateMeasurableCategory(DSLContext, String, String)"})
  void testGetOrCreateMeasurableCategory_givenTrue_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    ResultSet resultSet2 = mock(ResultSet.class);
    when(resultSet2.getLong(anyInt())).thenReturn(1L);
    when(resultSet2.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet2).close();
    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.executeUpdate()).thenReturn(1);
    when(preparedStatement2.getGeneratedKeys()).thenReturn(resultSet2);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement2).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement2);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Long actualOrCreateMeasurableCategory = WaltzUtilities
        .getOrCreateMeasurableCategory(new DefaultDSLContext(connection, SQLDialect.SQL99), "42", "Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\" from \"measurable_category\" where \"measurable_category\".\"external_id\" = ?"));
    verify(connection).prepareStatement(eq(
        "insert into \"measurable_category\" (\"name\", \"description\", \"external_id\", \"last_updated_at\", \"last_updated_by\", \"rating_scheme_id\") values (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).execute();
    verify(preparedStatement2).executeUpdate();
    verify(preparedStatement2).setLong(eq(6), eq(1L));
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement2).setTimestamp(eq(4), isA(Timestamp.class));
    verify(resultSet2).close();
    verify(resultSet).close();
    verify(resultSet2, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(resultSet2, atLeast(1)).next();
    verify(preparedStatement2).close();
    verify(preparedStatement).close();
    verify(preparedStatement2).getGeneratedKeys();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement2).getWarnings();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualOrCreateMeasurableCategory.longValue());
  }

  /**
   * Test {@link WaltzUtilities#getOrCreateMeasurableCategory(DSLContext, String, String)}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#getOrCreateMeasurableCategory(DSLContext, String, String)}
   */
  @Test
  @DisplayName("Test getOrCreateMeasurableCategory(DSLContext, String, String); then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long WaltzUtilities.getOrCreateMeasurableCategory(DSLContext, String, String)"})
  void testGetOrCreateMeasurableCategory_thenReturnLongValueIsOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    Long actualOrCreateMeasurableCategory = WaltzUtilities
        .getOrCreateMeasurableCategory(new DefaultDSLContext(connection, SQLDialect.SQL99), "42", "Name");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\" from \"measurable_category\" where \"measurable_category\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualOrCreateMeasurableCategory.longValue());
  }

  /**
   * Test {@link WaltzUtilities#toId(String)} with {@code t}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#toId(String)}
   */
  @Test
  @DisplayName("Test toId(String) with 't'; when 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WaltzUtilities.toId(String)"})
  void testToIdWithT_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", WaltzUtilities.toId("foo"));
  }

  /**
   * Test {@link WaltzUtilities#toId(String)} with {@code t}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#toId(String)}
   */
  @Test
  @DisplayName("Test toId(String) with 't'; when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WaltzUtilities.toId(String)"})
  void testToIdWithT_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", WaltzUtilities.toId((String) null));
  }

  /**
   * Test {@link WaltzUtilities#toId(String[])} with {@code ts}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#toId(String[])}
   */
  @Test
  @DisplayName("Test toId(String[]) with 'ts'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WaltzUtilities.toId(String[])"})
  void testToIdWithTs_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", WaltzUtilities.toId());
  }

  /**
   * Test {@link WaltzUtilities#toId(String[])} with {@code ts}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return {@code ts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#toId(String[])}
   */
  @Test
  @DisplayName("Test toId(String[]) with 'ts'; when 'Ts'; then return 'ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WaltzUtilities.toId(String[])"})
  void testToIdWithTs_whenTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("ts", WaltzUtilities.toId("Ts"));
  }

  /**
   * Test {@link WaltzUtilities#toId(String[])} with {@code ts}.
   * <ul>
   *   <li>When {@code _} and {@code Ts}.</li>
   *   <li>Then return {@code __ts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#toId(String[])}
   */
  @Test
  @DisplayName("Test toId(String[]) with 'ts'; when '_' and 'Ts'; then return '__ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WaltzUtilities.toId(String[])"})
  void testToIdWithTs_whenUnderscoreAndTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("__ts", WaltzUtilities.toId("_", "Ts"));
  }

  /**
   * Test {@link WaltzUtilities#getActiveAppIds(DSLContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#getActiveAppIds(DSLContext)}
   */
  @Test
  @DisplayName("Test getActiveAppIds(DSLContext); given ResultSet getLong(int) return one; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List WaltzUtilities.getActiveAppIds(DSLContext)"})
  void testGetActiveAppIds_givenResultSetGetLongReturnOne_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    List<Long> actualActiveAppIds = WaltzUtilities.getActiveAppIds(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\" from \"application\" where \"application\".\"entity_lifecycle_status\" <> ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("REMOVED"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualActiveAppIds.size());
    assertEquals(1L, actualActiveAppIds.get(0).longValue());
    assertEquals(1L, actualActiveAppIds.get(1).longValue());
  }

  /**
   * Test {@link WaltzUtilities#mkLogicalFlowDecoratorRecord(long, long, String)}.
   * <p>
   * Method under test: {@link WaltzUtilities#mkLogicalFlowDecoratorRecord(long, long, String)}
   */
  @Test
  @DisplayName("Test mkLogicalFlowDecoratorRecord(long, long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlowDecoratorRecord WaltzUtilities.mkLogicalFlowDecoratorRecord(long, long, String)"})
  void testMkLogicalFlowDecoratorRecord() {
    // Arrange and Act
    LogicalFlowDecoratorRecord actualMkLogicalFlowDecoratorRecordResult = WaltzUtilities
        .mkLogicalFlowDecoratorRecord(1L, 1L, "Provenance");

    // Assert
    assertTrue(actualMkLogicalFlowDecoratorRecordResult.getTable() instanceof LogicalFlowDecorator);
    assertEquals("DATA_TYPE", actualMkLogicalFlowDecoratorRecordResult.component2());
    assertEquals("DATA_TYPE", actualMkLogicalFlowDecoratorRecordResult.getDecoratorEntityKind());
    assertEquals("DATA_TYPE", actualMkLogicalFlowDecoratorRecordResult.value2());
    assertEquals("NO_OPINION", actualMkLogicalFlowDecoratorRecordResult.component4());
    assertEquals("NO_OPINION", actualMkLogicalFlowDecoratorRecordResult.getRating());
    assertEquals("NO_OPINION", actualMkLogicalFlowDecoratorRecordResult.value4());
    assertEquals("Provenance", actualMkLogicalFlowDecoratorRecordResult.component5());
    assertEquals("Provenance", actualMkLogicalFlowDecoratorRecordResult.getProvenance());
    assertEquals("Provenance", actualMkLogicalFlowDecoratorRecordResult.value5());
    assertEquals("admin", actualMkLogicalFlowDecoratorRecordResult.component7());
    assertEquals("admin", actualMkLogicalFlowDecoratorRecordResult.getLastUpdatedBy());
    assertEquals("admin", actualMkLogicalFlowDecoratorRecordResult.value7());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.component9());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.getIsReadonly());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.value9());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.component10());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.component11());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.component8());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.getFlowClassificationRuleId());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.getId());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.getInboundFlowClassificationRuleId());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.value10());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.value11());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.value8());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.component12());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.getTargetInboundRating());
    assertNull(actualMkLogicalFlowDecoratorRecordResult.value12());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.component1().longValue());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.component3().longValue());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.getDecoratorEntityId().longValue());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.getLogicalFlowId().longValue());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.value1().longValue());
    assertEquals(1L, actualMkLogicalFlowDecoratorRecordResult.value3().longValue());
    Timestamp component6Result = actualMkLogicalFlowDecoratorRecordResult.component6();
    assertSame(component6Result, actualMkLogicalFlowDecoratorRecordResult.getLastUpdatedAt());
    assertSame(component6Result, actualMkLogicalFlowDecoratorRecordResult.value6());
  }

  /**
   * Test {@link WaltzUtilities#mkLogicalFlowRecord(long, long, String)}.
   * <p>
   * Method under test: {@link WaltzUtilities#mkLogicalFlowRecord(long, long, String)}
   */
  @Test
  @DisplayName("Test mkLogicalFlowRecord(long, long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlowRecord WaltzUtilities.mkLogicalFlowRecord(long, long, String)"})
  void testMkLogicalFlowRecord() {
    // Arrange and Act
    LogicalFlowRecord actualMkLogicalFlowRecordResult = WaltzUtilities.mkLogicalFlowRecord(1L, 1L, "Provenance");

    // Assert
    assertTrue(actualMkLogicalFlowRecordResult.getTable() instanceof LogicalFlow);
    assertEquals("ACTIVE", actualMkLogicalFlowRecordResult.component11());
    assertEquals("ACTIVE", actualMkLogicalFlowRecordResult.getEntityLifecycleStatus());
    assertEquals("ACTIVE", actualMkLogicalFlowRecordResult.value11());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.component1());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.component3());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.getSourceEntityKind());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.getTargetEntityKind());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.value1());
    assertEquals("APPLICATION", actualMkLogicalFlowRecordResult.value3());
    assertEquals("Provenance", actualMkLogicalFlowRecordResult.component5());
    assertEquals("Provenance", actualMkLogicalFlowRecordResult.getProvenance());
    assertEquals("Provenance", actualMkLogicalFlowRecordResult.value5());
    assertEquals("admin", actualMkLogicalFlowRecordResult.component14());
    assertEquals("admin", actualMkLogicalFlowRecordResult.component8());
    assertEquals("admin", actualMkLogicalFlowRecordResult.getCreatedBy());
    assertEquals("admin", actualMkLogicalFlowRecordResult.getLastUpdatedBy());
    assertEquals("admin", actualMkLogicalFlowRecordResult.value14());
    assertEquals("admin", actualMkLogicalFlowRecordResult.value8());
    assertNull(actualMkLogicalFlowRecordResult.component15());
    assertNull(actualMkLogicalFlowRecordResult.getIsReadonly());
    assertNull(actualMkLogicalFlowRecordResult.value15());
    assertNull(actualMkLogicalFlowRecordResult.component6());
    assertNull(actualMkLogicalFlowRecordResult.getId());
    assertNull(actualMkLogicalFlowRecordResult.value6());
    assertNull(actualMkLogicalFlowRecordResult.component10());
    assertNull(actualMkLogicalFlowRecordResult.component16());
    assertNull(actualMkLogicalFlowRecordResult.getExternalId());
    assertNull(actualMkLogicalFlowRecordResult.getLastAttestedBy());
    assertNull(actualMkLogicalFlowRecordResult.value10());
    assertNull(actualMkLogicalFlowRecordResult.value16());
    assertNull(actualMkLogicalFlowRecordResult.component9());
    assertNull(actualMkLogicalFlowRecordResult.getLastAttestedAt());
    assertNull(actualMkLogicalFlowRecordResult.value9());
    assertEquals(1L, actualMkLogicalFlowRecordResult.component2().longValue());
    assertEquals(1L, actualMkLogicalFlowRecordResult.component4().longValue());
    assertEquals(1L, actualMkLogicalFlowRecordResult.getSourceEntityId().longValue());
    assertEquals(1L, actualMkLogicalFlowRecordResult.getTargetEntityId().longValue());
    assertEquals(1L, actualMkLogicalFlowRecordResult.value2().longValue());
    assertEquals(1L, actualMkLogicalFlowRecordResult.value4().longValue());
    assertFalse(actualMkLogicalFlowRecordResult.component12());
    assertFalse(actualMkLogicalFlowRecordResult.getIsRemoved());
    assertFalse(actualMkLogicalFlowRecordResult.value12());
    Timestamp component13Result = actualMkLogicalFlowRecordResult.component13();
    assertSame(component13Result, actualMkLogicalFlowRecordResult.getCreatedAt());
    assertSame(component13Result, actualMkLogicalFlowRecordResult.value13());
    Timestamp component7Result = actualMkLogicalFlowRecordResult.component7();
    assertSame(component7Result, actualMkLogicalFlowRecordResult.getLastUpdatedAt());
    assertSame(component7Result, actualMkLogicalFlowRecordResult.value7());
  }

  /**
   * Test {@link WaltzUtilities#getOrCreateCostKind(DSLContext, String, String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#getOrCreateCostKind(DSLContext, String, String)}
   */
  @Test
  @DisplayName("Test getOrCreateCostKind(DSLContext, String, String); given ResultSet getLong(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WaltzUtilities.getOrCreateCostKind(DSLContext, String, String)"})
  void testGetOrCreateCostKind_givenResultSetGetLongReturnOne_thenReturnOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    long actualOrCreateCostKind = WaltzUtilities
        .getOrCreateCostKind(new DefaultDSLContext(connection, SQLDialect.SQL99), "Name", "42");

    // Assert
    verify(connection)
        .prepareStatement(eq("select \"cost_kind\".\"id\" from \"cost_kind\" where \"cost_kind\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualOrCreateCostKind);
  }

  /**
   * Test {@link WaltzUtilities#getOrCreateCostKind(DSLContext, String, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link Connection#prepareStatement(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WaltzUtilities#getOrCreateCostKind(DSLContext, String, String)}
   */
  @Test
  @DisplayName("Test getOrCreateCostKind(DSLContext, String, String); given 'true'; then calls prepareStatement(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WaltzUtilities.getOrCreateCostKind(DSLContext, String, String)"})
  void testGetOrCreateCostKind_givenTrue_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    ResultSet resultSet2 = mock(ResultSet.class);
    when(resultSet2.getLong(anyInt())).thenReturn(1L);
    when(resultSet2.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet2).close();
    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.executeUpdate()).thenReturn(1);
    when(preparedStatement2.getGeneratedKeys()).thenReturn(resultSet2);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement2);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualOrCreateCostKind = WaltzUtilities
        .getOrCreateCostKind(new DefaultDSLContext(connection, SQLDialect.SQL99), "Name", "42");

    // Assert
    verify(connection)
        .prepareStatement(eq("select \"cost_kind\".\"id\" from \"cost_kind\" where \"cost_kind\".\"external_id\" = ?"));
    verify(connection).prepareStatement(
        eq("insert into \"cost_kind\" (\"name\", \"description\", \"external_id\") values (?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).execute();
    verify(preparedStatement2).executeUpdate();
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet2).close();
    verify(resultSet).close();
    verify(resultSet2, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(resultSet2, atLeast(1)).next();
    verify(preparedStatement2).close();
    verify(preparedStatement).close();
    verify(preparedStatement2).getGeneratedKeys();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement2).getWarnings();
    verify(preparedStatement).getWarnings();
    assertEquals(1L, actualOrCreateCostKind);
  }
}
