package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Test {@link ReportGridFixedColumnDefinition#additionalColumnOptions()}.
   *
   * <p>Method under test: {@link ReportGridFixedColumnDefinition#additionalColumnOptions()}
   */
  @Test
  @DisplayName("Test additionalColumnOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdditionalColumnOptions ReportGridFixedColumnDefinition.additionalColumnOptions()"
  })
  void testAdditionalColumnOptions() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        AdditionalColumnOptions.NONE,
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .additionalColumnOptions());
  }

  /**
   * Test {@link ReportGridFixedColumnDefinition#kind()}.
   *
   * <p>Method under test: {@link ReportGridFixedColumnDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ReportGridFixedColumnDefinition.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, new Json().kind());
  }
}
