package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import org.finos.waltz.model.assessment_rating.AssessmentRatingDetail;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowChangeUnitViewItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#addAllAssessments(Iterable)}
   */
  @Test
  void testBuilderAddAllAssessments() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#addAssessments(AssessmentRatingDetail)}
   */
  @Test
  void testBuilderAddAssessments() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(mock(AssessmentRatingDetail.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#addAssessments(AssessmentRatingDetail[])}
   */
  @Test
  void testBuilderAddAssessments2() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessments(mock(AssessmentRatingDetail.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#assessments(Iterable)}
   */
  @Test
  void testBuilderAssessments() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#changeUnit(ChangeUnit)}
   */
  @Test
  void testBuilderChangeUnit() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeUnit(new ImmutableChangeUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#changeUnit(ChangeUnit)}
   */
  @Test
  void testBuilderChangeUnit2() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    builderResult.addAssessments(mock(AssessmentRatingDetail.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeUnit(new ImmutableChangeUnit.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#from(ChangeUnitViewItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    ChangeUnitViewItem instance = mock(ChangeUnitViewItem.class);
    when(instance.assessments()).thenReturn(new HashSet<>());
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#from(ChangeUnitViewItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    HashSet<AssessmentRatingDetail> assessmentRatingDetailSet = new HashSet<>();
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    ChangeUnitViewItem instance = mock(ChangeUnitViewItem.class);
    when(instance.assessments()).thenReturn(assessmentRatingDetailSet);
    when(instance.changeUnit()).thenReturn(new ImmutableChangeUnit.Json());

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

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
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#from(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    Optional<PhysicalSpecification> ofResult = Optional.of(mock(PhysicalSpecification.class));
    when(instance.physicalSpecification()).thenReturn(ofResult);
    when(instance.logicalFlow()).thenReturn(mock(LogicalFlow.class));
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableChangeUnit.Json json = new ImmutableChangeUnit.Json();
    when(instance.changeUnit()).thenReturn(json);

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).logicalFlow();
    verify(instance).physicalSpecification();
    assertSame(json, builderResult.build().changeUnit());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Builder#logicalFlow(LogicalFlow)}
   */
  @Test
  void testBuilderLogicalFlow() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Builder builderResult = ImmutablePhysicalFlowChangeUnitViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlow(mock(LogicalFlow.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem#copyOf(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    Optional<PhysicalSpecification> ofResult = Optional.of(mock(PhysicalSpecification.class));
    when(instance.physicalSpecification()).thenReturn(ofResult);
    when(instance.logicalFlow()).thenReturn(mock(LogicalFlow.class));
    when(instance.assessments()).thenReturn(new HashSet<>());
    ImmutableChangeUnit.Json json = new ImmutableChangeUnit.Json();
    when(instance.changeUnit()).thenReturn(json);

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualCopyOfResult = ImmutablePhysicalFlowChangeUnitViewItem
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).logicalFlow();
    verify(instance).physicalSpecification();
    assertTrue(actualCopyOfResult.assessments().isEmpty());
    assertSame(json, actualCopyOfResult.changeUnit());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem#copyOf(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentRatingDetail> assessmentRatingDetailSet = new HashSet<>();
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    Optional<PhysicalSpecification> ofResult = Optional.of(mock(PhysicalSpecification.class));
    when(instance.physicalSpecification()).thenReturn(ofResult);
    when(instance.logicalFlow()).thenReturn(mock(LogicalFlow.class));
    when(instance.assessments()).thenReturn(assessmentRatingDetailSet);
    ImmutableChangeUnit.Json json = new ImmutableChangeUnit.Json();
    when(instance.changeUnit()).thenReturn(json);

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualCopyOfResult = ImmutablePhysicalFlowChangeUnitViewItem
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).logicalFlow();
    verify(instance).physicalSpecification();
    assertEquals(1, actualCopyOfResult.assessments().size());
    assertSame(json, actualCopyOfResult.changeUnit());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem#copyOf(PhysicalFlowChangeUnitViewItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentRatingDetail> assessmentRatingDetailSet = new HashSet<>();
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    assessmentRatingDetailSet.add(mock(AssessmentRatingDetail.class));
    PhysicalFlowChangeUnitViewItem instance = mock(PhysicalFlowChangeUnitViewItem.class);
    Optional<PhysicalSpecification> ofResult = Optional.of(mock(PhysicalSpecification.class));
    when(instance.physicalSpecification()).thenReturn(ofResult);
    when(instance.logicalFlow()).thenReturn(mock(LogicalFlow.class));
    when(instance.assessments()).thenReturn(assessmentRatingDetailSet);
    ImmutableChangeUnit.Json json = new ImmutableChangeUnit.Json();
    when(instance.changeUnit()).thenReturn(json);

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualCopyOfResult = ImmutablePhysicalFlowChangeUnitViewItem
        .copyOf(instance);

    // Assert
    verify(instance).assessments();
    verify(instance).changeUnit();
    verify(instance).logicalFlow();
    verify(instance).physicalSpecification();
    assertEquals(assessmentRatingDetailSet, actualCopyOfResult.assessments());
    assertSame(json, actualCopyOfResult.changeUnit());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(ImmutablePhysicalFlowChangeUnitViewItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalFlowChangeUnitViewItem.Json json = new ImmutablePhysicalFlowChangeUnitViewItem.Json();
    ImmutableChangeUnit.Json changeUnit = new ImmutableChangeUnit.Json();
    json.setChangeUnit(changeUnit);
    json.setAssessments(null);
    json.setPhysicalSpecification(null);
    json.setLogicalFlow(mock(LogicalFlow.class));

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualFromJsonResult = ImmutablePhysicalFlowChangeUnitViewItem
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessments().isEmpty());
    assertSame(changeUnit, actualFromJsonResult.changeUnit());
    LogicalFlow expectedLogicalFlowResult = json.logicalFlow;
    assertSame(expectedLogicalFlowResult, actualFromJsonResult.logicalFlow());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem#fromJson(ImmutablePhysicalFlowChangeUnitViewItem.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentRatingDetail> assessments = new LinkedHashSet<>();
    assessments.add(mock(AssessmentRatingDetail.class));

    ImmutablePhysicalFlowChangeUnitViewItem.Json json = new ImmutablePhysicalFlowChangeUnitViewItem.Json();
    ImmutableChangeUnit.Json changeUnit = new ImmutableChangeUnit.Json();
    json.setChangeUnit(changeUnit);
    json.setAssessments(assessments);
    json.setPhysicalSpecification(null);
    json.setLogicalFlow(mock(LogicalFlow.class));

    // Act
    ImmutablePhysicalFlowChangeUnitViewItem actualFromJsonResult = ImmutablePhysicalFlowChangeUnitViewItem
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessments().size());
    assertSame(changeUnit, actualFromJsonResult.changeUnit());
    LogicalFlow expectedLogicalFlowResult = json.logicalFlow;
    assertSame(expectedLogicalFlowResult, actualFromJsonResult.logicalFlow());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Json#assessments()}
   */
  @Test
  void testJsonAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowChangeUnitViewItem.Json()).assessments());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Json#changeUnit()}
   */
  @Test
  void testJsonChangeUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowChangeUnitViewItem.Json()).changeUnit());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Json#logicalFlow()}
   */
  @Test
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowChangeUnitViewItem.Json()).logicalFlow());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowChangeUnitViewItem.Json actualJson = new ImmutablePhysicalFlowChangeUnitViewItem.Json();

    // Assert
    assertNull(actualJson.changeUnit);
    assertNull(actualJson.logicalFlow);
    assertFalse(actualJson.physicalSpecification.isPresent());
    assertTrue(actualJson.assessments.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowChangeUnitViewItem.Json#physicalSpecification()}
   */
  @Test
  void testJsonPhysicalSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowChangeUnitViewItem.Json()).physicalSpecification());
  }
}
