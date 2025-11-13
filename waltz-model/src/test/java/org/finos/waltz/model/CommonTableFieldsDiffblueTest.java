package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableCommonTableFields.Builder;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommonTableFieldsDiffblueTest {
  /**
   * Test {@link CommonTableFields#hierarchical()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFields#hierarchical()}
   */
  @Test
  @DisplayName("Test hierarchical(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommonTableFields.hierarchical()"})
  void testHierarchical_thenReturnFalse() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    // Act and Assert
    assertFalse(
        builderResult
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .parentIdField(null)
            .qualifierIdField(mock(Field.class))
            .qualifierKindField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .table(mock(Table.class))
            .build()
            .hierarchical());
  }

  /**
   * Test {@link CommonTableFields#hierarchical()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CommonTableFields#hierarchical()}
   */
  @Test
  @DisplayName("Test hierarchical(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommonTableFields.hierarchical()"})
  void testHierarchical_thenReturnTrue() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .parentIdField(mock(Field.class))
            .qualifierIdField(mock(Field.class))
            .qualifierKindField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .table(mock(Table.class))
            .build()
            .hierarchical());
  }
}
