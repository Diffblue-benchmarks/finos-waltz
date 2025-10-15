package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunCompletionRateDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRunCompletionRate Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate actualImmutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Assert
    assertEquals(0, actualImmutableSurveyRunCompletionRate.completedCount());
    assertEquals(0, actualImmutableSurveyRunCompletionRate.inProgressCount());
    assertEquals(0, actualImmutableSurveyRunCompletionRate.notStartedCount());
    assertEquals(0, actualImmutableSurveyRunCompletionRate.totalCount());
    assertEquals(1L, actualImmutableSurveyRunCompletionRate.surveyRunId());
  }

  /**
   * Test Builder {@link Builder#completedCount(int)}.
   *
   * <p>Method under test: {@link Builder#completedCount(int)}
   */
  @Test
  @DisplayName("Test Builder completedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.completedCount(int)"})
  void testBuilderCompletedCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    Builder actualCompletedCountResult = builderResult.completedCount(3);

    // Assert
    assertSame(builderResult, actualCompletedCountResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunCompletionRate)}.
   *
   * <ul>
   *   <li>Then builder build is builder surveyRunId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyRunCompletionRate); then builder build is builder surveyRunId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunCompletionRate)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderSurveyRunIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();
    ImmutableSurveyRunCompletionRate instance =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRunCompletionRate actualImmutableSurveyRunCompletionRate = builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunCompletionRate);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inProgressCount(int)}.
   *
   * <p>Method under test: {@link Builder#inProgressCount(int)}
   */
  @Test
  @DisplayName("Test Builder inProgressCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inProgressCount(int)"})
  void testBuilderInProgressCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    Builder actualInProgressCountResult = builderResult.inProgressCount(3);

    // Assert
    assertSame(builderResult, actualInProgressCountResult);
  }

  /**
   * Test Builder {@link Builder#notStartedCount(int)}.
   *
   * <p>Method under test: {@link Builder#notStartedCount(int)}
   */
  @Test
  @DisplayName("Test Builder notStartedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.notStartedCount(int)"})
  void testBuilderNotStartedCount() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    Builder actualNotStartedCountResult = builderResult.notStartedCount(3);

    // Assert
    assertSame(builderResult, actualNotStartedCountResult);
  }

  /**
   * Test Builder {@link Builder#surveyRunId(long)}.
   *
   * <p>Method under test: {@link Builder#surveyRunId(long)}
   */
  @Test
  @DisplayName("Test Builder surveyRunId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyRunId(long)"})
  void testBuilderSurveyRunId() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunCompletionRate.builder();

    // Act
    Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

    // Assert
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate = builderResult.build();
    assertEquals(0, immutableSurveyRunCompletionRate.completedCount());
    assertEquals(0, immutableSurveyRunCompletionRate.inProgressCount());
    assertEquals(0, immutableSurveyRunCompletionRate.notStartedCount());
    assertEquals(0, immutableSurveyRunCompletionRate.totalCount());
    assertEquals(1L, immutableSurveyRunCompletionRate.surveyRunId());
    assertSame(builderResult, actualSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#completedCount()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#completedCount()}
   */
  @Test
  @DisplayName("Test completedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableSurveyRunCompletionRate.completedCount()"})
  void testCompletedCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().completedCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#copyOf(SurveyRunCompletionRate)}.
   *
   * <ul>
   *   <li>When builder surveyRunId one build.
   *   <li>Then return completedCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#copyOf(SurveyRunCompletionRate)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyRunCompletionRate); when builder surveyRunId one build; then return completedCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.copyOf(SurveyRunCompletionRate)"
  })
  void testCopyOf_whenBuilderSurveyRunIdOneBuild_thenReturnCompletedCountIsZero() {
    // Arrange
    ImmutableSurveyRunCompletionRate instance =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    ImmutableSurveyRunCompletionRate actualCopyOfResult =
        ImmutableSurveyRunCompletionRate.copyOf(instance);

    // Assert
    assertEquals(0, actualCopyOfResult.completedCount());
    assertEquals(0, actualCopyOfResult.inProgressCount());
    assertEquals(0, actualCopyOfResult.notStartedCount());
    assertEquals(0, actualCopyOfResult.totalCount());
    assertEquals(1L, actualCopyOfResult.surveyRunId());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#equals(Object)}, and {@link
   * ImmutableSurveyRunCompletionRate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCompletionRate#equals(Object)}
   *   <li>{@link ImmutableSurveyRunCompletionRate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCompletionRate.equals(Object)",
    "int ImmutableSurveyRunCompletionRate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate2 =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act and Assert
    assertEquals(immutableSurveyRunCompletionRate, immutableSurveyRunCompletionRate2);
    assertEquals(
        immutableSurveyRunCompletionRate.hashCode(), immutableSurveyRunCompletionRate2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#equals(Object)}, and {@link
   * ImmutableSurveyRunCompletionRate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCompletionRate#equals(Object)}
   *   <li>{@link ImmutableSurveyRunCompletionRate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCompletionRate.equals(Object)",
    "int ImmutableSurveyRunCompletionRate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act and Assert
    assertEquals(immutableSurveyRunCompletionRate, immutableSurveyRunCompletionRate);
    int expectedHashCodeResult = immutableSurveyRunCompletionRate.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRunCompletionRate.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCompletionRate.equals(Object)",
    "int ImmutableSurveyRunCompletionRate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyRunCompletionRate,
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCompletionRate.equals(Object)",
    "int ImmutableSurveyRunCompletionRate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunCompletionRate.equals(Object)",
    "int ImmutableSurveyRunCompletionRate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build(),
        "Different type to ImmutableSurveyRunCompletionRate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunCompletionRate#toString()}
   *   <li>{@link ImmutableSurveyRunCompletionRate#surveyRunId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableSurveyRunCompletionRate.surveyRunId()",
    "String ImmutableSurveyRunCompletionRate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    String actualToStringResult = immutableSurveyRunCompletionRate.toString();

    // Assert
    assertEquals(
        "SurveyRunCompletionRate{surveyRunId=1, notStartedCount=0, inProgressCount=0, completedCount=0,"
            + " totalCount=0}",
        actualToStringResult);
    assertEquals(1L, immutableSurveyRunCompletionRate.surveyRunId());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#inProgressCount()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#inProgressCount()}
   */
  @Test
  @DisplayName("Test inProgressCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableSurveyRunCompletionRate.inProgressCount()"})
  void testInProgressCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().inProgressCount());
  }

  /**
   * Test Json {@link Json#completedCount()}.
   *
   * <p>Method under test: {@link Json#completedCount()}
   */
  @Test
  @DisplayName("Test Json completedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.completedCount()"})
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().completedCount());
  }

  /**
   * Test Json {@link Json#inProgressCount()}.
   *
   * <p>Method under test: {@link Json#inProgressCount()}
   */
  @Test
  @DisplayName("Test Json inProgressCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.inProgressCount()"})
  void testJsonInProgressCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inProgressCount());
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
    assertEquals(0, actualJson.completedCount);
    assertEquals(0, actualJson.inProgressCount);
    assertEquals(0, actualJson.notStartedCount);
    assertEquals(0L, actualJson.surveyRunId);
    assertFalse(actualJson.completedCountIsSet);
    assertFalse(actualJson.inProgressCountIsSet);
    assertFalse(actualJson.notStartedCountIsSet);
    assertFalse(actualJson.surveyRunIdIsSet);
  }

  /**
   * Test Json {@link Json#notStartedCount()}.
   *
   * <p>Method under test: {@link Json#notStartedCount()}
   */
  @Test
  @DisplayName("Test Json notStartedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.notStartedCount()"})
  void testJsonNotStartedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().notStartedCount());
  }

  /**
   * Test Json {@link Json#setCompletedCount(int)}.
   *
   * <p>Method under test: {@link Json#setCompletedCount(int)}
   */
  @Test
  @DisplayName("Test Json setCompletedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCompletedCount(int)"})
  void testJsonSetCompletedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCompletedCount(3);

    // Assert
    assertEquals(3, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Test Json {@link Json#setInProgressCount(int)}.
   *
   * <p>Method under test: {@link Json#setInProgressCount(int)}
   */
  @Test
  @DisplayName("Test Json setInProgressCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setInProgressCount(int)"})
  void testJsonSetInProgressCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInProgressCount(3);

    // Assert
    assertEquals(3, json.inProgressCount);
    assertTrue(json.inProgressCountIsSet);
  }

  /**
   * Test Json {@link Json#setNotStartedCount(int)}.
   *
   * <p>Method under test: {@link Json#setNotStartedCount(int)}
   */
  @Test
  @DisplayName("Test Json setNotStartedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setNotStartedCount(int)"})
  void testJsonSetNotStartedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setNotStartedCount(3);

    // Assert
    assertEquals(3, json.notStartedCount);
    assertTrue(json.notStartedCountIsSet);
  }

  /**
   * Test Json {@link Json#setSurveyRunId(long)}.
   *
   * <p>Method under test: {@link Json#setSurveyRunId(long)}
   */
  @Test
  @DisplayName("Test Json setSurveyRunId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSurveyRunId(long)"})
  void testJsonSetSurveyRunId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSurveyRunId(1L);

    // Assert
    assertEquals(1L, json.surveyRunId);
    assertTrue(json.surveyRunIdIsSet);
  }

  /**
   * Test Json {@link Json#surveyRunId()}.
   *
   * <p>Method under test: {@link Json#surveyRunId()}
   */
  @Test
  @DisplayName("Test Json surveyRunId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.surveyRunId()"})
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyRunId());
  }

  /**
   * Test Json {@link Json#totalCount()}.
   *
   * <p>Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#notStartedCount()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#notStartedCount()}
   */
  @Test
  @DisplayName("Test notStartedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableSurveyRunCompletionRate.notStartedCount()"})
  void testNotStartedCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().notStartedCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#totalCount()}.
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#totalCount()}
   */
  @Test
  @DisplayName("Test totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableSurveyRunCompletionRate.totalCount()"})
  void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(
        0, ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().totalCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withCompletedCount(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return inProgressCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withCompletedCount(int)}
   */
  @Test
  @DisplayName("Test withCompletedCount(int); when forty-two; then return inProgressCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withCompletedCount(int)"
  })
  void testWithCompletedCount_whenFortyTwo_thenReturnInProgressCountIsZero() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate actualWithCompletedCountResult =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().withCompletedCount(42);

    // Assert
    assertEquals(0, actualWithCompletedCountResult.inProgressCount());
    assertEquals(0, actualWithCompletedCountResult.notStartedCount());
    assertEquals(1L, actualWithCompletedCountResult.surveyRunId());
    assertEquals(42, actualWithCompletedCountResult.completedCount());
    assertEquals(42, actualWithCompletedCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withCompletedCount(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return builder surveyRunId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withCompletedCount(int)}
   */
  @Test
  @DisplayName("Test withCompletedCount(int); when zero; then return builder surveyRunId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withCompletedCount(int)"
  })
  void testWithCompletedCount_whenZero_thenReturnBuilderSurveyRunIdOneBuild() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    ImmutableSurveyRunCompletionRate actualWithCompletedCountResult =
        immutableSurveyRunCompletionRate.withCompletedCount(0);

    // Assert
    assertSame(immutableSurveyRunCompletionRate, actualWithCompletedCountResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withInProgressCount(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return completedCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withInProgressCount(int)}
   */
  @Test
  @DisplayName("Test withInProgressCount(int); when forty-two; then return completedCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withInProgressCount(int)"
  })
  void testWithInProgressCount_whenFortyTwo_thenReturnCompletedCountIsZero() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate actualWithInProgressCountResult =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().withInProgressCount(42);

    // Assert
    assertEquals(0, actualWithInProgressCountResult.completedCount());
    assertEquals(0, actualWithInProgressCountResult.notStartedCount());
    assertEquals(1L, actualWithInProgressCountResult.surveyRunId());
    assertEquals(42, actualWithInProgressCountResult.inProgressCount());
    assertEquals(42, actualWithInProgressCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withInProgressCount(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return builder surveyRunId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withInProgressCount(int)}
   */
  @Test
  @DisplayName(
      "Test withInProgressCount(int); when zero; then return builder surveyRunId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withInProgressCount(int)"
  })
  void testWithInProgressCount_whenZero_thenReturnBuilderSurveyRunIdOneBuild() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    ImmutableSurveyRunCompletionRate actualWithInProgressCountResult =
        immutableSurveyRunCompletionRate.withInProgressCount(0);

    // Assert
    assertSame(immutableSurveyRunCompletionRate, actualWithInProgressCountResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withNotStartedCount(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return completedCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withNotStartedCount(int)}
   */
  @Test
  @DisplayName("Test withNotStartedCount(int); when forty-two; then return completedCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withNotStartedCount(int)"
  })
  void testWithNotStartedCount_whenFortyTwo_thenReturnCompletedCountIsZero() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate actualWithNotStartedCountResult =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().withNotStartedCount(42);

    // Assert
    assertEquals(0, actualWithNotStartedCountResult.completedCount());
    assertEquals(0, actualWithNotStartedCountResult.inProgressCount());
    assertEquals(1L, actualWithNotStartedCountResult.surveyRunId());
    assertEquals(42, actualWithNotStartedCountResult.notStartedCount());
    assertEquals(42, actualWithNotStartedCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withNotStartedCount(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return builder surveyRunId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withNotStartedCount(int)}
   */
  @Test
  @DisplayName(
      "Test withNotStartedCount(int); when zero; then return builder surveyRunId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withNotStartedCount(int)"
  })
  void testWithNotStartedCount_whenZero_thenReturnBuilderSurveyRunIdOneBuild() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build();

    // Act
    ImmutableSurveyRunCompletionRate actualWithNotStartedCountResult =
        immutableSurveyRunCompletionRate.withNotStartedCount(0);

    // Assert
    assertSame(immutableSurveyRunCompletionRate, actualWithNotStartedCountResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withSurveyRunId(long)}.
   *
   * <ul>
   *   <li>Then return builder surveyRunId forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withSurveyRunId(long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(long); then return builder surveyRunId forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withSurveyRunId(long)"
  })
  void testWithSurveyRunId_thenReturnBuilderSurveyRunIdFortyTwoBuild() {
    // Arrange
    ImmutableSurveyRunCompletionRate immutableSurveyRunCompletionRate =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(42L).build();

    // Act
    ImmutableSurveyRunCompletionRate actualWithSurveyRunIdResult =
        immutableSurveyRunCompletionRate.withSurveyRunId(42L);

    // Assert
    assertSame(immutableSurveyRunCompletionRate, actualWithSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyRunCompletionRate#withSurveyRunId(long)}.
   *
   * <ul>
   *   <li>Then return completedCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunCompletionRate#withSurveyRunId(long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(long); then return completedCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunCompletionRate ImmutableSurveyRunCompletionRate.withSurveyRunId(long)"
  })
  void testWithSurveyRunId_thenReturnCompletedCountIsZero() {
    // Arrange and Act
    ImmutableSurveyRunCompletionRate actualWithSurveyRunIdResult =
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build().withSurveyRunId(42L);

    // Assert
    assertEquals(0, actualWithSurveyRunIdResult.completedCount());
    assertEquals(0, actualWithSurveyRunIdResult.inProgressCount());
    assertEquals(0, actualWithSurveyRunIdResult.notStartedCount());
    assertEquals(0, actualWithSurveyRunIdResult.totalCount());
    assertEquals(42L, actualWithSurveyRunIdResult.surveyRunId());
  }
}
