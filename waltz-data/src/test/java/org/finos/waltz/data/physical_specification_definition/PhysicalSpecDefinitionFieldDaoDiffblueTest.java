package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult =
        physicalSpecDefinitionFieldDao.findForSpecDefinition(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSpecDefinitionResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefnFieldRecord} {@link PhysicalSpecDefnFieldRecord#getId()}
   *       return one.
   *   <li>Then calls {@link PhysicalSpecDefinitionField#description()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinitionField); given PhysicalSpecDefnFieldRecord getId() return one; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionFieldDao.create(PhysicalSpecDefinitionField)"})
  void testCreate_givenPhysicalSpecDefnFieldRecordGetIdReturnOne_thenCallsDescription()
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
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(insertSetStep);

    PhysicalSpecDefinitionField definitionField = mock(PhysicalSpecDefinitionField.class);
    when(definitionField.lastUpdatedBy()).thenReturn("2020-03-01");
    when(definitionField.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.of(1L);
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
   *   <li>Given {@link PhysicalSpecDefnFieldRecord} {@link PhysicalSpecDefnFieldRecord#getId()}
   *       return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinitionField); given PhysicalSpecDefnFieldRecord getId() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionFieldDao.create(PhysicalSpecDefinitionField)"})
  void testCreate_givenPhysicalSpecDefnFieldRecordGetIdReturnOne_thenReturnOne()
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
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(insertSetStep);

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
    verify(dSLContext).insertInto(isA(Table.class));
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
  void testDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDefnFieldRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<PhysicalSpecDefnFieldRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = physicalSpecDefinitionFieldDao.delete(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
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
  void testDeleteForSpecDefinition() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDefnFieldRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<PhysicalSpecDefnFieldRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForSpecDefinitionResult =
        physicalSpecDefinitionFieldDao.deleteForSpecDefinition(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteForSpecDefinitionResult);
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
  void testUpdateDescription() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnFieldRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalSpecDefnFieldRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecDefnFieldRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDescriptionResult =
        physicalSpecDefinitionFieldDao.updateDescription(
            1L, "The characteristics of someone or something");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenFour() throws DataAccessException {
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
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldDao.updateLogicalDataElement(4L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenOne() throws DataAccessException {
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
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldDao.updateLogicalDataElement(1L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenThree() throws DataAccessException {
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
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldDao.updateLogicalDataElement(3L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long, Long)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldDao#updateLogicalDataElement(long,
   * Long)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(long, Long); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldDao.updateLogicalDataElement(long, Long)"})
  void testUpdateLogicalDataElement_whenTwo() throws DataAccessException {
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
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnFieldRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldDao.updateLogicalDataElement(2L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateLogicalDataElementResult);
  }
}
