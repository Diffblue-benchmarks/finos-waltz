package org.finos.waltz.jobs.generators.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.generators.model.ImmutableCountry.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCountryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCountry actualImmutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Assert
    assertEquals("Code", actualImmutableCountry.code());
    assertEquals("Name", actualImmutableCountry.name());
    assertEquals("us-east-2", actualImmutableCountry.region());
    assertEquals("us-east-2", actualImmutableCountry.regionCode());
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   *
   * <ul>
   *   <li>When {@code Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String); when 'Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode_whenCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
  }

  /**
   * Test Builder {@link Builder#from(Country)}.
   *
   * <p>Method under test: {@link Builder#from(Country)}
   */
  @Test
  @DisplayName("Test Builder from(Country)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Country)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();
    ImmutableCountry instance =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCountry actualImmutableCountry = builderResult.build();
    assertEquals(instance, actualImmutableCountry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#regionCode(String)}.
   *
   * <ul>
   *   <li>When {@code us-east-2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#regionCode(String)}
   */
  @Test
  @DisplayName("Test Builder regionCode(String); when 'us-east-2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.regionCode(String)"})
  void testBuilderRegionCode_whenUsEast2_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act
    Builder actualRegionCodeResult = builderResult.regionCode("us-east-2");

    // Assert
    assertSame(builderResult, actualRegionCodeResult);
  }

  /**
   * Test Builder {@link Builder#region(String)}.
   *
   * <ul>
   *   <li>When {@code us-east-2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#region(String)}
   */
  @Test
  @DisplayName("Test Builder region(String); when 'us-east-2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.region(String)"})
  void testBuilderRegion_whenUsEast2_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act
    Builder actualRegionResult = builderResult.region("us-east-2");

    // Assert
    assertSame(builderResult, actualRegionResult);
  }

  /**
   * Test {@link ImmutableCountry#copyOf(Country)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#copyOf(Country)}
   */
  @Test
  @DisplayName("Test copyOf(Country); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.copyOf(Country)"})
  void testCopyOf_thenReturnCode() {
    // Arrange
    ImmutableCountry instance =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act
    ImmutableCountry actualCopyOfResult = ImmutableCountry.copyOf(instance);

    // Assert
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("us-east-2", actualCopyOfResult.region());
    assertEquals("us-east-2", actualCopyOfResult.regionCode());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}, and {@link ImmutableCountry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountry#equals(Object)}
   *   <li>{@link ImmutableCountry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();
    ImmutableCountry immutableCountry2 =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act and Assert
    assertEquals(immutableCountry, immutableCountry2);
    assertEquals(immutableCountry.hashCode(), immutableCountry2.hashCode());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}, and {@link ImmutableCountry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountry#equals(Object)}
   *   <li>{@link ImmutableCountry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act and Assert
    assertEquals(immutableCountry, immutableCountry);
    int expectedHashCodeResult = immutableCountry.hashCode();
    assertEquals(expectedHashCodeResult, immutableCountry.hashCode());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Name")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountry,
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Code")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountry,
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("Name")
            .regionCode("us-east-2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountry,
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCountry,
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build());
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCountry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCountry.equals(Object)", "int ImmutableCountry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build(),
        "Different type to ImmutableCountry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCountry#toString()}
   *   <li>{@link ImmutableCountry#code()}
   *   <li>{@link ImmutableCountry#name()}
   *   <li>{@link ImmutableCountry#region()}
   *   <li>{@link ImmutableCountry#regionCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCountry.code()",
    "String ImmutableCountry.name()",
    "String ImmutableCountry.region()",
    "String ImmutableCountry.regionCode()",
    "String ImmutableCountry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act
    String actualToStringResult = immutableCountry.toString();
    String actualCodeResult = immutableCountry.code();
    String actualNameResult = immutableCountry.name();
    String actualRegionResult = immutableCountry.region();

    // Assert
    assertEquals("Code", actualCodeResult);
    assertEquals(
        "Country{name=Name, code=Code, region=us-east-2, regionCode=us-east-2}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertEquals("us-east-2", actualRegionResult);
    assertEquals("us-east-2", immutableCountry.regionCode());
  }

  /**
   * Test {@link ImmutableCountry#withCode(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code 42} name {@code Name} region {@code us-east-2} regionCode
   *       {@code us-east-2} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withCode(String)}
   */
  @Test
  @DisplayName(
      "Test withCode(String); then return builder code '42' name 'Name' region 'us-east-2' regionCode 'us-east-2' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withCode(String)"})
  void testWithCode_thenReturnBuilderCode42NameNameRegionUsEast2RegionCodeUsEast2Build() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("42")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act
    ImmutableCountry actualWithCodeResult = immutableCountry.withCode("42");

    // Assert
    assertSame(immutableCountry, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableCountry#withCode(String)}.
   *
   * <ul>
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withCode(String)"})
  void testWithCode_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableCountry actualWithCodeResult =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build()
            .withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Name", actualWithCodeResult.name());
    assertEquals("us-east-2", actualWithCodeResult.region());
    assertEquals("us-east-2", actualWithCodeResult.regionCode());
  }

  /**
   * Test {@link ImmutableCountry#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code Code} name {@code 42} region {@code us-east-2} regionCode
   *       {@code us-east-2} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then return builder code 'Code' name '42' region 'us-east-2' regionCode 'us-east-2' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withName(String)"})
  void testWithName_thenReturnBuilderCodeCodeName42RegionUsEast2RegionCodeUsEast2Build() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("42")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build();

    // Act
    ImmutableCountry actualWithNameResult = immutableCountry.withName("42");

    // Assert
    assertSame(immutableCountry, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableCountry#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableCountry actualWithNameResult =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Code", actualWithNameResult.code());
    assertEquals("us-east-2", actualWithNameResult.region());
    assertEquals("us-east-2", actualWithNameResult.regionCode());
  }

  /**
   * Test {@link ImmutableCountry#withRegionCode(String)}.
   *
   * <p>Method under test: {@link ImmutableCountry#withRegionCode(String)}
   */
  @Test
  @DisplayName("Test withRegionCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withRegionCode(String)"})
  void testWithRegionCode() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("42")
            .build();

    // Act
    ImmutableCountry actualWithRegionCodeResult = immutableCountry.withRegionCode("42");

    // Assert
    assertSame(immutableCountry, actualWithRegionCodeResult);
  }

  /**
   * Test {@link ImmutableCountry#withRegionCode(String)}.
   *
   * <ul>
   *   <li>Then return regionCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withRegionCode(String)}
   */
  @Test
  @DisplayName("Test withRegionCode(String); then return regionCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withRegionCode(String)"})
  void testWithRegionCode_thenReturnRegionCodeIs42() {
    // Arrange and Act
    ImmutableCountry actualWithRegionCodeResult =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build()
            .withRegionCode("42");

    // Assert
    assertEquals("42", actualWithRegionCodeResult.regionCode());
    assertEquals("Code", actualWithRegionCodeResult.code());
    assertEquals("Name", actualWithRegionCodeResult.name());
    assertEquals("us-east-2", actualWithRegionCodeResult.region());
  }

  /**
   * Test {@link ImmutableCountry#withRegion(String)}.
   *
   * <ul>
   *   <li>Then return builder code {@code Code} name {@code Name} region {@code 42} regionCode
   *       {@code us-east-2} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withRegion(String)}
   */
  @Test
  @DisplayName(
      "Test withRegion(String); then return builder code 'Code' name 'Name' region '42' regionCode 'us-east-2' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withRegion(String)"})
  void testWithRegion_thenReturnBuilderCodeCodeNameNameRegion42RegionCodeUsEast2Build() {
    // Arrange
    ImmutableCountry immutableCountry =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("42")
            .regionCode("us-east-2")
            .build();

    // Act
    ImmutableCountry actualWithRegionResult = immutableCountry.withRegion("42");

    // Assert
    assertSame(immutableCountry, actualWithRegionResult);
  }

  /**
   * Test {@link ImmutableCountry#withRegion(String)}.
   *
   * <ul>
   *   <li>Then return region is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCountry#withRegion(String)}
   */
  @Test
  @DisplayName("Test withRegion(String); then return region is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCountry ImmutableCountry.withRegion(String)"})
  void testWithRegion_thenReturnRegionIs42() {
    // Arrange and Act
    ImmutableCountry actualWithRegionResult =
        ImmutableCountry.builder()
            .code("Code")
            .name("Name")
            .region("us-east-2")
            .regionCode("us-east-2")
            .build()
            .withRegion("42");

    // Assert
    assertEquals("42", actualWithRegionResult.region());
    assertEquals("Code", actualWithRegionResult.code());
    assertEquals("Name", actualWithRegionResult.name());
    assertEquals("us-east-2", actualWithRegionResult.regionCode());
  }
}
