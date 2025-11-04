package org.finos.waltz.service.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.Condition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityHierarchyServiceDiffblueTest {
  /**
   * Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  void testTallyByKind() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PersonHierarchyService personHierarchyService = new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Tally<String>> actualTallyByKindResult = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .tallyByKind();

    // Assert
    verify(connection).prepareStatement(eq("select count(*) from \"person_hierarchy\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).tallyByKind();
    assertEquals(1, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(0.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  void testTallyByKind2() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PersonHierarchyService personHierarchyService = new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Tally<String>> actualTallyByKindResult = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .tallyByKind();

    // Assert
    verify(connection).prepareStatement(eq("select count(*) from \"person_hierarchy\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).tallyByKind();
    assertEquals(1, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(3.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  void testTallyByKind3() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());
    PersonHierarchyService personHierarchyService = mock(PersonHierarchyService.class);
    when(personHierarchyService.count()).thenReturn(3);

    // Act
    List<Tally<String>> actualTallyByKindResult = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .tallyByKind();

    // Assert
    verify(entityHierarchyDao).tallyByKind();
    verify(personHierarchyService).count();
    assertEquals(1, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(3.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  void testGetRootTallies() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PersonHierarchyService personHierarchyService = new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Tally<String>> actualRootTallies = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .getRootTallies();

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).getRootTallies();
    assertEquals(1, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(1.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  void testGetRootTallies2() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    PersonHierarchyService personHierarchyService = new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Tally<String>> actualRootTallies = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .getRootTallies();

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).getRootTallies();
    assertEquals(1, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(3.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  void testGetRootTallies3() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());
    PersonHierarchyService personHierarchyService = mock(PersonHierarchyService.class);
    when(personHierarchyService.countRoots()).thenReturn(10.0d);

    // Act
    List<Tally<String>> actualRootTallies = (new EntityHierarchyService(new DefaultDSLContext(SQLDialect.SQL99),
        mock(ChangeInitiativeDao.class), mock(DataTypeDao.class), entityHierarchyDao, mock(EntityStatisticDao.class),
        mock(MeasurableDao.class), mock(OrganisationalUnitDao.class), personHierarchyService, mock(PersonDao.class)))
            .getRootTallies();

    // Assert
    verify(entityHierarchyDao).getRootTallies();
    verify(personHierarchyService).countRoots();
    assertEquals(1, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  void testGetRoots() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao, organisationalUnitDao,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
                .getRoots(EntityKind.ALL));
  }

  /**
   * Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  void testBuildFor() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao, organisationalUnitDao,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
                .buildFor(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  void testFetchHierarchyForKind() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult = (new EntityHierarchyService(dsl, changeInitiativeDao,
        dataTypeDao, entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
            .fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(eq(EntityKind.ALL));
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertTrue(actualFetchHierarchyForKindResult.hierarchyItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  void testFetchHierarchyForKind2() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(mock(EntityHierarchyItem.class));
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult = (new EntityHierarchyService(dsl, changeInitiativeDao,
        dataTypeDao, entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
            .fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(eq(EntityKind.ALL));
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertEquals(1, actualFetchHierarchyForKindResult.hierarchyItems().size());
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  void testFetchHierarchyForKind3() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(mock(EntityHierarchyItem.class));
    entityHierarchyItemList.add(mock(EntityHierarchyItem.class));
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any())).thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult = (new EntityHierarchyService(dsl, changeInitiativeDao,
        dataTypeDao, entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
            .fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(eq(EntityKind.ALL));
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertEquals(entityHierarchyItemList, actualFetchHierarchyForKindResult.hierarchyItems());
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  void testFetchHierarchyForKind4() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao, organisationalUnitDao,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
                .fetchHierarchyForKind(EntityKind.ALL));
    verify(entityHierarchyDao).fetchHierarchyForKind(eq(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  void testBuildForMeasurableByCategory() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.replaceHierarchy(Mockito.<EntityKind>any(), Mockito.<List<EntityHierarchyItem>>any(),
        Mockito.<Condition>any())).thenReturn(1);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    int actualBuildForMeasurableByCategoryResult = (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
            .buildForMeasurableByCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).replaceHierarchy(eq(EntityKind.MEASURABLE), isA(List.class), isA(Condition.class));
    assertEquals(1, actualBuildForMeasurableByCategoryResult);
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  void testBuildForMeasurableByCategory2() throws SQLException {
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.replaceHierarchy(Mockito.<EntityKind>any(), Mockito.<List<EntityHierarchyItem>>any(),
        Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("id"));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao, organisationalUnitDao,
            new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
                .buildForMeasurableByCategory(1L));
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).replaceHierarchy(eq(EntityKind.MEASURABLE), isA(List.class), isA(Condition.class));
  }

  /**
   * Method under test:
   * {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  void testBuildForMeasurableByCategory3() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.replaceHierarchy(Mockito.<EntityKind>any(), Mockito.<List<EntityHierarchyItem>>any(),
        Mockito.<Condition>any())).thenReturn(1);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);

    // Act
    int actualBuildForMeasurableByCategoryResult = (new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao,
        entityHierarchyDao, entityStatisticDao, measurableDao, organisationalUnitDao,
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class)))
            .buildForMeasurableByCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).replaceHierarchy(eq(EntityKind.MEASURABLE), isA(List.class), isA(Condition.class));
    assertEquals(1, actualBuildForMeasurableByCategoryResult);
  }
}
