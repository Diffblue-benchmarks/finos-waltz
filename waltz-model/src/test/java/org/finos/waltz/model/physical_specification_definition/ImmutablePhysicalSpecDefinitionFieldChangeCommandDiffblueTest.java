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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionFieldChangeCommand.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionFieldChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionFieldChangeCommandDiffblueTest {
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
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualLogicalDataElementIdResult = actualIdResult.id(id).logicalDataElementId(1L);
    Optional<Long> logicalDataElementId = Optional.of(1L);
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand =
            actualLogicalDataElementIdResult
                .logicalDataElementId(logicalDataElementId)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Assert
    assertEquals("Name", actualImmutablePhysicalSpecDefinitionFieldChangeCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand.description());
    assertEquals(1, actualImmutablePhysicalSpecDefinitionFieldChangeCommand.position());
    assertEquals(
        FieldDataType.DATE, actualImmutablePhysicalSpecDefinitionFieldChangeCommand.type());
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description(null)
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link NameProvider} {@link NameProvider#name()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; when NameProvider name() return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_whenNameProviderNameReturnName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionFieldChangeCommand)} with {@code
   * PhysicalSpecDefinitionFieldChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecDefinitionFieldChangeCommand) with 'PhysicalSpecDefinitionFieldChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionFieldChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionFieldChangeCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionFieldChangeCommand)} with {@code
   * PhysicalSpecDefinitionFieldChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecDefinitionFieldChangeCommand) with 'PhysicalSpecDefinitionFieldChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionFieldChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionFieldChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description(null)
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        actualImmutablePhysicalSpecDefinitionFieldChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionFieldChangeCommand);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#logicalDataElementId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#logicalDataElementId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalDataElementId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalDataElementId(long)"})
  void testBuilderLogicalDataElementIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    // Act
    Builder actualLogicalDataElementIdResult = builderResult.logicalDataElementId(1L);

    // Assert
    assertSame(builderResult, actualLogicalDataElementIdResult);
  }

  /**
   * Test Builder {@link Builder#logicalDataElementId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#logicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test Builder logicalDataElementId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalDataElementId(Optional)"})
  void testBuilderLogicalDataElementIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();
    Optional<Long> logicalDataElementId = Optional.of(1L);

    // Act
    Builder actualLogicalDataElementIdResult =
        builderResult.logicalDataElementId(logicalDataElementId);

    // Assert
    assertSame(builderResult, actualLogicalDataElementIdResult);
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#type(FieldDataType)}.
   *
   * <p>Method under test: {@link Builder#type(FieldDataType)}
   */
  @Test
  @DisplayName("Test Builder type(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(FieldDataType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder();

    // Act
    Builder actualTypeResult = builderResult.type(FieldDataType.DATE);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#copyOf(PhysicalSpecDefinitionFieldChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#copyOf(PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalSpecDefinitionFieldChangeCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.copyOf(PhysicalSpecDefinitionFieldChangeCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand instance =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualCopyOfResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand2 =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        immutablePhysicalSpecDefinitionFieldChangeCommand2);
    assertEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand.hashCode(),
        immutablePhysicalSpecDefinitionFieldChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        immutablePhysicalSpecDefinitionFieldChangeCommand);
    int expectedHashCodeResult = immutablePhysicalSpecDefinitionFieldChangeCommand.hashCode();
    assertEquals(
        expectedHashCodeResult, immutablePhysicalSpecDefinitionFieldChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(2L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(2L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("java.lang.Long")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(0)
                .type(FieldDataType.DATE)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATETIME)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionFieldChangeCommand,
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionFieldChangeCommand.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build(),
        "Different type to ImmutablePhysicalSpecDefinitionFieldChangeCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#description()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#name()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#position()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#type()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecDefinitionFieldChangeCommand.description()",
    "String ImmutablePhysicalSpecDefinitionFieldChangeCommand.name()",
    "int ImmutablePhysicalSpecDefinitionFieldChangeCommand.position()",
    "FieldDataType ImmutablePhysicalSpecDefinitionFieldChangeCommand.type()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    String actualDescriptionResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.description();
    String actualNameResult = immutablePhysicalSpecDefinitionFieldChangeCommand.name();
    int actualPositionResult = immutablePhysicalSpecDefinitionFieldChangeCommand.position();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualPositionResult);
    assertEquals(FieldDataType.DATE, immutablePhysicalSpecDefinitionFieldChangeCommand.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionFieldChangeCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#logicalDataElementId()}.
   *
   * <p>Method under test: {@link Json#logicalDataElementId()}
   */
  @Test
  @DisplayName("Test Json logicalDataElementId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.logicalDataElementId()"})
  void testJsonLogicalDataElementId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalDataElementId());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.type);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.logicalDataElementId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
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
  @MethodsUnderTest({"FieldDataType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#logicalDataElementId()}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#logicalDataElementId()}
   */
  @Test
  @DisplayName("Test logicalDataElementId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional ImmutablePhysicalSpecDefinitionFieldChangeCommand.logicalDataElementId()"
  })
  void testLogicalDataElementId() {
    // Arrange and Act
    Optional<Long> actualLogicalDataElementIdResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .logicalDataElementId();

    // Assert
    assertEquals(1L, actualLogicalDataElementIdResult.get().longValue());
    assertTrue(actualLogicalDataElementIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinitionFieldChangeCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PhysicalSpecDefinitionFieldChangeCommand{id=1, name=Name, position=1, type=DATE, logicalDataElementId"
            + "=1}",
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithDescriptionResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withDescription("42");

    // Assert
    assertEquals(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("42")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithDescriptionResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withDescription("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(2L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithIdResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(FieldDataType.DATE, actualWithIdResult.type());
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(Optional)"
  })
  void testWithLogicalDataElementIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(optional);

    // Assert
    assertSame(
        immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithLogicalDataElementIdResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(Optional)} with
   * {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(Optional)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(Optional)"
  })
  void testWithLogicalDataElementIdWithOptional_thenReturnName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(2L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(optional);

    // Assert
    assertEquals("Name", actualWithLogicalDataElementIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLogicalDataElementIdResult.description());
    assertEquals(1, actualWithLogicalDataElementIdResult.position());
    assertEquals(FieldDataType.DATE, actualWithLogicalDataElementIdResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(long)}
   * with {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(long)}
   */
  @Test
  @DisplayName("Test withLogicalDataElementId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(long)"
  })
  void testWithLogicalDataElementIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithLogicalDataElementIdResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(1L);

    // Assert
    assertSame(
        immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithLogicalDataElementIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(long)}
   * with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withLogicalDataElementId(long)}
   */
  @Test
  @DisplayName(
      "Test withLogicalDataElementId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withLogicalDataElementId(long)"
  })
  void testWithLogicalDataElementIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithLogicalDataElementIdResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .withLogicalDataElementId(42L);

    // Assert
    assertEquals("Name", actualWithLogicalDataElementIdResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLogicalDataElementIdResult.description());
    assertEquals(1, actualWithLogicalDataElementIdResult.position());
    assertEquals(FieldDataType.DATE, actualWithLogicalDataElementIdResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withName(String)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("42")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithNameResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withName("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithNameResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertEquals(FieldDataType.DATE, actualWithNameResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withPosition(int)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(42)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithPositionResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withPosition(42);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withPosition(int)"
  })
  void testWithPosition_thenReturnName() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithPositionResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATE)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(FieldDataType.DATE, actualWithPositionResult.type());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withType(FieldDataType)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withType(FieldDataType)}
   */
  @Test
  @DisplayName("Test withType(FieldDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withType(FieldDataType)"
  })
  void testWithType() {
    // Arrange
    ImmutablePhysicalSpecDefinitionFieldChangeCommand
        immutablePhysicalSpecDefinitionFieldChangeCommand =
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build();

    // Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithTypeResult =
        immutablePhysicalSpecDefinitionFieldChangeCommand.withType(FieldDataType.DATE);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionFieldChangeCommand, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionFieldChangeCommand#withType(FieldDataType)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionFieldChangeCommand#withType(FieldDataType)}
   */
  @Test
  @DisplayName("Test withType(FieldDataType); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionFieldChangeCommand ImmutablePhysicalSpecDefinitionFieldChangeCommand.withType(FieldDataType)"
  })
  void testWithType_thenReturnName() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionFieldChangeCommand actualWithTypeResult =
        ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .logicalDataElementId(1L)
            .name("Name")
            .position(1)
            .type(FieldDataType.DATETIME)
            .build()
            .withType(FieldDataType.DATE);

    // Assert
    assertEquals("Name", actualWithTypeResult.name());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(1, actualWithTypeResult.position());
    assertEquals(FieldDataType.DATE, actualWithTypeResult.type());
  }
}
