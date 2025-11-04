package org.finos.waltz.model.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityNamedNodeTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityNamedNodeType#builder()}
   *   <li>{@link ImmutableEntityNamedNodeType#description(String)}
   *   <li>{@link ImmutableEntityNamedNodeType#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityNamedNodeType.Builder actualExternalIdResult = ImmutableEntityNamedNodeType.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableEntityNamedNodeType.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#addAllApplicableEntityKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicableEntityKinds() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicableEntityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#addAllApplicableEntityKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicableEntityKinds2() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    LinkedHashSet<EntityKind> elements = new LinkedHashSet<>();
    elements.add(EntityKind.ALL);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicableEntityKinds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#addApplicableEntityKinds(EntityKind)}
   */
  @Test
  void testBuilderAddApplicableEntityKinds() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicableEntityKinds(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#addApplicableEntityKinds(EntityKind[])}
   */
  @Test
  void testBuilderAddApplicableEntityKinds2() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicableEntityKinds(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#applicableEntityKinds(Iterable)}
   */
  @Test
  void testBuilderApplicableEntityKinds() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicableEntityKinds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#applicableEntityKinds(Iterable)}
   */
  @Test
  void testBuilderApplicableEntityKinds2() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    LinkedHashSet<EntityKind> elements = new LinkedHashSet<>();
    elements.add(EntityKind.ALL);

    // Act and Assert
    assertSame(builderResult, builderResult.applicableEntityKinds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    ImmutableEntityNamedNodeType buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertTrue(buildResult.applicableEntityKinds().isEmpty());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    ImmutableEntityNamedNodeType buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertTrue(buildResult.applicableEntityKinds().isEmpty());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    ImmutableEntityNamedNodeType buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertTrue(buildResult.applicableEntityKinds().isEmpty());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    ImmutableEntityNamedNodeType buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertTrue(buildResult.applicableEntityKinds().isEmpty());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#from(EntityNamedNodeType)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    HashSet<EntityKind> entityKindSet = new HashSet<>();
    entityKindSet.add(EntityKind.ALL);
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.applicableEntityKinds()).thenReturn(entityKindSet);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    ImmutableEntityNamedNodeType buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    Set<EntityKind> applicableEntityKindsResult = buildResult.applicableEntityKinds();
    assertEquals(1, applicableEntityKindsResult.size());
    assertEquals(1, buildResult.position());
    assertTrue(applicableEntityKindsResult.contains(EntityKind.ALL));
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableEntityNamedNodeType.Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType actualCopyOfResult = ImmutableEntityNamedNodeType.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertTrue(actualCopyOfResult.applicableEntityKinds().isEmpty());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType actualCopyOfResult = ImmutableEntityNamedNodeType.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertTrue(actualCopyOfResult.applicableEntityKinds().isEmpty());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.applicableEntityKinds()).thenReturn(new HashSet<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType actualCopyOfResult = ImmutableEntityNamedNodeType.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertTrue(actualCopyOfResult.applicableEntityKinds().isEmpty());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<EntityKind> entityKindSet = new HashSet<>();
    entityKindSet.add(EntityKind.ALL);
    EntityNamedNodeType instance = mock(EntityNamedNodeType.class);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.applicableEntityKinds()).thenReturn(entityKindSet);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityNamedNodeType actualCopyOfResult = ImmutableEntityNamedNodeType.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).applicableEntityKinds();
    verify(instance).isReadOnly();
    verify(instance).position();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<EntityKind> applicableEntityKindsResult = actualCopyOfResult.applicableEntityKinds();
    assertEquals(1, applicableEntityKindsResult.size());
    assertEquals(1, actualCopyOfResult.position());
    assertTrue(applicableEntityKindsResult.contains(EntityKind.ALL));
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Json#applicableEntityKinds()}
   */
  @Test
  void testJsonApplicableEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNodeType.Json()).applicableEntityKinds());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityNamedNodeType.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityNamedNodeType.Json actualJson = new ImmutableEntityNamedNodeType.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.positionIsSet);
    assertTrue(actualJson.applicableEntityKinds.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityNamedNodeType.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNodeType.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableEntityNamedNodeType.Json json = new ImmutableEntityNamedNodeType.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityNamedNodeType.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableEntityNamedNodeType.Json json = new ImmutableEntityNamedNodeType.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
