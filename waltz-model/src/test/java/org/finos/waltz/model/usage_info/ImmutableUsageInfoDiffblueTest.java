package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo.Builder;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUsageInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo Builder.build()", "Builder Builder.description(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUsageInfo actualImmutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualImmutableUsageInfo.description());
    assertEquals(UsageKind.CONSUMER, actualImmutableUsageInfo.kind());
    assertTrue(actualImmutableUsageInfo.isSelected());
  }

  /**
   * Test Builder {@link Builder#from(UsageInfo)}.
   *
   * <p>Method under test: {@link Builder#from(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UsageInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UsageInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();
    ImmutableUsageInfo instance =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUsageInfo actualImmutableUsageInfo = builderResult.build();
    assertEquals(instance, actualImmutableUsageInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UsageInfo)}.
   *
   * <p>Method under test: {@link Builder#from(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UsageInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UsageInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();
    ImmutableUsageInfo instance =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(false)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUsageInfo actualImmutableUsageInfo = builderResult.build();
    assertEquals(instance, actualImmutableUsageInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isSelected(boolean)}.
   *
   * <p>Method under test: {@link Builder#isSelected(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSelected(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isSelected(boolean)"})
  void testBuilderIsSelected() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();

    // Act
    Builder actualIsSelectedResult = builderResult.isSelected(true);

    // Assert
    assertSame(builderResult, actualIsSelectedResult);
  }

  /**
   * Test Builder {@link Builder#kind(UsageKind)}.
   *
   * <p>Method under test: {@link Builder#kind(UsageKind)}
   */
  @Test
  @DisplayName("Test Builder kind(UsageKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(UsageKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableUsageInfo.builder();

    // Act
    Builder actualKindResult = builderResult.kind(UsageKind.CONSUMER);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test {@link ImmutableUsageInfo#copyOf(UsageInfo)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#copyOf(UsageInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UsageInfo); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.copyOf(UsageInfo)"})
  void testCopyOf_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    ImmutableUsageInfo instance =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    ImmutableUsageInfo actualCopyOfResult = ImmutableUsageInfo.copyOf(instance);

    // Assert
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(UsageKind.CONSUMER, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isSelected());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}, and {@link ImmutableUsageInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUsageInfo#equals(Object)}
   *   <li>{@link ImmutableUsageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();
    ImmutableUsageInfo immutableUsageInfo2 =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act and Assert
    assertEquals(immutableUsageInfo, immutableUsageInfo2);
    assertEquals(immutableUsageInfo.hashCode(), immutableUsageInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}, and {@link ImmutableUsageInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUsageInfo#equals(Object)}
   *   <li>{@link ImmutableUsageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act and Assert
    assertEquals(immutableUsageInfo, immutableUsageInfo);
    int expectedHashCodeResult = immutableUsageInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableUsageInfo.hashCode());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("Description")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUsageInfo,
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(false)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUsageInfo,
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.DISTRIBUTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUsageInfo,
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUsageInfo.equals(Object)",
    "int ImmutableUsageInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build(),
        "Different type to ImmutableUsageInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUsageInfo#toString()}
   *   <li>{@link ImmutableUsageInfo#description()}
   *   <li>{@link ImmutableUsageInfo#isSelected()}
   *   <li>{@link ImmutableUsageInfo#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUsageInfo.description()",
    "boolean ImmutableUsageInfo.isSelected()",
    "UsageKind ImmutableUsageInfo.kind()",
    "String ImmutableUsageInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    String actualToStringResult = immutableUsageInfo.toString();
    String actualDescriptionResult = immutableUsageInfo.description();
    boolean actualIsSelectedResult = immutableUsageInfo.isSelected();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(
        "UsageInfo{kind=CONSUMER, isSelected=true, description=The characteristics of someone or something}",
        actualToStringResult);
    assertEquals(UsageKind.CONSUMER, immutableUsageInfo.kind());
    assertTrue(actualIsSelectedResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setKind(UsageKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setKind(UsageKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(UsageKind.CONSUMER);

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(UsageKind.CONSUMER, actualJson.kind);
    assertFalse(actualJson.isSelected);
    assertFalse(actualJson.isSelectedIsSet);
  }

  /**
   * Test Json {@link Json#isSelected()}.
   *
   * <p>Method under test: {@link Json#isSelected()}
   */
  @Test
  @DisplayName("Test Json isSelected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isSelected()"})
  void testJsonIsSelected() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isSelected());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UsageKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#setIsSelected(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsSelected(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSelected(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsSelected(boolean)"})
  void testJsonSetIsSelected() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSelected(true);

    // Assert
    assertTrue(json.isSelected);
    assertTrue(json.isSelectedIsSet);
  }

  /**
   * Test {@link ImmutableUsageInfo#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("42")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    ImmutableUsageInfo actualWithDescriptionResult = immutableUsageInfo.withDescription("42");

    // Assert
    assertSame(immutableUsageInfo, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUsageInfo#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableUsageInfo actualWithDescriptionResult =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals(UsageKind.CONSUMER, actualWithDescriptionResult.kind());
    assertTrue(actualWithDescriptionResult.isSelected());
  }

  /**
   * Test {@link ImmutableUsageInfo#withIsSelected(boolean)}.
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withIsSelected(boolean)}
   */
  @Test
  @DisplayName("Test withIsSelected(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withIsSelected(boolean)"})
  void testWithIsSelected() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    ImmutableUsageInfo actualWithIsSelectedResult = immutableUsageInfo.withIsSelected(true);

    // Assert
    assertSame(immutableUsageInfo, actualWithIsSelectedResult);
  }

  /**
   * Test {@link ImmutableUsageInfo#withIsSelected(boolean)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withIsSelected(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsSelected(boolean); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withIsSelected(boolean)"})
  void testWithIsSelected_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    ImmutableUsageInfo actualWithIsSelectedResult =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(false)
            .kind(UsageKind.CONSUMER)
            .build()
            .withIsSelected(true);

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualWithIsSelectedResult.description());
    assertEquals(UsageKind.CONSUMER, actualWithIsSelectedResult.kind());
    assertTrue(actualWithIsSelectedResult.isSelected());
  }

  /**
   * Test {@link ImmutableUsageInfo#withKind(UsageKind)}.
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withKind(UsageKind)}
   */
  @Test
  @DisplayName("Test withKind(UsageKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withKind(UsageKind)"})
  void testWithKind() {
    // Arrange
    ImmutableUsageInfo immutableUsageInfo =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();

    // Act
    ImmutableUsageInfo actualWithKindResult = immutableUsageInfo.withKind(UsageKind.CONSUMER);

    // Assert
    assertSame(immutableUsageInfo, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableUsageInfo#withKind(UsageKind)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUsageInfo#withKind(UsageKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(UsageKind); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUsageInfo ImmutableUsageInfo.withKind(UsageKind)"})
  void testWithKind_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    ImmutableUsageInfo actualWithKindResult =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.DISTRIBUTOR)
            .build()
            .withKind(UsageKind.CONSUMER);

    // Assert
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(UsageKind.CONSUMER, actualWithKindResult.kind());
    assertTrue(actualWithKindResult.isSelected());
  }
}
