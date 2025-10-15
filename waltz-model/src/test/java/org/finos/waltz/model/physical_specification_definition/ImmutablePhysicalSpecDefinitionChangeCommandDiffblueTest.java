package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionChangeCommand.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#delimiter(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand Builder.build()",
    "Builder Builder.delimiter(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDelimiterResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder().delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("foo");
    Builder actualIdResult = actualDelimiterResult.delimiter(delimiter).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutablePhysicalSpecDefinitionChangeCommand
        actualImmutablePhysicalSpecDefinitionChangeCommand =
            actualIdResult
                .id(id)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build();

    // Assert
    assertEquals("1.0.2", actualImmutablePhysicalSpecDefinitionChangeCommand.version());
    assertEquals(
        ReleaseLifecycleStatus.DRAFT, actualImmutablePhysicalSpecDefinitionChangeCommand.status());
    assertEquals(
        PhysicalSpecDefinitionType.DELIMITED,
        actualImmutablePhysicalSpecDefinitionChangeCommand.type());
  }

  /**
   * Test Builder {@link Builder#delimiter(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#delimiter(Optional)}
   */
  @Test
  @DisplayName("Test Builder delimiter(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.delimiter(Optional)"})
  void testBuilderDelimiterWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    Optional<String> delimiter = Optional.of("foo");

    // Act
    Builder actualDelimiterResult = builderResult.delimiter(delimiter);

    // Assert
    assertSame(builderResult, actualDelimiterResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionChangeCommand instance =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionChangeCommand
        actualImmutablePhysicalSpecDefinitionChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionChangeCommand)} with {@code
   * PhysicalSpecDefinitionChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecDefinitionChangeCommand) with 'PhysicalSpecDefinitionChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionChangeCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionChangeCommand instance =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionChangeCommand
        actualImmutablePhysicalSpecDefinitionChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#status(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ReleaseLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#type(PhysicalSpecDefinitionType)}.
   *
   * <p>Method under test: {@link Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test Builder type(PhysicalSpecDefinitionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(PhysicalSpecDefinitionType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualTypeResult = builderResult.type(PhysicalSpecDefinitionType.DELIMITED);

    // Assert
    assertSame(builderResult, actualTypeResult);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#copyOf(PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#copyOf(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalSpecDefinitionChangeCommand); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.copyOf(PhysicalSpecDefinitionChangeCommand)"
  })
  void testCopyOf_thenReturnVersionIs102() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand instance =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualCopyOfResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualCopyOfResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#delimiter()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#delimiter()}
   */
  @Test
  @DisplayName("Test delimiter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionChangeCommand.delimiter()"})
  void testDelimiter() {
    // Arrange and Act
    Optional<String> actualDelimiterResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .delimiter();

    // Assert
    assertEquals("Delimiter", actualDelimiterResult.get());
    assertTrue(actualDelimiterResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand2 =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionChangeCommand,
        immutablePhysicalSpecDefinitionChangeCommand2);
    assertEquals(
        immutablePhysicalSpecDefinitionChangeCommand.hashCode(),
        immutablePhysicalSpecDefinitionChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionChangeCommand, immutablePhysicalSpecDefinitionChangeCommand);
    int expectedHashCodeResult = immutablePhysicalSpecDefinitionChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecDefinitionChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("1.0.2")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionChangeCommand,
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(2L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionChangeCommand,
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionChangeCommand,
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("Version")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionChangeCommand,
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build(),
        "Different type to ImmutablePhysicalSpecDefinitionChangeCommand");
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Version is {@code Json}.
   *   <li>Then return version is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Version is 'Json'; then return version is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonVersionIsJson_thenReturnVersionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setVersion("Json");
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setDelimiter(null);
    json.setType(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualFromJsonResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualFromJsonResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) Delimiter is of {@code foo}.
   *   <li>Then return version is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) Delimiter is of 'foo'; then return version is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfFoo_whenJsonDelimiterIsOfFoo_thenReturnVersionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setVersion("Json");
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    Optional<String> delimiter = Optional.of("foo");
    json.setDelimiter(delimiter);
    json.setType(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualFromJsonResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualFromJsonResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   *   <li>Then return version is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) Id is of one; then return version is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonIdIsOfOne_thenReturnVersionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setVersion("Json");
    json.setStatus(ReleaseLifecycleStatus.DRAFT);
    json.setDelimiter(null);
    json.setType(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualFromJsonResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualFromJsonResult.type());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#status()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#type()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReleaseLifecycleStatus ImmutablePhysicalSpecDefinitionChangeCommand.status()",
    "PhysicalSpecDefinitionType ImmutablePhysicalSpecDefinitionChangeCommand.type()",
    "String ImmutablePhysicalSpecDefinitionChangeCommand.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ReleaseLifecycleStatus actualStatusResult =
        immutablePhysicalSpecDefinitionChangeCommand.status();
    PhysicalSpecDefinitionType actualTypeResult =
        immutablePhysicalSpecDefinitionChangeCommand.type();

    // Assert
    assertEquals("1.0.2", immutablePhysicalSpecDefinitionChangeCommand.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualStatusResult);
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionChangeCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#delimiter()}.
   *
   * <p>Method under test: {@link Json#delimiter()}
   */
  @Test
  @DisplayName("Test Json delimiter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.delimiter()"})
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().delimiter());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.version);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
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
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalSpecDefinitionType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test Json {@link Json#version()}.
   *
   * <p>Method under test: {@link Json#version()}
   */
  @Test
  @DisplayName("Test Json version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.version()"})
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().version());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinitionChangeCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PhysicalSpecDefinitionChangeCommand{id=1, version=1.0.2, status=DRAFT, delimiter=Delimiter,"
            + " type=DELIMITED}",
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(Optional)}
   */
  @Test
  @DisplayName("Test withDelimiter(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withDelimiter(Optional)"
  })
  void testWithDelimiterWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("42")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithDelimiterResult =
        immutablePhysicalSpecDefinitionChangeCommand.withDelimiter(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithDelimiterResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(Optional)}
   */
  @Test
  @DisplayName("Test withDelimiter(Optional) with 'optional'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withDelimiter(Optional)"
  })
  void testWithDelimiterWithOptional_thenReturnVersionIs102() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithDelimiterResult =
        immutablePhysicalSpecDefinitionChangeCommand.withDelimiter(optional);

    // Assert
    assertEquals("1.0.2", actualWithDelimiterResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithDelimiterResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithDelimiterResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(String)}
   */
  @Test
  @DisplayName("Test withDelimiter(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withDelimiter(String)"
  })
  void testWithDelimiterWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("42")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithDelimiterResult =
        immutablePhysicalSpecDefinitionChangeCommand.withDelimiter("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithDelimiterResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(String)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withDelimiter(String)}
   */
  @Test
  @DisplayName("Test withDelimiter(String) with 'value'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withDelimiter(String)"
  })
  void testWithDelimiterWithValue_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithDelimiterResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withDelimiter("42");

    // Assert
    assertEquals("1.0.2", actualWithDelimiterResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithDelimiterResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithDelimiterResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionChangeCommand.withId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnVersionIs102() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(2L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionChangeCommand.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithIdResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionChangeCommand.withId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithIdResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithIdResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithStatusResult =
        immutablePhysicalSpecDefinitionChangeCommand.withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ReleaseLifecycleStatus); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus_thenReturnVersionIs102() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithStatusResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals("1.0.2", actualWithStatusResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithStatusResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithStatusResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withType(PhysicalSpecDefinitionType)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionChangeCommand#withType(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test withType(PhysicalSpecDefinitionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withType(PhysicalSpecDefinitionType)"
  })
  void testWithType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithTypeResult =
        immutablePhysicalSpecDefinitionChangeCommand.withType(PhysicalSpecDefinitionType.DELIMITED);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withVersion(String)"
  })
  void testWithVersion() {
    // Arrange
    ImmutablePhysicalSpecDefinitionChangeCommand immutablePhysicalSpecDefinitionChangeCommand =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("42")
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithVersionResult =
        immutablePhysicalSpecDefinitionChangeCommand.withVersion("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionChangeCommand, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionChangeCommand#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return version is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionChangeCommand ImmutablePhysicalSpecDefinitionChangeCommand.withVersion(String)"
  })
  void testWithVersion_thenReturnVersionIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionChangeCommand actualWithVersionResult =
        ImmutablePhysicalSpecDefinitionChangeCommand.builder()
            .delimiter("Delimiter")
            .id(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .type(PhysicalSpecDefinitionType.DELIMITED)
            .version("1.0.2")
            .build()
            .withVersion("42");

    // Assert
    assertEquals("42", actualWithVersionResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithVersionResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, actualWithVersionResult.type());
  }
}
