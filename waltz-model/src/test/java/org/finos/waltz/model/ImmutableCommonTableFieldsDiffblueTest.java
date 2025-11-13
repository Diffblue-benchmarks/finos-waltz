package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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

class ImmutableCommonTableFieldsDiffblueTest {
  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    // Act
    Builder<Record> actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
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
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom2() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
            .descriptionField(null)
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
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom3() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(null)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .parentIdField(mock(Field.class))
            .qualifierIdField(mock(Field.class))
            .qualifierKindField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .table(mock(Table.class))
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom4() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(null)
            .parentIdField(mock(Field.class))
            .qualifierIdField(mock(Field.class))
            .qualifierKindField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .table(mock(Table.class))
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom5() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
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
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom6() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .parentIdField(mock(Field.class))
            .qualifierIdField(null)
            .qualifierKindField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .table(mock(Table.class))
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#from(CommonTableFields)}.
   *
   * <p>Method under test: {@link Builder#from(CommonTableFields)}
   */
  @Test
  @DisplayName("Test Builder from(CommonTableFields)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommonTableFields)"})
  void testBuilderFrom7() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    Builder<Record> builderResult2 = ImmutableCommonTableFields.builder();
    ImmutableCommonTableFields<Record> instance =
        builderResult2
            .descriptionField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .entityKind(EntityKind.ALL)
            .externalIdField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .idField(mock(Field.class))
            .isActiveCondition(mock(Condition.class))
            .lifecycleField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .nameField(CommonTableFields.ALWAYS_ACTIVE_FIELD_VAL)
            .parentIdField(mock(Field.class))
            .qualifierIdField(mock(Field.class))
            .qualifierKindField(null)
            .table(mock(Table.class))
            .build();

    // Act and Assert
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCommonTableFields);
    ImmutableCommonTableFields<Record> actualImmutableCommonTableFields2 = builderResult.build();
    assertEquals(instance, actualImmutableCommonTableFields2);
  }

  /**
   * Test Builder {@link Builder#idField(Field)}.
   *
   * <p>Method under test: {@link Builder#idField(Field)}
   */
  @Test
  @DisplayName("Test Builder idField(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.idField(Field)"})
  void testBuilderIdField() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    // Act
    Builder<Record> actualIdFieldResult = builderResult.idField(mock(Field.class));

    // Assert
    assertSame(builderResult, actualIdFieldResult);
  }

  /**
   * Test Builder {@link Builder#table(Table)}.
   *
   * <ul>
   *   <li>When {@link Table}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#table(Table)}
   */
  @Test
  @DisplayName("Test Builder table(Table); when Table; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.table(Table)"})
  void testBuilderTable_whenTable_thenReturnBuilder() {
    // Arrange
    Builder<Record> builderResult = ImmutableCommonTableFields.builder();

    // Act
    Builder<Record> actualTableResult = builderResult.table(mock(Table.class));

    // Assert
    assertSame(builderResult, actualTableResult);
  }
}
