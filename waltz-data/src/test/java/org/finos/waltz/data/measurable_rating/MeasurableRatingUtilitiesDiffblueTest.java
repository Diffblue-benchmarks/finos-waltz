package org.finos.waltz.data.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingUtilitiesDiffblueTest {
  /**
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe"));
    verify(ref).id();
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, true, "janedoe");

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
   * Test {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext, EntityReference, long,
   * boolean, String)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingIsPrimary(DSLContext,
   * EntityReference, long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String); when 'false'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingIsPrimary(DSLContext, EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_whenFalse_thenReturnTrue() throws SQLException {
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
    boolean actualSaveRatingIsPrimaryResult =
        MeasurableRatingUtilities.saveRatingIsPrimary(tx, ref, 1L, false, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"is_primary\" = ? where (\"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"measurable_id\" in (select \"m_misf\".\"id\" from \"measurable\" \"m_misf\" where \"m_misf\".\"measurable_category_id\" = (select \"m_misf\".\"measurable_category_id\" from \"measurable\" \"m_misf\" where \"m_misf\".\"id\" = ?)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(3, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName("Test saveRatingDescription(DSLContext, EntityReference, long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult =
        MeasurableRatingUtilities.saveRatingDescription(
            tx, entityRef, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = cast(? as varchar(43)), \"measurable_rating\".\"last_updated_by\" = cast(? as varchar(7)), \"measurable_rating\".\"last_updated_at\" = cast(? as timestamp) where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar(3)))");
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
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName("Test saveRatingDescription(DSLContext, EntityReference, long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult =
        MeasurableRatingUtilities.saveRatingDescription(
            tx, entityRef, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"description\" = ?, \"last_updated_by\" = ?, \"last_updated_at\" = cast(? as timestamp) where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?)");
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
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(DSLContext, EntityReference, long, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            MeasurableRatingUtilities.saveRatingDescription(
                tx, entityRef, 1L, "The characteristics of someone or something", "janedoe"));
    verify(entityRef).id();
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult =
        MeasurableRatingUtilities.saveRatingDescription(
            tx, entityRef, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = cast(? as varchar), \"measurable_rating\".\"last_updated_by\" = cast(? as varchar), \"measurable_rating\".\"last_updated_at\" = cast(? as datetime) where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar))");
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
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_whenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
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
    boolean actualSaveRatingDescriptionResult =
        MeasurableRatingUtilities.saveRatingDescription(
            tx, entityRef, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = ?, \"measurable_rating\".\"last_updated_by\" = ?, \"measurable_rating\".\"last_updated_at\" = ? where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?)");
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
   * Test {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext, EntityReference, long,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingDescription(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingDescription(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_whenDefaultDSLContextWithConnectionAndDialectIsSqlite()
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingDescriptionResult =
        MeasurableRatingUtilities.saveRatingDescription(
            tx, entityRef, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update measurable_rating set description = ?, last_updated_by = ?, last_updated_at = ? where (measurable_rating.measurable_id = ? and measurable_rating.entity_id = ? and measurable_rating.entity_kind = ?)");
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
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); given PreparedStatement getUpdateCount() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_givenPreparedStatementGetUpdateCountReturnOne_thenReturnTrue()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
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
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertTrue(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); given PreparedStatement getUpdateCount() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_givenPreparedStatementGetUpdateCountReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
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
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
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
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); then calls getResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_thenCallsGetResultSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
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
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_thenCallsGetUpdateCount() throws SQLException {
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
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
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe"));
    verify(entityRef).id();
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_whenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
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
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#saveRatingItem(DSLContext, EntityReference, long, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#saveRatingItem(DSLContext,
   * EntityReference, long, String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(DSLContext, EntityReference, long, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.saveRatingItem(DSLContext, EntityReference, long, String, String)"
  })
  void testSaveRatingItem_whenDefaultDSLContextWithConnectionAndDialectIsSqlite()
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualSaveRatingItemResult =
        MeasurableRatingUtilities.saveRatingItem(tx, entityRef, 1L, "Rating Code", "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getUpdateCount();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(entityRef, atLeast(1)).id();
    verify(entityRef, atLeast(1)).kind();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); given PreparedStatement getUpdateCount() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_givenPreparedStatementGetUpdateCountReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 as \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName("Test doesRatingExist(DSLContext, EntityReference, long); then calls getResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_thenCallsGetResultSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
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
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_thenCallsGetUpdateCount() throws SQLException {
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 as \"one\" where exists (select ? from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L));
    verify(entityRef).id();
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select cast(? as int) from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_whenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from RDB$DATABASE where exists (select cast(? as integer) from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar(3))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#doesRatingExist(DSLContext, EntityReference, long)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingUtilities#doesRatingExist(DSLContext,
   * EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test doesRatingExist(DSLContext, EntityReference, long); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingUtilities.doesRatingExist(DSLContext, EntityReference, long)"
  })
  void testDoesRatingExist_whenDefaultDSLContextWithConnectionAndDialectIsSqlite()
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
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);
    when(entityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDoesRatingExistResult =
        MeasurableRatingUtilities.doesRatingExist(tx, entityRef, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 as one where exists (select ? from measurable_rating where (measurable_rating.measurable_id = ? and measurable_rating.entity_id = ? and measurable_rating.entity_kind = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityRef).id();
    verify(entityRef).kind();
    assertTrue(actualDoesRatingExistResult);
  }

  /**
   * Test {@link MeasurableRatingUtilities#resolveLoggingContextForRatingChange(DSLContext,
   * EntityReference, long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingUtilities#resolveLoggingContextForRatingChange(DSLContext, EntityReference,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test resolveLoggingContextForRatingChange(DSLContext, EntityReference, long, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.measurable_rating.MeasurableRatingChangeSummary MeasurableRatingUtilities.resolveLoggingContextForRatingChange(DSLContext, EntityReference, long, String)"
  })
  void testResolveLoggingContextForRatingChange_thenThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            MeasurableRatingUtilities.resolveLoggingContextForRatingChange(
                tx, entityRef, 1L, "Desired Rating Code"));
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(tx).select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }
}
