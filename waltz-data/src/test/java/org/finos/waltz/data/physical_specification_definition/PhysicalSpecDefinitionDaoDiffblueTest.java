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
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionType;
import org.finos.waltz.schema.tables.records.PhysicalSpecDefnRecord;
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
class PhysicalSpecDefinitionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecDefinitionDao physicalSpecDefinitionDao;

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<PhysicalSpecDefinition> actualFindForSpecificationResult =
        physicalSpecDefinitionDao.findForSpecification(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefnRecord} {@link PhysicalSpecDefnRecord#getId()} return one.
   *   <li>Then calls {@link PhysicalSpecDefinition#createdAt()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinition); given PhysicalSpecDefnRecord getId() return one; then calls createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionDao.create(PhysicalSpecDefinition)"})
  void testCreate_givenPhysicalSpecDefnRecordGetIdReturnOne_thenCallsCreatedAt()
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
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(insertSetStep);

    PhysicalSpecDefinition specDefinition = mock(PhysicalSpecDefinition.class);
    when(specDefinition.lastUpdatedBy()).thenReturn("2020-03-01");
    when(specDefinition.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(specDefinition.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(specDefinition.provenance()).thenReturn("Provenance");
    when(specDefinition.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<String> ofResult = Optional.of("foo");
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
   *   <li>Given {@link PhysicalSpecDefnRecord} {@link PhysicalSpecDefnRecord#getId()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinition); given PhysicalSpecDefnRecord getId() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PhysicalSpecDefinitionDao.create(PhysicalSpecDefinition)"})
  void testCreate_givenPhysicalSpecDefnRecordGetIdReturnOne_thenReturnOne()
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
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(insertSetStep);

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
    verify(dSLContext).insertInto(isA(Table.class));
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
  void testDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDefnRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<PhysicalSpecDefnRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = physicalSpecDefinitionDao.delete(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
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
  void testUpdateStatus() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalSpecDefnRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<PhysicalSpecDefnRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusResult =
        physicalSpecDefinitionDao.updateStatus(1L, ReleaseLifecycleStatus.DRAFT, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusResult);
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
  void testMarkExistingActiveAsDeprecated() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecDefnRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalSpecDefnRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<PhysicalSpecDefnRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<PhysicalSpecDefnRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecDefnRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualMarkExistingActiveAsDeprecatedResult =
        physicalSpecDefinitionDao.markExistingActiveAsDeprecated(1L, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualMarkExistingActiveAsDeprecatedResult);
  }
}
