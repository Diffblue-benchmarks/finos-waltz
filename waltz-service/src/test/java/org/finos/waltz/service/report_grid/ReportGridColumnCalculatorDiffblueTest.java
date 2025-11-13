package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance;
import org.finos.waltz.model.report_grid.ImmutableReportSubject;
import org.finos.waltz.model.report_grid.ImmutableReportSubject.Builder;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInstance;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridColumnCalculatorDiffblueTest {
  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    Builder builderResult2 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());
    ImmutableReportGridInstance instance = builderResult.build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate2() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder builderResult2 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());
    ImmutableReportGridInstance instance = builderResult.build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate3() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));
    builderResult.addCellData(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    Builder builderResult2 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());
    ImmutableReportGridInstance instance = builderResult.build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate4() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();

    Builder builderResult2 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());

    Builder builderResult3 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());
    ImmutableReportGridInstance instance = builderResult.build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate5() {
    // Arrange
    ImmutableReportGridInstance.Builder builderResult = ImmutableReportGridInstance.builder();
    builderResult.addRatingSchemeItems(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    builderResult.addRatingSchemeItems(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder builderResult2 = ImmutableReportSubject.builder();
    builderResult.addSubjects(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build());
    ImmutableReportGridInstance instance = builderResult.build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_thenReturnEmpty() {
    // Arrange
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();
    ImmutableReportGridDefinition definition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with
   * {@code ReportGridDerivedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
  })
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenReturn42() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition col =
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertEquals("42", ReportGridColumnCalculator.colToExtId(col));
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturn42() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition col =
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
            .build();

    // Act and Assert
    assertEquals("42", ReportGridColumnCalculator.colToExtId(col));
  }
}
