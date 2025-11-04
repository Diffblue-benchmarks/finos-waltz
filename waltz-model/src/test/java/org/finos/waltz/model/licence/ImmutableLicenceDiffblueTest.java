package org.finos.waltz.model.licence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedUserTimestampProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableLicenceDiffblueTest {
  /**
   * Method under test: {@link ImmutableLicence.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdated();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdated()).thenReturn(emptyResult);

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdated();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicence.Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    when(instance.lastUpdated()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdated();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("waltz", buildResult.provenance());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.lastUpdated()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdated();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdated()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn(null);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#from(Licence)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();

    // Act
    ImmutableLicence.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("waltz", buildResult.provenance());
    assertNull(buildResult.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableLicence.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableLicence.Builder builderResult = ImmutableLicence.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act
    ImmutableLicence.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableLicence buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("waltz", buildResult.provenance());
    assertNull(buildResult.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn(null);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdated()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    Licence instance = mock(Licence.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult3);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdated()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdated();
    verify(instance).name();
    verify(instance).provenance();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#fromJson(ImmutableLicence.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLicence.Json json = new ImmutableLicence.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence#fromJson(ImmutableLicence.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableLicence.Json json = new ImmutableLicence.Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance("Json");

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).created());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#lastUpdated()}
   */
  @Test
  void testJsonLastUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).lastUpdated());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLicence.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLicence.Json actualJson = new ImmutableLicence.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastUpdated.isPresent());
  }

  /**
   * Method under test: {@link ImmutableLicence.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicence.Json()).provenance());
  }
}
