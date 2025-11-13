package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.survey.ImmutableCopySurveyResponsesCommand.Builder;
import org.finos.waltz.model.survey.ImmutableCopySurveyResponsesCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCopySurveyResponsesCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllQuestionIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build questionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllQuestionIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllQuestionIds(Iterable); given one; then return build questionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllQuestionIds(Iterable)"})
  void testBuilderAddAllQuestionIds_givenOne_thenReturnBuildQuestionIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> questionIdsResult = builderResult.addAllQuestionIds(elements).build().questionIds();
    assertEquals(1, questionIdsResult.size());
    List<Long> questionIdsResult2 = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult2.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertEquals(1L, questionIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#addAllQuestionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllQuestionIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllQuestionIds(Iterable)"})
  void testBuilderAddAllQuestionIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddAllQuestionIdsResult = builderResult.addAllQuestionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllTargetSurveyInstanceIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllTargetSurveyInstanceIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTargetSurveyInstanceIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTargetSurveyInstanceIds(Iterable)"})
  void testBuilderAddAllTargetSurveyInstanceIds() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllTargetSurveyInstanceIdsResult =
        builderResult.addAllTargetSurveyInstanceIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().targetSurveyInstanceIds());
    assertSame(builderResult, actualAddAllTargetSurveyInstanceIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllTargetSurveyInstanceIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTargetSurveyInstanceIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTargetSurveyInstanceIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTargetSurveyInstanceIds(Iterable)"})
  void testBuilderAddAllTargetSurveyInstanceIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddAllTargetSurveyInstanceIdsResult =
        builderResult.addAllTargetSurveyInstanceIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTargetSurveyInstanceIdsResult);
  }

  /**
   * Test Builder {@link Builder#addQuestionIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addQuestionIds(long)}
   */
  @Test
  @DisplayName("Test Builder addQuestionIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addQuestionIds(long)"})
  void testBuilderAddQuestionIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddQuestionIdsResult = builderResult.addQuestionIds(1L);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addQuestionIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addQuestionIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addQuestionIds(long[])"})
  void testBuilderAddQuestionIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddQuestionIdsResult = builderResult.addQuestionIds(1L, 0L, 1L, 0L);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(4, questionIdsResult.size());
    assertEquals(0L, questionIdsResult.get(1).longValue());
    assertEquals(0L, questionIdsResult.get(3).longValue());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertEquals(1L, questionIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addTargetSurveyInstanceIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addTargetSurveyInstanceIds(long)}
   */
  @Test
  @DisplayName("Test Builder addTargetSurveyInstanceIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTargetSurveyInstanceIds(long)"})
  void testBuilderAddTargetSurveyInstanceIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddTargetSurveyInstanceIdsResult = builderResult.addTargetSurveyInstanceIds(1L);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualAddTargetSurveyInstanceIdsResult);
  }

  /**
   * Test Builder {@link Builder#addTargetSurveyInstanceIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addTargetSurveyInstanceIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addTargetSurveyInstanceIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTargetSurveyInstanceIds(long[])"})
  void testBuilderAddTargetSurveyInstanceIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualAddTargetSurveyInstanceIdsResult =
        builderResult.addTargetSurveyInstanceIds(1L, 0L, 1L, 0L);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(2, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(0L));
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualAddTargetSurveyInstanceIdsResult);
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
  @MethodsUnderTest({"ImmutableCopySurveyResponsesCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Assert
    assertFalse(actualImmutableCopySurveyResponsesCommand.overrideExistingResponses());
    assertTrue(actualImmutableCopySurveyResponsesCommand.questionIds().isEmpty());
    assertTrue(actualImmutableCopySurveyResponsesCommand.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(CopySurveyResponsesCommand)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CopySurveyResponsesCommand); given three; then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CopySurveyResponsesCommand)"})
  void testBuilderFrom_givenThree_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    Builder builderResult2 = ImmutableCopySurveyResponsesCommand.builder();
    builderResult2.addTargetSurveyInstanceIds(3L);
    ImmutableCopySurveyResponsesCommand instance = builderResult2.build();

    // Act and Assert
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCopySurveyResponsesCommand);
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableCopySurveyResponsesCommand2);
  }

  /**
   * Test Builder {@link Builder#from(CopySurveyResponsesCommand)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When builder addQuestionIds three.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CopySurveyResponsesCommand); given three; when builder addQuestionIds three; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CopySurveyResponsesCommand)"})
  void testBuilderFrom_givenThree_whenBuilderAddQuestionIdsThree_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    Builder builderResult2 = ImmutableCopySurveyResponsesCommand.builder();
    builderResult2.addQuestionIds(3L);
    builderResult2.addTargetSurveyInstanceIds(3L);
    ImmutableCopySurveyResponsesCommand instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableCopySurveyResponsesCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CopySurveyResponsesCommand)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CopySurveyResponsesCommand); when builder build; then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CopySurveyResponsesCommand)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();
    ImmutableCopySurveyResponsesCommand instance =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act and Assert
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCopySurveyResponsesCommand);
    ImmutableCopySurveyResponsesCommand actualImmutableCopySurveyResponsesCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableCopySurveyResponsesCommand2);
  }

  /**
   * Test Builder {@link Builder#overrideExistingResponses(boolean)}.
   *
   * <p>Method under test: {@link Builder#overrideExistingResponses(boolean)}
   */
  @Test
  @DisplayName("Test Builder overrideExistingResponses(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overrideExistingResponses(boolean)"})
  void testBuilderOverrideExistingResponses() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualOverrideExistingResponsesResult = builderResult.overrideExistingResponses(true);

    // Assert
    assertTrue(builderResult.build().overrideExistingResponses());
    assertSame(builderResult, actualOverrideExistingResponsesResult);
  }

  /**
   * Test Builder {@link Builder#questionIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build questionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#questionIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder questionIds(Iterable); given one; then return build questionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionIds(Iterable)"})
  void testBuilderQuestionIds_givenOne_thenReturnBuildQuestionIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> questionIdsResult = builderResult.questionIds(elements).build().questionIds();
    assertEquals(1, questionIdsResult.size());
    List<Long> questionIdsResult2 = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult2.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertEquals(1L, questionIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#questionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#questionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder questionIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionIds(Iterable)"})
  void testBuilderQuestionIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualQuestionIdsResult = builderResult.questionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#targetSurveyInstanceIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#targetSurveyInstanceIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyInstanceIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetSurveyInstanceIds(Iterable)"})
  void testBuilderTargetSurveyInstanceIds() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualTargetSurveyInstanceIdsResult = builderResult.targetSurveyInstanceIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().targetSurveyInstanceIds());
    assertSame(builderResult, actualTargetSurveyInstanceIdsResult);
  }

  /**
   * Test Builder {@link Builder#targetSurveyInstanceIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetSurveyInstanceIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyInstanceIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetSurveyInstanceIds(Iterable)"})
  void testBuilderTargetSurveyInstanceIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    Builder actualTargetSurveyInstanceIdsResult =
        builderResult.targetSurveyInstanceIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTargetSurveyInstanceIdsResult);
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return not overrideExistingResponses.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CopySurveyResponsesCommand); when builder build; then return not overrideExistingResponses")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.copyOf(CopySurveyResponsesCommand)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnNotOverrideExistingResponses() {
    // Arrange
    ImmutableCopySurveyResponsesCommand instance =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult =
        ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    assertFalse(actualCopyOfResult.overrideExistingResponses());
    assertTrue(actualCopyOfResult.questionIds().isEmpty());
    assertTrue(actualCopyOfResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}, and {@link
   * ImmutableCopySurveyResponsesCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   *   <li>{@link ImmutableCopySurveyResponsesCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand2 =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act and Assert
    assertEquals(immutableCopySurveyResponsesCommand, immutableCopySurveyResponsesCommand2);
    assertEquals(
        immutableCopySurveyResponsesCommand.hashCode(),
        immutableCopySurveyResponsesCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}, and {@link
   * ImmutableCopySurveyResponsesCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   *   <li>{@link ImmutableCopySurveyResponsesCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act and Assert
    assertEquals(immutableCopySurveyResponsesCommand, immutableCopySurveyResponsesCommand);
    int expectedHashCodeResult = immutableCopySurveyResponsesCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableCopySurveyResponsesCommand.hashCode());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();
    builderResult.addTargetSurveyInstanceIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCopySurveyResponsesCommand.builder().build());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();
    builderResult.addQuestionIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableCopySurveyResponsesCommand.builder().build());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCopySurveyResponsesCommand.builder().build(), null);
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.equals(Object)",
    "int ImmutableCopySurveyResponsesCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCopySurveyResponsesCommand.builder().build(),
        "Different type to ImmutableCopySurveyResponsesCommand");
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return questionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add one; then return questionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddOne_thenReturnQuestionIdsSizeIsOne() {
    // Arrange
    ArrayList<Long> questionIds = new ArrayList<>();
    questionIds.add(1L);

    Json json = new Json();
    json.setQuestionIds(questionIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult =
        ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    List<Long> questionIdsResult = actualFromJsonResult.questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add three.
   *   <li>Then return questionIds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add three; then return questionIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddThree_thenReturnQuestionIdsIsArrayList() {
    // Arrange
    ArrayList<Long> questionIds = new ArrayList<>();
    questionIds.add(3L);
    questionIds.add(1L);

    Json json = new Json();
    json.setQuestionIds(questionIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult =
        ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    assertEquals(questionIds, actualFromJsonResult.questionIds());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add one.
   *   <li>Then return targetSurveyInstanceIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet() add one; then return targetSurveyInstanceIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.fromJson(Json)"
  })
  void testFromJson_givenHashSetAddOne_thenReturnTargetSurveyInstanceIdsSizeIsOne() {
    // Arrange
    HashSet<Long> targetSurveyInstanceIds = new HashSet<>();
    targetSurveyInstanceIds.add(1L);

    Json json = new Json();
    json.setTargetSurveyInstanceIds(targetSurveyInstanceIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult =
        ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = actualFromJsonResult.targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add three.
   *   <li>Then return targetSurveyInstanceIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet() add three; then return targetSurveyInstanceIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.fromJson(Json)"
  })
  void testFromJson_givenHashSetAddThree_thenReturnTargetSurveyInstanceIdsIsHashSet() {
    // Arrange
    HashSet<Long> targetSurveyInstanceIds = new HashSet<>();
    targetSurveyInstanceIds.add(3L);
    targetSurveyInstanceIds.add(1L);

    Json json = new Json();
    json.setTargetSurveyInstanceIds(targetSurveyInstanceIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult =
        ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    assertEquals(targetSurveyInstanceIds, actualFromJsonResult.targetSurveyInstanceIds());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return not overrideExistingResponses.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return not overrideExistingResponses")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnNotOverrideExistingResponses() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult =
        ImmutableCopySurveyResponsesCommand.fromJson(new Json());

    // Assert
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    assertTrue(actualFromJsonResult.questionIds().isEmpty());
    assertTrue(actualFromJsonResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCopySurveyResponsesCommand#toString()}
   *   <li>{@link ImmutableCopySurveyResponsesCommand#overrideExistingResponses()}
   *   <li>{@link ImmutableCopySurveyResponsesCommand#questionIds()}
   *   <li>{@link ImmutableCopySurveyResponsesCommand#targetSurveyInstanceIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCopySurveyResponsesCommand.overrideExistingResponses()",
    "List ImmutableCopySurveyResponsesCommand.questionIds()",
    "Set ImmutableCopySurveyResponsesCommand.targetSurveyInstanceIds()",
    "String ImmutableCopySurveyResponsesCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act
    String actualToStringResult = immutableCopySurveyResponsesCommand.toString();
    boolean actualOverrideExistingResponsesResult =
        immutableCopySurveyResponsesCommand.overrideExistingResponses();
    List<Long> actualQuestionIdsResult = immutableCopySurveyResponsesCommand.questionIds();
    Set<Long> actualTargetSurveyInstanceIdsResult =
        immutableCopySurveyResponsesCommand.targetSurveyInstanceIds();

    // Assert
    assertEquals(
        "CopySurveyResponsesCommand{targetSurveyInstanceIds=[], overrideExistingResponses=false,"
            + " questionIds=[]}",
        actualToStringResult);
    assertFalse(actualOverrideExistingResponsesResult);
    assertTrue(actualQuestionIdsResult.isEmpty());
    assertTrue(actualTargetSurveyInstanceIdsResult.isEmpty());
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
    assertFalse(actualJson.overrideExistingResponses);
    assertFalse(actualJson.overrideExistingResponsesIsSet);
    assertTrue(actualJson.questionIds.isEmpty());
    assertTrue(actualJson.targetSurveyInstanceIds.isEmpty());
  }

  /**
   * Test Json {@link Json#overrideExistingResponses()}.
   *
   * <p>Method under test: {@link Json#overrideExistingResponses()}
   */
  @Test
  @DisplayName("Test Json overrideExistingResponses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.overrideExistingResponses()"})
  void testJsonOverrideExistingResponses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overrideExistingResponses());
  }

  /**
   * Test Json {@link Json#questionIds()}.
   *
   * <p>Method under test: {@link Json#questionIds()}
   */
  @Test
  @DisplayName("Test Json questionIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.questionIds()"})
  void testJsonQuestionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questionIds());
  }

  /**
   * Test Json {@link Json#setOverrideExistingResponses(boolean)}.
   *
   * <p>Method under test: {@link Json#setOverrideExistingResponses(boolean)}
   */
  @Test
  @DisplayName("Test Json setOverrideExistingResponses(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setOverrideExistingResponses(boolean)"})
  void testJsonSetOverrideExistingResponses() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOverrideExistingResponses(true);

    // Assert
    assertTrue(json.overrideExistingResponses);
    assertTrue(json.overrideExistingResponsesIsSet);
  }

  /**
   * Test Json {@link Json#targetSurveyInstanceIds()}.
   *
   * <p>Method under test: {@link Json#targetSurveyInstanceIds()}
   */
  @Test
  @DisplayName("Test Json targetSurveyInstanceIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.targetSurveyInstanceIds()"})
  void testJsonTargetSurveyInstanceIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetSurveyInstanceIds());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withOverrideExistingResponses(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return builder build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCopySurveyResponsesCommand#withOverrideExistingResponses(boolean)}
   */
  @Test
  @DisplayName(
      "Test withOverrideExistingResponses(boolean); when 'false'; then return builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withOverrideExistingResponses(boolean)"
  })
  void testWithOverrideExistingResponses_whenFalse_thenReturnBuilderBuild() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    // Act
    ImmutableCopySurveyResponsesCommand actualWithOverrideExistingResponsesResult =
        immutableCopySurveyResponsesCommand.withOverrideExistingResponses(false);

    // Assert
    assertSame(immutableCopySurveyResponsesCommand, actualWithOverrideExistingResponsesResult);
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withOverrideExistingResponses(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return questionIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCopySurveyResponsesCommand#withOverrideExistingResponses(boolean)}
   */
  @Test
  @DisplayName(
      "Test withOverrideExistingResponses(boolean); when 'true'; then return questionIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withOverrideExistingResponses(boolean)"
  })
  void testWithOverrideExistingResponses_whenTrue_thenReturnQuestionIdsEmpty() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualWithOverrideExistingResponsesResult =
        ImmutableCopySurveyResponsesCommand.builder().build().withOverrideExistingResponses(true);

    // Assert
    assertTrue(actualWithOverrideExistingResponsesResult.questionIds().isEmpty());
    assertTrue(actualWithOverrideExistingResponsesResult.targetSurveyInstanceIds().isEmpty());
    assertTrue(actualWithOverrideExistingResponsesResult.overrideExistingResponses());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withQuestionIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return questionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#withQuestionIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withQuestionIds(Iterable) with 'Iterable'; given one; then return questionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withQuestionIds(Iterable)"
  })
  void testWithQuestionIdsWithIterable_givenOne_thenReturnQuestionIdsSizeIsOne() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand actualWithQuestionIdsResult =
        immutableCopySurveyResponsesCommand.withQuestionIds(elements);

    // Assert
    List<Long> questionIdsResult = actualWithQuestionIdsResult.questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertFalse(actualWithQuestionIdsResult.overrideExistingResponses());
    assertTrue(actualWithQuestionIdsResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withQuestionIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableCopySurveyResponsesCommand#withQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test withQuestionIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withQuestionIds(long[])"
  })
  void testWithQuestionIdsWithLong() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualWithQuestionIdsResult =
        ImmutableCopySurveyResponsesCommand.builder().build().withQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> questionIdsResult = actualWithQuestionIdsResult.questionIds();
    assertEquals(4, questionIdsResult.size());
    assertEquals(-1L, questionIdsResult.get(1).longValue());
    assertEquals(-1L, questionIdsResult.get(3).longValue());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertEquals(1L, questionIdsResult.get(2).longValue());
    assertFalse(actualWithQuestionIdsResult.overrideExistingResponses());
    assertTrue(actualWithQuestionIdsResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withTargetSurveyInstanceIds(Iterable)} with
   * {@code Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableCopySurveyResponsesCommand#withTargetSurveyInstanceIds(Iterable)}
   */
  @Test
  @DisplayName("Test withTargetSurveyInstanceIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withTargetSurveyInstanceIds(Iterable)"
  })
  void testWithTargetSurveyInstanceIdsWithIterable() {
    // Arrange
    ImmutableCopySurveyResponsesCommand immutableCopySurveyResponsesCommand =
        ImmutableCopySurveyResponsesCommand.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand actualWithTargetSurveyInstanceIdsResult =
        immutableCopySurveyResponsesCommand.withTargetSurveyInstanceIds(elements);

    // Assert
    assertFalse(actualWithTargetSurveyInstanceIdsResult.overrideExistingResponses());
    assertTrue(actualWithTargetSurveyInstanceIdsResult.questionIds().isEmpty());
    assertEquals(elements, actualWithTargetSurveyInstanceIdsResult.targetSurveyInstanceIds());
  }

  /**
   * Test {@link ImmutableCopySurveyResponsesCommand#withTargetSurveyInstanceIds(long[])} with
   * {@code long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableCopySurveyResponsesCommand#withTargetSurveyInstanceIds(long[])}
   */
  @Test
  @DisplayName("Test withTargetSurveyInstanceIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCopySurveyResponsesCommand ImmutableCopySurveyResponsesCommand.withTargetSurveyInstanceIds(long[])"
  })
  void testWithTargetSurveyInstanceIdsWithLong() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualWithTargetSurveyInstanceIdsResult =
        ImmutableCopySurveyResponsesCommand.builder()
            .build()
            .withTargetSurveyInstanceIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult =
        actualWithTargetSurveyInstanceIdsResult.targetSurveyInstanceIds();
    assertEquals(2, targetSurveyInstanceIdsResult.size());
    assertFalse(actualWithTargetSurveyInstanceIdsResult.overrideExistingResponses());
    assertTrue(actualWithTargetSurveyInstanceIdsResult.questionIds().isEmpty());
    assertTrue(targetSurveyInstanceIdsResult.contains(-1L));
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
  }
}
