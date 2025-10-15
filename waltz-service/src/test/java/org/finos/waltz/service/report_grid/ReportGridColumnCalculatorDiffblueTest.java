package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.parser.ASTAddNode;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance;
import org.finos.waltz.model.report_grid.ImmutableReportSubject;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInstance;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportSubject;
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
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenThrow(new JexlException(new ASTAddNode(1), "xs cannot be null"));

    // Act and Assert
    assertThrows(
        JexlException.class,
        () -> ReportGridColumnCalculator.calculate(instance, mock(ReportGridDefinition.class)));
    verify(instance).cellData();
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
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);
    when(instance.subjects()).thenReturn(new HashSet<>());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions())
        .thenThrow(new JexlException(new ASTAddNode(1), "xs cannot be null"));
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act and Assert
    assertThrows(
        JexlException.class, () -> ReportGridColumnCalculator.calculate(instance, definition));
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList =
        new ArrayList<>();

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
    reportGridFixedColumnDefinitionList.add(
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
            .build());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
  void testCalculate6() {
    // Arrange
    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList =
        new ArrayList<>();

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
    reportGridFixedColumnDefinitionList.add(
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
            .build());

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    reportGridFixedColumnDefinitionList.add(
        displayNameResult2
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
            .build());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
  void testCalculate7() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList =
        new ArrayList<>();

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
    reportGridFixedColumnDefinitionList.add(
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
            .build());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
  void testCalculate8() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue(null).build());

    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList =
        new ArrayList<>();

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
    reportGridFixedColumnDefinitionList.add(
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
            .build());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
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
  void testCalculate9() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue(null).build());

    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList =
        new ArrayList<>();

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
    reportGridFixedColumnDefinitionList.add(
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
            .build());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_givenArrayList() {
    // Arrange
    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test calculate(ReportGridInstance, ReportGridDefinition); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_givenArrayList2() {
    // Arrange
    HashSet<ReportGridCell> reportGridCellSet = new HashSet<>();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    reportGridCellSet.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    HashSet<ReportSubject> reportSubjectSet = new HashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    reportSubjectSet.add(
        builderResult
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

    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(reportGridCellSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(reportSubjectSet);

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(definition).fixedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Given {@link JexlException#JexlException(JexlNode, String)} with node is {@link
   *       ASTAddNode#ASTAddNode(int)} and {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test calculate(ReportGridInstance, ReportGridDefinition); given JexlException(JexlNode, String) with node is ASTAddNode(int) and 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_givenJexlExceptionWithNodeIsASTAddNodeAndMsg() {
    // Arrange
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions())
        .thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(
        JexlException.class, () -> ReportGridColumnCalculator.calculate(instance, definition));
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test calculate(ReportGridInstance, ReportGridDefinition); given 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_givenNull_thenReturnEmpty() {
    // Arrange
    ReportGridInstance instance = mock(ReportGridInstance.class);
    when(instance.cellData()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());
    when(instance.subjects()).thenReturn(new HashSet<>());

    ReportGridDefinition definition = mock(ReportGridDefinition.class);
    when(definition.derivedColumnDefinitions()).thenReturn(null);

    // Act
    Set<ReportGridCell> actualCalculateResult =
        ReportGridColumnCalculator.calculate(instance, definition);

    // Assert
    verify(definition).derivedColumnDefinitions();
    verify(instance).cellData();
    verify(instance).ratingSchemeItems();
    verify(instance).subjects();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Test {@link ReportGridColumnCalculator#calculate(ReportGridInstance, ReportGridDefinition)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridColumnCalculator#calculate(ReportGridInstance,
   * ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test calculate(ReportGridInstance, ReportGridDefinition); when builder build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ReportGridColumnCalculator.calculate(ReportGridInstance, ReportGridDefinition)"
  })
  void testCalculate_whenBuilderBuild_thenReturnEmpty() {
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
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; given space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
  })
  void testColToExtIdWithReportGridDerivedColumnDefinition_givenSpace() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn(" ");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with
   * {@code ReportGridDerivedColumnDefinition}.
   *
   * <ul>
   *   <li>Given {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; given '_'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
  })
  void testColToExtIdWithReportGridDerivedColumnDefinition_givenUnderscore() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn("_");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("_", actualColToExtIdResult);
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
    "String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
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
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with
   * {@code ReportGridDerivedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code DISPLAY_NAME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then return 'DISPLAY_NAME'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
  })
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenReturnDisplayName() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).displayName();
    assertEquals("DISPLAY_NAME", actualColToExtIdResult);
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)} with
   * {@code ReportGridDerivedColumnDefinition}.
   *
   * <ul>
   *   <li>Then throw {@link JexlException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then throw JexlException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridDerivedColumnDefinition)"
  })
  void testColToExtIdWithReportGridDerivedColumnDefinition_thenThrowJexlException() {
    // Arrange
    ReportGridDerivedColumnDefinition col = mock(ReportGridDerivedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Given {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; given '_'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_givenUnderscore() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn("_");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("_", actualColToExtIdResult);
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
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
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

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code COLUMN_NAME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return 'COLUMN_NAME'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnColumnName() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.columnName()).thenReturn("Column Name");
    when(col.displayName()).thenReturn(null);
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col).columnName();
    verify(col).displayName();
    assertEquals("COLUMN_NAME", actualColToExtIdResult);
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code DISPLAY_NAME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return 'DISPLAY_NAME'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnDisplayName() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("DISPLAY_NAME", actualColToExtIdResult);
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Then return {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then return '_'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_thenReturnUnderscore() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.displayName()).thenReturn(" ");
    Optional<String> emptyResult = Optional.empty();
    when(col.externalId()).thenReturn(emptyResult);

    // Act
    String actualColToExtIdResult = ReportGridColumnCalculator.colToExtId(col);

    // Assert
    verify(col).externalId();
    verify(col, atLeast(1)).displayName();
    assertEquals("_", actualColToExtIdResult);
  }

  /**
   * Test {@link ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <ul>
   *   <li>Then throw {@link JexlException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReportGridColumnCalculator#colToExtId(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test colToExtId(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then throw JexlException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ReportGridColumnCalculator.colToExtId(ReportGridFixedColumnDefinition)"
  })
  void testColToExtIdWithReportGridFixedColumnDefinition_thenThrowJexlException() {
    // Arrange
    ReportGridFixedColumnDefinition col = mock(ReportGridFixedColumnDefinition.class);
    when(col.externalId()).thenThrow(new JexlException(new ASTAddNode(1), "Msg"));

    // Act and Assert
    assertThrows(JexlException.class, () -> ReportGridColumnCalculator.colToExtId(col));
    verify(col).externalId();
  }
}
