package org.finos.waltz.data.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.user_agent_info.ImmutableUserAgentInfo;
import org.finos.waltz.model.user_agent_info.UserAgentInfo;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.TableRecord;
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
class UserAgentInfoDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private UserAgentInfoDao userAgentInfoDao;

  /**
   * Test {@link UserAgentInfoDao#save(UserAgentInfo)}.
   *
   * <p>Method under test: {@link UserAgentInfoDao#save(UserAgentInfo)}
   */
  @Test
  @DisplayName("Test save(UserAgentInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserAgentInfoDao.save(UserAgentInfo)"})
  void testSave() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

    // Act
    int actualSaveResult =
        userAgentInfoDao.save(
            ImmutableUserAgentInfo.builder()
                .ipAddress("42 Main St")
                .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
                .operatingSystem("Operating System")
                .resolution("Resolution")
                .userAgent("User Agent")
                .userName("janedoe")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link UserAgentInfoDao#save(UserAgentInfo)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserAgentInfoDao#save(UserAgentInfo)}
   */
  @Test
  @DisplayName(
      "Test save(UserAgentInfo); given DSLContext executeInsert(TableRecord) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserAgentInfoDao.save(UserAgentInfo)"})
  void testSave_givenDSLContextExecuteInsertReturnOne_thenReturnOne() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);

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
    verify(userAgentInfo).userName();
    verify(userAgentInfo).ipAddress();
    verify(userAgentInfo).loginTimestamp();
    verify(userAgentInfo).operatingSystem();
    verify(userAgentInfo).resolution();
    verify(userAgentInfo).userAgent();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link UserAgentInfoDao#save(UserAgentInfo)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserAgentInfoDao#save(UserAgentInfo)}
   */
  @Test
  @DisplayName(
      "Test save(UserAgentInfo); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserAgentInfoDao.save(UserAgentInfo)"})
  void testSave_givenPreparedStatementExecuteReturnTrue_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    UserAgentInfoDao userAgentInfoDao = new UserAgentInfoDao(dsl);

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
    verify(connection)
        .prepareStatement(
            "insert into \"user_agent_info\" (\"user_name\", \"user_agent\", \"resolution\", \"operating_system\", \"ip_address\", \"login_timestamp\") values (?, ?, ?, ?, ?, ?)");
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
   * Test {@link UserAgentInfoDao#findLoginsForUser(String, int)}.
   *
   * <p>Method under test: {@link UserAgentInfoDao#findLoginsForUser(String, int)}
   */
  @Test
  @DisplayName("Test findLoginsForUser(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserAgentInfoDao.findLoginsForUser(String, int)"})
  void testFindLoginsForUser() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<UserAgentInfo> actualFindLoginsForUserResult =
        userAgentInfoDao.findLoginsForUser("janedoe", 1);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(1);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindLoginsForUserResult.isEmpty());
  }
}
