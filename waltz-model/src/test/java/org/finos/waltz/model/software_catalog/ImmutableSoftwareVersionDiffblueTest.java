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
import java.time.LocalDate;
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

class ImmutableSoftwareVersionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    when(instance.releaseDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).provenance();
    verify(instance).name();
    verify(instance).releaseDate();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    ImmutableSoftwareVersion buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(ofResult4, buildResult.releaseDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn(null);
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    ImmutableSoftwareVersion buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(ofResult4, buildResult.releaseDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    ImmutableSoftwareVersion buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(ofResult3, buildResult.releaseDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    ImmutableSoftwareVersion buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(ofResult3, buildResult.releaseDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    ImmutableSoftwareVersion buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.softwarePackageId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(ofResult3, buildResult.releaseDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#from(SoftwareVersion)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.softwarePackageId()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.releaseDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#releaseDate(LocalDate)}
   */
  @Test
  void testBuilderReleaseDate() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.releaseDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#releaseDate(LocalDate)}
   */
  @Test
  void testBuilderReleaseDate2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.releaseDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#softwarePackageId(long)}
   */
  @Test
  void testBuilderSoftwarePackageId() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.softwarePackageId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Builder#softwarePackageId(long)}
   */
  @Test
  void testBuilderSoftwarePackageId2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.softwarePackageId(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Builder#version(String)}
   */
  @Test
  void testBuilderVersion2() {
    // Arrange
    ImmutableSoftwareVersion.Builder builderResult = ImmutableSoftwareVersion.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult4, releaseDateResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn(null);
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult4, releaseDateResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult3, releaseDateResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult3, releaseDateResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SoftwareVersion instance = mock(SoftwareVersion.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.version()).thenReturn("1.0.2");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.softwarePackageId()).thenReturn(1L);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.releaseDate()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).releaseDate();
    verify(instance).softwarePackageId();
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(ofResult3, releaseDateResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).created());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSoftwareVersion.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSoftwareVersion.Json actualJson = new ImmutableSoftwareVersion.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.version);
    assertNull(actualJson.releaseDate);
    assertNull(actualJson.kind);
    assertEquals(0L, actualJson.softwarePackageId);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.softwarePackageIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#releaseDate()}
   */
  @Test
  void testJsonReleaseDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).releaseDate());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Json#setSoftwarePackageId(long)}
   */
  @Test
  void testJsonSetSoftwarePackageId() {
    // Arrange
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareVersion.Json#setSoftwarePackageId(long)}
   */
  @Test
  void testJsonSetSoftwarePackageId2() {
    // Arrange
    ImmutableSoftwareVersion.Json json = new ImmutableSoftwareVersion.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#softwarePackageId()}
   */
  @Test
  void testJsonSoftwarePackageId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).softwarePackageId());
  }

  /**
   * Method under test: {@link ImmutableSoftwareVersion.Json#version()}
   */
  @Test
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwareVersion.Json()).version());
  }
}
