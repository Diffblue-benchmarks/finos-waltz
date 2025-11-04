package org.finos.waltz.data.measurable_rating;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true,
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, false,
        "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable_rating\" set \"measurable_rating\".\"is_primary\" = ? where (\"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"measurable_id\" in (select \"m_misf\".\"id\" from \"measurable\" \"m_misf\" where \"m_misf\".\"measurable_category_id\" = (select \"m_misf\".\"measurable_category_id\" from \"measurable\" \"m_misf\" where \"m_misf\".\"id\" = ?)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true,
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true,
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true,
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult = MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true,
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult = MeasurableRatingUtilities.saveRatingDescription(tx, entityRef, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable_rating\" set \"measurable_rating\".\"description\" = ?, \"measurable_rating\".\"last_updated_by\" = ?, \"measurable_rating\".\"last_updated_at\" = ? where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult = MeasurableRatingUtilities.saveRatingDescription(tx, entityRef, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable_rating\" set \"measurable_rating\".\"description\" = cast(? as varchar(43)), \"measurable_rating\".\"last_updated_by\" = cast(? as varchar(7)), \"measurable_rating\".\"last_updated_at\" = cast(? as timestamp) where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar(3)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult = MeasurableRatingUtilities.saveRatingDescription(tx, entityRef, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable_rating\" set \"description\" = ?, \"last_updated_by\" = ?, \"last_updated_at\" = cast(? as timestamp) where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult = MeasurableRatingUtilities.saveRatingDescription(tx, entityRef, 1L,
        "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update measurable_rating set description = ?, last_updated_by = ?, last_updated_at = ? where (measurable_rating.measurable_id = ? and measurable_rating.entity_id = ? and measurable_rating.entity_kind = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
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
    doNothing().when(preparedStatement2).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement2).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement2);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code",
        "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))"));
    verify(connection).prepareStatement(eq(
        "insert into \"measurable_rating\" (\"entity_id\", \"entity_kind\", \"measurable_id\", \"rating\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).execute();
    verify(preparedStatement2).executeUpdate();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement2, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement2).setNull(eq(5), eq(12));
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setString(eq(4), eq("ALL"));
    verify(preparedStatement2).setTimestamp(eq(6), isA(Timestamp.class));
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
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code",
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code",
        "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingItem4() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    ResultSet resultSet2 = mock(ResultSet.class);
    when(resultSet2.getLong(anyInt())).thenReturn(1L);
    when(resultSet2.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet2).close();
    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.executeUpdate()).thenReturn(1);
    when(preparedStatement2.getGeneratedKeys()).thenReturn(resultSet2);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement2).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement2).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement2);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult = MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code",
        "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))"));
    verify(connection).prepareStatement(eq(
        "insert into \"measurable_rating\" (\"entity_id\", \"entity_kind\", \"measurable_id\", \"rating\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\") values (?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).execute();
    verify(preparedStatement2).executeUpdate();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement2, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement2).setNull(eq(5), eq(12));
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setString(eq(4), eq("ALL"));
    verify(preparedStatement2).setTimestamp(eq(6), isA(Timestamp.class));
    verify(resultSet2).close();
    verify(resultSet).close();
    verify(resultSet2).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(resultSet2, atLeast(1)).next();
    verify(preparedStatement2).close();
    verify(preparedStatement).close();
    verify(preparedStatement2).getGeneratedKeys();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement2).getWarnings();
    verify(preparedStatement).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertTrue(actualSaveRatingItemResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}
   */
  @Test
  void testDoesRatingExist() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult = MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertFalse(actualDoesRatingExistResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}
   */
  @Test
  void testDoesRatingExist2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult = MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}
   */
  @Test
  void testDoesRatingExist3() throws SQLException {
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult = MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("ALL"));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }
}
