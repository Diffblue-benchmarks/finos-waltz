package org.finos.waltz.model.complexity;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableComplexityKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityKind#builder()}
   *   <li>{@link ImmutableComplexityKind#description(String)}
   *   <li>{@link ImmutableComplexityKind#externalId(String)}
   *   <li>{@link ImmutableComplexityKind#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableComplexityKind.Builder actualExternalIdResult = ImmutableComplexityKind.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableComplexityKind.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableComplexityKind.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ComplexityKind)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    ImmutableComplexityKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ComplexityKind)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ComplexityKind)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    ImmutableComplexityKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ComplexityKind)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    ImmutableComplexityKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableComplexityKind.Builder#from(ComplexityKind)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    ImmutableComplexityKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#isDefault(boolean)}
   */
  @Test
  void testBuilderIsDefault() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDefault(true));
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableComplexityKind.Builder builderResult = ImmutableComplexityKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(false);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ComplexityKind instance = mock(ComplexityKind.class);
    when(instance.isDefault()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#isDefault()}
   */
  @Test
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).isDefault());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableComplexityKind.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableComplexityKind.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableComplexityKind.Json actualJson = new ImmutableComplexityKind.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
  }

  /**
   * Method under test: {@link ImmutableComplexityKind.Json#setIsDefault(boolean)}
   */
  @Test
  void testJsonSetIsDefault() {
    // Arrange
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }
}
