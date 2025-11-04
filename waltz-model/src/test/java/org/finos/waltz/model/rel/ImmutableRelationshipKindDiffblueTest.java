package org.finos.waltz.model.rel;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableRelationshipKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRelationshipKind#builder()}
   *   <li>{@link ImmutableRelationshipKind#categoryA(Long)}
   *   <li>{@link ImmutableRelationshipKind#categoryB(Long)}
   *   <li>{@link ImmutableRelationshipKind#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableRelationshipKind.Builder actualIdResult = ImmutableRelationshipKind.builder()
        .categoryA(1L)
        .categoryB(1L)
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(null);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.categoryA());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.categoryB());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#from(RelationshipKind)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn(null);
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    ImmutableRelationshipKind buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("Reverse Name", buildResult.reverseName());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryA().longValue());
    assertEquals(1L, buildResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, buildResult.kindA());
    assertEquals(EntityKind.ALL, buildResult.kindB());
    assertTrue(buildResult.isReadonly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#isReadonly(boolean)}
   */
  @Test
  void testBuilderIsReadonly() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#kindA(EntityKind)}
   */
  @Test
  void testBuilderKindA() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindA(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#kindB(EntityKind)}
   */
  @Test
  void testBuilderKindB() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kindB(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Builder#reverseName(String)}
   */
  @Test
  void testBuilderReverseName() {
    // Arrange
    ImmutableRelationshipKind.Builder builderResult = ImmutableRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.reverseName("Reverse Name"));
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind#copyOf(RelationshipKind)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind actualCopyOfResult = ImmutableRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.categoryA().longValue());
    assertEquals(1L, actualCopyOfResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindA());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindB());
    assertTrue(actualCopyOfResult.isReadonly());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind#copyOf(RelationshipKind)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind actualCopyOfResult = ImmutableRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.categoryA().longValue());
    assertEquals(1L, actualCopyOfResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindA());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindB());
    assertTrue(actualCopyOfResult.isReadonly());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind#copyOf(RelationshipKind)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    RelationshipKind instance = mock(RelationshipKind.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.kindB()).thenReturn(EntityKind.ALL);
    when(instance.categoryA()).thenReturn(1L);
    when(instance.kindA()).thenReturn(EntityKind.ALL);
    when(instance.reverseName()).thenReturn("Reverse Name");
    when(instance.categoryB()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.code()).thenReturn("Code");
    when(instance.isReadonly()).thenReturn(false);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRelationshipKind actualCopyOfResult = ImmutableRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).categoryA();
    verify(instance).categoryB();
    verify(instance).code();
    verify(instance).isReadonly();
    verify(instance).kindA();
    verify(instance).kindB();
    verify(instance).position();
    verify(instance).reverseName();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.categoryA().longValue());
    assertEquals(1L, actualCopyOfResult.categoryB().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindA());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kindB());
    assertFalse(actualCopyOfResult.isReadonly());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#categoryA()}
   */
  @Test
  void testJsonCategoryA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).categoryA());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#categoryB()}
   */
  @Test
  void testJsonCategoryB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).categoryB());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#code()}
   */
  @Test
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).code());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#isReadonly()}
   */
  @Test
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).isReadonly());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#kindA()}
   */
  @Test
  void testJsonKindA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).kindA());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#kindB()}
   */
  @Test
  void testJsonKindB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).kindB());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRelationshipKind.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRelationshipKind.Json actualJson = new ImmutableRelationshipKind.Json();

    // Assert
    assertNull(actualJson.categoryA);
    assertNull(actualJson.categoryB);
    assertNull(actualJson.code);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.reverseName);
    assertNull(actualJson.kindA);
    assertNull(actualJson.kindB);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadonly);
    assertFalse(actualJson.isReadonlyIsSet);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#reverseName()}
   */
  @Test
  void testJsonReverseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRelationshipKind.Json()).reverseName());
  }

  /**
   * Method under test:
   * {@link ImmutableRelationshipKind.Json#setIsReadonly(boolean)}
   */
  @Test
  void testJsonSetIsReadonly() {
    // Arrange
    ImmutableRelationshipKind.Json json = new ImmutableRelationshipKind.Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableRelationshipKind.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableRelationshipKind.Json json = new ImmutableRelationshipKind.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
