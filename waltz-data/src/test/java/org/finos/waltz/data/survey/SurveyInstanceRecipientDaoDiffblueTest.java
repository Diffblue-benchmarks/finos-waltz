package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.model.survey.SurveyInstanceRecipientCreateCommand;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyInstanceRecipientDaoDiffblueTest {
  /**
   * Test {@link SurveyInstanceRecipientDao#create(SurveyInstanceRecipientCreateCommand)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceRecipientDao#create(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  @DisplayName("Test create(SurveyInstanceRecipientCreateCommand); given ResultSet getLong(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long SurveyInstanceRecipientDao.create(SurveyInstanceRecipientCreateCommand)"})
  void testCreate_givenResultSetGetLongReturnOne_thenReturnOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = new SurveyInstanceRecipientDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    SurveyInstanceRecipientCreateCommand command = mock(SurveyInstanceRecipientCreateCommand.class);
    when(command.personId()).thenReturn(1L);
    when(command.surveyInstanceId()).thenReturn(1L);

    // Act
    long actualCreateResult = surveyInstanceRecipientDao.create(command);

    // Assert
    verify(connection).prepareStatement(
        eq("insert into \"survey_instance_recipient\" (\"survey_instance_id\", \"person_id\") values (?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).personId();
    verify(command).surveyInstanceId();
    assertEquals(1L, actualCreateResult);
  }
}
