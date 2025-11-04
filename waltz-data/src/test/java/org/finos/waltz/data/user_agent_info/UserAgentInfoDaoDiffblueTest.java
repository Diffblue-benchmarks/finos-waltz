package org.finos.waltz.data.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.finos.waltz.model.user_agent_info.ImmutableUserAgentInfo;
import org.finos.waltz.model.user_agent_info.UserAgentInfo;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserAgentInfoDaoDiffblueTest {
  /**
   * Method under test: {@link UserAgentInfoDao#save(UserAgentInfo)}
   */
  @Test
  void testSave() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    UserAgentInfoDao userAgentInfoDao = new UserAgentInfoDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    UserAgentInfo userAgentInfo = mock(UserAgentInfo.class);
    when(userAgentInfo.userName()).thenReturn("janedoe");
    when(userAgentInfo.ipAddress()).thenReturn("42 Main St");
    when(userAgentInfo.operatingSystem()).thenReturn("Operating System");
    when(userAgentInfo.resolution()).thenReturn("Resolution");
    when(userAgentInfo.userAgent()).thenReturn("User Agent");
    when(userAgentInfo.loginTimestamp()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    int actualSaveResult = userAgentInfoDao.save(userAgentInfo);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"user_agent_info\" (\"user_name\", \"user_agent\", \"resolution\", \"operating_system\", \"ip_address\", \"login_timestamp\") values (?, ?, ?, ?, ?, ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(userAgentInfo).userName();
    verify(userAgentInfo).ipAddress();
    verify(userAgentInfo).loginTimestamp();
    verify(userAgentInfo).operatingSystem();
    verify(userAgentInfo).resolution();
    verify(userAgentInfo).userAgent();
    assertEquals(0, actualSaveResult);
  }

  /**
   * Method under test: {@link UserAgentInfoDao#findLoginsForUser(String, int)}
   */
  @Test
  void testFindLoginsForUser() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<UserAgentInfo> actualFindLoginsForUserResult = (new UserAgentInfoDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findLoginsForUser("janedoe", 1);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"uai\".\"id\", \"uai\".\"user_name\", \"uai\".\"user_agent\", \"uai\".\"resolution\", \"uai\".\"operating_system\", \"uai\".\"ip_address\", \"uai\".\"login_timestamp\" from \"user_agent_info\" \"uai\" where \"uai\".\"user_name\" = ? order by \"uai\".\"login_timestamp\" desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("janedoe"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindLoginsForUserResult.size());
    UserAgentInfo getResult = actualFindLoginsForUserResult.get(0);
    assertTrue(getResult instanceof ImmutableUserAgentInfo);
    UserAgentInfo getResult2 = actualFindLoginsForUserResult.get(1);
    assertTrue(getResult2 instanceof ImmutableUserAgentInfo);
    LocalDateTime loginTimestampResult = getResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.userName());
    assertEquals("String", getResult.ipAddress());
    assertEquals("String", getResult.operatingSystem());
    assertEquals("String", getResult.resolution());
    assertEquals("String", getResult.userAgent());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }
}
