package org.finos.waltz.model.cost;

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

class ImmutableEntityCostKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityCostKind#builder()}
   *   <li>{@link ImmutableEntityCostKind#description(String)}
   *   <li>{@link ImmutableEntityCostKind#externalId(String)}
   *   <li>{@link ImmutableEntityCostKind#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityCostKind.Builder actualExternalIdResult = ImmutableEntityCostKind.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableEntityCostKind.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityCostKind.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityCostKind)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableEntityCostKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityCostKind)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityCostKind instance = mock(EntityCostKind.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityCostKind)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableEntityCostKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityCostKind)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableEntityCostKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#from(EntityCostKind)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableEntityCostKind buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.isDefault());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#isDefault(boolean)}
   */
  @Test
  void testBuilderIsDefault() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDefault(true));
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostKind.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableEntityCostKind.Builder builderResult = ImmutableEntityCostKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind#copyOf(EntityCostKind)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind actualCopyOfResult = ImmutableEntityCostKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind#copyOf(EntityCostKind)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind actualCopyOfResult = ImmutableEntityCostKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind#copyOf(EntityCostKind)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind actualCopyOfResult = ImmutableEntityCostKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind#copyOf(EntityCostKind)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(false);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind actualCopyOfResult = ImmutableEntityCostKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertFalse(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind#copyOf(EntityCostKind)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    EntityCostKind instance = mock(EntityCostKind.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.isDefault()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityCostKind actualCopyOfResult = ImmutableEntityCostKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).isDefault();
    verify(instance).kind();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#isDefault()}
   */
  @Test
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).isDefault());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityCostKind.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityCostKind.Json actualJson = new ImmutableEntityCostKind.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#setIsDefault(boolean)}
   */
  @Test
  void testJsonSetIsDefault() {
    // Arrange
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCostKind.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostKind.Json()).subjectKind());
  }
}
