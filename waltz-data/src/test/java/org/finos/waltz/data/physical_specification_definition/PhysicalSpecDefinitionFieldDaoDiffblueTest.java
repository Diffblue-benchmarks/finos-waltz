package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionField;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionField;
import org.finos.waltz.schema.tables.records.PhysicalSpecDefnFieldRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
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
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
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
class PhysicalSpecDefinitionFieldDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao;

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#findForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#findForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test findForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDefinitionFieldDao.findForSpecDefinition(long)"})
  void testFindForSpecDefinition() throws DataAccessException {
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
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult =
        new PhysicalSpecDefinitionFieldDao(dsl).findForSpecDefinition(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSpecDefinitionResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}.
   *
   * <ul>
   *   <li>Given {@code 2020-03-01}.
   *   <li>Then calls {@link PhysicalSpecDefinitionField#description()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinitionField); given '2020-03-01'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionFieldDao.create(PhysicalSpecDefinitionField)"})
  void testCreate_given20200301_thenCallsDescription() throws DataAccessException {
    // Arrange
    PhysicalSpecDefnFieldRecord physicalSpecDefnFieldRecord =
        mock(PhysicalSpecDefnFieldRecord.class);
    when(physicalSpecDefnFieldRecord.getId()).thenReturn(1L);

    InsertResultStep<PhysicalSpecDefnFieldRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnFieldRecord);

    InsertSetMoreStep<PhysicalSpecDefnFieldRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnFieldRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(insertSetStep);

    PhysicalSpecDefinitionField definitionField = mock(PhysicalSpecDefinitionField.class);
    when(definitionField.lastUpdatedBy()).thenReturn("2020-03-01");
    when(definitionField.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.of(42L);
    when(definitionField.logicalDataElementId()).thenReturn(ofResult);
    when(definitionField.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(definitionField.position()).thenReturn(1);
    when(definitionField.name()).thenReturn("Name");
    when(definitionField.specDefinitionId()).thenReturn(1L);
    when(definitionField.type()).thenReturn(FieldDataType.DATE);

    // Act
    long actualCreateResult = physicalSpecDefinitionFieldDao.create(definitionField);

    // Assert
    verify(definitionField).description();
    verify(definitionField).lastUpdatedAt();
    verify(definitionField).lastUpdatedBy();
    verify(definitionField).name();
    verify(definitionField).logicalDataElementId();
    verify(definitionField).position();
    verify(definitionField).specDefinitionId();
    verify(definitionField).type();
    verify(physicalSpecDefnFieldRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionFieldDao#PhysicalSpecDefinitionFieldDao(DSLContext)}
   *       with dsl is {@link DSLContext}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinitionField); given PhysicalSpecDefinitionFieldDao(DSLContext) with dsl is DSLContext; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionFieldDao.create(PhysicalSpecDefinitionField)"})
  void testCreate_givenPhysicalSpecDefinitionFieldDaoWithDslIsDSLContext_thenReturnOne()
      throws DataAccessException {
    // Arrange
    PhysicalSpecDefnFieldRecord physicalSpecDefnFieldRecord =
        mock(PhysicalSpecDefnFieldRecord.class);
    when(physicalSpecDefnFieldRecord.getId()).thenReturn(1L);

    InsertResultStep<PhysicalSpecDefnFieldRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnFieldRecord);

    InsertSetMoreStep<PhysicalSpecDefnFieldRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnFieldRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(insertSetStep);
    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao =
        new PhysicalSpecDefinitionFieldDao(dsl);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionFieldDao.create(
            ImmutablePhysicalSpecDefinitionField.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .specDefinitionId(1L)
                .type(FieldDataType.DATE)
                .build());

    // Assert
    verify(physicalSpecDefnFieldRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#delete(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.delete(long)"})
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
    int actualDeleteResult = new PhysicalSpecDefinitionFieldDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_defn_field\" where \"physical_spec_defn_field\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#deleteForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#deleteForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test deleteForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.deleteForSpecDefinition(long)"})
  void testDeleteForSpecDefinition() throws SQLException {
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
    int actualDeleteForSpecDefinitionResult =
        new PhysicalSpecDefinitionFieldDao(dsl).deleteForSpecDefinition(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_defn_field\" where \"physical_spec_defn_field\".\"spec_defn_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateDescription(long, String)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateDescription(long, String)"})
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateDescriptionResult =
        new PhysicalSpecDefinitionFieldDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_spec_defn_field\" set \"physical_spec_defn_field\".\"description\" = ? where \"physical_spec_defn_field\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_thenReturnZero() throws SQLException {
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
    int actualUpdateLogicalDataElementResult =
        new PhysicalSpecDefinitionFieldDao(dsl).updateLogicalDataElement(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_spec_defn_field\" set \"physical_spec_defn_field\".\"logical_data_element_id\" = ? where \"physical_spec_defn_field\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        new PhysicalSpecDefinitionFieldDao(dsl).updateLogicalDataElement(4L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        new PhysicalSpecDefinitionFieldDao(dsl).updateLogicalDataElement(3L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        new PhysicalSpecDefinitionFieldDao(dsl).updateLogicalDataElement(2L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }
}
