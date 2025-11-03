package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableDataType#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataType#builder()}
   *   <li>{@link ImmutableDataType#description(String)}
   *   <li>{@link ImmutableDataType#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDataType Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.kind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableDataType.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualParentIdResult = actualIdResult.id(id).kind(EntityKind.ALL).parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualParentIdResult, actualParentIdResult.parentId(parentId));
  }

  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#concrete(boolean)}.
   * <p>
   * Method under test: {@link Builder#concrete(boolean)}
   */
  @Test
  @DisplayName("Test Builder concrete(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.concrete(boolean)"})
  void testBuilderConcrete() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.concrete(true));
  }

  /**
   * Test Builder {@link Builder#deprecated(boolean)}.
   * <p>
   * Method under test: {@link Builder#deprecated(boolean)}
   */
  @Test
  @DisplayName("Test Builder deprecated(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.deprecated(boolean)"})
  void testBuilderDeprecated() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.deprecated(true));
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   * <ul>
   *   <li>Given {@code Code}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CodeProvider) with 'CodeProvider'; given 'Code'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_givenCode_thenReturnBuilder() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CodeProvider) with 'CodeProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   * <p>
   * Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DataType instance = mock(DataType.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.unknown()).thenReturn(true);
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).concrete();
    verify(instance).deprecated();
    verify(instance).kind();
    verify(instance).unknown();
    ImmutableDataType buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.concrete());
    assertTrue(buildResult.deprecated());
    assertTrue(buildResult.unknown());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link DataType} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'; given empty; when DataType id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType_givenEmpty_whenDataTypeIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DataType instance = mock(DataType.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.unknown()).thenReturn(true);
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).concrete();
    verify(instance).deprecated();
    verify(instance).kind();
    verify(instance).unknown();
    ImmutableDataType buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.concrete());
    assertTrue(buildResult.deprecated());
    assertTrue(buildResult.unknown());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link DataType} {@link ParentIdProvider#parentId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'; given empty; when DataType parentId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType_givenEmpty_whenDataTypeParentIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DataType instance = mock(DataType.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.unknown()).thenReturn(true);
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).concrete();
    verify(instance).deprecated();
    verify(instance).kind();
    verify(instance).unknown();
    ImmutableDataType buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.concrete());
    assertTrue(buildResult.deprecated());
    assertTrue(buildResult.unknown());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DataType instance = mock(DataType.class);
    when(instance.description()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.unknown()).thenReturn(true);
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).concrete();
    verify(instance).deprecated();
    verify(instance).kind();
    verify(instance).unknown();
    ImmutableDataType buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.concrete());
    assertTrue(buildResult.deprecated());
    assertTrue(buildResult.unknown());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataType)} with {@code DataType}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataType)}
   */
  @Test
  @DisplayName("Test Builder from(DataType) with 'DataType'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataType)"})
  void testBuilderFromWithDataType_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DataType instance = mock(DataType.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).description();
    verify(instance).name();
    verify(instance).concrete();
    verify(instance).deprecated();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Test Builder {@link Builder#unknown(boolean)}.
   * <p>
   * Method under test: {@link Builder#unknown(boolean)}
   */
  @Test
  @DisplayName("Test Builder unknown(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.unknown(boolean)"})
  void testBuilderUnknown() {
    // Arrange
    Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknown(true));
  }

  /**
   * Test Json {@link Json#code()}.
   * <p>
   * Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).code());
  }

  /**
   * Test Json {@link Json#concrete()}.
   * <p>
   * Method under test: {@link Json#concrete()}
   */
  @Test
  @DisplayName("Test Json concrete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.concrete()"})
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).concrete());
  }

  /**
   * Test Json {@link Json#deprecated()}.
   * <p>
   * Method under test: {@link Json#deprecated()}
   */
  @Test
  @DisplayName("Test Json deprecated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.deprecated()"})
  void testJsonDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).deprecated());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentId());
  }

  /**
   * Test Json {@link Json#setConcrete(boolean)}.
   * <p>
   * Method under test: {@link Json#setConcrete(boolean)}
   */
  @Test
  @DisplayName("Test Json setConcrete(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Json setDeprecated(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setUnknown(boolean)}
   */
  @Test
  @DisplayName("Test Json setUnknown(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#unknown()}
   */
  @Test
  @DisplayName("Test Json unknown()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.unknown()"})
  void testJsonUnknown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).unknown());
  }
}
