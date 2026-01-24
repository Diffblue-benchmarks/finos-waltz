package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridEvaluatorNamespaceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportGridEvaluatorNamespace#ReportGridEvaluatorNamespace(ReportGridDefinition)}
   *   <li>{@link ReportGridEvaluatorNamespace#setContext(Map)}
   *   <li>{@link ReportGridEvaluatorNamespace#getContext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportGridEvaluatorNamespace.<init>(ReportGridDefinition)",
    "Map ReportGridEvaluatorNamespace.getContext()",
    "void ReportGridEvaluatorNamespace.setContext(Map)"
  })
  void testGettersAndSetters() {
    // Arrange
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
    ReportGridEvaluatorNamespace actualReportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);
    HashMap<String, Object> ctx = new HashMap<>();
    actualReportGridEvaluatorNamespace.setContext(ctx);
    Map<String, Object> actualContext = actualReportGridEvaluatorNamespace.getContext();

    // Assert
    assertTrue(actualContext.isEmpty());
    assertSame(ctx, actualContext);
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#addContext(String, Object)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#addContext(String, Object)}
   */
  @Test
  @DisplayName("Test addContext(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridEvaluatorNamespace.addContext(String, Object)"})
  void testAddContext() {
    // Arrange
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
    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);

    // Act
    reportGridEvaluatorNamespace.addContext("Key", "Value");

    // Assert
    Map<String, Object> context = reportGridEvaluatorNamespace.getContext();
    assertEquals(1, context.size());
    assertEquals("Value", context.get("Key"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#cell(String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#cell(String)}
   */
  @Test
  @DisplayName("Test cell(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ReportGridEvaluatorNamespace.cell(String)"})
  void testCell() {
    // Arrange
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

    // Act and Assert
    assertNull(new ReportGridEvaluatorNamespace(definition).cell("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectLifecyclePhase} is {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName(
      "Test hasLifecyclePhase(String[]); given HashMap() 'subjectLifecyclePhase' is 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase_givenHashMapSubjectLifecyclePhaseIsFoo_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectLifecyclePhase", "foo");
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

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasLifecyclePhase("Lifecycle Phases"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasLifecyclePhase(String[])}
   */
  @Test
  @DisplayName("Test hasLifecyclePhase(String[]); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasLifecyclePhase(String[])"})
  void testHasLifecyclePhase_thenReturnFalse() {
    // Arrange
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

    // Act and Assert
    assertFalse(new ReportGridEvaluatorNamespace(definition).hasLifecyclePhase());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectExternalId} is {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName(
      "Test hasExternalId(String[]); given HashMap() 'subjectExternalId' is 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId_givenHashMapSubjectExternalIdIsFoo_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectExternalId", "foo");
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

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasExternalId("External Ids"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasExternalId(String[])}
   */
  @Test
  @DisplayName("Test hasExternalId(String[]); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasExternalId(String[])"})
  void testHasExternalId_thenReturnFalse() {
    // Arrange
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

    // Act and Assert
    assertFalse(new ReportGridEvaluatorNamespace(definition).hasExternalId());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectName} is {@code foo}.
   *   <li>When {@code Names}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName(
      "Test hasName(String[]); given HashMap() 'subjectName' is 'foo'; when 'Names'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName_givenHashMapSubjectNameIsFoo_whenNames_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectName", "foo");
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

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertFalse(reportGridEvaluatorNamespace.hasName("Names"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasName(String[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasName(String[])}
   */
  @Test
  @DisplayName("Test hasName(String[]); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasName(String[])"})
  void testHasName_thenReturnFalse() {
    // Arrange
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

    // Act and Assert
    assertFalse(new ReportGridEvaluatorNamespace(definition).hasName());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasId(Long[])}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code subjectId} is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  @DisplayName("Test hasId(Long[]); given HashMap() 'subjectId' is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasId(Long[])"})
  void testHasId_givenHashMapSubjectIdIsOne_thenReturnTrue() {
    // Arrange
    HashMap<String, Object> ctx = new HashMap<>();
    ctx.put("subjectId", 1L);
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

    ReportGridEvaluatorNamespace reportGridEvaluatorNamespace =
        new ReportGridEvaluatorNamespace(definition);
    reportGridEvaluatorNamespace.setContext(ctx);

    // Act and Assert
    assertTrue(reportGridEvaluatorNamespace.hasId(1L));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#hasId(Long[])}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#hasId(Long[])}
   */
  @Test
  @DisplayName("Test hasId(Long[]); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.hasId(Long[])"})
  void testHasId_thenReturnFalse() {
    // Arrange
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

    // Act and Assert
    assertFalse(new ReportGridEvaluatorNamespace(definition).hasId(1L));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#ratioProvided(String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#ratioProvided(String[])}
   */
  @Test
  @DisplayName("Test ratioProvided(String[]); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.math.BigDecimal ReportGridEvaluatorNamespace.ratioProvided(String[])"})
  void testRatioProvided_whenNull_thenReturnNull() {
    // Arrange
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

    // Act and Assert
    assertNull(new ReportGridEvaluatorNamespace(definition).ratioProvided(null));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#percentageProvided(String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#percentageProvided(String[])}
   */
  @Test
  @DisplayName("Test percentageProvided(String[]); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.math.BigDecimal ReportGridEvaluatorNamespace.percentageProvided(String[])"
  })
  void testPercentageProvided_whenNull_thenReturnNull() {
    // Arrange
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

    // Act and Assert
    assertNull(new ReportGridEvaluatorNamespace(definition).percentageProvided(null));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isAfterToday(String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#isAfterToday(String)}
   */
  @Test
  @DisplayName("Test isAfterToday(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isAfterToday(String)"})
  void testIsAfterToday() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ReportGridEvaluatorNamespace(definition).isAfterToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#after(String, String, String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#after(String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test after(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CellResult ReportGridEvaluatorNamespace.after(String, String, String, String)"
  })
  void testAfter() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition).after("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#before(String, String, String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#before(String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test before(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CellResult ReportGridEvaluatorNamespace.before(String, String, String, String)"
  })
  void testBefore() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .before("42", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isBeforeToday(String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#isBeforeToday(String)}
   */
  @Test
  @DisplayName("Test isBeforeToday(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isBeforeToday(String)"})
  void testIsBeforeToday() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ReportGridEvaluatorNamespace(definition).isBeforeToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareDateCells(String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#compareDateCells(String, String)}
   */
  @Test
  @DisplayName("Test compareDateCells(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareDateCells(String, String)"})
  void testCompareDateCells() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .compareDateCells("Cell Ext Id A", "Cell Ext Id B"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareToToday(String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#compareToToday(String)}
   */
  @Test
  @DisplayName("Test compareToToday(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareToToday(String)"})
  void testCompareToToday() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ReportGridEvaluatorNamespace(definition).compareToToday("42"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#compareToDate(String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#compareToDate(String, String)}
   */
  @Test
  @DisplayName("Test compareToDate(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReportGridEvaluatorNamespace.compareToDate(String, String)"})
  void testCompareToDate() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ReportGridEvaluatorNamespace(definition).compareToDate("42", "2020-03-01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#dateCompare(String, String, String, String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#dateCompare(String, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test dateCompare(String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CellResult ReportGridEvaluatorNamespace.dateCompare(String, String, String, String, String)"
  })
  void testDateCompare() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .dateCompare("42", "2020-03-01", "Before", "Equal", "After"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#isBetweenDates(String, String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#isBetweenDates(String, String,
   * String)}
   */
  @Test
  @DisplayName("Test isBetweenDates(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridEvaluatorNamespace.isBetweenDates(String, String, String)"})
  void testIsBetweenDates() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .isBetweenDates("42", "2020-03-01", "2020-03-01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#betweenDates(String, String, String, String, String)}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#betweenDates(String, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test betweenDates(String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CellResult ReportGridEvaluatorNamespace.betweenDates(String, String, String, String, String)"
  })
  void testBetweenDates() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .betweenDates("42", "2020-03-01", "2020-03-01", "Pass", "Fail"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return toString is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}
   */
  @Test
  @DisplayName(
      "Test parseLocalDatefromString(String); when '2020-03-01'; then return toString is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate ReportGridEvaluatorNamespace.parseLocalDatefromString(String)"})
  void testParseLocalDatefromString_when20200301_thenReturnToStringIs20200301() {
    // Arrange, Act and Assert
    assertEquals(
        "2020-03-01",
        ReportGridEvaluatorNamespace.parseLocalDatefromString("2020-03-01").toString());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}.
   *
   * <ul>
   *   <li>When {@code 2020/03/01}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#parseLocalDatefromString(String)}
   */
  @Test
  @DisplayName(
      "Test parseLocalDatefromString(String); when '2020/03/01'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate ReportGridEvaluatorNamespace.parseLocalDatefromString(String)"})
  void testParseLocalDatefromString_when20200301_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ReportGridEvaluatorNamespace.parseLocalDatefromString("2020/03/01"));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

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
    builderResult.addFixedColumnDefinitions(
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
    ImmutableReportGridDefinition definition =
        builderResult
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
    CellResult actualMkResultResult = new ReportGridEvaluatorNamespace(definition).mkResult("42");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42", actualMkResultResult.optionText());
    assertEquals("42", actualMkResultResult.value());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String, String, String)} with {@code value},
   * {@code optionText}, {@code optionCode}.
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String, String, String)}
   */
  @Test
  @DisplayName("Test mkResult(String, String, String) with 'value', 'optionText', 'optionCode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String, String, String)"})
  void testMkResultWithValueOptionTextOptionCode() {
    // Arrange
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
    CellResult actualMkResultResult =
        new ReportGridEvaluatorNamespace(definition).mkResult("42", "Option Text", "Option Code");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.value());
    assertEquals("Option Code", actualMkResultResult.optionCode());
    assertEquals("Option Text", actualMkResultResult.optionText());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link ImmutableCellResult}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when '42'; then return ImmutableCellResult")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_when42_thenReturnImmutableCellResult() {
    // Arrange
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
    CellResult actualMkResultResult = new ReportGridEvaluatorNamespace(definition).mkResult("42");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.optionCode());
    assertEquals("42", actualMkResultResult.optionText());
    assertEquals("42", actualMkResultResult.value());
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#mkResult(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#mkResult(String)}
   */
  @Test
  @DisplayName("Test mkResult(String) with 'value'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellResult ReportGridEvaluatorNamespace.mkResult(String)"})
  void testMkResultWithValue_whenNull_thenReturnNull() {
    // Arrange
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

    // Act and Assert
    assertNull(new ReportGridEvaluatorNamespace(definition).mkResult(null));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])} with {@code Byte},
   * {@code Object[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  @DisplayName(
      "Test numToOutcome(Byte, Object[]) with 'Byte', 'Object[]'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Byte, Object[])"})
  void testNumToOutcomeWithByteObject_thenThrowIllegalStateException() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .numToOutcome((byte) 'A', new Object[] {"Outcomes"}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])} with {@code Byte},
   * {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Byte, Object[])}
   */
  @Test
  @DisplayName(
      "Test numToOutcome(Byte, Object[]) with 'Byte', 'Object[]'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Byte, Object[])"})
  void testNumToOutcomeWithByteObject_whenNull_thenReturnNull() {
    // Arrange
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

    // Act and Assert
    assertNull(
        new ReportGridEvaluatorNamespace(definition)
            .numToOutcome(
                (Byte) null,
                new Object[] {
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes"
                }));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])} with {@code Number},
   * {@code Object[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  @DisplayName(
      "Test numToOutcome(Number, Object[]) with 'Number', 'Object[]'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Number, Object[])"})
  void testNumToOutcomeWithNumberObject_thenThrowIllegalStateException() {
    // Arrange
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

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new ReportGridEvaluatorNamespace(definition)
                .numToOutcome(Integer.valueOf(1), new Object[] {"Outcomes"}));
  }

  /**
   * Test {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])} with {@code Number},
   * {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridEvaluatorNamespace#numToOutcome(Number, Object[])}
   */
  @Test
  @DisplayName(
      "Test numToOutcome(Number, Object[]) with 'Number', 'Object[]'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportGridEvaluatorNamespace.numToOutcome(Number, Object[])"})
  void testNumToOutcomeWithNumberObject_whenNull_thenReturnNull() {
    // Arrange
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

    // Act and Assert
    assertNull(
        new ReportGridEvaluatorNamespace(definition)
            .numToOutcome(
                (Number) null,
                new Object[] {
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes",
                  "Outcomes"
                }));
  }
}
