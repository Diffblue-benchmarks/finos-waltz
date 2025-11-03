package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.assessment_rating.AssessmentRatingDetail;
import org.finos.waltz.model.change_unit.ImmutablePhysicalFlowChangeUnitViewItem.Builder;
import org.finos.waltz.model.change_unit.ImmutablePhysicalFlowChangeUnitViewItem.Json;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowChangeUnitViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessments(Iterable)"})
  void testBuilderAddAllAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessments(AssessmentRatingDetail)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessments(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder addAssessments(AssessmentRatingDetail) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessments(AssessmentRatingDetail)"})
  void testBuilderAddAssessmentsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(mock(AssessmentRatingDetail.class)));
  }

  /**
   * Test Builder {@link Builder#addAssessments(AssessmentRatingDetail[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessments(AssessmentRatingDetail[])}
   */
  @Test
  @DisplayName("Test Builder addAssessments(AssessmentRatingDetail[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessments(AssessmentRatingDetail[])"})
  void testBuilderAddAssessmentsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(mock(AssessmentRatingDetail.class)));
  }

  /**
   * Test Builder {@link Builder#assessments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessments(Iterable)"})
  void testBuilderAssessments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#changeUnit(ChangeUnit)}.
   * <ul>
   *   <li>When {@link ImmutableChangeUnit.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeUnit(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder changeUnit(ChangeUnit); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeUnit(ChangeUnit)"})
  void testBuilderChangeUnit_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeUnit(new ImmutableChangeUnit.Json()));
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnitViewItem)} with {@code ChangeUnitViewItem}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link AssessmentRatingDetail}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnitViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnitViewItem) with 'ChangeUnitViewItem'; given HashSet() add AssessmentRatingDetail")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnitViewItem)"})
  void testBuilderFromWithChangeUnitViewItem_givenHashSetAddAssessmentRatingDetail() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    HashSet<AssessmentRatingDetail> assessmentRatingDetailSet = new HashSet<>();
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    ChangeUnitViewItem instance = mock(ChangeUnitViewItem.class);
    when(instance.assessments()).thenReturn(assessmentRatingDetailSet);
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnitViewItem)} with {@code ChangeUnitViewItem}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeUnitViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnitViewItem) with 'ChangeUnitViewItem'; given HashSet(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeUnitViewItem)"})
  void testBuilderFromWithChangeUnitViewItem_givenHashSet_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    ChangeUnitViewItem instance = mock(ChangeUnitViewItem.class);
    when(instance.assessments()).thenReturn(new HashSet<>());
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowChangeUnitViewItem)} with {@code PhysicalFlowChangeUnitViewItem}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowChangeUnitViewItem) with 'PhysicalFlowChangeUnitViewItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowChangeUnitViewItem)"})
  void testBuilderFromWithPhysicalFlowChangeUnitViewItem() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    HashSet<AssessmentRatingDetail> assessmentRatingDetailSet = new HashSet<>();
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    when(instance.physicalSpecification()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessments()).thenReturn(assessmentRatingDetailSet);
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).physicalSpecification();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowChangeUnitViewItem)} with {@code PhysicalFlowChangeUnitViewItem}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowChangeUnitViewItem) with 'PhysicalFlowChangeUnitViewItem'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowChangeUnitViewItem)"})
  void testBuilderFromWithPhysicalFlowChangeUnitViewItem2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    Optional<PhysicalSpecification> ofResult = Optional.of(mock(PhysicalSpecification.class));
    when(instance.physicalSpecification()).thenReturn(ofResult);
    when(instance.logicalFlow()).thenReturn(mock(LogicalFlow.class));
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableChangeUnit.Json json = new ImmutableChangeUnit.Json();
    when(instance.changeUnit()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).logicalFlow();
    verify(instance).physicalSpecification();
    assertSame(json, builderResult.build().changeUnit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowChangeUnitViewItem)} with {@code PhysicalFlowChangeUnitViewItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowChangeUnitViewItem) with 'PhysicalFlowChangeUnitViewItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowChangeUnitViewItem)"})
  void testBuilderFromWithPhysicalFlowChangeUnitViewItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    when(instance.physicalSpecification()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessments()).thenReturn(new HashSet<>());
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).physicalSpecification();
  }

  /**
   * Test Builder {@link Builder#logicalFlow(LogicalFlow)}.
   * <ul>
   *   <li>When {@link LogicalFlow}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#logicalFlow(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder logicalFlow(LogicalFlow); when LogicalFlow; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlow(LogicalFlow)"})
  void testBuilderLogicalFlow_whenLogicalFlow_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlow(mock(LogicalFlow.class)));
  }

  /**
   * Test Builder {@link Builder#physicalSpecification(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#physicalSpecification(Optional)}
   */
  @Test
  @DisplayName("Test Builder physicalSpecification(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.physicalSpecification(Optional)"})
  void testBuilderPhysicalSpecificationWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    Optional<? extends PhysicalSpecification> physicalSpecification = Optional.of(mock(PhysicalSpecification.class));

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecification(physicalSpecification));
  }

  /**
   * Test Json {@link Json#assessments()}.
   * <p>
   * Method under test: {@link Json#assessments()}
   */
  @Test
  @DisplayName("Test Json assessments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.assessments()"})
  void testJsonAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessments());
  }

  /**
   * Test Json {@link Json#changeUnit()}.
   * <p>
   * Method under test: {@link Json#changeUnit()}
   */
  @Test
  @DisplayName("Test Json changeUnit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeUnit Json.changeUnit()"})
  void testJsonChangeUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeUnit());
  }

  /**
   * Test Json {@link Json#logicalFlow()}.
   * <p>
   * Method under test: {@link Json#logicalFlow()}
   */
  @Test
  @DisplayName("Test Json logicalFlow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlow Json.logicalFlow()"})
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlow());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.changeUnit);
    assertNull(actualJson.logicalFlow);
    assertFalse(actualJson.physicalSpecification.isPresent());
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Test Json {@link Json#physicalSpecification()}.
   * <p>
   * Method under test: {@link Json#physicalSpecification()}
   */
  @Test
  @DisplayName("Test Json physicalSpecification()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.physicalSpecification()"})
  void testJsonPhysicalSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecification());
  }
}
