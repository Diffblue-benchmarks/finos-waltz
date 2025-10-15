package org.finos.waltz.model.physical_specification;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationAddCommand.Builder;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationAddCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationAddCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    DataFormatKindValue format = DataFormatKindValue.of("42");
    Builder actualNameResult = actualExternalIdResult2.format(format).name("Name");
    ImmutableEntityReference owningEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        actualNameResult.owningEntity(owningEntity).build();

    // Assert
    DataFormatKindValue formatResult = actualImmutablePhysicalSpecificationAddCommand.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualImmutablePhysicalSpecificationAddCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalSpecificationAddCommand.description());
    assertSame(owningEntity, actualImmutablePhysicalSpecificationAddCommand.owningEntity());
    assertSame(format, formatResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#format(DataFormatKindValue)}.
   *
   * <ul>
   *   <li>When {@link DataFormatKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#format(DataFormatKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder format(DataFormatKindValue); when DataFormatKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.format(DataFormatKindValue)"})
  void testBuilderFormat_whenDataFormatKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act
    Builder actualFormatResult = builderResult.format(DataFormatKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualFormatResult);
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
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

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
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder().description(null).externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand2);
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
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder().description(null).externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecificationAddCommand)} with {@code
   * PhysicalSpecificationAddCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecificationAddCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecificationAddCommand) with 'PhysicalSpecificationAddCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecificationAddCommand)"})
  void testBuilderFromWithPhysicalSpecificationAddCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecificationAddCommand)} with {@code
   * PhysicalSpecificationAddCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecificationAddCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecificationAddCommand) with 'PhysicalSpecificationAddCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecificationAddCommand)"})
  void testBuilderFromWithPhysicalSpecificationAddCommand2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder().description(null).externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecificationAddCommand actualImmutablePhysicalSpecificationAddCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationAddCommand);
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
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#owningEntity(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#owningEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder owningEntity(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owningEntity(EntityReference)"})
  void testBuilderOwningEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationAddCommand.builder();

    // Act
    Builder actualOwningEntityResult = builderResult.owningEntity(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualOwningEntityResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#copyOf(PhysicalSpecificationAddCommand)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationAddCommand#copyOf(PhysicalSpecificationAddCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalSpecificationAddCommand); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.copyOf(PhysicalSpecificationAddCommand)"
  })
  void testCopyOf_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult = externalIdResult.format(format).name("Name");
    ImmutablePhysicalSpecificationAddCommand instance =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualCopyOfResult =
        ImmutablePhysicalSpecificationAddCommand.copyOf(instance);

    // Assert
    EntityReference owningEntityResult = actualCopyOfResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
    assertSame(format, formatResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecificationAddCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder externalIdResult2 =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand2 =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecificationAddCommand, immutablePhysicalSpecificationAddCommand2);
    assertEquals(
        immutablePhysicalSpecificationAddCommand.hashCode(),
        immutablePhysicalSpecificationAddCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecificationAddCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecificationAddCommand, immutablePhysicalSpecificationAddCommand);
    int expectedHashCodeResult = immutablePhysicalSpecificationAddCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecificationAddCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("Name");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder externalIdResult2 =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecificationAddCommand,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("Name")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder externalIdResult2 =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecificationAddCommand,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("42");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder externalIdResult2 =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecificationAddCommand,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder externalIdResult2 =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecificationAddCommand,
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationAddCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationAddCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutablePhysicalSpecificationAddCommand");
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecificationAddCommand.externalId()"})
  void testExternalId() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");

    // Act
    Optional<String> actualExternalIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.fromJson(Json)"
  })
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setName("Json");
    json.setDescription(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);

    // Act
    ImmutablePhysicalSpecificationAddCommand actualFromJsonResult =
        ImmutablePhysicalSpecificationAddCommand.fromJson(json);

    // Assert
    DataFormatKindValue formatResult = actualFromJsonResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertSame(format, formatResult);
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setExternalId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);

    // Act
    ImmutablePhysicalSpecificationAddCommand actualFromJsonResult =
        ImmutablePhysicalSpecificationAddCommand.fromJson(json);

    // Assert
    DataFormatKindValue formatResult = actualFromJsonResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertSame(format, formatResult);
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setExternalId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setOwningEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);

    // Act
    ImmutablePhysicalSpecificationAddCommand actualFromJsonResult =
        ImmutablePhysicalSpecificationAddCommand.fromJson(json);

    // Assert
    DataFormatKindValue formatResult = actualFromJsonResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertSame(format, formatResult);
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#description()}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#format()}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#name()}
   *   <li>{@link ImmutablePhysicalSpecificationAddCommand#owningEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecificationAddCommand.description()",
    "DataFormatKindValue ImmutablePhysicalSpecificationAddCommand.format()",
    "String ImmutablePhysicalSpecificationAddCommand.name()",
    "EntityReference ImmutablePhysicalSpecificationAddCommand.owningEntity()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult = externalIdResult.format(format).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualDescriptionResult = immutablePhysicalSpecificationAddCommand.description();
    DataFormatKindValue actualFormatResult = immutablePhysicalSpecificationAddCommand.format();
    String actualNameResult = immutablePhysicalSpecificationAddCommand.name();

    // Assert
    assertTrue(
        immutablePhysicalSpecificationAddCommand.owningEntity()
            instanceof ImmutableEntityReference);
    assertEquals("42", actualFormatResult.value());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertSame(format, actualFormatResult);
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#format()}.
   *
   * <p>Method under test: {@link Json#format()}
   */
  @Test
  @DisplayName("Test Json format()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataFormatKindValue Json.format()"})
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().format());
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
    assertNull(actualJson.owningEntity);
    assertNull(actualJson.format);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Test Json {@link Json#owningEntity()}.
   *
   * <p>Method under test: {@link Json#owningEntity()}
   */
  @Test
  @DisplayName("Test Json owningEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.owningEntity()"})
  void testJsonOwningEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owningEntity());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecificationAddCommand.toString()"})
  void testToString() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");

    // Act and Assert
    assertEquals(
        "PhysicalSpecificationAddCommand{externalId=42, name=Name, owningEntity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, format=42}",
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithDescriptionResult =
        immutablePhysicalSpecificationAddCommand.withDescription("42");

    // Assert
    assertEquals(immutablePhysicalSpecificationAddCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder().description("42").externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithDescriptionResult =
        immutablePhysicalSpecificationAddCommand.withDescription("42");

    // Assert
    assertSame(immutablePhysicalSpecificationAddCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithExternalIdResult =
        immutablePhysicalSpecificationAddCommand.withExternalId(optional);

    // Assert
    assertSame(immutablePhysicalSpecificationAddCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult = externalIdResult.format(format).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithExternalIdResult =
        immutablePhysicalSpecificationAddCommand.withExternalId(optional);

    // Assert
    EntityReference owningEntityResult = actualWithExternalIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    DataFormatKindValue formatResult = actualWithExternalIdResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
    assertSame(format, formatResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithExternalIdResult =
        immutablePhysicalSpecificationAddCommand.withExternalId("42");

    // Assert
    assertSame(immutablePhysicalSpecificationAddCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(String)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult = externalIdResult.format(format).name("Name");

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithExternalIdResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference owningEntityResult = actualWithExternalIdResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    DataFormatKindValue formatResult = actualWithExternalIdResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
    assertSame(format, formatResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withFormat(DataFormatKindValue)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationAddCommand#withFormat(DataFormatKindValue)}
   */
  @Test
  @DisplayName("Test withFormat(DataFormatKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withFormat(DataFormatKindValue)"
  })
  void testWithFormat() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithFormatResult =
        immutablePhysicalSpecificationAddCommand.withFormat(DataFormatKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalSpecificationAddCommand, actualWithFormatResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("42");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithNameResult =
        immutablePhysicalSpecificationAddCommand.withName("42");

    // Assert
    assertSame(immutablePhysicalSpecificationAddCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationAddCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withName(String)"
  })
  void testWithName_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult = externalIdResult.format(format).name("Name");

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithNameResult =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withName("42");

    // Assert
    EntityReference owningEntityResult = actualWithNameResult.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    DataFormatKindValue formatResult = actualWithNameResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
    assertSame(format, formatResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationAddCommand#withOwningEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationAddCommand#withOwningEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withOwningEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationAddCommand ImmutablePhysicalSpecificationAddCommand.withOwningEntity(EntityReference)"
  })
  void testWithOwningEntity() {
    // Arrange
    Builder externalIdResult =
        ImmutablePhysicalSpecificationAddCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.format(DataFormatKindValue.of("42")).name("Name");
    ImmutablePhysicalSpecificationAddCommand immutablePhysicalSpecificationAddCommand =
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutablePhysicalSpecificationAddCommand actualWithOwningEntityResult =
        immutablePhysicalSpecificationAddCommand.withOwningEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalSpecificationAddCommand, actualWithOwningEntityResult);
  }
}
