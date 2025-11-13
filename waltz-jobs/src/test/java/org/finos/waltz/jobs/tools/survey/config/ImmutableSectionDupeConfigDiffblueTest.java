package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.finos.waltz.jobs.tools.survey.config.ImmutableSectionDupeConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSectionDupeConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTargets(Iterable)}.
   *
   * <ul>
   *   <li>Given builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTargets(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllTargets(Iterable); given builder extIdPrefix 'Ext Id Prefix' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTargets(Iterable)"})
  void testBuilderAddAllTargets_givenBuilderExtIdPrefixExtIdPrefixNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());

    // Act
    Builder actualAddAllTargetsResult = builderResult.addAllTargets(elements);

    // Assert
    assertSame(builderResult, actualAddAllTargetsResult);
  }

  /**
   * Test Builder {@link Builder#addAllTargets(Iterable)}.
   *
   * <ul>
   *   <li>Given builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTargets(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllTargets(Iterable); given builder extIdPrefix 'Ext Id Prefix' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTargets(Iterable)"})
  void testBuilderAddAllTargets_givenBuilderExtIdPrefixExtIdPrefixNameNameBuild2() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());

    // Act
    Builder actualAddAllTargetsResult = builderResult.addAllTargets(elements);

    // Assert
    assertSame(builderResult, actualAddAllTargetsResult);
  }

  /**
   * Test Builder {@link Builder#addAllTargets(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTargets(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTargets(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTargets(Iterable)"})
  void testBuilderAddAllTargets_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualAddAllTargetsResult = builderResult.addAllTargets(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTargetsResult);
  }

  /**
   * Test Builder {@link Builder#addTargets(TargetSectionConfig)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTargets(TargetSectionConfig)}
   */
  @Test
  @DisplayName("Test Builder addTargets(TargetSectionConfig) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTargets(TargetSectionConfig)"})
  void testBuilderAddTargetsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualAddTargetsResult =
        builderResult.addTargets(
            ImmutableTargetSectionConfig.builder()
                .extIdPrefix("Ext Id Prefix")
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddTargetsResult);
  }

  /**
   * Test Builder {@link Builder#addTargets(TargetSectionConfig[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTargets(TargetSectionConfig[])}
   */
  @Test
  @DisplayName(
      "Test Builder addTargets(TargetSectionConfig[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTargets(TargetSectionConfig[])"})
  void testBuilderAddTargetsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualAddTargetsResult =
        builderResult.addTargets(
            ImmutableTargetSectionConfig.builder()
                .extIdPrefix("Ext Id Prefix")
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddTargetsResult);
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
  @MethodsUnderTest({"ImmutableSectionDupeConfig Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualSectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Assert
    assertEquals(
        "Section Name", actualSectionNameResult.targets(new ArrayList<>()).build().sectionName());
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   *
   * <p>Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig instance = sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSectionDupeConfig actualImmutableSectionDupeConfig = builderResult.build();
    assertEquals(instance, actualImmutableSectionDupeConfig);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   *
   * <ul>
   *   <li>Then return build targets size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig); then return build targets size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom_thenReturnBuildTargetsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());

    // Act and Assert
    ImmutableList<TargetSectionConfig> targetsResult =
        builderResult
            .from(
                ImmutableSectionDupeConfig.builder()
                    .sectionName("Section Name")
                    .targets(elements)
                    .build())
            .build()
            .targets();
    assertEquals(1, targetsResult.size());
    TargetSectionConfig getResult = targetsResult.get(0);
    assertTrue(getResult instanceof ImmutableTargetSectionConfig);
    assertEquals("Ext Id Prefix", getResult.extIdPrefix());
    assertEquals("Name", getResult.name());
  }

  /**
   * Test Builder {@link Builder#sectionName(String)}.
   *
   * <ul>
   *   <li>When {@code Section Name}.
   *   <li>Then builder build sectionName is {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sectionName(String)}
   */
  @Test
  @DisplayName(
      "Test Builder sectionName(String); when 'Section Name'; then builder build sectionName is 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sectionName(String)"})
  void testBuilderSectionName_whenSectionName_thenBuilderBuildSectionNameIsSectionName() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualSectionNameResult = builderResult.sectionName("Section Name");

    // Assert
    assertEquals("Section Name", builderResult.build().sectionName());
    assertSame(builderResult, actualSectionNameResult);
  }

  /**
   * Test Builder {@link Builder#targets(Iterable)}.
   *
   * <ul>
   *   <li>Given builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targets(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder targets(Iterable); given builder extIdPrefix 'Ext Id Prefix' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targets(Iterable)"})
  void testBuilderTargets_givenBuilderExtIdPrefixExtIdPrefixNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());

    // Act
    Builder actualTargetsResult = builderResult.targets(elements);

    // Assert
    assertSame(builderResult, actualTargetsResult);
  }

  /**
   * Test Builder {@link Builder#targets(Iterable)}.
   *
   * <ul>
   *   <li>Given builder extIdPrefix {@code Ext Id Prefix} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targets(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder targets(Iterable); given builder extIdPrefix 'Ext Id Prefix' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targets(Iterable)"})
  void testBuilderTargets_givenBuilderExtIdPrefixExtIdPrefixNameNameBuild2() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());

    // Act
    Builder actualTargetsResult = builderResult.targets(elements);

    // Assert
    assertSame(builderResult, actualTargetsResult);
  }

  /**
   * Test Builder {@link Builder#targets(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targets(Iterable)}
   */
  @Test
  @DisplayName("Test Builder targets(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targets(Iterable)"})
  void testBuilderTargets_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualTargetsResult = builderResult.targets(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTargetsResult);
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}.
   *
   * <ul>
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test copyOf(SectionDupeConfig); then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSectionDupeConfig ImmutableSectionDupeConfig.copyOf(SectionDupeConfig)"
  })
  void testCopyOf_thenReturnSectionName() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig instance = sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    ImmutableSectionDupeConfig actualCopyOfResult = ImmutableSectionDupeConfig.copyOf(instance);

    // Assert
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertTrue(actualCopyOfResult.targets().isEmpty());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}, and {@link
   * ImmutableSectionDupeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSectionDupeConfig#equals(Object)}
   *   <li>{@link ImmutableSectionDupeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    Builder sectionNameResult2 = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig2 =
        sectionNameResult2.targets(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableSectionDupeConfig, immutableSectionDupeConfig2);
    assertEquals(immutableSectionDupeConfig.hashCode(), immutableSectionDupeConfig2.hashCode());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}, and {@link
   * ImmutableSectionDupeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSectionDupeConfig#equals(Object)}
   *   <li>{@link ImmutableSectionDupeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableSectionDupeConfig, immutableSectionDupeConfig);
    int expectedHashCodeResult = immutableSectionDupeConfig.hashCode();
    assertEquals(expectedHashCodeResult, immutableSectionDupeConfig.hashCode());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("java.lang.String");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    Builder sectionNameResult2 = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act and Assert
    assertNotEquals(
        immutableSectionDupeConfig, sectionNameResult2.targets(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name").targets(elements).build();

    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act and Assert
    assertNotEquals(
        immutableSectionDupeConfig, sectionNameResult.targets(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act and Assert
    assertNotEquals(sectionNameResult.targets(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSectionDupeConfig.equals(Object)",
    "int ImmutableSectionDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act and Assert
    assertNotEquals(
        sectionNameResult.targets(new ArrayList<>()).build(),
        "Different type to ImmutableSectionDupeConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSectionDupeConfig#toString()}
   *   <li>{@link ImmutableSectionDupeConfig#sectionName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSectionDupeConfig.sectionName()",
    "String ImmutableSectionDupeConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    String actualToStringResult = immutableSectionDupeConfig.toString();

    // Assert
    assertEquals("Section Name", immutableSectionDupeConfig.sectionName());
    assertEquals("SectionDupeConfig{sectionName=Section Name, targets=[]}", actualToStringResult);
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#targets()}.
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#targets()}
   */
  @Test
  @DisplayName("Test targets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableList ImmutableSectionDupeConfig.targets()"})
  void testTargets() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act and Assert
    assertTrue(sectionNameResult.targets(new ArrayList<>()).build().targets().isEmpty());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#withSectionName(String)}.
   *
   * <ul>
   *   <li>Then return builder sectionName {@code 42} targets {@link ArrayList#ArrayList()} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#withSectionName(String)}
   */
  @Test
  @DisplayName(
      "Test withSectionName(String); then return builder sectionName '42' targets ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSectionDupeConfig ImmutableSectionDupeConfig.withSectionName(String)"
  })
  void testWithSectionName_thenReturnBuilderSectionName42TargetsArrayListBuild() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("42");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    ImmutableSectionDupeConfig actualWithSectionNameResult =
        immutableSectionDupeConfig.withSectionName("42");

    // Assert
    assertSame(immutableSectionDupeConfig, actualWithSectionNameResult);
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#withSectionName(String)}.
   *
   * <ul>
   *   <li>Then return sectionName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String); then return sectionName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSectionDupeConfig ImmutableSectionDupeConfig.withSectionName(String)"
  })
  void testWithSectionName_thenReturnSectionNameIs42() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act
    ImmutableSectionDupeConfig actualWithSectionNameResult =
        sectionNameResult.targets(new ArrayList<>()).build().withSectionName("42");

    // Assert
    assertEquals("42", actualWithSectionNameResult.sectionName());
    assertTrue(actualWithSectionNameResult.targets().isEmpty());
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#withTargets(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#withTargets(Iterable)}
   */
  @Test
  @DisplayName("Test withTargets(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSectionDupeConfig ImmutableSectionDupeConfig.withTargets(Iterable)"})
  void testWithTargetsWithIterable() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    ImmutableSectionDupeConfig actualWithTargetsResult =
        immutableSectionDupeConfig.withTargets(new ArrayList<>());

    // Assert
    assertEquals(immutableSectionDupeConfig, actualWithTargetsResult);
  }

  /**
   * Test {@link ImmutableSectionDupeConfig#withTargets(TargetSectionConfig[])} with {@code
   * TargetSectionConfig[]}.
   *
   * <ul>
   *   <li>Then return targets size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSectionDupeConfig#withTargets(TargetSectionConfig[])}
   */
  @Test
  @DisplayName(
      "Test withTargets(TargetSectionConfig[]) with 'TargetSectionConfig[]'; then return targets size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSectionDupeConfig ImmutableSectionDupeConfig.withTargets(TargetSectionConfig[])"
  })
  void testWithTargetsWithTargetSectionConfig_thenReturnTargetsSizeIsOne() {
    // Arrange
    Builder sectionNameResult = ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        sectionNameResult.targets(new ArrayList<>()).build();

    // Act
    ImmutableSectionDupeConfig actualWithTargetsResult =
        immutableSectionDupeConfig.withTargets(
            ImmutableTargetSectionConfig.builder()
                .extIdPrefix("Ext Id Prefix")
                .name("Name")
                .build());

    // Assert
    ImmutableList<TargetSectionConfig> targetsResult = actualWithTargetsResult.targets();
    assertEquals(1, targetsResult.size());
    TargetSectionConfig getResult = targetsResult.get(0);
    assertTrue(getResult instanceof ImmutableTargetSectionConfig);
    assertEquals("Ext Id Prefix", getResult.extIdPrefix());
    assertEquals("Name", getResult.name());
    assertEquals("Section Name", actualWithTargetsResult.sectionName());
  }
}
