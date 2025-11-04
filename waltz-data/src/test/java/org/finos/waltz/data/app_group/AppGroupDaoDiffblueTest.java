package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.schema.tables.records.ApplicationGroupRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupDaoDiffblueTest {
  /**
   * Method under test: {@link AppGroupDao#getGroup(long)}
   */
  @Test
  void testGetGroup() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AppGroup actualGroup = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where \"application_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualGroup);
  }

  /**
   * Method under test: {@link AppGroupDao#findGroupsForUser(String)}
   */
  @Test
  void testFindGroupsForUser() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroup> actualFindGroupsForUserResult = (new AppGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findGroupsForUser("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" where (\"application_group_member\".\"user_id\" = ? and \"application_group\".\"is_removed\" = ?)) and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(false));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindGroupsForUserResult.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupDao#findPrivateGroupsByOwner(String)}
   */
  @Test
  void testFindPrivateGroupsByOwner() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroup> actualFindPrivateGroupsByOwnerResult = (new AppGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPrivateGroupsByOwner("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" join \"application_group\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"role\" = ?)) and \"application_group\".\"kind\" = ? and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(4), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPrivateGroupsByOwnerResult.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupDao#getFavouritesGroupForOwner(String)}
   */
  @Test
  void testGetFavouritesGroupForOwner() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AppGroup actualFavouritesGroupForOwner = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getFavouritesGroupForOwner("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" join \"application_group\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"role\" = ?)) and \"application_group\".\"kind\" = ? and \"application_group\".\"is_removed\" = ? and \"application_group\".\"is_favourite_group\" = true)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(4), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualFavouritesGroupForOwner);
  }

  /**
   * Method under test:
   * {@link AppGroupDao#findRelatedByApplicationId(long, String)}
   */
  @Test
  void testFindRelatedByApplicationId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroup> actualFindRelatedByApplicationIdResult = (new AppGroupDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRelatedByApplicationId(1L, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"id\" in (select \"application_group_entry\".\"group_id\" from \"application_group_entry\" where \"application_group_entry\".\"application_id\" = ? union select \"application_group_ou_entry\".\"group_id\" from \"application_group_ou_entry\" where \"application_group_ou_entry\".\"org_unit_id\" in (select \"entity_hierarchy\".\"ancestor_id\" from \"entity_hierarchy\" join \"organisational_unit\" on \"entity_hierarchy\".\"id\" = \"organisational_unit\".\"id\" join \"application\" on \"application\".\"organisational_unit_id\" = \"organisational_unit\".\"id\" where \"application\".\"id\" = ?)) and (\"application_group\".\"kind\" = ? or \"application_group\".\"id\" in (select \"application_group_member\".\"group_id\" from \"application_group_member\" join \"application_group\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group_member\".\"user_id\" = ? and \"application_group_member\".\"role\" = ?))) and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(6), eq(false));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindRelatedByApplicationIdResult.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupDao#findPublicGroups()}
   */
  @Test
  void testFindPublicGroups() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroup> actualFindPublicGroupsResult = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findPublicGroups();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" where (\"application_group\".\"kind\" = ? and \"application_group\".\"is_favourite_group\" = false and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(2), eq(false));
    verify(preparedStatement).setString(eq(1), eq("PUBLIC"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPublicGroupsResult.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  void testUpdate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"application_group\" set \"application_group\".\"description\" = ?, \"application_group\".\"name\" = ?, \"application_group\".\"kind\" = ?, \"application_group\".\"external_id\" = ? where \"application_group\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Method under test: {@link AppGroupDao#update(AppGroup)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetFirstStep<ApplicationGroupRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<ApplicationGroupRecord>>any())).thenReturn(updateSetFirstStep);
    AppGroupDao appGroupDao = new AppGroupDao(dsl);
    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult2);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    int actualUpdateResult = appGroupDao.update(appGroup);

    // Assert
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).id();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test: {@link AppGroupDao#insert(AppGroup)}
   */
  @Test
  void testInsert() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appGroup.externalId()).thenReturn(ofResult);
    when(appGroup.isRemoved()).thenReturn(true);
    when(appGroup.isFavouriteGroup()).thenReturn(true);
    when(appGroup.description()).thenReturn("The characteristics of someone or something");
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.appGroupKind()).thenReturn(AppGroupKind.PUBLIC);

    // Act
    Long actualInsertResult = appGroupDao.insert(appGroup);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group\" (\"description\", \"name\", \"kind\", \"external_id\", \"is_removed\", \"is_favourite_group\") values (?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(appGroup).description();
    verify(appGroup).externalId();
    verify(appGroup).isRemoved();
    verify(appGroup).name();
    verify(appGroup).appGroupKind();
    verify(appGroup).isFavouriteGroup();
    assertEquals(1L, actualInsertResult.longValue());
  }

  /**
   * Method under test: {@link AppGroupDao#deleteGroup(long)}
   */
  @Test
  void testDeleteGroup() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteGroupResult = (new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"application_group\" set \"application_group\".\"is_removed\" = ? where (\"application_group\".\"id\" = ? and \"application_group\".\"is_favourite_group\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteGroupResult);
  }

  /**
   * Method under test: {@link AppGroupDao#deleteGroup(long)}
   */
  @Test
  void testDeleteGroup2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateConditionStep<ApplicationGroupRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<ApplicationGroupRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);
    UpdateSetFirstStep<ApplicationGroupRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ApplicationGroupRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualDeleteGroupResult = (new AppGroupDao(dsl)).deleteGroup(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualDeleteGroupResult);
  }

  /**
   * Method under test:
   * {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.SQL99));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }

  /**
   * Method under test:
   * {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals2() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(SQLDialect.DEFAULT));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }

  /**
   * Method under test:
   * {@link AppGroupDao#processAdditionsAndRemovals(Set, Set, String)}
   */
  @Test
  void testProcessAdditionsAndRemovals3() {
    // Arrange
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));
    HashSet<Tuple2<Long, EntityReference>> additions = new HashSet<>();

    // Act and Assert
    assertEquals(0, appGroupDao.processAdditionsAndRemovals(additions, new HashSet<>(), "42"));
  }

  /**
   * Method under test: {@link AppGroupDao#findByIds(String, List)}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AppGroupDao appGroupDao = new AppGroupDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<AppGroup> actualFindByIdsResult = appGroupDao.findByIds("User", new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group\".\"id\", \"application_group\".\"name\", \"application_group\".\"kind\", \"application_group\".\"description\", \"application_group\".\"external_id\", \"application_group\".\"is_removed\", \"application_group\".\"is_favourite_group\" from \"application_group\" join \"application_group_member\" on \"application_group_member\".\"group_id\" = \"application_group\".\"id\" where (\"application_group\".\"id\" in () and (\"application_group_member\".\"user_id\" = ? or \"application_group\".\"kind\" = ?) and \"application_group\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(3), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByIdsResult.isEmpty());
  }
}
