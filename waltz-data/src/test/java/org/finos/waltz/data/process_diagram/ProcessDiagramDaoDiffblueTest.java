package org.finos.waltz.data.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntity;
import org.finos.waltz.model.process_diagram.ProcessDiagramKind;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramDaoDiffblueTest {
  /**
   * Test {@link ProcessDiagramDao#getDiagramById(long)}.
   *
   * <p>Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  @DisplayName("Test getDiagramById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramById(long)"})
  void testGetDiagramById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableProcessDiagram.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ProcessDiagram actualDiagramById = new ProcessDiagramDao(dsl).getDiagramById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualDiagramById instanceof ImmutableProcessDiagram);
    assertEquals("2020-03-01", actualDiagramById.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualDiagramById.createdBy());
    assertEquals("Name", actualDiagramById.name());
    assertEquals("Provenance", actualDiagramById.provenance());
    assertEquals("The characteristics of someone or something", actualDiagramById.description());
    assertEquals(EntityKind.ALL, actualDiagramById.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramById.diagramKind());
    assertSame(ofResult, actualDiagramById.createdAt().toLocalDate());
    assertSame(ofResult2, actualDiagramById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ProcessDiagramDao#getDiagramByExternalId(String)}.
   *
   * <p>Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  @DisplayName("Test getDiagramByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramByExternalId(String)"})
  void testGetDiagramByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableProcessDiagram.builder()
                .createdAt(ofResult.atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .description("The characteristics of someone or something")
                .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult2.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ProcessDiagram actualDiagramByExternalId =
        new ProcessDiagramDao(dsl).getDiagramByExternalId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualDiagramByExternalId instanceof ImmutableProcessDiagram);
    assertEquals("2020-03-01", actualDiagramByExternalId.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualDiagramByExternalId.createdBy());
    assertEquals("Name", actualDiagramByExternalId.name());
    assertEquals("Provenance", actualDiagramByExternalId.provenance());
    assertEquals(
        "The characteristics of someone or something", actualDiagramByExternalId.description());
    assertEquals(EntityKind.ALL, actualDiagramByExternalId.kind());
    assertEquals(ProcessDiagramKind.WALTZ_SPARX, actualDiagramByExternalId.diagramKind());
    assertSame(ofResult, actualDiagramByExternalId.createdAt().toLocalDate());
    assertSame(ofResult2, actualDiagramByExternalId.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ProcessDiagramDao#findDiagramEntitiesById(long)}.
   *
   * <p>Method under test: {@link ProcessDiagramDao#findDiagramEntitiesById(long)}
   */
  @Test
  @DisplayName("Test findDiagramEntitiesById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramDao.findDiagramEntitiesById(long)"})
  void testFindDiagramEntitiesById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ProcessDiagramEntity> actualFindDiagramEntitiesByIdResult =
        new ProcessDiagramDao(dsl).findDiagramEntitiesById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindDiagramEntitiesByIdResult.isEmpty());
  }
}
