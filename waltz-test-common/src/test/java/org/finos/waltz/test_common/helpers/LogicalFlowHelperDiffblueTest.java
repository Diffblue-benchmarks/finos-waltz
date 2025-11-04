package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.datatype.DataTypeDecorator;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class LogicalFlowHelperDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowHelper#createLogicalFlowDecorators(EntityReference, Set)}
   */
  @Test
  void testCreateLogicalFlowDecorators() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    LogicalFlowHelper logicalFlowHelper = new LogicalFlowHelper();
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDecoratorDao", logicalFlowDecoratorDao);
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDao", mock(LogicalFlowDao.class));
    ReflectionTestUtils.setField(logicalFlowHelper, "dsl", mock(DSLContext.class));

    // Act
    logicalFlowHelper.createLogicalFlowDecorators(null, new HashSet<>());

    // Assert
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
  }

  /**
   * Method under test: {@link LogicalFlowHelper#fetchDecoratorsForFlow(Long)}
   */
  @Test
  void testFetchDecoratorsForFlow() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(dataTypeDecoratorList);
    LogicalFlowHelper logicalFlowHelper = new LogicalFlowHelper();
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDecoratorDao", logicalFlowDecoratorDao);
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDao", mock(LogicalFlowDao.class));
    ReflectionTestUtils.setField(logicalFlowHelper, "dsl", mock(DSLContext.class));

    // Act
    List<DataTypeDecorator> actualFetchDecoratorsForFlowResult = logicalFlowHelper.fetchDecoratorsForFlow(1L);

    // Assert
    verify(logicalFlowDecoratorDao).findByEntityId(eq(1L));
    assertTrue(actualFetchDecoratorsForFlowResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFetchDecoratorsForFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowHelper#clearAllFlows()}
   */
  @Test
  void testClearAllFlows() throws DataAccessException {
    // Arrange
    LogicalFlowHelper logicalFlowHelper = new LogicalFlowHelper();
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDecoratorDao", mock(LogicalFlowDecoratorDao.class));
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDao", mock(LogicalFlowDao.class));
    DeleteUsingStep<LogicalFlowRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.deleteFrom(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(deleteUsingStep);
    ReflectionTestUtils.setField(logicalFlowHelper, "dsl", dslContext);

    // Act
    logicalFlowHelper.clearAllFlows();

    // Assert
    verify(dslContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).execute();
  }

  /**
   * Method under test: {@link LogicalFlowHelper#removeFlow(Long)}
   */
  @Test
  void testRemoveFlow() {
    // Arrange
    LogicalFlowHelper logicalFlowHelper = new LogicalFlowHelper();
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDecoratorDao", mock(LogicalFlowDecoratorDao.class));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDao", logicalFlowDao);
    ReflectionTestUtils.setField(logicalFlowHelper, "dsl", mock(DSLContext.class));

    // Act
    int actualRemoveFlowResult = logicalFlowHelper.removeFlow(1L);

    // Assert
    verify(logicalFlowDao).removeFlow(eq(1L), eq("admin"));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowHelper#makeReadOnly(long)}
   */
  @Test
  void testMakeReadOnly() throws DataAccessException {
    // Arrange
    LogicalFlowHelper logicalFlowHelper = new LogicalFlowHelper();
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDecoratorDao", mock(LogicalFlowDecoratorDao.class));
    ReflectionTestUtils.setField(logicalFlowHelper, "logicalFlowDao", mock(LogicalFlowDao.class));
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(logicalFlowHelper, "dsl", dslContext);

    // Act
    logicalFlowHelper.makeReadOnly(1L);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
