package org.finos.waltz.data.physical_specification_definition;

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
import java.util.Optional;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionType;
import org.finos.waltz.schema.tables.records.PhysicalSpecDefnRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
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
class PhysicalSpecDefinitionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecDefinitionDao physicalSpecDefinitionDao;

  /**
   * Test {@link PhysicalSpecDefinitionDao#getById(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalSpecDefinition PhysicalSpecDefinitionDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    PhysicalSpecDefinition actualById = new PhysicalSpecDefinitionDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutablePhysicalSpecDefinition);
    assertEquals("1.0.2", actualById.version());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualById.createdBy());
    assertEquals("Provenance", actualById.provenance());
    assertEquals(1L, actualById.specificationId());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualById.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualById.type());
    assertSame(ofResult, actualById.createdAt().toLocalDate());
    assertSame(ofResult2, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#findForSpecification(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#findForSpecification(long)}
   */
  @Test
  @DisplayName("Test findForSpecification(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDefinitionDao.findForSpecification(long)"})
  void testFindForSpecification() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<PhysicalSpecDefinition> actualFindForSpecificationResult =
        new PhysicalSpecDefinitionDao(dsl).findForSpecification(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}.
   *
   * <ul>
   *   <li>Given {@code 2020-03-01}.
   *   <li>Then calls {@link PhysicalSpecDefinition#createdAt()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName("Test create(PhysicalSpecDefinition); given '2020-03-01'; then calls createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionDao.create(PhysicalSpecDefinition)"})
  void testCreate_given20200301_thenCallsCreatedAt() throws DataAccessException {
    // Arrange
    PhysicalSpecDefnRecord physicalSpecDefnRecord = mock(PhysicalSpecDefnRecord.class);
    when(physicalSpecDefnRecord.getId()).thenReturn(1L);

    InsertResultStep<PhysicalSpecDefnRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnRecord);

    InsertSetMoreStep<PhysicalSpecDefnRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(insertSetStep);

    PhysicalSpecDefinition specDefinition = mock(PhysicalSpecDefinition.class);
    when(specDefinition.lastUpdatedBy()).thenReturn("2020-03-01");
    when(specDefinition.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(specDefinition.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(specDefinition.provenance()).thenReturn("Provenance");
    when(specDefinition.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<String> ofResult = Optional.of("42");
    when(specDefinition.delimiter()).thenReturn(ofResult);
    when(specDefinition.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(specDefinition.version()).thenReturn("1.0.2");
    when(specDefinition.specificationId()).thenReturn(1L);
    when(specDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    long actualCreateResult = physicalSpecDefinitionDao.create(specDefinition);

    // Assert
    verify(specDefinition).createdAt();
    verify(specDefinition).createdBy();
    verify(specDefinition).lastUpdatedAt();
    verify(specDefinition).lastUpdatedBy();
    verify(specDefinition).provenance();
    verify(specDefinition).delimiter();
    verify(specDefinition).specificationId();
    verify(specDefinition).status();
    verify(specDefinition).type();
    verify(specDefinition).version();
    verify(physicalSpecDefnRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao#PhysicalSpecDefinitionDao(DSLContext)} with dsl is
   *       {@link DSLContext}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinition); given PhysicalSpecDefinitionDao(DSLContext) with dsl is DSLContext; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionDao.create(PhysicalSpecDefinition)"})
  void testCreate_givenPhysicalSpecDefinitionDaoWithDslIsDSLContext_thenReturnOne()
      throws DataAccessException {
    // Arrange
    PhysicalSpecDefnRecord physicalSpecDefnRecord = mock(PhysicalSpecDefnRecord.class);
    when(physicalSpecDefnRecord.getId()).thenReturn(1L);

    InsertResultStep<PhysicalSpecDefnRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnRecord);

    InsertSetMoreStep<PhysicalSpecDefnRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalSpecDefnRecord>>any())).thenReturn(insertSetStep);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = new PhysicalSpecDefinitionDao(dsl);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionDao.create(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Assert
    verify(physicalSpecDefnRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#delete(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionDao.delete(long)"})
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteResult = new PhysicalSpecDefinitionDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_defn\" where \"physical_spec_defn\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#updateStatus(long, ReleaseLifecycleStatus, String)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#updateStatus(long,
   * ReleaseLifecycleStatus, String)}
   */
  @Test
  @DisplayName("Test updateStatus(long, ReleaseLifecycleStatus, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionDao.updateStatus(long, ReleaseLifecycleStatus, String)"
  })
  void testUpdateStatus() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateStatusResult =
        new PhysicalSpecDefinitionDao(dsl)
            .updateStatus(1L, ReleaseLifecycleStatus.DRAFT, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_spec_defn\" set \"physical_spec_defn\".\"status\" = ?, \"physical_spec_defn\".\"last_updated_at\" = ?, \"physical_spec_defn\".\"last_updated_by\" = ? where (\"physical_spec_defn\".\"id\" = ? and \"physical_spec_defn\".\"status\" <> ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#markExistingActiveAsDeprecated(long, String)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#markExistingActiveAsDeprecated(long,
   * String)}
   */
  @Test
  @DisplayName("Test markExistingActiveAsDeprecated(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionDao.markExistingActiveAsDeprecated(long, String)"})
  void testMarkExistingActiveAsDeprecated() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualMarkExistingActiveAsDeprecatedResult =
        new PhysicalSpecDefinitionDao(dsl).markExistingActiveAsDeprecated(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_spec_defn\" set \"physical_spec_defn\".\"status\" = ?, \"physical_spec_defn\".\"last_updated_at\" = ?, \"physical_spec_defn\".\"last_updated_by\" = ? where (\"physical_spec_defn\".\"specification_id\" = ? and \"physical_spec_defn\".\"status\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkExistingActiveAsDeprecatedResult);
  }
}
