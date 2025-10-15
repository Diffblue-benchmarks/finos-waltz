package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableApplicationRow.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationRowDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endDate(String)}
   *   <li>{@link Builder#startDate(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationRow Builder.build()",
    "Builder Builder.endDate(String)",
    "Builder Builder.startDate(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableApplicationRow actualImmutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableApplicationRow.version());
    assertEquals("2020-03-01", actualImmutableApplicationRow.endDate());
    assertEquals("2020-03-01", actualImmutableApplicationRow.startDate());
    assertEquals("42", actualImmutableApplicationRow.externalId());
    assertEquals("42", actualImmutableApplicationRow.internalId());
    assertEquals("Name", actualImmutableApplicationRow.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableApplicationRow.lifecyclePhase());
    assertTrue(actualImmutableApplicationRow.businessCritical());
  }

  /**
   * Test Builder {@link Builder#businessCritical(boolean)}.
   *
   * <p>Method under test: {@link Builder#businessCritical(boolean)}
   */
  @Test
  @DisplayName("Test Builder businessCritical(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.businessCritical(boolean)"})
  void testBuilderBusinessCritical() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualBusinessCriticalResult = builderResult.businessCritical(true);

    // Assert
    assertSame(builderResult, actualBusinessCriticalResult);
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationRow)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
    ImmutableApplicationRow instance =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationRow actualImmutableApplicationRow = builderResult.build();
    assertEquals(instance, actualImmutableApplicationRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationRow)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
    ImmutableApplicationRow instance =
        ImmutableApplicationRow.builder()
            .businessCritical(false)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationRow actualImmutableApplicationRow = builderResult.build();
    assertEquals(instance, actualImmutableApplicationRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationRow)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
    ImmutableApplicationRow instance =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate(null)
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationRow actualImmutableApplicationRow = builderResult.build();
    assertEquals(instance, actualImmutableApplicationRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationRow)}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationRow)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationRow)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();
    ImmutableApplicationRow instance =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate(null)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationRow actualImmutableApplicationRow = builderResult.build();
    assertEquals(instance, actualImmutableApplicationRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#internalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualInternalIdResult = builderResult.internalId("42");

    // Assert
    assertSame(builderResult, actualInternalIdResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
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
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationRow.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#copyOf(ApplicationRow)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#copyOf(ApplicationRow)}
   */
  @Test
  @DisplayName("Test copyOf(ApplicationRow); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.copyOf(ApplicationRow)"})
  void testCopyOf_thenReturnVersionIs102() {
    // Arrange
    ImmutableApplicationRow instance =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualCopyOfResult = ImmutableApplicationRow.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.startDate());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.internalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}, and {@link
   * ImmutableApplicationRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationRow#equals(Object)}
   *   <li>{@link ImmutableApplicationRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();
    ImmutableApplicationRow immutableApplicationRow2 =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableApplicationRow, immutableApplicationRow2);
    assertEquals(immutableApplicationRow.hashCode(), immutableApplicationRow2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}, and {@link
   * ImmutableApplicationRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationRow#equals(Object)}
   *   <li>{@link ImmutableApplicationRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableApplicationRow, immutableApplicationRow);
    int expectedHashCodeResult = immutableApplicationRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationRow.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(false)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020/03/01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("Name")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("Name")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020/03/01")
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationRow,
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.equals(Object)",
    "int ImmutableApplicationRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build(),
        "Different type to ImmutableApplicationRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationRow#toString()}
   *   <li>{@link ImmutableApplicationRow#businessCritical()}
   *   <li>{@link ImmutableApplicationRow#endDate()}
   *   <li>{@link ImmutableApplicationRow#externalId()}
   *   <li>{@link ImmutableApplicationRow#internalId()}
   *   <li>{@link ImmutableApplicationRow#lifecyclePhase()}
   *   <li>{@link ImmutableApplicationRow#name()}
   *   <li>{@link ImmutableApplicationRow#startDate()}
   *   <li>{@link ImmutableApplicationRow#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationRow.businessCritical()",
    "String ImmutableApplicationRow.endDate()",
    "String ImmutableApplicationRow.externalId()",
    "String ImmutableApplicationRow.internalId()",
    "LifecyclePhase ImmutableApplicationRow.lifecyclePhase()",
    "String ImmutableApplicationRow.name()",
    "String ImmutableApplicationRow.startDate()",
    "String ImmutableApplicationRow.toString()",
    "String ImmutableApplicationRow.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    String actualToStringResult = immutableApplicationRow.toString();
    boolean actualBusinessCriticalResult = immutableApplicationRow.businessCritical();
    String actualEndDateResult = immutableApplicationRow.endDate();
    String actualExternalIdResult = immutableApplicationRow.externalId();
    String actualInternalIdResult = immutableApplicationRow.internalId();
    LifecyclePhase actualLifecyclePhaseResult = immutableApplicationRow.lifecyclePhase();
    String actualNameResult = immutableApplicationRow.name();
    String actualStartDateResult = immutableApplicationRow.startDate();

    // Assert
    assertEquals("1.0.2", immutableApplicationRow.version());
    assertEquals("2020-03-01", actualEndDateResult);
    assertEquals("2020-03-01", actualStartDateResult);
    assertEquals("42", actualExternalIdResult);
    assertEquals("42", actualInternalIdResult);
    assertEquals(
        "ApplicationRow{externalId=42, internalId=42, name=Name, version=1.0.2, businessCritical=true,"
            + " lifecyclePhase=PRODUCTION, startDate=2020-03-01, endDate=2020-03-01}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertTrue(actualBusinessCriticalResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withBusinessCritical(boolean)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withBusinessCritical(boolean)}
   */
  @Test
  @DisplayName("Test withBusinessCritical(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationRow ImmutableApplicationRow.withBusinessCritical(boolean)"
  })
  void testWithBusinessCritical() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithBusinessCriticalResult =
        immutableApplicationRow.withBusinessCritical(true);

    // Assert
    assertSame(immutableApplicationRow, actualWithBusinessCriticalResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withBusinessCritical(boolean)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withBusinessCritical(boolean)}
   */
  @Test
  @DisplayName("Test withBusinessCritical(boolean); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationRow ImmutableApplicationRow.withBusinessCritical(boolean)"
  })
  void testWithBusinessCritical_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithBusinessCriticalResult =
        ImmutableApplicationRow.builder()
            .businessCritical(false)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withBusinessCritical(true);

    // Assert
    assertEquals("1.0.2", actualWithBusinessCriticalResult.version());
    assertEquals("2020-03-01", actualWithBusinessCriticalResult.endDate());
    assertEquals("2020-03-01", actualWithBusinessCriticalResult.startDate());
    assertEquals("42", actualWithBusinessCriticalResult.externalId());
    assertEquals("42", actualWithBusinessCriticalResult.internalId());
    assertEquals("Name", actualWithBusinessCriticalResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithBusinessCriticalResult.lifecyclePhase());
    assertTrue(actualWithBusinessCriticalResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withEndDate(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withEndDate(String)"})
  void testWithEndDate() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("42")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithEndDateResult = immutableApplicationRow.withEndDate("42");

    // Assert
    assertSame(immutableApplicationRow, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withEndDate(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withEndDate(String)}
   */
  @Test
  @DisplayName("Test withEndDate(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withEndDate(String)"})
  void testWithEndDate_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithEndDateResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withEndDate("42");

    // Assert
    assertEquals("1.0.2", actualWithEndDateResult.version());
    assertEquals("2020-03-01", actualWithEndDateResult.startDate());
    assertEquals("42", actualWithEndDateResult.endDate());
    assertEquals("42", actualWithEndDateResult.externalId());
    assertEquals("42", actualWithEndDateResult.internalId());
    assertEquals("Name", actualWithEndDateResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithEndDateResult.lifecyclePhase());
    assertTrue(actualWithEndDateResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withExternalId(String)"})
  void testWithExternalId() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("0123456789ABCDEF")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithExternalIdResult =
        immutableApplicationRow.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableApplicationRow, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withExternalId(String)"})
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableApplicationRow actualWithExternalIdResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("1.0.2", actualWithExternalIdResult.version());
    assertEquals("2020-03-01", actualWithExternalIdResult.endDate());
    assertEquals("2020-03-01", actualWithExternalIdResult.startDate());
    assertEquals("42", actualWithExternalIdResult.internalId());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
    assertTrue(actualWithExternalIdResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withInternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withInternalId(String)"})
  void testWithInternalId() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithInternalIdResult =
        immutableApplicationRow.withInternalId("42");

    // Assert
    assertSame(immutableApplicationRow, actualWithInternalIdResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withInternalId(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withInternalId(String)}
   */
  @Test
  @DisplayName("Test withInternalId(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withInternalId(String)"})
  void testWithInternalId_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithInternalIdResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("internalId")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withInternalId("42");

    // Assert
    assertEquals("1.0.2", actualWithInternalIdResult.version());
    assertEquals("2020-03-01", actualWithInternalIdResult.endDate());
    assertEquals("2020-03-01", actualWithInternalIdResult.startDate());
    assertEquals("42", actualWithInternalIdResult.externalId());
    assertEquals("42", actualWithInternalIdResult.internalId());
    assertEquals("Name", actualWithInternalIdResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithInternalIdResult.lifecyclePhase());
    assertTrue(actualWithInternalIdResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationRow ImmutableApplicationRow.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithLifecyclePhaseResult =
        immutableApplicationRow.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableApplicationRow, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationRow ImmutableApplicationRow.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithLifecyclePhaseResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("1.0.2", actualWithLifecyclePhaseResult.version());
    assertEquals("2020-03-01", actualWithLifecyclePhaseResult.endDate());
    assertEquals("2020-03-01", actualWithLifecyclePhaseResult.startDate());
    assertEquals("42", actualWithLifecyclePhaseResult.externalId());
    assertEquals("42", actualWithLifecyclePhaseResult.internalId());
    assertEquals("Name", actualWithLifecyclePhaseResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
    assertTrue(actualWithLifecyclePhaseResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithNameResult = immutableApplicationRow.withName("42");

    // Assert
    assertSame(immutableApplicationRow, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withName(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withName(String)"})
  void testWithName_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithNameResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withName("42");

    // Assert
    assertEquals("1.0.2", actualWithNameResult.version());
    assertEquals("2020-03-01", actualWithNameResult.endDate());
    assertEquals("2020-03-01", actualWithNameResult.startDate());
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.internalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
    assertTrue(actualWithNameResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withStartDate(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withStartDate(String)"})
  void testWithStartDate() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("42")
            .version("1.0.2")
            .build();

    // Act
    ImmutableApplicationRow actualWithStartDateResult = immutableApplicationRow.withStartDate("42");

    // Assert
    assertSame(immutableApplicationRow, actualWithStartDateResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withStartDate(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withStartDate(String)}
   */
  @Test
  @DisplayName("Test withStartDate(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withStartDate(String)"})
  void testWithStartDate_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutableApplicationRow actualWithStartDateResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withStartDate("42");

    // Assert
    assertEquals("1.0.2", actualWithStartDateResult.version());
    assertEquals("2020-03-01", actualWithStartDateResult.endDate());
    assertEquals("42", actualWithStartDateResult.externalId());
    assertEquals("42", actualWithStartDateResult.internalId());
    assertEquals("42", actualWithStartDateResult.startDate());
    assertEquals("Name", actualWithStartDateResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithStartDateResult.lifecyclePhase());
    assertTrue(actualWithStartDateResult.businessCritical());
  }

  /**
   * Test {@link ImmutableApplicationRow#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withVersion(String)"})
  void testWithVersion() {
    // Arrange
    ImmutableApplicationRow immutableApplicationRow =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("42")
            .build();

    // Act
    ImmutableApplicationRow actualWithVersionResult = immutableApplicationRow.withVersion("42");

    // Assert
    assertSame(immutableApplicationRow, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutableApplicationRow#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return endDate is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationRow#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return endDate is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableApplicationRow ImmutableApplicationRow.withVersion(String)"})
  void testWithVersion_thenReturnEndDateIs20200301() {
    // Arrange and Act
    ImmutableApplicationRow actualWithVersionResult =
        ImmutableApplicationRow.builder()
            .businessCritical(true)
            .endDate("2020-03-01")
            .externalId("42")
            .internalId("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .startDate("2020-03-01")
            .version("1.0.2")
            .build()
            .withVersion("42");

    // Assert
    assertEquals("2020-03-01", actualWithVersionResult.endDate());
    assertEquals("2020-03-01", actualWithVersionResult.startDate());
    assertEquals("42", actualWithVersionResult.externalId());
    assertEquals("42", actualWithVersionResult.internalId());
    assertEquals("42", actualWithVersionResult.version());
    assertEquals("Name", actualWithVersionResult.name());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithVersionResult.lifecyclePhase());
    assertTrue(actualWithVersionResult.businessCritical());
  }
}
