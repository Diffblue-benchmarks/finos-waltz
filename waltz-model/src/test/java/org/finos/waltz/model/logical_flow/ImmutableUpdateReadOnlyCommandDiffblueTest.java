package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableUpdateReadOnlyCommand.Builder;
import org.finos.waltz.model.logical_flow.ImmutableUpdateReadOnlyCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateReadOnlyCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateReadOnlyCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build().readOnly());
  }

  /**
   * Test Builder {@link Builder#from(UpdateReadOnlyCommand)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateReadOnlyCommand); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateReadOnlyCommand)"})
  void testBuilderFrom_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();

    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).readOnly();
  }

  /**
   * Test Builder {@link Builder#from(UpdateReadOnlyCommand)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then builder build readOnly.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateReadOnlyCommand); given 'true'; then builder build readOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateReadOnlyCommand)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildReadOnly() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();

    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).readOnly();
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#readOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#readOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder readOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.readOnly(boolean)"})
  void testBuilderReadOnly() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();

    // Act
    Builder actualReadOnlyResult = builderResult.readOnly(true);

    // Assert
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualReadOnlyResult);
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#copyOf(UpdateReadOnlyCommand)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link UpdateReadOnlyCommand#readOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#copyOf(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateReadOnlyCommand); given 'true'; then calls readOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateReadOnlyCommand ImmutableUpdateReadOnlyCommand.copyOf(UpdateReadOnlyCommand)"
  })
  void testCopyOf_givenTrue_thenCallsReadOnly() {
    // Arrange
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenReturn(true);

    // Act
    ImmutableUpdateReadOnlyCommand actualCopyOfResult =
        ImmutableUpdateReadOnlyCommand.copyOf(instance);

    // Assert
    verify(instance).readOnly();
    assertTrue(actualCopyOfResult.readOnly());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#copyOf(UpdateReadOnlyCommand)}.
   *
   * <ul>
   *   <li>When builder readOnly {@code true} build.
   *   <li>Then return readOnly.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#copyOf(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateReadOnlyCommand); when builder readOnly 'true' build; then return readOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateReadOnlyCommand ImmutableUpdateReadOnlyCommand.copyOf(UpdateReadOnlyCommand)"
  })
  void testCopyOf_whenBuilderReadOnlyTrueBuild_thenReturnReadOnly() {
    // Arrange
    ImmutableUpdateReadOnlyCommand instance =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();

    // Act and Assert
    assertTrue(ImmutableUpdateReadOnlyCommand.copyOf(instance).readOnly());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#equals(Object)}, and {@link
   * ImmutableUpdateReadOnlyCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateReadOnlyCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateReadOnlyCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.equals(Object)",
    "int ImmutableUpdateReadOnlyCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand2 =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();

    // Act and Assert
    assertEquals(immutableUpdateReadOnlyCommand, immutableUpdateReadOnlyCommand2);
    assertEquals(
        immutableUpdateReadOnlyCommand.hashCode(), immutableUpdateReadOnlyCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#equals(Object)}, and {@link
   * ImmutableUpdateReadOnlyCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateReadOnlyCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateReadOnlyCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.equals(Object)",
    "int ImmutableUpdateReadOnlyCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();

    // Act and Assert
    assertEquals(immutableUpdateReadOnlyCommand, immutableUpdateReadOnlyCommand);
    int expectedHashCodeResult = immutableUpdateReadOnlyCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateReadOnlyCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.equals(Object)",
    "int ImmutableUpdateReadOnlyCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(false).build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateReadOnlyCommand,
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.equals(Object)",
    "int ImmutableUpdateReadOnlyCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build(), null);
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.equals(Object)",
    "int ImmutableUpdateReadOnlyCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build(),
        "Different type to ImmutableUpdateReadOnlyCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateReadOnlyCommand#toString()}
   *   <li>{@link ImmutableUpdateReadOnlyCommand#readOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateReadOnlyCommand.readOnly()",
    "String ImmutableUpdateReadOnlyCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();

    // Act
    String actualToStringResult = immutableUpdateReadOnlyCommand.toString();

    // Assert
    assertEquals("UpdateReadOnlyCommand{readOnly=true}", actualToStringResult);
    assertTrue(immutableUpdateReadOnlyCommand.readOnly());
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
    assertFalse(actualJson.readOnly);
    assertFalse(actualJson.readOnlyIsSet);
  }

  /**
   * Test Json {@link Json#readOnly()}.
   *
   * <p>Method under test: {@link Json#readOnly()}
   */
  @Test
  @DisplayName("Test Json readOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.readOnly()"})
  void testJsonReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().readOnly());
  }

  /**
   * Test Json {@link Json#setReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setReadOnly(boolean)"})
  void testJsonSetReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setReadOnly(true);

    // Assert
    assertTrue(json.readOnly);
    assertTrue(json.readOnlyIsSet);
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#withReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Given builder readOnly {@code false} build.
   *   <li>Then return readOnly.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#withReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withReadOnly(boolean); given builder readOnly 'false' build; then return readOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateReadOnlyCommand ImmutableUpdateReadOnlyCommand.withReadOnly(boolean)"
  })
  void testWithReadOnly_givenBuilderReadOnlyFalseBuild_thenReturnReadOnly() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableUpdateReadOnlyCommand.builder()
            .readOnly(false)
            .build()
            .withReadOnly(true)
            .readOnly());
  }

  /**
   * Test {@link ImmutableUpdateReadOnlyCommand#withReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Then return builder readOnly {@code true} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateReadOnlyCommand#withReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withReadOnly(boolean); then return builder readOnly 'true' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateReadOnlyCommand ImmutableUpdateReadOnlyCommand.withReadOnly(boolean)"
  })
  void testWithReadOnly_thenReturnBuilderReadOnlyTrueBuild() {
    // Arrange
    ImmutableUpdateReadOnlyCommand immutableUpdateReadOnlyCommand =
        ImmutableUpdateReadOnlyCommand.builder().readOnly(true).build();

    // Act
    ImmutableUpdateReadOnlyCommand actualWithReadOnlyResult =
        immutableUpdateReadOnlyCommand.withReadOnly(true);

    // Assert
    assertSame(immutableUpdateReadOnlyCommand, actualWithReadOnlyResult);
  }
}
