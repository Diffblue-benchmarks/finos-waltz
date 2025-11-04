package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.schema.tables.records.ChangeUnitRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ChangeUnitGeneratorDiffblueTest {
  /**
   * Method under test: {@link ChangeUnitGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws DataAccessException, BeansException {
    // Arrange
    ChangeUnitGenerator changeUnitGenerator = new ChangeUnitGenerator();
    DeleteConditionStep<ChangeUnitRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<ChangeUnitRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<ChangeUnitRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = changeUnitGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(deleteConditionStep, atLeast(1)).execute();
    verify(defaultDSLContext, atLeast(1)).deleteFrom(Mockito.<Table<Record>>any());
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link ChangeUnitGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove2() throws BeansException {
    // Arrange
    ChangeUnitGenerator changeUnitGenerator = new ChangeUnitGenerator();
    DeleteUsingStep<ChangeUnitRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException("foo"));
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<ChangeUnitRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> changeUnitGenerator.remove(ctx));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
  }
}
