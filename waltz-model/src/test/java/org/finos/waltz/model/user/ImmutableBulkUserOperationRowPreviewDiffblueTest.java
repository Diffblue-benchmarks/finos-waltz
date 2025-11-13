package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.BulkUserOperationRowPreview.ResolutionStatus;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview.Builder;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUserOperationRowPreviewDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#givenComment(String)}
   *   <li>{@link Builder#givenRole(String)}
   *   <li>{@link Builder#givenUser(String)}
   *   <li>{@link Builder#resolvedComment(String)}
   *   <li>{@link Builder#resolvedRole(String)}
   *   <li>{@link Builder#resolvedUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview Builder.build()",
    "Builder Builder.givenComment(String)",
    "Builder Builder.givenRole(String)",
    "Builder Builder.givenUser(String)",
    "Builder Builder.resolvedComment(String)",
    "Builder Builder.resolvedRole(String)",
    "Builder Builder.resolvedUser(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Assert
    assertEquals("Given Comment", actualImmutableBulkUserOperationRowPreview.givenComment());
    assertEquals("Given Role", actualImmutableBulkUserOperationRowPreview.givenRole());
    assertEquals("Given User", actualImmutableBulkUserOperationRowPreview.givenUser());
    assertEquals("Resolved Comment", actualImmutableBulkUserOperationRowPreview.resolvedComment());
    assertEquals("Resolved Role", actualImmutableBulkUserOperationRowPreview.resolvedRole());
    assertEquals("Resolved User", actualImmutableBulkUserOperationRowPreview.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualImmutableBulkUserOperationRowPreview.status());
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment(null)
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole(null)
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser(null)
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom6() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole(null)
            .resolvedUser("Resolved User")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUserOperationRowPreview)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUserOperationRowPreview)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUserOperationRowPreview)"})
  void testBuilderFrom7() {
    // Arrange
    Builder builderResult = ImmutableBulkUserOperationRowPreview.builder();
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUserOperationRowPreview actualImmutableBulkUserOperationRowPreview =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUserOperationRowPreview);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}.
   *
   * <ul>
   *   <li>Then return {@code Given Comment}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUserOperationRowPreview#copyOf(BulkUserOperationRowPreview)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUserOperationRowPreview); then return 'Given Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.copyOf(BulkUserOperationRowPreview)"
  })
  void testCopyOf_thenReturnGivenComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview instance =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualCopyOfResult =
        ImmutableBulkUserOperationRowPreview.copyOf(instance);

    // Assert
    assertEquals("Given Comment", actualCopyOfResult.givenComment());
    assertEquals("Given Role", actualCopyOfResult.givenRole());
    assertEquals("Given User", actualCopyOfResult.givenUser());
    assertEquals("Resolved Comment", actualCopyOfResult.resolvedComment());
    assertEquals("Resolved Role", actualCopyOfResult.resolvedRole());
    assertEquals("Resolved User", actualCopyOfResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualCopyOfResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}, and {@link
   * ImmutableBulkUserOperationRowPreview#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview2 =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertEquals(immutableBulkUserOperationRowPreview, immutableBulkUserOperationRowPreview2);
    assertEquals(
        immutableBulkUserOperationRowPreview.hashCode(),
        immutableBulkUserOperationRowPreview2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}, and {@link
   * ImmutableBulkUserOperationRowPreview#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertEquals(immutableBulkUserOperationRowPreview, immutableBulkUserOperationRowPreview);
    int expectedHashCodeResult = immutableBulkUserOperationRowPreview.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUserOperationRowPreview.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("42")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("42")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("42")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("42")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("42")
            .resolvedUser("Resolved User")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUserOperationRowPreview,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUserOperationRowPreview.equals(Object)",
    "int ImmutableBulkUserOperationRowPreview.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build(),
        "Different type to ImmutableBulkUserOperationRowPreview");
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given empty string; then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"
  })
  void testFromJson_givenEmptyString_thenReturnResolvedUserIsEmptyString() {
    // Arrange
    Json json = new Json();
    json.setGivenUser("Json");
    json.setGivenRole("Json");
    json.setGivenComment("Json");
    json.setResolvedUser("");
    json.setResolvedRole("Json");
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult =
        ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("", actualFromJsonResult.resolvedUser());
    assertEquals("Json", actualFromJsonResult.givenComment());
    assertEquals("Json", actualFromJsonResult.givenRole());
    assertEquals("Json", actualFromJsonResult.givenUser());
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) ResolvedUser is {@code Json}.
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) ResolvedUser is 'Json'; then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonResolvedUserIsJson_thenReturnStatusIsOk() {
    // Arrange
    Json json = new Json();
    json.setGivenUser("Json");
    json.setGivenRole("Json");
    json.setGivenComment("Json");
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult =
        ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ResolvedRole is {@code null}.
   *   <li>Then return resolvedRole is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ResolvedRole is 'null'; then return resolvedRole is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonResolvedRoleIsNull_thenReturnResolvedRoleIsNull() {
    // Arrange
    Json json = new Json();
    json.setGivenUser("Json");
    json.setGivenRole("Json");
    json.setGivenComment("Json");
    json.setResolvedUser("Json");
    json.setResolvedRole(null);
    json.setResolvedComment("Json");

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult =
        ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenComment());
    assertEquals("Json", actualFromJsonResult.givenRole());
    assertEquals("Json", actualFromJsonResult.givenUser());
    assertEquals("Json", actualFromJsonResult.resolvedComment());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ResolvedComment is {@code null}.
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ResolvedComment is 'null'; then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"
  })
  void testFromJson_whenJsonResolvedCommentIsNull_thenReturnResolvedCommentIsNull() {
    // Arrange
    Json json = new Json();
    json.setGivenUser("Json");
    json.setGivenRole("Json");
    json.setGivenComment("Json");
    json.setResolvedUser("Json");
    json.setResolvedRole("Json");
    json.setResolvedComment(null);

    // Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult =
        ImmutableBulkUserOperationRowPreview.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.givenComment());
    assertEquals("Json", actualFromJsonResult.givenRole());
    assertEquals("Json", actualFromJsonResult.givenUser());
    assertEquals("Json", actualFromJsonResult.resolvedRole());
    assertEquals("Json", actualFromJsonResult.resolvedUser());
    assertNull(actualFromJsonResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualFromJsonResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return givenComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return givenComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnGivenCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualFromJsonResult =
        ImmutableBulkUserOperationRowPreview.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.givenComment());
    assertNull(actualFromJsonResult.givenRole());
    assertNull(actualFromJsonResult.givenUser());
    assertNull(actualFromJsonResult.resolvedUser());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUserOperationRowPreview#toString()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenComment()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenRole()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#givenUser()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedComment()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedRole()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#resolvedUser()}
   *   <li>{@link ImmutableBulkUserOperationRowPreview#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkUserOperationRowPreview.givenComment()",
    "String ImmutableBulkUserOperationRowPreview.givenRole()",
    "String ImmutableBulkUserOperationRowPreview.givenUser()",
    "String ImmutableBulkUserOperationRowPreview.resolvedComment()",
    "String ImmutableBulkUserOperationRowPreview.resolvedRole()",
    "String ImmutableBulkUserOperationRowPreview.resolvedUser()",
    "ResolutionStatus ImmutableBulkUserOperationRowPreview.status()",
    "String ImmutableBulkUserOperationRowPreview.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    String actualToStringResult = immutableBulkUserOperationRowPreview.toString();
    String actualGivenCommentResult = immutableBulkUserOperationRowPreview.givenComment();
    String actualGivenRoleResult = immutableBulkUserOperationRowPreview.givenRole();
    String actualGivenUserResult = immutableBulkUserOperationRowPreview.givenUser();
    String actualResolvedCommentResult = immutableBulkUserOperationRowPreview.resolvedComment();
    String actualResolvedRoleResult = immutableBulkUserOperationRowPreview.resolvedRole();
    String actualResolvedUserResult = immutableBulkUserOperationRowPreview.resolvedUser();

    // Assert
    assertEquals(
        "BulkUserOperationRowPreview{givenUser=Given User, givenRole=Given Role, givenComment=Given Comment,"
            + " resolvedUser=Resolved User, resolvedRole=Resolved Role, resolvedComment=Resolved Comment,"
            + " status=OK}",
        actualToStringResult);
    assertEquals("Given Comment", actualGivenCommentResult);
    assertEquals("Given Role", actualGivenRoleResult);
    assertEquals("Given User", actualGivenUserResult);
    assertEquals("Resolved Comment", actualResolvedCommentResult);
    assertEquals("Resolved Role", actualResolvedRoleResult);
    assertEquals("Resolved User", actualResolvedUserResult);
    assertEquals(ResolutionStatus.OK, immutableBulkUserOperationRowPreview.status());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGivenComment(String)}
   *   <li>{@link Json#setGivenRole(String)}
   *   <li>{@link Json#setGivenUser(String)}
   *   <li>{@link Json#setResolvedComment(String)}
   *   <li>{@link Json#setResolvedRole(String)}
   *   <li>{@link Json#setResolvedUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setGivenComment(String)",
    "void Json.setGivenRole(String)",
    "void Json.setGivenUser(String)",
    "void Json.setResolvedComment(String)",
    "void Json.setResolvedRole(String)",
    "void Json.setResolvedUser(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGivenComment("Given Comment");
    actualJson.setGivenRole("Given Role");
    actualJson.setGivenUser("Given User");
    actualJson.setResolvedComment("Resolved Comment");
    actualJson.setResolvedRole("Resolved Role");
    actualJson.setResolvedUser("Resolved User");

    // Assert
    assertEquals("Given Comment", actualJson.givenComment);
    assertEquals("Given Role", actualJson.givenRole);
    assertEquals("Given User", actualJson.givenUser);
    assertEquals("Resolved Comment", actualJson.resolvedComment);
    assertEquals("Resolved Role", actualJson.resolvedRole);
    assertEquals("Resolved User", actualJson.resolvedUser);
  }

  /**
   * Test Json {@link Json#givenComment()}.
   *
   * <p>Method under test: {@link Json#givenComment()}
   */
  @Test
  @DisplayName("Test Json givenComment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.givenComment()"})
  void testJsonGivenComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().givenComment());
  }

  /**
   * Test Json {@link Json#givenRole()}.
   *
   * <p>Method under test: {@link Json#givenRole()}
   */
  @Test
  @DisplayName("Test Json givenRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.givenRole()"})
  void testJsonGivenRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().givenRole());
  }

  /**
   * Test Json {@link Json#givenUser()}.
   *
   * <p>Method under test: {@link Json#givenUser()}
   */
  @Test
  @DisplayName("Test Json givenUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.givenUser()"})
  void testJsonGivenUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().givenUser());
  }

  /**
   * Test Json {@link Json#resolvedComment()}.
   *
   * <p>Method under test: {@link Json#resolvedComment()}
   */
  @Test
  @DisplayName("Test Json resolvedComment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.resolvedComment()"})
  void testJsonResolvedComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedComment());
  }

  /**
   * Test Json {@link Json#resolvedRole()}.
   *
   * <p>Method under test: {@link Json#resolvedRole()}
   */
  @Test
  @DisplayName("Test Json resolvedRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.resolvedRole()"})
  void testJsonResolvedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedRole());
  }

  /**
   * Test Json {@link Json#resolvedUser()}.
   *
   * <p>Method under test: {@link Json#resolvedUser()}
   */
  @Test
  @DisplayName("Test Json resolvedUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.resolvedUser()"})
  void testJsonResolvedUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedUser());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("42")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        immutableBulkUserOperationRowPreview.withGivenComment("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithGivenCommentResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment_thenReturnResolvedCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenComment("42");

    // Assert
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertNull(actualWithGivenCommentResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("")
            .resolvedUser("Resolved User")
            .build()
            .withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("")
            .build()
            .withGivenComment("42");

    // Assert
    assertEquals("", actualWithGivenCommentResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenComment(String)}
   */
  @Test
  @DisplayName("Test withGivenComment(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenComment(String)"
  })
  void testWithGivenComment_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenComment("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("42")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        immutableBulkUserOperationRowPreview.withGivenRole("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithGivenRoleResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole_thenReturnResolvedCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenRole("42");

    // Assert
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertNull(actualWithGivenRoleResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("")
            .resolvedUser("Resolved User")
            .build()
            .withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("")
            .build()
            .withGivenRole("42");

    // Assert
    assertEquals("", actualWithGivenRoleResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenRole(String)}
   */
  @Test
  @DisplayName("Test withGivenRole(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenRole(String)"
  })
  void testWithGivenRole_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenRole("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenRoleResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("42")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        immutableBulkUserOperationRowPreview.withGivenUser("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithGivenUserResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser_thenReturnResolvedCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenUser("42");

    // Assert
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertNull(actualWithGivenUserResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("")
            .resolvedUser("Resolved User")
            .build()
            .withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("")
            .build()
            .withGivenUser("42");

    // Assert
    assertEquals("", actualWithGivenUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withGivenUser(String)}
   */
  @Test
  @DisplayName("Test withGivenUser(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withGivenUser(String)"
  })
  void testWithGivenUser_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithGivenUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withGivenUser("42");

    // Assert
    assertEquals("Resolved Comment", actualWithGivenUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithGivenUserResult.resolvedRole());
    assertEquals("Resolved User", actualWithGivenUserResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithGivenUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("42")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        immutableBulkUserOperationRowPreview.withResolvedComment("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithResolvedCommentResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedComment("42");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return resolvedRole is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment_thenReturnResolvedRoleIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole(null)
            .resolvedUser("Resolved User")
            .build()
            .withResolvedComment("42");

    // Assert
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertNull(actualWithResolvedCommentResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <ul>
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("")
            .build()
            .withResolvedComment("42");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedUser());
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName("Test withResolvedComment(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedComment("42");

    // Assert
    assertEquals("42", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedComment(String)}
   */
  @Test
  @DisplayName(
      "Test withResolvedComment(String); when empty string; then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedComment(String)"
  })
  void testWithResolvedComment_whenEmptyString_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedCommentResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedComment("");

    // Assert
    assertEquals("", actualWithResolvedCommentResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedCommentResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedCommentResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedCommentResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("42")
            .resolvedUser("Resolved User")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        immutableBulkUserOperationRowPreview.withResolvedRole("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithResolvedRoleResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedRole("42");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole_thenReturnResolvedCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedRole("42");

    // Assert
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertNull(actualWithResolvedRoleResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <ul>
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("")
            .build()
            .withResolvedRole("42");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedUser());
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName("Test withResolvedRole(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedRole("42");

    // Assert
    assertEquals("42", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.OK, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedRole(String)}
   */
  @Test
  @DisplayName(
      "Test withResolvedRole(String); when empty string; then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedRole(String)"
  })
  void testWithResolvedRole_whenEmptyString_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedRoleResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedRole("");

    // Assert
    assertEquals("", actualWithResolvedRoleResult.resolvedRole());
    assertEquals("Resolved Comment", actualWithResolvedRoleResult.resolvedComment());
    assertEquals("Resolved User", actualWithResolvedRoleResult.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedRoleResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser() {
    // Arrange
    ImmutableBulkUserOperationRowPreview immutableBulkUserOperationRowPreview =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("42")
            .build();

    // Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        immutableBulkUserOperationRowPreview.withResolvedUser("42");

    // Assert
    assertSame(immutableBulkUserOperationRowPreview, actualWithResolvedUserResult);
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return resolvedComment is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser_thenReturnResolvedCommentIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedUser("42");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedComment());
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedComment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return resolvedComment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser_thenReturnResolvedCommentIsNull() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment(null)
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedUser("42");

    // Assert
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertNull(actualWithResolvedUserResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <ul>
   *   <li>Then return resolvedRole is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return resolvedRole is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser_thenReturnResolvedRoleIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedUser("42");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedRole());
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <ul>
   *   <li>Then return status is {@code OK}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName("Test withResolvedUser(String); then return status is 'OK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser_thenReturnStatusIsOk() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedUser("42");

    // Assert
    assertEquals("42", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.OK, actualWithResolvedUserResult.status());
  }

  /**
   * Test {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return resolvedUser is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUserOperationRowPreview#withResolvedUser(String)}
   */
  @Test
  @DisplayName(
      "Test withResolvedUser(String); when empty string; then return resolvedUser is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUserOperationRowPreview ImmutableBulkUserOperationRowPreview.withResolvedUser(String)"
  })
  void testWithResolvedUser_whenEmptyString_thenReturnResolvedUserIsEmptyString() {
    // Arrange and Act
    ImmutableBulkUserOperationRowPreview actualWithResolvedUserResult =
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .withResolvedUser("");

    // Assert
    assertEquals("", actualWithResolvedUserResult.resolvedUser());
    assertEquals("Resolved Comment", actualWithResolvedUserResult.resolvedComment());
    assertEquals("Resolved Role", actualWithResolvedUserResult.resolvedRole());
    assertEquals(ResolutionStatus.ERROR, actualWithResolvedUserResult.status());
  }
}
