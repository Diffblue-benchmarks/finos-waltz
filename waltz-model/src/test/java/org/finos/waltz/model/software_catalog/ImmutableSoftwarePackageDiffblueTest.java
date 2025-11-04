package org.finos.waltz.model.software_catalog;

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
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableSoftwarePackageDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Vendor", buildResult.vendor());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Vendor", buildResult.vendor());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn(null);
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Vendor", buildResult.vendor());
    assertNull(buildResult.group());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn(null);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.vendor());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Vendor", buildResult.vendor());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    ImmutableSoftwarePackage buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Vendor", buildResult.vendor());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable2() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableSoftwarePackage.Builder builderResult = ImmutableSoftwarePackage.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(false);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn(null);
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.group());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn(null);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    SoftwarePackage instance = mock(SoftwarePackage.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.group()).thenReturn("Group");
    when(instance.vendor()).thenReturn("Vendor");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).group();
    verify(instance).isNotable();
    verify(instance).kind();
    verify(instance).vendor();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).created());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#group()}
   */
  @Test
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).group());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#isNotable()}
   */
  @Test
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSoftwarePackage.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSoftwarePackage.Json actualJson = new ImmutableSoftwarePackage.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.group);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.vendor);
    assertNull(actualJson.kind);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable() {
    // Arrange
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackage.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable2() {
    // Arrange
    ImmutableSoftwarePackage.Json json = new ImmutableSoftwarePackage.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackage.Json#vendor()}
   */
  @Test
  void testJsonVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackage.Json()).vendor());
  }
}
