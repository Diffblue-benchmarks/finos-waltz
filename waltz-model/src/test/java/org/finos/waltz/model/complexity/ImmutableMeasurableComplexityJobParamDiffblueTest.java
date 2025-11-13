package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityJobParam.Builder;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityJobParam.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableComplexityJobParamDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllMeasurableComplexities(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllMeasurableComplexities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMeasurableComplexities(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMeasurableComplexities(Iterable)"})
  void testBuilderAddAllMeasurableComplexities() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    Builder actualAddAllMeasurableComplexitiesResult =
        builderResult.addAllMeasurableComplexities(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllMeasurableComplexitiesResult.build().measurableComplexities().isEmpty());
    assertSame(builderResult, actualAddAllMeasurableComplexitiesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableComplexities(MeasurableComplexityDetail)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addMeasurableComplexities(MeasurableComplexityDetail)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableComplexities(MeasurableComplexityDetail) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableComplexities(MeasurableComplexityDetail)"})
  void testBuilderAddMeasurableComplexitiesWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    Builder actualAddMeasurableComplexitiesResult =
        builderResult.addMeasurableComplexities(new ImmutableMeasurableComplexityDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().measurableComplexities().size());
    assertSame(builderResult, actualAddMeasurableComplexitiesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableComplexities(MeasurableComplexityDetail[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link Builder#addMeasurableComplexities(MeasurableComplexityDetail[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurableComplexities(MeasurableComplexityDetail[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableComplexities(MeasurableComplexityDetail[])"})
  void testBuilderAddMeasurableComplexitiesWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    Builder actualAddMeasurableComplexitiesResult =
        builderResult.addMeasurableComplexities(new ImmutableMeasurableComplexityDetail.Json());

    // Assert
    assertEquals(1, builderResult.build().measurableComplexities().size());
    assertSame(builderResult, actualAddMeasurableComplexitiesResult);
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
  @MethodsUnderTest({"ImmutableMeasurableComplexityJobParam Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableMeasurableComplexityJobParam.builder().build().measurableComplexities().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableComplexityJobParam)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableComplexityJobParam)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableComplexityJobParam)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableComplexityJobParam)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    Builder builderResult2 = ImmutableMeasurableComplexityJobParam.builder();
    builderResult2.addMeasurableComplexities(
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build());
    ImmutableMeasurableComplexityJobParam instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableComplexityJobParam actualImmutableMeasurableComplexityJobParam =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableComplexityJobParam);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableComplexityJobParam)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableComplexityJobParam)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableComplexityJobParam); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableComplexityJobParam)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();
    ImmutableMeasurableComplexityJobParam instance =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableComplexityJobParam actualImmutableMeasurableComplexityJobParam =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableComplexityJobParam);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableComplexities(Iterable)}.
   *
   * <ul>
   *   <li>Then return build measurableComplexities Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableComplexities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableComplexities(Iterable); then return build measurableComplexities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableComplexities(Iterable)"})
  void testBuilderMeasurableComplexities_thenReturnBuildMeasurableComplexitiesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    Builder actualMeasurableComplexitiesResult =
        builderResult.measurableComplexities(new ArrayList<>());

    // Assert
    assertTrue(actualMeasurableComplexitiesResult.build().measurableComplexities().isEmpty());
    assertSame(builderResult, actualMeasurableComplexitiesResult);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#copyOf(MeasurableComplexityJobParam)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return measurableComplexities Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableComplexityJobParam#copyOf(MeasurableComplexityJobParam)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableComplexityJobParam); when builder build; then return measurableComplexities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.copyOf(MeasurableComplexityJobParam)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnMeasurableComplexitiesEmpty() {
    // Arrange
    ImmutableMeasurableComplexityJobParam instance =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act and Assert
    assertTrue(
        ImmutableMeasurableComplexityJobParam.copyOf(instance).measurableComplexities().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#equals(Object)}, and {@link
   * ImmutableMeasurableComplexityJobParam#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityJobParam#equals(Object)}
   *   <li>{@link ImmutableMeasurableComplexityJobParam#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityJobParam.equals(Object)",
    "int ImmutableMeasurableComplexityJobParam.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableComplexityJobParam immutableMeasurableComplexityJobParam =
        ImmutableMeasurableComplexityJobParam.builder().build();
    ImmutableMeasurableComplexityJobParam immutableMeasurableComplexityJobParam2 =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act and Assert
    assertEquals(immutableMeasurableComplexityJobParam, immutableMeasurableComplexityJobParam2);
    assertEquals(
        immutableMeasurableComplexityJobParam.hashCode(),
        immutableMeasurableComplexityJobParam2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#equals(Object)}, and {@link
   * ImmutableMeasurableComplexityJobParam#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityJobParam#equals(Object)}
   *   <li>{@link ImmutableMeasurableComplexityJobParam#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityJobParam.equals(Object)",
    "int ImmutableMeasurableComplexityJobParam.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableComplexityJobParam immutableMeasurableComplexityJobParam =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act and Assert
    assertEquals(immutableMeasurableComplexityJobParam, immutableMeasurableComplexityJobParam);
    int expectedHashCodeResult = immutableMeasurableComplexityJobParam.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableComplexityJobParam.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityJobParam.equals(Object)",
    "int ImmutableMeasurableComplexityJobParam.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();
    builderResult.addMeasurableComplexities(
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableMeasurableComplexityJobParam.builder().build());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityJobParam.equals(Object)",
    "int ImmutableMeasurableComplexityJobParam.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableMeasurableComplexityJobParam.builder().build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityJobParam.equals(Object)",
    "int ImmutableMeasurableComplexityJobParam.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableComplexityJobParam.builder().build(),
        "Different type to ImmutableMeasurableComplexityJobParam");
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableMeasurableComplexityDetail.Json} (default constructor).
   *   <li>Then return measurableComplexities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return measurableComplexities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnMeasurableComplexitiesSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableComplexityDetail> measurableComplexities = new LinkedHashSet<>();
    measurableComplexities.add(new ImmutableMeasurableComplexityDetail.Json());

    Json json = new Json();
    json.setMeasurableComplexities(measurableComplexities);

    // Act
    ImmutableMeasurableComplexityJobParam actualFromJsonResult =
        ImmutableMeasurableComplexityJobParam.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableComplexities().size());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) MeasurableComplexities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) MeasurableComplexities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonMeasurableComplexitiesIsNull() {
    // Arrange
    Json json = new Json();
    json.setMeasurableComplexities(null);

    // Act
    ImmutableMeasurableComplexityJobParam actualFromJsonResult =
        ImmutableMeasurableComplexityJobParam.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.measurableComplexities().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurableComplexities is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableComplexities is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.fromJson(Json)"
  })
  void testFromJson_thenReturnMeasurableComplexitiesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<MeasurableComplexityDetail> measurableComplexities = new LinkedHashSet<>();
    measurableComplexities.add(
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build());
    measurableComplexities.add(new ImmutableMeasurableComplexityDetail.Json());

    Json json = new Json();
    json.setMeasurableComplexities(measurableComplexities);

    // Act
    ImmutableMeasurableComplexityJobParam actualFromJsonResult =
        ImmutableMeasurableComplexityJobParam.fromJson(json);

    // Assert
    assertEquals(measurableComplexities, actualFromJsonResult.measurableComplexities());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return measurableComplexities Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityJobParam#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return measurableComplexities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnMeasurableComplexitiesEmpty() {
    // Arrange and Act
    ImmutableMeasurableComplexityJobParam actualFromJsonResult =
        ImmutableMeasurableComplexityJobParam.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.measurableComplexities().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityJobParam#toString()}
   *   <li>{@link ImmutableMeasurableComplexityJobParam#measurableComplexities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Set ImmutableMeasurableComplexityJobParam.measurableComplexities()",
    "String ImmutableMeasurableComplexityJobParam.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableComplexityJobParam immutableMeasurableComplexityJobParam =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act
    String actualToStringResult = immutableMeasurableComplexityJobParam.toString();

    // Assert
    assertEquals("MeasurableComplexityJobParam{measurableComplexities=[]}", actualToStringResult);
    assertTrue(immutableMeasurableComplexityJobParam.measurableComplexities().isEmpty());
  }

  /**
   * Test Json {@link Json#measurableComplexities()}.
   *
   * <p>Method under test: {@link Json#measurableComplexities()}
   */
  @Test
  @DisplayName("Test Json measurableComplexities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.measurableComplexities()"})
  void testJsonMeasurableComplexities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableComplexities());
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
    // Arrange, Act and Assert
    assertTrue(new Json().measurableComplexities.isEmpty());
  }

  /**
   * Test {@link
   * ImmutableMeasurableComplexityJobParam#withMeasurableComplexities(MeasurableComplexityDetail[])}
   * with {@code MeasurableComplexityDetail[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableComplexityJobParam#withMeasurableComplexities(MeasurableComplexityDetail[])}
   */
  @Test
  @DisplayName(
      "Test withMeasurableComplexities(MeasurableComplexityDetail[]) with 'MeasurableComplexityDetail[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityJobParam ImmutableMeasurableComplexityJobParam.withMeasurableComplexities(MeasurableComplexityDetail[])"
  })
  void testWithMeasurableComplexitiesWithMeasurableComplexityDetail() {
    // Arrange
    ImmutableMeasurableComplexityJobParam immutableMeasurableComplexityJobParam =
        ImmutableMeasurableComplexityJobParam.builder().build();

    // Act and Assert
    assertEquals(
        1,
        immutableMeasurableComplexityJobParam
            .withMeasurableComplexities(
                ImmutableMeasurableComplexityDetail.builder()
                    .complexityKind("Complexity Kind")
                    .measurableCategory("Measurable Category")
                    .build())
            .measurableComplexities()
            .size());
  }
}
