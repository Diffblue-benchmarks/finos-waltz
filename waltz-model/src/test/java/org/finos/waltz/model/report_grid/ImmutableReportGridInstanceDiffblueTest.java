package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridInstanceDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCellData(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddAllCellDataResult = builderResult.addAllCellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingSchemeItems(Iterable)"})
  void testBuilderAddAllRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddAllRatingSchemeItemsResult =
        builderResult.addAllRatingSchemeItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addAllSubjects(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllSubjects(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSubjects(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSubjects(Iterable)"})
  void testBuilderAddAllSubjects_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddAllSubjectsResult = builderResult.addAllSubjects(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllSubjectsResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ReportGridCell)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridCell.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(ReportGridCell) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(ReportGridCell)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(ReportGridCell[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridCell.Json} (default constructor).
   *   <li>Then builder build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCellData(ReportGridCell[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCellData(ReportGridCell[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCellData(ReportGridCell[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableReportGridCell.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
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

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
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

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addSubjects(ReportSubject)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportSubject.Json} (default constructor).
   *   <li>Then builder build subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSubjects(ReportSubject)}
   */
  @Test
  @DisplayName(
      "Test Builder addSubjects(ReportSubject) with 'element'; when Json (default constructor); then builder build subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSubjects(ReportSubject)"})
  void testBuilderAddSubjectsWithElement_whenJson_thenBuilderBuildSubjectsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddSubjectsResult = builderResult.addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Test Builder {@link Builder#addSubjects(ReportSubject[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportSubject.Json} (default constructor).
   *   <li>Then builder build subjects size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSubjects(ReportSubject[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSubjects(ReportSubject[]) with 'elements'; when Json (default constructor); then builder build subjects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSubjects(ReportSubject[])"})
  void testBuilderAddSubjectsWithElements_whenJson_thenBuilderBuildSubjectsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualAddSubjectsResult = builderResult.addSubjects(new ImmutableReportSubject.Json());

    // Assert
    assertEquals(1, builderResult.build().subjects().size());
    assertSame(builderResult, actualAddSubjectsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableReportGridInstance.builder().build().cellData().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cellData(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualCellDataResult = builderResult.cellData(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCellDataResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   *
   * <ul>
   *   <li>Then return build cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInstance); then return build cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_thenReturnBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    Builder builderResult2 = ImmutableReportGridInstance.builder();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));
    builderResult2.addCellData(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    ImmutableReportSubject.Builder builderResult3 = ImmutableReportSubject.builder();
    builderResult2.addSubjects(
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
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance immutableReportGridInstance = builderResult.from(instance).build();
    assertEquals(1, immutableReportGridInstance.cellData().size());
    assertEquals(1, immutableReportGridInstance.subjects().size());
    assertTrue(immutableReportGridInstance.ratingSchemeItems().isEmpty());
    ImmutableReportGridInstance actualImmutableReportGridInstance = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInstance);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   *
   * <ul>
   *   <li>Then return build ratingSchemeItems is build cellData.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridInstance); then return build ratingSchemeItems is build cellData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsIsBuildCellData() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    Builder builderResult2 = ImmutableReportGridInstance.builder();

    ImmutableReportSubject.Builder builderResult3 = ImmutableReportSubject.builder();
    builderResult2.addSubjects(
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
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance immutableReportGridInstance = builderResult.from(instance).build();
    assertEquals(1, immutableReportGridInstance.subjects().size());
    Set<ReportGridCell> cellDataResult = immutableReportGridInstance.cellData();
    assertTrue(cellDataResult.isEmpty());
    ImmutableReportGridInstance actualImmutableReportGridInstance = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInstance);
    assertSame(cellDataResult, immutableReportGridInstance.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   *
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridInstance); then return build ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    Builder builderResult2 = ImmutableReportGridInstance.builder();
    builderResult2.addRatingSchemeItems(
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

    ImmutableReportSubject.Builder builderResult3 = ImmutableReportSubject.builder();
    builderResult2.addSubjects(
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
    ImmutableReportGridInstance instance = builderResult2.build();

    // Act and Assert
    ImmutableReportGridInstance immutableReportGridInstance = builderResult.from(instance).build();
    assertEquals(1, immutableReportGridInstance.ratingSchemeItems().size());
    assertEquals(1, immutableReportGridInstance.subjects().size());
    assertTrue(immutableReportGridInstance.cellData().isEmpty());
    ImmutableReportGridInstance actualImmutableReportGridInstance = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInstance);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInstance)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build subjects is build cellData.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridInstance); when builder build; then return build subjects is build cellData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInstance)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildSubjectsIsBuildCellData() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();

    // Act and Assert
    ImmutableReportGridInstance immutableReportGridInstance = builderResult.from(instance).build();
    Set<ReportGridCell> cellDataResult = immutableReportGridInstance.cellData();
    assertTrue(cellDataResult.isEmpty());
    ImmutableReportGridInstance actualImmutableReportGridInstance = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInstance);
    assertSame(cellDataResult, immutableReportGridInstance.ratingSchemeItems());
    assertSame(cellDataResult, immutableReportGridInstance.subjects());
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeItems(Iterable)"})
  void testBuilderRatingSchemeItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualRatingSchemeItemsResult = builderResult.ratingSchemeItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#subjects(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subjects(Iterable)}
   */
  @Test
  @DisplayName("Test Builder subjects(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjects(Iterable)"})
  void testBuilderSubjects_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    // Act
    Builder actualSubjectsResult = builderResult.subjects(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualSubjectsResult);
  }

  /**
   * Test {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#copyOf(ReportGridInstance)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridInstance); when builder build; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInstance ImmutableReportGridInstance.copyOf(ReportGridInstance)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnCellDataEmpty() {
    // Arrange
    ImmutableReportGridInstance instance = ImmutableReportGridInstance.builder().build();

    // Act
    ImmutableReportGridInstance actualCopyOfResult = ImmutableReportGridInstance.copyOf(instance);

    // Assert
    Set<ReportGridCell> cellDataResult = actualCopyOfResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualCopyOfResult.ratingSchemeItems());
    assertSame(cellDataResult, actualCopyOfResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}, and {@link
   * ImmutableReportGridInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#equals(Object)}
   *   <li>{@link ImmutableReportGridInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();
    ImmutableReportGridInstance immutableReportGridInstance2 =
        ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertEquals(immutableReportGridInstance, immutableReportGridInstance2);
    assertEquals(immutableReportGridInstance.hashCode(), immutableReportGridInstance2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}, and {@link
   * ImmutableReportGridInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#equals(Object)}
   *   <li>{@link ImmutableReportGridInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();

    // Act and Assert
    assertEquals(immutableReportGridInstance, immutableReportGridInstance);
    int expectedHashCodeResult = immutableReportGridInstance.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridInstance.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

    ImmutableReportSubject.Builder builderResult2 = ImmutableReportSubject.builder();
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableReportGridInstance.builder().build());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableReportGridInstance.builder().build());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableReportGridInstance.builder();

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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableReportGridInstance.builder().build());
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableReportGridInstance.builder().build(), null);
  }

  /**
   * Test {@link ImmutableReportGridInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInstance.equals(Object)",
    "int ImmutableReportGridInstance.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridInstance.builder().build(),
        "Different type to ImmutableReportGridInstance");
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet(); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenHashSet_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();
    subjects.add(new ImmutableReportSubject.Json());

    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableReportGridCell.Json());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(new HashSet<>());
    json.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) CellData is {@code null}.
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) CellData is 'null'; then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonCellDataIsNull_thenReturnCellDataEmpty() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();
    subjects.add(new ImmutableReportSubject.Json());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(new HashSet<>());
    json.setCellData(null);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    Set<ReportGridCell> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    subjects.add(
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

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));
    cellData.add(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertEquals(1, actualFromJsonResult.subjects().size());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return subjects size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return subjects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_thenReturnSubjectsSizeIsTwo() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    subjects.add(
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
    subjects.add(new ImmutableReportSubject.Json());

    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableReportGridCell.Json());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(new HashSet<>());
    json.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertEquals(2, actualFromJsonResult.subjects().size());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RatingSchemeItems is {@code null}.
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RatingSchemeItems is 'null'; then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_whenJsonRatingSchemeItemsIsNull_thenReturnCellDataSizeIsOne() {
    // Arrange
    LinkedHashSet<ReportSubject> subjects = new LinkedHashSet<>();
    subjects.add(new ImmutableReportSubject.Json());

    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    cellData.add(new ImmutableReportGridCell.Json());

    Json json = new Json();
    json.setSubjects(subjects);
    json.setRatingSchemeItems(null);
    json.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Subjects is {@code null}.
   *   <li>Then return subjects is {@link ImmutableReportGridCell.Json} (default constructor) {@link
   *       ImmutableReportGridCell.Json#ratingIdValues}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Subjects is 'null'; then return subjects is Json (default constructor) ratingIdValues")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_whenJsonSubjectsIsNull_thenReturnSubjectsIsJsonRatingIdValues() {
    // Arrange
    LinkedHashSet<ReportGridCell> cellData = new LinkedHashSet<>();
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setSubjects(null);
    json2.setRatingSchemeItems(new HashSet<>());
    json2.setCellData(cellData);

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json2);

    // Assert
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
    Set<Long> expectedSubjectsResult = json.ratingIdValues;
    assertSame(expectedSubjectsResult, actualFromJsonResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return ratingSchemeItems is {@link Json} (default constructor) {@link
   *       Json#subjects}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return ratingSchemeItems is Json (default constructor) subjects")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInstance ImmutableReportGridInstance.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRatingSchemeItemsIsJsonSubjects() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableReportGridInstance actualFromJsonResult = ImmutableReportGridInstance.fromJson(json);

    // Assert
    Set<ReportSubject> reportSubjectSet = json.subjects;
    assertSame(reportSubjectSet, actualFromJsonResult.ratingSchemeItems());
    assertSame(reportSubjectSet, actualFromJsonResult.subjects());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInstance#toString()}
   *   <li>{@link ImmutableReportGridInstance#cellData()}
   *   <li>{@link ImmutableReportGridInstance#ratingSchemeItems()}
   *   <li>{@link ImmutableReportGridInstance#subjects()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableReportGridInstance.cellData()",
    "Set ImmutableReportGridInstance.ratingSchemeItems()",
    "Set ImmutableReportGridInstance.subjects()",
    "String ImmutableReportGridInstance.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();

    // Act
    String actualToStringResult = immutableReportGridInstance.toString();
    Set<ReportGridCell> actualCellDataResult = immutableReportGridInstance.cellData();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableReportGridInstance.ratingSchemeItems();
    Set<ReportSubject> actualSubjectsResult = immutableReportGridInstance.subjects();

    // Assert
    assertEquals(
        "ReportGridInstance{subjects=[], ratingSchemeItems=[], cellData=[]}", actualToStringResult);
    assertTrue(actualCellDataResult.isEmpty());
    assertSame(actualCellDataResult, actualRatingSchemeItemsResult);
    assertSame(actualCellDataResult, actualSubjectsResult);
  }

  /**
   * Test Json {@link Json#cellData()}.
   *
   * <p>Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.cellData()"})
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellData());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
    assertTrue(actualJson.subjects.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingSchemeItems()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItems());
  }

  /**
   * Test Json {@link Json#subjects()}.
   *
   * <p>Method under test: {@link Json#subjects()}
   */
  @Test
  @DisplayName("Test Json subjects()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.subjects()"})
  void testJsonSubjects() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withCellData(ReportGridCell[])} with {@code
   * ReportGridCell[]}.
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#withCellData(ReportGridCell[])}
   */
  @Test
  @DisplayName("Test withCellData(ReportGridCell[]) with 'ReportGridCell[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInstance ImmutableReportGridInstance.withCellData(ReportGridCell[])"
  })
  void testWithCellDataWithReportGridCell() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridInstance actualWithCellDataResult =
        immutableReportGridInstance.withCellData(
            numberValueResult
                .addAllOptions(new ArrayList<>())
                .subjectId(1L)
                .textValue("42")
                .build());

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    Set<RatingSchemeItem> ratingSchemeItemsResult = actualWithCellDataResult.ratingSchemeItems();
    assertTrue(ratingSchemeItemsResult.isEmpty());
    assertSame(ratingSchemeItemsResult, actualWithCellDataResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withRatingSchemeItems(RatingSchemeItem[])} with {@code
   * RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridInstance#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInstance ImmutableReportGridInstance.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();

    // Act
    ImmutableReportGridInstance actualWithRatingSchemeItemsResult =
        immutableReportGridInstance.withRatingSchemeItems(
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

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<ReportGridCell> cellDataResult = actualWithRatingSchemeItemsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithRatingSchemeItemsResult.subjects());
  }

  /**
   * Test {@link ImmutableReportGridInstance#withSubjects(ReportSubject[])} with {@code
   * ReportSubject[]}.
   *
   * <p>Method under test: {@link ImmutableReportGridInstance#withSubjects(ReportSubject[])}
   */
  @Test
  @DisplayName("Test withSubjects(ReportSubject[]) with 'ReportSubject[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInstance ImmutableReportGridInstance.withSubjects(ReportSubject[])"
  })
  void testWithSubjectsWithReportSubject() {
    // Arrange
    ImmutableReportGridInstance immutableReportGridInstance =
        ImmutableReportGridInstance.builder().build();

    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();

    // Act
    ImmutableReportGridInstance actualWithSubjectsResult =
        immutableReportGridInstance.withSubjects(
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

    // Assert
    assertEquals(1, actualWithSubjectsResult.subjects().size());
    Set<ReportGridCell> cellDataResult = actualWithSubjectsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithSubjectsResult.ratingSchemeItems());
  }
}
