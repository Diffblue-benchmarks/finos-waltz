package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.schema.tables.records.PhysicalFlowRecord;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
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

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class PhysicalFlowHelperDiffblueTest {
  @InjectMocks
  private PhysicalFlowHelper physicalFlowHelper;

  @Mock
  private PhysicalFlowService physicalFlowService;

  @Mock
  private PhysicalSpecificationService physicalSpecificationService;

  @Mock
  private DSLContext dSLContext;

  /**
   * Test {@link PhysicalFlowHelper#createPhysicalFlow(Long, Long, String)}.
   * <ul>
   *   <li>Given {@link PhysicalFlowService} {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowHelper#createPhysicalFlow(Long, Long, String)}
   */
  @Test
  @DisplayName("Test createPhysicalFlow(Long, Long, String); given PhysicalFlowService create(PhysicalFlowCreateCommand, String) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowCreateCommandResponse PhysicalFlowHelper.createPhysicalFlow(Long, Long, String)"})
  void testCreatePhysicalFlow_givenPhysicalFlowServiceCreateReturnNull_thenReturnNull() {
    // Arrange
    when(physicalFlowService.create(Mockito.<PhysicalFlowCreateCommand>any(), Mockito.<String>any())).thenReturn(null);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(mock(PhysicalSpecification.class));

    // Act
    PhysicalFlowCreateCommandResponse actualCreatePhysicalFlowResult = physicalFlowHelper.createPhysicalFlow(1L, 1L,
        "Name");

    // Assert
    verify(physicalFlowService).create(isA(PhysicalFlowCreateCommand.class),
        eq("Name_fedcbd6c-cb8e-416a-92db-b6accd16c3ff"));
    verify(physicalSpecificationService).getById(eq(1L));
    assertNull(actualCreatePhysicalFlowResult);
  }

  /**
   * Test {@link PhysicalFlowHelper#deletePhysicalFlow(Long)}.
   * <p>
   * Method under test: {@link PhysicalFlowHelper#deletePhysicalFlow(Long)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlow(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalFlowDeleteCommandResponse PhysicalFlowHelper.deletePhysicalFlow(Long)"})
  void testDeletePhysicalFlow() {
    // Arrange
    when(physicalFlowService.delete(Mockito.<PhysicalFlowDeleteCommand>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeletePhysicalFlowResult = physicalFlowHelper.deletePhysicalFlow(1L);

    // Assert
    verify(physicalFlowService).delete(isA(PhysicalFlowDeleteCommand.class),
        eq("deletingFlow_28d39cb7-41b7-4201-82c7-f4d41c70a900"));
    assertNull(actualDeletePhysicalFlowResult);
  }

  /**
   * Test {@link PhysicalFlowHelper#markFlowAsReadOnly(long)}.
   * <p>
   * Method under test: {@link PhysicalFlowHelper#markFlowAsReadOnly(long)}
   */
  @Test
  @DisplayName("Test markFlowAsReadOnly(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PhysicalFlowHelper.markFlowAsReadOnly(long)"})
  void testMarkFlowAsReadOnly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    physicalFlowHelper.markFlowAsReadOnly(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalFlowHelper#updateExternalIdOnFlowDirectly(long, String)}.
   * <p>
   * Method under test: {@link PhysicalFlowHelper#updateExternalIdOnFlowDirectly(long, String)}
   */
  @Test
  @DisplayName("Test updateExternalIdOnFlowDirectly(long, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PhysicalFlowHelper.updateExternalIdOnFlowDirectly(long, String)"})
  void testUpdateExternalIdOnFlowDirectly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    physicalFlowHelper.updateExternalIdOnFlowDirectly(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
