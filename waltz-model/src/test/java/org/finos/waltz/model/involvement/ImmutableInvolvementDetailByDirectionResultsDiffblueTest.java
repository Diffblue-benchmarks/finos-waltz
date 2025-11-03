package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDetailByDirectionResultsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAncestors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAncestors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAncestors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAncestors(Iterable)"})
  void testBuilderAddAllAncestors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAncestors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllDescendents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDescendents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDescendents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDescendents(Iterable)"})
  void testBuilderAddAllDescendents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDescendents(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllExact(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllExact(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllExact(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllExact(Iterable)"})
  void testBuilderAddAllExact_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllExact(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAncestors(InvolvementDetail)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then builder build ancestors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAncestors(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addAncestors(InvolvementDetail) with 'element'; when Json (default constructor); then builder build ancestors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAncestors(InvolvementDetail)"})
  void testBuilderAddAncestorsWithElement_whenJson_thenBuilderBuildAncestorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAncestorsResult = builderResult.addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Test Builder {@link Builder#addAncestors(InvolvementDetail[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then builder build ancestors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAncestors(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addAncestors(InvolvementDetail[]) with 'elements'; when Json (default constructor); then builder build ancestors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAncestors(InvolvementDetail[])"})
  void testBuilderAddAncestorsWithElements_whenJson_thenBuilderBuildAncestorsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddAncestorsResult = builderResult.addAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().ancestors().size());
    assertSame(builderResult, actualAddAncestorsResult);
  }

  /**
   * Test Builder {@link Builder#addDescendents(InvolvementDetail)} with {@code element}.
   * <ul>
   *   <li>Then builder build descendents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDescendents(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addDescendents(InvolvementDetail) with 'element'; then builder build descendents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDescendents(InvolvementDetail)"})
  void testBuilderAddDescendentsWithElement_thenBuilderBuildDescendentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddDescendentsResult = builderResult.addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#addDescendents(InvolvementDetail[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build descendents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDescendents(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addDescendents(InvolvementDetail[]) with 'elements'; then builder build descendents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDescendents(InvolvementDetail[])"})
  void testBuilderAddDescendentsWithElements_thenBuilderBuildDescendentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddDescendentsResult = builderResult.addDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().descendents().size());
    assertSame(builderResult, actualAddDescendentsResult);
  }

  /**
   * Test Builder {@link Builder#addExact(InvolvementDetail)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then builder build exact size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addExact(InvolvementDetail)}
   */
  @Test
  @DisplayName("Test Builder addExact(InvolvementDetail) with 'element'; when Json (default constructor); then builder build exact size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addExact(InvolvementDetail)"})
  void testBuilderAddExactWithElement_whenJson_thenBuilderBuildExactSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddExactResult = builderResult.addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Test Builder {@link Builder#addExact(InvolvementDetail[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then builder build exact size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addExact(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test Builder addExact(InvolvementDetail[]) with 'elements'; when Json (default constructor); then builder build exact size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addExact(InvolvementDetail[])"})
  void testBuilderAddExactWithElements_whenJson_thenBuilderBuildExactSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act
    Builder actualAddExactResult = builderResult.addExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().exact().size());
    assertSame(builderResult, actualAddExactResult);
  }

  /**
   * Test Builder {@link Builder#ancestors(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ancestors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ancestors(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ancestors(Iterable)"})
  void testBuilderAncestors_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ancestors(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableInvolvementDetailByDirectionResults Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableInvolvementDetailByDirectionResults.builder().build().ancestors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#descendents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#descendents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder descendents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.descendents(Iterable)"})
  void testBuilderDescendents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descendents(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#exact(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#exact(Iterable)}
   */
  @Test
  @DisplayName("Test Builder exact(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.exact(Iterable)"})
  void testBuilderExact_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exact(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetailByDirectionResults)}.
   * <ul>
   *   <li>Given {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then return build exact is build descendents.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetailByDirectionResults); given Json (default constructor); then return build exact is build descendents")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetailByDirectionResults)"})
  void testBuilderFrom_givenJson_thenReturnBuildExactIsBuildDescendents() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    Builder builderResult2 = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult2.addAncestors(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults instance = builderResult2.build();

    // Act and Assert
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = buildResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(descendentsResult, buildResult.exact());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetailByDirectionResults)}.
   * <ul>
   *   <li>Given {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>When builder addExact {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then return build exact size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetailByDirectionResults); given Json (default constructor); when builder addExact Json (default constructor); then return build exact size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetailByDirectionResults)"})
  void testBuilderFrom_givenJson_whenBuilderAddExactJson_thenReturnBuildExactSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    Builder builderResult2 = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult2.addExact(new ImmutableInvolvementDetail.Json());
    builderResult2.addAncestors(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults instance = builderResult2.build();

    // Act and Assert
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.ancestors().size());
    assertEquals(1, buildResult.exact().size());
    assertTrue(buildResult.descendents().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetailByDirectionResults)}.
   * <ul>
   *   <li>Then return build descendents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetailByDirectionResults); then return build descendents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetailByDirectionResults)"})
  void testBuilderFrom_thenReturnBuildDescendentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    Builder builderResult2 = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult2.addDescendents(new ImmutableInvolvementDetail.Json());
    builderResult2.addAncestors(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults instance = builderResult2.build();

    // Act and Assert
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.ancestors().size());
    assertEquals(1, buildResult.descendents().size());
    assertTrue(buildResult.exact().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementDetailByDirectionResults)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build ancestors Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementDetailByDirectionResults); when builder build; then return build ancestors Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(InvolvementDetailByDirectionResults)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildAncestorsEmpty() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    ImmutableInvolvementDetailByDirectionResults instance = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.from(instance).build();
    Set<InvolvementDetail> ancestorsResult = buildResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(ancestorsResult, buildResult.descendents());
    assertSame(ancestorsResult, buildResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return ancestors Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#copyOf(InvolvementDetailByDirectionResults)}
   */
  @Test
  @DisplayName("Test copyOf(InvolvementDetailByDirectionResults); when builder build; then return ancestors Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.copyOf(InvolvementDetailByDirectionResults)"})
  void testCopyOf_whenBuilderBuild_thenReturnAncestorsEmpty() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults instance = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualCopyOfResult = ImmutableInvolvementDetailByDirectionResults
        .copyOf(instance);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualCopyOfResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualCopyOfResult.descendents());
    assertSame(ancestorsResult, actualCopyOfResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}, and {@link ImmutableInvolvementDetailByDirectionResults#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();
    ImmutableInvolvementDetailByDirectionResults buildResult2 = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}, and {@link ImmutableInvolvementDetailByDirectionResults#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult.addAncestors(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.build();
    ImmutableInvolvementDetailByDirectionResults buildResult2 = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult.addDescendents(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.build();
    ImmutableInvolvementDetailByDirectionResults buildResult2 = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableInvolvementDetailByDirectionResults.builder();
    builderResult.addExact(new ImmutableInvolvementDetail.Json());
    ImmutableInvolvementDetailByDirectionResults buildResult = builderResult.build();
    ImmutableInvolvementDetailByDirectionResults buildResult2 = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableInvolvementDetailByDirectionResults.equals(Object)",
      "int ImmutableInvolvementDetailByDirectionResults.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableInvolvementDetailByDirectionResults");
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Exact is {@code null}.</li>
   *   <li>Then return ancestors Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Exact is 'null'; then return ancestors Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonExactIsNull_thenReturnAncestorsEmpty() {
    // Arrange
    Json json = new Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    Set<InvolvementDetail> ancestorsResult = actualFromJsonResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualFromJsonResult.descendents());
    assertSame(ancestorsResult, actualFromJsonResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) Ancestors is {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then return ancestors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) Ancestors is LinkedHashSet(); then return ancestors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_whenJsonAncestorsIsLinkedHashSet_thenReturnAncestorsSizeIsOne() {
    // Arrange
    LinkedHashSet<InvolvementDetail> ancestors = new LinkedHashSet<>();
    ancestors.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(ancestors);
    json.setDescendents(null);
    json.setExact(null);

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualFromJsonResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualFromJsonResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) Descendents is {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then return descendents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) Descendents is LinkedHashSet(); then return descendents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_whenJsonDescendentsIsLinkedHashSet_thenReturnDescendentsSizeIsOne() {
    // Arrange
    LinkedHashSet<InvolvementDetail> descendents = new LinkedHashSet<>();
    descendents.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(null);
    json.setDescendents(descendents);
    json.setExact(null);

    // Act and Assert
    assertEquals(1, ImmutableInvolvementDetailByDirectionResults.fromJson(json).descendents().size());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) Exact is {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then return exact is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) Exact is LinkedHashSet(); then return exact is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_whenJsonExactIsLinkedHashSet_thenReturnExactIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(exact);

    // Act and Assert
    assertEquals(exact, ImmutableInvolvementDetailByDirectionResults.fromJson(json).exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) Exact is {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then return exact size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) Exact is LinkedHashSet(); then return exact size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_whenJsonExactIsLinkedHashSet_thenReturnExactSizeIsOne() {
    // Arrange
    LinkedHashSet<InvolvementDetail> exact = new LinkedHashSet<>();
    exact.add(new ImmutableInvolvementDetail.Json());

    Json json = new Json();
    json.setAncestors(null);
    json.setDescendents(null);
    json.setExact(exact);

    // Act and Assert
    assertEquals(1, ImmutableInvolvementDetailByDirectionResults.fromJson(json).exact().size());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return descendents is {@link Json} (default constructor) {@link Json#exact}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return descendents is Json (default constructor) exact")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnDescendentsIsJsonExact() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualFromJsonResult = ImmutableInvolvementDetailByDirectionResults
        .fromJson(json);

    // Assert
    Set<InvolvementDetail> involvementDetailSet = json.exact;
    assertSame(involvementDetailSet, actualFromJsonResult.descendents());
    assertSame(involvementDetailSet, actualFromJsonResult.exact());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#toString()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#ancestors()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#descendents()}
   *   <li>{@link ImmutableInvolvementDetailByDirectionResults#exact()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableInvolvementDetailByDirectionResults.ancestors()",
      "Set ImmutableInvolvementDetailByDirectionResults.descendents()",
      "Set ImmutableInvolvementDetailByDirectionResults.exact()",
      "String ImmutableInvolvementDetailByDirectionResults.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<InvolvementDetail> actualAncestorsResult = buildResult.ancestors();
    Set<InvolvementDetail> actualDescendentsResult = buildResult.descendents();
    Set<InvolvementDetail> actualExactResult = buildResult.exact();

    // Assert
    assertEquals("InvolvementDetailByDirectionResults{ancestors=[], descendents=[], exact=[]}", actualToStringResult);
    assertTrue(actualAncestorsResult.isEmpty());
    assertSame(actualAncestorsResult, actualDescendentsResult);
    assertSame(actualAncestorsResult, actualExactResult);
  }

  /**
   * Test Json {@link Json#ancestors()}.
   * <p>
   * Method under test: {@link Json#ancestors()}
   */
  @Test
  @DisplayName("Test Json ancestors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ancestors()"})
  void testJsonAncestors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ancestors());
  }

  /**
   * Test Json {@link Json#descendents()}.
   * <p>
   * Method under test: {@link Json#descendents()}
   */
  @Test
  @DisplayName("Test Json descendents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.descendents()"})
  void testJsonDescendents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).descendents());
  }

  /**
   * Test Json {@link Json#exact()}.
   * <p>
   * Method under test: {@link Json#exact()}
   */
  @Test
  @DisplayName("Test Json exact()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.exact()"})
  void testJsonExact() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).exact());
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
    assertTrue(actualJson.ancestors.isEmpty());
    assertTrue(actualJson.descendents.isEmpty());
    assertTrue(actualJson.exact.isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withAncestors(InvolvementDetail[])} with {@code InvolvementDetail[]}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then return ancestors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#withAncestors(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withAncestors(InvolvementDetail[]) with 'InvolvementDetail[]'; when Json (default constructor); then return ancestors size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withAncestors(InvolvementDetail[])"})
  void testWithAncestorsWithInvolvementDetail_whenJson_thenReturnAncestorsSizeIsOne() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithAncestorsResult = buildResult
        .withAncestors(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, actualWithAncestorsResult.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualWithAncestorsResult.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualWithAncestorsResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withDescendents(InvolvementDetail[])} with {@code InvolvementDetail[]}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then return descendents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#withDescendents(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withDescendents(InvolvementDetail[]) with 'InvolvementDetail[]'; when Json (default constructor); then return descendents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withDescendents(InvolvementDetail[])"})
  void testWithDescendentsWithInvolvementDetail_whenJson_thenReturnDescendentsSizeIsOne() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithDescendentsResult = buildResult
        .withDescendents(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, actualWithDescendentsResult.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualWithDescendentsResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualWithDescendentsResult.exact());
  }

  /**
   * Test {@link ImmutableInvolvementDetailByDirectionResults#withExact(InvolvementDetail[])} with {@code InvolvementDetail[]}.
   * <ul>
   *   <li>When {@link ImmutableInvolvementDetail.Json} (default constructor).</li>
   *   <li>Then return exact size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableInvolvementDetailByDirectionResults#withExact(InvolvementDetail[])}
   */
  @Test
  @DisplayName("Test withExact(InvolvementDetail[]) with 'InvolvementDetail[]'; when Json (default constructor); then return exact size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableInvolvementDetailByDirectionResults ImmutableInvolvementDetailByDirectionResults.withExact(InvolvementDetail[])"})
  void testWithExactWithInvolvementDetail_whenJson_thenReturnExactSizeIsOne() {
    // Arrange
    ImmutableInvolvementDetailByDirectionResults buildResult = ImmutableInvolvementDetailByDirectionResults.builder()
        .build();

    // Act
    ImmutableInvolvementDetailByDirectionResults actualWithExactResult = buildResult
        .withExact(new ImmutableInvolvementDetail.Json());

    // Assert
    assertEquals(1, actualWithExactResult.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualWithExactResult.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualWithExactResult.descendents());
  }
}
