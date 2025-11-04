package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.schema.tables.records.PhysicalFlowParticipantRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class PhysicalFlowParticipantGeneratorDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalFlowParticipantGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws DataAccessException, BeansException {
    // Arrange
    PhysicalFlowParticipantGenerator physicalFlowParticipantGenerator = new PhysicalFlowParticipantGenerator();
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<PhysicalFlowParticipantRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<PhysicalFlowParticipantRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = physicalFlowParticipantGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
