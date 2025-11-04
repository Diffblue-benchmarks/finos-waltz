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

class ImmutableSoftwarePackageViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackage)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom27() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn(null);
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom28() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn(null);
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom29() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom30() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom31() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
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
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom32() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView.Builder actualFromResult = builderResult.from(instance);

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
    verify(instance).version();
    ImmutableSoftwarePackageView buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("Group", buildResult.group());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Vendor", buildResult.vendor());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#from(SoftwarePackageView)}
   */
  @Test
  void testBuilderFrom33() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenThrow(new IllegalStateException("instance"));
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
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
    verify(instance).version();
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#isNotable(boolean)}
   */
  @Test
  void testBuilderIsNotable2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Builder#version(String)}
   */
  @Test
  void testBuilderVersion2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn(null);
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.group());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(false);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn(null);
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    SoftwarePackageView instance = mock(SoftwarePackageView.class);
    when(instance.group()).thenReturn("Group");
    when(instance.isNotable()).thenReturn(true);
    when(instance.vendor()).thenReturn("Vendor");
    when(instance.version()).thenReturn("1.0.2");
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

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
    verify(instance).version();
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).created());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#group()}
   */
  @Test
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).group());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#isNotable()}
   */
  @Test
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).isNotable());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSoftwarePackageView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSoftwarePackageView.Json actualJson = new ImmutableSoftwarePackageView.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.group);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.vendor);
    assertNull(actualJson.version);
    assertNull(actualJson.kind);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable() {
    // Arrange
    ImmutableSoftwarePackageView.Json json = new ImmutableSoftwarePackageView.Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwarePackageView.Json#setIsNotable(boolean)}
   */
  @Test
  void testJsonSetIsNotable2() {
    // Arrange
    ImmutableSoftwarePackageView.Json json = new ImmutableSoftwarePackageView.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#vendor()}
   */
  @Test
  void testJsonVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).vendor());
  }

  /**
   * Method under test: {@link ImmutableSoftwarePackageView.Json#version()}
   */
  @Test
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSoftwarePackageView.Json()).version());
  }
}
