package org.finos.waltz.model.logical_data_element;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableLogicalDataElementDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalDataElement#builder()}
   *   <li>{@link ImmutableLogicalDataElement#description(String)}
   *   <li>
   * {@link ImmutableLogicalDataElement#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableLogicalDataElement#externalId(String)}
   *   <li>{@link ImmutableLogicalDataElement#kind(EntityKind)}
   *   <li>{@link ImmutableLogicalDataElement#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLogicalDataElement.Builder actualExternalIdResult = ImmutableLogicalDataElement.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableLogicalDataElement.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableLogicalDataElement.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(LogicalDataElement)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    ImmutableLogicalDataElement buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(LogicalDataElement)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    LogicalDataElement instance = mock(LogicalDataElement.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).provenance();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(LogicalDataElement)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    ImmutableLogicalDataElement buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(LogicalDataElement)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    ImmutableLogicalDataElement buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#from(LogicalDataElement)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    ImmutableLogicalDataElement buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#parentDataTypeId(long)}
   */
  @Test
  void testBuilderParentDataTypeId() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentDataTypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Builder#type(FieldDataType)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutableLogicalDataElement.Builder builderResult = ImmutableLogicalDataElement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(FieldDataType.DATE));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement actualCopyOfResult = ImmutableLogicalDataElement.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement actualCopyOfResult = ImmutableLogicalDataElement.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement actualCopyOfResult = ImmutableLogicalDataElement.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement#copyOf(LogicalDataElement)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    LogicalDataElement instance = mock(LogicalDataElement.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.parentDataTypeId()).thenReturn(1L);
    when(instance.type()).thenReturn(FieldDataType.DATE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLogicalDataElement actualCopyOfResult = ImmutableLogicalDataElement.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).parentDataTypeId();
    verify(instance).provenance();
    verify(instance).type();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualCopyOfResult.type());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalDataElement.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalDataElement.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalDataElement.Json actualJson = new ImmutableLogicalDataElement.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.type);
    assertEquals(0L, actualJson.parentDataTypeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentDataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Json#parentDataTypeId()}
   */
  @Test
  void testJsonParentDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalDataElement.Json()).parentDataTypeId());
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalDataElement.Json#setParentDataTypeId(long)}
   */
  @Test
  void testJsonSetParentDataTypeId() {
    // Arrange
    ImmutableLogicalDataElement.Json json = new ImmutableLogicalDataElement.Json();

    // Act
    json.setParentDataTypeId(1L);

    // Assert
    assertEquals(1L, json.parentDataTypeId);
    assertTrue(json.parentDataTypeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalDataElement.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalDataElement.Json()).type());
  }
}
