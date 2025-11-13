package org.finos.waltz.service.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchyItem;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
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
class EntityHierarchyServiceDiffblueTest {
  @Mock private ChangeInitiativeDao changeInitiativeDao;

  @Mock private DSLContext dSLContext;

  @Mock private DataTypeDao dataTypeDao;

  @Mock private EntityHierarchyDao entityHierarchyDao;

  @InjectMocks private EntityHierarchyService entityHierarchyService;

  @Mock private EntityStatisticDao entityStatisticDao;

  @Mock private MeasurableDao measurableDao;

  @Mock private OrganisationalUnitDao organisationalUnitDao;

  @Mock private PersonDao personDao;

  @Mock private PersonHierarchyService personHierarchyService;

  /**
   * Test {@link EntityHierarchyService#tallyByKind()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  @DisplayName("Test tallyByKind(); given DSLContext; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.tallyByKind()"})
  void testTallyByKind_givenDSLContext_thenThrowIllegalArgumentException() {
    // Arrange
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());
    when(personHierarchyService.count()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyService.tallyByKind());
    verify(entityHierarchyDao).tallyByKind();
    verify(personHierarchyService).count();
  }

  /**
   * Test {@link EntityHierarchyService#tallyByKind()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#fetchCount(Table)} return three.
   *   <li>Then calls {@link DefaultDSLContext#fetchCount(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  @DisplayName(
      "Test tallyByKind(); given DefaultDSLContext fetchCount(Table) return three; then calls fetchCount(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.tallyByKind()"})
  void testTallyByKind_givenDefaultDSLContextFetchCountReturnThree_thenCallsFetchCount() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchCount(Mockito.<Table<?>>any())).thenReturn(3);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualTallyByKindResult = entityHierarchyService.tallyByKind();

    // Assert
    verify(entityHierarchyDao).tallyByKind();
    verify(dsl).fetchCount(isA(Table.class));
    assertEquals(1, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(3.0d, getResult.count());
  }

  /**
   * Test {@link EntityHierarchyService#tallyByKind()}.
   *
   * <ul>
   *   <li>Given {@link EntityHierarchyDao} {@link EntityHierarchyDao#tallyByKind()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  @DisplayName(
      "Test tallyByKind(); given EntityHierarchyDao tallyByKind() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.tallyByKind()"})
  void testTallyByKind_givenEntityHierarchyDaoTallyByKindThrowIllegalArgumentException() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyService.tallyByKind());
    verify(entityHierarchyDao).tallyByKind();
  }

  /**
   * Test {@link EntityHierarchyService#tallyByKind()}.
   *
   * <ul>
   *   <li>Given {@link PersonHierarchyService} {@link PersonHierarchyService#count()} return three.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  @DisplayName("Test tallyByKind(); given PersonHierarchyService count() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.tallyByKind()"})
  void testTallyByKind_givenPersonHierarchyServiceCountReturnThree() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());

    PersonHierarchyService personHierarchyService = mock(PersonHierarchyService.class);
    when(personHierarchyService.count()).thenReturn(3);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualTallyByKindResult = entityHierarchyService.tallyByKind();

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
   * Test {@link EntityHierarchyService#tallyByKind()}.
   *
   * <ul>
   *   <li>Then return first count is minus one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#tallyByKind()}
   */
  @Test
  @DisplayName("Test tallyByKind(); then return first count is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.tallyByKind()"})
  void testTallyByKind_thenReturnFirstCountIsMinusOne() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.tallyByKind()).thenReturn(new ArrayList<>());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualTallyByKindResult = entityHierarchyService.tallyByKind();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).tallyByKind();
    assertEquals(1, actualTallyByKindResult.size());
    Tally<String> getResult = actualTallyByKindResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(-1.0d, getResult.count());
  }

  /**
   * Test {@link EntityHierarchyService#getRootTallies()}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  @DisplayName("Test getRootTallies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRootTallies()"})
  void testGetRootTallies() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyService.getRootTallies());
    verify(entityHierarchyDao).getRootTallies();
  }

  /**
   * Test {@link EntityHierarchyService#getRootTallies()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  @DisplayName("Test getRootTallies(); given DSLContext; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRootTallies()"})
  void testGetRootTallies_givenDSLContext_thenThrowIllegalArgumentException() {
    // Arrange
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());
    when(personHierarchyService.countRoots()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityHierarchyService.getRootTallies());
    verify(entityHierarchyDao).getRootTallies();
    verify(personHierarchyService).countRoots();
  }

  /**
   * Test {@link EntityHierarchyService#getRootTallies()}.
   *
   * <ul>
   *   <li>Then return first count is minus one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  @DisplayName("Test getRootTallies(); then return first count is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRootTallies()"})
  void testGetRootTallies_thenReturnFirstCountIsMinusOne() throws SQLException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualRootTallies = entityHierarchyService.getRootTallies();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(entityHierarchyDao).getRootTallies();
    assertEquals(1, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(-1.0d, getResult.count());
  }

  /**
   * Test {@link EntityHierarchyService#getRootTallies()}.
   *
   * <ul>
   *   <li>Then return first count is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  @DisplayName("Test getRootTallies(); then return first count is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRootTallies()"})
  void testGetRootTallies_thenReturnFirstCountIsTen() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());

    PersonHierarchyService personHierarchyService = mock(PersonHierarchyService.class);
    when(personHierarchyService.countRoots()).thenReturn(10.0d);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualRootTallies = entityHierarchyService.getRootTallies();

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
   * Test {@link EntityHierarchyService#getRootTallies()}.
   *
   * <ul>
   *   <li>Then return first count is three.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRootTallies()}
   */
  @Test
  @DisplayName("Test getRootTallies(); then return first count is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRootTallies()"})
  void testGetRootTallies_thenReturnFirstCountIsThree() throws DataAccessException {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.getRootTallies()).thenReturn(new ArrayList<>());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(ChangeInitiativeDao.class),
            mock(DataTypeDao.class),
            entityHierarchyDao,
            mock(EntityStatisticDao.class),
            mock(MeasurableDao.class),
            mock(OrganisationalUnitDao.class),
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<Tally<String>> actualRootTallies = entityHierarchyService.getRootTallies();

    // Assert
    verify(entityHierarchyDao).getRootTallies();
    verify(dsl).fetchCount(isA(Select.class));
    assertEquals(1, actualRootTallies.size());
    Tally<String> getResult = actualRootTallies.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    assertEquals("PERSON", getResult.id());
    assertEquals(3.0d, getResult.count());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findByIdSelectorAsEntityReference(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<EntityReference> actualRoots =
        entityHierarchyService.getRoots(EntityKind.CHANGE_INITIATIVE);

    // Assert
    verify(changeInitiativeDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findByIdSelectorAsEntityReference(
            Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.getRoots(EntityKind.CHANGE_INITIATIVE));
    verify(changeInitiativeDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots3() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.getRoots(EntityKind.DATA_TYPE));
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots4() {
    // Arrange
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    when(entityStatisticDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<EntityReference> actualRoots =
        entityHierarchyService.getRoots(EntityKind.ENTITY_STATISTIC);

    // Assert
    verify(entityStatisticDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots5() {
    // Arrange
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    when(entityStatisticDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.getRoots(EntityKind.ENTITY_STATISTIC));
    verify(entityStatisticDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots6() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.getRoots(EntityKind.MEASURABLE));
    verify(measurableDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots7() {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.findByIdSelectorAsEntityReference(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<EntityReference> actualRoots = entityHierarchyService.getRoots(EntityKind.ORG_UNIT);

    // Assert
    verify(organisationalUnitDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots8() {
    // Arrange
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.findByIdSelectorAsEntityReference(
            Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityHierarchyService.getRoots(EntityKind.ORG_UNIT));
    verify(organisationalUnitDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots9() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByPersonIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            personDao);

    // Act
    List<EntityReference> actualRoots = entityHierarchyService.getRoots(EntityKind.PERSON);

    // Assert
    verify(personDao).findByPersonIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots10() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByPersonIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            personDao);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityHierarchyService.getRoots(EntityKind.PERSON));
    verify(personDao).findByPersonIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao} {@link DataTypeDao#findByIdSelectorAsEntityReference(Select)}
   *       return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRoots(EntityKind); given DataTypeDao findByIdSelectorAsEntityReference(Select) return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots_givenDataTypeDaoFindByIdSelectorAsEntityReferenceReturnArrayList() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<EntityReference> actualRoots = entityHierarchyService.getRoots(EntityKind.DATA_TYPE);

    // Assert
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link
   *       MeasurableDao#findByIdSelectorAsEntityReference(Select)} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test getRoots(EntityKind); given MeasurableDao findByIdSelectorAsEntityReference(Select) return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots_givenMeasurableDaoFindByIdSelectorAsEntityReferenceReturnArrayList() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    List<EntityReference> actualRoots = entityHierarchyService.getRoots(EntityKind.MEASURABLE);

    // Assert
    verify(measurableDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualRoots.isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#getRoots(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#getRoots(EntityKind)}
   */
  @Test
  @DisplayName("Test getRoots(EntityKind); when 'ALL'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityHierarchyService.getRoots(EntityKind)"})
  void testGetRoots_whenAll_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityHierarchyService.getRoots(EntityKind.ALL));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName("Test buildFor(EntityKind) with 'kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    when(entityHierarchyDao.replaceHierarchy(
            Mockito.<EntityKind>any(),
            Mockito.<List<EntityHierarchyItem>>any(),
            Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE));
    verify(entityHierarchyDao)
        .replaceHierarchy(eq(EntityKind.CHANGE_INITIATIVE), isA(List.class), isA(Condition.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test buildFor(EntityKind) with 'kind'; given DSLContext select(SelectField, SelectField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>When {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test buildFor(EntityKind) with 'kind'; given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_givenDefaultDSLContextWithDialectIsSql99_whenAll() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityHierarchyService.buildFor(EntityKind.ALL));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test buildFor(EntityKind) with 'kind'; given SelectConditionStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_givenSelectConditionStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test buildFor(EntityKind) with 'kind'; given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test buildFor(EntityKind) with 'kind'; given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildFor(EntityKind)} with {@code kind}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildFor(EntityKind)}
   */
  @Test
  @DisplayName("Test buildFor(EntityKind) with 'kind'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildFor(EntityKind)"})
  void testBuildForWithKind_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    when(entityHierarchyDao.replaceHierarchy(
            Mockito.<EntityKind>any(),
            Mockito.<List<EntityHierarchyItem>>any(),
            Mockito.<Condition>any()))
        .thenReturn(1);

    // Act
    int actualBuildForResult = entityHierarchyService.buildFor(EntityKind.CHANGE_INITIATIVE);

    // Assert
    verify(entityHierarchyDao)
        .replaceHierarchy(eq(EntityKind.CHANGE_INITIATIVE), isA(List.class), isA(Condition.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1, actualBuildForResult);
  }

  /**
   * Test {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return hierarchyItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind); then return hierarchyItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityHierarchy EntityHierarchyService.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_thenReturnHierarchyItemsEmpty() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult =
        entityHierarchyService.fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(EntityKind.ALL);
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertTrue(actualFetchHierarchyForKindResult.hierarchyItems().isEmpty());
  }

  /**
   * Test {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return hierarchyItems is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind); then return hierarchyItems is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityHierarchy EntityHierarchyService.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_thenReturnHierarchyItemsIsArrayList() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult =
        entityHierarchyService.fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(EntityKind.ALL);
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertEquals(entityHierarchyItemList, actualFetchHierarchyForKindResult.hierarchyItems());
  }

  /**
   * Test {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return hierarchyItems is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind); then return hierarchyItems is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityHierarchy EntityHierarchyService.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_thenReturnHierarchyItemsIsArrayList2() {
    // Arrange
    ArrayList<EntityHierarchyItem> entityHierarchyItemList = new ArrayList<>();
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    entityHierarchyItemList.add(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenReturn(entityHierarchyItemList);
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    EntityHierarchy actualFetchHierarchyForKindResult =
        entityHierarchyService.fetchHierarchyForKind(EntityKind.ALL);

    // Assert
    verify(entityHierarchyDao).fetchHierarchyForKind(EntityKind.ALL);
    assertTrue(actualFetchHierarchyForKindResult instanceof ImmutableEntityHierarchy);
    assertEquals(entityHierarchyItemList, actualFetchHierarchyForKindResult.hierarchyItems());
  }

  /**
   * Test {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#fetchHierarchyForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test fetchHierarchyForKind(EntityKind); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityHierarchy EntityHierarchyService.fetchHierarchyForKind(EntityKind)"})
  void testFetchHierarchyForKind_thenThrowIllegalArgumentException() {
    // Arrange
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.fetchHierarchyForKind(Mockito.<EntityKind>any()))
        .thenThrow(new IllegalArgumentException());
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.fetchHierarchyForKind(EntityKind.ALL));
    verify(entityHierarchyDao).fetchHierarchyForKind(EntityKind.ALL);
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildForMeasurableByCategory(1L));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory2() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildForMeasurableByCategory(1L));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory3() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildForMeasurableByCategory(1L));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.replaceHierarchy(
            Mockito.<EntityKind>any(),
            Mockito.<List<EntityHierarchyItem>>any(),
            Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildForMeasurableByCategory(1L));
    verify(entityHierarchyDao)
        .replaceHierarchy(eq(EntityKind.MEASURABLE), isA(List.class), isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityHierarchyService.buildForMeasurableByCategory(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityHierarchyService#buildForMeasurableByCategory(long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchyService#buildForMeasurableByCategory(long)}
   */
  @Test
  @DisplayName("Test buildForMeasurableByCategory(long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityHierarchyService.buildForMeasurableByCategory(long)"})
  void testBuildForMeasurableByCategory_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    when(entityHierarchyDao.replaceHierarchy(
            Mockito.<EntityKind>any(),
            Mockito.<List<EntityHierarchyItem>>any(),
            Mockito.<Condition>any()))
        .thenReturn(1);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    EntityHierarchyService entityHierarchyService =
        new EntityHierarchyService(
            dsl,
            changeInitiativeDao,
            dataTypeDao,
            entityHierarchyDao,
            entityStatisticDao,
            measurableDao,
            organisationalUnitDao,
            personHierarchyService,
            mock(PersonDao.class));

    // Act
    int actualBuildForMeasurableByCategoryResult =
        entityHierarchyService.buildForMeasurableByCategory(1L);

    // Assert
    verify(entityHierarchyDao)
        .replaceHierarchy(eq(EntityKind.MEASURABLE), isA(List.class), isA(Condition.class));
    verify(dsl).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1, actualBuildForMeasurableByCategoryResult);
  }
}
