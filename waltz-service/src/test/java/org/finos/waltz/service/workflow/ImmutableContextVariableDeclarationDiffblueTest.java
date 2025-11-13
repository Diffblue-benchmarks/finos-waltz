package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableContextVariableDeclaration.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDeclarationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariableDeclaration Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualNameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableReference ref =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();
    ImmutableContextVariableDeclaration actualImmutableContextVariableDeclaration =
        actualNameResult.ref(ref).build();

    // Assert
    assertEquals("Name", actualImmutableContextVariableDeclaration.name());
    assertSame(ref, actualImmutableContextVariableDeclaration.ref());
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableDeclaration)}.
   *
   * <p>Method under test: {@link Builder#from(ContextVariableDeclaration)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableDeclaration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariableDeclaration)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();

    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration instance =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableContextVariableDeclaration actualImmutableContextVariableDeclaration =
        builderResult.build();
    assertEquals(instance, actualImmutableContextVariableDeclaration);
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
    Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ref(ContextVariableReference)}.
   *
   * <ul>
   *   <li>When builder externalId {@code 42} kind {@code ALL} build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ref(ContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test Builder ref(ContextVariableReference); when builder externalId '42' kind 'ALL' build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ref(ContextVariableReference)"})
  void testBuilderRef_whenBuilderExternalId42KindAllBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act
    Builder actualRefResult =
        builderResult.ref(
            ImmutableContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .build());

    // Assert
    assertSame(builderResult, actualRefResult);
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#copyOf(ContextVariableDeclaration)}.
   *
   * <ul>
   *   <li>Then ref return {@link ImmutableContextVariableReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableContextVariableDeclaration#copyOf(ContextVariableDeclaration)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ContextVariableDeclaration); then ref return ImmutableContextVariableReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableDeclaration ImmutableContextVariableDeclaration.copyOf(ContextVariableDeclaration)"
  })
  void testCopyOf_thenRefReturnImmutableContextVariableReference() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration instance =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableContextVariableDeclaration actualCopyOfResult =
        ImmutableContextVariableDeclaration.copyOf(instance);

    // Assert
    ContextVariableReference refResult = actualCopyOfResult.ref();
    assertTrue(refResult instanceof ImmutableContextVariableReference);
    assertEquals("42", refResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(EntityKind.ALL, refResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}, and {@link
   * ImmutableContextVariableDeclaration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableDeclaration#equals(Object)}
   *   <li>{@link ImmutableContextVariableDeclaration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    Builder nameResult2 = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration2 =
        nameResult2
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableContextVariableDeclaration, immutableContextVariableDeclaration2);
    assertEquals(
        immutableContextVariableDeclaration.hashCode(),
        immutableContextVariableDeclaration2.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}, and {@link
   * ImmutableContextVariableDeclaration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableDeclaration#equals(Object)}
   *   <li>{@link ImmutableContextVariableDeclaration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableContextVariableDeclaration, immutableContextVariableDeclaration);
    int expectedHashCodeResult = immutableContextVariableDeclaration.hashCode();
    assertEquals(expectedHashCodeResult, immutableContextVariableDeclaration.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("42");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    Builder nameResult2 = ImmutableContextVariableDeclaration.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        immutableContextVariableDeclaration,
        nameResult2
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("Name")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    Builder nameResult2 = ImmutableContextVariableDeclaration.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        immutableContextVariableDeclaration,
        nameResult2
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableDeclaration.equals(Object)",
    "int ImmutableContextVariableDeclaration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build(),
        "Different type to ImmutableContextVariableDeclaration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableDeclaration#toString()}
   *   <li>{@link ImmutableContextVariableDeclaration#name()}
   *   <li>{@link ImmutableContextVariableDeclaration#ref()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableContextVariableDeclaration.name()",
    "ContextVariableReference ImmutableContextVariableDeclaration.ref()",
    "String ImmutableContextVariableDeclaration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableContextVariableDeclaration.toString();
    String actualNameResult = immutableContextVariableDeclaration.name();

    // Assert
    assertTrue(
        immutableContextVariableDeclaration.ref() instanceof ImmutableContextVariableReference);
    assertEquals(
        "ContextVariableDeclaration{name=Name, ref=ContextVariableReference{kind=ALL, externalId=42}}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#withName(String)}.
   *
   * <ul>
   *   <li>Then ref return {@link ImmutableContextVariableReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then ref return ImmutableContextVariableReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableDeclaration ImmutableContextVariableDeclaration.withName(String)"
  })
  void testWithName_thenRefReturnImmutableContextVariableReference() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");

    // Act
    ImmutableContextVariableDeclaration actualWithNameResult =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build()
            .withName("42");

    // Assert
    ContextVariableReference refResult = actualWithNameResult.ref();
    assertTrue(refResult instanceof ImmutableContextVariableReference);
    assertEquals("42", refResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals(EntityKind.ALL, refResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#withName(String)}.
   *
   * <ul>
   *   <li>Then return builder name {@code 42} ref builder externalId {@code 42} kind {@code ALL}
   *       build build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableDeclaration#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); then return builder name '42' ref builder externalId '42' kind 'ALL' build build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableDeclaration ImmutableContextVariableDeclaration.withName(String)"
  })
  void testWithName_thenReturnBuilderName42RefBuilderExternalId42KindAllBuildBuild() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("42");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableContextVariableDeclaration actualWithNameResult =
        immutableContextVariableDeclaration.withName("42");

    // Assert
    assertSame(immutableContextVariableDeclaration, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableContextVariableDeclaration#withRef(ContextVariableReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableContextVariableDeclaration#withRef(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test withRef(ContextVariableReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableDeclaration ImmutableContextVariableDeclaration.withRef(ContextVariableReference)"
  })
  void testWithRef() {
    // Arrange
    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    ImmutableContextVariableDeclaration immutableContextVariableDeclaration =
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableContextVariableDeclaration actualWithRefResult =
        immutableContextVariableDeclaration.withRef(
            ImmutableContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableContextVariableDeclaration, actualWithRefResult);
  }
}
