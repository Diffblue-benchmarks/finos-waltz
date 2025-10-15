package org.finos.waltz.model.datatype;

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
import org.finos.waltz.model.CodeProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.datatype.ImmutableDataType.Builder;
import org.finos.waltz.model.datatype.ImmutableDataType.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataType Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualParentIdResult =
        actualIdResult.id(id).kind(EntityKind.ALL).name("Name").parentId(1L);
    Optional<Long> parentId = Optional.of(1L);
    ImmutableDataType actualImmutableDataType = actualParentIdResult.parentId(parentId).build();

    // Assert
    assertEquals("Code", actualImmutableDataType.code());
    assertEquals("Name", actualImmutableDataType.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableDataType.description());
    assertEquals(EntityKind.ALL, actualImmutableDataType.kind());
    assertFalse(actualImmutableDataType.deprecated());
    assertFalse(actualImmutableDataType.unknown());
    assertTrue(actualImmutableDataType.concrete());
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
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualCodeResult = builderResult.code("Code");

    // Assert
    assertSame(builderResult, actualCodeResult);
  }

  /**
   * Test Builder {@link Builder#concrete(boolean)}.
   *
   * <p>Method under test: {@link Builder#concrete(boolean)}
   */
  @Test
  @DisplayName("Test Builder concrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.concrete(boolean)"})
  void testBuilderConcrete() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualConcreteResult = builderResult.concrete(true);

    // Assert
    assertSame(builderResult, actualConcreteResult);
  }

  /**
   * Test Builder {@link Builder#deprecated(boolean)}.
   *
   * <p>Method under test: {@link Builder#deprecated(boolean)}
   */
  @Test
  @DisplayName("Test Builder deprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deprecated(boolean)"})
  void testBuilderDeprecated() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualDeprecatedResult = builderResult.deprecated(true);

    // Assert
    assertSame(builderResult, actualDeprecatedResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CodeProvider) with 'CodeProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CodeProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <ul>
   *   <li>Given {@code Code}.
   *   <li>When {@link CodeProvider} {@link CodeProvider#code()} return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodeProvider) with 'CodeProvider'; given 'Code'; when CodeProvider code() return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_givenCode_whenCodeProviderCodeReturnCode() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenReturn("Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CodeProvider) with 'CodeProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   *
   * <p>Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   *
   * <p>Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType2() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description(null)
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
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
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ParentIdProvider) instance);

    // Assert
    ImmutableDataType actualImmutableDataType = builderResult.build();
    assertEquals(instance, actualImmutableDataType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOfOne() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
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
    Builder builderResult = ImmutableDataType.builder();

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
    Builder builderResult = ImmutableDataType.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    Optional<Long> parentId = Optional.of(1L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#unknown(boolean)}.
   *
   * <p>Method under test: {@link Builder#unknown(boolean)}
   */
  @Test
  @DisplayName("Test Builder unknown(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.unknown(boolean)"})
  void testBuilderUnknown() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act
    Builder actualUnknownResult = builderResult.unknown(true);

    // Assert
    assertSame(builderResult, actualUnknownResult);
  }

  /**
   * Test {@link ImmutableDataType#concrete()}.
   *
   * <p>Method under test: {@link ImmutableDataType#concrete()}
   */
  @Test
  @DisplayName("Test concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableDataType.concrete()"})
  void testConcrete() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .concrete());
  }

  /**
   * Test {@link ImmutableDataType#copyOf(DataType)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  @DisplayName("Test copyOf(DataType); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.copyOf(DataType)"})
  void testCopyOf_thenReturnCode() {
    // Arrange
    ImmutableDataType instance =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

    // Assert
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.deprecated());
    assertFalse(actualCopyOfResult.unknown());
    assertTrue(actualCopyOfResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#deprecated()}.
   *
   * <p>Method under test: {@link ImmutableDataType#deprecated()}
   */
  @Test
  @DisplayName("Test deprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableDataType.deprecated()"})
  void testDeprecated() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .deprecated());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}, and {@link ImmutableDataType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataType#equals(Object)}
   *   <li>{@link ImmutableDataType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    ImmutableDataType immutableDataType2 =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableDataType, immutableDataType2);
    assertEquals(immutableDataType.hashCode(), immutableDataType2.hashCode());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}, and {@link ImmutableDataType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataType#equals(Object)}
   *   <li>{@link ImmutableDataType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableDataType, immutableDataType);
    int expectedHashCodeResult = immutableDataType.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataType.hashCode());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Name")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataType,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataType,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataType,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Code")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataType,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataType,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataType.equals(Object)",
    "int ImmutableDataType.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build(),
        "Different type to ImmutableDataType");
  }

  /**
   * Test {@link ImmutableDataType#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setKind(EntityKind.ALL);
    json.setCode("name");
    json.setName("name");

    // Act
    ImmutableDataType actualFromJsonResult = ImmutableDataType.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.code());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertFalse(actualFromJsonResult.deprecated());
    assertFalse(actualFromJsonResult.unknown());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Code is {@code name}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Code is 'name'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.fromJson(Json)"})
  void testFromJson_givenName_whenJsonCodeIsName_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setCode("name");
    json.setName("name");

    // Act
    ImmutableDataType actualFromJsonResult = ImmutableDataType.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.code());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.DATA_TYPE, actualFromJsonResult.kind());
    assertFalse(actualFromJsonResult.deprecated());
    assertFalse(actualFromJsonResult.unknown());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setDescription("The characteristics of someone or something");
    json.setCode("name");
    json.setName("name");

    // Act
    ImmutableDataType actualFromJsonResult = ImmutableDataType.fromJson(json);

    // Assert
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.code());
    assertEquals("name", actualFromJsonResult.name());
    assertEquals(EntityKind.DATA_TYPE, actualFromJsonResult.kind());
    assertFalse(actualFromJsonResult.deprecated());
    assertFalse(actualFromJsonResult.unknown());
    assertTrue(actualFromJsonResult.concrete());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataType#code()}
   *   <li>{@link ImmutableDataType#description()}
   *   <li>{@link ImmutableDataType#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableDataType.code()",
    "String ImmutableDataType.description()",
    "String ImmutableDataType.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    String actualCodeResult = immutableDataType.code();
    String actualDescriptionResult = immutableDataType.description();

    // Assert
    assertEquals("Code", actualCodeResult);
    assertEquals("Name", immutableDataType.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableDataType#id()}.
   *
   * <p>Method under test: {@link ImmutableDataType#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataType.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#code()}.
   *
   * <p>Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().code());
  }

  /**
   * Test Json {@link Json#concrete()}.
   *
   * <p>Method under test: {@link Json#concrete()}
   */
  @Test
  @DisplayName("Test Json concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.concrete()"})
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().concrete());
  }

  /**
   * Test Json {@link Json#deprecated()}.
   *
   * <p>Method under test: {@link Json#deprecated()}
   */
  @Test
  @DisplayName("Test Json deprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.deprecated()"})
  void testJsonDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().deprecated());
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    assertNull(actualJson.code);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
    assertFalse(actualJson.deprecated);
    assertFalse(actualJson.deprecatedIsSet);
    assertFalse(actualJson.unknown);
    assertFalse(actualJson.unknownIsSet);
  }

  /**
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
  }

  /**
   * Test Json {@link Json#setConcrete(boolean)}.
   *
   * <p>Method under test: {@link Json#setConcrete(boolean)}
   */
  @Test
  @DisplayName("Test Json setConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setConcrete(boolean)"})
  void testJsonSetConcrete() {
    // Arrange
    Json json = new Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }

  /**
   * Test Json {@link Json#setDeprecated(boolean)}.
   *
   * <p>Method under test: {@link Json#setDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Json setDeprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDeprecated(boolean)"})
  void testJsonSetDeprecated() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDeprecated(true);

    // Assert
    assertTrue(json.deprecated);
    assertTrue(json.deprecatedIsSet);
  }

  /**
   * Test Json {@link Json#setUnknown(boolean)}.
   *
   * <p>Method under test: {@link Json#setUnknown(boolean)}
   */
  @Test
  @DisplayName("Test Json setUnknown(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setUnknown(boolean)"})
  void testJsonSetUnknown() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUnknown(true);

    // Assert
    assertTrue(json.unknown);
    assertTrue(json.unknownIsSet);
  }

  /**
   * Test Json {@link Json#unknown()}.
   *
   * <p>Method under test: {@link Json#unknown()}
   */
  @Test
  @DisplayName("Test Json unknown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.unknown()"})
  void testJsonUnknown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().unknown());
  }

  /**
   * Test {@link ImmutableDataType#kind()}.
   *
   * <p>Method under test: {@link ImmutableDataType#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableDataType.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableDataType#parentId()}.
   *
   * <p>Method under test: {@link ImmutableDataType#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataType.parentId()"})
  void testParentId() {
    // Arrange and Act
    Optional<Long> actualParentIdResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableDataType#toString()}.
   *
   * <p>Method under test: {@link ImmutableDataType#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDataType.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "DataType{name=Name, code=Code, id=1, parentId=1, concrete=true, deprecated=false, kind=ALL,"
            + " unknown=false}",
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableDataType#unknown()}.
   *
   * <p>Method under test: {@link ImmutableDataType#unknown()}
   */
  @Test
  @DisplayName("Test unknown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableDataType.unknown()"})
  void testUnknown() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .unknown());
  }

  /**
   * Test {@link ImmutableDataType#withCode(String)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withCode(String)"})
  void testWithCode() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("42")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithCodeResult = immutableDataType.withCode("42");

    // Assert
    assertSame(immutableDataType, actualWithCodeResult);
  }

  /**
   * Test {@link ImmutableDataType#withCode(String)}.
   *
   * <ul>
   *   <li>Then return code is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withCode(String)}
   */
  @Test
  @DisplayName("Test withCode(String); then return code is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withCode(String)"})
  void testWithCode_thenReturnCodeIs42() {
    // Arrange and Act
    ImmutableDataType actualWithCodeResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withCode("42");

    // Assert
    assertEquals("42", actualWithCodeResult.code());
    assertEquals("Name", actualWithCodeResult.name());
    assertEquals("The characteristics of someone or something", actualWithCodeResult.description());
    assertEquals(EntityKind.ALL, actualWithCodeResult.kind());
    assertFalse(actualWithCodeResult.deprecated());
    assertFalse(actualWithCodeResult.unknown());
    assertTrue(actualWithCodeResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withConcrete(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withConcrete(boolean)"})
  void testWithConcrete() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithConcreteResult = immutableDataType.withConcrete(true);

    // Assert
    assertSame(immutableDataType, actualWithConcreteResult);
  }

  /**
   * Test {@link ImmutableDataType#withConcrete(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean); when 'false'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withConcrete(boolean)"})
  void testWithConcrete_whenFalse_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithConcreteResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withConcrete(false);

    // Assert
    assertEquals("Code", actualWithConcreteResult.code());
    assertEquals("Name", actualWithConcreteResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithConcreteResult.description());
    assertEquals(EntityKind.ALL, actualWithConcreteResult.kind());
    assertFalse(actualWithConcreteResult.concrete());
    assertFalse(actualWithConcreteResult.deprecated());
    assertFalse(actualWithConcreteResult.unknown());
  }

  /**
   * Test {@link ImmutableDataType#withDeprecated(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test withDeprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withDeprecated(boolean)"})
  void testWithDeprecated() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithDeprecatedResult = immutableDataType.withDeprecated(false);

    // Assert
    assertSame(immutableDataType, actualWithDeprecatedResult);
  }

  /**
   * Test {@link ImmutableDataType#withDeprecated(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test withDeprecated(boolean); when 'true'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withDeprecated(boolean)"})
  void testWithDeprecated_whenTrue_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithDeprecatedResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withDeprecated(true);

    // Assert
    assertEquals("Code", actualWithDeprecatedResult.code());
    assertEquals("Name", actualWithDeprecatedResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDeprecatedResult.description());
    assertEquals(EntityKind.ALL, actualWithDeprecatedResult.kind());
    assertFalse(actualWithDeprecatedResult.unknown());
    assertTrue(actualWithDeprecatedResult.concrete());
    assertTrue(actualWithDeprecatedResult.deprecated());
  }

  /**
   * Test {@link ImmutableDataType#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithDescriptionResult = immutableDataType.withDescription("42");

    // Assert
    assertEquals(immutableDataType, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableDataType#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithDescriptionResult = immutableDataType.withDescription("42");

    // Assert
    assertSame(immutableDataType, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableDataType#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDataType#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataType actualWithIdResult = immutableDataType.withId(optional);

    // Assert
    assertSame(immutableDataType, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDataType#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withId(Optional)"})
  void testWithIdWithOptional_thenReturnCode() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataType actualWithIdResult = immutableDataType.withId(optional);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.deprecated());
    assertFalse(actualWithIdResult.unknown());
    assertTrue(actualWithIdResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDataType#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithIdResult = immutableDataType.withId(1L);

    // Assert
    assertSame(immutableDataType, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDataType#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithIdResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Code", actualWithIdResult.code());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.deprecated());
    assertFalse(actualWithIdResult.unknown());
    assertTrue(actualWithIdResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithKindResult = immutableDataType.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableDataType, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableDataType#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withKind(EntityKind)"})
  void testWithKind_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithKindResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Code", actualWithKindResult.code());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertFalse(actualWithKindResult.deprecated());
    assertFalse(actualWithKindResult.unknown());
    assertTrue(actualWithKindResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithNameResult = immutableDataType.withName("42");

    // Assert
    assertSame(immutableDataType, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableDataType#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableDataType actualWithNameResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Code", actualWithNameResult.code());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertFalse(actualWithNameResult.deprecated());
    assertFalse(actualWithNameResult.unknown());
    assertTrue(actualWithNameResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDataType#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withParentId(Optional)"})
  void testWithParentIdWithOptional() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataType actualWithParentIdResult = immutableDataType.withParentId(optional);

    // Assert
    assertSame(immutableDataType, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableDataType#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withParentId(Optional)"})
  void testWithParentIdWithOptional_thenReturnCode() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataType actualWithParentIdResult = immutableDataType.withParentId(optional);

    // Assert
    assertEquals("Code", actualWithParentIdResult.code());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertFalse(actualWithParentIdResult.deprecated());
    assertFalse(actualWithParentIdResult.unknown());
    assertTrue(actualWithParentIdResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDataType#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withParentId(long)"})
  void testWithParentIdWithValue() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithParentIdResult = immutableDataType.withParentId(1L);

    // Assert
    assertSame(immutableDataType, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableDataType#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'; when forty-two; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withParentId(long)"})
  void testWithParentIdWithValue_whenFortyTwo_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithParentIdResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withParentId(42L);

    // Assert
    assertEquals("Code", actualWithParentIdResult.code());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertFalse(actualWithParentIdResult.deprecated());
    assertFalse(actualWithParentIdResult.unknown());
    assertTrue(actualWithParentIdResult.concrete());
  }

  /**
   * Test {@link ImmutableDataType#withUnknown(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataType#withUnknown(boolean)}
   */
  @Test
  @DisplayName("Test withUnknown(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withUnknown(boolean)"})
  void testWithUnknown() {
    // Arrange
    ImmutableDataType immutableDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableDataType actualWithUnknownResult = immutableDataType.withUnknown(false);

    // Assert
    assertSame(immutableDataType, actualWithUnknownResult);
  }

  /**
   * Test {@link ImmutableDataType#withUnknown(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataType#withUnknown(boolean)}
   */
  @Test
  @DisplayName("Test withUnknown(boolean); when 'true'; then return 'Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataType ImmutableDataType.withUnknown(boolean)"})
  void testWithUnknown_whenTrue_thenReturnCode() {
    // Arrange and Act
    ImmutableDataType actualWithUnknownResult =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withUnknown(true);

    // Assert
    assertEquals("Code", actualWithUnknownResult.code());
    assertEquals("Name", actualWithUnknownResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithUnknownResult.description());
    assertEquals(EntityKind.ALL, actualWithUnknownResult.kind());
    assertFalse(actualWithUnknownResult.deprecated());
    assertTrue(actualWithUnknownResult.concrete());
    assertTrue(actualWithUnknownResult.unknown());
  }
}
