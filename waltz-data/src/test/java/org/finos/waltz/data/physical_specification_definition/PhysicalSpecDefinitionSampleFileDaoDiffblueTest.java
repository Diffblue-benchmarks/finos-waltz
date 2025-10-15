package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFile;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFile;
import org.finos.waltz.schema.tables.records.PhysicalSpecDefnSampleFileRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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
class PhysicalSpecDefinitionSampleFileDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao;

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#findForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionSampleFileDao#findForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test findForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PhysicalSpecDefinitionSampleFileDao.findForSpecDefinition(long)"})
  void testFindForSpecDefinition() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.of("42");
    when(selectConditionStep.fetchOptional(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(ofResult);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Optional<PhysicalSpecDefinitionSampleFile> actualFindForSpecDefinitionResult =
        physicalSpecDefinitionSampleFileDao.findForSpecDefinition(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOptional(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertSame(ofResult, actualFindForSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test create(PhysicalSpecDefinitionSampleFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionSampleFileDao.create(PhysicalSpecDefinitionSampleFile)"
  })
  void testCreate() throws DataAccessException {
    // Arrange
    InsertResultStep<PhysicalSpecDefnSampleFileRecord> insertResultStep =
        mock(InsertResultStep.class);
    PhysicalSpecDefnSampleFileRecord physicalSpecDefnSampleFileRecord =
        new PhysicalSpecDefnSampleFileRecord(1L, 1L, "Name", "File Data");
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnSampleFileRecord);

    InsertSetMoreStep<PhysicalSpecDefnSampleFileRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnSampleFileRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnSampleFileRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionSampleFileDao.create(
            ImmutablePhysicalSpecDefinitionSampleFile.builder()
                .fileData("File Data")
                .id(1L)
                .name("Name")
                .specDefinitionId(1L)
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefnSampleFileRecord} {@link
   *       PhysicalSpecDefnSampleFileRecord#getId()} return one.
   *   <li>Then calls {@link PhysicalSpecDefnSampleFileRecord#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalSpecDefinitionSampleFile); given PhysicalSpecDefnSampleFileRecord getId() return one; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionSampleFileDao.create(PhysicalSpecDefinitionSampleFile)"
  })
  void testCreate_givenPhysicalSpecDefnSampleFileRecordGetIdReturnOne_thenCallsGetId()
      throws DataAccessException {
    // Arrange
    PhysicalSpecDefnSampleFileRecord physicalSpecDefnSampleFileRecord =
        mock(PhysicalSpecDefnSampleFileRecord.class);
    when(physicalSpecDefnSampleFileRecord.getId()).thenReturn(1L);

    InsertResultStep<PhysicalSpecDefnSampleFileRecord> insertResultStep =
        mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnSampleFileRecord);

    InsertSetMoreStep<PhysicalSpecDefnSampleFileRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnSampleFileRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnSampleFileRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionSampleFileDao.create(
            ImmutablePhysicalSpecDefinitionSampleFile.builder()
                .fileData("File Data")
                .id(1L)
                .name("Name")
                .specDefinitionId(1L)
                .build());

    // Assert
    verify(physicalSpecDefnSampleFileRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}.
   *
   * <ul>
   *   <li>Then calls {@link PhysicalSpecDefinitionSampleFile#name()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionSampleFileDao#create(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test create(PhysicalSpecDefinitionSampleFile); then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionSampleFileDao.create(PhysicalSpecDefinitionSampleFile)"
  })
  void testCreate_thenCallsName() throws DataAccessException {
    // Arrange
    InsertResultStep<PhysicalSpecDefnSampleFileRecord> insertResultStep =
        mock(InsertResultStep.class);
    PhysicalSpecDefnSampleFileRecord physicalSpecDefnSampleFileRecord =
        new PhysicalSpecDefnSampleFileRecord(1L, 1L, "Name", "File Data");
    when(insertResultStep.fetchOne()).thenReturn(physicalSpecDefnSampleFileRecord);

    InsertSetMoreStep<PhysicalSpecDefnSampleFileRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<PhysicalSpecDefnSampleFileRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<PhysicalSpecDefnSampleFileRecord>>any()))
        .thenReturn(insertSetStep);

    PhysicalSpecDefinitionSampleFile sampleFile = mock(PhysicalSpecDefinitionSampleFile.class);
    when(sampleFile.name()).thenReturn("Name");
    when(sampleFile.fileData()).thenReturn("File Data");
    when(sampleFile.specDefinitionId()).thenReturn(1L);

    // Act
    long actualCreateResult = physicalSpecDefinitionSampleFileDao.create(sampleFile);

    // Assert
    verify(sampleFile).name();
    verify(sampleFile).fileData();
    verify(sampleFile).specDefinitionId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#delete(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionSampleFileDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionSampleFileDao.delete(long)"})
  void testDelete() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDefnSampleFileRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<PhysicalSpecDefnSampleFileRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDefnSampleFileRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = physicalSpecDefinitionSampleFileDao.delete(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionSampleFileDao#deleteForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionSampleFileDao#deleteForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test deleteForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(long)"})
  void testDeleteForSpecDefinition() throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalSpecDefnSampleFileRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<PhysicalSpecDefnSampleFileRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<PhysicalSpecDefnSampleFileRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForSpecDefinitionResult =
        physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteForSpecDefinitionResult);
  }
}
