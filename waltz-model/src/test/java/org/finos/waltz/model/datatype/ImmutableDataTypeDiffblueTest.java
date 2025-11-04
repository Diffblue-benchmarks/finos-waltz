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
import java.util.Optional;
import org.finos.waltz.model.CodeProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataType#builder()}
   *   <li>{@link ImmutableDataType#description(String)}
   *   <li>{@link ImmutableDataType#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDataType.Builder actualIdResult = ImmutableDataType.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableDataType.Builder actualParentIdResult = actualIdResult.id(id).kind(EntityKind.ALL).parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualParentIdResult, actualParentIdResult.parentId(parentId));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#concrete(boolean)}
   */
  @Test
  void testBuilderConcrete() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.concrete(true));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#deprecated(boolean)}
   */
  @Test
  void testBuilderDeprecated() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.deprecated(true));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(CodeProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenReturn("Code");

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(CodeProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Method under test:
   * {@link ImmutableDataType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#from(DataType)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
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
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableDataType.Builder#from(DataType)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
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
   * Method under test: {@link ImmutableDataType.Builder#from(DataType)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
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
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableDataType.Builder#from(DataType)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
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
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableDataType.Builder#from(DataType)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
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
    ImmutableDataType.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableDataType.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test: {@link ImmutableDataType.Builder#unknown(boolean)}
   */
  @Test
  void testBuilderUnknown() {
    // Arrange
    ImmutableDataType.Builder builderResult = ImmutableDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknown(true));
  }

  /**
   * Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

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
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.concrete());
    assertTrue(actualCopyOfResult.deprecated());
    assertTrue(actualCopyOfResult.unknown());
  }

  /**
   * Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

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
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.concrete());
    assertTrue(actualCopyOfResult.deprecated());
    assertTrue(actualCopyOfResult.unknown());
  }

  /**
   * Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
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
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

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
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.concrete());
    assertTrue(actualCopyOfResult.deprecated());
    assertTrue(actualCopyOfResult.unknown());
  }

  /**
   * Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

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
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.concrete());
    assertTrue(actualCopyOfResult.deprecated());
    assertTrue(actualCopyOfResult.unknown());
  }

  /**
   * Method under test: {@link ImmutableDataType#copyOf(DataType)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    DataType instance = mock(DataType.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.unknown()).thenReturn(false);
    when(instance.name()).thenReturn("Name");
    when(instance.deprecated()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.code()).thenReturn("Code");
    when(instance.concrete()).thenReturn(true);

    // Act
    ImmutableDataType actualCopyOfResult = ImmutableDataType.copyOf(instance);

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
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.unknown());
    assertTrue(actualCopyOfResult.concrete());
    assertTrue(actualCopyOfResult.deprecated());
  }

  /**
   * Method under test: {@link ImmutableDataType#fromJson(ImmutableDataType.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDataType.Json json = new ImmutableDataType.Json();
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
   * Method under test: {@link ImmutableDataType#fromJson(ImmutableDataType.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDataType.Json json = new ImmutableDataType.Json();
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
   * Method under test: {@link ImmutableDataType.Json#code()}
   */
  @Test
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).code());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#concrete()}
   */
  @Test
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).concrete());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#deprecated()}
   */
  @Test
  void testJsonDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).deprecated());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDataType.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDataType.Json actualJson = new ImmutableDataType.Json();

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
   * Method under test: {@link ImmutableDataType.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).parentId());
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#setConcrete(boolean)}
   */
  @Test
  void testJsonSetConcrete() {
    // Arrange
    ImmutableDataType.Json json = new ImmutableDataType.Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#setDeprecated(boolean)}
   */
  @Test
  void testJsonSetDeprecated() {
    // Arrange
    ImmutableDataType.Json json = new ImmutableDataType.Json();

    // Act
    json.setDeprecated(true);

    // Assert
    assertTrue(json.deprecated);
    assertTrue(json.deprecatedIsSet);
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#setUnknown(boolean)}
   */
  @Test
  void testJsonSetUnknown() {
    // Arrange
    ImmutableDataType.Json json = new ImmutableDataType.Json();

    // Act
    json.setUnknown(true);

    // Assert
    assertTrue(json.unknown);
    assertTrue(json.unknownIsSet);
  }

  /**
   * Method under test: {@link ImmutableDataType.Json#unknown()}
   */
  @Test
  void testJsonUnknown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataType.Json()).unknown());
  }
}
