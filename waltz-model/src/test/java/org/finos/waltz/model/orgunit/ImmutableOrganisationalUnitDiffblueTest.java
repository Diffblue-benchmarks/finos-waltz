package org.finos.waltz.model.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.waltz.model.ParentIdProvider;
import org.junit.jupiter.api.Test;

class ImmutableOrganisationalUnitDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnit#builder()}
   *   <li>{@link ImmutableOrganisationalUnit#description(String)}
   *   <li>{@link ImmutableOrganisationalUnit#externalId(String)}
   *   <li>{@link ImmutableOrganisationalUnit#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableOrganisationalUnit.Builder actualExternalIdResult = ImmutableOrganisationalUnit.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableOrganisationalUnit.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableOrganisationalUnit.Builder actualParentIdResult = actualIdResult.id(id).kind(EntityKind.ALL).parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Assert
    assertSame(actualParentIdResult, actualParentIdResult.parentId(parentId));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ORG_UNIT, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#from(OrganisationalUnit)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();

    // Act
    ImmutableOrganisationalUnit.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableOrganisationalUnit buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ORG_UNIT, buildResult.kind());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableOrganisationalUnit.Builder builderResult = ImmutableOrganisationalUnit.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    OrganisationalUnit instance = mock(OrganisationalUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).kind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#fromJson(ImmutableOrganisationalUnit.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableOrganisationalUnit#fromJson(ImmutableOrganisationalUnit.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableOrganisationalUnit.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableOrganisationalUnit.Json actualJson = new ImmutableOrganisationalUnit.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableOrganisationalUnit.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableOrganisationalUnit.Json()).parentId());
  }
}
