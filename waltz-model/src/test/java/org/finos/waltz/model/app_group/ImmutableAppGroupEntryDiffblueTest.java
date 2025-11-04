package org.finos.waltz.model.app_group;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroupEntry#builder()}
   *   <li>{@link ImmutableAppGroupEntry#description(String)}
   *   <li>
   * {@link ImmutableAppGroupEntry#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableAppGroupEntry#externalId(String)}
   *   <li>{@link ImmutableAppGroupEntry#name(String)}
   *   <li>{@link ImmutableAppGroupEntry#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAppGroupEntry.Builder actualExternalIdResult = ImmutableAppGroupEntry.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableAppGroupEntry.Builder actualNameResult = actualExternalIdResult.externalId(externalId).name("Name");
    Optional<String> name = Optional.of("foo");
    ImmutableAppGroupEntry.Builder actualNameResult2 = actualNameResult.name(name);

    // Assert
    assertSame(actualNameResult2, actualNameResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("waltz", buildResult.provenance());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertFalse(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityReference instance = mock(EntityReference.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("waltz", buildResult.provenance());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertFalse(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("waltz", buildResult.provenance());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertFalse(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("waltz", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertFalse(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#from(AppGroupEntry)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#from(AppGroupEntry)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    AppGroupEntry instance = mock(AppGroupEntry.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#from(AppGroupEntry)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#from(AppGroupEntry)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#from(AppGroupEntry)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    ImmutableAppGroupEntry buildResult = builderResult.build();
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Builder#name(Optional)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAppGroupEntry.Builder builderResult = ImmutableAppGroupEntry.builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AppGroupEntry instance = mock(AppGroupEntry.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).isReadOnly();
    verify(instance).provenance();
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupEntry.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppGroupEntry.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppGroupEntry.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppGroupEntry.Json actualJson = new ImmutableAppGroupEntry.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.idIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupEntry.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableAppGroupEntry.Json json = new ImmutableAppGroupEntry.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppGroupEntry.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableAppGroupEntry.Json json = new ImmutableAppGroupEntry.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }
}
