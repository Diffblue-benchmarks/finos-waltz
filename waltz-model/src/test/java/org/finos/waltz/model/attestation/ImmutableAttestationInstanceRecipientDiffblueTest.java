package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceRecipientDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#attestationInstance(AttestationInstance)}
   */
  @Test
  void testBuilderAttestationInstance() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationInstance(new ImmutableAttestationInstance.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#attestationInstance(AttestationInstance)}
   */
  @Test
  void testBuilderAttestationInstance2() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Json attestationInstance = new ImmutableAttestationInstance.Json();
    attestationInstance.setParentEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.attestationInstance(attestationInstance));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAttestationInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAttestationInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    ImmutableAttestationInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    ImmutableAttestationInstanceRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertSame(json, buildResult.attestationInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.attestationInstance()).thenReturn(new ImmutableAttestationInstance.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    ImmutableAttestationInstanceRecipient.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    ImmutableAttestationInstanceRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertSame(json, buildResult.attestationInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient#copyOf(AttestationInstanceRecipient)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    ImmutableAttestationInstanceRecipient actualCopyOfResult = ImmutableAttestationInstanceRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertSame(json, actualCopyOfResult.attestationInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient#copyOf(AttestationInstanceRecipient)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    ImmutableAttestationInstanceRecipient actualCopyOfResult = ImmutableAttestationInstanceRecipient.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertSame(json, actualCopyOfResult.attestationInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient#fromJson(ImmutableAttestationInstanceRecipient.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestationInstanceRecipient.Json json = new ImmutableAttestationInstanceRecipient.Json();
    json.setId(null);
    ImmutableAttestationInstance.Json attestationInstance = new ImmutableAttestationInstance.Json();
    json.setAttestationInstance(attestationInstance);
    json.setUserId("Json");

    // Act
    ImmutableAttestationInstanceRecipient actualFromJsonResult = ImmutableAttestationInstanceRecipient.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertSame(attestationInstance, actualFromJsonResult.attestationInstance());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Json#attestationInstance()}
   */
  @Test
  void testJsonAttestationInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationInstanceRecipient.Json()).attestationInstance());
  }

  /**
   * Method under test: {@link ImmutableAttestationInstanceRecipient.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationInstanceRecipient.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationInstanceRecipient.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationInstanceRecipient.Json actualJson = new ImmutableAttestationInstanceRecipient.Json();

    // Assert
    assertNull(actualJson.userId);
    assertNull(actualJson.attestationInstance);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationInstanceRecipient.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationInstanceRecipient.Json()).userId());
  }
}
