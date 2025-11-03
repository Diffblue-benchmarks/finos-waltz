package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
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
class LogicalFlowHelperDiffblueTest {
  @Mock
  private DSLContext dSLContext;

  @InjectMocks
  private LogicalFlowHelper logicalFlowHelper;

  @Mock
  private LogicalFlowDao logicalFlowDao;

  @Mock
  private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlow(EntityReference, EntityReference)}.
   * <ul>
   *   <li>Given {@link LogicalFlowDao} {@link LogicalFlowDao#addFlow(LogicalFlow)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowHelper#createLogicalFlow(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test createLogicalFlow(EntityReference, EntityReference); given LogicalFlowDao addFlow(LogicalFlow) return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlow LogicalFlowHelper.createLogicalFlow(EntityReference, EntityReference)"})
  void testCreateLogicalFlow_givenLogicalFlowDaoAddFlowReturnNull_thenReturnNull() {
    // Arrange
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any())).thenReturn(null);

    // Act
    LogicalFlow actualCreateLogicalFlowResult = logicalFlowHelper.createLogicalFlow(mock(EntityReference.class),
        mock(EntityReference.class));

    // Assert
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    assertNull(actualCreateLogicalFlowResult);
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   * <ul>
   *   <li>Given minus three.</li>
   *   <li>When {@link HashSet#HashSet()} add minus three.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test createLogicalFlowDecorators(EntityReference, Set); given minus three; when HashSet() add minus three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators_givenMinusThree_whenHashSetAddMinusThree() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    EntityReference flowRef = mock(EntityReference.class);
    when(flowRef.id()).thenReturn(1L);

    HashSet<Long> dtIds = new HashSet<>();
    dtIds.add(-3L);
    dtIds.add(1L);

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(flowRef, dtIds);

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(flowRef, atLeast(1)).id();
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test createLogicalFlowDecorators(EntityReference, Set); when EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators_whenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    EntityReference flowRef = mock(EntityReference.class);
    when(flowRef.id()).thenReturn(1L);

    HashSet<Long> dtIds = new HashSet<>();
    dtIds.add(1L);

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(flowRef, dtIds);

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(flowRef).id();
  }

  /**
   * Test {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}
   */
  @Test
  @DisplayName("Test createLogicalFlowDecorators(EntityReference, Set); when HashSet(); then calls addDecorators(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogicalFlowHelper.createLogicalFlowDecorators(EntityReference, Set)"})
  void testCreateLogicalFlowDecorators_whenHashSet_thenCallsAddDecorators() {
    // Arrange
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(null, new HashSet<>());

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Test {@link LogicalFlowHelper#fetchDecoratorsForFlow(Long)}.
   * <p>
   * Method under test: {@link LogicalFlowHelper#fetchDecoratorsForFlow(Long)}
   */
  @Test
  @DisplayName("Test fetchDecoratorsForFlow(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List LogicalFlowHelper.fetchDecoratorsForFlow(Long)"})
  void testFetchDecoratorsForFlow() {
    // Arrange
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<DataTypeDecorator> actualFetchDecoratorsForFlowResult = logicalFlowHelper.fetchDecoratorsForFlow(1L);

    // Assert
    verify(logicalFlowDecoratorDao).findByEntityId(eq(1L));
    assertTrue(actualFetchDecoratorsForFlowResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowHelper#clearAllFlows()}.
   * <p>
   * Method under test: {@link LogicalFlowHelper#clearAllFlows()}
   */
  @Test
  @DisplayName("Test clearAllFlows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogicalFlowHelper.clearAllFlows()"})
  void testClearAllFlows() throws DataAccessException {
    // Arrange
    DeleteUsingStep<LogicalFlowRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    when(dSLContext.deleteFrom(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    logicalFlowHelper.clearAllFlows();

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).execute();
  }

  /**
   * Test {@link LogicalFlowHelper#removeFlow(Long)}.
   * <p>
   * Method under test: {@link LogicalFlowHelper#removeFlow(Long)}
   */
  @Test
  @DisplayName("Test removeFlow(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LogicalFlowHelper.removeFlow(Long)"})
  void testRemoveFlow() {
    // Arrange
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);

    // Act
    int actualRemoveFlowResult = logicalFlowHelper.removeFlow(1L);

    // Assert
    verify(logicalFlowDao).removeFlow(eq(1L), eq("admin"));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowHelper#makeReadOnly(long)}.
   * <p>
   * Method under test: {@link LogicalFlowHelper#makeReadOnly(long)}
   */
  @Test
  @DisplayName("Test makeReadOnly(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LogicalFlowHelper.makeReadOnly(long)"})
  void testMakeReadOnly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    logicalFlowHelper.makeReadOnly(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
