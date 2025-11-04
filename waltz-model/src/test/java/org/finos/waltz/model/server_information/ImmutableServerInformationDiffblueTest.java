package org.finos.waltz.model.server_information;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EndOfLifeStatus;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableServerInformationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableServerInformation#builder()}
   *   <li>{@link ImmutableServerInformation#externalId(String)}
   *   <li>{@link ImmutableServerInformation#hardwareEndOfLifeDate(Date)}
   *   <li>{@link ImmutableServerInformation#kind(EntityKind)}
   *   <li>{@link ImmutableServerInformation#operatingSystemEndOfLifeDate(Date)}
   *   <li>{@link ImmutableServerInformation#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableServerInformation.Builder actualExternalIdResult = ImmutableServerInformation.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableServerInformation.Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    ImmutableServerInformation.Builder actualIdResult = actualExternalIdResult2
        .hardwareEndOfLifeDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableServerInformation.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableServerInformation.Builder actualOperatingSystemEndOfLifeDateResult = actualKindResult
        .operatingSystemEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(actualOperatingSystemEndOfLifeDateResult,
        actualOperatingSystemEndOfLifeDateResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#country(String)}
   */
  @Test
  void testBuilderCountry() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.country("GB"));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#country(String)}
   */
  @Test
  void testBuilderCountry2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.country("GB"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.operatingSystemVersion());
    assertEquals("GB", buildResult.country());
    assertEquals("Location", buildResult.location());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("localhost", buildResult.hostname());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertTrue(buildResult.virtual());
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    when(instance.operatingSystemEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.hardwareEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.operatingSystemVersion());
    assertEquals("GB", buildResult.country());
    assertEquals("Location", buildResult.location());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("localhost", buildResult.hostname());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertTrue(buildResult.virtual());
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(null);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.operatingSystemVersion());
    assertEquals("GB", buildResult.country());
    assertEquals("Location", buildResult.location());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("localhost", buildResult.hostname());
    assertNull(buildResult.operatingSystemEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, buildResult.operatingSystemEndOfLifeStatus());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertTrue(buildResult.virtual());
    assertSame(fromResult, buildResult.hardwareEndOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.operatingSystemVersion());
    assertEquals("GB", buildResult.country());
    assertEquals("Location", buildResult.location());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("localhost", buildResult.hostname());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertTrue(buildResult.virtual());
    assertSame(fromResult2, buildResult.hardwareEndOfLifeDate());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#from(ServerInformation)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.hardwareEndOfLifeDate()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    ImmutableServerInformation buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.operatingSystemVersion());
    assertEquals("GB", buildResult.country());
    assertEquals("Location", buildResult.location());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("localhost", buildResult.hostname());
    assertNull(buildResult.hardwareEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, buildResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, buildResult.lifecycleStatus());
    assertTrue(buildResult.virtual());
    assertSame(fromResult, buildResult.operatingSystemEndOfLifeDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#hostname(String)}
   */
  @Test
  void testBuilderHostname() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hostname("localhost"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#hostname(String)}
   */
  @Test
  void testBuilderHostname2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.hostname("localhost"));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  void testBuilderLifecycleStatus() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  void testBuilderLifecycleStatus2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lifecycleStatus(LifecycleStatus.ACTIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#location(String)}
   */
  @Test
  void testBuilderLocation() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.location("Location"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#location(String)}
   */
  @Test
  void testBuilderLocation2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.location("Location"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#operatingSystem(String)}
   */
  @Test
  void testBuilderOperatingSystem() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#operatingSystem(String)}
   */
  @Test
  void testBuilderOperatingSystem2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#operatingSystemVersion(String)}
   */
  @Test
  void testBuilderOperatingSystemVersion() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemVersion("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#operatingSystemVersion(String)}
   */
  @Test
  void testBuilderOperatingSystemVersion2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystemVersion("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#virtual(boolean)}
   */
  @Test
  void testBuilderVirtual() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.virtual(true));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Builder#virtual(boolean)}
   */
  @Test
  void testBuilderVirtual2() {
    // Arrange
    ImmutableServerInformation.Builder builderResult = ImmutableServerInformation.builder();
    builderResult.hardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.virtual(true));
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult2, actualCopyOfResult.hardwareEndOfLifeDate());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult2, actualCopyOfResult.hardwareEndOfLifeDate());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualCopyOfResult.operatingSystemEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
    assertSame(fromResult2, actualCopyOfResult.hardwareEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(null);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertNull(actualCopyOfResult.operatingSystemEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualCopyOfResult.operatingSystemEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult, actualCopyOfResult.hardwareEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult2, actualCopyOfResult.hardwareEndOfLifeDate());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.hardwareEndOfLifeDate()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(true);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertNull(actualCopyOfResult.hardwareEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualCopyOfResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertTrue(actualCopyOfResult.virtual());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    ServerInformation instance = mock(ServerInformation.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.location()).thenReturn("Location");
    when(instance.operatingSystemVersion()).thenReturn("1.0.2");
    when(instance.hostname()).thenReturn("localhost");
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.operatingSystemEndOfLifeDate()).thenReturn(fromResult);
    when(instance.operatingSystem()).thenReturn("Operating System");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.hardwareEndOfLifeDate()).thenReturn(fromResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(instance.virtual()).thenReturn(false);
    when(instance.country()).thenReturn("GB");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).country();
    verify(instance).hardwareEndOfLifeDate();
    verify(instance).hostname();
    verify(instance).kind();
    verify(instance).lifecycleStatus();
    verify(instance).location();
    verify(instance).operatingSystem();
    verify(instance).operatingSystemEndOfLifeDate();
    verify(instance).operatingSystemVersion();
    verify(instance).provenance();
    verify(instance).virtual();
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertFalse(actualCopyOfResult.virtual());
    assertSame(fromResult2, actualCopyOfResult.hardwareEndOfLifeDate());
    assertSame(fromResult, actualCopyOfResult.operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#country()}
   */
  @Test
  void testJsonCountry() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).country());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#hardwareEndOfLifeDate()}
   */
  @Test
  void testJsonHardwareEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerInformation.Json()).hardwareEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#hardwareEndOfLifeStatus()}
   */
  @Test
  void testJsonHardwareEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerInformation.Json()).hardwareEndOfLifeStatus());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#hostname()}
   */
  @Test
  void testJsonHostname() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).hostname());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#lifecycleStatus()}
   */
  @Test
  void testJsonLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).lifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#location()}
   */
  @Test
  void testJsonLocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).location());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableServerInformation.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableServerInformation.Json actualJson = new ImmutableServerInformation.Json();

    // Assert
    assertNull(actualJson.country);
    assertNull(actualJson.hostname);
    assertNull(actualJson.location);
    assertNull(actualJson.operatingSystem);
    assertNull(actualJson.operatingSystemVersion);
    assertNull(actualJson.provenance);
    assertNull(actualJson.hardwareEndOfLifeDate);
    assertNull(actualJson.operatingSystemEndOfLifeDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.virtual);
    assertFalse(actualJson.virtualIsSet);
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#operatingSystem()}
   */
  @Test
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).operatingSystem());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#operatingSystemEndOfLifeDate()}
   */
  @Test
  void testJsonOperatingSystemEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerInformation.Json()).operatingSystemEndOfLifeDate());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#operatingSystemEndOfLifeStatus()}
   */
  @Test
  void testJsonOperatingSystemEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerInformation.Json()).operatingSystemEndOfLifeStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#operatingSystemVersion()}
   */
  @Test
  void testJsonOperatingSystemVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableServerInformation.Json()).operatingSystemVersion());
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#setVirtual(boolean)}
   */
  @Test
  void testJsonSetVirtual() {
    // Arrange
    ImmutableServerInformation.Json json = new ImmutableServerInformation.Json();

    // Act
    json.setVirtual(true);

    // Assert
    assertTrue(json.virtual);
    assertTrue(json.virtualIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableServerInformation.Json#setVirtual(boolean)}
   */
  @Test
  void testJsonSetVirtual2() {
    // Arrange
    ImmutableServerInformation.Json json = new ImmutableServerInformation.Json();
    json.setHardwareEndOfLifeDate(mock(java.sql.Date.class));

    // Act
    json.setVirtual(true);

    // Assert
    assertTrue(json.virtual);
    assertTrue(json.virtualIsSet);
  }

  /**
   * Method under test: {@link ImmutableServerInformation.Json#virtual()}
   */
  @Test
  void testJsonVirtual() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableServerInformation.Json()).virtual());
  }
}
