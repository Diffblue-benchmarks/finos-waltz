package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.survey.config.ImmutableTargetSectionConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetSectionConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTargetSectionConfig Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableTargetSectionConfig actualImmutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Assert
    assertEquals("Ext Id Prefix", actualImmutableTargetSectionConfig.extIdPrefix());
    assertEquals("Name", actualImmutableTargetSectionConfig.name());
  }

  /**
   * Test Builder {@link Builder#extIdPrefix(String)}.
   *
   * <ul>
   *   <li>When {@code Ext Id Prefix}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#extIdPrefix(String)}
   */
  @Test
  @DisplayName("Test Builder extIdPrefix(String); when 'Ext Id Prefix'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.extIdPrefix(String)"})
  void testBuilderExtIdPrefix_whenExtIdPrefix_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act
    Builder actualExtIdPrefixResult = builderResult.extIdPrefix("Ext Id Prefix");

    // Assert
    assertSame(builderResult, actualExtIdPrefixResult);
  }

  /**
   * Test Builder {@link Builder#from(TargetSectionConfig)}.
   *
   * <ul>
   *   <li>Then builder build is builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(TargetSectionConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder from(TargetSectionConfig); then builder build is builder extIdPrefix 'Ext Id Prefix' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TargetSectionConfig)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderExtIdPrefixExtIdPrefixNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();
    ImmutableTargetSectionConfig instance =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTargetSectionConfig actualImmutableTargetSectionConfig = builderResult.build();
    assertEquals(instance, actualImmutableTargetSectionConfig);
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
    Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#copyOf(TargetSectionConfig)}.
   *
   * <ul>
   *   <li>When builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   *   <li>Then return {@code Ext Id Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#copyOf(TargetSectionConfig)}
   */
  @Test
  @DisplayName(
      "Test copyOf(TargetSectionConfig); when builder extIdPrefix 'Ext Id Prefix' name 'Name' build; then return 'Ext Id Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetSectionConfig ImmutableTargetSectionConfig.copyOf(TargetSectionConfig)"
  })
  void testCopyOf_whenBuilderExtIdPrefixExtIdPrefixNameNameBuild_thenReturnExtIdPrefix() {
    // Arrange
    ImmutableTargetSectionConfig instance =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Act
    ImmutableTargetSectionConfig actualCopyOfResult = ImmutableTargetSectionConfig.copyOf(instance);

    // Assert
    assertEquals("Ext Id Prefix", actualCopyOfResult.extIdPrefix());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}, and {@link
   * ImmutableTargetSectionConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetSectionConfig#equals(Object)}
   *   <li>{@link ImmutableTargetSectionConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();
    ImmutableTargetSectionConfig immutableTargetSectionConfig2 =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Act and Assert
    assertEquals(immutableTargetSectionConfig, immutableTargetSectionConfig2);
    assertEquals(immutableTargetSectionConfig.hashCode(), immutableTargetSectionConfig2.hashCode());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}, and {@link
   * ImmutableTargetSectionConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetSectionConfig#equals(Object)}
   *   <li>{@link ImmutableTargetSectionConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Act and Assert
    assertEquals(immutableTargetSectionConfig, immutableTargetSectionConfig);
    int expectedHashCodeResult = immutableTargetSectionConfig.hashCode();
    assertEquals(expectedHashCodeResult, immutableTargetSectionConfig.hashCode());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Name").name("Name").build();

    // Act and Assert
    assertNotEquals(
        immutableTargetSectionConfig,
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder()
            .extIdPrefix("Ext Id Prefix")
            .name("Ext Id Prefix")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTargetSectionConfig,
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build(),
        null);
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetSectionConfig.equals(Object)",
    "int ImmutableTargetSectionConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build(),
        "Different type to ImmutableTargetSectionConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetSectionConfig#toString()}
   *   <li>{@link ImmutableTargetSectionConfig#extIdPrefix()}
   *   <li>{@link ImmutableTargetSectionConfig#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTargetSectionConfig.extIdPrefix()",
    "String ImmutableTargetSectionConfig.name()",
    "String ImmutableTargetSectionConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build();

    // Act
    String actualToStringResult = immutableTargetSectionConfig.toString();
    String actualExtIdPrefixResult = immutableTargetSectionConfig.extIdPrefix();

    // Assert
    assertEquals("Ext Id Prefix", actualExtIdPrefixResult);
    assertEquals("Name", immutableTargetSectionConfig.name());
    assertEquals("TargetSectionConfig{name=Name, extIdPrefix=Ext Id Prefix}", actualToStringResult);
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#withExtIdPrefix(String)}.
   *
   * <ul>
   *   <li>Then return builder extIdPrefix {@code 0123456789ABCDEF} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#withExtIdPrefix(String)}
   */
  @Test
  @DisplayName(
      "Test withExtIdPrefix(String); then return builder extIdPrefix '0123456789ABCDEF' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetSectionConfig ImmutableTargetSectionConfig.withExtIdPrefix(String)"
  })
  void testWithExtIdPrefix_thenReturnBuilderExtIdPrefix0123456789abcdefNameNameBuild() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("0123456789ABCDEF").name("Name").build();

    // Act
    ImmutableTargetSectionConfig actualWithExtIdPrefixResult =
        immutableTargetSectionConfig.withExtIdPrefix("0123456789ABCDEF");

    // Assert
    assertSame(immutableTargetSectionConfig, actualWithExtIdPrefixResult);
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#withExtIdPrefix(String)}.
   *
   * <ul>
   *   <li>Then return extIdPrefix is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#withExtIdPrefix(String)}
   */
  @Test
  @DisplayName("Test withExtIdPrefix(String); then return extIdPrefix is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetSectionConfig ImmutableTargetSectionConfig.withExtIdPrefix(String)"
  })
  void testWithExtIdPrefix_thenReturnExtIdPrefixIs0123456789abcdef() {
    // Arrange and Act
    ImmutableTargetSectionConfig actualWithExtIdPrefixResult =
        ImmutableTargetSectionConfig.builder()
            .extIdPrefix("Ext Id Prefix")
            .name("Name")
            .build()
            .withExtIdPrefix("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExtIdPrefixResult.extIdPrefix());
    assertEquals("Name", actualWithExtIdPrefixResult.name());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#withName(String)}.
   *
   * <ul>
   *   <li>Given builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder extIdPrefix 'Ext Id Prefix' name 'Name' build; then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTargetSectionConfig ImmutableTargetSectionConfig.withName(String)"})
  void testWithName_givenBuilderExtIdPrefixExtIdPrefixNameNameBuild_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableTargetSectionConfig actualWithNameResult =
        ImmutableTargetSectionConfig.builder()
            .extIdPrefix("Ext Id Prefix")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Ext Id Prefix", actualWithNameResult.extIdPrefix());
  }

  /**
   * Test {@link ImmutableTargetSectionConfig#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder extIdPrefix {@code Ext Id Prefix} name {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetSectionConfig#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then return builder extIdPrefix 'Ext Id Prefix' name '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTargetSectionConfig ImmutableTargetSectionConfig.withName(String)"})
  void testWithName_thenReturnBuilderExtIdPrefixExtIdPrefixName42Build() {
    // Arrange
    ImmutableTargetSectionConfig immutableTargetSectionConfig =
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("42").build();

    // Act
    ImmutableTargetSectionConfig actualWithNameResult = immutableTargetSectionConfig.withName("42");

    // Assert
    assertSame(immutableTargetSectionConfig, actualWithNameResult);
  }
}
