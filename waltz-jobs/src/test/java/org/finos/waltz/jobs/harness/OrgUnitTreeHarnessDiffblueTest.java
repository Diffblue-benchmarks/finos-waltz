package org.finos.waltz.jobs.harness;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.schema.tables.AccessLog;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrgUnitTreeHarnessDiffblueTest {
  /**
   * Test {@link OrgUnitTreeHarness#findAncestors(long)}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrgUnitTreeHarness#findAncestors(long)}
   */
  @Test
  @DisplayName("Test findAncestors(long); then calls eq(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.CommonTableExpression OrgUnitTreeHarness.findAncestors(long)"})
  void testFindAncestors_thenCallsEq() {
    // Arrange
    Field<Long> idField = mock(Field.class);
    when(idField.eq(Mockito.<Long>any())).thenReturn(mock(Condition.class));
    when(idField.eq(Mockito.<Field<Long>>any())).thenReturn(mock(Condition.class));
    Class<Long> type = Long.class;
    when(idField.getDataType()).thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type, "Type Name"));
    Field<Long> parentIdField = mock(Field.class);
    Class<Long> type2 = Long.class;
    when(parentIdField.getDataType()).thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type2, "Type Name"));

    // Act
    (new OrgUnitTreeHarness(new AccessLog(), idField, parentIdField)).findAncestors(1L);

    // Assert
    verify(idField).eq(eq(1L));
    verify(idField).eq(isA(Field.class));
    verify(idField).getDataType();
    verify(parentIdField).getDataType();
  }

  /**
   * Test {@link OrgUnitTreeHarness#findDescendents(long)}.
   * <ul>
   *   <li>Then calls {@link Field#eq(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrgUnitTreeHarness#findDescendents(long)}
   */
  @Test
  @DisplayName("Test findDescendents(long); then calls eq(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.CommonTableExpression OrgUnitTreeHarness.findDescendents(long)"})
  void testFindDescendents_thenCallsEq() {
    // Arrange
    Field<Long> idField = mock(Field.class);
    when(idField.eq(Mockito.<Long>any())).thenReturn(mock(Condition.class));
    Class<Long> type = Long.class;
    when(idField.getDataType()).thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type, "Type Name"));
    Field<Long> parentIdField = mock(Field.class);
    when(parentIdField.eq(Mockito.<Field<Long>>any())).thenReturn(mock(Condition.class));
    Class<Long> type2 = Long.class;
    when(parentIdField.getDataType()).thenReturn(new DefaultDataType<>(SQLDialect.SQL99, type2, "Type Name"));

    // Act
    (new OrgUnitTreeHarness(new AccessLog(), idField, parentIdField)).findDescendents(1L);

    // Assert
    verify(idField).eq(eq(1L));
    verify(parentIdField).eq(isA(Field.class));
    verify(idField).getDataType();
    verify(parentIdField).getDataType();
  }
}
